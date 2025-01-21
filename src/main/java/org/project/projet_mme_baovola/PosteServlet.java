package org.project.projet_mme_baovola;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import org.project.projet_mme_baovola.connecting.Connecting;
import org.project.projet_mme_baovola.model.Poste;

import java.io.IOException;
import java.sql.Connection;

@WebServlet(name = "PosteServlet", value = "/PosteServlet")
public class PosteServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String post = request.getParameter("post");
        try{
            Connection connection = Connecting.getConnection("postgres");
            Poste poste = new Poste();
            poste.setNomPoste(post);
            poste.insertPoste(connection);
            response.sendRedirect("EmployeServlet");
        }catch (Exception e){
            System.out.println(e);
        }
    }
}