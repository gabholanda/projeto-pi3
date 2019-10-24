<%-- 
    Document   : Filial
    Created on : 16/10/2019, 21:14:25
    Author     : lucas.mnpaiva
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<link href="../../css/Cbranch.css" rel="stylesheet" id="bootstrap-css">

<body>

<div class="wrapper fadeInDown">
  <div id="formContent">

    <form>
     <div class="form-group">
    <label for="exampleFormControlInput1">Nome da filial</label>
    <input type="text" class="form-control" name="name" id="exampleFormControlInput1" placeholder="Branch Office">
  </div>
     <div class="form-group">
    <label for="exampleFormControlInput1">Endereço</label>
    <input type="text" class="form-control"name="address" id="exampleFormControlInput1" placeholder="Address">
  </div>
    <div class="form-group">
    <label for="exampleFormControlInput1">CNPJ</label>
    <input type="text" class="form-control" name="cnpj" id="exampleFormControlInput1" placeholder="CNPJ">
    <button>Submit </button>
    </form>
  </div>
</div>
</div>
</body>