<%-- 
    Document   : SaleList
    Created on : 21/11/2019, 23:16:43
    Author     : patrickchagas
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<link href="${pageContext.request.contextPath}/css/sale.css" rel="stylesheet">
<section class="p-5">
    <div class="d-flex">
        <div class="mr-5">
            <h2>Lista de Realizadas</h2>
            <form method="post" action="${pageContext.request.contextPath}/sale/searchClient">
                <input type="text" placeholder="Pesquise pelo nome ..." name="name">
                <button type="submit">pesquisar</button>
            </form>
            <div class="table-responsive-sm table-w mt-2 top-body">
                <table class="table">
                    <thead>
                        <tr>
                            <th scope="col">ID</th>
                            <th scope="col">Nome</th>
                            <th scope="col">CPF</th>
                            <th scope="col">Endereço</th>
                            <th scope="col">Email</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:choose>
                            <c:when test="${sessionScope.clientList != null && !sessionScope.clientList.isEmpty()}">
                                <c:forEach var="client" items="${sessionScope.clientList}">
                                    <tr>
                                        <th scope="row" name="clientId"><c:out value="${client.id}"/></th>
                                        <td><c:out value="${client.name}"/></td>
                                        <td><c:out value="${client.cpf}"/></td>
                                        <td><c:out value="${client.address}"/></td>
                                        <td><c:out value="${client.mail}"/></td>
                                        <td>
                                            <form method="post" action="${pageContext.request.contextPath}/sale/addClient">
                                                <input type="hidden"  name="clientId" value="${client.id}">
                                                <button type="submit">Adicionar</button>
                                            </form>
                                        </td>
                                    </tr>
                                </c:forEach>
                            </c:when>
                        </c:choose>
                    </tbody>
                </table>
                <p>${errorClient}</p>
            </div>
        </div>
        <div class="ml-5">
            <h2>Lista de produtos</h2>
            <form method="post" action="${pageContext.request.contextPath}/sale/searchProduct">
                <input type="text" placeholder="Pesquise pelo nome ..." name="productName">
                <button type="submit">pesquisar</button>
            </form>
            <div class="table-responsive-sm table-w mt-2 top-body">
                <table class="table">
                    <thead>
                        <tr>
                            <th scope="col">Id</th>
                            <th scope="col">Nome</th>
                            <th scope="col">Preço(R$)</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:choose>
                            <c:when test="${sessionScope.productList != null && !sessionScope.productList.isEmpty()}">
                                <c:forEach var="product" items="${sessionScope.productList}">
                                    <tr>
                                        <th scope="row"><c:out value="${product.id}"/></th>
                                        <td><c:out value="${product.nameProduct}"/></td>
                                        <td><c:out value="${product.valuesSale}"/></td>
                                        <td>
                                            <form method="post" action="${pageContext.request.contextPath}/sale/addSaleList">
                                                <input type="hidden"  name="productId" value="${product.id}">
                                                <button type="submit">Adicionar</button>
                                            </form>
                                        </td>
                                    </tr>
                                </c:forEach>
                            </c:when>
                        </c:choose>
                    </tbody>
                </table>
                <p>${errorProduct}</p>
            </div>
        </div>
    </div>
    <div>
        <h2>Lista de produtos</h2>
        <div class="container mt-2 top-body">
            <p>${errorQuantity}</p>
            <div class="row">
                <div class="col">Id</div>
                <div class="col">Nome</div>
                <div class="col">Preço(R$)</div>
                <div class="col">Quantidade</div>
            </div>
            <c:choose>
                <c:when test="${sessionScope.orderedItemList != null && !sessionScope.orderedItemList.isEmpty()}">
                    <c:forEach var="orderedItem" items="${sessionScope.orderedItemList}">
                        <div class="row">
                            <div class="col"><c:out value="${orderedItem.id}" /></div>
                            <div class="col"><c:out value="${orderedItem.name}"/></div>
                            <div class="col"><c:out value="${orderedItem.value}"/></div>
                            <div class="col">
                                <div class="d-flex">
                                    <form method="post" action="${pageContext.request.contextPath}/sale/changeQuantity" class="mr-2">
                                        <input type="hidden"  name="orderedItemId" value="${orderedItem.id}">
                                        <input type="number" value="${orderedItem.quantityItem}" max="99999" name="itemQuantity" class="quantity">
                                    </form>
                                    <form method="post" action="${pageContext.request.contextPath}/sale/removeSaleList">
                                        <input type="hidden"  name="orderedItemId" value="${orderedItem.id}">
                                        <input type="submit" value="Remover" name="itemQuantity">
                                    </form>
                                </div>
                            </div>
                        </div>
                    </c:forEach>
                </c:when>
            </c:choose>
            <div class="row">
                <div class="col">
                    <label for="valorTotal">Valor Total:</label>
                    <input type="number" step="0.01" disabled value="${sale.totalValue}" name="valorTotal">
                    <label>${selectedClient.name}</label>
                    <input type="hidden" value="${selectedClient.id}" name="selectedClientId">
                    <form method="post" action="${pageContext.request.contextPath}/sale/create">
                        <input type="submit" value="Realizar venda" class="btn btn-success">
                    </form>
                </div>
            </div>
            <p>${errorSale}</p>
        </div>
    </div>
</section>