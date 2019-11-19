<%-- 
    Document   : UserJSP
    Created on : 18/10/2019, 03:24:58
    Author     : marcelo.moraes
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>


<div> 
    <section>

        <h1>Cadastrar Usuario</h1>
        <form method="post" action="">

            <input type="hidden" name="id" value="${idAttr}">

            <div>

                <label for="txtName">
                    Nome do usuario: 
                </label>

                <div>

                    <input type="text" name="name" id="txtName" 
                           placeholder="Digite o nome do usuario: " 
                           required maxlength="100" value="${nomeAttr}" />
                    <c:if test="${erroNome}">
                        <div class="erro-input">
                            Digite o nome do cliente: 
                        </div>
                    </c:if>
                </div>
            </div>


            <div>
                <label for="txtEmail">
                    E-mail
                </label>
                <div>
                    <input type="email" name="email" id="txtEmail" 
                           placeholder="E-mail"
                           required />

                    <div
                        class="erro-input">
                        Digite um e-mail.
                    </div>
                </div>

            </div>

            <div>
                <label for="txtSenha">
                    Senha
                </label>
                <div>
                    <input type="password" name="senha" id="txtSenha" 
                           placeholder="Senha">
                    <c:if test="${erroSenha}">
                        <div class="erro-input com-erro">
                            Senhas digitadas não conferem.
                        </div>
                    </c:if>
                </div>
            </div>
            <div>
                <label for="txtRepetirSenha">
                    Repetir senha
                </label>
                <div>
                    <input type="password" name="repetirSenha" id="txtRepetirSenha" 
                           placeholder="Repetir senha">
                </div>
            </div>

            <fieldset>
                <legend>Permissao</legend>
                <div>
                    <div>
                        <input type="radio" name="permission" 
                               id="fillial1" value="0" ${idBranchOfficeAttr != '1' ? 'checked' : ''} />
                        <label for="optFilial1">
                            Filial 1 
                        </label>
                    </div>
                    <div>
                        <input type="radio" name="permission"
                               id="optSexoM" value="1" ${idBranchOfficeAttr == '1' ? 'checked' : ''} />
                        <label for="optFilial2">
                            Filial 2
                        </label>
                    </div>
                        <div>
                        <input type="radio" name="permission"
                               id="optSexoM" value="2" ${idBranchOfficeAttr == '2' ? 'checked' : ''} />
                        <label for="optFilial3">
                            Filial 3
                        </label>
                    </div>
                </div>
            </fieldset>

            <div>
                <button type="submit">Enviar</button>
                <button type="reset">Resetar dados</button>
                <a href="#" role="button">Cancelar</a>
            </div>


    </section>
</div> 


