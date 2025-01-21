package org.project.projet_mme_baovola.model;

import java.sql.Connection;
import java.time.LocalDate;
import java.util.ArrayList;

public class Client {
    private int idClient;
    private String nom;
    private Genre genre;
    private LocalDate dateInsertion;

    public int getIdClient() {
        return idClient;
    }

    public void setIdClient(int idClient) {
        this.idClient = idClient;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public LocalDate getDateInsertion() {
        return dateInsertion;
    }

    public void setDateInsertion(LocalDate dateInsertion) {
        this.dateInsertion = dateInsertion;
    }

    public Client() {
    }

    public Client(int idClient, String nom, Genre genre, LocalDate dateInsertion) {
        this.idClient = idClient;
        this.nom = nom;
        this.genre = genre;
        this.dateInsertion = dateInsertion;
    }

    public void insertClient(Connection connection) throws Exception {
        try {
            String sql = "insert into client(nom, id_genre) values(?,?)";
            java.sql.PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, this.nom);
            statement.setInt(2, this.genre.getIdGenre());
            statement.execute();
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    public ArrayList<Client> getAllClient(Connection connection) throws Exception {
        try{
            ArrayList<Client> clients = new ArrayList<>();
            String sql = "select * from client join genre on client.id_genre = genre.id_genre";
            java.sql.PreparedStatement statement = connection.prepareStatement(sql);
            java.sql.ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                Client client = new Client();
                client.setIdClient(resultSet.getInt("id_client"));
                client.setNom(resultSet.getString("nom"));
                Genre genre = new Genre();
                genre.setIdGenre(resultSet.getInt("id_genre"));
                genre.setGenre(resultSet.getString("genre"));
                client.setGenre(genre);
                client.setDateInsertion(resultSet.getDate("date_insertion").toLocalDate());
                clients.add(client);
            }
            return clients;
        }catch (Exception e){
            e.printStackTrace();
            throw e;
        }
    }
}
