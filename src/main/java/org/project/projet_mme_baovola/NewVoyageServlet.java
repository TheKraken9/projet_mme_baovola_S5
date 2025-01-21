package org.project.projet_mme_baovola;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import org.project.projet_mme_baovola.connecting.Connecting;
import org.project.projet_mme_baovola.model.*;

import java.io.IOException;
import java.sql.Connection;
import java.time.LocalDate;
import java.util.ArrayList;

@WebServlet(name = "NewVoyageServlet", value = "/NewVoyageServlet")
public class NewVoyageServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ArrayList<Client> clients = new ArrayList<Client>();
        ArrayList<Bouquet> bouquets = new ArrayList<Bouquet>();
        ArrayList<Duree> durees = new ArrayList<Duree>();
        Client client = new Client();
        Bouquet bouquet = new Bouquet();
        Duree duree = new Duree();
        try{
            Connection connection = Connecting.getConnection("postgres");
            clients = client.getAllClient(connection);
            bouquets = bouquet.getAllBouquet(connection);
            durees = duree.getAllDuree(connection);
            request.setAttribute("clients", clients);
            request.setAttribute("bouquets", bouquets);
            request.setAttribute("durees", durees);
            request.getRequestDispatcher("new_voyage.jsp").forward(request, response);
        }catch (Exception e) {
            System.out.println(e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id_bouquet = Integer.parseInt(request.getParameter("bouquet"));
        int id_duree = Integer.parseInt(request.getParameter("duree"));
        int id_client = Integer.parseInt(request.getParameter("client"));
        int billet = Integer.parseInt(request.getParameter("billet"));
        LocalDate date = LocalDate.parse(request.getParameter("date"));
        try{
            Connection connection = Connecting.getConnection("postgres");
            Voyage voyage = new Voyage();
            Activite activite = new Activite();
            activite.setId_bouquet(id_bouquet);
            activite.setId_duree(id_duree);
            activite.setQuantite(billet);
            activite.setDate(date);
            boolean billetSuffisant = activite.verifierSiBilletSuffisantBool(connection);
            if(!billetSuffisant){
                voyage.insertVenteVoyage(connection, id_bouquet, id_duree, id_client, billet, date);
                response.sendRedirect("hello-servlet");
            }else {
                throw new Exception("Billet insuffisant");
            }
        }catch (Exception e){
            System.out.println(e);
        }
    }
}