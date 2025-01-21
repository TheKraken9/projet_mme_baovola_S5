package org.project.projet_mme_baovola;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import org.project.projet_mme_baovola.connecting.Connecting;
import org.project.projet_mme_baovola.model.Lieu;

import java.io.IOException;
import java.sql.Connection;

@WebServlet(name = "LieuServlet", value = "/LieuServlet")
public class LieuServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String lieu = request.getParameter("lieu");
        double prix = Integer.parseInt(request.getParameter("prix"));
        System.out.println("prix : " + prix);
        Lieu lieu1 = new Lieu();
        lieu1.setPrix(prix);
        try{
            Connection connection = Connecting.getConnection("postgres");
            lieu1.insertLieu(connection, lieu);
            response.sendRedirect("hello-servlet");
        }catch(Exception e){
            System.out.println(e);
        }
    }
}