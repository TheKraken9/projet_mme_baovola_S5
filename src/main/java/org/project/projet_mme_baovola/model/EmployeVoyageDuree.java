package org.project.projet_mme_baovola.model;

import java.time.LocalDate;
import java.util.ArrayList;

public class EmployeVoyageDuree {
    private ArrayList<EmployeVoyage> employeVoyages;
    private String date;
    private String idBouquet;
    private String idDuree;

    public ArrayList<EmployeVoyage> getEmployeVoyages() {
        return employeVoyages;
    }

    public void setEmployeVoyages(ArrayList<EmployeVoyage> employeVoyages) {
        this.employeVoyages = employeVoyages;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getIdBouquet() {
        return idBouquet;
    }

    public void setIdBouquet(String idBouquet) {
        this.idBouquet = idBouquet;
    }

    public String getIdDuree() {
        return idDuree;
    }

    public void setIdDuree(String idDuree) {
        this.idDuree = idDuree;
    }

    public EmployeVoyageDuree() {
    }

    public EmployeVoyageDuree(ArrayList<EmployeVoyage> employeVoyages, String date) {
        this.employeVoyages = employeVoyages;
        this.date = date;
    }
}
