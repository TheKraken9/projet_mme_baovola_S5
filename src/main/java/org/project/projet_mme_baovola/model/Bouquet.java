package org.project.projet_mme_baovola.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.time.LocalDate;
import java.util.ArrayList;

public class Bouquet {
    private int id_bouquet;
    private String nom;
    private double prix;


    private double prixTotal;
    private String bouquet;
    private String lieu;
    private String duree;

    private int idBouquet;
    private int idDuree;
    private int idLieu;
    public Bouquet() {
    }

    public Bouquet(int id_bouquet, String nom) {
        this.id_bouquet = id_bouquet;
        this.nom = nom;
    }

    public int getId_bouquet() {
        return id_bouquet;
    }

    public void setId_bouquet(int id_bouquet) {
        this.id_bouquet = id_bouquet;
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

    public double getPrixTotal() {
        return prixTotal;
    }

    public void setPrixTotal(double prixTotal) {
        this.prixTotal = prixTotal;
    }

    public String getBouquet() {
        return bouquet;
    }

    public void setBouquet(String bouquet) {
        this.bouquet = bouquet;
    }

    public String getLieu() {
        return lieu;
    }

    public void setLieu(String lieu) {
        this.lieu = lieu;
    }

    public String getDuree() {
        return duree;
    }

    public int getIdBouquet() {
        return idBouquet;
    }

    public void setIdBouquet(int idBouquet) {
        this.idBouquet = idBouquet;
    }

    public int getIdDuree() {
        return idDuree;
    }

    public void setIdDuree(int idDuree) {
        this.idDuree = idDuree;
    }

    public int getIdLieu() {
        return idLieu;
    }

    public void setIdLieu(int idLieu) {
        this.idLieu = idLieu;
    }

    public void setDuree(String duree) {
        this.duree = duree;
    }

    public ArrayList<Bouquet> getAllBouquet(Connection connection) throws Exception {
        ArrayList<Bouquet> bouquets = new ArrayList<Bouquet>();
        String query = "select * from bouquet";
        try {
            java.sql.Statement statement = connection.createStatement();
            java.sql.ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                Bouquet bouquet = new Bouquet();
                bouquet.setId_bouquet(resultSet.getInt("id_bouquet"));
                bouquet.setNom(resultSet.getString("bouquet"));
                bouquets.add(bouquet);
            }
        } catch (Exception e) {
            throw e;
        }
        return bouquets;
    }

    public void insertBouquet(Connection connection, String bouquet) throws Exception {
        String query = "insert into bouquet(bouquet) values(?)";
        try {
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, bouquet);
            statement.executeUpdate();
        } catch (Exception e) {
            throw e;
        }
    }

    public ArrayList<Bouquet> getListBouquetEntreDeuxDate(Connection connection, double prix1, double prix2) throws Exception {
        ArrayList<Bouquet> bouquets = new ArrayList<Bouquet>();
        String query = "select * from prix where somme >= ? and somme <= ?";
        try {
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setDouble(1, prix1);
            statement.setDouble(2, prix2);
            java.sql.ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Bouquet bouquet = new Bouquet();
                bouquet.setPrixTotal(resultSet.getDouble("somme"));
                bouquet.setId_bouquet(resultSet.getInt("id_bouquet"));
                bouquet.setIdLieu(resultSet.getInt("id_lieu"));
                bouquet.setIdDuree(resultSet.getInt("id_duree"));
                bouquet.setBouquet(resultSet.getString("bouquet"));
                bouquet.setLieu(resultSet.getString("lieu"));
                bouquet.setDuree(resultSet.getString("duree"));
                bouquets.add(bouquet);
            }
        } catch (Exception e) {
            throw e;
        }
        return bouquets;
    }
}
