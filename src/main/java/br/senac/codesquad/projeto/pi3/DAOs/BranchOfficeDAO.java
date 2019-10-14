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
 * @author gabriel.hsantos21
 */
public class BranchOfficeDAO {

    private static PreparedStatement ps = null;
    private static ResultSet rs = null;
    private static boolean retorno = false;

    public static boolean create(String name, String cnpj) throws SQLException {

        try {
            Connection con = ConnectionManager.getConnection();

            String query = "IF NOT EXISTS (SELECT TOP 1 1 FROM BRANCH_OFFICE WHERE NAME like '%?')"
                    + "INSERT"
                    + "       INTO"
                    + "   BRANCH_OFFICE"
                    + "       (NAME,CNPJ)"
                    + "   VALUES"
                    + "        (?,?)  ";
            ps = con.prepareStatement(query);
            ps.setString(1, name);
            ps.setString(2, cnpj);
            int updatedlines = ps.executeUpdate();

            retorno = updatedlines > 0 ? true : false;

            return retorno;

        } catch (Exception ex) {

            throw ex;

        }

    }

    public static boolean delete() {
        String query = "";
        return true;
    }

    public static boolean update(String ID, String name, String cnpj) throws Exception {
        try {
            Connection con = ConnectionManager.getConnection();
            String query = "UPDATE"
                    + "       BRANCH_OFFICE"
                    + "   SET"
                    + "       NAME='?',"
                    + "       CNPJ='?'"
                    + "   WHERE"
                    + "       ID=?";
            ps = con.prepareStatement(query);

            ps.setString(1, name);
            ps.setString(2, cnpj);
            ps.setString(3, ID);

            int updatedlines = ps.executeUpdate();

            retorno = updatedlines > 0 ? true : false;

            return true;

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
                    branch.setAdress((rs.getString("ADDRESS")));
                    Branchs.add(branch);
                }
            }

            return Branchs;

        } catch (Exception ex) {
            throw ex;
        }

    }

}
