<%-- 
    Document   : ReportManager
    Created on : 18/11/2019, 21:14:11
    Author     : marcelo.smoraes2
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<link href="${pageContext.request.contextPath}/css/report.css" rel="stylesheet">
<section class="p-4"">
    <div class="d-flex justify-content-center">
        <form method="post" action="${pageContext.request.contextPath}/report/generate">
            <input type="submit" value="Gerar Relatório" class="btn btn-success">
        </form>
    </div>
    <div class="d-flex justify-content-center flex-column mt-5">
        <h5>Total da Filial</h5>
        <h6>R$ 500000,00</h6>
        <h4>Os 10 mais vendidos</h4>
        <table class="table table-hover table-dark">
            <thead>
                <tr>
                    <th scope="col">Id</th>
                    <th scope="col">Nome</th>
                    <th scope="col">Preço(R$)</th>
                    <th scope="col">Quantidade</th>
                    <th scope="col">Preço Total(R$)</th>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <th scope="row">1</th>
                    <td>Mark</td>
                    <td>Otto</td>
                    <td>@mdo</td>
                </tr>
                <tr>
                    <th scope="row">2</th>
                    <td>Jacob</td>
                    <td>Thornton</td>
                    <td>@fat</td>
                </tr>
                <tr>
                    <th scope="row">3</th>
                    <td colspan="2">Larry the Bird</td>
                    <td>@twitter</td>
                </tr>
            </tbody>
        </table>
    </div>
</section>

<!--
<c:choose>
    <c:when test="${sessionScope.clientList != null && !sessionScope.clientList.isEmpty()}">
        <c:forEach var="client" items="${sessionScope.clientList}">
            <tr>
                <th scope="row" name="clientId"><c:out value="${client.id}"/></th>
                <td><c:out value="${client.name}"/></td>
                <td><c:out value="${client.cpf}"/></td>
                <td><c:out value="${client.address}"/></td>
                <td><c:out value="${client.mail}"/></td>
                <td>
                    <form method="post" action="${pageContext.request.contextPath}/sale/addClient">
                        <input type="hidden"  name="clientId" value="${client.id}">
                        <button type="submit">Adicionar</button>
                    </form>
                </td>
            </tr>
        </c:forEach>
    </c:when>
</c:choose>
-->
