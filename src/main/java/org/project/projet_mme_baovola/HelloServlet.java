package org.project.projet_mme_baovola;

import java.io.*;
import java.sql.Connection;
import java.util.ArrayList;

import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import org.project.projet_mme_baovola.connecting.Connecting;
import org.project.projet_mme_baovola.model.Activite;
import org.project.projet_mme_baovola.model.Bouquet;
import org.project.projet_mme_baovola.model.Duree;
import org.project.projet_mme_baovola.model.Lieu;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {
    private String message;

    public void init() {
        message = "Hello World!";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String pathJsp = "/ajout.jsp";
        ArrayList<Bouquet> bouquets = new ArrayList<Bouquet>();
        ArrayList<Activite> activites = new ArrayList<Activite>();
        ArrayList<Lieu> lieux = new ArrayList<Lieu>();
        ArrayList<Duree> durees = new ArrayList<Duree>();
        Bouquet bouquet = new Bouquet();
        Activite activite = new Activite();
        Lieu lieu = new Lieu();
        Duree duree = new Duree();
        try{
            Connection connection = Connecting.getConnection("postgres");
            bouquets = bouquet.getAllBouquet(connection);
            activites = activite.getAllActivites(connection);
            lieux = lieu.getAllLieu(connection);
            durees = duree.getAllDuree(connection);
            request.setAttribute("bouquets", bouquets);
            request.setAttribute("activites", activites);
            request.setAttribute("lieux", lieux);
            request.setAttribute("durees", durees);
            request.getRequestDispatcher(pathJsp).forward(request, response);
        }catch(Exception e){
            System.out.println(e);
        }
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id_bouquet = Integer.parseInt(request.getParameter("bouquet"));
        int id_activite = Integer.parseInt(request.getParameter("activite"));
        int id_lieu = Integer.parseInt(request.getParameter("lieu"));
        int duree = Integer.parseInt(request.getParameter("duree"));
        int seance = Integer.parseInt(request.getParameter("seance"));
        //int prix = Integer.parseInt(request.getParameter("prix"));
        //System.out.println("prix : " + prix);
        //String duree = request.getParameter("duree");
        try{
            Connection connection = Connecting.getConnection("postgres");
            Activite activite = new Activite();
            activite.setId_bouquet(id_bouquet);
            activite.setId_activite(id_activite);
            activite.setId_lieu(id_lieu);
            activite.setId_duree(duree);
            activite.setSeance(seance);
            //activite.setDuree(Double.parseDouble(duree));
            //activite.setPrix(prix);
            activite.insertActiviteParBouquet(connection);
            response.sendRedirect("hello-servlet");
        }catch(Exception e){
            System.out.println(e);
        }
    }

    public void destroy() {
    }
}