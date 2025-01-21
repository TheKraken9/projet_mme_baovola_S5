<%@ page import="java.util.ArrayList" %>
<%@ page import="org.project.projet_mme_baovola.model.Activite" %><%--
  Created by IntelliJ IDEA.
  User: thekraken9
  Date: 2024-01-11
  Time: 10:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    ArrayList<Activite> activites = (ArrayList<Activite>) request.getAttribute("activites");
%>
<html>
<head>
    <title>Details activites</title>
    <link rel="stylesheet" href="bootstrap.css" />
</head>
<body class="container mt-5">
<h4 class="text-center">Insertion</h4>
<form action="DetailsActivite" method="post" class="mt-8 w-25 mx-auto border shadow-lg rounded-2 p-5">
    <label for="act" class="block mt-4 text-sm font-medium text-gray-700">Activite</label><br/>
    <select id="act" name="activite" class="mt-1 p-2 border rounded-md">
        <%
            for (Activite activite : activites) {
        %>
        <option value="<%= activite.getId_activite() %>"><%= activite.getNom() %></option>
        <%
            }
        %>
    </select><br/>
    <label for="prix" class="mt-3">Prix : </label>
    <input type="number" id="prix" name="prix" class="p-2 border rounded-md" placeholder="prix"><br/>
    <label for="date" class="mt-3">Date : </label><br/>
    <input type="date" id="date" name="date" class="p-2 border rounded-md mb-3" placeholder="date"><br/>
    <input type="submit" value="Ajouter" class="btn btn-primary">
</form>
<br><br>
<h4 class="text-center">Insertion billet</h4>
<form action="DetailsServlet2" method="post" class="mt-8 w-25 mx-auto border shadow-lg rounded-2 p-5">
    <label for="act1" class="block mt-4 text-sm font-medium text-gray-700">Activite</label><br/>
    <select id="act1" name="activite" class="mt-1 p-2 border rounded-md">
        <%
            for (Activite activite : activites) {
        %>
        <option value="<%= activite.getId_activite() %>"><%= activite.getNom() %></option>
        <%
            }
        %>
    </select><br/>
    <label for="date1" class="mt-3">Date : </label><br/>
    <input type="date" id="date1" name="date1" class="p-2 border rounded-md mb-3" placeholder="date"><br/>
    <label for="quantite1" class="mt-3">Quantite : </label><br/>
    <input type="number" id="quantite1" name="quantite1" class="p-2 border rounded-md mb-3" placeholder="quantite"><br/>
    <input type="submit" value="Ajouter" class="btn btn-primary">
</form>
</body>
</html>
