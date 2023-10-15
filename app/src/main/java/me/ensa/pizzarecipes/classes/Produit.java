package me.ensa.pizzarecipes.classes;

import androidx.annotation.DrawableRes;
import androidx.annotation.StringRes;

import java.io.Serializable;

public class Produit implements Serializable {
    private int id;
    private @StringRes int nom;
    private @StringRes int nbrIngredients;
    private @DrawableRes int phonto;
    private String duree;
    private @StringRes int detaisIngred;
    private @StringRes int description;
    private @StringRes int preparation;
    private static int comp;

    public Produit() {
    }

    public Produit(int nom, int nbrIngredients, int phonto, String duree, int detaisIngred, int description, int preparation){
        this.id = ++comp;
        this.nom = nom;
        this.nbrIngredients = nbrIngredients;
        this.phonto = phonto;
        this.duree = duree;
        this.detaisIngred = detaisIngred;
        this.description = description;
        this.preparation = preparation;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNom() {
        return nom;
    }

    public void setNom(int nom) {
        this.nom = nom;
    }

    public int getNbrIngredients() {
        return nbrIngredients;
    }

    public void setNbrIngredients(int nbrIngredients) {
        this.nbrIngredients = nbrIngredients;
    }

    public int getPhonto() {
        return phonto;
    }

    public void setPhonto(int phonto) {
        this.phonto = phonto;
    }

    public String getDuree() {
        return duree;
    }

    public void setDuree(String duree) {
        this.duree = duree;
    }

    public int getDetaisIngred() {
        return detaisIngred;
    }

    public void setDetaisIngred(int detaisIngred) {
        this.detaisIngred = detaisIngred;
    }

    public int getDescription() {
        return description;
    }

    public void setDescription(int description) {
        this.description = description;
    }

    public int getPreparation() {
        return preparation;
    }

    public void setPreparation(int preparation) {
        this.preparation = preparation;
    }

    @Override
    public String toString() {
        return "Produit{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", nbrIngredients=" + nbrIngredients +
                ", phonto=" + phonto +
                ", duree=" + duree +
                ", detaisIngred='" + detaisIngred + '\'' +
                ", description='" + description + '\'' +
                ", preparation='" + preparation + '\'' +
                '}';
    }
}
