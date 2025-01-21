package org.project.projet_mme_baovola;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import org.project.projet_mme_baovola.connecting.Connecting;
import org.project.projet_mme_baovola.model.Employe;

import java.io.IOException;
import java.sql.Connection;
import java.time.LocalDate;

@WebServlet(name = "SalaireServlet", value = "/SalaireServlet")
public class SalaireServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id_emp = request.getParameter("id_emp");
        String salaire = request.getParameter("salaire");
        LocalDate date = LocalDate.parse(request.getParameter("date"));
        try{
            Connection connection = Connecting.getConnection("postgres");
            Employe employe = new Employe();
            employe.setIdEmploye(Integer.parseInt(id_emp));
            employe.setSalaire(Double.parseDouble(salaire));
            employe.setDateSalaire(date);
            employe.insertSalaire(connection);
            response.sendRedirect("hello-servlet");
        }catch (Exception e){
            System.out.println(e);
        }
    }
}