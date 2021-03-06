<%-- 
    Document   : ClientList
    Created on : 18/10/2019, 21:42:52
    Author     : marcelo.moraes
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<link href="${pageContext.request.contextPath}/css/client.css" rel="stylesheet"/>
<div class="jumbotron">
    <h2>Lista de Clientes</h2>
</div>
<section class="p-5">
    <form method="post" action="${pageContext.request.contextPath}/client/searchClient">
        <input type="text" placeholder="Pesquise pelo nome ..." name="name"     >
        <button type="submit" class="btn btn-secondary">Pesquisar</button>
    </form>
    <div class="top-body">
         
        <table class="table">
            <thead>
                <tr>
                    <th scope="col">ID</th>
                    <th scope="col">Nome</th>
                    <th scope="col">CPF</th>
                    <th scope="col">Endereço</th>
                    <th scope="col">Email</th>
                    <th scope="col">Opções</th>
                </tr>
            </thead>
            <tbody>
                <c:choose>
                    <c:when test="${sessionScope.clientList != null && !sessionScope.clientList.isEmpty()}">
                        <c:forEach var="client" items="${sessionScope.clientList}">
                            <tr>
                                <th scope="row"><c:out value="${client.id}" /></th>
                                <td><c:out value="${client.name}"/></td>
                                <td><c:out value="${client.cpf}"/></td>
                                <td><c:out value="${client.address}"/></td>
                                <td><c:out value="${client.mail}"/></td>
                                <td class="d-flex">
                                    <a href="${pageContext.request.contextPath}/client/edit?id=<c:out value='${client.id}' />" class="btn btn-secondary">Editar</a>
                                    &nbsp;&nbsp;&nbsp;&nbsp;
                                    <form method="post" action="${pageContext.request.contextPath}/client/delete?id=<c:out value='${client.id}' />">
                                        <input type="hidden" name="id" value="${client.id}">
                                        <button type="submit" class="btn btn-danger">Deletar</button> 
                                    </form>
                                </td>
                            </tr>
                        </c:forEach>
                    </c:when>
                </c:choose>
            </tbody>
        </table>
    </div>
</section>
<div class="d-flex justify-content-center">
    <a href="${pageContext.request.contextPath}/client/new" class="btn btn-success"   >Novo cliente</a>
</div>
