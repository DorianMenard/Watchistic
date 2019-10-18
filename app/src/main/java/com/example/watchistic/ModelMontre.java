package com.example.watchistic;

public class ModelMontre {
    private int  Bracelet, Boitier, Cadran, Creator_id;
    private double votesTotal;
    private String Nom;

    public int getCreator_id() {
        return Creator_id;
    }

    public void setCreator_id(int creator_id) {
        Creator_id = creator_id;
    }

    public int getBracelet() { return Bracelet; }

    public void setBracelet(int bracelet) { Bracelet = bracelet; }

    public int getBoitier() {  return Boitier;  }

    public void setBoitier(int boitier) { Boitier = boitier; }

    public int getCadran() { return Cadran; }

    public void setCadran(int cadran) { Cadran = cadran; }

    public double getVotesTotal() {
        return votesTotal;
    }

    public void setVotesTotal(double votesTotal) {
        this.votesTotal = votesTotal;
    }

    public String getNom() {
        return Nom;
    }

    public void setNom(String nom) {
        Nom = nom;
    }
}