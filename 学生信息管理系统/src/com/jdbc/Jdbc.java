package com.jdbc;

import com.mysql.cj.jdbc.JdbcConnection;

import javax.swing.plaf.nimbus.State;
import java.sql.*;

public class Jdbc {
        public static Connection getconnection() {
                String username = "root";
                String password = "123456";
                String url = "jdbc:mysql://localhost:3306/tb_student?serverTimezone=UTC";
                Connection con = null;
                try {
                        Class.forName("com.mysql.cj.jdbc.Driver");
                        con = DriverManager.getConnection(url, username, password);
                } catch (ClassNotFoundException e) {
                        e.printStackTrace();
                } catch (SQLException e) {
                        e.printStackTrace();
                }
                return con;
        }

        public static int executeupdates(String sql, Object[] parameter) {
                int a = 0;
                try {
                        Connection con = getconnection();
                        PreparedStatement pt = con.prepareStatement(sql);
                        for (int i = 0; i < parameter.length; i++) {
                                pt.setObject(i + 1, parameter[i]);
                        }
                        a = pt.executeUpdate();
                        close(con, pt);
                } catch (SQLException e) {
                        e.printStackTrace();
                }
                return a;
        }

        public static void executequery(String sql) {
                try {
                        Connection con = getconnection();
                        Statement st = con.createStatement();
                        ResultSet rs = st.executeQuery(sql);
                        while (rs.next()) {

                        }
                        close(con, st, rs);
                } catch (SQLException e) {
                        e.printStackTrace();
                }
        }

        public static int change(int id, String sql) {
                try {
                        Connection con = getconnection();
                        PreparedStatement pt = con.prepareStatement(sql);
                        int a = pt.executeUpdate();
                        close(con, pt);
                        return a;
                } catch (SQLException e) {
                        e.printStackTrace();
                }
                return 0;
        }

        public static void information(int id) {
                String sql = "select * from tb_student where id=" + id;
                try {
                        Connection con = getconnection();
                        Statement st = con.createStatement();
                        ResultSet rs = st.executeQuery(sql);
                        while (rs.next()) {
                                System.out.println("姓名:" + rs.getString("name") + "\t性别:" + rs.getString("sex") +
                                        "\t年龄:" + rs.getInt("age"));
                        }
                        close(con, st, rs);
                } catch (SQLException e) {
                        e.printStackTrace();
                }
        }

        public static int log(String sql) {
                int id = 0;
                try {
                        Connection con = getconnection();
                        Statement st = con.createStatement();
                        ResultSet rs = st.executeQuery(sql);
                        while (rs.next()) {
                                id = rs.getInt("id");
                        }
                        close(con, st, rs);
                } catch (SQLException e) {
                        e.printStackTrace();
                }
                return id;
        }

        public static void close(Connection con, PreparedStatement pt, Statement st, ResultSet rs) {
                try {
                        con.close();
                        pt.close();
                        st.close();
                        rs.close();
                } catch (SQLException e) {
                        e.printStackTrace();
                }
        }

        public static void close(Connection con, Statement st, ResultSet rs) {
                try {
                        con.close();
                        st.close();
                        rs.close();
                } catch (SQLException e) {
                        e.printStackTrace();
                }
        }

        public static void close(Connection con, PreparedStatement pt) {
                try {
                        con.close();
                        pt.close();
                } catch (SQLException e) {
                        e.printStackTrace();
                }
        }
}
