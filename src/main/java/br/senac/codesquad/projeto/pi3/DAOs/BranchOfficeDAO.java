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

    public static boolean create(String name, String address, String cnpj) throws SQLException {

        try {
            Connection con = ConnectionManager.getConnection();

            String query = "IF NOT EXISTS (SELECT TOP 1 1 FROM BRANCH_OFFICE WHERE NAME like '%?')"
                    + "INSERT"
                    + "       INTO"
                    + "   BRANCH_OFFICE"
                    + "       (NAME,CNPJ,ADDRESS)"
                    + "   VALUES"
                    + "        (?,?,?)  ";
            ps = con.prepareStatement(query);
            ps.setString(1, name);
            ps.setString(2, cnpj);
            ps.setString(3, address);
            int updatedlines = ps.executeUpdate();

            retorno = updatedlines > 0 ? true : false;

            return retorno;

        } catch (Exception ex) {

            throw ex;

        }

    }

    public static boolean delete(int id) throws SQLException {
        Connection con = ConnectionManager.getConnection();
        String query = "DELETE "
                + "         * "
                + "     FROM "
                + "         BRANCH_OFFICE"
                + "     WHERE"
                + "         ID=? ";
        ps = con.prepareStatement(query);
        ps.setInt(1, id);
        int updatedlines = ps.executeUpdate();
        retorno = updatedlines > 0 ? true : false;
        return retorno;
    }

    public static boolean update(BranchOffice Branch) throws Exception {
        try {
            Connection con = ConnectionManager.getConnection();
            String query = "UPDATE"
                    + "       BRANCH_OFFICE"
                    + "   SET"
                    + "       NAME='?',"
                    + "       CNPJ='?'"
                    + "       ADDRESS='?'"
                    + "   WHERE"
                    + "       ID=?";
            ps = con.prepareStatement(query);

            ps.setString(1, Branch.getName());
            ps.setString(2, Branch.getCnpj());
            ps.setString(3, Branch.getAddress());
            ps.setInt(4, Branch.getId());

            int updatedlines = ps.executeUpdate();

            retorno = updatedlines > 0 ? true : false;

            return retorno;

        } catch (Exception ex) {
            throw ex;
        }

    }

    public static ArrayList<BranchOffice> read() throws Exception {
        ArrayList<BranchOffice> Branchs = new ArrayList<BranchOffice>();
        try {
            Connection con = ConnectionManager.getConnection();
            String query = "SELECT "
                    + "       *"
                    + "   FROM"
                    + "       BRANCH_OFFICE";

            rs = ps.executeQuery(query);
            if (rs != null) {
                while (rs.next()) {
                    BranchOffice branch = new BranchOffice();
                    branch.setName(rs.getString("NAME"));
                    branch.setCnpj(rs.getString("CNPJ"));
                    branch.setAddress((rs.getString("ADDRESS")));
                    Branchs.add(branch);
                }
            }

            return Branchs;

        } catch (Exception ex) {
            throw ex;
        }

    }

}
