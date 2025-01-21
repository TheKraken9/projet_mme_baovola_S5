package org.project.projet_mme_baovola;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import org.project.projet_mme_baovola.connecting.Connecting;
import org.project.projet_mme_baovola.model.Activite;

import java.io.IOException;
import java.sql.Connection;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Locale;

@WebServlet(name = "DetailsActivite", value = "/DetailsActivite")
public class DetailsActivite extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ArrayList<Activite> activites = new ArrayList<Activite>();
        Activite activite = new Activite();
        try{
            Connection connection = Connecting.getConnection("postgres");
            activites = activite.getAllActivites(connection);
            request.setAttribute("activites", activites);
            request.getRequestDispatcher("detailsActivite.jsp").forward(request, response);
        }catch (Exception e){
            System.out.println(e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int activite = Integer.parseInt(request.getParameter("activite"));
        double prix = Double.parseDouble(request.getParameter("prix"));
        LocalDate date = LocalDate.parse(request.getParameter("date"));
        try{
            Connection connection = Connecting.getConnection("postgres");
            Activite activite1 = new Activite();
            activite1.setId_activite(activite);
            activite1.insertDetailsActivite(connection, prix, date);
            response.sendRedirect("hello-servlet");
        }catch (Exception e){
            System.out.println(e);
        }
    }
}