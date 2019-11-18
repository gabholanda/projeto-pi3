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

    private static PreparedStatement ps = null;
    private static ResultSet rs = null;
    private static boolean retorno = false;
    private static final Connection con = ConnectionManager.getConnection();

    public static ArrayList<Product> getProduct()
            throws Exception {
        ArrayList<Product> Product = new ArrayList<>();
        try {
            String query = "SELECT * FROM product";

            ps = con.prepareStatement(query);
            rs = ps.executeQuery(query);
            if (rs != null) {
                while (rs.next()) {
                    Product product = new Product();
                    product.setId(rs.getInt("ID_PRODUCT"));
                    product.setNameProduct(rs.getString("NAMEPRODUCT"));
                    product.setValues(rs.getDouble("BUYVALUE"));
                    product.setValuesSale(rs.getDouble("SALEVALUE"));
                    product.setDetails(rs.getString("DETAILS"));
                    product.setQuantidade(rs.getInt("QUANTIDADE"));
                    Product.add(product);
                }
            }
            return Product;

        } catch (SQLException ex) {
            throw ex;
        }

    }

    public static boolean delete(int id)
            throws SQLException {

        String query = "DELETE FROM product WHERE ID_PRODUCT=? ";

        ps = con.prepareStatement(query);
        ps.setInt(1, id);
        int updatedlines = ps.executeUpdate();
        retorno = updatedlines > 0;
        return retorno;
    }

    public static boolean update(int id, String nameProduct, double values, double valueSale, String details, int quantidade)
            throws SQLException {

        try {
            String query = "UPDATE product SET NAMEPRODUCT =?,BUYVALUE =?, SALEVALUE=?, DETAILS =?, QUANTIDADE =? WHERE ID_PRODUCT = ?";

            ps = con.prepareStatement(query);

            ps.setString(1, nameProduct);
            ps.setDouble(2, values);
            ps.setDouble(3, valueSale);
            ps.setString(4, details);
            ps.setInt(5, quantidade);
            ps.setInt(6, id);

            int updatedlines = ps.executeUpdate();

            retorno = updatedlines > 0;

            return retorno;
        } catch (SQLException ex) {
            throw ex;
        }
    }

    public static boolean create(String nameProduct, double values, double valueSale, String details, int quantidade) {
        try {

            String query
                    = "INSERT INTO product (NAMEPRODUCT, BUYVALUE, SALEVALUE, DETAILS, QUANTIDADE) VALUES (?,?,?,?,?)";
            ps = con.prepareStatement(query);
            ps.setString(1, nameProduct);
            ps.setDouble(2, values);
            ps.setDouble(3, valueSale);
            ps.setString(4, details);
            ps.setInt(5, quantidade);

            int updatedlines = ps.executeUpdate();

            retorno = updatedlines > 0;

            return retorno;

        } catch (SQLException ex) {
            printSQLException(ex);

        }
        return false;
    }
// Method that helps to print SQL exceptions on console

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

    public static Product findBydId(int id) {
        try {
            String query = "SELECT * FROM product WHERE ID_PRODUCT = ?";
            ps = con.prepareStatement(query);
            ps.setInt(1, id);

            rs = ps.executeQuery();

            Product product = new Product();
            while (rs.next()) {
                product.setId(rs.getInt("ID_PRODUCT"));
                product.setNameProduct(rs.getString("NAMEPRODUCT"));
                product.setValues(rs.getDouble("BUYVALUE"));
                product.setValuesSale((rs.getDouble("SALEVALUE")));
                product.setDetails(rs.getString("DETAILS"));
                product.setQuantidade(rs.getInt("QUANTIDADE"));
            }
            return product;
        } catch (SQLException ex) {
            printSQLException(ex);
        }
        return null;
    }
}
