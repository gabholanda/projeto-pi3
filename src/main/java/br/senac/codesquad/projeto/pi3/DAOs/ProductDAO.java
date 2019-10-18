package br.senac.codesquad.projeto.pi3.DAOs;

import br.senac.codesquad.projeto.pi3.application.ConnectionManager;
import br.senac.codesquad.projeto.pi3.models.Product;
import static br.senac.codesquad.projeto.pi3.models.Product.getId;
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
    private static PreparedStatement ps = null;
    private static ResultSet rs = null;
    private static boolean retorno = false; 
    public static ArrayList<Product> getProduct() throws Exception {
        ArrayList<Product> Product = new ArrayList<Product>();
        try {
            Connection con = ConnectionManager.getConnection();
            String query = "SELECT "
                    + "       *"
                    + "   FROM"
                    + "       BRANCH_OFFICE";

            rs = ps.executeQuery(query);
            if (rs != null) {
                while (rs.next()) {
                    Product product = new Product();
                    product.setNameProduct(rs.getString("NAME"));
                    product.setValues(rs.getDouble("VALUE"));
                    product.setValuesSale(rs.getDouble("VALUESALE"));
                    product.setAmount(rs.getInt("AMOUNT"));
                    product.setDetails(rs.getString("DETAILS"));
                    Product.add(product);
                }
            }

            return Product;

        } catch (Exception ex) {
            throw ex;
        }
      
    }

    public static boolean delete() throws SQLException {

      Connection con = ConnectionManager.getConnection();
        String query = "DELETE "
                + "         * "
                + "     FROM "
                + "         BRANCH_OFFICE"
                + "     WHERE"
                + "         ID=? ";
        ps = con.prepareStatement(query);
        ps.setInt(1, getId());
        int updatedlines = ps.executeUpdate();
        retorno = updatedlines > 0 ? true : false;
        return retorno;
    }
    public static boolean update( int id,String nameProduct, double value, double valueSale, int amount, int stock,String details) throws Exception {

        boolean returnn = false;

        try {
            Connection con = ConnectionManager.getConnection();
            String query = "UPDATE"
                    + "       BRANCH_OFFICE"
                    + "   SET"
                    + "       NAME_PRODUCT='?',"
                    + "       VALUE='?'"
                    + "       VALUESALE='?'"
                    + "       DETAILS='?',"
                    + "       AMOUNT='?'"
                    + "       STOKE='?'"
                    + "   WHERE"
                    + "       ID_PRODUCT=?";
            ps = con.prepareStatement(query);

            ps.setString(1, nameProduct);
            ps.setDouble(2, value);
            ps.setDouble(2, valueSale);
            ps.setString(3, details);
            ps.setInt(4, amount);
            ps.setInt(5, stock);
            ps.setInt(6,id);

            int updatedlines = ps.executeUpdate();

            retorno = updatedlines > 0 ? true : false;

            return retorno;

        } catch (Exception ex) {
            throw ex;
        }
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
