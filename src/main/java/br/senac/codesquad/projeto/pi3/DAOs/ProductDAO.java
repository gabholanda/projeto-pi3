package br.senac.codesquad.projeto.pi3.DAOs;

import br.senac.codesquad.projeto.pi3.application.ConnectionManager;
import br.senac.codesquad.projeto.pi3.models.Category;
import br.senac.codesquad.projeto.pi3.models.Product;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
            String query = "SELECT "
                    + "A.ID_PRODUCT, "
                    + "A.NAMEPRODUCT, "
                    + "A.BUYVALUE, "
                    + "A.SALEVALUE, "
                    + "A.DETAILS, "
                    + "C.NAME, "
                    + "B.AMOUNT "
                    + "FROM (product AS A INNER JOIN relation_product_and_branch_office AS B ON (A.ID_PRODUCT = B.PRODUCT_ID_PRODUCT)) "
                    + "INNER JOIN category as C ON (A.CATEGORY_ID = C.ID_CATEGORY) ORDER BY A.NAMEPRODUCT";

            ps = con.prepareStatement(query);
            rs = ps.executeQuery(query);
            if (rs != null) {
                while (rs.next()) {
                    Product product = new Product();
                    product.setId(rs.getInt(1));
                    product.setNameProduct(rs.getString(2));
                    product.setValues(rs.getDouble(3));
                    product.setValuesSale(rs.getDouble(4));
                    product.setDetails(rs.getString(5));
                    product.setCategoryName(rs.getString(6));
                    product.setQuantity(rs.getInt(7));
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

    public static boolean update(Product p)
            throws SQLException {

        try {
            String query = "UPDATE product SET NAMEPRODUCT =?,BUYVALUE =?, SALEVALUE=?, DETAILS =?, CATEGORY_ID WHERE ID_PRODUCT = ?";
            ps = con.prepareStatement(query);

            ps.setString(1, p.getNameProduct());
            ps.setDouble(2, p.getValues());
            ps.setDouble(3, p.getValuesSale());
            ps.setString(4, p.getDetails());
            ps.setInt(5, p.getCategoryId());
            ps.setInt(5, p.getId());

            int updatedlines = ps.executeUpdate();

            retorno = updatedlines > 0;

            return retorno;
        } catch (SQLException ex) {
            throw ex;
        }
    }

    public static boolean create(Product p, int quantity) {
        try {

            String query
                    = "INSERT INTO product"
                    + "(NAMEPRODUCT, BUYVALUE, SALEVALUE, DETAILS, CATEGORY_ID)"
                    + "VALUES (?,?,?,?,?);";
            ps = con.prepareStatement(query);
            ps.setString(1, p.getNameProduct());
            ps.setDouble(2, p.getValues());
            ps.setDouble(3, p.getValuesSale());
            ps.setString(4, p.getDetails());

            ps.setInt(5, p.getCategoryId());
            int updatedlines = ps.executeUpdate();
            String queryBranch
                    = "INSERT INTO relation_product_and_branch_office"
                    + "(BRANCH_OFFICE_ID_BRANCH_OFFICE, PRODUCT_ID_PRODUCT, AMOUNT)"
                    + "VALUES (?,(select last_insert_id() as product),?);";
            ps = con.prepareStatement(queryBranch);
            ps.setInt(1, p.getIdBranchOffice());
            ps.setInt(2, quantity);
            updatedlines = ps.executeUpdate();
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
                product.setCategoryId(rs.getInt("CATEGORY_ID"));
            }
            return product;
        } catch (SQLException ex) {
            printSQLException(ex);
        }
        return null;
    }

    public static List<Product> findByName(String name) {
        try {
            String query = "SELECT * FROM product WHERE NAMEPRODUCT LIKE ?";
            ps = con.prepareStatement(query);
            ps.setString(1, "%" + name + "%");

            rs = ps.executeQuery();

            List<Product> productList = new ArrayList<>();
            if (rs != null) {
                while (rs.next()) {
                    Product product = new Product();
                    product.setId(rs.getInt("ID_PRODUCT"));
                    product.setNameProduct(rs.getString("NAMEPRODUCT"));
                    product.setValues(rs.getDouble("BUYVALUE"));
                    product.setValuesSale(rs.getDouble("SALEVALUE"));
                    product.setDetails(rs.getString("DETAILS"));
                    //product.setIdBranchOffice("ID_BRANCH_OFFICE");
                    productList.add(product);
                }
            }
            return productList;
        } catch (SQLException ex) {
            printSQLException(ex);
        }
        return null;
    }

    public static List<Category> findCategoryName() throws SQLException {
        try {
            String query = "SELECT * FROM category AS C";
            ps = con.prepareStatement(query);
            rs = ps.executeQuery();
            List<Category> list = new ArrayList<>();
            if (rs != null) {
                while (rs.next()) {
                    Category category = new Category();
                    category.setId(rs.getInt("ID_CATEGORY"));
                    category.setName(rs.getString("NAME"));
                    list.add(category);
                }
            }
            return list;
        } catch (SQLException ex) {
            printSQLException(ex);
        }
        return null;
    }
}
