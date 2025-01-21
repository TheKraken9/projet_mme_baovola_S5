package org.project.projet_mme_baovola;

import com.google.gson.Gson;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import org.project.projet_mme_baovola.connecting.Connecting;
import org.project.projet_mme_baovola.model.EmployeVoyageDuree;
import org.project.projet_mme_baovola.model.Prix;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;

@WebServlet(name = "PrixDeRevientServlet", value = "/PrixDeRevientServlet")
public class PrixDeRevientServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader reader = new BufferedReader(new InputStreamReader(request.getInputStream()));
        String line = reader.readLine();
        while (line != null){
            sb.append(line);
            line = reader.readLine();
        }
        System.out.println(sb.toString());
        Gson gson = new Gson();
        EmployeVoyageDuree employeVoyageDuree = gson.fromJson(sb.toString(), EmployeVoyageDuree.class);
        System.out.println(employeVoyageDuree);
        try{
            Connection connection = Connecting.getConnection("postgres");
            connection.setAutoCommit(false);
            Prix prix = new Prix();
            prix.setIdBouquet(Integer.parseInt(employeVoyageDuree.getIdBouquet()));
            prix.setIdDuree(Integer.parseInt(employeVoyageDuree.getIdDuree()));
            int idPrixDeRevient = prix.insertPrixDeRevient(connection);
            System.out.println("idPrixDeRevient : " + idPrixDeRevient);
            prix.setIdPrixDeRevient(idPrixDeRevient);
            prix.insertDetailsPrixDeRevient(connection, employeVoyageDuree.getEmployeVoyages());
            connection.commit();
            System.out.println("commit");
        }catch (Exception e){
            System.out.println(e);
        }
    }
}