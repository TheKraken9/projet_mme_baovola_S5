<%@ page import="java.util.ArrayList" %>
<%@ page import="org.project.projet_mme_baovola.model.Activite" %><%--
  Created by IntelliJ IDEA.
  User: thekraken9
  Date: 2024-01-11
  Time: 14:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    ArrayList<Activite> activites = (ArrayList<Activite>) request.getAttribute("activites");
    String quantite = (String) request.getAttribute("quantite");
%>
<html>
<head>
    <title>Resultat reservation</title>
    <link rel="stylesheet" href="bootstrap.css">
</head>
<body class="container mt-5">
<table class="table table-striped table-bordered">
    <thead class="thead-dark">
        <th>Bouquet</th>
        <th>Type</th>
        <th>Duree</th>
        <th>Activite</th>
        <th>Nombre de seances</th>
        <th>Nombre de seances total</th>
        <th>En stock restant</th>
        <th>Nombre de billet manquant</th>
    </thead>
    <tbody>
    <% for (Activite activite : activites) { %>
    <tr>
        <td><%= activite.getNom_bouquet() %></td>
        <td><%= activite.getLieu() %></td>
        <td><%= activite.getNom_duree() %></td>
        <td><%= activite.getActivite() %></td>
        <td><%= activite.getSeance() %></td>
        <td><%= (Double.parseDouble(quantite) * activite.getSeance()) %></td>
        <td><%= activite.getSomme() %></td>
        <td <% if(activite.getManquant()>0){ %> class="bg-danger" <% } %>><%= activite.getManquant() %></td>
    </tr>
    <% } %>
    </tbody>
</table>
</body>
</html>
