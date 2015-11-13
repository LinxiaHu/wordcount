package com.hd.algorithms;

import java.util.BitSet;

/**
 * @author Chunyun
 * 异形数长度为n的数组里面，除了几个数字，其他都出现2次，
 * 写出程序找出只出现一次的数，例如 1 3 7 9 5 5 9 4 3 17 1 7 输出 4/17
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
			if(bs.get(arr[i])){//如果第二次出现，则将其置为false
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
