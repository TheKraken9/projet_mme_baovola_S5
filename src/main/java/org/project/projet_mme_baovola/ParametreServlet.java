package org.project.projet_mme_baovola;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import org.project.projet_mme_baovola.connecting.Connecting;
import org.project.projet_mme_baovola.model.Niveau;

import java.io.IOException;
import java.sql.Connection;

@WebServlet(name = "ParametreServlet", value = "/ParametreServlet")
public class ParametreServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String niveau = request.getParameter("niveau");
        String duree_empl = request.getParameter("duree_empl");
        String salaire_empl = request.getParameter("salaire_empl");
        Niveau n = new Niveau();
        try{
            Connection connection = Connecting.getConnection("postgres");
            n.setNiveau(niveau);
            n.setDuree(Double.parseDouble(duree_empl));
            n.setSalaire(Double.parseDouble(salaire_empl));
            n.insertNiveau(connection);
            response.sendRedirect("hello-servlet");
        }catch (Exception e){
            System.out.println(e);
        }
    }
}