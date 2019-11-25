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

    public static Report generateReport() {
        ArrayList<Product> listaRetorno = new ArrayList<>();
        Connection con = ConnectionManager.getConnection();
        try {
            String query
                    = "select A.ID_SALES,E.NAME,A.VALUE_FULL, C.*, sum(B.AMOUNT_ITEM), D.NAME "
                    + "from sales as A "
                    + "inner join item_ordered as B "
                    + "on A.ID_SALES = B.SALES_ID_SALES "
                    + "inner join product AS C "
                    + "ON B.PRODUCT_ID_PRODUCT = C.ID_PRODUCT "
                    + "INNER JOIN category as D "
                    + "on C.CATEGORY_ID = D.ID_CATEGORY "
                    + "inner join client as E "
                    + "on A.CLIENT_ID_CLIENT = E.ID_CLIENT "
                    + "where A.ID_SALES = 6 "
                    + "group by B.PRODUCT_ID_PRODUCT "
                    + "Order by sum(B.AMOUNT_ITEM) desc "
                    + "limit 10;";
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
        Connection con = ConnectionManager.getConnection();

        try {
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
            reportList = null;
        }
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
