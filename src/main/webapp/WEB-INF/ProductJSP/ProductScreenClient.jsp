<%-- 
    Document   : ProductJSP
    Created on : 11/10/2019, 22:15:59
    Author     : t-xp-198536
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Produtos</title>
        <meta charset="UTF-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <style>
            .erro-input {
                display: none;
                color: #e74c3c;
            }
            .com-erro {
                display: block;
            }
            input[type='text'],
            input[type='email'],
            input[type='number'],
            input[type='password'],
            input[type='date'],
            textarea {
                width: 100%;
            }
        </style>
    </head>
    <body>
        <main>
            <div>
                <section style="width: 70%; margin: 0 auto">
                    <h1>Produtos</h1>
                    <form method="post" action="">
 
                        <input type="hidden" name="id" value="123">
                        <hr/>    
                        <div>
                            <label for="txtName">
                                Nome
                            </label>
                            <div>
                                <input type="text" name="name" id="txtName" 
                                       placeholder="Digite um nome..." 
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
                                <textarea name="description" id="txtDescription" placeholder="Descrição...">
                                </textarea>
                            </div>
                        </div>

                        <div>
                            <label for="txtPriceSale">
                              Preço Venda
                            </label>
                            <div>
                                <input type="number" name="priceSale" id="txtPriceSale" 
                                       placeholder="Preço Venda"
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
                                <input type="number" name="purchasePrice" id="txtPurchasePrice" 
                                       placeholder="Preço Compra"
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
                                <input type="number" name="amount" id="txtAmount" 
                                       placeholder="Quantidade..." 
                                       >
                                <div class="erro-input">
                                    Digite uma quantidade válida.
                                </div>
                            </div>
                        </div>
                        
                        <div>
                            <label for="txtStock">
                                Estoque Produto
                            </label>
                            <div>
                                <input type="number" name="stock" id="txtStock" 
                                       placeholder="Estoque..." 
                                       >
                                <div class="erro-input">
                                </div>
                            </div>
                        </div>
                            
                         <fieldset>
                            <legend>Filiais</legend>
                            <div>
                                <div>
                                    <input type="checkbox" name="branchOfice" 
                                           id="branchOfficeUZGame" value="UZGame" />
                                    <label for="branchOfficeUZGame">
                                        UZGame
                                    </label>
                                </div>
                                <div>
                                    <input type="checkbox" name="branchOfice" 
                                           id="branchOfficeRiot" value="Riot" />
                                    <label for="branchOfficeRiot">
                                        Riot
                                    </label>
                                </div>
                                <div>
                                    <input type="checkbox" name="branchOfice" 
                                           id="branchOfficelevelUp" value="LevelUp" />
                                    <label for="branchOfficelevelUp">
                                        LevelUp
                                    </label>
                                </div>
                            </div>
                         </fieldset>
                        <div>
                            <button type="submit" >Salvar</button>
                            <button type="reset">Cancelar</button>
                        </div>
                    </form>
                </section>
            </div>
        </main>

    </body>
</html>
