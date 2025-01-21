package org.project.projet_mme_baovola;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import org.project.projet_mme_baovola.connecting.Connecting;
import org.project.projet_mme_baovola.model.Client;
import org.project.projet_mme_baovola.model.Genre;

import java.io.IOException;
import java.sql.Connection;
import java.util.ArrayList;

@WebServlet(name = "ClientServlet", value = "/ClientServlet")
public class ClientServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ArrayList<Genre> genres = new ArrayList<Genre>();
        Genre genre = new Genre();
        try{
            Connection connection = Connecting.getConnection("postgres");
            genres = genre.getAllGenre(connection);
            request.setAttribute("genres", genres);
            request.getRequestDispatcher("client.jsp").forward(request, response);
        }catch (Exception e) {
            System.out.println(e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nom = request.getParameter("nom");
        String idGenre = request.getParameter("genre");

        try{
            Connection connection = Connecting.getConnection("postgres");
            Genre genre = new Genre();
            Client client = new Client();
            genre.setIdGenre(Integer.parseInt(idGenre));
            client.setNom(nom);
            client.setGenre(genre);
            client.insertClient(connection);
            response.sendRedirect("hello-servlet");
    }catch (Exception e){
        System.out.println(e);
    }
    }
}