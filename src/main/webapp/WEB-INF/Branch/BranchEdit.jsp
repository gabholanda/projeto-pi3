<%-- 
    Document   : BranchEdit
    Created on : Oct 19, 2019, 6:29:04 PM
    Author     : HOLANDAS
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<form  method="post" action="update">
    <input type="hidden" name="id" value="${idAttr}"/>
    <div class="form-group">
        <label>Nome da Filial</label>
        <input type="text" name="name" class="form-control" value="${nameAttr}" />
        placeholder= "Digite o Nome da filial:"
    </div>
    <div class="form-group">
        <label>CNPJ</label>
        <input type="text" name="cnpj" class="form-control" value="${cnpjAttr}" />
        placeholder= "Digite o CNPJ da filial:"
    </div>
    <div class="form-group">
        <label>Endereço</label>
        <input type="text" name="address" class="form-control" value="${addressAttr}" />
        placeholder= "Digite o Endereco da Filial:"
    </div>
    <button type="submit" class="btn btn-primary">Enviar</button>
</form>
