/**
 * 
 */
package com.stu.dto;

import java.util.Scanner;

/**
 * @author Administrator
 *
 */

public class Student {
	
	
	
	private String num;// ѧ��
	private String name;// ����
	private int age;// ����
	private String sex;// �Ա�
	private String nativeplace;// ����
	private String department;// ����ϵ��
	private String mobilephone;// ��ϵ�绰
	private String change;// ѧ���䶯���
	private String gradute;// �Ƿ��ҵ

	public String getNum() {
		return num;
	}

	public void setNum(String num) {
		this.num = num;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getNativeplace() {
		return nativeplace;
	}

	public void setNativeplace(String nativeplace) {
		this.nativeplace = nativeplace;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getMobilephone() {
		return mobilephone;
	}

	public void setMobilephone(String mobilephone) {
		this.mobilephone = mobilephone;
	}

	public String getChange() {
		return change;
	}

	public void setChange(String change) {
		this.change = change;
	}

	public String getGradute() {
		return gradute;
	}

	public void setGradute(String gradute) {
		this.gradute = gradute;

	}

	public Student() {
	}

	public Student(String num, String name, int age, String sex, String nativeplace, String mobilephone,
			String department, String change, String gradute) {
		// ����ʵ��������

		this.num = num;
		this.name = name;
		this.age = age;
		this.sex = sex;
		this.nativeplace = nativeplace;
		this.mobilephone = mobilephone;

		this.department = department;

		this.change = change;
		this.gradute = gradute;

	}

	@Override
	public String toString() {
		return this.num + "\t" + this.name + "\t" + this.age + "\t" + this.sex + "\t" + this.nativeplace + "\t"
				+ this.mobilephone+"\t"+this.department+this.change+"\t\t"+this.gradute;
	}

	public static void initDepartment() {
		
		
		
		System.out.println("1����ľϵ	2����Ϣϵ	3������ϵ	4����ýϵ	5����óϵ	6������ϵ");
	}

	

}
