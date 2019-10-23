<%-- 
    Document   : ProductScreenClient
    Created on : 16/10/2019, 10:20:18
    Author     : hcyrillo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        
        <style>
  #divBusca{
  background-color:#2F4F4F;
  border:solid 1px;
  border-radius:15px;
  width:260px;
}
 
  #txtBusca{
  float:left;
  background-color:transparent;
  padding-left:10px;
  font-style:italic;
  font-size:18px;
  border:none;
  height:30px;
  width:360px;
  border-radius: 50%;
}
#btnBusca{
    width: 20px;
    height: 20px; 
    
}
#btnLupa{
	width:25px;
        height: 25px;
        border-radius: 50%;
    }  
        </style>
    </head>
    <body>
        <h2>Lista de Produtos</h2>
    <table class="table">
        <thead>
            <tr>
                <th scope="col">ID</th>
                <th scope="col">Nome</th>
                <th scope="col">Detalhe</th>
                <th scope="col">Preço Venda</th>
                <th scope="col">Preço Compra</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="product" items="${searchProduct}">
                <tr>
                    <th scope="row"><c:out value="${searchProduct.idProduct}" /></th>
                    <td><c:out value="${searchProduct.nameProduct}"/></td>
                    <td><c:out value="${searchProduct.details}"/></td>
                    <td><c:out value="${searchProduct.values}"/></td>
                    <td><c:out value="${searchProduct.valuesSale}"/></td>
                    <td>
                        <a href="http://localhost:8084/product/FormEdit">Editar</a>
                        &nbsp;&nbsp;&nbsp;&nbsp;
                        <form method="post" action="http://localhost:8084/product/delete?id=<c:out value='${branchOffice.idProduct}' />">
                            <input type="hidden" name="id" value="${branchOffice.idProduct}">
                            <button type="submit">Deletar</button> 
                        </form>

                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>

    <a href="http://localhost:8084/product/product">Add New User</a>

    </body>
</html>
