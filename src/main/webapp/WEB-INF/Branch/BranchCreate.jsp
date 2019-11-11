<%-- 
    Document   : Filial
    Created on : 16/10/2019, 21:14:25
    Author     : lucas.mnpaiva
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<div class="wrapper fadeInDown cbg-image">
    <div id="formContent" class="p-3">
        <form method="post" action="create">
            <div class="form-group">
                <label for="name">Nome da filial</label>
                <input type="text" class="form-control" name="name" placeholder="Nome da filial" required>
            </div>
            <div class="form-group">
                <label for="address">Endereço</label>
                <input type="text" class="form-control" name="address" placeholder="Endereço" required>
            </div>
            <div class="form-group d-flex flex-column justify-content-center align-items-center">
                <label for="cnpj">CNPJ</label>
                <input type="text" class="form-control" name="cnpj" placeholder="CNPJ" required>
            </div>
            <button class="btn btn-primary" type="submit">Criar</button>
        </form>
    </div>
</div>