<%-- 
    Document   : ClientCreate
    Created on : 21/10/2019, 21:53:07
    Author     : marcelo.moraes
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<form  method="post" action="create">

    <div class="form-group">
        <label>Nome do Cliente</label>
        <input type="text" name="name" class="form-control" />
        
    </div>
    <div class="form-group">
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
        <button type="submit">Enviar</button>
        <button type="reset">Resetar dados</button>
        <a href="#" role="button">Cancelar</a>
    </div>

</form> 