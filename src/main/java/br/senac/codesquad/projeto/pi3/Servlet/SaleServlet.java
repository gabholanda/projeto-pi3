/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.codesquad.projeto.pi3.Servlet;

/**
 *
 * @author gabriel.hsantos21
 */
import br.senac.codesquad.projeto.pi3.controllers.ClientController;
import br.senac.codesquad.projeto.pi3.controllers.ProductController;
import br.senac.codesquad.projeto.pi3.controllers.SaleController;
import br.senac.codesquad.projeto.pi3.models.Client;
import br.senac.codesquad.projeto.pi3.models.ItemOrdered;
import br.senac.codesquad.projeto.pi3.models.Product;
import br.senac.codesquad.projeto.pi3.models.Sale;
import br.senac.codesquad.projeto.pi3.models.User;
import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author gabriel.hsantos21
 */
@WebServlet(name = "SaleServlet", urlPatterns = {"/sale/*"})
public class SaleServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
        String action;
        if (request.getPathInfo() == null) {
            action = request.getServletPath();
        } else {
            action = request.getPathInfo();
        }
// Give url paths by servletPath or getPathInfo depending on situation
        try {
            switch (action) {
                case "/sale":
                    read(request, response);
                        break;
                case "/delete":
                    delete(request,response);
                    break;
                case "/update":
                    //update(request, response); aqui tbm
                    break;
                case "/edit":
                    // formEdit(request, response); aqui tbm
                    break;
                case "/new":
                    form(request, response);
                    break;
                case "/create":
                    create(request, response);
                    break;
                case "/searchClient":
                    searchClient(request, response);
                    break;
                case "/addClient":
                    addClient(request, response);
                    break;
                case "/searchProduct":
                    searchProduct(request, response);
                    break;
                case "/addSaleList":
                    addSaleList(request, response);
                    break;
                case "/removeSaleList":
                    removeSaleList(request, response);
                    break;
                case "/changeQuantity":
                    changeQuantity(request, response);
                    break;
                case "/changeDiscount":
                    changeDiscount(request, response);
                    break;
                default:
                    //read(request, response);
                    break;
            }
        } catch (Exception ex) {
            Logger.getLogger(BranchServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

    private static void form(HttpServletRequest request, HttpServletResponse response) {
        try {
            HttpSession session = request.getSession();

            if (session.getAttribute("sale") == null) {
                session.setAttribute("sale",
                        new Sale());
            }
            Sale sale = (Sale) session.getAttribute("sale");
            session.setAttribute("sale", sale);
            String path = "./Sale/SaleCreateJSP.jsp";
            request.setAttribute("path", path);
            RequestDispatcher dispatcher
                    = request.getRequestDispatcher(
                            "/WEB-INF/IndexJSP.jsp");
            dispatcher.forward(request, response);
        } catch (ServletException | IOException ex) {
            Logger.getLogger(SaleServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private static void create(HttpServletRequest request, HttpServletResponse response) {
        try {
            HttpSession session = request.getSession();

            if (session.getAttribute("sale") == null) {
                session.setAttribute("errorSale", "Erro ao tentar realizar venda");
                response.sendRedirect(request.getContextPath() + "/4sale/new");
            } else {
                Sale sale = (Sale) session.getAttribute("sale");
                if (sale.getClient() == null || sale.getItems() == null || sale.getItems().size() <= 0) {
                    session.setAttribute("errorSale", "É necessário ter um cliente selecionado e pelo menos um item na lista");
                    response.sendRedirect(request.getContextPath() + "/sale/new");
                } else {
                    session.setAttribute("errorSale", "");
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
                    Date date = new Date();
                    sdf.format(date);
                    sale.setDate(date);
                    User user = (User) session.getAttribute("user");
                    if (SaleController.create(sale, user)) {
                        clean(request, response);
                        response.sendRedirect(request.getContextPath() + "/sale/new");
                    } else {
                        response.sendRedirect(request.getContextPath() + "/sale/new");
                    }
                }
            }
        } catch (ServletException | IOException ex) {
            Logger.getLogger(SaleServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(SaleServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private static void searchClient(HttpServletRequest request, HttpServletResponse response) {
        try {
            HttpSession session = request.getSession();

            if (session.getAttribute("clientList") == null) {
                session.setAttribute("clientList", new ArrayList<>());
            }
            String name = request.getParameter("name");
            List<Client> clientList = ClientController.findByName(name);
            session.setAttribute("clientList",
                    clientList);
            response.sendRedirect(request.getContextPath() + "/sale/new");
        } catch (IOException ex) {
            Logger.getLogger(SaleServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private static void addClient(HttpServletRequest request, HttpServletResponse response) {
        try {
            HttpSession session = request.getSession();

            if (session.getAttribute("selectedClient") == null) {
                session.setAttribute("selectedClient", new Client());
            }
            // Seto a sale e o cliente que esta comprando
            Sale sale = (Sale) session.getAttribute("sale");
            String id = request.getParameter("clientId");
            session.setAttribute("errorSale", "");
            Client c = ClientController.findById(Integer.parseInt(id));
            if (c == null) {
                // Se o Cliente nao for encontrando, envio uma mensagem para o usuário
                session.setAttribute("errorClient", "Cliente não encontrado");
                response.sendRedirect(request.getContextPath() + "/sale/new");
            } else {
                session.setAttribute("errorClient", "");
                session.setAttribute("errorSale", "");
                sale.setClient(c);
                session.setAttribute("selectedClient", sale.getClient());
                response.sendRedirect(request.getContextPath() + "/sale/new");
            }
        } catch (IOException ex) {
            Logger.getLogger(SaleServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private static void searchProduct(HttpServletRequest request, HttpServletResponse response) {
        try {
            HttpSession session = request.getSession();

            if (session.getAttribute("productList") == null) {
                session.setAttribute("productList", new ArrayList<>());
            }
            String name = request.getParameter("productName");
            List<Product> productList = ProductController.findByName(name);
            session.setAttribute("productList",
                    productList);
            response.sendRedirect(request.getContextPath() + "/sale/new");
        } catch (IOException ex) {
            Logger.getLogger(SaleServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private static void addSaleList(HttpServletRequest request, HttpServletResponse response) {
        try {
            HttpSession session = request.getSession();

            if (session.getAttribute("orderedItemList") == null) {
                session.setAttribute("orderedItemList", new TreeSet<>());
            }
            // Seto a sale e a lista de items da Sale
            Sale sale = (Sale) session.getAttribute("sale");
            sale.setItems((Set<ItemOrdered>) session.getAttribute("orderedItemList"));
            // Busco o produto pelo ID e adiciono a lista, verificando se ela ja nao esta nela
            String productId = request.getParameter("productId");
            Product p = ProductController.findById(Integer.parseInt(productId));
            if (p == null) {
                // Mando uma mensagem informando o erro
                session.setAttribute("errorProduct", "Produto não encontrado");
                response.sendRedirect(request.getContextPath() + "/sale/new");
            } else {
                ItemOrdered item = new ItemOrdered(p.getId(), 1, p.getValuesSale());
                item.setName(p.getNameProduct());
                if (!sale.getItems().contains(item)) {
                    sale.getItems().add(item);
                    sumTotalValue(sale);
                    session.setAttribute("errorProduct", "");
                    response.sendRedirect(request.getContextPath() + "/sale/new");
                } else {
                    response.sendRedirect(request.getContextPath() + "/sale/new");
                }
            }
        } catch (IOException ex) {
            Logger.getLogger(SaleServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private static void removeSaleList(HttpServletRequest request, HttpServletResponse response) {
        try {
            HttpSession session = request.getSession();

            if (session.getAttribute("orderedItemList") == null) {
                session.setAttribute("orderedItemList", new TreeSet<>());
            }
            // Seto a sale e a lista de items da Sale
            Sale sale = (Sale) session.getAttribute("sale");
            sale.setItems((Set<ItemOrdered>) session.getAttribute("orderedItemList"));
            // Busco o produto pelo ID e adiciono a lista, verificando se ela ja nao esta nela
            String productId = request.getParameter("orderedItemId");
            Product p = ProductController.findById(Integer.parseInt(productId));
            if (p == null) {
                // Mando uma mensagem informando o erro
                session.setAttribute("errorProduct", "Produto não encontrado");
                response.sendRedirect(request.getContextPath() + "/sale/new");
            } else {
                ItemOrdered item = new ItemOrdered(p.getId(), 1, p.getValuesSale());
                item.setName(p.getNameProduct());
                if (sale.getItems().contains(item)) {
                    sale.getItems().remove(item);
                    sumTotalValue(sale);
                    session.setAttribute("errorProduct", "");
                    response.sendRedirect(request.getContextPath() + "/sale/new");
                } else {
                    response.sendRedirect(request.getContextPath() + "/sale/new");
                }
            }
        } catch (IOException ex) {
            Logger.getLogger(SaleServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private static void changeQuantity(HttpServletRequest request, HttpServletResponse response) {
        try {
            HttpSession session = request.getSession();

            if (session.getAttribute("orderedItemList") == null) {
                session.setAttribute("orderedItemList", new TreeSet<>());
            }
            // Seto a sale e a lista de items da Sale
            Sale sale = (Sale) session.getAttribute("sale");
            sale.setItems((Set<ItemOrdered>) session.getAttribute("orderedItemList"));
            String id = request.getParameter("orderedItemId");
            String quantity = request.getParameter("itemQuantity");
            if (Integer.parseInt(quantity) <= 0) {
                // Verifiso se a quantidade foi mudada para 0 e mando msg de erro
                session.setAttribute("errorQuantity", "Quantidade não pode ser menor do que 1");
                response.sendRedirect(request.getContextPath() + "/sale/new");
            } else {
                ItemOrdered i = new ItemOrdered();
                i.setId(Integer.parseInt(id));
                i.setQuantityItem(Integer.parseInt(quantity));
                // Verifico qual o item que vai ter a quantidade aumentada pelo ID e depois recalculo o total
                for (ItemOrdered item : sale.getItems()) {
                    if (item.equals(i)) {
                        item.setQuantityItem(i.getQuantityItem());
                        sumTotalValue(sale);
                    }
                }
                response.sendRedirect(request.getContextPath() + "/sale/new");
            }
        } catch (IOException ex) {
            Logger.getLogger(SaleServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private static void changeDiscount(HttpServletRequest request, HttpServletResponse response) {
        try {
            HttpSession session = request.getSession();

            if (session.getAttribute("sale") == null) {
                session.setAttribute("sale", new Sale());
            }
            Sale sale = (Sale) session.getAttribute("sale");
            double discount = Double.parseDouble(request.getParameter("discount"));
            sale.setDiscount(discount / 100);
            session.setAttribute("sale", sale);
            response.sendRedirect(request.getContextPath() + "/sale/new");
        } catch (NumberFormatException | IOException ex) {
            Logger.getLogger(SaleServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private static void sumTotalValue(Sale sale) {
        int soma = 0;
        for (ItemOrdered item : sale.getItems()) {
            soma += item.getValue() * item.getQuantityItem();
        }
        sale.setTotalValue(soma);
    }

    private static void clean(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        session.setAttribute("sale", new Sale());
        session.setAttribute("clientList", new ArrayList<>());
        session.setAttribute("productList", new ArrayList<>());
        session.setAttribute("orderedItemList", new TreeSet<>());
        session.setAttribute("selectedClient", new Client());
        session.setAttribute("errorSale", "");
    }
    
    private void read(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException, Exception {
        try {
            HttpSession session = request.getSession();
//            User user = (User) session.getAttribute("user");

            ArrayList<Sale> saleList = SaleController.read();
            String path = "./Sale/SaleList.jsp";
            request.setAttribute("saleList", saleList);
            request.setAttribute("path", path);
            RequestDispatcher dispatcher
                    = request.getRequestDispatcher(
                            "/WEB-INF/IndexJSP.jsp");
            dispatcher.forward(request, response);
        } catch (IOException | ServletException ex) {
            Logger.getLogger(SaleServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void delete(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {

        try {
            String id = request.getParameter("id");
            request.setAttribute("id", id);

            SaleController.delete(Integer.parseInt(id));
            searchClient(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(SaleServlet.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
