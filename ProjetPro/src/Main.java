import produit.*;
import stock.CreerStockException;
import stock.Stock;
import stock.StockGestion;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    private final static String MENU =
            "1. Créer un produit\n" +
            "2. Créer un stock\n" +
            "3. Ajouter un produit à un stock\n" +
            "4. Modifier la quantité de ce produit dans le stock\n" +
            "5. Supprimer un produit d'un stock\n" +
            "6. Quitter";
    private final static Scanner sc= new Scanner(System.in);
    private final static ProduitGestion produitGestion = new ProduitGestion();
    private final static StockGestion stockGestion = new StockGestion();

    public static void main(String[] args) {

        int choixMenu;


        do {
            System.out.println(MENU);
            System.out.println("Que voulez-vous faire ?");

            choixMenu = lireNombre();
            if (choixMenu >= 1 && choixMenu <= 5) {
                switch (choixMenu){
                    case 1 : afficherNouveauProduit();
                        break;
                    case 2: afficherNouveauStock();
                        break;
                        //ajouter produit à un stock
                    case 3 : ajouterProduitAStock();
                        break;
                    case 4 : modifierQuantite();
                        break;
                    case 5 : supprimerProduit();
                        break;
                }
            } else if (choixMenu==6){
                System.out.println("Vous quittez le programme.");
            }else{
                afficherMessageErreurMenu();
            }

        }while (choixMenu!=6);

        //Menu


    }

    private static void afficherMessageErreurMenu() {
        System.out.println("Veuillez entrer un choix entre 1 et 5");
    }

    //CASE 1
    private static void afficherNouveauProduit(){

        System.out.println("Nom du produit :");
        String nom = sc.next();

        System.out.println("Prix du produit :");
        double prix= sc.nextDouble();
        sc.nextLine();

        System.out.println("Marque du produit :");
        String marque = sc.next();

        // vérification pour produit toxique en userfriendly
        int choixToxique;
        do {

            System.out.println("Taper 1 si le produit est toxique et 2 si non");
            choixToxique=sc.nextInt();
            sc.nextLine();

        }while (choixToxique <1 || choixToxique >2);

        boolean estToxique = choixToxique == 1;
        // température
        double temperature;
        System.out.println("Quelle est la température de conservation du produits ? Comprise entre 0° et 30°");
        temperature= sc.nextDouble();
        sc.nextLine();

        System.out.println("Produit créé avec succès");

        try {
            produitGestion.creerProduit(nom,prix, marque, estToxique, temperature);
        } catch (CreerProduitException e) {
            System.out.println("Erreur dans l'encodage. Le message d'erreur est le suivant:");
            System.out.println(e.getMessage());
        }

        System.out.println("Nb produits " + produitGestion.getNbProduits());
    }

    //CASE 2
    private static void afficherNouveauStock(){
        System.out.println("Adresse : ");
        String adresse = sc.nextLine();

        System.out.println("Taille max du stock :");
        int tailleMax = lireNombre();

        System.out.println("Nom du stock :");
        String nomStock = sc.next();
        sc.nextLine();

        int choixToxique;
        do {

            System.out.println("Taper 1 si le produit est toxique et 2 si non");
            choixToxique=lireNombre();

        }while (choixToxique <1 || choixToxique >2);

        boolean estToxique = choixToxique == 1;

        int choixFrais;
        do {

            System.out.println("Taper 1 si le produit est frais et 2 si non");
            choixFrais=lireNombre();

        }while (choixFrais <1 || choixFrais >2);

        boolean estFrais = choixFrais == 1;



        System.out.println("Stock créé avec succès");

        try {
            stockGestion.creerStock(adresse,tailleMax,nomStock,estToxique,estFrais);
        } catch (CreerStockException e) {
            System.out.println("Erreur dans l'encodage. Le message d'erreur est le suivant:");
            System.out.println(e.getMessage());
        }


    }

    //CASE 3
    private static void ajouterProduitAStock(){
        System.out.println("Nom du produit à ajouter : ");
        String nomProduit = sc.next();

        System.out.println("Nom du stock dans lequel ajouter :");
        String nomStock = sc.next();


        System.out.println("Quantité du produit :");
        int quantite = lireNombre();
        sc.nextLine();


        try{
            stockGestion.ajouterProduitAStock(produitGestion,nomProduit,nomStock,quantite);
        }catch(CreerStockException e){
            System.out.println("Erreur dans l'encodage. Le message d'erreur est le suivant:");
            System.out.println(e.getMessage());
        }


        //Gérer pour pas que ça s'affiche quand plein
        //System.out.println("Ajout effectué avec succès");
        int qtt = stockGestion.getNbStockProduits();
        System.out.println(qtt + " produit dans le stock");
    }

    //CASE 4
    private static void modifierQuantite(){
        System.out.println("Nom du produit à modifier : ");
        String nomProduit = sc.next();

        System.out.println("Quantité du produit :");
        int quantite = lireNombre();


        try{
            stockGestion.modifierQuantite(nomProduit,quantite);
            int qtt = stockGestion.getQuantite(nomProduit);
            System.out.println("La quantité est de "+qtt+ " dans ce stock");
        }catch(CreerStockException e ){
            System.out.println("Erreur dans l'encodage. Le message d'erreur est le suivant:");
            System.out.println(e.getMessage());
        }


    }
    //CASE 5
    private static void supprimerProduit(){
        System.out.println("Nom du produit à supprimer : ");
        String nomProduit = sc.next();

        System.out.println("Nom du stock dans lequel supprimer :");
        String nomStock = sc.next();
        sc.nextLine();
        try{
            stockGestion.supprimerProduit(nomProduit,nomStock);
        }catch (CreerStockException e ){
            System.out.println("Erreur dans l'encodage. Le message d'erreur est le suivant:");
            System.out.println(e.getMessage());
        }

    }




    private static Integer lireNombre() {
        try {
            return Integer.parseInt(sc.nextLine());
        } catch (NumberFormatException e) {
            // e.printStackTrace();
            return -1;
        }
    }

    private static String lireString() throws Exception {
        String input = sc.nextLine();
        if (input == null || input.length() == 0) {
            throw new Exception();
        }
        return input;
    }
}


