package org.project.projet_mme_baovola;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import org.project.projet_mme_baovola.connecting.Connecting;
import org.project.projet_mme_baovola.model.Prix;

import java.io.IOException;
import java.sql.Connection;
import java.util.ArrayList;

@WebServlet(name = "FiltreServlet", value = "/FiltreServlet")
public class FiltreServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        double prix1 = Double.parseDouble(request.getParameter("prix1"));
        double prix2 = Double.parseDouble(request.getParameter("prix2"));

        try{
            Connection connection = Connecting.getConnection("postgres");
            ArrayList<Prix> prix = new ArrayList<Prix>();
            Prix prix3 = new Prix();
            prix = prix3.getAllPrix(connection, prix1, prix2);
            request.setAttribute("prix", prix);
            request.getRequestDispatcher("filtre.jsp").forward(request, response);
        }catch (Exception e){
            System.out.println(e);
        }
    }
}