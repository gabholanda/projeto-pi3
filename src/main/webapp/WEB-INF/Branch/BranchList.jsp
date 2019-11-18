<%-- 
    Document   : BranchList
    Created on : 18/10/2019, 13:33:36
    Author     : gabriel.santos
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<link href="${pageContext.request.contextPath}/css/branch.css" rel="stylesheet">
<h2>Lista de Filiais</h2>
<section class="p-5">
    <table class="table">
        <thead>
            <tr>    
                <th scope="col">ID</th>
                <th scope="col">Nome</th>
                <th scope="col">Endereço</th>
                <th scope="col">CNPJ</th>             
                <th scope="col">Opções</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="branchOffice" items="${branchList}">
                <tr>
                    <th scope="row"><c:out value="${branchOffice.id}" /></th>
                    <td><c:out value="${branchOffice.name}"/></td>
                    <td><c:out value="${branchOffice.cnpj}"/></td>
                    <td><c:out value="${branchOffice.address}"/></td>
                    <td class="d-flex">
                        <a href="${pageContext.request.contextPath}/branch/edit?id=<c:out value='${branchOffice.id}' />" class="btn btn-secondary">Editar</a>
                        &nbsp;&nbsp;&nbsp;&nbsp;
                        <form method="post" action="${pageContext.request.contextPath}/branch/delete?id=<c:out value='${branchOffice.id}' />">
                            <input type="hidden" name="id" value="${branchOffice.id}">
                            <button type="submit" class="btn btn-danger">Deletar</button> 
                        </form>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</section>

<div class="d-flex justify-content-center">
    <a href="${pageContext.request.contextPath}/branch/new" class="btn btn-success">Nova filial</a>
</div>

