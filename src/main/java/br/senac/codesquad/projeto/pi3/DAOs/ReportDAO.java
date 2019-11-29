/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.codesquad.projeto.pi3.DAOs;

import br.senac.codesquad.projeto.pi3.application.ConnectionManager;
import br.senac.codesquad.projeto.pi3.models.BranchOffice;
import br.senac.codesquad.projeto.pi3.models.ItemOrdered;
import br.senac.codesquad.projeto.pi3.models.Report;
import br.senac.codesquad.projeto.pi3.models.Sale;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author gabriel.hsantos21
 */
public class ReportDAO {

    private static PreparedStatement ps = null;
    private static ResultSet rs = null;
    private static Connection con;

    public static Report generateReport(int idBranch) {
        Report report = new Report();
        try {
            con = ConnectionManager.getConnection();
            String query
                    = "select "
                    + "p.NAMEPRODUCT as Produto, "
                    + "COUNT(IO.PRODUCT_ID_PRODUCT) as Vendas, "
                    + "SUM(IO.AMOUNT_ITEM) as ItensVendidos, "
                    + "SUM(IO.AMOUNT_ITEM)* IO.VALUE as ValorTotal, "
                    + "rpb.BRANCH_OFFICE_ID_BRANCH_OFFICE as BranchOfficeID, "
                    + "p.salevalue, "
                    + "s.DATE_SALE as DataVenda "
                    + "from item_ordered as IO "
                    + "inner join product as p "
                    + "on IO.PRODUCT_ID_PRODUCT= p.ID_Product "
                    + "inner join relation_product_and_branch_office rpb "
                    + "on rpb.PRODUCT_ID_PRODUCT = p.ID_Product "
                    + "inner join sales s on IO.SALES_ID_SALES = s.ID_SALES "
                    + "where rpb.BRANCH_OFFICE_ID_BRANCH_OFFICE = ? and  s.DATE_SALE >= cast(subtime(current_date,3) as date) "
                    + "group by Produto order by ItensVendidos  desc limit 10;";
            ps = con.prepareStatement(query);
            ps.setInt(1, idBranch);
            rs = ps.executeQuery();
            if (rs != null) {
                while (rs.next()) {
                    //setting top 10 items
                    ItemOrdered item = new ItemOrdered();
                    item.setName(rs.getString("produto"));
                    item.setQuantityItem(rs.getInt("itensvendidos"));
                    item.setValue(rs.getDouble("salevalue"));
                    report.getItemList().add(item);
                }
                DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
                LocalDate date = LocalDate.now();
                report.setInitialDateReport(dtf.format(date));
            }
            return report;
        } catch (SQLException e) {
            printSQLException(e);
        }
        return report;
    }

    //to com muito sono olhar isso aqui depois 
    public static Report generateReportTotalBranch() throws SQLException {
        Report report = new Report();
        try {
            con = ConnectionManager.getConnection();
            String query = "SELECT "
                    + "BO.NAME as Name, "
                    + "SUM(S.VALUE_FULL) AS ValorTotal "
                    + "FROM sales as S "
                    + "inner join branch_office as BO "
                    + "on BO.ID = S.BRANCH_OFFICE_ID_BRANCH_OFFICE "
                    + "WHERE S.DATE_SALE >= cast(subtime(current_date,3) as date) "
                    + "group by Name order by ValorTotal desc;";
            ps = con.prepareStatement(query);
            rs = ps.executeQuery();

            if (rs != null) {
                while (rs.next()) {
                    BranchOffice branch = new BranchOffice();
                    branch.setTotalValue(rs.getDouble("valortotal"));
                    branch.setName(rs.getString("name"));
                    report.getBranchList().add(branch);
                }
                return report;
            }
        } catch (SQLException ex) {
            printSQLException(ex);
            con.close();
            report = null;
        }
        con.close();
        return report;

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
