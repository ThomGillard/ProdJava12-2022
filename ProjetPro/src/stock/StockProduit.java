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
    

}
