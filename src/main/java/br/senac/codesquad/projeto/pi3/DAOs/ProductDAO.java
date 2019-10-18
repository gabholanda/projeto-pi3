/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.codesquad.projeto.pi3.DAOs;

import br.senac.codesquad.projeto.pi3.application.ConnectionManager;
import br.senac.codesquad.projeto.pi3.models.Product;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author gabriel.hsantos21
 */
public class ProductDAO extends Product{
    
    private static Connection conectionSystem; 
    private static PreparedStatement ps = null;
    private static ResultSet rs = null;
    private static boolean retorno = false;    

    public static Connection getConectionSystem() {
        return conectionSystem;
    }
   

    public static ArrayList<Product> getProduct() throws Exception {
        ArrayList<Product> Products = new ArrayList<Product>();
        try {
            Connection con = ConnectionManager.getConnection();
            String query = "SELECT "
                    + "       *"
                    + "   FROM"
                    + "       PRODUCT";

            rs = ps.executeQuery(query);
            if (rs != null) {
                while (rs.next()) {
                    Product prod = new Product();
                    prod.setNameProduct(rs.getString("NAMEPRODUCT"));
                    prod.setValues(rs.getDouble("VALUES"));
                    prod.setValuesSale(rs.getDouble("VAlUESSALE"));
                    prod.setAmount(rs.getInt("AMOUNT"));
                    prod.setDetails(rs.getString("DETAILS"));
                    prod.setStock(rs.getInt("STOCK"));
                    Products.add(prod);
                }
            }

            return Products;

        } catch (Exception ex) {
            throw ex;
        }
    }

    public static boolean delete() throws Exception {
        //DELETE FROM NOME_DA_TABELA WHERE id = VALOR_DO_ID;
        try {
            Connection con = ConnectionManager.getConnection();
            String query = "DELETE FROM"
                    + "       PRODUCT"
                    + "   WHERE"
                    + "       IDPRODUCT='?'";
            ps = con.prepareStatement(query);
            ps.setInt(1, getId());
            int updatedlines = ps.executeUpdate();

            retorno = updatedlines > 0 ? true : false;

            return true;

        } catch (SQLException ex) {
            throw ex;
        }
    
    }

    public  static boolean update( String nameProduct, double values, double valuesSale, String details, int amount, int stock ) throws Exception {
        try {
            Connection con = ConnectionManager.getConnection();
            String query = "UPDATE"
                    + "       BRANCH_OFFICE"
                    + "   SET"
                    + "       NAMEPRODUCT='?',"
                    + "       VALUES='?',"
                    + "       VALUESSALE='?',"
                    + "       DETAILS='?',"
                    + "       AMOUNT='?',"
                    + "       STOCK"
                    + "   WHERE"
                    + "       ID=?";
            ps = con.prepareStatement(query);
            ps.setString(1, nameProduct);
            ps.setDouble(2, values);
            ps.setDouble(3, valuesSale);
            ps.setInt(4,getId());
            ps.setString(5, details);
            ps.setInt(6, amount);
            ps.setInt(7,stock);
            int updatedlines = ps.executeUpdate();

            retorno = updatedlines > 0 ? true : false;

            return true;

        } catch (Exception ex) {
            throw ex;
        }

    }

    public static boolean create( String nameProduct, double values, double valuesSale, int amount, String details, int stock, int id_branch_office) throws Exception {
       try {
            Connection con = ConnectionManager.getConnection();

            String query = "IF NOT EXISTS (SELECT TOP 1 1 FROM PRODUCT WHERE NAMEPRODUCTSS like '%?')"
                    + "INSERT"
                    + "       INTO"
                    + "   PRODUCT"
                    + "       (NAMEPRODUCT,VALUES,VALUESSALE, AMOUNT, DETAILS, STOKE, ID_BRANCH_OFFICE)"
                    + "VALUES,"
                    + "        (?,?,?,?,?,?,?)  ";
            ps = con.prepareStatement(query);
            ps.setString(1, nameProduct);
            ps.setDouble(2, values);
            ps.setDouble(2, valuesSale);
            ps.setInt(4, amount);
            ps.setString(5, details);
            ps.setInt(6, stock);
            ps.setInt(7, id_branch_office);
            int updatedlines = ps.executeUpdate();

            retorno = updatedlines > 0 ? true : false;

            return retorno;

        } catch (Exception ex) {

            throw ex;

        }

    }
       /* try { 
            
            Class.forName("driver do banco"); 
            conectionSystem
        }
    }
   */ 
}

