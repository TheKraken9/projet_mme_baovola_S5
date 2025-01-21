package org.project.projet_mme_baovola;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import org.project.projet_mme_baovola.connecting.Connecting;
import org.project.projet_mme_baovola.model.Demp;
import org.project.projet_mme_baovola.model.Employe;

import java.io.IOException;
import java.sql.Connection;
import java.util.ArrayList;

@WebServlet(name = "EtatEmployeServlet", value = "/EtatEmployeServlet")
public class EtatEmployeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ArrayList<Demp> dEmps = new ArrayList<>();
        try{
            Demp d = new Demp();
            Connection connection = Connecting.getConnection("postgres");
            dEmps = d.getDEmp(connection);
            request.setAttribute("dEmps", dEmps);
            request.getRequestDispatcher("etat_actuel.jsp").forward(request, response);
        }catch (Exception e) {
            System.out.println(e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}