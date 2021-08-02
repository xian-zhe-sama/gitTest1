package com.service;

import com.jdbc.Jdbc;

public class Changeinfor {
        public int changesex(int sex, int id) {
                String sql = null;
                if (sex == 1) {
                        sql = "update tb_student set sex='男' where id=" + id;
                } else if (sex == 2) {
                        sql = "update tb_student set sex='女' where id=" + id;
                } else {
                        System.out.println("输入错误");
                        return 0;
                }
                return Jdbc.change(id, sql);
        }

        public int changeage(int age, int id) {
                String sql = "update tb_student set age=" + age + " where id=" + id;
                return Jdbc.change(id, sql);
        }

        public int changecourse(int course, int id) {
                String sql = null;
                if (course == 1) {
                        sql = "update student_course set coursename='java课程' where id=" + id;
                } else if (course == 2) {
                        sql = "update student_course set coursename='sql课程' where id=" + id;
                } else if (course == 3) {
                        sql = "update student_course set coursename='ps课程' where id=" + id;
                } else {
                        System.out.println("输入错误");
                }
                return Jdbc.change(id, sql);
        }
}
