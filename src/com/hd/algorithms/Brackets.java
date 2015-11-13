package com.hd.algorithms;

import java.util.ArrayList;

/**
 * @author Chunyun
 * ��ӡn�����ŵ����кϷ����
 * ��n==3:
 * (()())  ((()))  ()(())  (())()  ()()()
 */
public class Brackets {//������ֻҪ������û������Ϳ��Բ��룻ֻҪ������û�ж��������žͿ��Բ���
	
	public static void addParen(ArrayList<String> list, int leftRem, int rightRem, char[] str, int count){
		if(leftRem < 0 || rightRem < leftRem) return;//������������������ֹ
		if(leftRem == 0 && rightRem == 0){//������������˾ͱ�ʾ�����һ������������б�
			String s = String.copyValueOf(str);
			list.add(s);
		}else {//ע������2��if����˳��˳��ͬ������ŵ�˳��Ҳ��ͬ����if(rightRem > leftRem)�ȣ�������ƥ�������ţ���֮����ƥ��������
			if(rightRem > leftRem){//��������ŷ��Ϲ��򣬾Ϳ������һ��������
				str[count] = ')';//���������count���Ը�������if����е�count�����Բ������ظ����������if�Ǿ���������һ������
				addParen(list, leftRem, rightRem - 1, str, count + 1);
			}
			if(leftRem > 0){//������������ţ��Ϳ������һ��������
				str[count] = '(';
				addParen(list, leftRem - 1, rightRem, str, count + 1);//ע������count����û���ı䣬�ݹ��Ǿ�����һ��λ�÷��ĸ�����
			}
		}
	}
	
	public static ArrayList<String> generateParens(int count){
		char[] str = new char[count * 2];
		ArrayList<String> list = new ArrayList<String>();
		addParen(list, count, count, str, 0);
		return list;
	}
	
	public static void main(String[] args) {
		ArrayList<String> list = Brackets.generateParens(3);
		System.out.println("����" + list.size() + "�������");
		for(String l : list){
			System.out.println(l);
		}
		System.out.println("���������Ե�" + list.size() + "�����");
	}
}
