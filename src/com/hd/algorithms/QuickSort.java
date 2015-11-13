package com.hd.algorithms;

/**
 * @author Chunyun
 * 快速排序
 */
public class QuickSort {
	
	private int partition(int[] a, int low, int high){//按左小右大排序
		int l = low; //必须记录low和high，在这个函数中不能被改变
		int r = high;
		int pivot = a[l];
		while(l < r){
			while(l < r && a[r] >= pivot) r--;
			if(l < r){
				a[l++] = a[r];
			}
			while(l < r && a[l] <= pivot) l++;
			if(l < r){
				a[r--] = a[l];
			}
		}
		a[l] = pivot;
		return l;
	}
	
	public void quickSort(int[] a, int low, int high){
		int index;
		if(low < high){//必须判断终止条件
			index = this.partition(a, low, high);
			quickSort(a, low, index - 1);
			quickSort(a, index + 1, high);
		}
	}
	
	
	
	public static void main(String[] args) {
		QuickSort qs = new QuickSort();
		int[] testData = {33,7,9,32,-101,-1,47,-12,99};
		for(int i = 0; i < testData.length; i++){
			System.out.print(testData[i] + " ");
		}
		System.out.println();
//		int index = qs.Partition(testData, 0, testData.length - 1);
//		System.out.println(index);
		qs.quickSort(testData, 0, testData.length - 1);
		for(int i = 0; i < testData.length; i++){
			System.out.print(testData[i] + " ");
		}
	}
}
