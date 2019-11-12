<%-- 
    Document   : BranchEdit
    Created on : Oct 19, 2019, 6:29:04 PM
    Author     : HOLANDAS
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<div class="wrapper fadeInDown cbg-image">
    <div id="formContent" class="p-3">
        <form  method="post" action="update">
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
                <input type="text" name="cnpj" class="form-control" value="${cnpjAttr}" required/>
            </div>
            <button type="submit" class="btn btn-primary">Editar</button>
        </form>
    </div>
</div>