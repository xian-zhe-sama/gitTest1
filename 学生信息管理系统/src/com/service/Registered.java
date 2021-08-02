package com.service;

import com.jdbc.Jdbc;

import java.util.Scanner;

public class Registered {
        Scanner sc = new Scanner(System.in);

        public void zhuce() {
                Object[] parameter = new Object[4];
                System.out.println("请输入姓名");
                parameter[0] = sc.nextLine();
                Object[] name = new Object[2];
                name[0] = parameter[0];
                name[1] = "null";
                System.out.println("请输入密码");
                parameter[1] = sc.nextLine();
                System.out.println("请输入性别");
                parameter[2] = sc.nextLine();
                System.out.println("请输入年龄");
                parameter[3] = sc.nextInt();
                String sql = "insert into tb_student(name,password,sex,age) values(?,?,?,?)";
                String sql2 = "insert into student_course(studentname,coursename) values(?,?)";
                if (Jdbc.executeupdates(sql, parameter) > 0 && Jdbc.executeupdates(sql2, name) > 0) {
                        System.out.println("注册成功");
                } else {
                        System.out.println("注册失败");
                }
        }
}
