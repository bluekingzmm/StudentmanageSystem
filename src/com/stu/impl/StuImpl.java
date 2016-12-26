package com.stu.impl;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.SynchronousQueue;

import javax.xml.crypto.Data;

import org.omg.CORBA.DATA_CONVERSION;

import com.stu.db.DataBase;
import com.stu.dto.Student;

public class StuImpl {

	static Scanner sc = new Scanner(System.in);

	static Assist ai = new Assist();

	/*
	 * 添加学生在数据库中
	 */

	public static void dispmenu() {

		try {
			init();
			while (true) {
				mainmenu();

				int choice = sc.nextInt();
				switch (choice) {
				case 1:
					System.out.println("*     1.录入学生学籍信息                     *");
					addStu();
					break;
				case 2:
					System.out.println("*     2.显示学生学籍信息                     *");

					Infomation();

					break;
				case 3:
					System.out.println("*     3.查询学生学籍信息      *");

					find();
					break;

				case 4:
					System.out.println("*     4.修改学生学籍信息                     *");
					modify();
					break;
				case 5:
					System.out.println("*     5.删除学生学籍信息                     *");
					deletStu();
					break;
				case 6:
					System.out.println("*     6.按学号给学籍信息排序           *");
					sort();
					break;
				case 0:
					System.out.println("*     0.退出学生学籍信息                     *");
					System.exit(0);
				default:
					System.out.println("输入有误！！！");
				}
			}

		} catch (Exception e) {
			System.out.println(e.toString());
			// TODO: handle exception
		}
	}

	/*
	 * 初始化
	 */
	public static void init() {
		Student s1 = new Student("111", "张明明", 18, "男士", "安徽省阜阳", "\t18885236271", "信息系", "\t无变动", "否");
		Student s2 = new Student("115", "杨昌", 19, "男士", "广东省东莞市", "16665236271", "汽车系", "\t转专业", "否");
		Student s3 = new Student("112", "李磊", 18, "男士", "安徽省宿州市", "18825234271", "信息系", "\t转专业", "否");
		Student s4 = new Student("113", "赵盼", 18, "女士", "安徽省滁州", "\t18845234271", "传媒系", "\t无变动", "否");
		Student s5 = new Student("114", "张花季", 22, "女士", "安徽省阜阳", "\t18815231271", "经贸系", "\t转专业", "否");
		Student s6 = new Student("116", "李弘基", 19, "男士", "安徽省芜湖市", "18385232271", "信息系", "\t无变动", "否");
		Student s7 = new Student("110", "胡心门", 19, "男士", "安徽省合肥市", "16885233271", "土木系", "\t无变动", "否");
		DataBase.getsList().add(s1);
		DataBase.getsList().add(s2);
		DataBase.getsList().add(s3);
		DataBase.getsList().add(s4);
		DataBase.getsList().add(s5);
		DataBase.getsList().add(s6);
		DataBase.getsList().add(s7);
	}

	public static void mainmenu() {
		Info();
		System.out.println("");
		System.out.println(
				"*                  1.录入学生学籍信息                                                                                    *");
		System.out.println(
				"*                  2.显示学生学籍信息                                                                                    *");
		System.out.println(
				"*                  3.查询学生学籍信息                                                                          *");
		System.out.println(
				"*                  4.修改学生学籍信息                                                                                      *");
		System.out.println(
				"*                  5.删除学生学籍信息                                                                                      *");
		System.out.println(
				"*                  6.按学号给学籍信息排序                                                                                *");
		System.out.println(
				"*                  0.退出学生学籍信息                                                                                       *");
		Info();
		System.out.println("\n请输入你要选择的序号，然后按回车:");
	}

	public static void Infomation() {

		System.out
				.print("**************************************学生学籍信息表*********************************************\n");
		System.out.println("学号\t名字\t年龄\t性别\t籍贯\t\t联系电话\t\t所在系部\t学籍变动情况\t是否毕业");
		for (int i = 0; i < DataBase.getsList().size(); i++) {
			System.out.println(DataBase.getsList().get(i));
			System.out.print(
					"______________________________________________________________________________________________\n");

		}
	}

	public static void Info() {

		for (int i = 0; i < 53; i++) {
			if (i == 23) {
				System.out.print("欢迎使用学生管理系统!");
			}
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.print("*");
		}
	}

	public static void addStu() {
		String yes = "y";
		try {
			while (!yes.equalsIgnoreCase("n")) {
				Student student = new Student();
				System.out.println("请输入学号");
				student.setNum(sc.next());
				System.out.println("请输入姓名");
				student.setName(sc.next());
				System.out.println("请输入年龄");
				student.setAge(sc.nextInt());
				System.out.println("请输入性别：");

				while (true) {
					String sex = sc.next();
					if (sex.equals("男") || sex.equals("女")) {
						student.setSex(sex);
						break;
					} else {
						System.out.println("请输入男或者女");

					}
				}
				System.out.println("请输入籍贯：");
				student.setNativeplace(sc.next());
				System.out.println("请输入联系电话");
				while (true) {
					String mobilephone = sc.next();
					if (mobilephone.startsWith("1") && mobilephone.length() == 11) {
						student.setMobilephone(mobilephone);
						break;
					} else {
						System.out.println("请输入11位数的号码并且第一位是1");
					}

				}
				Student.initDepartment();
				System.out.println("请输入所在系部，只能选择系统给出的");
				student.setDepartment(sc.next());
				System.out.println("请输入学籍变动情况");
				student.setChange(sc.next());
				System.out.println("请输入是否毕业");
				student.setGradute(sc.next());
				if (ai.addStu(student)) {
					System.out.println("添加成功");
				} else {
					System.out.println("添加失败！！");
				}
				System.out.println("输入n或者N停止添加，任意键继续");
				yes = sc.next();

			}

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("录入信息不正常，可能输入有误！！");
		}
	}

	public static void deletStu() {
		String yes = "y", num;

		try {
			while (!yes.equalsIgnoreCase("n")) {
				System.out.println("请输入你要删除的学号");
				num = sc.next();
				if (ai.deletStu(num)) {
					System.out.println("删除成功");

				} else {
					System.out.println("删除失败，请确认好学号！！");
				}
				System.out.println("输入n或者N停止删除，任意键继续删除");
				yes = sc.next();

			}

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("录入信息不正常，可能输入有误！！");
		}

	}

	public static void  find() {

		String yes = "y";
		try {
			while (!yes.equalsIgnoreCase("n")) {
				System.out.println("请选择查询方式  1：按姓名查询  2：按学号查询");
				int key = sc.nextInt();
				System.out.println("请输入关键字");
				String keyname = sc.next();
				ArrayList<Student> sList = ai.find(keyname, key);
				for (int i = 0; i < sList.size(); i++) {
					Student stu = sList.get(i);
					System.out.println("一共有" + sList.size() + "个学生");
					showone(stu);
				}
				System.out.println("是否继续查找，输入n或者N则停止查找，任意键继续");
				yes = sc.next();
			}

		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}

	public static void showone(Student stu) {
		System.out.println(
				"@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
		System.out.println("学号\t名字\t年龄\t性别\t籍贯\t\t联系电话\t\t所在系部\t学籍变动情况\t是否毕业");
		System.out.println(stu.toString());

	}

	public static void modify() {
		String yes = "y", num;
		try {
			while (!yes.equalsIgnoreCase("n")) {
				System.out.println("请输入你要修改的学生学号");
				num = sc.next();
				Student stu = ai.get(num);
				showone(stu);
				modifyInfo();
				int key = sc.nextInt();
				switch (key) {
				case 1:
					System.out.println("                                    1:请修改学号");
					stu.setNum(sc.next());
					break;
				case 2:
					System.out.println("                                    2:请修改姓名");
					stu.setName(sc.next());
					break;
				case 3:
					System.out.println("                                    3:请修改年龄");
					stu.setAge(sc.nextInt());
					break;
				case 4:
					System.out.println("                                    4:请修改性别");
					stu.setSex(sc.next());
					break;
				case 5:
					System.out.println("                                    5:请修改籍贯");
					stu.setNativeplace(sc.next());
					break;
				case 6:
					System.out.println("                                    6:请修改联系电话");

					stu.setMobilephone(sc.next());
					break;
				case 7:
					System.out.println("                                    7:请修改所在系部");
					stu.setDepartment(sc.next());
					break;
				case 8:
					System.out.println("                                    8:请修改学籍变动情况");
					stu.setChange(sc.next());
					break;
				case 9:
					System.out.println("                                    9:请修改是否毕业");
					stu.setGradute(sc.next());
					break;
				case 0:
					System.out.println("                                    0:退出修改");
					System.exit(0);
					break;
				default:
					break;
				}
				if (ai.modify(stu)) {
					System.out.println("修改成功");
				} else {
					System.out.println("修改失败！！");
				}
				System.out.println("任意键继续修改，输入n或者N退出修改！！！");
				yes = sc.next();
				showone(stu);
			}

		} catch (Exception e) {
			// TODO: handle exception
		}

	}

	public static void modifyInfo() {
		System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&");
		System.out.println("                                    1:请修改学号");
		System.out.println("                                    2:请修改姓名");
		System.out.println("                                    3:请修改年龄");
		System.out.println("                                    4:请修改性别");
		System.out.println("                                    5:请修改籍贯");
		System.out.println("                                    6:请修改联系电话");
		System.out.println("                                    7:请修改所在系部");
		System.out.println("                                    8:请修改学籍变动情况");
		System.out.println("                                    9:请修改是否毕业");
		System.out.println("                                    0:退出修改");
		System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&");
		System.out.println("\n   请输入你要修改的序号：   ");

	}

	public static  void sort() {

		System.out.print("@@@@@@@@@@@@@@@重新排序后的学生学籍表@@@@@@@@@@@@@@\n");
		ai.sort();
		Infomation();
		System.out.print("@@@@@@@@@@@@@@@重新排序后的学生学籍表@@@@@@@@@@@@@@\n");

	}

	

}
