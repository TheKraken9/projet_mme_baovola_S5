<%@ page import="java.util.ArrayList" %>
<%@ page import="org.project.projet_mme_baovola.model.Bouquet" %>
<%@ page import="org.project.projet_mme_baovola.model.Lieu" %>
<%@ page import="org.project.projet_mme_baovola.model.Duree" %><%--
  Created by IntelliJ IDEA.
  User: thekraken9
  Date: 2023-12-12
  Time: 20:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    ArrayList<Bouquet> bouquets = (ArrayList<Bouquet>) request.getAttribute("bouquets");
    ArrayList<Lieu> lieux = (ArrayList<Lieu>) request.getAttribute("lieux");
    ArrayList<Duree> durees = (ArrayList<Duree>) request.getAttribute("durees");
%>
<html>
<head>
    <meta charset="UTF-8">
    <title>Voyage</title>
    <link rel="stylesheet" href="bootstrap.css" />
</head>
<body>
<h4 class="text-center mt-3">Insertion de nouveau voyage</h4>
    <form method="post" action="VoyageServlet" class="mt-8 w-25 mx-auto border shadow-lg rounded-2 p-5">
        <label for="nom">Nom :</label>
        <input type="text" name="nom" id="nom" class="p-2 border rounded-md mb-3" placeholder="nom">
        <br>
        <label for="cin">CIN</label>
        <input type="text" name="cin" id="cin" class="p-2 border rounded-md mb-3" placeholder="CIN">
        <br>
        <label for="contact">Contact</label>
        <input type="text" name="contact" id="contact" class="p-2 border rounded-md mb-3" placeholder="contact">
        <br>
        <!--<label for="dateDebut">Date debut : </label>
        <input type="datetime-local" id="dateDebut" name="dateDebut" class="p-2 border rounded-md mb-3" required>
        <br>
        <label for="dateFin">Date fin : </label>
        <input type="datetime-local" id="dateFin" name="dateFin" class="p-2 border rounded-md mb-3" required>
        <br>-->
        <label for="date">Date : </label>
        <input type="date" id="date" name="date" class="p-2 border rounded-md mb-3" required>
        <br>
        <label for="lieu">Categorie de lieu : </label>
        <select id="lieu" name="lieu" class="mt-1 p-2 border rounded-md">
            <% for (Lieu lieu : lieux) { %>
                <option value="<%= lieu.getId_lieu() %>"><%= lieu.getNom() %></option>
            <% } %>
        </select>
        <br>
        <label for="bouquet">Bouquet : </label>
        <select id="bouquet" name="bouquet" class="mt-1 p-2 border rounded-md">
            <% for (Bouquet bouquet : bouquets) { %>
                <option value="<%= bouquet.getId_bouquet() %>"><%= bouquet.getNom() %></option>
            <% } %>
        </select>
        <br>
        <label for="duree">Duree : </label>
        <select id="duree" name="duree" class="mt-1 p-2 border rounded-md">
            <% for (Duree duree : durees) { %>
            <option value="<%= duree.getIdDuree() %>"><%= duree.getDuree() %></option>
            <% } %>
        </select>
        <br>
        <label for="nombre">Nombre : </label>
        <input type="number" name="nombre" id="nombre" class="p-2 border rounded-md mb-3" placeholder="nombre">
        <div id="activite">

        </div>
        <input type="submit" value="Suivant" class="btn btn-primary mt-3">
    </form>
</body>
<script>
    /*var id_bouquet = document.getElementById("bouquet").value;
    console.log(id_bouquet);
    var listes_de_activites_par_ajax = () => {
        var xhr = new XMLHttpRequest();
        xhr.open('GET', 'ActiviteServlet?id_bouquet=' + id_bouquet, true);
        xhr.onload = () => {
            if (xhr.status === 200) {
                var activites = JSON.parse(xhr.responseText);
                var select = document.getElementById("activite");
                select.innerHTML = "";
                for (var i = 0; i < activites.length; i++) {
                    var option = document.createElement("option");
                    option.value = activites[i].id_activite;
                    option.text = activites[i].nom;
                    select.appendChild(option);
                }
            }
        };
        xhr.send();
    };*/
</script>
</html>
