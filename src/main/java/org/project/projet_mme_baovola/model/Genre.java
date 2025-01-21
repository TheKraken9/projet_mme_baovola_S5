package org.project.projet_mme_baovola.model;

import java.sql.Connection;
import java.util.ArrayList;

public class Genre {
    private int idGenre;
    private String genre;

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

    public Genre() {
    }

    public Genre(int idGenre, String genre) {
        this.idGenre = idGenre;
        this.genre = genre;
    }

    public ArrayList<Genre> getAllGenre(Connection connection) throws Exception {

        ArrayList<Genre> genres = new ArrayList<>();
        try {
            String sql = "select * from genre";
            java.sql.PreparedStatement statement = connection.prepareStatement(sql);
            java.sql.ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Genre genre = new Genre();
                genre.setIdGenre(resultSet.getInt("id_genre"));
                genre.setGenre(resultSet.getString("genre"));
                genres.add(genre);
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
        return genres;
    }
}
