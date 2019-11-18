<%-- 
    Document   : Filial
    Created on : 16/10/2019, 21:14:25
    Author     : lucas.mnpaiva
--%>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery.mask/1.14.15/jquery.mask.min.js"></script>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<link href="${pageContext.request.contextPath}/css/branch.css" rel="stylesheet">
<div class="wrapper fadeInDown cbg-image">
    <div id="formContent" class="p-3">
        <form method="post" action="${pageContext.request.contextPath}/branch/create">
            <div class="form-group">
                <label for="name">Nome da filial</label>
                <input type="text" class="form-control" name="name" value="${nameAttr}" placeholder="Nome da filial" required>
            </div>
            <div class="form-group d-flex flex-column justify-content-center align-items-center">
                <label for="cnpj">CNPJ</label>
                <input type="text" class="form-control" name="cnpj" placeholder="CNPJ" value="${cnpjAttr}" onkeypress="$(this).mask('00.000.000/0000-00');" required>
            </div>
            <div class="form-group">
                <label for="address">Endereço</label>
                <input type="text" class="form-control" name="address" value="${addressAttr}" placeholder="Endereço" required>
            </div>          
            <button type="submit" class="btn btn-success">Salvar</button>
            <button type="reset" class="btn btn-warning">Resetar dados</button>
            <a href="${pageContext.request.contextPath}/branch" role="button" class="btn btn-danger">Cancelar</a>
        </form>
    </div>
</div>