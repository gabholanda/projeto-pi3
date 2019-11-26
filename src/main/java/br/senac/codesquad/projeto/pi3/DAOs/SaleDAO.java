/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.codesquad.projeto.pi3.DAOs;

import br.senac.codesquad.projeto.pi3.application.ConnectionManager;
import br.senac.codesquad.projeto.pi3.models.Client;
import br.senac.codesquad.projeto.pi3.models.ItemOrdered;
import br.senac.codesquad.projeto.pi3.models.Sale;
import br.senac.codesquad.projeto.pi3.models.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author gabriel.hsantos21
 */
public class SaleDAO {

    private static PreparedStatement ps = null;
    private static ResultSet rs = null;
    private static boolean retorno = false;

    public static ArrayList<Sale> getSales() {
        ArrayList<Sale> listaRetorno = new ArrayList<>();
        Connection con = ConnectionManager.getConnection();
        try {
            String query = "SELECT A.ID_SALES, A.DATE_SALE, B.NAME, A.VALUE_FULL "
                    + "FROM sales A "
                    + "INNER JOIN client AS B "
                    + "ON A.CLIENT_ID_CLIENT = B.ID_CLIENT;";
            ps = con.prepareStatement(query);
            rs = ps.executeQuery();
            
            if (rs != null) {
                while (rs.next()) {
                    Sale s = new Sale();
                    Client c = new Client();
                    s.setId(rs.getInt("ID_SALES"));
                    s.setDate((Date) rs.getObject("DATE_SALE"));
                    c.setName((String) rs.getObject("NAME"));
                    s.setClient(c); 
                    s.setTotalValue(rs.getDouble("VALUE_FULL"));
                    listaRetorno.add(s);
                    
                }
            } else {
                throw new SQLException();
            }
        } catch (SQLException e) {
            listaRetorno = null;
        } finally {
            try {
                con.close();
            } catch (SQLException ex) {
                listaRetorno = null;
            }
        }

        return listaRetorno;

    }

    public static boolean delete(int id) throws SQLException {
        Connection con = ConnectionManager.getConnection();
        try {
            String query
                    = "DELETE FROM SALES WHERE salesID= ?";
            ps = con.prepareStatement(query);
            ps.setInt(1, id);
            int updatedlines = ps.executeUpdate();

            retorno = updatedlines > 0;
        } catch (SQLException ex) {
            throw ex;
        } finally {
            try {
                con.close();
            } catch (SQLException ex) {
                retorno = false;
            }
        }
        return retorno;
    }

    public static boolean update(Sale sale) throws SQLException {
        Connection con = ConnectionManager.getConnection();
        try {
            String query
                    = "INSERT"
                    + "       INTO"
                    + "   SALES"
                    + "       (TOTALVALUE, CLIENTID)"
                    + "   VALUES"
                    + "        (?,?)  ";
            ps = con.prepareStatement(query);
            ps.setDouble(1, sale.getTotalValue());
            int updatedlines = ps.executeUpdate();

            retorno = updatedlines > 0;
        } catch (SQLException ex) {
            throw ex;
        } finally {
            try {
                con.close();
            } catch (SQLException ex) {
                retorno = false;
            }
        }
        return retorno;
    }

    public static boolean create(Sale sale, User user) throws Exception {
        Connection con = ConnectionManager.getConnection();
        try {
            String query
                    = "insert into sales "
                    + "(VALUE_FULL, "
                    + "USER_ID_USER, "
                    + "CLIENT_ID_CLIENT, "
                    + "BRANCH_OFFICE_ID_BRANCH_OFFICE, "
                    + "DATE_SALE) "
                    + "values "
                    + "(?, ?, ?, ?, ?);";
            ps = con.prepareStatement(query);
            Date dt = new Date();
            SimpleDateFormat sdf
                    = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String currentTime = sdf.format(dt);
            ps.setDouble(1, sale.getTotalValue());
            ps.setInt(2, user.getId());
            ps.setInt(3, sale.getClient().getId());
            ps.setInt(4, user.getIdBranch());
            ps.setString(5, currentTime);
            int updatedlines = ps.executeUpdate();

            if (updatedlines > 0) {
                String queryIdSales = "select last_insert_id() as ID_SALES;";
                ps = con.prepareStatement(queryIdSales);
                rs = ps.executeQuery();
                int idSalves = 0;
                while (rs.next()) {
                    idSalves = rs.getInt("ID_SALES");
                }
                for (ItemOrdered item : sale.getItems()) {
                    String queryItems
                            = "INSERT INTO item_ordered "
                            + "(AMOUNT_ITEM, "
                            + "VALUE, "
                            + "SALES_ID_SALES, "
                            + "PRODUCT_ID_PRODUCT) "
                            + "values "
                            + "(?, ?, ?, ?);";
                    ps = con.prepareStatement(queryItems);
                    ps.setInt(1, item.getQuantityItem());
                    ps.setDouble(2, item.getValue());
                    ps.setInt(3, idSalves);
                    ps.setInt(4, item.getId());
                    updatedlines = ps.executeUpdate();
                }
            }

            retorno = updatedlines > 0;
        } catch (SQLException ex) {
            throw ex;
        } finally {
            try {
                con.close();
            } catch (SQLException ex) {
                retorno = false;
            }
        }
        return retorno;
    }
}
