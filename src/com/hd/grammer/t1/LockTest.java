package com.hd.grammer.t1;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

//����ϵͳģ��
public class LockTest {
	/**
	 * @param args
	 */
	private Map<String, Object> cache = new HashMap<String, Object>();

	public static void main(String[] args) {

	}

	private ReadWriteLock rwl = new ReentrantReadWriteLock();// reentrant:adj.
																// �������

	public Object getData(String key) {
		rwl.readLock().lock();// ׼��������
		Object value = null;
		try {
			value = cache.get(key);// ������
			if (value == null) {// ����ǿգ���Ҫд����
				rwl.readLock().unlock();
				rwl.writeLock().lock();// ����ж��д�̣߳�����ǰ��Ļ��д��
				try {
					if (value == null) {// �ٴ��ж���Ϊ�˷�ֹ����߳���ĳ���Ѿ����д����ô�����߳̾Ͳ�����д��
						value = "DATA";// ʵ���Ǵ����ݿ���ȡ
					}

				} catch (Exception e) {
					// TODO: handle exception
				} finally {
					rwl.writeLock().unlock();
					rwl.readLock().lock();
				}

			}
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			rwl.readLock().unlock();
		}
		return value;
	}

}
