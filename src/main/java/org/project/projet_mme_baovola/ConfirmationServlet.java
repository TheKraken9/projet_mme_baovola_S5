package org.project.projet_mme_baovola;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import org.project.projet_mme_baovola.connecting.Connecting;
import org.project.projet_mme_baovola.model.Activite;

import java.io.IOException;
import java.sql.Connection;
import java.util.ArrayList;

@WebServlet(name = "ConfirmationServlet", value = "/ConfirmationServlet")
public class ConfirmationServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int idBouquet = Integer.parseInt(request.getParameter("idBouquet"));
        int idLieu = Integer.parseInt(request.getParameter("idLieu"));
        int idDuree = Integer.parseInt(request.getParameter("idDuree"));
        System.out.println(idBouquet);
        System.out.println(idLieu);
        System.out.println(idDuree);
        Activite activite = new Activite();
        activite.setId_bouquet(idBouquet);
        activite.setId_lieu(idLieu);
        activite.setId_duree(idDuree);
        try{
            Connection connection = Connecting.getConnection("postgres");
            ArrayList<Activite> activites = new ArrayList<>();
            activites = activite.verifierSiBilletSuffisant(connection);
            request.setAttribute("activites", activites);
            request.getRequestDispatcher("confirmation.jsp").forward(request, response);
        }catch (Exception e){
            System.out.println(e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}