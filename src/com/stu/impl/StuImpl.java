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
	 * ���ѧ�������ݿ���
	 */

	public static void dispmenu() {

		try {
			init();
			while (true) {
				mainmenu();

				int choice = sc.nextInt();
				switch (choice) {
				case 1:
					System.out.println("*     1.¼��ѧ��ѧ����Ϣ                     *");
					addStu();
					break;
				case 2:
					System.out.println("*     2.��ʾѧ��ѧ����Ϣ                     *");

					Infomation();

					break;
				case 3:
					System.out.println("*     3.��ѯѧ��ѧ����Ϣ      *");

					find();
					break;

				case 4:
					System.out.println("*     4.�޸�ѧ��ѧ����Ϣ                     *");
					modify();
					break;
				case 5:
					System.out.println("*     5.ɾ��ѧ��ѧ����Ϣ                     *");
					deletStu();
					break;
				case 6:
					System.out.println("*     6.��ѧ�Ÿ�ѧ����Ϣ����           *");
					sort();
					break;
				case 0:
					System.out.println("*     0.�˳�ѧ��ѧ����Ϣ                     *");
					System.exit(0);
				default:
					System.out.println("�������󣡣���");
				}
			}

		} catch (Exception e) {
			System.out.println(e.toString());
			// TODO: handle exception
		}
	}

	/*
	 * ��ʼ��
	 */
	public static void init() {
		Student s1 = new Student("111", "������", 18, "��ʿ", "����ʡ����", "\t18885236271", "��Ϣϵ", "\t�ޱ䶯", "��");
		Student s2 = new Student("115", "���", 19, "��ʿ", "�㶫ʡ��ݸ��", "16665236271", "����ϵ", "\tתרҵ", "��");
		Student s3 = new Student("112", "����", 18, "��ʿ", "����ʡ������", "18825234271", "��Ϣϵ", "\tתרҵ", "��");
		Student s4 = new Student("113", "����", 18, "Ůʿ", "����ʡ����", "\t18845234271", "��ýϵ", "\t�ޱ䶯", "��");
		Student s5 = new Student("114", "�Ż���", 22, "Ůʿ", "����ʡ����", "\t18815231271", "��óϵ", "\tתרҵ", "��");
		Student s6 = new Student("116", "����", 19, "��ʿ", "����ʡ�ߺ���", "18385232271", "��Ϣϵ", "\t�ޱ䶯", "��");
		Student s7 = new Student("110", "������", 19, "��ʿ", "����ʡ�Ϸ���", "16885233271", "��ľϵ", "\t�ޱ䶯", "��");
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
				"*                  1.¼��ѧ��ѧ����Ϣ                                                                                    *");
		System.out.println(
				"*                  2.��ʾѧ��ѧ����Ϣ                                                                                    *");
		System.out.println(
				"*                  3.��ѯѧ��ѧ����Ϣ                                                                          *");
		System.out.println(
				"*                  4.�޸�ѧ��ѧ����Ϣ                                                                                      *");
		System.out.println(
				"*                  5.ɾ��ѧ��ѧ����Ϣ                                                                                      *");
		System.out.println(
				"*                  6.��ѧ�Ÿ�ѧ����Ϣ����                                                                                *");
		System.out.println(
				"*                  0.�˳�ѧ��ѧ����Ϣ                                                                                       *");
		Info();
		System.out.println("\n��������Ҫѡ�����ţ�Ȼ�󰴻س�:");
	}

	public static void Infomation() {

		System.out
				.print("**************************************ѧ��ѧ����Ϣ��*********************************************\n");
		System.out.println("ѧ��\t����\t����\t�Ա�\t����\t\t��ϵ�绰\t\t����ϵ��\tѧ���䶯���\t�Ƿ��ҵ");
		for (int i = 0; i < DataBase.getsList().size(); i++) {
			System.out.println(DataBase.getsList().get(i));
			System.out.print(
					"______________________________________________________________________________________________\n");

		}
	}

	public static void Info() {

		for (int i = 0; i < 53; i++) {
			if (i == 23) {
				System.out.print("��ӭʹ��ѧ������ϵͳ!");
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
				System.out.println("������ѧ��");
				student.setNum(sc.next());
				System.out.println("����������");
				student.setName(sc.next());
				System.out.println("����������");
				student.setAge(sc.nextInt());
				System.out.println("�������Ա�");

				while (true) {
					String sex = sc.next();
					if (sex.equals("��") || sex.equals("Ů")) {
						student.setSex(sex);
						break;
					} else {
						System.out.println("�������л���Ů");

					}
				}
				System.out.println("�����뼮�᣺");
				student.setNativeplace(sc.next());
				System.out.println("��������ϵ�绰");
				while (true) {
					String mobilephone = sc.next();
					if (mobilephone.startsWith("1") && mobilephone.length() == 11) {
						student.setMobilephone(mobilephone);
						break;
					} else {
						System.out.println("������11λ���ĺ��벢�ҵ�һλ��1");
					}

				}
				Student.initDepartment();
				System.out.println("����������ϵ����ֻ��ѡ��ϵͳ������");
				student.setDepartment(sc.next());
				System.out.println("������ѧ���䶯���");
				student.setChange(sc.next());
				System.out.println("�������Ƿ��ҵ");
				student.setGradute(sc.next());
				if (ai.addStu(student)) {
					System.out.println("��ӳɹ�");
				} else {
					System.out.println("���ʧ�ܣ���");
				}
				System.out.println("����n����Nֹͣ��ӣ����������");
				yes = sc.next();

			}

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("¼����Ϣ�������������������󣡣�");
		}
	}

	public static void deletStu() {
		String yes = "y", num;

		try {
			while (!yes.equalsIgnoreCase("n")) {
				System.out.println("��������Ҫɾ����ѧ��");
				num = sc.next();
				if (ai.deletStu(num)) {
					System.out.println("ɾ���ɹ�");

				} else {
					System.out.println("ɾ��ʧ�ܣ���ȷ�Ϻ�ѧ�ţ���");
				}
				System.out.println("����n����Nֹͣɾ�������������ɾ��");
				yes = sc.next();

			}

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("¼����Ϣ�������������������󣡣�");
		}

	}

	public static void  find() {

		String yes = "y";
		try {
			while (!yes.equalsIgnoreCase("n")) {
				System.out.println("��ѡ���ѯ��ʽ  1����������ѯ  2����ѧ�Ų�ѯ");
				int key = sc.nextInt();
				System.out.println("������ؼ���");
				String keyname = sc.next();
				ArrayList<Student> sList = ai.find(keyname, key);
				for (int i = 0; i < sList.size(); i++) {
					Student stu = sList.get(i);
					System.out.println("һ����" + sList.size() + "��ѧ��");
					showone(stu);
				}
				System.out.println("�Ƿ�������ң�����n����N��ֹͣ���ң����������");
				yes = sc.next();
			}

		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}

	public static void showone(Student stu) {
		System.out.println(
				"@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
		System.out.println("ѧ��\t����\t����\t�Ա�\t����\t\t��ϵ�绰\t\t����ϵ��\tѧ���䶯���\t�Ƿ��ҵ");
		System.out.println(stu.toString());

	}

	public static void modify() {
		String yes = "y", num;
		try {
			while (!yes.equalsIgnoreCase("n")) {
				System.out.println("��������Ҫ�޸ĵ�ѧ��ѧ��");
				num = sc.next();
				Student stu = ai.get(num);
				showone(stu);
				modifyInfo();
				int key = sc.nextInt();
				switch (key) {
				case 1:
					System.out.println("                                    1:���޸�ѧ��");
					stu.setNum(sc.next());
					break;
				case 2:
					System.out.println("                                    2:���޸�����");
					stu.setName(sc.next());
					break;
				case 3:
					System.out.println("                                    3:���޸�����");
					stu.setAge(sc.nextInt());
					break;
				case 4:
					System.out.println("                                    4:���޸��Ա�");
					stu.setSex(sc.next());
					break;
				case 5:
					System.out.println("                                    5:���޸ļ���");
					stu.setNativeplace(sc.next());
					break;
				case 6:
					System.out.println("                                    6:���޸���ϵ�绰");

					stu.setMobilephone(sc.next());
					break;
				case 7:
					System.out.println("                                    7:���޸�����ϵ��");
					stu.setDepartment(sc.next());
					break;
				case 8:
					System.out.println("                                    8:���޸�ѧ���䶯���");
					stu.setChange(sc.next());
					break;
				case 9:
					System.out.println("                                    9:���޸��Ƿ��ҵ");
					stu.setGradute(sc.next());
					break;
				case 0:
					System.out.println("                                    0:�˳��޸�");
					System.exit(0);
					break;
				default:
					break;
				}
				if (ai.modify(stu)) {
					System.out.println("�޸ĳɹ�");
				} else {
					System.out.println("�޸�ʧ�ܣ���");
				}
				System.out.println("����������޸ģ�����n����N�˳��޸ģ�����");
				yes = sc.next();
				showone(stu);
			}

		} catch (Exception e) {
			// TODO: handle exception
		}

	}

	public static void modifyInfo() {
		System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&");
		System.out.println("                                    1:���޸�ѧ��");
		System.out.println("                                    2:���޸�����");
		System.out.println("                                    3:���޸�����");
		System.out.println("                                    4:���޸��Ա�");
		System.out.println("                                    5:���޸ļ���");
		System.out.println("                                    6:���޸���ϵ�绰");
		System.out.println("                                    7:���޸�����ϵ��");
		System.out.println("                                    8:���޸�ѧ���䶯���");
		System.out.println("                                    9:���޸��Ƿ��ҵ");
		System.out.println("                                    0:�˳��޸�");
		System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&");
		System.out.println("\n   ��������Ҫ�޸ĵ���ţ�   ");

	}

	public static  void sort() {

		System.out.print("@@@@@@@@@@@@@@@����������ѧ��ѧ����@@@@@@@@@@@@@@\n");
		ai.sort();
		Infomation();
		System.out.print("@@@@@@@@@@@@@@@����������ѧ��ѧ����@@@@@@@@@@@@@@\n");

	}

	

}
