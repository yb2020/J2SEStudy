package com.gebilaoyi.j2se.lesson15;

import java.sql.*;

/**
 * @author bingyi
 * @date 2022/7/3
 * J2SEStudy
 **/
public class MyLesson15 {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver") ;
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/test1", "root", "root") ;
            Statement statement = connection.createStatement() ;
            ResultSet rs = statement.executeQuery("select id, name from teacher") ;
            ResultSetMetaData rsmd = rs.getMetaData();
            for(int i = 1 ; i <= rsmd.getColumnCount(); i ++) {
                System.out.print(rsmd.getColumnName(i) + "    ");
            }
            System.out.println();
            while(rs.next()) {
                System.out.println(rs.getInt(1) + "   " + rs.getString(2));
            }
            int i = statement.executeUpdate("update teacher set name='Mrs.Wang' where id=1");
        }catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
