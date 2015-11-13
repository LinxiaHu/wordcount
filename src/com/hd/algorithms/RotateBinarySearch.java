package com.hd.algorithms;

/**
 * @author Chunyun
 * �������������飬�������ɴ���ת�����������е�ĳ����
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
		
		//��ߺ��ұ߱���һ���������ĵ�������
		if(array[left] < array[middle]){//��벿��˳������
			if(x >= array[left] && x <= array[middle]){
				return search(array, left, middle, x);
			}else {
				return search(array, middle + 1, right, x);
			}	
		}else if (array[middle] < array[left]) {//�Ұ벿��˳������
			if(x >= array[middle] && x <= array[right]){
				return search(array, middle + 1, right, x);
			}else {
				return search(array, left, middle - 1, x);
			}
		}else if (array[left] == array[middle]) {//��벿�ֶ����
			if (array[middle] != array[right]) {//����Ұ벿�ֲ���ȣ��������Ұ벿��
				return search(array, middle + 1, right, x);
			}else {//�������߶�������
				int result = search(array, left, middle - 1, x);//������벿��
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
