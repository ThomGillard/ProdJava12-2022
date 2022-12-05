package produit;

import java.util.ArrayList;
import java.util.Scanner;

public class ProduitGestion {


    private final ArrayList<Produit> produits = new ArrayList();
    private static final double MAX_TEMPERATURE_FRIGO = 8;



    public void creerProduit(String nom, double prix, String marque, boolean estToxique, double temperature) throws CreerProduitException{

        // Nom non vide:
        if (nom == null || nom.length() == 0 ){
           throw  new CreerProduitException("Le nom ne peut être vide");
        }
        // Prix positif
        if (prix <=0){
            throw new CreerProduitException("le prix ne peut être nul ou négatif");
        }
        // Marque non vide
        if (marque == null || marque.length() == 0){
            throw new CreerProduitException("La marque ne peut être vide");
        }
        // temperature entre ...
        if (temperature <0 || temperature > 30){
            throw new CreerProduitException("La température doit être comprise entre 0° et 30°");
        }


        Produit nouveauProduit;
        if (temperature < MAX_TEMPERATURE_FRIGO) {
            nouveauProduit = new ProduitFroid(nom, prix, marque, estToxique, temperature);
        } else {
            nouveauProduit = new ProduitTempere(nom, prix, marque, estToxique);
        }
        this.produits.add(nouveauProduit);
    }
    public int rechercheIndiceProduit(String nom){
        int i=0;
        while (i<produits.size() && !nom.equals(produits.get(i).getNom())){
            i++;
        }
        return i;
    }


    public int getNbProduits() {
        return produits.size();
    }

    public ArrayList<Produit> getProduits() {
        return produits;
    }
}