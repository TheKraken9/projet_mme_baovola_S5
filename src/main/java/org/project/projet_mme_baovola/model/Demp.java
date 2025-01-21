package org.project.projet_mme_baovola.model;

import java.sql.Connection;
import java.util.ArrayList;

public class Demp {
    private int idEmploye;
    private String nom;
    private double salaire;
    private String titre;

    public int getIdEmploye() {
        return idEmploye;
    }

    public void setIdEmploye(int idEmploye) {
        this.idEmploye = idEmploye;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public double getSalaire() {
        return salaire;
    }

    public void setSalaire(double salaire) {
        this.salaire = salaire;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public Demp() {
    }

    public Demp(int idEmploye, String nom, double salaire, String titre) {
        this.idEmploye = idEmploye;
        this.nom = nom;
        this.salaire = salaire;
        this.titre = titre;
    }

    public ArrayList<Demp> getDEmp(Connection connection) throws Exception {
        ArrayList<Demp> dEmps = new ArrayList<>();
        try {
            String sql = "select distinct * from calculer_taux_horaire_en_fonction_date_embauche()";
            java.sql.PreparedStatement statement = connection.prepareStatement(sql);
            java.sql.ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int idEmploye = resultSet.getInt("id_emp");
                double salaire = resultSet.getDouble("taux");
                String nom = resultSet.getString("nom_emp");
                titre = resultSet.getString("titre");
                Demp dEmp = new Demp(idEmploye, nom, salaire, titre);
                dEmps.add(dEmp);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return dEmps;
    }
}
