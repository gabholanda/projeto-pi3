<%-- 
    Document   : UserJSP
    Created on : 18/10/2019, 03:24:58
    Author     : Patrick Chagas
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<link href="${pageContext.request.contextPath}/css/user.css" rel="stylesheet">
<div class="wrapper fadeInDown ubg-image">
    <div id="formContent" class="p-3">
        <form method="post" action="${pageContext.request.contextPath}/user/create">

            <div>
                <span> Todos os campos são obrigatórios</span> <span style="color: red ">*</span>
            </div>

            <div class="form-groupUser d-flex flex-column justify-content-center align-items-center">
                <label for="txtName">Nome</label>
                <input class="form-control" name="name" placeholder="Nome completo" required/>
            </div>
            <div class="form-groupUser d-flex flex-column justify-content-center align-items-center">
                <label for="txtName">E-mail</label>
                <input class="form-control" type="email" name="email" placeholder="E-mail de acesso" required/>
            </div>
            <div class="form-groupUser d-flex flex-column justify-content-center align-items-center">
                <label for="txtName">Password</label>
                <input class="form-control" type="password" name="password" placeholder="Senha secreta" required/>
            </div>
            <div class="form-groupUser d-flex flex-column justify-content-center align-items-center">
                <label for="txtName" >Nivel de permissões</label>
                <select class="form-control" name="permission" >
                    <option name="permission" value="BACKOFFICE" >BACKOFFICE</option>
                    <option name="permission" value="DIRETORIA" >DIRETORIA</option>
                    <option name="permission" value="GERENTE" >GERENTE</option>
                    <option name="permission" value="RH" >RH</option>
                    <option name="permission" value="TI" >TI</option>
                    <option name="permission" value="VENDAS" >VENDAS</option>
                </select>

<!--                <c:forEach var="category" items="${categoryList}">
                <label for="txtCategory">Categoria</label>
                <input type="checkbox" name="category" class="form-control">
                <label for="checkCatgory">${categoryAttr}</label>-->
                </c:forEach>
            </div>
            <div class="Div_buttons">
                <button type="submit" class="btn btn-success">Salvar</button>
                <button type="reset"class="btn btn-warning">Resetar Dados</button>
                <a href="${pageContext.request.contextPath}/user" role="button" class="btn btn-danger">Cancelar</a>
            </div>
        </form>
    </div>
</div>
