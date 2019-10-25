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
    private static final Connection con = ConnectionManager.getConnection();

    public static boolean delete(int id) throws SQLException {
        String query = "DELETE FROM client WHERE ID_CLIENT =?";

        ps = con.prepareStatement(query);
        ps.setInt(1, id);
        int updatedlines = ps.executeUpdate();
        retorno = updatedlines > 0;
        return retorno;
    }

    public static boolean update(Client client) throws SQLException {

        try {
            String query = "UPDATE client SET NAME = ?,CPF= ?, ADDRESS =?, EMAIL =? WHERE ID_CLIENT = ?";

            ps = con.prepareStatement(query);

            ps.setString(1, client.getName());
            ps.setString(2, client.getCpf());
            ps.setString(3, client.getAddress());
            ps.setString(4, client.getMail());
            ps.setInt(5, client.getId());

            int updatedlines = ps.executeUpdate();

            retorno = updatedlines > 0;

            return retorno;

        } catch (SQLException ex) {
            throw ex;
        }

    }
    
    public static boolean create(Client client) {
        try {

            String query = "INSERT INTO client (NAME,CPF,ADDRESS,EMAIL) VALUES(?,?,?,?)";
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

    public static ArrayList<Client> read() {
        ArrayList<Client> Clients = new ArrayList<>();
        try {
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
            return Clients;
        } catch (SQLException ex) {
            printSQLException(ex);
        }
        return null;
    }

    public static Client findBydId(int id) {

        try {
            String query = "SELECT * FROM client WHERE ID_CLIENT = ?";
            ps = con.prepareStatement(query);
            ps.setInt(1, id);

            rs = ps.executeQuery();

            Client client = new Client();
            while (rs.next()) {
                client.setId(rs.getInt("ID_CLIENT"));
                client.setName(rs.getString("NAME"));
                client.setCpf(rs.getString("CPF"));
                client.setAddress((rs.getString("ADDRESS")));
                client.setMail(rs.getString("EMAIL"));
            }

            return client;

        } catch (SQLException ex) {
            printSQLException(ex);
        }
        return null;
    }

    
}
