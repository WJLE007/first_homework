package weijial.test;

import java.sql.*;
import java.util.Random;
import java.util.Scanner;

public class jabcsearch {
    public static void main(String[] args) {
      randomtfood();
    }
    public static void foodsearch(){
        String url="jdbc:mysql://localhost:3306/first_work?serverTimezone=UTC";
        try {
            Connection con = DriverManager.getConnection(url,"root","123123" );
            String sql="select * from food";
            PreparedStatement pre = con.prepareStatement(sql);
            ResultSet resultSet = pre.executeQuery();
            //遍历结果集合
            while (resultSet.next()){
                int did= resultSet.getInt("id");
                String dname=resultSet.getString("name");
               int desc= resultSet.getInt("canteen");
                int mima=resultSet.getInt("floor");
                System.out.println(did+"\t"+dname+"\t"+desc+"\t"+mima);
            }
            pre.close();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void usersearch(){
        String url="jdbc:mysql://localhost:3306/first_work?serverTimezone=UTC";
        try {
            Connection con = DriverManager.getConnection(url,"root","123123" );
            String sql="select * from user";
            PreparedStatement pre = con.prepareStatement(sql);
            ResultSet resultSet = pre.executeQuery();
            //遍历结果集合
            while (resultSet.next()){
                int did= resultSet.getInt("id");
                String dname=resultSet.getString("username");
                String desc= resultSet.getString("email");
                String mima=resultSet.getString("password");
                System.out.println(did+"\t"+dname+"\t"+desc+"\t"+mima);
            }
            pre.close();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void slectfood(){
        String url="jdbc:mysql://localhost:3306/first_work?serverTimezone=UTC";
        Scanner input=new Scanner(System.in);
        System.out.println("所在食堂");
        int canteen=input.nextInt();
        System.out.println("所在楼层");
        int floor=input.nextInt();
        try {
            Connection con = DriverManager.getConnection(url,"root","123123https://github.com/WJLE007/first_homework" );
            String sql="select * from food where canteen=? and floor=?";
            PreparedStatement pre = con.prepareStatement(sql);
            pre.setObject(1,canteen);
            pre.setObject(2,floor);
            ResultSet resultSet = pre.executeQuery();
            //遍历结果集合
            while (resultSet.next()){
                int did= resultSet.getInt("id");
                String dname=resultSet.getString("name");
                int desc= resultSet.getInt("canteen");
                int mima=resultSet.getInt("floor");
                System.out.println(did+"\t"+dname);
            }
            pre.close();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void randomtfood(){
        String url="jdbc:mysql://localhost:3306/first_work?serverTimezone=UTC";
//        Scanner input=new Scanner(System.in);
//        System.out.println("所在食堂");
//        int canteen=input.nextInt();
//        System.out.println("所在楼层");
//        int floor=input.nextInt();
        try {
            Connection con = DriverManager.getConnection(url,"root","123123" );
            String sql="select * from food ";
            PreparedStatement pre = con.prepareStatement(sql);
            ResultSet resultSet = pre.executeQuery();
            //遍历结果集合
            int count=0;
            while (resultSet.next()){
                count++;
//                int did= resultSet.getInt("id");
//                String dname=resultSet.getString("name");
//                int desc= resultSet.getInt("canteen");
//                int mima=resultSet.getInt("floor");
//                System.out.println(did+"\t"+dname);
            }
            Random rd=new Random();
            int suijishu=rd.nextInt(count)+1;
            String sql1="select * from food where id=? ";
            PreparedStatement pre1 = con.prepareStatement(sql1);
            pre1.setObject(1,suijishu);
            ResultSet resultSet1 = pre1.executeQuery();
            System.out.println("今天就吃这个好了：");
            while (resultSet1.next()){

                int did= resultSet1.getInt("id");
                String dname=resultSet1.getString("name");
                int desc= resultSet1.getInt("canteen");
                int mima=resultSet1.getInt("floor");
                System.out.println(did+"\t"+dname+"\t"+desc+"\t"+mima);
            }
            pre.close();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
