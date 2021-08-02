package com.service;

import com.jdbc.Jdbc;

import java.util.Scanner;

public class Login {
        public int login() {
                Scanner sc = new Scanner(System.in);
                Object[] parameter = new Object[2];
                System.out.println("请输入姓名");
                String name = sc.next();
                System.out.println("请输入密码");
                String password = sc.next();
                String sql = "select id from tb_student where name='" + name + "' and password=" + password;
                try {
                        return Jdbc.log(sql);
                } catch (Exception e) {
                        e.printStackTrace();
                }
                return 0;
        }
}
