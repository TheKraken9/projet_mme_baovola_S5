package org.project.projet_mme_baovola;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import org.project.projet_mme_baovola.connecting.Connecting;
import org.project.projet_mme_baovola.model.Activite;
import org.project.projet_mme_baovola.model.Bouquet;
import org.project.projet_mme_baovola.model.Duree;
import org.project.projet_mme_baovola.model.Lieu;

import java.io.IOException;
import java.sql.Connection;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

@WebServlet(name = "VoyageServlet", value = "/VoyageServlet")
public class VoyageServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String pathJsp = "voyage.jsp";
        ArrayList<Bouquet> bouquets = new ArrayList<Bouquet>();
        ArrayList<Lieu> lieux = new ArrayList<Lieu>();
        ArrayList<Duree> durees = new ArrayList<Duree>();
        Bouquet bouquet = new Bouquet();
        Lieu lieu = new Lieu();
        Duree duree = new Duree();
        try{
            Connection connection = Connecting.getConnection("postgres");
            bouquets = bouquet.getAllBouquet(connection);
            lieux = lieu.getAllLieu(connection);
            durees = duree.getAllDuree(connection);
            request.setAttribute("bouquets", bouquets);
            request.setAttribute("lieux", lieux);
            request.setAttribute("durees", durees);
            request.getRequestDispatcher(pathJsp).forward(request, response);
        }catch (Exception e){
            System.out.println(e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //String dateDebut = request.getParameter("dateDebut");
        //String dateFin = request.getParameter("dateFin");
        String date = request.getParameter("date");
        String id_bouquet = request.getParameter("bouquet");
        String id_lieu = request.getParameter("lieu");
        String id_duree = request.getParameter("duree");
        String nom = request.getParameter("nom");
        String cin = request.getParameter("cin");
        String contact = request.getParameter("contact");
        String nombre = request.getParameter("nombre");
        LocalDate dateDebut = LocalDate.parse(date);
        //DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm");
        //LocalDateTime dateDebut2 = LocalDateTime.parse(dateDebut, formatter);
        //LocalDateTime dateFin2 = LocalDateTime.parse(dateFin, formatter);


        //Duration duration = Duration.between(dateDebut2, dateFin2);
        //System.out.println(duration);
        //System.out.println(duration.toMinutes() + " minutes");
        //String minute = String.valueOf(duration.toMinutes());

        //System.out.println(id_bouquet + " " + id_lieu + " " + dateDebut + " " + dateFin);
        ArrayList<Activite> activites = new ArrayList<Activite>();
        try{
            Connection connection = Connecting.getConnection("postgres");
            Activite activite = new Activite();
            activite.setId_bouquet(Integer.parseInt(id_bouquet));
            activite.setId_lieu(Integer.parseInt(id_lieu));
            activite.setId_duree(Integer.parseInt(id_duree));
            activite.setQuantite(Integer.parseInt(nombre));
            activites = activite.verifierSiBilletSuffisant(connection);
            request.setAttribute("activites", activites);
            request.setAttribute("quantite", nombre);
            request.getRequestDispatcher("confirmation.jsp").forward(request, response);
        }catch(Exception e){
            System.out.println(e);
        }
    }
}