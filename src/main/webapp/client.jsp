<%@ page import="java.util.ArrayList" %>
<%@ page import="org.project.projet_mme_baovola.model.Genre" %><%--
  Created by IntelliJ IDEA.
  User: thekraken9
  Date: 2024-01-25
  Time: 14:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    ArrayList<Genre> genres = (ArrayList<Genre>) request.getAttribute("genres");
%>
<html>
<head>
    <title>Clientele</title>
    <link rel="stylesheet" href="bootstrap.css">
</head>
<body class="container">
<div class="text-center mt-5 mb-5">
    <a href="NewVoyageServlet" class="btn btn-secondary">Insertion nouveau voyage</a>
</div>
<h4 class="text-center">Ajout Client</h4>
<form method="post" action="ClientServlet" class="mt-8 w-25 mx-auto border shadow-lg rounded-2 p-5">
    <label for="nom" class="mt-3">Nom : </label>
    <input type="text" id="nom" name="nom" class="p-2 border rounded-md mb-3" placeholder="nom du client"><br/>
    <label for="genre" class="block text-sm font-medium text-gray-700">Genre</label>
    <select id="genre" name="genre" class="mt-1 p-2 border rounded-md">
        <%
            for (Genre genre : genres) {
        %>
        <option value="<%= genre.getIdGenre() %>"><%= genre.getGenre() %></option>
        <%
            }
        %>
    </select><br/>
    <input type="submit" value="Ajouter" class="btn btn-primary">
</form>
<br><br>
</body>
</html>
