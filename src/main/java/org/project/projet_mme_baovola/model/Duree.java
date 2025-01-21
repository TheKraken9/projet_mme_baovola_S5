package org.project.projet_mme_baovola.model;

import java.sql.Connection;
import java.util.ArrayList;

public class Duree {
    private int idDuree;
    private String duree;

    public Duree() {
    }

    public Duree(int idDuree, String duree) {
        this.idDuree = idDuree;
        this.duree = duree;
    }

    public int getIdDuree() {
        return idDuree;
    }

    public void setIdDuree(int idDuree) {
        this.idDuree = idDuree;
    }

    public String getDuree() {
        return duree;
    }

    public void setDuree(String duree) {
        this.duree = duree;
    }

    public ArrayList<Duree> getAllDuree(Connection connection) throws Exception {
        ArrayList<Duree> durees = new ArrayList<Duree>();
        String query = "select * from duree";
        try {
            java.sql.Statement statement = connection.createStatement();
            java.sql.ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                Duree duree = new Duree();
                duree.setIdDuree(resultSet.getInt("id_duree"));
                duree.setDuree(resultSet.getString("duree"));
                durees.add(duree);
            }
        } catch (Exception e) {
            throw e;
        }
        return durees;
    }

    public void insertDuree(Connection connection) throws Exception {
        String query = "insert into duree(duree) values('" + this.duree + "')";
        try {
            java.sql.Statement statement = connection.createStatement();
            statement.executeUpdate(query);
        } catch (Exception e) {
            throw e;
        }
    }
}
