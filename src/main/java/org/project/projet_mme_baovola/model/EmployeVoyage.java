package org.project.projet_mme_baovola.model;

public class EmployeVoyage {
    private int idEmploye;
    private int heure;

    public int getIdEmploye() {
        return idEmploye;
    }

    public void setIdEmploye(int idEmploye) {
        this.idEmploye = idEmploye;
    }

    public int getHeure() {
        return heure;
    }

    public void setHeure(int heure) {
        this.heure = heure;
    }

    public EmployeVoyage() {
    }

    public EmployeVoyage(int idEmploye, int heure) {
        this.idEmploye = idEmploye;
        this.heure = heure;
    }
}
