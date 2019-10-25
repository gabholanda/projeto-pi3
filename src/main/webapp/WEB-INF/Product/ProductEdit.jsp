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
        <input type="text" name="name" class="form-control" value="${nameProductAttr}"  />
    </div>
    <div class="form-group">
        <label>Descrição</label>
        <input type="text" name="details" class="form-control" value="${detailsAttr}"  />
        
    </div>
    <div class="form-group">
        <label>Preço Venda</label>
        <input type="text" name="saleValue" class="form-control" value="${valuesAttr}"  />
    </div>
    <div class="form-group">
        <label>Preço Compra</label>
        <input type="text" name="buyValue" class="form-control" value="${valuesSaleAttr}" />
    </div>
    
    <button type="submit" class="btn btn-primary">Enviar</button>
    <a href="/product" role="button">Cancelar</a>
</form>