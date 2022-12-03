package produit;

import java.util.ArrayList;

public class ProduitGestion {

    private final ArrayList<Produit> produits = new ArrayList();
    private static final int MAX_TEMPERATURE_FRIGO = 8;

        /* public void nouveauProduit (String nom,double prix,String marque, boolean estToxique){
                Produit nouveauProduit = new nouveauProduit();
                produits.add(nouveauProduit);

        } */

    //

    // Produit normal   --> nom, prix, marque, toxique
    // Produit refrigéré --> nom prix marque toxique, temperature


    public void creerProduit(String nom, double prix, String marque, boolean estToxique, int temperature) throws CreerProduitException{

        // Nom non vide
        // Prix positif
        // Marque non vide
        // temperature entre ...


        Produit nouveauProduit;
        if (temperature < MAX_TEMPERATURE_FRIGO) {
            nouveauProduit = new ProduitFroid(nom, prix, marque, estToxique, temperature);
        } else {
            nouveauProduit = new ProduitTempere(nom, prix, marque, estToxique);
        }
        this.produits.add(nouveauProduit);
    }

    public int getNbProduits() {
        return produits.size();
    }
}