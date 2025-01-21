package org.project.projet_mme_baovola.model;

public class Prestation {
    private int idEmploye;
    private int duree;

    public int getIdEmploye() {
        return idEmploye;
    }

    public void setIdEmploye(int idEmploye) {
        this.idEmploye = idEmploye;
    }

    public int getDuree() {
        return duree;
    }

    public void setDuree(int duree) {
        this.duree = duree;
    }

    public Prestation() {
    }

    public Prestation(int idEmploye, int duree) {
        this.idEmploye = idEmploye;
        this.duree = duree;
    }
}
