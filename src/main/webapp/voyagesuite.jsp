<%@ page import="java.util.ArrayList" %>
<%@ page import="org.project.projet_mme_baovola.model.Activite" %><%--
  Created by IntelliJ IDEA.
  User: thekraken9
  Date: 2023-12-12
  Time: 21:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String dateDebut = request.getParameter("dateDebut");
    String dateFin = request.getParameter("dateFin");
    String id_bouquet = request.getParameter("bouquet");
    String id_lieu = request.getParameter("lieu");
    String id_duree = request.getParameter("duree");
    String dureeMinutes = request.getParameter("duree_minutes");
    String nom = request.getParameter("nom");
    String cin = request.getParameter("cin");
    String contact = request.getParameter("contact");
    ArrayList<Activite> activites = (ArrayList<Activite>) request.getAttribute("activites");
%>
<html>
<head>
    <title>Activites</title>
    <link rel="stylesheet" href="bootstrap.css" />
</head>
<body>
    <form method="post" action="VoyageSuite" class="mt-8 w-25 mx-auto border shadow-lg rounded-2 p-5">
        <input type="text" name="nom" value="<%= nom %>" class="p-2 border rounded-md mb-3"><br/>
        <input type="text" name="cin" value="<%= cin %>" class="p-2 border rounded-md mb-3"><br/>
        <input type="text" name="contact" value="<%= contact %>" class="p-2 border rounded-md mb-3"><br/>
        <input type="hidden" name="dateDebut" value="<%= dateDebut %>">
        <input type="hidden" name="dateFin" value="<%= dateFin %>">
        <input type="hidden" name="id_bouquet" value="<%= id_bouquet %>">
        <input type="hidden" name="id_lieu" value="<%= id_lieu %>">

        <label for="nb">Nombre d'heure</label>
        <input type="text" id="nb" class="p-2 border rounded-md mb-3" name="duree_total" value="${ duree/60 }" disabled>
        <br>
        <h4>Activites disponibles</h4>
        <% for (Activite activite : activites) { %>
        <p><input type="checkbox" class="form-check-input" name="activites" value="<%= activite.getId_activite() %>"><span class="mx-3"></span><%= activite.getNom() %> - <%= activite.getNom_duree() %></p>
            <input type="hidden" name="duree" value="<%= activite.getDuree() %>">
        <br>
        <% } %><br/>
        <input type="text" name="somme" id="som" class="p-2 border rounded-md mb-3" disabled>
        <input type="submit" value="Terminer" class="btn btn-primary">
    </form>
</body>
<script>
    let somme = 0;
    let inputs = document.getElementsByName("activites");
    let durees = document.getElementsByName("duree");
    let total = document.getElementById("som");
    let duree_total = document.getElementsByName("duree_total");
    for (let i = 0; i < inputs.length; i++) {
        inputs[i].addEventListener("click", function () {
            if (this.checked) {
                somme += parseInt(durees.item(i).value);
            } else {
                somme -= parseInt(durees.item(i).value);
            }
            if(somme > parseInt(duree_total.value)){
                alert("La somme des activites ne doit pas depasser la duree du voyage");
                this.checked = false;
                somme -= parseInt(durees.item(i).value);
            }
            document.getElementById("som").value = somme;
        });
    }
</script>
</html>
