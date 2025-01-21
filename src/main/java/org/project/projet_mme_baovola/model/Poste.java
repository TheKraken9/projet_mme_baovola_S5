package org.project.projet_mme_baovola.model;

import java.sql.Connection;
import java.util.ArrayList;

public class Poste {
    private int idPoste;
    private String nomPoste;

    public int getIdPoste() {
        return idPoste;
    }

    public void setIdPoste(int idPoste) {
        this.idPoste = idPoste;
    }

    public String getNomPoste() {
        return nomPoste;
    }

    public void setNomPoste(String nomPoste) {
        this.nomPoste = nomPoste;
    }

    public Poste() {
    }

    public Poste(int idPoste, String nomPoste) {
        this.setIdPoste(idPoste);
        this.setNomPoste(nomPoste);
    }

    public void insertPoste(Connection connection) throws Exception {
        String query = "INSERT INTO poste (nom_poste) VALUES (?)";
        try {
            java.sql.PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, this.getNomPoste());
            ps.executeUpdate();
        } catch (Exception e) {
            throw e;
        }
    }

    public ArrayList<Poste> getAllPoste(Connection connection) throws Exception {
        ArrayList<Poste> postes = new ArrayList<Poste>();
        String query = "SELECT * FROM poste";
        try {
            java.sql.PreparedStatement ps = connection.prepareStatement(query);
            java.sql.ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Poste poste = new Poste();
                poste.setIdPoste(rs.getInt("id_poste"));
                poste.setNomPoste(rs.getString("nom_poste"));
                postes.add(poste);
            }
        } catch (Exception e) {
            throw e;
        }
        return postes;
    }
}
