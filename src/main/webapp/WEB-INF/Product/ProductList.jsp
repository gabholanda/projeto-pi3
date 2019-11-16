<%-- 
    Document   : ProductScreenClient
    Created on : 16/10/2019, 10:20:18
    Author     : hcyrillo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<h2>Lista de Produtos</h2>
<section class="p-5">
    <table class="table">
        <thead>
            <tr>
                <th scope="col">ID</th>
                <th scope="col">Nome</th>
                <th scope="col">Detalhe</th>
                <th scope="col">Preço Venda</th>
                <th scope="col">Preço Compra</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="item" items="${productList}">
                <tr>
                    <th scope="row"><c:out value="${item.id}" /></th>
                    <td><c:out value="${item.nameProduct}"/></td>
                    <td><c:out value="${item.details}"/></td>
                    <td><c:out value="${item.values}"/></td>
                    <td><c:out value="${item.valuesSale}"/></td>
                    <td>
                        <a href="${pageContext.request.contextPath}/product/formEdit?id=<c:out value='${item.id}' />" class="btn btn-secondary">Editar</a>
                        &nbsp;&nbsp;&nbsp;&nbsp;
                        <form method="post" action="/product/delete?id=<c:out value='${item.id}' />">
                            <input type="hidden" name="id" value="${item.id}">
                            <button type="submit" class="btn btn-danger">Deletar</button> 
                        </form>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</section>
<div class="d-flex justify-content-center">
    <a href="${pageContext.request.contextPath}/product/new" class="btn btn-success">Novo produto</a>
</div>