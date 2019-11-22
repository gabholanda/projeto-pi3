<%-- 
    Document   : Home
    Created on : 18/11/2019, 21:17:20
    Author     : lucas.mnpaiva
--%>

<%@page import="java.time.ZoneId"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
 <%@ page import="java.util.*" %>
<!DOCTYPE html>
<html>
    <head>

        <link href="${pageContext.request.contextPath}/css/home.css" rel="stylesheet">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home</title>
     
    </head>
    <body>
        <div id="carouselExampleControls" class="carousel slide" data-ride="carousel">
            <div class="carousel-inner">
                <div class="carousel-item active">
                    <img class="d-block w-100" src="${pageContext.request.contextPath}/Images/Products/Playstation4.jpg" alt="First Product">
                </div>
                <div class="carousel-item">
                    <img class="d-block w-100" src="${pageContext.request.contextPath}/Images/Products/XboxLive.jpg"  alt="Segundo Slide">
                </div>
                <div class="carousel-item">
                    <img class="d-block w-100" src="${pageContext.request.contextPath}/Images/Products/xboxOne.jpg" alt="Terceiro Slide">
                </div>
                <div class="carousel-item">
                    <img class="d-block w-100" src="${pageContext.request.contextPath}/Images/Products/PSNbanner.jpg" alt="Terceiro Slide">
                </div>
               
            </div>
            <a class="carousel-control-prev" href="#carouselExampleControls" role="button" data-slide="prev">
                <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                <span class="sr-only">Anterior</span>
            </a>
            <a class="carousel-control-next" href="#carouselExampleControls" role="button" data-slide="next">
                <span class="carousel-control-next-icon" aria-hidden="true"></span>
                <span class="sr-only">Próximo</span>
            </a>
        </div>
                      
    </body>
</html>
