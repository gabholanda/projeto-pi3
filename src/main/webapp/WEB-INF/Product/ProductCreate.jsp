<%-- 
    Document   : ProductJSP
    Created on : 11/10/2019, 22:15:59
    Author     : t-xp-198536
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<section style="width: 70%; margin: 0 auto">
    <h1>Produtos</h1>
    <form method="post" action="${pageContext.request.contextPath}/product/create">

        <input type="hidden" name="id" value="123">
        <hr/>    
        <div class="form-groupProduct">
            <label for="txtName"> Nome</label>
            <div class="form-groupProduct">
                <input type="text" name="name" id="txtName" 
                       placeholder="Digite um nome..." 
                       required maxlength="100"/>
                <div class="erro-input">
                    Digite um nome.
                </div>
            </div>
        </div>

        <div class="form-groupProduct">
            <label for="txtDescription">
                Descrição
            </label>
            <div>
                <textarea name="description" id="txtDescription" placeholder="Descrição..." required>
                </textarea>
            </div>
        </div>

        <div class="form-groupProduct">
            <label for="txtPriceSale">
                Preço Venda
            </label>
            <div>
                <input type="number" name="priceSale" id="txtPriceSale" 
                       placeholder="Preço Venda" step="0.01"
                       required />
                <div class="erro-input">
                    Digite um preço.
                </div>
            </div>
        </div>
        <div class="form-groupProduct">
            <label for="txt">
                Preço Compra
            </label>
            <div>
                <input type="number" name="purchasePrice" id="txtPurchasePrice" 
                       placeholder="Preço Compra" step="0.01"
                       required/>
                <div class="erro-input">
                    Digite um preço.    
                </div>
            </div>

            <div>
                <button type="submit" class="btn btn-primary">Salvar</button>
                <button type="reset">Resetar Dados</button>
                <a href="${pageContext.request.contextPath}/product" role="button">Cancelar</a>
            </div>
    </form>
</section>
