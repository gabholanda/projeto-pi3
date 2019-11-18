<%-- 
    Document   : ProductJSP
    Created on : 11/10/2019, 22:15:59
    Author     : t-xp-198536
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<link href="${pageContext.request.contextPath}/css/product.css" rel="stylesheet">
<div class="wrapper fadeInDown cbg-image">
    <div id="formContent" class="p-3">
        <form method="post" action="${pageContext.request.contextPath}/product/create">

            <div class="form-groupProduct d-flex flex-column justify-content-center align-items-center">
                <label for="txtName">Nome</label>
                <input type="text" name="name" class="form-control" value="${nameProductAttr}" placeholder="Digite o nome do produto" required/>
            </div>
            <div class="form-groupProduct d-flex flex-column justify-content-center align-items-center">
                <label for="txtDescription">Descrição</label>
                <input type="text" name="description" class="form-control" value="${detailsAttr}" placeholder="Digite a descrição" required/>
            </div>
            <div class="form-groupProduct d-flex flex-column justify-content-center align-items-center">
                <label for="txtPriceBuy">Preço de Compra</label>
                <input type="number" name="priceBuy" class="form-control" value="${valuesAttr}" placeholder="Preço Venda" step="0.01" required/>
            </div>
            <div class="form-groupProduct d-flex flex-column justify-content-center align-items-center">
                <label for="txtPriceSale">Preço de Venda</label>
                <input type="number" name="priceSale" class="form-control" value="${valuesSaleAttr}" placeholder="Preço Compra" step="0.01" required/>            
            </div>
            <div class="form-groupProduct d-flex flex-column justify-content-center align-items-center">
                <label for="txtPriceSale">Quantidade</label>
                <input type="number" name="quantity" class="form-control" value="${quantidadeAttr}" placeholder="Quantidade" step="0.01" required/>            
            </div>

            <div>
                <button type="submit" class="btn btn-success">Salvar</button>
                <button type="reset"class="btn btn-warning">Resetar Dados</button>
                <a href="${pageContext.request.contextPath}/product" role="button" class="btn btn-danger">Cancelar</a>
            </div>
        </form>
    </div>
</div>

