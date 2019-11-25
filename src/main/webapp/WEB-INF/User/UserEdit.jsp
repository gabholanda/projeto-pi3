<%-- 
    Document   : UserEdit
    Created on : 20/11/2019
    Author     : Patrick Chagas
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<link href="${pageContext.request.contextPath}/css/user.css" rel="stylesheet">

<div class="wrapper fadeInDown ubg-image">
    <div id="formContent" class="p-3">
        <form  method="post" action="${pageContext.request.contextPath}/user/update">
            <input type="hidden" name="id" value="${idAttr}"/>
            <div class="form-group">
                <label>Nome Usuario</label>
                <input class="form-control" name="name"  value="${nameAttr}"  />
            </div>
            <div class="form-group">
                <label>E-mail</label>
                <input class="form-control" type="email" name="email"  disabled="true" value="${mailAttr}"  />

            </div>
            <div class="form-group">
                <label>Senha</label>
                <input class="form-control" type="password" name="password"  value="${passwordAttr}"  />
            </div>
            <p class="error">${errorForm}</p>
            <button type="submit" class="btn btn-success">Alterar</button>
            <a href="${pageContext.request.contextPath}/user" role="button" class="btn btn-danger">Cancelar</a>
        </form>
    </div>
</div>