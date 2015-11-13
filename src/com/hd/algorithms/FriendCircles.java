package com.hd.algorithms;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

/**
 * @author Chunyun
 * 假如n=5，m=3，r={{1,2}，{2,3}，{4,5}}，表示一共5个人，
 * 1和2是朋友，2和3是朋友1和3通过2间接是朋友。那么1,2,3属于一个朋友圈，
 * 4,5属于一个朋友圈一共两个朋友圈,所以返回2
 */
public class FriendCircles {
	
	public static int countOfFriendCircles(Integer[][] sets){
		int count = 0;
		LinkedList<Set<Integer>> list = new LinkedList<Set<Integer>>();
		boolean flag = false;
		
		Set<Integer> init = new HashSet<Integer>();
		init.add(sets[0][0]);
		init.add(sets[0][1]);
		list.add(init);//先将第一行加入到列表中
		
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
				}//依次取出列表中每一个集合，判断新的一行是否属于某个集合，若是，则加入这个集合，并退出这层循环
				if(flag){
					break;
				}
			}
			if(!flag){//若某行不属于任意一个集合，则新建一个集合，并加入列表中
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
