package com.domain;

import com.service.Changeinfor;
import com.service.Information;
import com.service.Login;
import com.service.Registered;

import java.util.Scanner;

public class Test {
        public static void main(String[] args) {
                Scanner sc = new Scanner(System.in);
                Registered registered = new Registered();
                Login login = new Login();
                Information information = new Information();
                Changeinfor changeinfor = new Changeinfor();
                while (true) {
                        System.out.println("欢迎来到学生信息管理系统");
                        System.out.println("1注册  2.登陆  3.退出");
                        switch (sc.nextInt()) {
                                case 1:
                                        registered.zhuce();
                                        break;
                                case 2:
                                        int id = login.login();
                                        if (id > 0) {
                                                int exit = 0;
                                                while (exit != 4) {
                                                        System.out.println("1.查询个人信息  2.修改个人信息  3.课程选择  4.返回上一级");
                                                        exit = sc.nextInt();
                                                        switch (exit) {
                                                                case 1:
                                                                        information.information(id);
                                                                        break;
                                                                case 2:
                                                                        System.out.println("1.修改性别  2.修改年龄");
                                                                        switch (sc.nextInt()) {
                                                                                case 1:
                                                                                        System.out.println("请选择修改性别为  1.男   2.女");
                                                                                        changeinfor.changesex(sc.nextInt(), id);
                                                                                        break;
                                                                                case 2:
                                                                                        System.out.println("请输入要改成的年龄");
                                                                                        changeinfor.changeage(sc.nextInt(), id);
                                                                                        break;
                                                                                default:
                                                                                        System.out.println("输入错误");
                                                                        }
                                                                        break;
                                                                case 3:
                                                                        System.out.println("1.java课程   2.sql课程   3.ps课程");
                                                                        changeinfor.changecourse(sc.nextInt(), id);
                                                                        break;
                                                                case 4:
                                                                        break;
                                                                default:
                                                                        System.out.println("输入错误");
                                                        }
                                                }
                                        } else {
                                                System.out.println("登陆失败，姓名或密码错误");
                                        }
                                        break;
                                case 3:
                                        System.out.println("退出系统");
                                        return;
                                default:
                                        System.out.println("输入错误");
                        }
                }
        }
}
