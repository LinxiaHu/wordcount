package com.hd.algorithms;

import java.util.ArrayList;

/**
 * @author Chunyun
 * 打印n个括号的所有合法组合
 * 如n==3:
 * (()())  ((()))  ()(())  (())()  ()()()
 */
public class Brackets {//条件：只要左括号没有用完就可以插入；只要右括号没有多于左括号就可以插入
	
	public static void addParen(ArrayList<String> list, int leftRem, int rightRem, char[] str, int count){
		if(leftRem < 0 || rightRem < leftRem) return;//不符合上述条件就终止
		if(leftRem == 0 && rightRem == 0){//如果括号用完了就表示完成了一种情况，加入列表
			String s = String.copyValueOf(str);
			list.add(s);
		}else {//注意以下2个if语句的顺序，顺序不同输出括号的顺序也不同，若if(rightRem > leftRem)先，则优先匹配右括号，反之优先匹配左括号
			if(rightRem > leftRem){//如果右括号符合规则，就可以添加一个右括号
				str[count] = ')';//由于这里的count可以覆盖上面if语句中的count，所以不会有重复，进入这个if是决定覆盖上一个括号
				addParen(list, leftRem, rightRem - 1, str, count + 1);
			}
			if(leftRem > 0){//如果还有左括号，就可以添加一个左括号
				str[count] = '(';
				addParen(list, leftRem - 1, rightRem, str, count + 1);//注意这里count本身没被改变，递归是决定下一个位置放哪个括号
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
		System.out.println("共有" + list.size() + "种情况：");
		for(String l : list){
			System.out.println(l);
		}
		System.out.println("以上是所以的" + list.size() + "种情况");
	}
}
