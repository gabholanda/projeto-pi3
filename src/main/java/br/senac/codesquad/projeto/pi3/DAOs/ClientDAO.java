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
import java.util.List;

/**
 *
 * @author gabriel.hsantos21
 */
public class ClientDAO {

    private static PreparedStatement ps = null;
    private static ResultSet rs = null;
    private static boolean retorno = false;
    private static Connection con;

    public static boolean create(Client client) throws SQLException {
        try {
            con = ConnectionManager.getConnection();
            String query = "INSERT INTO client (NAME,CPF,ADDRESS,EMAIL) VALUES(?,?,?,?)";
            ps = con.prepareStatement(query);
            ps.setString(1, client.getName());
            ps.setString(2, client.getCpf());
            ps.setString(3, client.getAddress());
            ps.setString(4, client.getMail());

            int updatedlines = ps.executeUpdate();

            retorno = updatedlines > 0;
            con.close();
            return retorno;

        } catch (SQLException ex) {
            printSQLException(ex);
            con.close();
        }
        con.close();
        return false;
    }

    public static boolean delete(int id) throws SQLException {
        con = ConnectionManager.getConnection();
        String query = "DELETE FROM client WHERE ID_CLIENT =?";
        ps = con.prepareStatement(query);
        ps.setInt(1, id);
        int updatedlines = ps.executeUpdate();
        retorno = updatedlines > 0;
        con.close();
        return retorno;
    }

    public static boolean update(Client client) throws SQLException {
        try {
            con = ConnectionManager.getConnection();
            String query = "UPDATE client SET NAME = ?,CPF= ?, ADDRESS =?, EMAIL =? WHERE ID_CLIENT = ?";
            ps = con.prepareStatement(query);
            ps.setString(1, client.getName());
            ps.setString(2, client.getCpf());
            ps.setString(3, client.getAddress());
            ps.setString(4, client.getMail());
            ps.setInt(5, client.getId());

            int updatedlines = ps.executeUpdate();

            retorno = updatedlines > 0;
            con.close();
            return retorno;

        } catch (SQLException ex) {
            printSQLException(ex);
            con.close();
        }
        con.close();
        return false;

    }

// Method that helps to print SQL exceptions on console
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

    public static ArrayList<Client> read() throws SQLException {
        ArrayList<Client> Clients = new ArrayList<>();
        try {
            con = ConnectionManager.getConnection();
            String query = "SELECT * FROM client";
            ps = con.prepareStatement(query);
            rs = ps.executeQuery();
            if (rs != null) {
                while (rs.next()) {
                    Client client = new Client();
                    client.setId(rs.getInt("ID_CLIENT"));
                    client.setName(rs.getString("NAME"));
                    client.setCpf(rs.getString("CPF"));
                    client.setAddress((rs.getString("ADDRESS")));
                    client.setMail(rs.getString("EMAIL"));
                    Clients.add(client);
                }
            }
            con.close();
            return Clients;
        } catch (SQLException ex) {
            printSQLException(ex);
            con.close();
        }
        con.close();
        return null;
    }

    public static Client findBydId(int id) throws SQLException {
        try {
            con = ConnectionManager.getConnection();
            String query = "SELECT * FROM client WHERE ID_CLIENT = ?";
            ps = con.prepareStatement(query);
            ps.setInt(1, id);

            rs = ps.executeQuery();

            Client client = null;
            while (rs.next()) {
                client = new Client();
                client.setId(rs.getInt("ID_CLIENT"));
                client.setName(rs.getString("NAME"));
                client.setCpf(rs.getString("CPF"));
                client.setAddress((rs.getString("ADDRESS")));
                client.setMail(rs.getString("EMAIL"));
            }
            con.close();
            return client;

        } catch (SQLException ex) {
            printSQLException(ex);
            con.close();
        }
        con.close();
        return null;
    }

    public static List<Client> findByName(String name) throws SQLException {
        try {
            con = ConnectionManager.getConnection();
            String query = "SELECT * FROM client WHERE NAME LIKE ?";
            ps = con.prepareStatement(query);
            ps.setString(1, "%" + name + "%");

            rs = ps.executeQuery();

            List<Client> clientList = new ArrayList<>();
            if (rs != null) {
                while (rs.next()) {
                    Client client = new Client();
                    client.setId(rs.getInt("ID_CLIENT"));
                    client.setName(rs.getString("NAME"));
                    client.setCpf(rs.getString("CPF"));
                    client.setAddress((rs.getString("ADDRESS")));
                    client.setMail(rs.getString("EMAIL"));
                    clientList.add(client);
                }
            }
            con.close();
            return clientList;
        } catch (SQLException ex) {
            printSQLException(ex);
            con.close();
        }
        con.close();
        return null;
    }

}
