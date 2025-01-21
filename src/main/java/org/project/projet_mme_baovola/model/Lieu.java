package org.project.projet_mme_baovola.model;

import java.sql.Connection;
import java.util.ArrayList;

public class Lieu {
    private int id_lieu;
    private String nom;
    private double prix;

    public Lieu() {

    }

    public Lieu(int id_lieu, String nom) {
        this.id_lieu = id_lieu;
        this.nom = nom;
    }

    public int getId_lieu() {
        return id_lieu;
    }

    public void setId_lieu(int id_lieu) {
        this.id_lieu = id_lieu;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public ArrayList<Lieu> getAllLieu(Connection connection) throws Exception {
        ArrayList<Lieu> lieux = new ArrayList<Lieu>();
        String query = "select * from lieu";
        try {
            java.sql.Statement statement = connection.createStatement();
            java.sql.ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                Lieu lieu = new Lieu();
                lieu.setId_lieu(resultSet.getInt("id_lieu"));
                lieu.setNom(resultSet.getString("lieu"));
                lieux.add(lieu);
            }
        } catch (Exception e) {
            throw e;
        }
        return lieux;
    }

    public void insertLieu(Connection connection, String lieu) throws Exception {
        String query = "insert into lieu(lieu, prix_lieu) values(?,?)";
        try {
            java.sql.PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, lieu);
            statement.setDouble(2, this.prix);
            statement.executeUpdate();
        } catch (Exception e) {
            throw e;
        }
    }
}
