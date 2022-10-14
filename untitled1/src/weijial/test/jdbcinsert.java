package weijial.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

import weijial.test.jabcsearch;

import static weijial.test.jabcsearch.usersearch;


public class jdbcinsert {
    public static void main(String[] args) {
       foodinsert();
    }
public static void foodinsert(){
    String url="jdbc:mysql://localhost:3306/first_work?serverTimezone=UTC";
    Scanner input=new Scanner(System.in);

    System.out.println("输入食物名");
    String foodname=input.next();
    System.out.println("食堂用数字1，2，3代替");
    int canteen=input.nextInt();
    System.out.println("楼层");
    int  password=input.nextInt();

    try {
        Connection con = DriverManager.getConnection(url,"root","123123" );
        String sql="insert into food(name ,canteen,floor) values (?,?,?)";

        PreparedStatement pre = con.prepareStatement(sql);
        pre.setObject(1,foodname);
        pre.setObject(2,canteen);
        pre.setObject(3,password);
        int i = pre.executeUpdate();
        System.out.println(i>0?"yes":"no");
        pre.close();
        con.close();
    } catch (SQLException e) {
        e.printStackTrace();
    }
}

    public static void userinsert(){
        String url="jdbc:mysql://localhost:3306/first_work?serverTimezone=UTC";
        Scanner input=new Scanner(System.in);

        System.out.println("输入用户名");
        String username=input.next();
        System.out.println("输入邮箱");
        String email=input.next();
        System.out.println("输入密码");
        String password=input.next();

        try {
            Connection con = DriverManager.getConnection(url,"root","123213" );
            String sql="insert into user(username,email,password) values (?,?,MD5(?))";

            PreparedStatement pre = con.prepareStatement(sql);
            pre.setObject(1,username);
            pre.setObject(2,email);
            pre.setObject(3,password);
            int i = pre.executeUpdate();
            System.out.println(i>0?"yes":"no");
            pre.close();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void shoucang(){
        String url="jdbc:mysql://localhost:3306/first_work?serverTimezone=UTC";
        Scanner input=new Scanner(System.in);


        System.out.println("食物编号");
        int canteen=input.nextInt();
        System.out.println("用户编号");
        int  password=input.nextInt();

        try {
            Connection con = DriverManager.getConnection(url,"root","123123" );
            String sql="insert into save(canteen,floor) values (?,?)";

            PreparedStatement pre = con.prepareStatement(sql);
            pre.setObject(1,canteen);
            pre.setObject(2,password);
            int i = pre.executeUpdate();
            System.out.println(i>0?"yes":"no");
            pre.close();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
