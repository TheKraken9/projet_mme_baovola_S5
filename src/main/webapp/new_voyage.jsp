<%@ page import="org.project.projet_mme_baovola.model.Client" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="org.project.projet_mme_baovola.model.Bouquet" %>
<%@ page import="org.project.projet_mme_baovola.model.Duree" %><%--
  Created by IntelliJ IDEA.
  User: thekraken9
  Date: 2024-01-25
  Time: 14:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    ArrayList<Client> clients = (ArrayList<Client>) request.getAttribute("clients");
    ArrayList<Bouquet> bouquets = (ArrayList<Bouquet>) request.getAttribute("bouquets");
    ArrayList<Duree> durees = (ArrayList<Duree>) request.getAttribute("durees");
%>
<html>
<head>
    <title>Nouveau voyage</title>
    <link rel="stylesheet" href="bootstrap.css">
</head>
<body class="container">
<h4 class="text-center">Ajout Activite par bouquet</h4>
<form method="post" action="NewVoyageServlet" class="mt-8 w-25 mx-auto border shadow-lg rounded-2 p-5">
    <label for="bouquet" class="block text-sm font-medium text-gray-700">Bouquets</label>
    <select id="bouquet" name="bouquet" class="mt-1 p-2 border rounded-md">
        <%
            for (Bouquet bouquet : bouquets) {
        %>
        <option value="<%= bouquet.getId_bouquet() %>"><%= bouquet.getNom() %></option>
        <%
            }
        %>
    </select><br/>
    <label for="duree" class="block mt-4 text-sm font-medium text-gray-700">Duree</label>
    <select id="duree" name="duree" class="mt-1 p-2 border rounded-md">
        <%
            for (Duree duree : durees) {
        %>
        <option value="<%= duree.getIdDuree() %>"><%= duree.getDuree() %></option>
        <%
            }
        %>
    </select><br/>
    <label for="client" class="block mt-4 text-sm font-medium text-gray-700">Client</label>
    <select id="client" name="client" class="mt-1 p-2 border rounded-md">
        <%
            for (Client client : clients) {
        %>
        <option value="<%= client.getIdClient() %>"><%= client.getNom() %></option>
        <%
            }
        %>
    </select><br/>
    <label for="billet" class="mt-3">Nombre de billet : </label>
    <input type="number" id="billet" name="billet" class="p-2 border rounded-md mb-3" placeholder="nombre de billet"><br/>

    <label for="datee" class="mt-3">Date : </label>
    <input type="date" id="datee" name="date" class="p-2 border rounded-md mb-3" placeholder="nombre de billet"><br/>

    <!--<label for="prix">Prix : </label>
    <input type="number" id="prix" name="prix">-->
    <input type="submit" value="Ajouter" class="btn btn-primary">
</form>
<br><br>
<form method="post" action="StatistiqueServlet" class="mt-8 w-25 mx-auto border shadow-lg rounded-2 p-5">
    <label for="bou" class="block text-sm font-medium text-gray-700">Bouquets</label>
    <select id="bou" name="bouquet" class="mt-1 p-2 border rounded-md">
        <%
            for (Bouquet bouquet : bouquets) {
        %>
        <option value="<%= bouquet.getId_bouquet() %>"><%= bouquet.getNom() %></option>
        <%
            }
        %>
    </select><br/>
    <input type="submit" value="Voir" class="btn btn-primary">
</form>
</body>
</html>
