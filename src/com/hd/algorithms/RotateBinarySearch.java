package com.hd.algorithms;

/**
 * @author Chunyun
 * 递增的整型数组，经过若干次旋转后，搜索数组中的某个数
 * 1,2,3,4 --> 3,4,1,2
 */
public class RotateBinarySearch {
	
	public static int search(int[] array, int left, int right, int x){
		
		int middle = (left + right) >> 1;
		if(array[middle] == x){
			return middle;
		}
		if(right < left){
			return -1;
		}
		
		//左边和右边必有一边是正常的递增序列
		if(array[left] < array[middle]){//左半部分顺序正常
			if(x >= array[left] && x <= array[middle]){
				return search(array, left, middle, x);
			}else {
				return search(array, middle + 1, right, x);
			}	
		}else if (array[middle] < array[left]) {//右半部分顺序正常
			if(x >= array[middle] && x <= array[right]){
				return search(array, middle + 1, right, x);
			}else {
				return search(array, left, middle - 1, x);
			}
		}else if (array[left] == array[middle]) {//左半部分都相等
			if (array[middle] != array[right]) {//如果右半部分不相等，则搜索右半部分
				return search(array, middle + 1, right, x);
			}else {//否则，两边都得搜索
				int result = search(array, left, middle - 1, x);//搜索左半部分
				if(result == -1){
					return search(array, middle + 1, right, x);
				}else {
					return result;
				}
			}
		} 
		return -1;
	}
	
	
	public static void main(String[] args) {
		int[] testArray = {4,5,6,7,8,9,11,1,2,3};
		System.out.println(search(testArray, 0, 9, 3));
	}
}
