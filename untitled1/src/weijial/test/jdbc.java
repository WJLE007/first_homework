package weijial.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class jdbc {
    public static void main(String[] args) {
        String url="jdbc:mysql://localhost:3306/atguigu?serverTimezone=UTC";
        Connection con= null;
        try {
            con = DriverManager.getConnection(url,"root","Ll5211314" );
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println(con);
    }
}

