<%@ page import="java.util.ArrayList" %>
<%@ page import="org.project.projet_mme_baovola.model.Prix" %><%--
  Created by IntelliJ IDEA.
  User: thekraken9
  Date: 2024-01-16
  Time: 16:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    ArrayList<Prix> prix = (ArrayList<Prix>) request.getAttribute("prix");
%>
<html>
<head>
    <title>Filtre</title>
    <link rel="stylesheet" href="bootstrap.css">
</head>
<body class="container">
<table class="table table-striped table-bordered mt-5">
    <thead>
        <tr>
            <th>Bouquet</th>
            <th>Duree</th>
            <th>Benefice</th>
        </tr>
    </thead>
    <tbody>
        <% for (Prix p : prix) { %>
        <tr>
            <td><%= p.getBouquet() %></td>
            <td><%= p.getDuree() %></td>
            <td><%= p.getBenefice() %></td>
        </tr>
        <% } %>
    </tbody>
</table>
</body>
</html>
