package org.project.projet_mme_baovola.model;

import java.sql.Connection;
import java.time.LocalDateTime;

public class Niveau {
    private int idParametreNiveau;
    private String niveau;
    private double duree;
    private double salaire;
    private LocalDateTime dateInsertion;

    public int getIdParametreNiveau() {
        return idParametreNiveau;
    }

    public void setIdParametreNiveau(int idParametreNiveau) {
        this.idParametreNiveau = idParametreNiveau;
    }

    public String getNiveau() {
        return niveau;
    }

    public void setNiveau(String niveau) {
        this.niveau = niveau;
    }

    public double getDuree() {
        return duree;
    }

    public void setDuree(double duree) {
        this.duree = duree;
    }

    public LocalDateTime getDateInsertion() {
        return dateInsertion;
    }

    public void setDateInsertion(LocalDateTime dateInsertion) {
        this.dateInsertion = dateInsertion;
    }

    public double getSalaire() {
        return salaire;
    }

    public void setSalaire(double salaire) {
        this.salaire = salaire;
    }

    public Niveau() {
    }

    public Niveau(int idParametreNiveau, String niveau, double duree, LocalDateTime dateInsertion) {
        this.idParametreNiveau = idParametreNiveau;
        this.niveau = niveau;
        this.duree = duree;
        this.dateInsertion = dateInsertion;
    }

    public void insertNiveau(Connection connection) throws Exception {
        try {
            String sql = "insert into parametre_niveau(niveau,duree,salaire) values(?,?,?)";
            java.sql.PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, this.niveau);
            statement.setDouble(2, this.duree);
            statement.setDouble(3, this.salaire);
            statement.execute();
        } catch (Exception e) {
            throw e;
        }
    }
}
