package stock;

import produit.CreerProduitException;
import produit.Produit;
import produit.ProduitFroid;
import produit.ProduitGestion;

import java.util.ArrayList;

public class StockGestion {

    private final ArrayList<Stock> stocks = new ArrayList<>();
    private ArrayList<StockProduit> stockProduits = new ArrayList<>();


    public void creerStock(String adresse, int tailleMax,String nom,boolean estToxique,boolean estFrais) throws CreerStockException {

        // adresse non vide
        if (adresse == null|| adresse.length()==0){
            throw new CreerStockException("L'adresse ne peut être nulle");
        }
        // Taille positive
        if (tailleMax<=0){
            throw new CreerStockException("La taille ne peut être nulle ou négative");
        }
        if (nom == null || nom.length()==0){
            throw new CreerStockException("Le nom ne peut être null");
        }

        
        Stock nouveauStock = new Stock(adresse,tailleMax,nom,estToxique,estFrais);
        this.stocks.add(nouveauStock);


    }
    public void ajouterProduitAStock(ProduitGestion produitGestion,String nomProduit,String nomStock,int quantite)throws CreerStockException{

        int indiceStock = rechercheIndiceStock(nomStock);
        int indiceProd = produitGestion.rechercheIndiceProduit(nomProduit);

        ArrayList<Produit> produits = produitGestion.getProduits();
        StockProduit stockProduit = new StockProduit(produits.get(indiceProd),quantite);
        //Si prod froid et toxique
        if (produits.get(indiceProd) instanceof ProduitFroid){
            if (produits.get(indiceProd).isEstToxique()){
                //vérifier si le stock est frais et toxique
                if (stocks.get(indiceStock).isEstFrais() &&stocks.get(indiceStock).isEstToxique() ){
                    //vérifier qu'on ne dépasse pas la taille max
                    if ((quantite +getQuantiteTot()) <= stocks.get(indiceStock).getTailleMax()){
                        stockProduits.add(stockProduit);
                    }else{
                        throw new CreerStockException("Le stock est plein");
                    }
                }else{
                    throw new CreerStockException("Impossible d'ajouter, le produit et le stock ne possèdent pas les mêmes attributs");
                }

                //si non toxique
            }else{
                if (stocks.get(indiceStock).isEstFrais() && !stocks.get(indiceStock).isEstToxique() ){
                    //vérifier qu'on ne dépasse pas la taille max
                    if ((quantite +getQuantiteTot()) <= stocks.get(indiceStock).getTailleMax()){
                        stockProduits.add(stockProduit);
                    }else{
                        throw new CreerStockException("Le stock est plein");
                    }
                }else{
                    throw new CreerStockException("Impossible d'ajouter, le produit et le stock ne possèdent pas les mêmes attributs");
                }
            }
            //si produit tempere et toxique
        }else{
            if (produits.get(indiceProd).isEstToxique()){
                if (!stocks.get(indiceStock).isEstFrais() && stocks.get(indiceStock).isEstToxique() ){
                    //vérifier qu'on ne dépasse pas la taille max
                    if ((quantite +getQuantiteTot()) <= stocks.get(indiceStock).getTailleMax()){
                        stockProduits.add(stockProduit);
                    }else{
                        throw new CreerStockException("Le stock est plein");
                    }
                }else {
                    throw new CreerStockException("Impossible d'ajouter, le produit et le stock ne possèdent pas les mêmes attributs");
                }
                //si non toxique
            }else{
                if (!stocks.get(indiceStock).isEstFrais() && !stocks.get(indiceStock).isEstToxique() ){
                    //vérifier qu'on ne dépasse pas la taille max
                    if ((quantite +getQuantiteTot()) <= stocks.get(indiceStock).getTailleMax()){
                        stockProduits.add(stockProduit);
                    }else{
                        throw new CreerStockException("Le stock est plein");
                    }
                }else {
                    throw new CreerStockException("Impossible d'ajouter, le produit et le stock ne possèdent pas les mêmes attributs");
                }
            }
        }

    }
    public void modifierQuantite(String nomProd,int nouvQuantite)throws CreerStockException{

        if (nomProd == null || nomProd.length()==0){
            throw new CreerStockException("Le nom ne peut être null");
        }


        int indiceStockProd = rechercheIndiceStockProduit(nomProd);
        stockProduits.get(indiceStockProd).modifierQuantite(nouvQuantite);

    }
    public void supprimerProduit(String nomProduit,String nomStock)throws CreerStockException{
        if (nomProduit == null || nomProduit.length()==0){
            throw new CreerStockException("Le nom du produit ne peut être null");
        }
        if (nomStock == null || nomStock.length()==0){
            throw new CreerStockException("Le nom du stock ne peut être null");
        }

        int indiceStock = rechercheIndiceStock(nomStock);
        int indiceProd = rechercheIndiceStockProduit(nomProduit);
        stockProduits.remove(indiceProd);
        System.out.println(getNbStockProduits());
    }


    public int getQuantiteTot(){
        int i=0;
        int quantiteTot=0;
        while (i< stockProduits.size()){
            quantiteTot+=stockProduits.get(i).getQuantite();
            i++;
        }
        return quantiteTot;
    }
    public int rechercheIndiceStockProduit(String nom){
        int i=0;
        while (i<stockProduits.size() && !nom.equals(stockProduits.get(i).getProduit().getNom())){
            i++;
        }
        return i;
    }

    public int rechercheIndiceStock(String nom){
        int i=0;
        while (i<stocks.size() && !nom.equals(stocks.get(i).getNom())){
            i++;
        }
        return i;
    }

    public int getNbStockProduits() {
        return stockProduits.size();
    }
    public int getQuantite(String nom){
        int i= rechercheIndiceStockProduit(nom);
        return stockProduits.get(i).getQuantite();
    }
}
