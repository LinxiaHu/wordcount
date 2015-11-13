package com.hd.algorithms;

/**
 * @author Chunyun
 * 将n*n的二维数组逆时针旋转45°，并打印
 * 1 2 3           3
 * 4 5 6 --> 1            9
 * 7 8 9
 *                 7
 */                  
public class Rotate45 {
	
	public static void printRotate45(int mat[][], int n){
		for(int i = n - 1; i >= 0; i--){//打印上半部分,若n==3，则上半部分打印3行，即i=0-->n-1，i用于控制新的行数
			int f = 0;
			int s = i;
			while(s < n){//s用于控制旋转后新行的元素个数
				System.out.print(mat[f++][s++] + " ");
			}
			System.out.println();
		}
		
		
	    for (int i = 1; i < n; i++) {//打印下半部分，若n==3,则下半部分打印2行,即i=1-->n-1
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
		System.out.println("原矩阵是:");
		for(int i = 0; i < n; i++){
			for(int j = 0; j < n; j++){
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
		
		System.out.println("转换后矩阵是:");
		Rotate45.printRotate45(matrix, n);
	}
}
