package com.hd.stra;

import java.util.Map;
import java.util.Queue;

public class Worker implements Runnable {
	//������У�����ȡ��������
	protected Queue<Object> workQueue;
	//����������
	protected Map<String, Object> resultMap;
	
	/**
	 * @return the workQueue
	 */
	public Queue<Object> getWorkQueue() {
		return workQueue;
	}

	/**
	 * @param workQueue the workQueue to set
	 */
	public void setWorkQueue(Queue<Object> workQueue) {
		this.workQueue = workQueue;
	}

	/**
	 * @return the resultMap
	 */
	public Map<String, Object> getResultMap() {
		return resultMap;
	}

	/**
	 * @param resultMap the resultMap to set
	 */
	public void setResultMap(Map<String, Object> resultMap) {
		this.resultMap = resultMap;
	}
	
	//���������߼�������������Ҫ��д
	public Object handle(Object input){
		return input;
	}
	
	@Override
	public void run() {
		while(true){
			Object input = workQueue.poll();
			//��workQueue�յ�ʱ����߳�ֹͣ
			if(null == input) break;
			//����������
			Object re = handle(input);
			//�����д��������
			resultMap.put(Integer.toString(input.hashCode()), re);
		}
	}

}
