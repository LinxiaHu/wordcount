package com.hd.stra;

import java.util.Map;
import java.util.Queue;

public class Worker implements Runnable {
	//任务队列，用于取得子任务
	protected Queue<Object> workQueue;
	//子任务处理结果
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
	
	//子任务处理逻辑，在子类中需要重写
	public Object handle(Object input){
		return input;
	}
	
	@Override
	public void run() {
		while(true){
			Object input = workQueue.poll();
			//当workQueue空的时候该线程停止
			if(null == input) break;
			//处理子任务
			Object re = handle(input);
			//将结果写入结果队列
			resultMap.put(Integer.toString(input.hashCode()), re);
		}
	}

}
