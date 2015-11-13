package com.hd.algorithms;

/**
 * @author Chunyun
 * ��n*n�Ķ�ά������ʱ����ת45�㣬����ӡ
 * 1 2 3           3
 * 4 5 6 --> 1            9
 * 7 8 9
 *                 7
 */                  
public class Rotate45 {
	
	public static void printRotate45(int mat[][], int n){
		for(int i = n - 1; i >= 0; i--){//��ӡ�ϰ벿��,��n==3�����ϰ벿�ִ�ӡ3�У���i=0-->n-1��i���ڿ����µ�����
			int f = 0;
			int s = i;
			while(s < n){//s���ڿ�����ת�����е�Ԫ�ظ���
				System.out.print(mat[f++][s++] + " ");
			}
			System.out.println();
		}
		
		
	    for (int i = 1; i < n; i++) {//��ӡ�°벿�֣���n==3,���°벿�ִ�ӡ2��,��i=1-->n-1
			int f = i;
			int s = 0;
			while(f < n){
				System.out.print(mat[f++][s++] + " ");
			}
			System.out.println();
		}
	}
	
	public static void main(String[] args) {
		int n = 3;
		int[][] matrix;
		matrix = new int[3][];
		matrix[0] = new int[3];
		matrix[1] = new int[3];
		matrix[2] = new int[3];
		for(int i = 0; i < n; i++){
			for(int j = 0; j < n; j++){
				matrix[i][j] = i + j;
			}
		}
		System.out.println("ԭ������:");
		for(int i = 0; i < n; i++){
			for(int j = 0; j < n; j++){
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
		
		System.out.println("ת���������:");
		Rotate45.printRotate45(matrix, n);
	}
}
