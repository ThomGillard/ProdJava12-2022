package stock;

import produit.CreerProduitException;
import produit.Produit;

public class StockProduit {
    private Produit produit;
    private int quantite;

    public StockProduit(Produit produit, int quantite) {
        this.produit = produit;
        this.quantite = quantite;
    }

    public int getQuantite() {
        return quantite;
    }
    public void modifierQuantite(int nouvQuantite){
        this.quantite=nouvQuantite;
    }

    public Produit getProduit() {
        return produit;
    }
    /*public void supprimerProduit(String nomProduit, String nomStock)throws CreerProduitException {
        if (nomProduit == null || nomProduit.length() == 0 ){
            throw  new CreerProduitException("Le nom du produit ne peut être vide");
        }
        if (nomStock == null || nomStock.length() == 0 ){
            throw  new CreerProduitException("Le nom du stock ne peut être vide");
        }
        int indiceStock = rechercheIndiceStock(nomStock);
        stocks.get(indiceStock).

    }*/

}
