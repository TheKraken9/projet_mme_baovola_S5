package org.project.projet_mme_baovola;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import org.project.projet_mme_baovola.connecting.Connecting;
import org.project.projet_mme_baovola.model.Activite;

import java.io.IOException;
import java.sql.Connection;
import java.time.LocalDate;

@WebServlet(name = "DetailsServlet2", value = "/DetailsServlet2")
public class DetailsServlet2 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int activite = Integer.parseInt(request.getParameter("activite"));
        LocalDate date = LocalDate.parse(request.getParameter("date1"));
        int quantite = Integer.parseInt(request.getParameter("quantite1"));
        try{
            Connection connection = Connecting.getConnection("postgres");
            Activite activite1 = new Activite();
            activite1.setId_activite(activite);
            activite1.insertDetailsActivite2(connection, date, quantite);
            response.sendRedirect("hello-servlet");
        }catch (Exception e){
            System.out.println(e);
        }
    }
}