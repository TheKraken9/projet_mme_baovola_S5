package org.project.projet_mme_baovola;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import org.project.projet_mme_baovola.connecting.Connecting;
import org.project.projet_mme_baovola.model.Activite;

import java.io.IOException;
import java.sql.Connection;
import java.util.ArrayList;

@WebServlet(name = "ListServlet", value = "/ListServlet")
public class ListServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String pathJsp = "/index.jsp";
        request.getRequestDispatcher(pathJsp).forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("bouquet");
        ArrayList<Activite> activites = new ArrayList<Activite>();
        try{
            Connection connection = Connecting.getConnection("postgres");
            Activite activite = new Activite();
            activites = activite.getAllActivite(connection, id);
            request.setAttribute("activites", activites);
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }catch(Exception e){
            System.out.println(e);
        }
    }
}