<%-- 
    Document   : FormEdit
    Created on : 21/10/2019, 16:51:13
    Author     : marcelo.moraes
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<link href="${pageContext.request.contextPath}/css/product.css" rel="stylesheet">
<div class="wrapper fadeInDown cbg-image">
    <div id="formContent" class="p-3">
        <form  method="post" action="${pageContext.request.contextPath}/product/update">
            <input type="hidden" name="id" value="${idAttr}"/>
            <div class="form-group">
                <label>Nome Produto</label>
                <input type="text" name="name" class="form-control" value="${nameProductAttr}"  />
            </div>
            <div class="form-group">
                <label>Descrição</label>
                <input type="text" name="description" class="form-control" value="${descriptionAttr}"  />

            </div>
            <div class="form-group">
                <label>Preço Venda</label>
                <input type="text" name="priceSale" class="form-control" value="${priceSaleAttr}"  />
            </div>
            <div class="form-group">
                <label>Preço Compra</label>
                <input type="text" name="priceBuy" class="form-control" value="${priceBuyAttr}" />
            </div>
            <div class="form-group">
                <c:forEach var="category" items="${categoryList}">
                <label for="txtCategory">Categoria</label>
                <input type="checkbox" name="category" class="form-control" value="${categoryAttr}">
                </c:forEach>
            </div>

            <button type="submit" class="btn btn-success">Alterar</button>
            <a href="${pageContext.request.contextPath}/product" role="button" class="btn btn-danger">Cancelar</a>
        </form>
    </div>
</div>