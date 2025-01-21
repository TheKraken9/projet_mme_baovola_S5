package org.project.projet_mme_baovola;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import org.project.projet_mme_baovola.connecting.Connecting;
import org.project.projet_mme_baovola.model.Activite;

import java.io.IOException;
import java.sql.Connection;
import java.util.ArrayList;

@WebServlet(name = "ListBouquetParActiviteServlet", value = "/ListBouquetParActiviteServlet")
public class ListBouquetParActiviteServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id_activite = Integer.parseInt(request.getParameter("activite"));
        try{
            ArrayList<Activite> activites = new ArrayList<>();
            Connection connection = Connecting.getConnection("postgres");
            Activite activite = new Activite();
            activite.setId_activite(id_activite);
            activites = activite.getActiviteById(connection);
            request.setAttribute("activites", activites);
            request.getRequestDispatcher("listBouquetParActivite.jsp").forward(request, response);
        }catch (Exception e){
            System.out.println(e);
        }
    }
}