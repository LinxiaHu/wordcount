package com.hd.grammer.t1;

public class TypeTest {
	
	public int add(int a,int b){   
        try {
            return a+b;      
        } 
       catch (Exception e) {  
           System.out.println("catch����");
        }
        finally{ 
            System.out.println("finally����");
        }
        return 0;
   } 
	
	public static void main(String[] args) {
		
		TypeTest test =new TypeTest(); 
        System.out.println("���ǣ�"+test.add(9, 34)); 
        
		byte b1 = 1, b2 = 2, b3, b6;
		final byte b4 = 4, b5 = 6; // final���͵Ļᱻjvm�Ż������������൱��b6 = 10;
		b6 = b4 + b5;
		// b3=b1+b2; //���ʽ����ת��ʧ�ܣ�b1+b2�Ѿ���int���ͣ��޷�����ת��Ϊbyte
		// System.out.println(b3+b6);
	}
}
