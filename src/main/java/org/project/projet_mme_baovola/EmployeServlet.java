package org.project.projet_mme_baovola;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import org.project.projet_mme_baovola.connecting.Connecting;
import org.project.projet_mme_baovola.model.Bouquet;
import org.project.projet_mme_baovola.model.Duree;
import org.project.projet_mme_baovola.model.Employe;
import org.project.projet_mme_baovola.model.Poste;

import java.io.IOException;
import java.sql.Connection;
import java.util.ArrayList;

@WebServlet(name = "EmployeServlet", value = "/EmployeServlet")
public class EmployeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ArrayList<Bouquet> bouquets = new ArrayList<Bouquet>();
        ArrayList<Duree> durees = new ArrayList<Duree>();
        ArrayList<Employe> employes = new ArrayList<Employe>();
        ArrayList<Poste> postes = new ArrayList<Poste>();
        Bouquet bouquet = new Bouquet();
        Duree duree = new Duree();
        Employe employe = new Employe();
        Poste poste = new Poste();
        try{
            Connection connection = Connecting.getConnection("postgres");
            bouquets = bouquet.getAllBouquet(connection);
            durees = duree.getAllDuree(connection);
            employes = employe.getAllEmployes(connection);
            postes = poste.getAllPoste(connection);
            request.setAttribute("bouquets", bouquets);
            request.setAttribute("durees", durees);
            request.setAttribute("employes", employes);
            request.setAttribute("postes", postes);
            request.getRequestDispatcher("employe.jsp").forward(request, response);
        }catch (Exception e){
            System.out.println(e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nom = request.getParameter("nom");
        String poste = request.getParameter("poste");
        String cin = request.getParameter("cin");
        String niveau = request.getParameter("Niveau");

        try{
            Connection connection = Connecting.getConnection("postgres");
            Employe employe = new Employe();
            employe.setNom(nom);
            employe.setPoste(poste);
            employe.setNiveau(niveau);
            employe.setCin(cin);
            employe.insertEmploye(connection);
            response.sendRedirect("hello-servlet");
        }catch (Exception e){
            System.out.println(e);
        }
    }
}