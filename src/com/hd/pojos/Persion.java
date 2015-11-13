package com.hd.pojos;

public class Persion {
	private Persion(){}
	//每个线程产生一个实例
	static ThreadLocal<Persion> map =  new ThreadLocal<Persion>();
	public static  Persion getThreadInstance(){
		Persion instance = map.get();
		if (instance == null) {
			instance = new Persion();
			map.set(instance);
		}
		return instance;
	}
	private String id;
	private String name;
	private int data;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getData() {
		return data;
	}
	public void setData(int data) {
		this.data = data;
	}																																		
}
