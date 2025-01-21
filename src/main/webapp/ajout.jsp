<%@ page import="java.util.ArrayList" %>
<%@ page import="org.project.projet_mme_baovola.model.Bouquet" %>
<%@ page import="org.project.projet_mme_baovola.model.Activite" %>
<%@ page import="org.project.projet_mme_baovola.model.Lieu" %>
<%@ page import="org.project.projet_mme_baovola.model.Duree" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%
    ArrayList<Bouquet> bouquets = (ArrayList<Bouquet>) request.getAttribute("bouquets");
    ArrayList<Activite> activites = (ArrayList<Activite>) request.getAttribute("activites");
    ArrayList<Lieu> lieux = (ArrayList<Lieu>) request.getAttribute("lieux");
    ArrayList<Duree> durees = (ArrayList<Duree>) request.getAttribute("durees");
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Gestion de projet</title>
    <link rel="stylesheet" href="bootstrap.css" />
</head>

<body>
<div class="text-center mt-5 mb-5">
    <a href="ClientServlet" class="btn btn-secondary">Insertion nouveau client</a>
</div>
<div class="text-center mt-5 mb-5">
    <a href="EtatEmployeServlet" class="btn btn-secondary">Voir etat actuel</a>
</div>
<div class="text-center mt-5 mb-5">
    <a href="VoyageServlet" class="btn btn-secondary">Inserer un nouveau voyage</a>
</div>
<div class="text-center mt-5 mb-5">
    <a href="EmployeServlet" class="btn btn-secondary">Inserer un nouveau employe</a>
</div>
<h4 class="text-center">Ajout Activite par bouquet</h4>
<form method="post" action="hello-servlet" class="mt-8 w-25 mx-auto border shadow-lg rounded-2 p-5">
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
    <label for="lieu" class="block mt-4 text-sm font-medium text-gray-700">Type</label>
    <select id="lieu" name="lieu" class="mt-1 p-2 border rounded-md">
        <%
            for (Lieu lieu : lieux) {
        %>
        <option value="<%= lieu.getId_lieu() %>"><%= lieu.getNom() %></option>
        <%
            }
        %>
    </select><br/>
    <label for="act" class="block mt-4 text-sm font-medium text-gray-700">Activite</label>
    <select id="act" name="activite" class="mt-1 p-2 border rounded-md">
        <%
            for (Activite activite : activites) {
        %>
        <option value="<%= activite.getId_activite() %>"><%= activite.getNom() %></option>
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
    <label for="seance" class="mt-3">Nombre de séance : </label>
    <input type="number" id="seance" name="seance" class="p-2 border rounded-md mb-3" placeholder="nombre de seance"><br/>
    <!--<label for="prix">Prix : </label>
    <input type="number" id="prix" name="prix">-->
    <input type="submit" value="Ajouter" class="btn btn-primary">
</form>
<br><br>
<h4 class="text-center">Voyage entre deux prix</h4>
<form method="post" action="PrixServlet" class="mt-8 w-25 mx-auto border shadow-lg rounded-2 p-5">
    <label for="prix1">Prix min : </label>
    <input type="number" id="prix1" name="prix1" class="p-2 border rounded-md mb-3" placeholder="prix min"><br/>
    <label for="prix2">Prix max : </label>
    <input type="number" id="prix2" name="prix2" class="p-2 border rounded-md mb-3" placeholder="prix max"><br/>
    <input type="submit" value="Voir" class="btn btn-primary">
</form>
<br><br>
    <h4 class="text-center">Activites par bouquet</h4>
<form method="post" action="ListServlet" class="mt-8 w-25 mx-auto border shadow-lg rounded-2 p-5">
    <label for="bouq" class="block text-sm font-medium text-gray-700">Bouquets</label>
    <select id="bouq" name="bouquet" class="mt-1 p-2 border rounded-md">
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
<br><br>
<h4 class="text-center">Info par activités</h4>
<form method="post" action="ListBouquetParActiviteServlet" class="mt-8 w-25 mx-auto border shadow-lg rounded-2 p-5">
    <label for="acti" class="block mt-4 text-sm font-medium text-gray-700">Activite</label>
    <select id="acti" name="activite" class="mt-1 p-2 border rounded-md">
        <%
            for (Activite activite : activites) {
        %>
        <option value="<%= activite.getId_activite() %>"><%= activite.getNom() %></option>
        <%
            }
        %>
    </select><br/>
    <input type="submit" value="Voir" class="btn btn-primary mt-3">
</form>
<br><br>
<h4 class="text-center">Ajout Bouquet</h4>
<form method="post" action="BouquetServlet" class="mt-8 w-25 mx-auto border shadow-lg rounded-2 p-5">
    <input type="text" name="bouquet" class="p-2 border rounded-md mb-3" placeholder="bouquet"><br/>
    <input type="submit" value="Ajouter" class="btn btn-primary">
</form>
<br><br>
<h4 class="text-center">Ajout Activite</h4>
<form method="post" action="ActiviteServlet" class="mt-8 w-25 mx-auto border shadow-lg rounded-2 p-5">
    <input type="text" name="activite" class="p-2 border rounded-md mb-3" placeholder="activite"><br/>
    <input type="submit" value="Ajouter" class="btn btn-primary">
</form>
<div class="text-center mt-5 mb-5">
    <a href="DetailsActivite" class="btn btn-secondary">inserer billet</a>
</div>
<br><br>
<h4 class="text-center">Ajout Lieu</h4>
<form method="post" action="LieuServlet" class="mt-8 w-25 mx-auto border shadow-lg rounded-2 p-5">
    <input type="text" name="lieu" class="p-2 border rounded-md mb-3" placeholder="lieu"><br/>
    <input type="number" name="prix" class="p-2 border rounded-md mb-3" placeholder="tarif"><br/>
    <input type="submit" value="Ajouter" class="btn btn-primary">
</form>
<br><br>
<h4 class="text-center">Ajout Duree</h4>
<form method="post" action="DureeServlet" class="mt-8 w-25 mx-auto border shadow-lg rounded-2 p-5 mb-5">
    <input type="text" name="duree" placeholder="duree" class="p-2 border rounded-md mb-3"><br/>
    <input type="submit" value="Ajouter" class="btn btn-primary">
</form>
</body>

</html>