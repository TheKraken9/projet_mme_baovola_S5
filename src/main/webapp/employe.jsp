<%@ page import="java.util.ArrayList" %>
<%@ page import="org.project.projet_mme_baovola.model.Bouquet" %>
<%@ page import="org.project.projet_mme_baovola.model.Duree" %>
<%@ page import="org.project.projet_mme_baovola.model.Employe" %>
<%@ page import="org.project.projet_mme_baovola.model.Poste" %><%--
  Created by IntelliJ IDEA.
  User: thekraken9
  Date: 2024-01-16
  Time: 15:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    ArrayList<Bouquet> bouquets = (ArrayList<Bouquet>) request.getAttribute("bouquets");
    ArrayList<Duree> durees = (ArrayList<Duree>) request.getAttribute("durees");
    ArrayList<Employe> employes = (ArrayList<Employe>) request.getAttribute("employes");
    ArrayList<Poste> postes = (ArrayList<Poste>) request.getAttribute("postes");
%>
<html>
<head>
    <title>Employe</title>
    <link rel="stylesheet" href="bootstrap.css">
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
</head>
<body>
<h4 class="text-center">Nouveau employe</h4>
<form method="post" action="EmployeServlet" class="mt-8 w-25 mx-auto border shadow-lg rounded-2 p-5">
    <label for="nom">Nom : </label>
    <input type="text" id="nom" name="nom" class="p-2 border rounded-md mb-3" placeholder="nom"><br/>
    <label for="poste">Poste : </label>
    <select id="poste" name="poste" class="mt-1 p-2 border rounded-md">
        <%
            for (Poste poste : postes) {
        %>
        <option value="<%= poste.getIdPoste() %>"><%= poste.getNomPoste() %></option>
        <%
            }
        %>
    </select><br/><br/>
    <label for="cin">CIN : </label>
    <input type="text" id="cin" name="cin" class="p-2 border rounded-md mb-3" placeholder="cin"><br/>
    <select name="niveau" class="mt-1 p-2 border rounded-md">
        <option value="junior">junior</option>
        <option value="senior">senior</option>
        <option value="expert">expert</option>
    </select><br/><br/>
    <input type="submit" value="Ajouter" class="btn btn-primary">
</form>
<br><br>
<h4 class="text-center">Salaire employe</h4>
<form method="post" action="SalaireServlet" class="mt-8 w-25 mx-auto border shadow-lg rounded-2 p-5">
    <label for="emp" class="block mt-4 text-sm font-medium text-gray-700">Type</label>
    <select id="emp" name="id_emp" class="mt-1 p-2 border rounded-md">
        <%
            for (Employe employe : employes) {
        %>
        <option value="<%= employe.getIdEmploye() %>"><%= employe.getNom() %></option>
        <%
            }
        %>
    </select><br/>
    <label for="salaire" class="mt-3">Salaire : </label>
    <input type="number" id="salaire" name="salaire" class="p-2 border rounded-md mb-3" placeholder="Salaire"><br/>
    <label for="date" class="mt-3">Date : </label>
    <input type="date" id="date" name="date" class="p-2 border rounded-md mb-3" placeholder="Date"><br/>
    <input type="submit" value="Ajouter" class="btn btn-primary">
</form>
<br><br>
<h4 class="text-center">Embauche employe</h4>
<form method="post" action="EmbaucheServlet" class="mt-8 w-25 mx-auto border shadow-lg rounded-2 p-5">
    <label for="empl" class="block mt-4 text-sm font-medium text-gray-700">Employe</label>
    <select id="empl" name="id_empl" class="mt-1 p-2 border rounded-md">
        <%
            for (Employe employe : employes) {
        %>
        <option value="<%= employe.getIdEmploye() %>"><%= employe.getNom() %></option>
        <%
            }
        %>
    </select><br/>
    <label for="date_emb" class="mt-3">Date : </label>
    <input type="date" id="date_emb" name="date_emb" class="p-2 border rounded-md mb-3" placeholder="Date"><br/>
    <input type="submit" value="Ajouter" class="btn btn-primary">
</form>

<br><br>
<h4 class="text-center">Parametre employe</h4>
<form method="post" action="ParametreServlet" class="mt-8 w-25 mx-auto border shadow-lg rounded-2 p-5">
    <label for="niveau" class="block mt-4 text-sm font-medium text-gray-700">Niveau</label>
    <select id="niveau" name="niveau" class="mt-1 p-2 border rounded-md">
        <option value="junior">junior</option>
        <option value="senior">senior</option>
        <option value="expert">expert</option>
    </select><br/>
    <label for="duree_empl" class="mt-3">Duree : </label>
    <input type="text" id="duree_empl" name="duree_empl" class="p-2 border rounded-md mb-3" placeholder="Volume annuel"><br/>
    <label for="salaire_empl" class="mt-3">Volume : </label>
    <input type="text" id="salaire_empl" class="mt-1 p-2 border rounded-md" placeholder="volume">
    <input type="submit" value="Ajouter" class="btn btn-primary">
</form>

<br><br>

<h4 class="text-center">Nouveau poste</h4>
<form method="post" action="PosteServlet" class="mt-8 w-25 mx-auto border shadow-lg rounded-2 p-5">
    <label for="post" class="block mt-4 text-sm font-medium text-gray-700">Poste : </label>
    <input type="text" name="post" id="post" class="p-2 border rounded-md mb-3" placeholder="poste"><br/>
    <input type="submit" value="Ajouter" class="btn btn-primary">
</form>
<br><br>
<h4 class="text-center">Nouveau Voyage</h4>
<div class="mt-8 w-25 mx-auto border shadow-lg rounded-2 p-5">
    <label for="bouquet" class="block mt-4 text-sm font-medium text-gray-700">Bouquet</label>
    <select id="bouquet" name="id_bouquet" class="mt-1 p-2 border rounded-md">
        <%
            for (Bouquet bouquet : bouquets) {
        %>
        <option value="<%= bouquet.getId_bouquet() %>"><%= bouquet.getNom() %></option>
        <%
            }
        %>
    </select><br/>
    <label for="duree" class="block mt-4 text-sm font-medium text-gray-700">Duree</label>
    <select id="duree" name="id_duree" class="mt-1 p-2 border rounded-md">
        <%
            for (Duree duree : durees) {
        %>
        <option value="<%= duree.getIdDuree() %>"><%= duree.getDuree() %></option>
        <%
            }
        %>
    </select><br/>
    <label for="date1" class="mt-3">Date : </label>
    <input type="date" id="date1" name="date1" class="p-2 border rounded-md mb-3" placeholder="Date"><br/>
    <button onClick="envoyer()" class="btn btn-primary">Envoyer</button><br/><br/>
    <button type="button" onClick="ajouter()" class="btn btn-secondary">Ajouter</button><br/><br/>
    <div class="component">
        <select name="id_emp" class="all_emp" class="mt-1 p-2 border rounded-md">
            <%
                for (Employe employe : employes) {
            %>
                <option value="<%= employe.getIdEmploye() %>"><%= employe.getNom() %> </option>
            <%
                }
            %>
        </select>
        <input type="number" name="heure" id="heure" class="p-2 border rounded-md mb-3" placeholder="duree" />
    </div>
</div>
<br/><br/>
<h4 class="text-center">Prix de vente</h4>
<form method="post" action="PrixDeVenteServlet" class="mt-8 w-25 mx-auto border shadow-lg rounded-2 p-5">
    <label for="bouquet1" class="block mt-4 text-sm font-medium text-gray-700">Bouquet</label>
    <select id="bouquet1" name="id_bouquet1" class="mt-1 p-2 border rounded-md">
        <%
            for (Bouquet bouquet : bouquets) {
        %>
        <option value="<%= bouquet.getId_bouquet() %>"><%= bouquet.getNom() %></option>
        <%
            }
        %>
    </select><br/>
    <label for="duree1" class="block mt-4 text-sm font-medium text-gray-700">Duree</label>
    <select id="duree1" name="id_duree1" class="mt-1 p-2 border rounded-md">
        <%
            for (Duree duree : durees) {
        %>
        <option value="<%= duree.getIdDuree() %>"><%= duree.getDuree() %></option>
        <%
            }
        %>
    </select><br/>
    <label for="price" class="mt-3">Prix : </label>
    <input type="number" id="price" name="price" class="p-2 border rounded-md mb-3" placeholder="Prix"><br/>
    <input type="submit" value="Envoyer" class="btn btn-primary">
    <br/><br/>
</form>
<br/><br/>
<h4 class="text-center">Filtrage</h4>
<form method="post" action="FiltreServlet" class="mt-8 w-25 mx-auto border shadow-lg rounded-2 p-5">
    <label for="prix1">Prix min : </label>
    <input type="number" id="prix1" name="prix1" class="p-2 border rounded-md mb-3" placeholder="prix min"><br/>
    <label for="prix2">Prix max : </label>
    <input type="number" id="prix2" name="prix2" class="p-2 border rounded-md mb-3" placeholder="prix max"><br/>
    <input type="submit" value="Voir" class="btn btn-primary">
</form>
<script>
    let component = document.getElementsByClassName("component");
    function ajouter() {
        var clone = component[0].cloneNode(true);
        component[0].parentNode.appendChild(clone);
    }

    let all_result = [];

    function envoyer() {
        let component = document.getElementsByClassName("component");
        let all_emp = document.getElementsByClassName("all_emp");
        let id_bouquet = document.getElementById("bouquet").value;
        let id_duree = document.getElementById("duree").value;
        console.log(all_emp);
        for (let i = 0; i < component.length; i++) {
            let emp = {
                idEmploye: all_emp[i].value,
                heure: component[i].children[1].value
            }
            all_result.push(emp);
        }
        console.log(all_result);
        let date = document.getElementById("date1").value;
        $.ajax({
            type: "POST",
            url: "http://localhost:8080/projet_Mme_Baovola_war_exploded/PrixDeRevientServlet",
            data: JSON.stringify({
                employeVoyages: all_result,
                date: date,
                idBouquet: id_bouquet,
                idDuree: id_duree
            }),
            contentType: "application/json",
            success: function (data) {
                console.log(data);
            }
        });
    }

</script>

</body>
</html>
