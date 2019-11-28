/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.codesquad.projeto.pi3.DAOs;

import br.senac.codesquad.projeto.pi3.application.ConnectionManager;
import br.senac.codesquad.projeto.pi3.models.BranchOffice;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author lucas.mnpaiva
 */
public class BranchOfficeDAO {

    private static PreparedStatement ps = null;
    private static ResultSet rs = null;
    private static boolean retorno = false;
    private static Connection con;

    public static boolean create(BranchOffice branch) throws SQLException {
        try {
            con = ConnectionManager.getConnection();
            String query = "INSERT INTO branch_office(NAME,CNPJ,ADDRESS) VALUES(?,?,?)";

            ps = con.prepareStatement(query);
            ps.setString(1, branch.getName());
            ps.setString(2, branch.getCnpj());
            ps.setString(3, branch.getAddress());

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
        String query = "DELETE FROM branch_office WHERE ID=?";
        ps = con.prepareStatement(query);
        ps.setInt(1, id);
        int updatedlines = ps.executeUpdate();
        retorno = updatedlines > 0;
        con.close();
        return retorno;
    }

    public static boolean update(BranchOffice branch) throws Exception {
        try {
            con = ConnectionManager.getConnection();
            String query = "UPDATE branch_office SET NAME = ?,CNPJ= ?, ADDRESS =? WHERE ID = ?";
            ps = con.prepareStatement(query);
            ps.setString(1, branch.getName());
            ps.setString(2, branch.getCnpj());
            ps.setString(3, branch.getAddress());
            ps.setInt(4, branch.getId());

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

    public static ArrayList<BranchOffice> read() throws Exception {
        ArrayList<BranchOffice> Branchs = new ArrayList<>();
        try {
            con = ConnectionManager.getConnection();
            String query = "SELECT * FROM branch_office";
            ps = con.prepareStatement(query);
            rs = ps.executeQuery();
            if (rs != null) {
                while (rs.next()) {
                    BranchOffice branch = new BranchOffice();
                    branch.setId(rs.getInt("ID"));
                    branch.setName(rs.getString("NAME"));
                    branch.setCnpj(rs.getString("CNPJ"));
                    branch.setAddress((rs.getString("ADDRESS")));
                    Branchs.add(branch);
                }
            }
            con.close();
            return Branchs;
        } catch (SQLException ex) {
            printSQLException(ex);
            con.close();
        }
        con.close();
        return null;
    }

    public static BranchOffice findBydId(int id) throws SQLException {
        try {
            con = ConnectionManager.getConnection();
            String query = "SELECT * FROM branch_office WHERE ID = ?";
            ps = con.prepareStatement(query);
            ps.setInt(1, id);

            rs = ps.executeQuery();

            BranchOffice branch = null;
            while (rs.next()) {
                branch = new BranchOffice();
                branch.setId(rs.getInt("ID"));
                branch.setName(rs.getString("NAME"));
                branch.setCnpj(rs.getString("CNPJ"));
                branch.setAddress((rs.getString("ADDRESS")));
            }
            con.close();
            return branch;
        } catch (SQLException ex) {
            printSQLException(ex);
            con.close();
        }
        con.close();
        return null;
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

    public static List<BranchOffice> findCategoryName() throws SQLException {
        try {
            con = ConnectionManager.getConnection();
            String query = "SELECT * FROM branch_office";
            ps = con.prepareStatement(query);
            rs = ps.executeQuery();
            List<BranchOffice> list = new ArrayList<>();
            if (rs != null) {
                while (rs.next()) {
                    BranchOffice branchOffice = new BranchOffice();
                    branchOffice.setId(rs.getInt("ID"));
                    branchOffice.setName(rs.getString("NAME"));
                    list.add(branchOffice);
                }
            }
            con.close();
            return list;
        } catch (SQLException ex) {
            printSQLException(ex);
            con.close();
        }
        con.close();
        return null;
    }

}
