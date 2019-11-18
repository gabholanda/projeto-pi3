<%-- 
    Document   : BranchEdit
    Created on : Oct 19, 2019, 6:29:04 PM
    Author     : HOLANDAS
--%>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery.mask/1.14.15/jquery.mask.min.js"></script>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<div class="wrapper fadeInDown cbg-image">
    <div id="formContent" class="p-3">
        <form  method="post" action="${pageContext.request.contextPath}/branch/update">
            <input type="hidden" name="id" value="${idAttr}"/>
            <div class="form-group">
                <label>Nome da Filial</label>
                <input type="text" name="name" class="form-control" value="${nameAttr}" required />
            </div>
             <div class="form-group">
                <label>Endereço</label>
                <input type="text" name="address" class="form-control" value="${addressAttr}" required/>
            </div>
            <div class="form-group d-flex flex-column justify-content-center align-items-center">
                <label>CNPJ</label>
                <input type="text" name="cnpj" class="form-control" value="${cnpjAttr}" onkeypress="$(this).mask('00.000.000/0000-00');" required/>
            </div>                   
            <button type="submit" class="btn btn-primary">Enviar</button>
            <button class="btn btn-warning" type="reset">Resetar Dados</button>
            <a href="${pageContext.request.contextPath}/branch" role="button" class="btn btn-danger">Cancelar</a>
        </form>
    </div>
</div>