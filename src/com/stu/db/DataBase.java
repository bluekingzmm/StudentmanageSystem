package com.stu.db;

import java.util.ArrayList;

import com.stu.dto.Student;

public class DataBase {

	private static ArrayList<Student> sList=new ArrayList<Student>();

	public static ArrayList<Student> getsList() {
		return sList;
	}

	public static void setsList(ArrayList<Student> sList) {
		DataBase.sList = sList;
	}

	

	
	
}
