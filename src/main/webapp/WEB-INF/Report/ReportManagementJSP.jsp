<%-- 
    Document   : ReportManagement
    Created on : 18/11/2019, 21:15:25
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
        <c:when test="${sessionScope.reportAll != null}">
            <div class="d-flex justify-content-center flex-column mt-5">
                <h5>Total de vendas</h5>
                <h6>R$ ${reportAll.totalBranchValue}</h6>
                <h4>Valor de cada branch</h4>

                <div>
                    <table class="table">
                        <thead>
                            <tr>
                                <th scope="col">Nome</th>
                                <th scope="col">Valor Filial(R$)</th>
                                <th scope="col">Percentual(%)</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach var="branch" items="${sessionScope.allBranches}">
                                <tr>
                                    <th scope="row">><c:out value="${branch.name}"/></th>
                                    <td><c:out value="${branch.totalValue}"/></td>
                                    <td><c:out value="${(branch.totalValue/reportAll.totalBranchValue) * 100}"/>%</td>

                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </div>
            </c:when>
        </c:choose>
</section>