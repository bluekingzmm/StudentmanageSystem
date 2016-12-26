package com.stu.impl;

import java.lang.reflect.Array;
import java.nio.channels.ShutdownChannelGroupException;
import java.util.ArrayList;
import java.util.Iterator;

import javax.xml.crypto.Data;

import com.stu.db.DataBase;
import com.stu.dto.Student;

public class Assist {

	public boolean addStu(Student s) {
		return DataBase.getsList().add(s);
	}

	public boolean deletStu(String num) throws Exception {
		Student stu = get(num);
		return DataBase.getsList().remove(stu);
	}

	/*
	 * 通过学号姓名查找学生
	 * 
	 */
	public ArrayList<Student> find(String keyname, int key) {
		ArrayList<Student> sList = new ArrayList<Student>();
		Iterator<Student> iterator = DataBase.getsList().iterator();
		while (iterator.hasNext()) {
			Student stu =  iterator.next();
			switch (key) {
			case 1:
				if (stu.getName().indexOf(keyname) == 0) {
				sList.add(stu);
				}
				break;
			case 2:

				if (stu.getNum().indexOf(keyname) == 0) {
					sList.add(stu);
				}

				break;

			default:
				System.out.println("异常错误！！");
				break;

			}

		}
		return sList;
	}

	public Student get(String num) throws Exception {
		int i;
		for (i = 0; i < DataBase.getsList().size(); i++) {
			if (num.compareTo(DataBase.getsList().get(i).getNum()) == 0) {
				return DataBase.getsList().get(i);

			}
		}

		return null;
	}

	public boolean modify(Student s) throws Exception {

		Student stu = get(s.getNum());
		ArrayList<Student> sList = new ArrayList<Student>();
		sList.remove(stu);
		return sList.add(stu);
	}

	
	public static void sort() {
		ArrayList<Student> sList =DataBase.getsList();
		Student stu=new Student();
	
		for (int i = 0; i < DataBase.getsList().size() - 1; i++) {
			for (int j = 0; j < sList.size() - i - 1; j++) {
				if (sList.get(j).getNum().compareTo(sList.get(j+1).getNum()) > 0) {
					 stu=(sList.get(j));
					sList.set(j, sList.get(j+1));
					sList.set(j+1, stu);
				}
			}
		}
	}

}
