package org.project.projet_mme_baovola.model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class Voyage {
    private String nom;
    private String cin;
    private String contact;
    private int id_voyage;
    private LocalDateTime date_debut;
    private LocalDateTime date_fin;
    private int id_lieu;
    private int id_bouquet;

    public Voyage() {
    }

    public Voyage(int id_voyage, LocalDateTime date_debut, LocalDateTime date_fin, int id_lieu, int id_bouquet) {
        this.id_voyage = id_voyage;
        this.date_debut = date_debut;
        this.date_fin = date_fin;
        this.id_lieu = id_lieu;
        this.id_bouquet = id_bouquet;
    }

    public int getId_voyage() {
        return id_voyage;
    }

    public void setId_voyage(int id_voyage) {
        this.id_voyage = id_voyage;
    }

    public LocalDateTime getDate_debut() {
        return date_debut;
    }

    public void setDate_debut(LocalDateTime date_debut) {
        this.date_debut = date_debut;
    }

    public LocalDateTime getDate_fin() {
        return date_fin;
    }

    public void setDate_fin(LocalDateTime date_fin) {
        this.date_fin = date_fin;
    }

    public int getId_lieu() {
        return id_lieu;
    }

    public void setId_lieu(int id_lieu) {
        this.id_lieu = id_lieu;
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

    public String getCin() {
        return cin;
    }

    public void setCin(String cin) {
        this.cin = cin;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public int insertVoyage(Connection connection) throws Exception {
        int id_voyage = 0;
        String query = "insert into voyage(date_debut, date_fin, id_lieu, id_bouquet, nom, cin, contact) values(?, ?, ?, ?, ?, ?, ?) returning id_voyage";
        try {
            java.sql.PreparedStatement statement = connection.prepareStatement(query);
            statement.setTimestamp(1, Timestamp.valueOf(this.getDate_debut()));
            statement.setTimestamp(2, Timestamp.valueOf(this.getDate_fin()));
            statement.setInt(3, this.getId_lieu());
            statement.setInt(4, this.getId_bouquet());
            statement.setString(5, this.getNom());
            statement.setString(6, this.getCin());
            statement.setString(7, this.getContact());
            java.sql.ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                id_voyage = resultSet.getInt("id_voyage");
            }
        } catch (Exception e) {
            throw e;
        }
        return id_voyage;
    }

    public void insertVoyageActivite(Connection connection, int id_voyage, String id_activite) throws Exception {
        String query = "insert into activite_pdt_voyage(id_voyage, id_activite) values(?, ?)";
        try {
            java.sql.PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, id_voyage);
            statement.setInt(2, Integer.parseInt(id_activite));
            statement.executeUpdate();
        } catch (Exception e) {
            throw e;
        }
    }

    public void insertVenteVoyage(Connection connection, int id_client, int id_bouquet, int id_duree, int billet, LocalDate date) throws Exception {
        String query = "insert into vente_voyage (id_client,id_bouquet, id_duree, billet,date_insertion) values(?, ?, ?, ?, ?)";
        try{
            java.sql.PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, id_client);
            statement.setInt(2, id_bouquet);
            statement.setInt(3, id_duree);
            statement.setInt(4, billet);
            statement.setDate(5, Date.valueOf(date));
            statement.executeUpdate();
        }catch (Exception e){
            throw e;
        }
    }
}
