package com.surveypark.model;

/**
 * 数据统计
 */
public class Data {

	private int count; //选择次数
	
	private String name; //名称

	private String other; //其他
	
	
	public Data(String name,int count ) {
		this.count = count;
		this.name = name;
	}

	
	
	public Data(int count, String name, String other) {
		this.count = count;
		this.name = name;
		this.other = other;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getOther() {
		return other;
	}

	public void setOther(String other) {
		this.other = other;
	}
}
