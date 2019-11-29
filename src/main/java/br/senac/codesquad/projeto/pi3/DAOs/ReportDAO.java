/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.codesquad.projeto.pi3.DAOs;

import br.senac.codesquad.projeto.pi3.application.ConnectionManager;
import br.senac.codesquad.projeto.pi3.models.Product;
import br.senac.codesquad.projeto.pi3.models.Report;
import br.senac.codesquad.projeto.pi3.models.Sale;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author gabriel.hsantos21
 */
public class ReportDAO {

    private static PreparedStatement ps = null;
    private static ResultSet rs = null;
    private static boolean retorno = false;
    private static Connection con;

    public static Report generateReport() {
        ArrayList<Product> listaRetorno = new ArrayList<>();
        try {
            con = ConnectionManager.getConnection();
            String query
                    = "select\n"
                    + "p.NAMEPRODUCT as Produto, "
                    + "COUNT(IO.PRODUCT_ID_PRODUCT) as Vendas, "
                    + "SUM(IO.AMOUNT_ITEM) as ItensVendidos, "
                    + "SUM(IO.AMOUNT_ITEM)* IO.VALUE as ValorTotal, "
                    + "rpb.BRANCH_OFFICE_ID_BRANCH_OFFICE as BranchOfficeID "
                    + " from item_ordered as IO "
                    + " inner join product as p "
                    + " on IO.PRODUCT_ID_PRODUCT= p.ID_Product "
                    + " inner join relation_product_and_branch_office rpb "
                    + " on rpb.PRODUCT_ID_PRODUCT = p.ID_Product "
                    + " where rpb.BRANCH_OFFICE_ID_BRANCH_OFFICE = ? "
                    + "  group by Produto order by ItensVendidos  desc limit 10;";
            ps = con.prepareStatement(query);
            rs = ps.executeQuery();
            if (rs != null) {
                while (rs.next()) {
                    Product p = new Product();
                    String teste = rs.getString("ID_SALES");
                    teste = rs.getString("NAME");
                    teste = rs.getString("VALUE_FULL");
                    teste = rs.getString("AMOUNT_ITEM");
                    teste = rs.getString("NAME");
                }
            } else {
                con.close();
                throw new SQLException();
            }
        } catch (SQLException e) {
            printSQLException(e);
            listaRetorno = null;
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                printSQLException(e);
                listaRetorno = null;
            }
        }
        return null;
    }

    //to com muito sono olhar isso aqui depois 
    public static ArrayList<Report> generateReportTotalBranch(int idbranchs) throws SQLException {
        ArrayList<Report> reportList = new ArrayList<>();
        try {
            con = ConnectionManager.getConnection();
            String query = "quero a querry disso";
            ps = con.prepareStatement(query);
            rs = ps.executeQuery();

            if (rs != null) {
                while (rs.next()) {
                    Report report = new Report();
                    String productL = rs.getString("NAMEBRANCH");
                    productL = rs.getString("TOTALVALUEBRANCH");
                    reportList.add(report);
                }

            } else {
                throw new SQLException();
            }
        } catch (SQLException ex) {
            con.close();
            reportList = null;
        }
        con.close();
        return reportList;

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
