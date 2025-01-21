package org.project.projet_mme_baovola.model;

import java.sql.Connection;
import java.time.LocalDate;
import java.util.ArrayList;

public class Employe {
    private int idEmploye;
    private String nom;
    private int idPoste;
    private String poste;
    private String cin;
    private double salaire;
    private LocalDate dateSalaire;
    private String niveau;

    private LocalDate date_emb;

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

    public String getCin() {
        return cin;
    }

    public void setCin(String cin) {
        this.cin = cin;
    }

    public double getSalaire() {
        return salaire;
    }

    public void setSalaire(double salaire) {
        this.salaire = salaire;
    }

    public String getPoste() {
        return poste;
    }

    public void setPoste(String poste) {
        this.poste = poste;
    }

    public LocalDate getDateSalaire() {
        return dateSalaire;
    }

    public void setDateSalaire(LocalDate dateSalaire) {
        this.dateSalaire = dateSalaire;
    }

    public String getNiveau() {
        return niveau;
    }

    public void setNiveau(String niveau) {
        this.niveau = niveau;
    }

    public int getIdPoste() {
        return idPoste;
    }

    public void setIdPoste(int idPoste) {
        this.idPoste = idPoste;
    }

    public LocalDate getDate_emb() {
        return date_emb;
    }

    public void setDate_emb(LocalDate date_emb) {
        this.date_emb = date_emb;
    }

    public Employe() {
    }

    public Employe(int idEmploye, String nom, String cin, double salaire) {
        this.setIdEmploye(idEmploye);
        this.setNom(nom);
        this.setCin(cin);
        this.setSalaire(salaire);
    }

    public ArrayList<Employe> getAllEmployes(Connection connection) throws Exception {
        ArrayList<Employe> employes = new ArrayList<>();
        String sql = "select id_employe, nom, niveau ,poste.id_poste, nom_poste, cin, (select salaire from salaire_employe where salaire_employe.id_employe = employe.id_employe order by date_insertion desc limit 1) as salaire from employe join poste on employe.id_poste = poste.id_poste";
        try{
            java.sql.Statement statement = connection.createStatement();
            java.sql.ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                Employe employe = new Employe();
                employe.setIdEmploye(resultSet.getInt("id_employe"));
                employe.setNom(resultSet.getString("nom"));
                employe.setIdPoste(resultSet.getInt("id_poste"));
                employe.setPoste(resultSet.getString("nom_poste"));
                employe.setCin(resultSet.getString("cin"));
                employe.setNiveau(resultSet.getString("Niveau"));
                employe.setSalaire(resultSet.getDouble("salaire"));
                employes.add(employe);
            }
        }catch (Exception e){
            throw e;
        }
        return employes;
    }

    public void insertEmploye(Connection connection) throws Exception {
        String sql = "insert into employe(nom, id_poste, cin, niveau) values(?,?,?,?)";
        try{
            java.sql.PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, this.getNom());
            preparedStatement.setInt(2, Integer.parseInt(this.getPoste()));
            preparedStatement.setString(3, this.getCin());
            preparedStatement.setString(4, this.getNiveau());
            preparedStatement.executeUpdate();
        }catch (Exception e){
            throw e;
        }
    }

    public void insertSalaire(Connection connection) throws Exception {
        String sql = "insert into salaire_employe(id_employe, salaire, date_insertion) values(?,?,?)";
        try{
            java.sql.PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, this.getIdEmploye());
            preparedStatement.setDouble(2, this.getSalaire());
            preparedStatement.setDate(3, java.sql.Date.valueOf(this.getDateSalaire()));
            preparedStatement.executeUpdate();
        }catch (Exception e){
            throw e;
        }
    }

    public void insertDateEmbauche(Connection connection) throws Exception {
        String sql = "insert into date_embauche(id_employe, date_emb) values(?,?)";
        try{
            java.sql.PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, this.getIdEmploye());
            preparedStatement.setDate(2, java.sql.Date.valueOf(this.getDate_emb()));
            preparedStatement.executeUpdate();
        }catch (Exception e){
            throw e;
        }
    }
}
