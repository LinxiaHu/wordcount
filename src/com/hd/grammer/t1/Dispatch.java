package com.hd.grammer.t1;

/**
 * @author Chunyun 用于测试单分派与多分派 静态分派与动态分派
 */
public class Dispatch {
	static class QQ {
	}

	static class _360 {
	}

	public static class Father {
		public void hardChoice(QQ arg) {
			System.out.println("father choose qq");
		}

		public void hardChoice(_360 arg) {
			System.out.println("father choose 360");
		}
	}

	

	public static class Son extends Father {
		public void hardChoice(QQ arg) {
			System.out.println("son choose qq");
		}

		public void hardChoice(_360 arg) {
			System.out.println("son choose 360");
		}
	}
	// 静态分派：一是选择静态类型是Father还是Son,
	//二是方法参数是QQ还是360，产生2条invokevirtual,
	//分别指向常量池中Father.hardChoice(_360)和Father.hardChoice(QQ)的符号引用
	//因为是个根据2个宗量进行选择，所以Java的静态分派属于多分派类型
	
	//动态分派：在执行son.hardChioce(new QQ())时，
	//更确切地是在执行invokevirtual时，由于编译期已经决定目标
	//方法的签名必须是hardChoice(QQ),虚拟机不会关心参数是腾讯QQ还是奇瑞QQ，
	//因为这是静态类型和实际类型都不会构成影响，唯一可以影响虚拟机选择的因素只有
	//此方法的接受者的实际类型是Father还是Son，只有一个宗量，所以Java动态分派是
	//单分派
	public static void main(String[] args) {
		Father father = new Father();
		Father son = new Son();
		father.hardChoice(new _360());
		son.hardChoice(new QQ());
	}
}
