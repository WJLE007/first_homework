package weijial.test;

import java.sql.*;
import java.util.Scanner;

public class shanchucaozuo {
    public static void deluser(){
        String url="jdbc:mysql://localhost:3306/first_work?serverTimezone=UTC";
        Scanner input=new Scanner(System.in);

        System.out.println("输入你的用户名称");
        String username=input.next();
        try {
            Connection con = DriverManager.getConnection(url,"root","123123" );
            String sql="delete from user where username=?";
            PreparedStatement pre = con.prepareStatement(sql);
            pre.setObject(1,username);
            ResultSet resultSet = pre.executeQuery();
            //遍历结果集合
            pre.close();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void delfood(){
        String url="jdbc:mysql://localhost:3306/first_work?serverTimezone=UTC";
        Scanner input=new Scanner(System.in);

        System.out.println("输入食物名称");
        String username=input.next();
        try {
            Connection con = DriverManager.getConnection(url,"root","12323" );
            String sql="delete from food where name=?";
            PreparedStatement pre = con.prepareStatement(sql);
            pre.setObject(1,username);
            ResultSet resultSet = pre.executeQuery();
            //遍历结果集合
            pre.close();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }public static void delsave(){
        String url="jdbc:mysql://localhost:3306/first_work?serverTimezone=UTC";
        Scanner input=new Scanner(System.in);

        System.out.println("输入你的用户名称");
     int userid=input.nextInt();
        System.out.println("输入食物名称");
        int food=input.nextInt();
        try {
            Connection con = DriverManager.getConnection(url,"root","123123" );
            String sql="delete from save where user_id=? and food_id=?";
            PreparedStatement pre = con.prepareStatement(sql);
            pre.setObject(1,userid);
            pre.setObject(2,food);
            ResultSet resultSet = pre.executeQuery();
            //遍历结果集合
            pre.close();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
