<%-- 
    Document   : ProductJSP
    Created on : 11/10/2019, 22:15:59
    Author     : t-xp-198536
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<div>
    <section style="width: 70%; margin: 0 auto">
        <h1>Produtos</h1>
        <form method="post" action="">

            <input type="hidden" name="id" value="123">

            <div>
                <label for="txtName">
                    Nome
                </label>
                <div>
                    <input type="text" name="name" id="txtName" 
                           placeholder="Name" 
                           required maxlength="100" />
                    <div class="erro-input">
                        Digite um nome.
                    </div>
                </div>
            </div>

            <div>
                <label for="txtDescription">
                    Descrição
                </label>
                <div>
                    <textarea name="description" id="txtDescription" placeholder="Description">
                    </textarea>
                </div>
            </div>

            <div>
                <label for="txtPriceSale">
                    Preço Venda
                </label>
                <div>
                    <input type="priceSale" name="priceSale" id="txtPriceSale" 
                           placeholder="PriceSale"
                           required />
                    <div class="erro-input">
                        Digite um preço.
                    </div>
                </div>
            </div>
            <div>
                <label for="txt">
                    Preço Compra
                </label>
                <div>
                    <input type="text" name="purchasePrice" id="txtPurchasePrice" 
                           placeholder="PurchasePrice"
                           required/>
                    <div class="erro-input">
                        Digite um preço.

                    </div>
                </div>
                <div>
                    <label for="txtAmount">
                        Quantidade Produto
                    </label>
                    <div>
                        <input type="text" name="amount" id="txtAmount" 
                               placeholder="Amount" 
                               >
                        <div class="erro-input">
                            Digite uma quantidade válida.
                        </div>
                    </div>
                </div>
                <div>
                    <button type="submit">Enviar</button>
                    <button type="reset">Resetar dados</button>
                    <a href="#" role="button">Cancelar</a>
                </div>
        </form>
    </section>
</div>
