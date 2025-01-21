<%@ page import="java.util.ArrayList" %>
<%@ page import="org.project.projet_mme_baovola.model.Activite" %><%--
  Created by IntelliJ IDEA.
  User: thekraken9
  Date: 2023-12-27
  Time: 16:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    ArrayList<Activite> activites = (ArrayList<Activite>) request.getAttribute("activites");
%>
<html>
<head>
    <title>Listes des bouquets par activité</title>
    <link rel="stylesheet" href="bootstrap.css">
</head>
<body class="container">
<table class="table table-striped table-bordered mt-5">
    <thead class="thead-dark">
    <tr>
        <th>Activité</th>
        <th>Bouquet</th>
        <th>Lieu</th>
        <th>Durée</th>
        <th>Nombre de séance</th>
    </tr>
    </thead>
    <tbody>
    <% for (Activite activite : activites) { %>
    <tr>
        <td><%= activite.getNom() %></td>
        <td><%= activite.getNom_bouquet() %></td>
        <td><%= activite.getLieu() %></td>
        <td><%= activite.getNom_duree() %></td>
        <td><%= activite.getSeance() %></td>
    </tr>
    <% } %>
    </tbody>
</table>
</body>
</html>
