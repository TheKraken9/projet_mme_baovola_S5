<%@ page import="java.util.ArrayList" %>
<%@ page import="org.project.projet_mme_baovola.model.Activite" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%
    ArrayList<Activite> activites = (ArrayList<Activite>) request.getAttribute("activites");
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Gestion de projet</title>
    <link rel="stylesheet" href="bootstrap.css">
</head>
<body class="container mt-5">
    <table class="table table-striped table-bordered">
        <thead class="thead-dark">
            <th>Activite</th>
            <th>Duree</th>
        </thead>
        <tbody>
            <% for (Activite activite : activites) { %>
                <tr>
                    <td><%= activite.getNom() %></td>
                    <td><%= activite.getNom_duree() %></td>
                </tr>
            <% } %>
        </tbody>
    </table>
</body>

</html>