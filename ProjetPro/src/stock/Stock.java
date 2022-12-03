package stock;

import produit.Produit;

public class Stock {

    private String adresse;
    private int tailleMax;


    //Constructeur
    public Stock(String adresse, int tailleMax) {
        this.adresse = adresse;
        this.tailleMax = tailleMax;
    }
    public int getTailleMax() {
        return tailleMax;
    }

}
