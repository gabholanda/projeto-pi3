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
    <div>
        <h1>Produtos - Pesquisa</h1>  
        <hr>
      <div id="divBusca">
        <input type="text" id="txtBusca" placeholder="Buscar..."/>
        <button type="submit"><img src="C:\Users\hcyrillo\Downloads\lupa.png" id="btnBusca"/></button>
      </div>
        <div>
            <table border="1">
                <thead>
                    <tr>
                        <th><label for="nameProduct"> Nome</label></th>
                        <th><label for="valuesProduct"> Preço Compra</label></th>
                        <th><label for="valuesSaleProduct"> Preço Venda</label></th>
                        <th><label for="amountProduct"> Quantidade</label></th>
                        <th><label for="stockProduct"> Estoque</label></th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td>sdfdsf</td>
                        <td>ds</td>
                        <td>sdfsdf</td>
                        <td> asad</td>
                        <td>asdds</td>
                        <td> <a href="http://localhost:8080/update">Alterar</a> </td>
                        <td> <a href="http://localhost:8080/product/searchProduct">Excluir</a> </td>
                    </tr>
                   <tr>
                        <td>sdfdsf</td>
                        <td>ds</td>
                        <td>sdfsdf</td>
                        <td> asad</td>
                        <td>asdds</td>
                        <td> <a href="http://localhost:8080/update">Alterar</a> </td>
                        <td> <a href="http://localhost:8080/delete">Excluir</a> </td>
                    </tr>
                    <tr>
                        <td>sdfdsf</td>
                        <td>ds</td>
                        <td>sdfsdf</td>
                        <td> asad</td>
                        <td>asdds</td>
                        <td> <a href="http://localhost:8080/update">Alterar</a> </td>
                        <td> <a href="http://localhost:8080/delete">Excluir</a> </td>
                    </tr>
                    <tr>
                        <td>sdfdsf</td>
                        <td>ds</td>
                        <td>sdfsdf</td>
                        <td> asad</td>
                        <td>asdds</td>
                        <td> <a href="http://localhost:8080/update">Alterar</a></td>
                       <td> <a href="http://localhost:8080/product/searchProduct">Excluir</a> </td>
                    </tr>
                    <tr>
                        <td>sdfdsf</td>
                        <td>ds</td>
                        <td>sdfsdf</td>
                        <td> asad</td>
                        <td>asdds</td>
                        <td> <a href="http://localhost:8080/update">Alterar</a> </td>
                        <td> <a href="http://localhost:8080/product/searchProduct">Excluir</a> </td>
                    </tr>
                </tbody>
            </table>

        </div>
    </div>        
    </body>
</html>
