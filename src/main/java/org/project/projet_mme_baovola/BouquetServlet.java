package org.project.projet_mme_baovola;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import org.project.projet_mme_baovola.connecting.Connecting;
import org.project.projet_mme_baovola.model.Bouquet;

import java.io.IOException;
import java.sql.Connection;

@WebServlet(name = "BouquetServlet", value = "/BouquetServlet")
public class BouquetServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String bouquet = request.getParameter("bouquet");
        Bouquet bouquet1 =new Bouquet();
        try{
            Connection connection = Connecting.getConnection("postgres");
            bouquet1.insertBouquet(connection, bouquet);
            response.sendRedirect("hello-servlet");
        }catch(Exception e){
            System.out.println(e);
        }
    }
}