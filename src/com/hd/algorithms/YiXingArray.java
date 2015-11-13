package com.hd.algorithms;

import java.util.BitSet;

/**
 * @author Chunyun
 * ����������Ϊn���������棬���˼������֣�����������2�Σ�
 * д�������ҳ�ֻ����һ�ε��������� 1 3 7 9 5 5 9 4 3 17 1 7 ��� 4/17
 */
public class YiXingArray {
	
	public static String Pick(int[] arr){
		StringBuffer sb = new StringBuffer();
		BitSet bs = new BitSet();
		for(int i = 0; i < arr.length; i++){
			if(!bs.get(arr[i])){
				bs.set(arr[i]);
				continue;
			}
			if(bs.get(arr[i])){//����ڶ��γ��֣�������Ϊfalse
				bs.clear(arr[i]);
			}
		}
		for(int i = 0; i < arr.length; i++){
			if(bs.get(arr[i])){
				sb.append(arr[i]).append("/");
			}
		}
		sb.replace(sb.length() - 1, sb.length(), "");
		return sb.toString();
	}
	
	public static void main(String[] args) {
		int[] data = new int[] {1, 3, 7, 9, 5, 5, 9, 4, 3, 17, 1, 7 };
		System.out.println(Pick(data));
	}
}
