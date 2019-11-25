<%-- 
    Document   : ProductScreenClient
    Created on : 16/10/2019, 10:20:18
    Author     : hcyrillo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<link href="${pageContext.request.contextPath}/css/product.css" rel="stylesheet">
<body style="position: relative">
    <div class="jumbotron">
        <h2>Lista de Produtos</h2>
    </div>
    <section class="p-5">
        <form method="post" action="${pageContext.request.contextPath}/product/searchProduct">
            <input type="text" placeholder="Pesquise pelo nome ..." name="productName">
            <button type="submit" class="btn btn-secondary">Pesquisar</button>
        </form>
        <div class="top-body">
            <table class="table">
                <thead>
                    <tr>
                        <th scope="col">ID</th>
                        <th scope="col">Nome</th>
                        <th scope="col">Detalhes</th>
                        <th scope="col">Preço Compra(R$)</th>
                        <th scope="col">Preço Venda(R$)</th>
                        <th scope="col">Categoria</th>
                        <th scope="col">Quantidade</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="product" items="${sessionScope.productList}">
                        <tr>
                            <th scope="row"><c:out value="${product.id}" /></th>
                            <td><c:out value="${product.nameProduct}"/></td>
                            <td><c:out value="${product.details}"/></td>
                            <td><c:out value="${product.values}"/></td>
                            <td><c:out value="${product.valuesSale}"/></td>    
                            <td><c:out value="${product.categoryName}"/></td>
                            <td><c:out value="${product.quantity}"/></td>

                            <td class="d-flex">
                                <a href="${pageContext.request.contextPath}/product/edit?id=<c:out value='${product.id}' />" class="btn btn-secondary">Editar</a>
                                &nbsp;&nbsp;&nbsp;&nbsp;
                                <form method="post" action="${pageContext.request.contextPath}/product/delete?id=<c:out value='${product.id}' />">
                                    <input type="hidden" name="id" value="${product.id}">
                                    <button type="submit" class="btn btn-danger">Deletar</button> 
                                </form>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
         
        <div class="d-flex justify-content-center" >
            <a href="${pageContext.request.contextPath}/product/new" class="btn btn-success">Novo produto</a>
        </div>
         
    </section>
</body>