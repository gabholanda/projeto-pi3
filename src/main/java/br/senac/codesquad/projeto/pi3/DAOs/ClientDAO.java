/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.codesquad.projeto.pi3.DAOs;

import br.senac.codesquad.projeto.pi3.application.ConnectionManager;
import br.senac.codesquad.projeto.pi3.models.Client;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author gabriel.hsantos21
 */
public class ClientDAO {

    private static PreparedStatement ps = null;
    private static ResultSet rs = null;
    private static boolean retorno = false;
    private static Connection con = ConnectionManager.getConnection();

    public static ArrayList<Client> getClient() {

        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public static boolean delete(int id) {
        boolean returnn = false;

        /*   try { 
            
            Class.forName(DRIVER); 
            connection = DriverManager.getConnection(URL, LOGIN, SENHA); 
            
            PreparedStatement comand = connection.prepareStatement("DELETE FROM CLIENT WHERE ID_CLIENT=?"); 
            
            comand.setInt(1, id);
            
            int lineserror = comand.executeUpdate(); 
            
            if(lineserror > 0){ 
                returnn = true; 
            } else { 
                returnn = false; 
            }                        
            
        }catch (ClassNotFoundException | SQLException ex) { 
            returnn = false; 
        }finally { 
            try { 
                connection.close();
            }catch (SQLException ex) { 
                returnn = false; 
            }
        }
        
       return returnn; */
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public static boolean update(Client client) {

        boolean returnn = false;

        /*     try {
            Class.forName(DRIVER);
            connection = DriverManager.getConnection(URL, LOGIN, SENHA);

            PreparedStatement comand = connection.prepareStatement("UPDATE CLIENT SET "
                    + "NAME=?, ANDRESS=?"
                    + "WHERE ID_CLIENT=?");

            comand.setString(1, client.getName());
            comand.setString(2, client.getAddress());

            int lineserror = comand.executeUpdate();

            if (lineserror > 0) {
                returnn = true;
            } else {
                returnn = false;
            }

        } catch (ClassNotFoundException | SQLException ex) {
            returnn = false;

        } finally { 
            try { 
                connection.close();
            } catch (SQLException ex){ 
                returnn = false; 
            }
        }
        
        return returnn; */
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public static boolean save(Client client) {

        try {

            String query
                    = "INSERT"
                    + "       INTO"
                    + "   CLIENT"
                    + "       (NAME,CPF,ADDRESS, MAIL)"
                    + "   VALUES"
                    + "        (?,?,?,?)  ";
            ps = con.prepareStatement(query);
            ps.setString(1, client.getName());
            ps.setString(2, client.getCpf());
            ps.setString(3, client.getAddress());
            ps.setString(4, client.getMail()); 
            int updatedlines = ps.executeUpdate();

            retorno = updatedlines > 0;

            return retorno;

        } catch (SQLException ex) {
            printSQLException(ex);

        }
        return false;
    }
    
    
    private static void printSQLException(SQLException ex) {
        for (Throwable e : ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }
}