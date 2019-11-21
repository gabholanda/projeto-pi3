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
                    <img class="d-block w-100" src="${pageContext.request.contextPath}/Images/Products/Tshirts.jpg" alt="Terceiro Slide">
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
        <div class="album py-5 bg-light">
            <div class="container">
                <div class="row">
                    <div class="col-md-4">
                        <div class="card mb-4 box-shadow">
                            <img class="card-img-top" data-src="holder.js/100px225?theme=thumb&amp;bg=55595c&amp;fg=eceeef&amp;text=Thumbnail" 
                                 alt="Thumbnail [100%x225]" style="height: 225px; width: 100%; display: block;" 
                                 src="${pageContext.request.contextPath}/Images/Products/XboxControl.jpg" data-holder-rendered="true">
                            <div class="card-body">
                                De: <span class=" a-text-strike"> R$359,00 </span>                   Por:  <span class="a-size-medium a-color-price ">R$269,00</span>
                               
                                <div class="d-flex justify-content-between align-items-center">
                                    <div class=""btn-group>
                                        <button type="button" class="btn btn-sm btn-outline-secondary">View</button>
                                        <button type="button" class="btn btn-sm btn-outline-secondary">Cart</button>
                                    </div>
                                    <small class="text-muted"></small>
                                </div>
                            </div>
                        </div>
                        <div class="card mb-4 box-shadow">
                            <img class="card-img-top" data-src="holder.js/100px225?theme=thumb&amp;bg=55595c&amp;fg=eceeef&amp;text=Thumbnail" 
                                 alt="Thumbnail [100%x225]" style="height: 225px; width: 100%; display: block;" 
                                 src="${pageContext.request.contextPath}/Images/Products/PlayStationControl.jpg" data-holder-rendered="true">
                            <div class="card-body">
                               De: <span class=" a-text-strike"> R$2.599,00 </span>                   Por:  <span class="a-size-medium a-color-price ">R$1.979,99</span>
                               
                                <div class="d-flex justify-content-between align-items-center">
                                    <div class=""btn-group>
                                        <button type="button" class="btn btn-sm btn-outline-secondary">View</button>
                                        <button type="button" class="btn btn-sm btn-outline-secondary">Cart</button>
                                    </div>
                                    <small class="text-muted"></small>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="col-md-4">
                        <div class="card mb-4 box-shadow">
                            <img class="card-img-top" data-src="holder.js/100px225?theme=thumb&amp;bg=55595c&amp;fg=eceeef&amp;text=Thumbnail" 
                                 alt="Thumbnail [100%x225]" style="height: 225px; width: 100%; display: block;" 
                                 src="${pageContext.request.contextPath}/Images/Products/tshirtRick.jpg" data-holder-rendered="true">
                            <div class="card-body">
                                De: <span class=" a-text-strike"> R$2.599,00 </span>                   Por:  <span class="a-size-medium a-color-price ">R$1.979,99</span>
                               
                                <div class="d-flex justify-content-between align-items-center">
                                    <div class=""btn-group>
                                        <button type="button" class="btn btn-sm btn-outline-secondary">View</button>
                                        <button type="button" class="btn btn-sm btn-outline-secondary">Cart</button>
                                    </div>
                                    <small class="text-muted"></small>
                                </div>
                            </div>
                        </div>
                        <div class="card mb-4 box-shadow">
                            <img class="card-img-top" data-src="holder.js/100px225?theme=thumb&amp;bg=55595c&amp;fg=eceeef&amp;text=Thumbnail" 
                                 alt="Thumbnail [100%x225]" style="height: 225px; width: 100%; display: block;" 
                                 src="${pageContext.request.contextPath}/Images/Products/TshirtThor.jpg" data-holder-rendered="true">
                            <div class="card-body">
                                De: <span class=" a-text-strike"> R$2.599,00 </span>                   Por:  <span class="a-size-medium a-color-price ">R$1.979,99</span>
                               
                                <div class="d-flex justify-content-between align-items-center">
                                    <div class=""btn-group>
                                        <button type="button" class="btn btn-sm btn-outline-secondary">View</button>
                                        <button type="button" class="btn btn-sm btn-outline-secondary">Cart</button>
                                    </div>
                                    <small class="text-muted"></small>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="col-md-4">
                        <div class="card mb-4 box-shadow">
                            <img class="card-img-top" data-src="holder.js/100px225?theme=thumb&amp;bg=55595c&amp;fg=eceeef&amp;text=Thumbnail" 
                                 alt="Thumbnail [100%x225]" style="height: 225px; width: 100%; display: block;" 
                                 src="${pageContext.request.contextPath}/Images/Products/play4Console.jpg" data-holder-rendered="true">
                            <div class="card-body">
                                De: <span class=" a-text-strike"> R$2.599,00 </span>                   Por:  <span class="a-size-medium a-color-price ">R$1.979,99</span>
                                <div class="d-flex justify-content-between align-items-center">
                                    <div class=""btn-group>
                                        <button type="button" class="btn btn-sm btn-outline-secondary">View</button>
                                        <button type="button" class="btn btn-sm btn-outline-secondary">Cart</button>
                                    </div>
                                    <small class="text-muted"></small>
                                </div>
                            </div>
                        </div>
                        <div class="card mb-4 box-shadow">
                            <img class="card-img-top" data-src="holder.js/100px225?theme=thumb&amp;bg=55595c&amp;fg=eceeef&amp;text=Thumbnail" 
                                 alt="Thumbnail [100%x225]" style="height: 225px; width: 100%; display: block;" 
                                 src="${pageContext.request.contextPath}/Images/Products/Playstation3.jpg" data-holder-rendered="true">
                            <div class="card-body">
                               De: <span class=" a-text-strike"> R$2.599,00 </span>                   Por:  <span class="a-size-medium a-color-price ">R$1.979,99</span>
                               
                                <div class="d-flex justify-content-between align-items-center">
                                    <div class=""btn-group>
                                        <button type="button" class="btn btn-sm btn-outline-secondary">View</button>
                                        <button type="button" class="btn btn-sm btn-outline-secondary">Cart</button>
                                    </div>
                                    <small class="text-muted"></small>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>      
                            <footer  style="background-color: #141014">
                                <div id='divFooter'>
                                <div class="relative">
                                   Developed by: CodeSquad  
</div>
                                     <div class="location">
                                         <%java.text.DateFormat df = new java.text.SimpleDateFormat("dd/MM/yyyy HH:mm"); %>
                                         © São Paulo,Brasil  <%= df.format(new java.util.Date()
                                         )%>
</div>
           </div>    
                            </footer>
    </body>
</html>
