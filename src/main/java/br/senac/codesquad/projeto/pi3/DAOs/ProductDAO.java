package br.senac.codesquad.projeto.pi3.DAOs;

import br.senac.codesquad.projeto.pi3.application.ConnectionManager;
import br.senac.codesquad.projeto.pi3.models.Product;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author gabriel.hsantos21
 */
public class ProductDAO {

    private static Connection connection;

    public static ArrayList<Product> getProduct() throws SQLException {

        ArrayList<Product> Products = new ArrayList<>();

        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public static boolean delete(int id) {

        boolean returnn = false;

        /*  try {
            Class.forName(DRIVER);
            connection = DriverManager.getConnection(URL, LOGIN, SENHA);
            PreparedStatement comand = connection.prepareStatement("DELETE FROM CLIENT WHERE ID_PRODUCT=?");
                    
            comand.setInt(1, id);
            int lineserror = comand.executeUpdate();
            if (lineserror > 0) {
                returnn = true;
            } else {
                returnn = false;
            }
        } catch (SQLException ex) {
            returnn = false;
        } finally {
            try {
                connection.close();
            } catch (SQLException ex) {
                returnn = false;
            }
        }
        return returnn;
    }*/
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public static boolean update(Product product) {

        boolean returnn = false;

        /*   try { 
            
            Class.forName(DRIVER); 
            connection = DriverManager.getConnection(URL, LOGIN, SENHA); 
            
            PreparedStatement comand = connection.prepareStatement("UPDATE PRODUCT SET "
                    + "NAME=?, AMOUNT=?, VALUES=?, VALUESSALE=?, DETAILS=?"); 
            
            comand.setString(1, product.getNameProduct());
            comand.setInt(2, product.getAmount());
            comand.setDouble(3, product.getValues());
            comand.setDouble(4, product.getValeusSale());
            comand.setString(5, product.getDetails());
            
            int lineserror = comand.executeUpdate(); 
            
             if (lineserror > 0) {
                returnn = true;
            } else {
                returnn = false;
            }
        } catch (SQLException ex) {
            returnn = false;
        } finally { 
            try { 
                connection.close();
            } catch (SQLException ex){ 
                returnn = false; 
            }
        }
        
        return returnn; 
        }  */
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public static boolean save(Product product) {
        boolean returnn = false;

        /*  try {
            Class.forName(DRIVER);
            connection = DriverManager.getConnection(URL, LOGIN, SENHA);
        
            PreparedStatement comand = connection.prepareStatement("INSERT INTO PRODUCT "
                    + "(NAME, AMOUNT, VALUES, VALUESSALE, DETAILS)"
                    + "VALUES(?,?,?,?,?,)");
            comand.setString(1, product.getNameProduct());
            comand.setInt(2, product.getAmount());
            comand.setDouble(3, product.getValues());
            comand.setDouble(4, product.getValeusSale());
            comand.setString(5, product.getDetails());
            int lineserror = comand.executeUpdate();
            if (lineserror > 0) {
                returnn = true;
            } else {
                returnn = false;
            }
        } catch (SQLException ex) {
            returnn = false;
        } finally {
            try {
                connection.close();
            } catch (SQLException ex) {
                returnn = false;
            }
        }
        return returnn; */
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
