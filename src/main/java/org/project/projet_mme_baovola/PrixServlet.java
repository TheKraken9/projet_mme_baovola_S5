package org.project.projet_mme_baovola;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import org.project.projet_mme_baovola.connecting.Connecting;
import org.project.projet_mme_baovola.model.Bouquet;

import java.io.IOException;
import java.sql.Connection;
import java.util.ArrayList;

@WebServlet(name = "PrixServlet", value = "/PrixServlet")
public class PrixServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        double prix1 = Double.parseDouble(request.getParameter("prix1"));
        double prix2 = Double.parseDouble(request.getParameter("prix2"));
        try{
            Connection connection = Connecting.getConnection("postgres");
            ArrayList<Bouquet> bouquets = new ArrayList<>();
            Bouquet bouquet = new Bouquet();
            bouquets = bouquet.getListBouquetEntreDeuxDate(connection, prix1, prix2);
            request.setAttribute("bouquets", bouquets);
            request.getRequestDispatcher("resultPrix.jsp").forward(request, response);
        }catch (Exception e){
            System.out.println(e);
        }
    }
}