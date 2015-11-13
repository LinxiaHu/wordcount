package com.hd.grammer.t1;

public class TypeTest {
	
	public int add(int a,int b){   
        try {
            return a+b;      
        } 
       catch (Exception e) {  
           System.out.println("catch语句块");
        }
        finally{ 
            System.out.println("finally语句块");
        }
        return 0;
   } 
	
	public static void main(String[] args) {
		
		TypeTest test =new TypeTest(); 
        System.out.println("和是："+test.add(9, 34)); 
        
		byte b1 = 1, b2 = 2, b3, b6;
		final byte b4 = 4, b5 = 6; // final类型的会被jvm优化，下面的语句相当于b6 = 10;
		b6 = b4 + b5;
		// b3=b1+b2; //表达式类型转换失败，b1+b2已经是int类型，无法向下转换为byte
		// System.out.println(b3+b6);
	}
}
