import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        List<Produit> listeProduit = new ArrayList<Produit>();
        int choixMenu;
        int choixFroid;
        int choixToxique;
        String affichageMenu= "1. Créer un produit\n" +
                "2. Créer un stock\n" +
                "3. Ajouter un produit à un stock\n" +
                "4. Modifier la quantité de ce produit dans le stock\n" +
                "5. Supprimer un produit d'un stock\n" +
                "6. Quitter";
        Scanner sc= new Scanner(System.in);
        System.out.println(affichageMenu);
        System.out.println("Que voulez vous faire ?");
        do {
            do {
                choixMenu=sc.nextInt();
                if (choixMenu < 0 || choixMenu > 6){
                    System.out.println(affichageMenu);
                    System.out.println("Veuillez entrer un choix entre 1 et 6");
                }
            }while (choixMenu < 0 || choixMenu > 6);
            // Menu 
            switch (choixMenu){
                case 1:
                    do {
                        System.out.println("Le produit doit être au réfrigérateur ?(1 pour 'oui' et 2 pour 'non')");
                        choixFroid = sc.nextInt();
                    }while(choixFroid != 1 || choixFroid !=2);
                    if (choixFroid ==1){
                        String nom;
                        double prix;
                        String marque;
                        boolean estToxique;
                        //Exception à géré

                        Produit produitCreer = new Réfrigéré();
                        listeProduit.add()
                    }else {
                        Produit
                    }

            }
        }while (choixMenu!=6);

    }
}