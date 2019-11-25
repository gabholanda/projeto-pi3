<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<link href="${pageContext.request.contextPath}/css/sale.css" rel="stylesheet">

<section class="p-5">
    <h2>Items na venda</h2>
    <div class="container mt-2 top-body">
        <p>${errorQuantity}</p>
        <div class="row">
            <div class="col"><strong>Id</strong></div>
            <div class="col"><strong>Nome</strong></div>
            <div class="col"><strong>Preço(R$)</strong></div>
            <div class="col"><strong>Quantidade</strong></div>
        </div>
        <c:choose>
            <c:when test="${sessionScope.orderedItemList != null && !sessionScope.orderedItemList.isEmpty()}">
                <c:forEach var="orderedItem" items="${sessionScope.orderedItemList}">
                    <div class="row">
                        <div class="col"><strong><c:out value="${orderedItem.id}" /></strong></div>
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
                                    <input type="submit" value="Remover" name="itemQuantity" class="btn btn-danger">
                                </form>
                            </div>
                        </div>
                    </div>
                </c:forEach>
            </c:when>
        </c:choose>
        <div class="row">
            <div class="col">
                <label for="discount">Desconto: </label>
                <form method="post" action="${pageContext.request.contextPath}/sale/changeDiscount">
                    <input type="number" step="1" value="${sale.discount}%" name="discount" max="100" min="0">
                </form>
                <label for="valorTotal">Valor Total:</label>
                <input type="number" step="0.00" disabled value="${sale.totalValue - sale.discount * sale.totalValue}" name="valorTotal">
                <p class="selected">Cliente: ${selectedClient.name}</p>
                <input type="hidden" value="${selectedClient.id}" name="selectedClientId">
                <form method="post" action="${pageContext.request.contextPath}/sale/create">
                    <input type="submit" value="Realizar venda" class="btn btn-success">
                </form>
            </div>
        </div>
        <p>${errorSale}</p>
    </div>
</div>
<div class="d-flex justify-content-between">
    <div class="jumbotron">
        <div class="ml-5">
            <h2>Lista de clientes</h2>
            <form method="post" action="${pageContext.request.contextPath}/sale/searchClient" class="d-flex">
                <input type="text" placeholder="Pesquise pelo nome ..." name="name">
                <button type="submit" class="btn btn-secondary">Pesquisar</button>
            </form>
            <div class="table-responsive-sm table-w mt-2 top-body">
                <table class="table">
                    <thead>
                        <tr>
                            <th scope="col">ID</th>
                            <th scope="col">Nome</th>
                            <th scope="col">CPF</th>
                            <th scope="col">Endereço</th>
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
                                        <td>
                                            <form method="post" action="${pageContext.request.contextPath}/sale/addClient">
                                                <input type="hidden"  name="clientId" value="${client.id}">
                                                <button type="submit" class="btn btn-success">Adicionar</button>
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
    </div>
    <div class="jumbotron">
        <div class="ml-5">
            <h2>Lista de produtos</h2>
            <form method="post" action="${pageContext.request.contextPath}/sale/searchProduct" class="d-flex">
                <input type="text" placeholder="Pesquise pelo nome ..." name="productName">
                <button type="submit" class="btn btn-secondary">Pesquisar</button>
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
                        </div>
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
                                                <button type="submit" class="btn btn-success">Adicionar</button>
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
</div>
<div>
</section>