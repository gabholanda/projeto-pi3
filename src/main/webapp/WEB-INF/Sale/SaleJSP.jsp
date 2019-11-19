<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<link href="${pageContext.request.contextPath}/css/sale.css" rel="stylesheet">
<section class="p-5">
    <div class="d-flex">
        <div class="mr-5">
            <h2>Lista de clientes</h2>
            <form method="post" action="${pageContext.request.contextPath}/sale/client">
                <input type="text" placeholder="Pesquise pelo nome ...">
            </form>
            <div class="table-responsive-sm table-w mt-2">
                <table class="table">
                    <thead>
                        <tr>
                            <th scope="col">Id</th>
                            <th scope="col">Nome</th>
                            <th scope="col">CPF/CNPJ</th>
                            <th scope="col">Endereço</th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr>
                            <th scope="row">1</th>
                            <td>Mark</td>
                            <td>Otto</td>
                            <td>@mdo</td>
                        </tr>
                        <tr>
                            <th scope="row">2</th>
                            <td>Jacob</td>
                            <td>Thornton</td>
                            <td>@fat</td>
                        </tr>
                        <tr>
                            <th scope="row">3</th>
                            <td>Larry</td>
                            <td>the Bird</td>
                            <td>Rua que fica logo ali no senac</td>
                        </tr>
                    </tbody>
                </table>
            </div>
        </div>
        <div class="ml-5">
            <h2>Lista de produtos</h2>
            <form method="post" action="${pageContext.request.contextPath}/sale/product">
                <input type="text" placeholder="Pesquise pelo nome ...">
            </form>
            <div class="table-responsive-sm table-w mt-2">
                <table class="table">
                    <thead>
                        <tr>
                            <th scope="col">Id</th>
                            <th scope="col">Nome</th>
                            <th scope="col">Preço</th> 
                        </tr>
                    </thead>
                    <tbody>
                        <tr>
                            <th scope="row">1</th>
                            <td>Mark</td>
                            <td>Otto</td>
                        </tr>
                        <tr>
                            <th scope="row">2</th>
                            <td>Jacob</td>
                            <td>Thornton</td>
                        </tr>
                        <tr>
                            <th scope="row">3</th>
                            <td>Larry</td>
                            <td>the Bird</td>
                        </tr>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
    <div>
        <h2>Lista de produtos</h2>
        <div class="container mt-2">
            <div class="row">
                <div class="col">Id</div>
                <div class="col">Preço</div>
                <div class="col">Nome</div>
                <div class="col">Quantidade</div>
            </div>





            <div class="row">
                <div class="col">
                    <label for="valorTotal">Valor Total:</label>
                    <input type="number" step="0.01" disabled value="2" name="valorTotal">
                    <form method="post" action="${pageContext.request.contextPath}/sale/create">
                        <input type="submit" value="Realizar compra" class="btn btn-success">
                    </form>
                </div>
            </div>
        </div>
    </div>
</section>