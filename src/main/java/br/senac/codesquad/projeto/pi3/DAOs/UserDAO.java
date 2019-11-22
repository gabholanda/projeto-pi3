/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.codesquad.projeto.pi3.DAOs;

import br.senac.codesquad.projeto.pi3.application.ConnectionManager;
import br.senac.codesquad.projeto.pi3.enums.Roles;
import static br.senac.codesquad.projeto.pi3.enums.Roles.RH;
import static br.senac.codesquad.projeto.pi3.enums.Roles.TI;
import static br.senac.codesquad.projeto.pi3.enums.Roles.BACKOFFICE;
import static br.senac.codesquad.projeto.pi3.enums.Roles.DIRETORIA;
import static br.senac.codesquad.projeto.pi3.enums.Roles.GERENTE;
import static br.senac.codesquad.projeto.pi3.enums.Roles.VENDAS;
import br.senac.codesquad.projeto.pi3.models.BackOffice;
import br.senac.codesquad.projeto.pi3.models.Employee;
import br.senac.codesquad.projeto.pi3.models.Management;
import br.senac.codesquad.projeto.pi3.models.Manager;
import br.senac.codesquad.projeto.pi3.models.RH;
import br.senac.codesquad.projeto.pi3.models.TI;
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
            String query = "UPDATE user SET NAME = ?, PASSWORD=? WHERE ID_USER = ?";

            ps = con.prepareStatement(query);

            ps.setString(1, user.getName());
//            ps.setString(2, user.getMail());
            ps.setString(2, user.getPassword());
            ps.setInt(3, id);

            int updatedlines = ps.executeUpdate();

            retorno = updatedlines > 0;

            return retorno;

        } catch (SQLException ex) {
            throw ex;
        }

    }

    public static boolean create(User user, Roles permission) throws SQLException {

        try {

            String query = "INSERT INTO user (NAME,EMAIL,PASSWORD,PERMISSIONS) VALUES(?,?,?,?)";
            ps = con.prepareStatement(query);
            ps.setString(1, user.getName());
            ps.setString(2, user.getMail());
            ps.setString(3, user.getPassword());
            ps.setString(4, permission.getPermission());

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
            String query = "SELECT ID_USER, NAME, EMAIL, PERMISSIONS FROM user";

            ps = con.prepareStatement(query);
            rs = ps.executeQuery();
            if (rs != null) {
                //adicionar condiçoes de permissões
                while (rs.next()) {
                    User user = new User() {
                    };
                    user.setId(rs.getInt("ID_USER"));
                    user.setName(rs.getString("NAME"));
                    user.setMail(rs.getString("EMAIL"));
//                    user.setPermission(Roles.DIRETORIA);
                    user.setPermission(Roles.valueOf(rs.getString("PERMISSIONS")));
                    users.add(user);
                }
            }
            return users;
        } catch (SQLException ex) {
            printSQLException(ex);
        }
        return null;
    }

    public static User findBydId(int id) {

        try {
            String query = "SELECT ID_USER, NAME, EMAIL  FROM user WHERE ID_USER = ?";
            ps = con.prepareStatement(query);
            ps.setInt(1, id);

            rs = ps.executeQuery();

            User user = new User() {
            };
            while (rs.next()) {
                user.setId(rs.getInt("ID_USER"));
                user.setName(rs.getString("NAME"));
                user.setMail(rs.getString("EMAIL"));
//                user.setPermission((rs.getString("PERMISSIONS")));
            }

            return user;

        } catch (SQLException ex) {
            printSQLException(ex);
        }
        return null;
    }

    public static User findbyMail(User user) throws SQLException {
        try {
            String query = "SELECT PERMISSIONS FROM codesquad.user WHERE EMAIL = ? and PASSWORD = ?";
            ps = con.prepareStatement(query);
            ps.setString(1, user.getMail());
            ps.setString(2, user.getPassword());
            rs = ps.executeQuery();

            while (rs.next()) {
                if (rs.getString("permissions").equals("TI")) {
                    user = new TI();
                } else if (rs.getString("permissions").equals("RH")) {
                    user = new RH();
                } else if (rs.getString("permissions").equals("BACKOFFICE")) {
                    user = new BackOffice();
                } else if (rs.getString("permissions").equals("VENDAS")) {
                    user = new Employee();
                } else if (rs.getString("permissions").equals("MANAGER")) {
                    user = new Manager();
                } else {

                    user = new Management();
                }

                user.setMail(rs.getString("mail"));
                user.setPassword(rs.getString("password"));
            }

            return user;

        } catch (SQLException ex) {
            System.out.println(ex);
            return null;
        }
    }
}
