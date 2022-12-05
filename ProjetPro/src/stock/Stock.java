package stock;

import produit.Produit;

public class Stock {

    private String adresse;
    private int tailleMax;
    private String nom;
    private boolean estToxique;
    private boolean estFrais;


    //Constructeur
    public Stock(String adresse, int tailleMax,String nom,boolean estToxique,boolean estFrais) {
        this.adresse = adresse;
        this.tailleMax = tailleMax;
        this.nom=nom;
        this.estToxique=estToxique;
        this.estFrais=estFrais;
    }
    //quantité physique du stock
    public int getTailleMax() {
        return tailleMax;
    }

    public String getNom() {
        return nom;
    }

    public boolean isEstToxique() {
        return estToxique;
    }

    public boolean isEstFrais() {
        return estFrais;
    }
}
