<%-- 
    Document   : ClientCreate
    Created on : 21/10/2019, 21:53:07
    Author     : marcelo.moraes
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<div class="wrapper fadeInDown cbg-image">
    <div id="formContent" class="p-3">
        <form  method="post" action="create">
            <div class="form-group">
                <label>Nome do Cliente</label>
                <input type="text" name="name" class="form-control" />
            </div>
            <div class="form-group d-flex flex-column justify-content-center align-items-center">
                <label>CPF</label>
                <input type="text" name="cpf" class="form-control" />
            </div>
            <div class="form-group">
                <label>Endereço</label>
                <input type="text" name="address" class="form-control" />
            </div>
            <div class="form-group">
                <label>Email</label>
                <input type="email" name="mail" class="form-control" />
            </div>
            <div>
                <button type="submit" class="btn btn-success">Salvar</button>
                <button type="reset" class="btn btn-warning">Resetar dados</button>
                <a href="#" role="button" class="btn btn-danger">Cancelar</a>
            </div>
        </form> 
    </div>
</div>