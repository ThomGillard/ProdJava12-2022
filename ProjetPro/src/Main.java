import produit.CreerProduitException;
import produit.Produit;
import produit.ProduitGestion;
import stock.Stock;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    private final static String MENU = "1. Créer un produit\n" +
            "2. Créer un stock\n" +
            "3. Ajouter un produit à un stock\n" +
            "4. Modifier la quantité de ce produit dans le stock\n" +
            "5. Supprimer un produit d'un stock\n" +
            "6. Quitter";
    private final static Scanner sc= new Scanner(System.in);
    private final static ProduitGestion produitGestion = new ProduitGestion();

    public static void main(String[] args) {

        List<Produit> listeProduit = new ArrayList<Produit>();
        List<Stock> listeStock = new ArrayList<Stock>();
        int choixMenu;
        int choixFroid;



        do {
            System.out.println(MENU);
            System.out.println("Que voulez-vous faire ?");

            choixMenu = lireNombre();
            if (choixMenu >= 1 && choixMenu <= 5) {
                switch (choixMenu){
                    case 1 : afficherNouveauProduit();
                        break;
//            case 2: nouveauStock;
//            break,
//            case 3 : produitEnStock;
//            break;
//            case 4 : modifQuantStock;
//            break;
//            case 5 : suppProduit;
//            break;
                }
            } else {
                afficherMessageErreurMenu();
            }

        }while (choixMenu!=6);

        //Menu



    }

    private static void afficherMessageErreurMenu() {
        System.out.println("Veuillez entrer un choix entre 1 et 6");
    }

    private static void afficherNouveauProduit(){
        System.out.println("Nom du produit");
        String nomProduit = null;

        try {
            nomProduit = lireString();
        } catch (Exception e) {
            System.out.println("Le nom ne peut être vide");
            return;
        }
//        double prix = 31.10;
//        String marque = "Ferrero";
//        boolean toxique = true;
//        boolean froid = true;

        // Produit normal   --> nom, prix, marque, toxique
        // Produit refrigéré --> nom prix marque toxique, temperature



        System.out.println("Quel est la température de conservation");
        int temperature = lireNombre();
        if (temperature <= 0 || temperature >= 30) {
            System.out.println("La température doit être comprise entre 0 et 30°");
            return;
        }
        try {
            produitGestion.creerProduit(nomProduit,prix, marque, toxique, temperature);
        } catch (CreerProduitException e) {
            System.out.println("Erreur dans l'encodage. Le message d'erreur est le suivant:");
            System.out.println(e.getMessage());
        }

        System.out.println("Nb produits " + produitGestion.getNbProduits());
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