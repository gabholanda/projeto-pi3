<%-- 
    Document   : SaleList
    Created on : 21/11/2019, 23:16:43
    Author     : patrickchagas
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<link href="${pageContext.request.contextPath}/css/sale.css" rel="stylesheet">

<h2>Lista de Vendas</h2>
<section class="p-5">
    <div class="top-body">
        <table class="table">
            <thead>
                <tr>
                    <th scope="col">ID</th>
                    <th scope="col">Data</th>
                    <th scope="col">Cliente</th>
                    <th scope="col">Valor Total</th>
                    <th scope="col">Opções</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="sale" items="${saleList}">
                    <tr>
                        <th scope="row"><c:out value="${sale.id}" /></th>
                        <td><c:out value="${sale.date.toString()}"/></td>
                        <td><c:out value="${sale.client.name}"/></td>
                        <td><c:out value="${sale.totalValue}"/></td>
                        <td class="d-flex">
                            <a href="${pageContext.request.contextPath}/sale/edit?id=<c:out value='${user.id}' />" class="btn btn-secondary">Editar</a>
                            &nbsp;&nbsp;&nbsp;&nbsp;
                            <form method="post" action="${pageContext.request.contextPath}/sale/delete?id=<c:out value='${sale.id}' />">
                                <input type="hidden" name="id" value="${sale.id}">
                                <button type="submit" class="btn btn-danger">Deletar</button> 
                            </form>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>
</section>
<div class="d-flex justify-content-center">
    <a href="${pageContext.request.contextPath}/sale/new" class="btn btn-success"   >Nova venda</a>
</div>
