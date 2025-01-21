package org.project.projet_mme_baovola;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import org.project.projet_mme_baovola.connecting.Connecting;
import org.project.projet_mme_baovola.model.Duree;

import java.io.IOException;
import java.sql.Connection;

@WebServlet(name = "DureeServlet", value = "/DureeServlet")
public class DureeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String duree = request.getParameter("duree");
        try{
            Connection connection = Connecting.getConnection("postgres");
            Duree duree1 = new Duree();
            duree1.setDuree(duree);
            duree1.insertDuree(connection);
            response.sendRedirect("hello-servlet");
        }catch (Exception e){
            System.out.println(e);
        }
    }
}