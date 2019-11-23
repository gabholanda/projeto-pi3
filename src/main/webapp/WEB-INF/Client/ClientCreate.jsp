<%-- 
    Document   : ClientCreate
    Created on : 21/10/2019, 21:53:07
    Author     : marcelo.moraes
--%>

<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery.mask/1.14.15/jquery.mask.min.js"></script>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

 <link href="${pageContext.request.contextPath}/css/client.css" rel="stylesheet"/>
<div class="wrapper fadeInDown cbg-image">
    <div id="formContent" class="p-3">
        <form  method="post" action="${pageContext.request.contextPath}/client/create">
            <div class="form-group d-flex flex-column justify-content-center align-items-center">
                <label>Nome</label>
                <input type="text" name="name" class="form-control" value="${nameAttr}" placeholder="Digite o nome do cliente..." required/>
            </div>
            <div class="form-group d-flex flex-column justify-content-center align-items-center">
                
                <label>CPF</label>
                <input type="text" name="cpf" class="form-control" value="${cpfAttr}" placeholder="Digite o cpf do cliente..." onkeypress="$(this).mask('000.000.000/00');"  required/>
            </div>
            <div class="form-group">
                <label>Endereço</label>
                <input type="text" name="address" class="form-control" placeholder="Digite o endereço do cliente..." value="${addressAttr}" required/>
            </div>
             <label>Email</label>
            <div class="form-group">
               
                 
                <input type="text" name="mail" class="form-control" placeholder="Digite o email do cliente..." value="${mailAttr}" required/>
            </div>
             
            <div>
                <button type="submit" class="btn btn-success">Salvar</button>
                <button type="reset" class="btn btn-warning">Resetar dados</button>
                <a href="${pageContext.request.contextPath}/client" role="button" class="btn btn-danger">Cancelar</a>
            </div>
        </form> 
    </div>
</div>