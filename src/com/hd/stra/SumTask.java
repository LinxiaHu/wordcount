package com.hd.stra;

import java.util.Map;
import java.util.Set;

/**
 * @author Chunyun
 * Master-Worker的立方和计算任务
 */
public class SumTask {
	private static final int COUNT_JOB = 101;//计算规模
	public static void main(String[] args) {
		Master m = new Master(new SumCal(), 5);//使用5个固定线程处理计算任务
		for(int i = 0; i < COUNT_JOB; i++){
			m.submit(i);
		}
		m.execute();
		
		int re = 0;//最终结果
		Map<String, Object> resultMap = m.getResultMap();
		while(resultMap.size() > 0 | !m.isComplete()){
			Set<String> keys = resultMap.keySet();
			String key = null;
			for(String k : keys){
				key = k;
				break;//由于是多线程，而且取keySet时线程还没有全部结束，所以每次只许取一个结果
			}
			
			Integer i = null;
			if(key != null){
				i = (Integer) resultMap.get(key);
			}
			if(i != null){
				re += i;
			}
			if(key != null){
				resultMap.remove(key);//计算完了一个结果必须移除，防止重复计算
			}
		}
		
		System.out.println(re);
	}
	
	//任务线程
	public static class SumCal extends Worker{
		@Override
		public Object handle(Object input) {
			Integer i = (Integer) input;
			return i * i * i;
		}
		
	}
}
