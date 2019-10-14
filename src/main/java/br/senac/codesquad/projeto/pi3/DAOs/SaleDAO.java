/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.codesquad.projeto.pi3.DAOs;

import br.senac.codesquad.projeto.pi3.application.ConnectionManager;
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
public class SaleDAO {

    private static PreparedStatement ps = null;
    private static ResultSet rs = null;
    private static boolean retorno = false;

    public static ArrayList<Sale> getSales() {
        ArrayList<Sale> listaRetorno = new ArrayList<>();
        Connection con = ConnectionManager.getConnection();
        try {
            String query
                    = "SELECT * FROM PRODUCT";
            //Carrego o driver para acesso ao banco
            //Monto a URL
            PreparedStatement comando = con.prepareStatement(query);

            ResultSet rs = comando.getResultSet();

            if (rs != null) {
                while (rs.next()) {
                    Sale s = new Sale();
                    s.setId(rs.getInt("id"));
                    s.setClientId(rs.getInt("clientId"));
                    s.setDate(rs.getDate("createDate"));
                    s.setTotalValue(rs.getDouble("totalValue"));
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
                    = "DELETE"
                    + "       FROM"
                    + "   SALES"
                    + "       WHERE"
                    + "   salesId =(?)";
            ps = con.prepareStatement(query);
            ps.setInt(1, id);
            int updatedlines = ps.executeUpdate();

            retorno = updatedlines > 0 ? true : false;
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
            ps.setInt(2, sale.getClientId());
            int updatedlines = ps.executeUpdate();

            retorno = updatedlines > 0 ? true : false;
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

    public static boolean create(Sale sale) throws Exception {
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
            ps.setInt(2, sale.getClientId());
            int updatedlines = ps.executeUpdate();

            retorno = updatedlines > 0 ? true : false;
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
