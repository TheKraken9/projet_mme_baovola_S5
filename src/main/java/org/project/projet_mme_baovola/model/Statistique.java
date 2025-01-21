package org.project.projet_mme_baovola.model;

import java.sql.Connection;
import java.util.ArrayList;

public class Statistique {
    private int idGenre;
    private String genre;
    private int mois;
    private int nombre;

    public int getIdGenre() {
        return idGenre;
    }

    public void setIdGenre(int idGenre) {
        this.idGenre = idGenre;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getMois() {
        return mois;
    }

    public void setMois(int mois) {
        this.mois = mois;
    }

    public int getNombre() {
        return nombre;
    }

    public void setNombre(int nombre) {
        this.nombre = nombre;
    }

    public Statistique() {
    }

    public Statistique(int idGenre, String genre, int mois, int nombre) {
        this.idGenre = idGenre;
        this.genre = genre;
        this.mois = mois;
        this.nombre = nombre;
    }

    public ArrayList<Statistique> getAllStatistiqueByBouquet(Connection connection, int idBouquet) throws Exception {

            ArrayList<Statistique> statistiques = new ArrayList<>();
            try {
                String sql = "select * from statistique_nombre_de_vente_par_genre_par_mois(?)";
                java.sql.PreparedStatement statement = connection.prepareStatement(sql);
                statement.setInt(1, idBouquet);
                java.sql.ResultSet resultSet = statement.executeQuery();
                while (resultSet.next()) {
                    Statistique statistique = new Statistique();
                    statistique.setIdGenre(resultSet.getInt("id_genr"));
                    statistique.setGenre(resultSet.getString("genr"));
                    statistique.setMois(resultSet.getInt("mois"));
                    statistique.setNombre(resultSet.getInt("nombre"));
                    statistiques.add(statistique);
                }
            } catch (Exception e) {
                e.printStackTrace();
                throw e;
            }
            return statistiques;
    }
}
