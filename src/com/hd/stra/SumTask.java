package com.hd.stra;

import java.util.Map;
import java.util.Set;

/**
 * @author Chunyun
 * Master-Worker�������ͼ�������
 */
public class SumTask {
	private static final int COUNT_JOB = 101;//�����ģ
	public static void main(String[] args) {
		Master m = new Master(new SumCal(), 5);//ʹ��5���̶��̴߳����������
		for(int i = 0; i < COUNT_JOB; i++){
			m.submit(i);
		}
		m.execute();
		
		int re = 0;//���ս��
		Map<String, Object> resultMap = m.getResultMap();
		while(resultMap.size() > 0 | !m.isComplete()){
			Set<String> keys = resultMap.keySet();
			String key = null;
			for(String k : keys){
				key = k;
				break;//�����Ƕ��̣߳�����ȡkeySetʱ�̻߳�û��ȫ������������ÿ��ֻ��ȡһ�����
			}
			
			Integer i = null;
			if(key != null){
				i = (Integer) resultMap.get(key);
			}
			if(i != null){
				re += i;
			}
			if(key != null){
				resultMap.remove(key);//��������һ����������Ƴ�����ֹ�ظ�����
			}
		}
		
		System.out.println(re);
	}
	
	//�����߳�
	public static class SumCal extends Worker{
		@Override
		public Object handle(Object input) {
			Integer i = (Integer) input;
			return i * i * i;
		}
		
	}
}
