<%-- 
    Document   : BranchList
    Created on : 18/10/2019, 13:33:36
    Author     : gabriel.santos
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>


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
        <td><c:out value="${branchOffice.name}" /></td>
        <td><c:out value="${branchOffice.cnpj}" /></td>
        <td><c:out value="${branchOffice.address}" /></td>
        <td>
            <a href="edit?id=<c:out value='${branchOffice.id}' />">Edit</a>
            &nbsp;&nbsp;&nbsp;&nbsp;
            <a href="delete?id=<c:out value='${branchOffice.id}' />">Delete</a>                    	
        </td>
        </tr>
    </c:forEach>
</tbody>
</table>

<a href="/branch/new">Add New User</a>
