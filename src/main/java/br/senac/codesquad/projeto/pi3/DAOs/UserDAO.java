/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.codesquad.projeto.pi3.DAOs;

import br.senac.codesquad.projeto.pi3.application.ConnectionManager;
import br.senac.codesquad.projeto.pi3.models.Client;
import br.senac.codesquad.projeto.pi3.models.Employee;
import br.senac.codesquad.projeto.pi3.models.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author patrick.ctavares1
 */
public class UserDAO {

    private static PreparedStatement ps = null;
    private static ResultSet rs = null;
    private static boolean retorno = false;
    private static final Connection con = ConnectionManager.getConnection();

    public static boolean delete(int id) throws SQLException {
        String query = "DELETE FROM user WHERE ID_USER =?";

        ps = con.prepareStatement(query);
        ps.setInt(1, id);
        int updatedlines = ps.executeUpdate();
        retorno = updatedlines > 0;
        return retorno;
    }

    public static boolean update(User user, int id) throws SQLException {

        try {
            String query = "UPDATE user SET NAME = ?,EMAIL= ?, PASSWORD=? WHERE ID_USER = ?";

            ps = con.prepareStatement(query);

            ps.setString(1, user.getName());
            ps.setString(2, user.getMail());
            ps.setString(3, user.getPassword());
            ps.setInt(4, id);

            int updatedlines = ps.executeUpdate();

            retorno = updatedlines > 0;

            return retorno;

        } catch (SQLException ex) {
            throw ex;
        }

    }

    public static boolean create(User user, String permission) throws SQLException {

        try {

            String query = "INSERT INTO user (NAME,EMAIL,PASSWORD,PERMISSIONS) VALUES(?,?,?,?)";
            ps = con.prepareStatement(query);
            ps.setString(1, user.getName());
            ps.setString(2, user.getMail());
            ps.setString(3, user.getPassword());
            ps.setString(4, permission);

            int updatedlines = ps.executeUpdate();

            retorno = updatedlines > 0;

            return retorno;

        } catch (SQLException ex) {
            printSQLException(ex);

        }
        return false;
    }

// Method that helps to print SQL exceptions on consoles
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

    public static ArrayList<User> read() {
        ArrayList<User> users = new ArrayList<>();
        try {
            String query = "SELECT * FROM user";

            ps = con.prepareStatement(query);
            rs = ps.executeQuery();
            if (rs != null) {
                //adicionar condiçoes de permissões
                while (rs.next()) {
                    User user = new Employee();
                    user.setId(rs.getInt("ID_USER"));
                    user.setName(rs.getString("NAME"));
                    user.setMail(rs.getString("EMAIL"));
                    user.setPassword(rs.getString("PASSWORD"));
                    user.setPermission(rs.getString("PERMISSIONS"));
                    users.add(user);
                }
            }
            return users;
        } catch (SQLException ex) {
            printSQLException(ex);
        }
        return null;
    }

    public static Client findBydId(int id) {

        try {
            String query = "SELECT * FROM user WHERE ID_USER = ?";
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
