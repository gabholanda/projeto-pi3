<%-- 
    Document   : Filial
    Created on : 16/10/2019, 21:14:25
    Author     : lucas.mnpaiva
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<form  method="post" action="create">
    <div class="form-group">
        <label>Nome da Filial</label>
        <input type="text" name="name" class="form-control" />
    </div>
    <div class="form-group">
        <label>CNPJ</label>
        <input type="text" name="cnpj" class="form-control" />
    </div>
    <div class="form-group">
        <label>Endereço</label>
        <input type="text" name="address" class="form-control" />
    </div>
    <button type="submit" class="btn btn-primary">Enviar</button>
</form>