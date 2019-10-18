<%-- 
    Document   : Filial
    Created on : 16/10/2019, 21:14:25
    Author     : lucas.mnpaiva
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Branch Office</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
        <style>
            .scheme { color: #2980b9 }
            .server-name { color: #16a085 }
            .server-port { color: #f39c12 }
            .context-path { color: #c0392b}
            .servlet-path { color: #8e44ad }
            .query-string { color: #95a5a6 }
        </style>
    </head>
    <body>
        
         <form action="${pageContext.request.contextPath}/servelet-branch" method="post">
                        <input type="hidden" name="campo-hidden" value="123" />
                        <div class="form-group">
                            <label>Nome da Filial</label>
                            <input type="text" name="name" class="form-control" />
                        </div>
                        <div class="form-group">
                            <label>CNPJ</label>
                            <input type="text" name="cnpj" class="form-control" />
                        </div>
                        <div class="form-group">
                            <label>Endereço</label>
                            <input type="text" name="address" class="form-control" />
                        </div>
                        <button type="submit" class="btn btn-default">Enviar</button>
                    </form>
    </body>
</html>
