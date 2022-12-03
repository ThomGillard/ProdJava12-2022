package stock;

import produit.CreerProduitException;

import java.util.ArrayList;

public class StockGestion {

    private final ArrayList<Stock> stocks = new ArrayList<>();

    public void créerStock(String adresse, int tailleMax) throws CreerStockException {

        // adresse non vide
        if (adresse == null|| adresse.length()==0){
            throw new CreerStockException("L'adresse ne peut être nulle");
        }
        // Taille positive
        if (tailleMax<=0){
            throw new CreerStockException("La taille ne peut être nulle ou négative");
        }
        
        Stock nouveauStock = new Stock(adresse,tailleMax);
        this.stocks.add(nouveauStock);


    }
}
