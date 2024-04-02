package com.accolite;

import java.sql.Connection;
import java.sql.DriverManager;

public class Main {
    public static void main(String[] args) {
        String url="jdbc:mysql://localhost:3306/hibernate_demo";

        try {
            System.out.println("Connecting to database " + url);
            Connection conn = DriverManager.getConnection(url, "root", "root");
            System.out.println("Connection successful");
            conn.close();
            System.out.println(conn.isClosed());
        }
        catch (Exception e) {
            System.out.println(e);
            e.printStackTrace();
        }
    }
}