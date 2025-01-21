<%@ page import="java.util.ArrayList" %>
<%@ page import="org.project.projet_mme_baovola.model.Demp" %><%--
  Created by IntelliJ IDEA.
  User: thekraken9
  Date: 2024-01-23
  Time: 14:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    ArrayList<Demp> dEmps = (ArrayList<Demp>) request.getAttribute("dEmps");
%>
<html>
<head>
    <title>Etat actuel</title>
    <link rel="stylesheet" href="bootstrap.css">
</head>
<body class="container">
<h4 class="mt-5">Etat actuel</h4>
<table class="table table-striped table-bordered mt-5">
    <thead>
    <tr>
        <th>ID</th>
        <th>Nom</th>
        <th>Taux</th>
        <th>Titre</th>
    </tr>
    </thead>
    <tbody>
    <% for (Demp p :dEmps) { %>
    <tr>
        <td><%= p.getIdEmploye() %></td>
        <td><%= p.getNom() %></td>
        <td><%= p.getSalaire() %></td>
        <td><%= p.getTitre() %></td>
    </tr>
    <% } %>
    </tbody>
</table>
</body>
</html>
