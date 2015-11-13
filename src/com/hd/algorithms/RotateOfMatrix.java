package com.hd.algorithms;

/**
 * @author Chunyun
 * N*N���������һ��ͼ��ÿ������4���ֽڣ����䰴˳ʱ����ת90�ȣ���ʹ�ø����ڴ�
 * @@@@
 * @@@@    ������Ȧ���ɵ�һ��ѭ���������������ƽ�����Ҫ��N/2Ȧ�����ƶ�
 * @@@@
 * @@@@
 * 
 */
public class RotateOfMatrix {
	public static void rotate(int[][] mat, int n){
		for(int layer = 0; layer < n / 2; layer++){
			int first = layer;//ÿһȦ��ʼ���±�
			int last = n - 1 - layer;//ÿһȦ�������±�
			for(int i = first; i < last; i++){
				int offset = i - first;//һȦ�ڵ�ǰ�ƶ����±����Ȧ��ʼ���±����
				int topTmp = mat[first][i];//�ȴ洢��Ȧ�����Ԫ��
				//����Ȧ��ߵ��ƶ�������
				mat[first][i] = mat[last - offset][first];
				//����Ȧ�±ߵ��ƶ������
				mat[last - offset][first] = mat[last][last - offset];
				//����Ȧ�ұߵ��ƶ����±�
				mat[last][last - offset] = mat[i][last];
				//����Ȧ�ϱߵ��ƶ����ұ�
				mat[i][last] = topTmp;
			}
		}
	}
}
