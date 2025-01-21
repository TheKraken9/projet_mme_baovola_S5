package org.project.projet_mme_baovola;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import org.project.projet_mme_baovola.connecting.Connecting;
import org.project.projet_mme_baovola.model.Employe;
import org.project.projet_mme_baovola.model.Prix;

import java.io.IOException;
import java.sql.Connection;

@WebServlet(name = "PrixDeVenteServlet", value = "/PrixDeVenteServlet")
public class PrixDeVenteServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String bouquet1 = request.getParameter("id_bouquet1");
        String duree1 = request.getParameter("id_duree1");
        double price = Double.parseDouble(request.getParameter("price"));
        try{
            Connection connection = Connecting.getConnection("postgres");
            Prix prix = new Prix();
            prix.setIdBouquet(Integer.parseInt(bouquet1));
            prix.setIdDuree(Integer.parseInt(duree1));
            prix.setPrix(price);
            prix.insertPrixDeVente(connection);
            response.sendRedirect("hello-servlet");
        }catch (Exception e){
            System.out.println(e);
        }
    }
}