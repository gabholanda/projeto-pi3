<%-- 
    Document   : ClientEdit
    Created on : 21/10/2019, 15:13:30
    Author     : marcelo.moraes
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<div class="wrapper fadeInDown cbg-image">
    <div id="formContent" class="p-3">
        <form  method="post" action="update">
            <input type="hidden" name="id" value="${idAttr}"/>
            <div class="form-group">
                <label>Nome do Cliente</label>
                <input type="text" name="name" class="form-control" value="${nameAttr}" placeholder= "Digite o Nome do Cliente:"/>
            </div>
            <div class="form-group">
                <label>CPF do Cliente</label>
                <input type="text" name="cpf" class="form-control" value="${cpfAttr}" placeholder= "Digite o CPF do Cliente:"/>
            </div>
            <div class="form-group">
                <label>Endereço do Cliente</label>
                <input type="text" name="address" class="form-control" value="${addressAttr}" placeholder= "Digite o Endereco do Cliente:"/>
            </div>
            <div class="form-group">
                <label>Email do Cliente</label>
                <input type="email" name="mail" class="form-control" value="${mailAttr}" placeholder= "Digite o Email do Cliente:"/>
            </div>
            <button type="submit" class="btn btn-primary">Enviar</button>
        </form>
    </div>
</div>