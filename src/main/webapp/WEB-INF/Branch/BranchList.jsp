<%-- 
    Document   : BranchList
    Created on : 18/10/2019, 13:33:36
    Author     : gabriel.santos
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<h2>Lista de Filiais</h2>
<table class="table">
    <thead>
        <tr>
            <th scope="col">ID</th>
            <th scope="col">Nome</th>
            <th scope="col">CNPJ</th>
            <th scope="col">Endereço</th>
        </tr>
    </thead>
    <tbody>
        <c:forEach var="branchOffice" items="${branchList}">
            <tr>
                <th scope="row"><c:out value="${branchOffice.id}" /></th>
                <td><c:out value="${branchOffice.name}"/></td>
                <td><c:out value="${branchOffice.cnpj}"/></td>
                <td><c:out value="${branchOffice.address}"/></td>
                <td>
                    <a href="/branch/edit?id=<c:out value='${branchOffice.id}' />">Editar</a>
                    &nbsp;&nbsp;&nbsp;&nbsp;
                    <form method="post" action="delete">
                        <input type="hidden" name="id" value="${branchOffice.id}">
                        <button type="submit">Deletar</button> 
                    </form>

                </td>
            </tr>
        </c:forEach>
    </tbody>
</table>

<a href="/branch/new">Add New User</a>
