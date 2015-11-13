package com.hd.algorithms;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

/**
 * @author Chunyun
 * ����n=5��m=3��r={{1,2}��{2,3}��{4,5}}����ʾһ��5���ˣ�
 * 1��2�����ѣ�2��3������1��3ͨ��2��������ѡ���ô1,2,3����һ������Ȧ��
 * 4,5����һ������Ȧһ����������Ȧ,���Է���2
 */
public class FriendCircles {
	
	public static int countOfFriendCircles(Integer[][] sets){
		int count = 0;
		LinkedList<Set<Integer>> list = new LinkedList<Set<Integer>>();
		boolean flag = false;
		
		Set<Integer> init = new HashSet<Integer>();
		init.add(sets[0][0]);
		init.add(sets[0][1]);
		list.add(init);//�Ƚ���һ�м��뵽�б���
		
		for(int i = 1; i < sets.length; i++){
			
			Set<Integer> in = new HashSet<Integer>();
			for(int j = 0; j < list.size(); j++){
				in = list.get(j);
				if(in.contains(sets[i][0])){
					in.add(sets[i][1]);
					flag = true;
				}else if(in.contains(sets[i][1])){
					in.add(sets[i][0]);
					flag = true;
				}//����ȡ���б���ÿһ�����ϣ��ж��µ�һ���Ƿ�����ĳ�����ϣ����ǣ������������ϣ����˳����ѭ��
				if(flag){
					break;
				}
			}
			if(!flag){//��ĳ�в���������һ�����ϣ����½�һ�����ϣ��������б���
					Set<Integer> newMem = new HashSet<Integer>();
					newMem.add(sets[i][0]);
					newMem.add(sets[i][1]);
					list.add(newMem);
			}
			flag = false;
		}
		
		count = list.size();
		return count;
	}
	
	public static void main(String[] args) {
		Integer[][] data = new Integer[][]{{1,2},{2,3},{3,4},{7,8},{9,11},{13,17},{17,1}};
		System.out.println(countOfFriendCircles(data));
	}
}
