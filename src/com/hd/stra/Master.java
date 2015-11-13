package com.hd.stra;

import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;


/**
 * @author Chunyun
 * Master-Worker���̼߳�����
 */
public class Master {
	//�������,����Ҫʹ�ò�����
	protected Queue<Object> workQueue = new ConcurrentLinkedQueue<Object>();
	//���̶���,����Ҫʹ�ò�����
	protected Map<String, Thread> threadMap = new ConcurrentHashMap<String, Thread>();
	//�������,����Ҫʹ�ò�����
	protected Map<String, Object> resultMap = new ConcurrentHashMap<String, Object>();
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
	 * @return the threadMap
	 */
	public Map<String, Thread> getThreadMap() {
		return threadMap;
	}
	/**
	 * @param threadMap the threadMap to set
	 */
	public void setThreadMap(Map<String, Thread> threadMap) {
		this.threadMap = threadMap;
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
	
	//�ж��Ƿ����е������񶼽���
	public boolean isComplete(){
		for(Map.Entry<String, Thread> entry : threadMap.entrySet()){
			if(entry.getValue().getState() != Thread.State.TERMINATED){
				return false;
			}
		}
		return true;
	}
	
	//���캯��������worker�̺߳������������̵߳�workQueue��resultMap�ǹ����
	public Master(Worker worker, int countWork){
		worker.setWorkQueue(workQueue);
		worker.setResultMap(resultMap);
		for(int i = 0; i < countWork; i++){
			threadMap.put(Integer.toString(i), new Thread(worker, Integer.toString(i)));
		}
	}
	
	//�ύһ������
	public void submit(Object job){
		workQueue.add(job);
	}
	
	//��ʼ��������worker���̣����д���
	public void execute(){
		for(Map.Entry<String, Thread> entry : threadMap.entrySet()){
			entry.getValue().start();
		}
	}
}
