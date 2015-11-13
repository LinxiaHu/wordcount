package com.hd.grammer.t1;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

//缓存系统模拟
public class LockTest {
	/**
	 * @param args
	 */
	private Map<String, Object> cache = new HashMap<String, Object>();

	public static void main(String[] args) {

	}

	private ReadWriteLock rwl = new ReentrantReadWriteLock();// reentrant:adj.
																// 可重入的

	public Object getData(String key) {
		rwl.readLock().lock();// 准备读操作
		Object value = null;
		try {
			value = cache.get(key);// 读数据
			if (value == null) {// 如果是空，则要写数据
				rwl.readLock().unlock();
				rwl.writeLock().lock();// 如果有多个写线程，则最前面的获得写锁
				try {
					if (value == null) {// 再次判断是为了防止多个线程中某个已经完成写，那么其他线程就不必再写了
						value = "DATA";// 实际是从数据库中取
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
