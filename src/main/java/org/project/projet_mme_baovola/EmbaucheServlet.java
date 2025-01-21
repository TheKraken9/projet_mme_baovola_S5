package org.project.projet_mme_baovola;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import org.project.projet_mme_baovola.connecting.Connecting;
import org.project.projet_mme_baovola.model.Employe;

import java.io.IOException;
import java.sql.Connection;
import java.time.LocalDate;

@WebServlet(name = "EmbaucheServlet", value = "/EmbaucheServlet")
public class EmbaucheServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id_emp = request.getParameter("id_empl");
        String date_emb = request.getParameter("date_emb");
        Employe employe = new Employe();
        employe.setIdEmploye(Integer.parseInt(id_emp));
        employe.setDate_emb(LocalDate.parse(date_emb));
        try{
            Connection connection = Connecting.getConnection("postgres");
            employe.insertDateEmbauche(connection);
            response.sendRedirect("hello-servlet");
        }catch (Exception e){
            System.out.println(e);
        }
    }
}