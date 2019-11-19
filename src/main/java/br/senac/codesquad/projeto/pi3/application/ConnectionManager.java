/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.codesquad.projeto.pi3.application;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author gabriel.hsantos21
 */
public class ConnectionManager {

    private static final String driverName = "com.mysql.jdbc.Driver";
    private static final String username = "admin";
    private static final String password = "adminadmin";
    private static Connection con;
    private static final String urlString = "jdbc:mysql://teste.ctqsrvfmxptn.us-east-1.rds.amazonaws.com:3306/codesquad?useTimezone=true&serverTimezone=UTC";

    public static Connection getConnection() {
        try {
            Class.forName(driverName);
            try {
                con = DriverManager.getConnection(urlString, username, password);
            } catch (SQLException ex) {
                System.out.println("Failed to create the database connection.");
            }
        } catch (ClassNotFoundException ex) {
            System.out.println("Driver not found.");
        }
        return con;
    }

    public static void closeConnection() {
        try {
            con.close();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

}
