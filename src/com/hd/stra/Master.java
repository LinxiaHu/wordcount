package com.hd.stra;

import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;


/**
 * @author Chunyun
 * Master-Worker多线程计算框架
 */
public class Master {
	//任务队列,必须要使用并发包
	protected Queue<Object> workQueue = new ConcurrentLinkedQueue<Object>();
	//进程队列,必须要使用并发包
	protected Map<String, Thread> threadMap = new ConcurrentHashMap<String, Thread>();
	//结果队列,必须要使用并发包
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
	
	//判断是否所有的子任务都结束
	public boolean isComplete(){
		for(Map.Entry<String, Thread> entry : threadMap.entrySet()){
			if(entry.getValue().getState() != Thread.State.TERMINATED){
				return false;
			}
		}
		return true;
	}
	
	//构造函数，传入worker线程和他的数量，线程的workQueue和resultMap是共享的
	public Master(Worker worker, int countWork){
		worker.setWorkQueue(workQueue);
		worker.setResultMap(resultMap);
		for(int i = 0; i < countWork; i++){
			threadMap.put(Integer.toString(i), new Thread(worker, Integer.toString(i)));
		}
	}
	
	//提交一个任务
	public void submit(Object job){
		workQueue.add(job);
	}
	
	//开始运行所以worker进程，进行处理
	public void execute(){
		for(Map.Entry<String, Thread> entry : threadMap.entrySet()){
			entry.getValue().start();
		}
	}
}
