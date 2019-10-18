package com.example.watchistic;

import android.graphics.drawable.Drawable;

public class ModelMontre {
    private Drawable Bracelet, Boitier, Cadran;
    private double votesTotal;
    private String Nom, Creator_id;

    public ModelMontre(Drawable bracelet, Drawable boitier, Drawable cadran, String creator_id, double votesTotal, String nom) {
        Bracelet = bracelet;
        Boitier = boitier;
        Cadran = cadran;
        Creator_id = creator_id;
        this.votesTotal = votesTotal;
        Nom = nom;
    }

    public String getCreator_id() {
        return Creator_id;
    }

    public void setCreator_id(String creator_id) {
        Creator_id = creator_id;
    }

    public Drawable getBracelet() { return Bracelet; }

    public void setBracelet(Drawable bracelet) { Bracelet = bracelet; }

    public Drawable getBoitier() {  return Boitier;  }

    public void setBoitier(Drawable boitier) { Boitier = boitier; }

    public Drawable getCadran() { return Cadran; }

    public void setCadran(Drawable cadran) { Cadran = cadran; }

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
