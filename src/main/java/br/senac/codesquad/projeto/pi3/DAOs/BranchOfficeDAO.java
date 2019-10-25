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

/**
 *
 * @author lucas.mnpaiva
 */
public class BranchOfficeDAO {

    private static PreparedStatement ps = null;
    private static ResultSet rs = null;
    private static boolean retorno = false;
    private static final Connection con = ConnectionManager.getConnection();

    public static boolean create(String name, String address, String cnpj) throws SQLException {

        try {
            String query = "INSERT INTO BRANCH_OFFICE(NAME,CNPJ,ADDRESS) VALUES(?,?,?)";

            ps = con.prepareStatement(query);
            ps.setString(1, name);
            ps.setString(2, cnpj);
            ps.setString(3, address);

            int updatedlines = ps.executeUpdate();

            retorno = updatedlines > 0;

            return retorno;

        } catch (SQLException ex) {
            printSQLException(ex);
        }
        return false;
    }

    public static boolean delete(int id) throws SQLException {
        String query = "DELETE FROM BRANCH_OFFICE WHERE ID_BRANCH_OFFICE=?";

        ps = con.prepareStatement(query);
        ps.setInt(1, id);
        int updatedlines = ps.executeUpdate();
        retorno = updatedlines > 0;
        return retorno;
    }

    public static boolean update(BranchOffice branch) throws Exception {
        try {
            String query = "UPDATE BRANCH_OFFICE SET NAME = ?,CNPJ= ?, ADDRESS =? WHERE ID_BRANCH_OFFICE = ?";

            ps = con.prepareStatement(query);

            ps.setString(1, branch.getName());
            ps.setString(2, branch.getCnpj());
            ps.setString(3, branch.getAddress());
            ps.setInt(4, branch.getId());

            int updatedlines = ps.executeUpdate();

            retorno = updatedlines > 0;

            return retorno;

        } catch (SQLException ex) {
            throw ex;
        }

    }

    public static ArrayList<BranchOffice> read() throws Exception {
        ArrayList<BranchOffice> Branchs = new ArrayList<>();
        try {
            String query = "SELECT * FROM BRANCH_OFFICE";

            ps = con.prepareStatement(query);
            rs = ps.executeQuery();
            if (rs != null) {
                while (rs.next()) {
                    BranchOffice branch = new BranchOffice();
                    branch.setId(rs.getInt("ID_BRANCH_OFFICE"));
                    branch.setName(rs.getString("NAME"));
                    branch.setCnpj(rs.getString("CNPJ"));
                    branch.setAddress((rs.getString("ADDRESS")));
                    Branchs.add(branch);
                }
            }
            return Branchs;
        } catch (SQLException ex) {
            printSQLException(ex);
        }
        return null;
    }

    public static BranchOffice findBydId(int id) {

        try {
            String query = "SELECT * FROM BRANCH_OFFICE WHERE ID_BRANCH_OFFICE = ?";
            ps = con.prepareStatement(query);
            ps.setInt(1, id);

            rs = ps.executeQuery();

            BranchOffice branch = new BranchOffice();
            while (rs.next()) {
                branch.setId(rs.getInt("ID_BRANCH_OFFICE"));
                branch.setName(rs.getString("NAME"));
                branch.setCnpj(rs.getString("CNPJ"));
                branch.setAddress((rs.getString("ADDRESS")));
            }
            return branch;
        } catch (SQLException ex) {
            printSQLException(ex);
        }
        return null;
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
