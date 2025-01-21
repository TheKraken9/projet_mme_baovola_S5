package org.project.projet_mme_baovola;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import org.project.projet_mme_baovola.connecting.Connecting;
import org.project.projet_mme_baovola.model.Voyage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Timestamp;
import java.time.LocalDateTime;

@WebServlet(name = "VoyageSuite", value = "/VoyageSuite")
public class VoyageSuite extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id_bouquet = request.getParameter("id_bouquet");
        String id_lieu = request.getParameter("id_lieu");
        String dateDebut = request.getParameter("dateDebut");
        String dateFin = request.getParameter("dateFin");
        String[] activites = request.getParameterValues("activites");
        String nom = request.getParameter("nom");
        String cin = request.getParameter("cin");
        String contact = request.getParameter("contact");

        //String dateDebut2 = dateDebut.replace("T", " ");
        //String dateFin2 = dateFin.replace("T", " ");


        int id = 0;
        try{
            Connection connection = Connecting.getConnection("postgres");
            Voyage voyage = new Voyage();
            voyage.setNom(nom);
            voyage.setCin(cin);
            voyage.setContact(contact);
            voyage.setId_bouquet(Integer.parseInt(id_bouquet));
            voyage.setId_lieu(Integer.parseInt(id_lieu));
            voyage.setDate_debut(LocalDateTime.parse(dateDebut));
            voyage.setDate_fin(LocalDateTime.parse(dateFin));

            id = voyage.insertVoyage(connection);
            for (String activite : activites) {
                voyage.insertVoyageActivite(connection, id, activite);
            }
            response.sendRedirect("hello-servlet");
        }catch (Exception e){
            System.out.println(e);
        }
    }
}