package org.project.projet_mme_baovola;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import org.project.projet_mme_baovola.connecting.Connecting;
import org.project.projet_mme_baovola.model.Statistique;

import java.io.IOException;
import java.sql.Connection;
import java.util.ArrayList;

@WebServlet(name = "StatistiqueServlet", value = "/StatistiqueServlet")
public class StatistiqueServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id_bouquet = Integer.parseInt(request.getParameter("bouquet"));
        try{
            Connection connection = Connecting.getConnection("postgres");
            Statistique statistique = new Statistique();
            ArrayList<Statistique> statistiques = new ArrayList<>();
            statistiques = statistique.getAllStatistiqueByBouquet(connection, id_bouquet);
            request.setAttribute("statistiques", statistiques);
            request.getRequestDispatcher("statistique.jsp").forward(request, response);
        }catch (Exception e) {
            System.out.println(e);
        }
    }
}