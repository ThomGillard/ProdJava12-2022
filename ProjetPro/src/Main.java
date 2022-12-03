import produit.*;
import stock.Stock;

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
//            case 2: nouveauStock;
//            break,
//            case 3 : produitEnStock;
//            break;
//            case 4 : modifQuantStock;
//            break;
//            case 5 : suppProduit; Mathis
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
        }while (choixToxique <1 || choixToxique >2);
            boolean estToxique = choixToxique == 1;
        // température ;
            double temperature;
                System.out.println("Quelle est la température de conservation du produits ? Comprise entre 0° et 30°");
                temperature= sc.nextDouble();


        System.out.println("Produit créé avec succès");

        try {
            produitGestion.creerProduit(nom,prix, marque, estToxique, temperature);
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


