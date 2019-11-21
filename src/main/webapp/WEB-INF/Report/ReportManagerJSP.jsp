<%-- 
    Document   : ReportManager
    Created on : 18/11/2019, 21:14:11
    Author     : marcelo.smoraes2
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<section>
    <form method="post" action="${pageContext.request.contextPath}/report/generate">
        <input type="submit" value="Gerar Relatório">
    </form>
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
