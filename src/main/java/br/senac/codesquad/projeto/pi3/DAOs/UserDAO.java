/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.codesquad.projeto.pi3.DAOs;

import br.senac.codesquad.projeto.pi3.application.ConnectionManager;
import br.senac.codesquad.projeto.pi3.enums.Roles;
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
import java.util.List;

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

    public static boolean update(int id, String name, String password) throws SQLException {

        try {
            String query = "UPDATE user SET NAME = ?, PASSWORD=? WHERE ID_USER = ?";

            ps = con.prepareStatement(query);

            ps.setString(1, name);
//            ps.setString(2, user.getMail());
            ps.setString(2, password);
            ps.setInt(3, id);

            int updatedlines = ps.executeUpdate();

            retorno = updatedlines > 0;

            return retorno;

        } catch (SQLException ex) {
            throw ex;
        }

    }

    public static boolean create(String mail, String password, String name, Roles permission) throws SQLException {

        try {
            //FALTA O ID_BRANCH AQUI
            String query = "INSERT INTO user (NAME,EMAIL,PASSWORD,PERMISSIONS) VALUES(?,?,?,?)";
            ps = con.prepareStatement(query);
            ps.setString(1, name);
            ps.setString(2, mail);
            ps.setString(3, password);
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
                checkUserType(users);
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

            User user = checkUserType();
            return user;

        } catch (SQLException ex) {
            printSQLException(ex);
        }
        return null;
    }

    public static User findbyMail(String mail, String password) throws SQLException {
        try {
            //FALTA O ID BRANCH DAQUI
            String query = "SELECT EMAIL, PASSWORD, PERMISSIONS, ID_USER, ID_BRANCHOFFICE FROM user WHERE EMAIL = ?";
            ps = con.prepareStatement(query);
            ps.setString(1, mail);
            rs = ps.executeQuery();
            User user = null;
            while (rs.next()) {
                switch (rs.getString("permissions")) {
                    case "TI":
                        user = new TI();
                        break;
                    case "RH":
                        user = new RH();
                        break;
                    case "BACKOFFICE":
                        user = new BackOffice();
                        break;
                    case "VENDAS":
                        user = new Employee();
                        break;
                    case "GERENTE":
                        user = new Manager();
                        break;
                    case "DIRETORIA":
                        user = new Management();
                        break;
                    default:
                        user = null;
                        break;
                }
                user.setMail(rs.getString("email"));
                user.setPassword(rs.getString("password"));
                user.setIdBranch(rs.getInt("ID_BRANCHOFFICE"));
                user.setId(rs.getInt("ID_USER"));
            }

            return user;

        } catch (SQLException ex) {
            System.out.println(ex);
            return null;
        }
    }

    public static User checkUserType() throws SQLException {
        User user = null;
        while (rs.next()) {
            switch ((rs.getString("PERMISSIONS"))) {
                case "RH":
                    user = (User) new RH();
                    user.setId(rs.getInt("ID_USER"));
                    user.setName(rs.getString("NAME"));
                    user.setMail(rs.getString("EMAIL"));
                    break;
                case "TI":
                    user = (User) new TI();
                    user.setId(rs.getInt("ID_USER"));
                    user.setName(rs.getString("NAME"));
                    user.setMail(rs.getString("EMAIL"));
                    break;
                case "VENDAS":
                    user = (User) new Manager();
                    user.setId(rs.getInt("ID_USER"));
                    user.setName(rs.getString("NAME"));
                    user.setMail(rs.getString("EMAIL"));
                    break;
                case "DIRETORIA":
                    user = (User) new Management();
                    user.setId(rs.getInt("ID_USER"));
                    user.setName(rs.getString("NAME"));
                    user.setMail(rs.getString("EMAIL"));
                    break;
                case "BACKOFFICE":
                    user = (User) new BackOffice();
                    user.setId(rs.getInt("ID_USER"));
                    user.setName(rs.getString("NAME"));
                    user.setMail(rs.getString("EMAIL"));
                    break;
            }
        }
        return user;
    }

    public static void checkUserType(List<User> list) throws SQLException {
        User user = null;
        while (rs.next()) {
            switch ((rs.getString("PERMISSIONS"))) {
                case "RH":
                    user = (User) new RH();
                    user.setId(rs.getInt("ID_USER"));
                    user.setName(rs.getString("NAME"));
                    user.setMail(rs.getString("EMAIL"));
                    break;
                case "TI":
                    user = (User) new TI();
                    user.setId(rs.getInt("ID_USER"));
                    user.setName(rs.getString("NAME"));
                    user.setMail(rs.getString("EMAIL"));
                    break;
                case "VENDAS":
                    user = (User) new Manager();
                    user.setId(rs.getInt("ID_USER"));
                    user.setName(rs.getString("NAME"));
                    user.setMail(rs.getString("EMAIL"));
                    break;
                case "DIRETORIA":
                    user = (User) new Management();
                    user.setId(rs.getInt("ID_USER"));
                    user.setName(rs.getString("NAME"));
                    user.setMail(rs.getString("EMAIL"));
                    break;
                case "BACKOFFICE":
                    user = (User) new BackOffice();
                    user.setId(rs.getInt("ID_USER"));
                    user.setName(rs.getString("NAME"));
                    user.setMail(rs.getString("EMAIL"));
                    break;
            }
            list.add(user);
        }
    }

}
