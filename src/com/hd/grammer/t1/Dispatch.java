package com.hd.grammer.t1;

/**
 * @author Chunyun ���ڲ��Ե����������� ��̬�����붯̬����
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
	// ��̬���ɣ�һ��ѡ��̬������Father����Son,
	//���Ƿ���������QQ����360������2��invokevirtual,
	//�ֱ�ָ��������Father.hardChoice(_360)��Father.hardChoice(QQ)�ķ�������
	//��Ϊ�Ǹ�����2����������ѡ������Java�ľ�̬�������ڶ��������
	
	//��̬���ɣ���ִ��son.hardChioce(new QQ())ʱ��
	//��ȷ�е�����ִ��invokevirtualʱ�����ڱ������Ѿ�����Ŀ��
	//������ǩ��������hardChoice(QQ),�����������Ĳ�������ѶQQ��������QQ��
	//��Ϊ���Ǿ�̬���ͺ�ʵ�����Ͷ����ṹ��Ӱ�죬Ψһ����Ӱ�������ѡ�������ֻ��
	//�˷����Ľ����ߵ�ʵ��������Father����Son��ֻ��һ������������Java��̬������
	//������
	public static void main(String[] args) {
		Father father = new Father();
		Father son = new Son();
		father.hardChoice(new _360());
		son.hardChoice(new QQ());
	}
}
