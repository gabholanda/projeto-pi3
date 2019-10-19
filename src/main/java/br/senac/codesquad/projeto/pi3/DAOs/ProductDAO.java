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
public class ProductDAO {

    private static Connection con = ConnectionManager.getConnection();
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
        retorno = updatedlines > 0;
        return retorno;
    }

    public static boolean update(int id, String nameProduct, double value, double valueSale, String details) throws Exception {

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
            ps.setDouble(3, valueSale);
            ps.setString(4, details);

            ps.setInt(5, id);

            int updatedlines = ps.executeUpdate();

            retorno = updatedlines > 0 ? true : false;

            return retorno;

        } catch (Exception ex) {
            throw ex;
        }
    }

    public static boolean save(Product product) {
        try {

            String query
                    = "INSERT"
                    + "       INTO"
                    + "   PRODUCT"
                    + "       (NAME,BUYVALUE,SALEVALUE, DETAILS)"
                    + "   VALUES"
                    + "        (?,?,?,?)  ";
            ps = con.prepareStatement(query);
            ps.setString(1, product.getNameProduct());
            ps.setDouble(2, product.getValues());
            ps.setDouble(3, product.getValuesSale());
            ps.setString(4, product.getDetails());

            int updatedlines = ps.executeUpdate();

            retorno = updatedlines > 0;

            return retorno;

        } catch (SQLException ex) {
            printSQLException(ex);

        }
        return false;
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
