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
            <button type="submit" class="btn btn-success">Gerar Relatório</button>
        </form>
    </div>
    <c:choose>
        <c:when test="${sessionScope.report != null}">
            <div class="d-flex justify-content-center flex-column mt-5">
                <h5>Total da Filial</h5>
                <h6>R$ ${report.totalBranchValue}</h6>
                <h4>Os 10 mais vendidos</h4>

                <div>
                    <table class="table">
                        <thead>
                            <tr>
                                <th scope="col">Nome</th>
                                <th scope="col">Valor Unitário(R$)</th>
                                <th scope="col">Valor Total(R$)</th>
                                <th scope="col">Quantidade Vendida</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach var="item" items="${sessionScope.reportItems}">
                                <tr>
                                    <th scope="row">><c:out value="${item.name}"/></th>
                                    <td><c:out value="${item.value}"/></td>
                                    <td><c:out value="${item.value * item.quantityItem}"/></td>
                                    <td><c:out value="${item.quantityItem}"/></td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </div>
            </c:when>
        </c:choose>
</section>