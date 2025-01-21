package org.project.projet_mme_baovola.model;

import java.sql.Connection;
import java.time.LocalDate;
import java.util.ArrayList;

public class Prix {
    private int idPrixDeRevient;
    private int idBouquet;
    private int idDuree;
    private LocalDate dateInsertion;

    private int idDetailsPrixDeRevient;
    private Employe employe;
    private String bouquet;
    private String duree;


    private int prixDeVente;
    private double prix;

    private double benefice;

    public int getIdPrixDeRevient() {
        return idPrixDeRevient;
    }

    public void setIdPrixDeRevient(int idPrixDeRevient) {
        this.idPrixDeRevient = idPrixDeRevient;
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

    public LocalDate getDateInsertion() {
        return dateInsertion;
    }

    public void setDateInsertion(LocalDate dateInsertion) {
        this.dateInsertion = dateInsertion;
    }

    public int getIdDetailsPrixDeRevient() {
        return idDetailsPrixDeRevient;
    }

    public void setIdDetailsPrixDeRevient(int idDetailsPrixDeRevient) {
        this.idDetailsPrixDeRevient = idDetailsPrixDeRevient;
    }

    public Employe getEmploye() {
        return employe;
    }

    public void setEmploye(Employe employe) {
        this.employe = employe;
    }

    public int getPrixDeVente() {
        return prixDeVente;
    }

    public void setPrixDeVente(int prixDeVente) {
        this.prixDeVente = prixDeVente;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public double getBenefice() {
        return benefice;
    }

    public void setBenefice(double benefice) {
        this.benefice = benefice;
    }

    public String getBouquet() {
        return bouquet;
    }

    public void setBouquet(String bouquet) {
        this.bouquet = bouquet;
    }

    public String getDuree() {
        return duree;
    }

    public void setDuree(String duree) {
        this.duree = duree;
    }

    public int insertPrixDeRevient(Connection connection) throws Exception {
        int idPrixDeRev = 0;
        String query = "insert into prix_de_revient(id_bouquet, id_duree) values(?, ?) returning id_prix_de_revient";
        try{
            java.sql.PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, this.idBouquet);
            preparedStatement.setInt(2, this.idDuree);
            java.sql.ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                idPrixDeRev = resultSet.getInt("id_prix_de_revient");
            }
        }catch (Exception e){
            throw e;
        }
        return idPrixDeRev;
    }

    public void insertDetailsPrixDeRevient(Connection connection, ArrayList<EmployeVoyage> prestations) throws Exception {
        String query = "insert into details_prix_de_revient(id_prix_de_revient, id_employee, duree) values(?, ?, ?)";
        try{
            for (EmployeVoyage prestation: prestations){
                java.sql.PreparedStatement preparedStatement = connection.prepareStatement(query);
                preparedStatement.setInt(1, this.idPrixDeRevient);
                preparedStatement.setInt(2, prestation.getIdEmploye());
                preparedStatement.setDouble(3, prestation.getHeure());
                preparedStatement.executeUpdate();
            }
        }catch (Exception e){
            throw e;
        }
    }

    public void insertPrixDeVente(Connection connection) throws Exception {
        String query = "insert into prix_de_vente(id_bouquet, id_duree, prix) values(?, ?, ?)";
        try{
            java.sql.PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, this.idBouquet);
            preparedStatement.setInt(2, this.idDuree);
            preparedStatement.setDouble(3, this.prix);
            preparedStatement.executeUpdate();
        }catch (Exception e){
            throw e;
        }
    }

    public ArrayList<Prix> getAllPrix(Connection connection, double prix1, double prix2) throws Exception {
        ArrayList<Prix> prixs = new ArrayList<>();
        String sql = "select somme, bouquet, duree, benefice from benefice join bouquet b on benefice.id_bouquet = b.id_bouquet join duree d on benefice.id_duree = d.id_duree where benefice between ? and ?";
        try{
            java.sql.PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setDouble(1, prix1);
            preparedStatement.setDouble(2, prix2);
            java.sql.ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Prix prix = new Prix();
                prix.setPrix(resultSet.getDouble("somme"));
                prix.setBouquet(resultSet.getString("bouquet"));
                prix.setDuree(resultSet.getString("duree"));
                prix.setBenefice(resultSet.getDouble("benefice"));
                prixs.add(prix);
                }
        }catch (Exception e){
            throw e;
        }
        return prixs;
    }
}
