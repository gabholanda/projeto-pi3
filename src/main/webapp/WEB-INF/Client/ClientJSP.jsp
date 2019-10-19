<%-- 
    Document   : ClientJSP
    Created on : 18/10/2019, 02:16:49
    Author     : marcelo.moraes
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>


        <div> 
            <section>

                <h1>Cadastrar Cliente</h1>
                <form method="post" action="">

                    <input type="hidden" name="id" value="${idAttr}">

                    <div>

                        <label for="txtName">
                            Nome do cliente: 
                        </label>

                        <div>

                            <input type="text" name="name" id="txtName" 
                                   placeholder="Digite o nome do cliente: " 
                                   required maxlength="100" value="${nomeAttr}" />
                            <c:if test="${erroNome}">
                                <div class="erro-input">
                                    
                                </div>
                            </c:if>
                        </div>
                    </div>

                    <div>
                        <label for="txtCPF">
                            Digite um CPF:  
                            <br> 
                           
                        </label>
                        <div>
                            <input name="cpf" id="txtCPF" 
                                   placeholder="Digite o cpf do Cliente"
                                   required maxlength="100" value="${cpfAttr}" />                  
                        </div>
                    </div>

                    <div>
                        <label for="txtAddress">
                            Digite o endereco do cliente: 
                            <br> 
                        </label>
                        <div>
                            <textarea name="address" id="txtAddress"
                                      placeholder="Digite o endereco do cliente:">
                            </textarea>
                        </div> 

                        <div>
                            <label for="txtEmail">
                                E-mail
                            </label>
                            <div>
                                <input type="email" name="mail" id="txtEmail" 
                                       placeholder="E-mail"
                                       required />

                                <div
                                    class="erro-input">
                                    <br>
                                </div>
                            </div>

                        </div>

                        <div>
                            <button type="submit">Enviar</button>
                            <button type="reset">Resetar dados</button>
                            <a href="#" role="button">Cancelar</a>
                        </div>

               
            </section>
        </div> 

   
