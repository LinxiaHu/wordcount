package com.hd.algorithms;

/**
 * @author Chunyun
 * N*N的像素组成一幅图像，每个像素4个字节，将其按顺时针旋转90度，不使用辅助内存
 * @@@@
 * @@@@    将最外圈看成第一个循环，紧接着向内推进，共要对N/2圈进行移动
 * @@@@
 * @@@@
 * 
 */
public class RotateOfMatrix {
	public static void rotate(int[][] mat, int n){
		for(int layer = 0; layer < n / 2; layer++){
			int first = layer;//每一圈开始的下标
			int last = n - 1 - layer;//每一圈结束的下标
			for(int i = first; i < last; i++){
				int offset = i - first;//一圈内当前移动的下标与该圈开始的下标距离
				int topTmp = mat[first][i];//先存储该圈顶层的元素
				//将该圈左边的移动到顶层
				mat[first][i] = mat[last - offset][first];
				//将该圈下边的移动到左边
				mat[last - offset][first] = mat[last][last - offset];
				//将该圈右边的移动到下边
				mat[last][last - offset] = mat[i][last];
				//将该圈上边的移动到右边
				mat[i][last] = topTmp;
			}
		}
	}
}
