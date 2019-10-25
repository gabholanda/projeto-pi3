<%-- 
    Document   : FormEdit
    Created on : 21/10/2019, 16:51:13
    Author     : marcelo.moraes
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
       <form  method="post" action="update">
    <input type="hidden" name="id" value="${idProductAttr}"/>
    <div class="form-group">
        <label>Nome Produto</label>
        <input type="text" name="name" class="form-control" value="${nameProductAttr}" />
        placeholder= "Digite o Nome do Produto"
    </div>
    <div class="form-group">
        <label>Descrição</label>
        <input type="text" name="cnpj" class="form-control" value="${detailsAttr}" />
        placeholder= "Descrição..."
    </div>
    <div class="form-group">
        <label>Preço Venda</label>
        <input type="text" name="address" class="form-control" value="${valuesAttr}" />
        placeholder= "Digite um preço de Venda:"
    </div>
    <div class="form-group">
        <label>Preço Compra</label>
        <input type="text" name="address" class="form-control" value="${valuesSaleAttr}" />
        placeholder= "Digite um preço de Compra:"
    </div>
    
    <button type="submit" class="btn btn-primary">Enviar</button>
</form>