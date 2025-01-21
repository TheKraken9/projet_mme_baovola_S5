<%@ page import="java.util.ArrayList" %>
<%@ page import="org.project.projet_mme_baovola.model.Bouquet" %>
<%--
  Created by IntelliJ IDEA.
  User: thekraken9
  Date: 2024-01-09
  Time: 14:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    ArrayList<Bouquet> bouquets = (ArrayList<Bouquet>) request.getAttribute("bouquets");
%>
<html>
<head>
    <title>Resultats par rapport aux prix</title>
    <link rel="stylesheet" href="bootstrap.css">
</head>
<body class="container">
<table class="table table-striped table-bordered mt-5">
    <thead class="thead-dark">
    <tr>
        <th>Bouquet</th>
        <th>Type</th>
        <th>Durée</th>
        <th>Prix Total(MGA)</th>
        <th>Action</th>
    </tr>
    </thead>
    <tbody>
    <% for (Bouquet bouquet : bouquets) { %>
    <tr>
        <td><%= bouquet.getBouquet() %></td>
        <td><%= bouquet.getLieu() %></td>
        <td><%= bouquet.getDuree() %></td>
        <td><%= bouquet.getPrixTotal() %></td>
        <td><a href="ConfirmationServlet?idBouquet=<%= bouquet.getId_bouquet() %>&idDuree=<%= bouquet.getIdDuree() %>&idLieu=<%= bouquet.getIdLieu() %>">Reserver</a></td>
    </tr>
    <% } %>
    </tbody>
</table>
</body>
</html>
