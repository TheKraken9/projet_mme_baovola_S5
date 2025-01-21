package org.project.projet_mme_baovola.model;

import org.project.projet_mme_baovola.connecting.Connecting;

import java.lang.reflect.Array;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.time.LocalDate;
import java.util.ArrayList;

public class Activite {

    private int id_activite_par_bouquet;
    private int id_activite;
    private int id_bouquet;
    private int id_lieu;
    private int id_duree;
    private int seance;
    private String nom;
    private String nom_bouquet;
    private String lieu;
    private String nom_duree;
    private double duree;
    private double prix;
    private double somme;
    private double manquant;
    private String activite;
    private double prixTotal;
    private int quantite;

    private LocalDate date;

    public Activite() {
    }

    public Activite(int id_activite, int id_bouquet, String nom) {
        this.id_activite = id_activite;
        this.id_bouquet = id_bouquet;
        this.nom = nom;
    }

    public int getId_activite() {
        return id_activite;
    }

    public void setId_activite(int id_activite) {
        this.id_activite = id_activite;
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

    public String getNom_bouquet() {
        return nom_bouquet;
    }

    public void setNom_bouquet(String nom_bouquet) {
        this.nom_bouquet = nom_bouquet;
    }

    public int getId_activite_par_bouquet() {
        return id_activite_par_bouquet;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public void setId_activite_par_bouquet(int id_activite_par_bouquet) {
        this.id_activite_par_bouquet = id_activite_par_bouquet;
    }

    public double getDuree() {
        return duree;
    }

    public void setDuree(double duree) {
        this.duree = duree;
    }

    public int getId_lieu() {
        return id_lieu;
    }

    public void setId_lieu(int id_lieu) {
        this.id_lieu = id_lieu;
    }

    public int getId_duree() {
        return id_duree;
    }

    public void setId_duree(int id_duree) {
        this.id_duree = id_duree;
    }

    public int getSeance() {
        return seance;
    }

    public void setSeance(int seance) {
        this.seance = seance;
    }

    public String getLieu() {
        return lieu;
    }

    public void setLieu(String lieu) {
        this.lieu = lieu;
    }

    public String getNom_duree() {
        return nom_duree;
    }

    public void setNom_duree(String nom_duree) {
        this.nom_duree = nom_duree;
    }

    public double getSomme() {
        return somme;
    }

    public void setSomme(double somme) {
        this.somme = somme;
    }

    public double getManquant() {
        return manquant;
    }

    public void setManquant(double manquant) {
        this.manquant = manquant;
    }

    public String getActivite() {
        return activite;
    }

    public void setActivite(String activite) {
        this.activite = activite;
    }

    public double getPrixTotal() {
        return prixTotal;
    }

    public void setPrixTotal(double prixTotal) {
        this.prixTotal = prixTotal;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public ArrayList<Activite> getAllActivites(Connection connection) throws Exception {
        ArrayList<Activite> activites = new ArrayList<Activite>();
        String query = "select * from activite";
        try {
            java.sql.Statement statement = connection.createStatement();
            java.sql.ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                Activite activite = new Activite();
                activite.setId_activite(resultSet.getInt("id_activite"));
                activite.setNom(resultSet.getString("activite"));
                activites.add(activite);
            }
        } catch (Exception e) {
            throw e;
        }
        return activites;
    }

    public void insertActivite(Connection connection) throws Exception {
        String query = "insert into activite(activite) values(?)";
        try {
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, this.nom);
            statement.executeUpdate();
        } catch (Exception e) {
            throw e;
        }
    }

    public void insertDetailsActivite(Connection connection, double prix, LocalDate date) throws Exception {
        String sql = "insert into details_activite(id_activite, prix, date_insertion) values(?, ?, ?)";
        //String sql2 = "insert into billet_achete_par_activite(id_activite, stock) values(?, ?)";
        try{
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, this.id_activite);
            statement.setDouble(2, prix);
            statement.setDate(3, Date.valueOf(date));
            statement.executeUpdate();
        }catch (Exception e) {
            throw e;
        }
    }

    public void insertDetailsActivite2(Connection connection, LocalDate date, int quantite) throws Exception {
        String sql = "insert into billet_par_activite(id_activite, quantite_v, quantite_a, prix, date_insertion) values(?, default, ?, default, ?)";
        try{
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, this.id_activite);
            statement.setInt(2, quantite);
            statement.setDate(3, Date.valueOf(date));
            statement.executeUpdate();
        }catch (Exception e) {
            throw e;
        }
    }
    public void insertActiviteParBouquet(Connection connection) throws Exception {
        String query = "insert into activite_par_bouquet(id_activite, id_bouquet, id_lieu, id_duree, nbre_seance) values(?,?,?,?,?)";
        try {
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, this.id_activite);
            statement.setInt(2, this.id_bouquet);
            statement.setInt(3, this.id_lieu);
            statement.setInt(4, this.id_duree);
            statement.setInt(5, this.seance);
            statement.executeUpdate();
        } catch (Exception e) {
            throw e;
        }
    }

    public ArrayList<Activite> getAllActivite(Connection connection, String id) throws Exception {
        ArrayList<Activite> activites = new ArrayList<Activite>();
        String query ="select activite_par_bouquet.id_activite_par_bouquet as id, activite_par_bouquet.id_duree as duree, d.duree as nom_duree, a.activite as activite, b.bouquet as bouquet, b.id_bouquet from activite_par_bouquet join activite a on activite_par_bouquet.id_activite = a.id_activite join bouquet b on b.id_bouquet = activite_par_bouquet.id_bouquet join duree d on d.id_duree = activite_par_bouquet.id_duree where b.id_bouquet = ?";
        try {
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, Integer.parseInt(id));
            java.sql.ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Activite activite = new Activite();
                activite.setId_activite(resultSet.getInt("id"));
                activite.setNom(resultSet.getString("activite"));
                activite.setNom_bouquet(resultSet.getString("bouquet"));
                activite.setDuree(resultSet.getDouble("duree"));
                activite.setNom_duree(resultSet.getString("nom_duree"));
                activites.add(activite);
            }
        } catch (Exception e) {
            throw e;
        }
        return activites;
    }

    public ArrayList<Activite> getActiviteById(Connection connection) throws Exception {
        String sql = "select activite_par_bouquet.nbre_seance, activite_par_bouquet.prix_activite, b.bouquet, d.duree, l.lieu, a.activite from activite_par_bouquet join bouquet b on b.id_bouquet = activite_par_bouquet.id_bouquet join duree d on activite_par_bouquet.id_duree = d.id_duree join lieu l on activite_par_bouquet.id_lieu = l.id_lieu join activite a on activite_par_bouquet.id_activite = a.id_activite where b.id_bouquet = ?";
        ArrayList<Activite> activites = new ArrayList<Activite>();
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, this.id_activite);
            java.sql.ResultSet resultSet = statement.executeQuery();
            while(resultSet.next()) {
                Activite activite = new Activite();
                activite.setNom(resultSet.getString("activite"));
                activite.setNom_bouquet(resultSet.getString("bouquet"));
                activite.setLieu(resultSet.getString("lieu"));
                activite.setNom_duree(resultSet.getString("duree"));
                activite.setSeance(resultSet.getInt("nbre_seance"));
                activite.setPrix(resultSet.getDouble("prix_activite"));
                activites.add(activite);
            }
        }catch (Exception e){
            throw e;
        }
        return activites;
    }

    public ArrayList<Activite> listesDesActivites(Connection connection) throws Exception {
        String sql = "select * from result where id_bouquet=? and id_lieu=? and id_duree=?";
        ArrayList<Activite> activites = new ArrayList<Activite>();
        try{
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, this.id_bouquet);
            statement.setInt(2, this.id_lieu);
            statement.setInt(3, this.id_duree);
            java.sql.ResultSet resultSet = statement.executeQuery();
            while(resultSet.next()){
                Activite activite = new Activite();
                activite.setId_activite(resultSet.getInt("id_activite"));
                activite.setActivite(resultSet.getString("activite"));
                activite.setSeance(resultSet.getInt("nbre_seance"));
                activite.setId_bouquet(resultSet.getInt("id_bouquet"));
                activite.setId_duree(resultSet.getInt("id_duree"));
                activite.setId_lieu(resultSet.getInt("id_lieu"));
                activite.setNom_bouquet(resultSet.getString("bouquet"));
                activite.setLieu(resultSet.getString("lieu"));
                activite.setNom_duree(resultSet.getString("duree"));
                activite.setSomme(resultSet.getDouble("somme"));
                activite.setPrixTotal(resultSet.getDouble("prix"));
                activites.add(activite);
            }
        }catch (Exception e){
            throw e;
        }
        return activites;
    }

    public ArrayList<Activite> listesDesActivitesBool(Connection connection) throws Exception {
        String sql = "select * from result where id_bouquet=? and id_duree=?";
        ArrayList<Activite> activites = new ArrayList<Activite>();
        try{
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, this.id_bouquet);
            statement.setInt(2, this.id_duree);
            java.sql.ResultSet resultSet = statement.executeQuery();
            while(resultSet.next()){
                Activite activite = new Activite();
                activite.setId_activite(resultSet.getInt("id_activite"));
                activite.setActivite(resultSet.getString("activite"));
                activite.setSeance(resultSet.getInt("nbre_seance"));
                activite.setId_bouquet(resultSet.getInt("id_bouquet"));
                activite.setId_duree(resultSet.getInt("id_duree"));
                activite.setId_lieu(resultSet.getInt("id_lieu"));
                activite.setNom_bouquet(resultSet.getString("bouquet"));
                activite.setLieu(resultSet.getString("lieu"));
                activite.setNom_duree(resultSet.getString("duree"));
                activite.setSomme(resultSet.getDouble("somme"));
                activite.setPrixTotal(resultSet.getDouble("prix"));
                activites.add(activite);
            }
        }catch (Exception e){
            throw e;
        }
        return activites;
    }

    public ArrayList<Activite> verifierSiBilletSuffisant(Connection connection) throws Exception {
        ArrayList<Activite> activites = new ArrayList<Activite>();
        boolean insuffisant = false;
        try{
            activites = this.listesDesActivites(connection);
            for (Activite activite: activites) {
                if(activite.getSomme() < (activite.getSeance()*this.getQuantite())){
                    activite.setManquant((activite.getSeance()*this.getQuantite()) - activite.getSomme());
                    insuffisant = true;
                }else{
                    activite.setManquant(0);
                }
            }
            if(!insuffisant) {
                this.confirmerAchat(connection, activites);
            }
        }catch (Exception e){
            throw e;
        }
        return activites;
    }

    public boolean verifierSiBilletSuffisantBool(Connection connection) throws Exception {
        ArrayList<Activite> activites = new ArrayList<Activite>();
        boolean insuffisant = false;
        try{
            activites = this.listesDesActivitesBool(connection);
            for (Activite activite: activites) {
                if(activite.getSomme() < (activite.getSeance()*this.getQuantite())){
                    activite.setManquant((activite.getSeance()*this.getQuantite()) - activite.getSomme());
                    insuffisant = true;
                    return insuffisant;
                }else{
                    activite.setManquant(0);
                }
            }
            if(!insuffisant) {
                this.confirmerAchat(connection, activites);
            }
        }catch (Exception e){
            throw e;
        }
        return insuffisant;
    }

    public void confirmerAchat(Connection connection, ArrayList<Activite> activites) throws Exception {
        String sql = "insert into billet_par_activite(id_activite, quantite_v, prix) values(?, ?, ?)";
        try {
            for (Activite activite: activites) {
                PreparedStatement statement1 = connection.prepareStatement(sql);
                statement1.setInt(1, activite.getId_activite());
                statement1.setInt(2, activite.getSeance()*this.getQuantite());
                statement1.setDouble(3, activite.getSeance() * activite.getPrixTotal() * this.getQuantite());
                statement1.executeUpdate();
            }
        } catch (Exception e) {
            throw e;
        }
    }

    public static void main(String[] args) {
        Activite activite = new Activite();
        activite.setId_bouquet(1);
        activite.setId_duree(1);
        activite.setQuantite(1);
        try{
            Connection connection = Connecting.getConnection("postgres");
            boolean ok = activite.verifierSiBilletSuffisantBool(connection);
            System.out.println(ok);
        }catch (Exception e) {
            System.out.println(e);
        }
    }
}
