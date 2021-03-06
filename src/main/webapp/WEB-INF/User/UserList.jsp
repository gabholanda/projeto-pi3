<%-- 
    Document   : UserList
    Created on : 17/11/2019, 02:22:56
    Author     : Patrick Chagas
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div class="jumbotron">
    <h2>Lista de Usuarios</h2>
</div>
<section class="p-5">
    <div class="top-body">
        <table class="table">
            <thead>
                <tr>
                    <th scope="col">ID</th>
                    <th scope="col">Nome</th>
                    <th scope="col">Email</th>
                    <th scope="col">Permissões</th>
                    <th scope="col">Opções</th>
                </tr>
            </thead>
            <tbody>
                <c:choose>
                    <c:when test="${userList != null && !userList.isEmpty()}">
                        <c:forEach var="employee" items="${userList}">
                            <tr>
                                <th scope="row"><c:out value="${employee.id}" /></th>
                                <td><c:out value="${employee.name}"/></td>
                                <td><c:out value="${employee.mail}"/></td>
                                <td><c:out value="${employee.permission}"/></td>
                                <td class="d-flex">
                                    <a href="${pageContext.request.contextPath}/user/edit?id=<c:out value='${employee.id}' />" class="btn btn-secondary">Editar</a>
                                    &nbsp;&nbsp;&nbsp;&nbsp;
                                    <form method="post" action="${pageContext.request.contextPath}/user/delete?id=<c:out value='${employee.id}' />">
                                        <input type="hidden" name="id" value="${employee.id}">
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
    <a href="${pageContext.request.contextPath}/user/new" class="btn btn-success">Novo Usuario</a>
</div>
