package org.project.projet_mme_baovola;

import com.google.gson.Gson;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import org.project.projet_mme_baovola.connecting.Connecting;
import org.project.projet_mme_baovola.model.Activite;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.util.ArrayList;

@WebServlet(name = "ActiviteServlet", value = "/ActiviteServlet")
public class ActiviteServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id_bouquet = request.getParameter("id_bouquet");
        System.out.println(id_bouquet);
        ArrayList<Activite> activites = new ArrayList<Activite>();
        Activite activite = new Activite();
        try{
            Connection connection = Connecting.getConnection("postgres");
            activites = activite.getAllActivite(connection, id_bouquet);

            Gson gson = new Gson();
            String json = gson.toJson(activites);
            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");
            try (PrintWriter out = response.getWriter()) {
                out.print(json);
                out.flush();
            }
        }catch(Exception e){
            System.out.println(e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String activite = request.getParameter("activite");
        Activite activite1 = new Activite();
        try{
            Connection connection = Connecting.getConnection("postgres");
            activite1.setNom(activite);
            activite1.insertActivite(connection);
            response.sendRedirect("hello-servlet");
        }catch (Exception e){
            System.out.println(e);
        }
    }
}