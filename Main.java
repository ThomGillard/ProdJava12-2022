import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        List<Produit> listeProduit = new ArrayList<Produit>();
        List<Stock> listeStock = new ArrayList<Stock>();
        int choixMenu;
        int choixFroid;

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
                //Création produit
                case 1:
                    do {
                        System.out.println("Le produit doit être au réfrigérateur ?(1 pour 'oui' et 2 pour 'non')");
                        choixFroid = sc.nextInt();
                    }while(choixFroid < 1 || choixFroid >2);

                    String nom;
                    double prix;
                    String marque;
                    boolean estToxique;
                    int choixToxique;
                    double temperature;

                    //Exception à géré

                    System.out.println("Nom du produit :");
                    nom = sc.next();

                    System.out.println("Prix du produit :");
                    prix= sc.nextDouble();
                    sc.nextLine();

                    System.out.println("Marque du produit :");
                    marque = sc.next();


                    // vérification pour produit toxique en userfriendly
                    do {
                        System.out.println("Tapper 1 si le produit est toxique et 2 sinon");
                        choixToxique=sc.nextInt();
                        sc.nextLine();
                    }while (choixToxique !=1 || choixToxique !=2);

                    //attribution du choix à toxique
                    estToxique = choixToxique == 1;

                    // création produit réfrigéré
                    if (choixFroid ==1){

                        System.out.println("Température du produit");
                        temperature = sc.nextDouble();
                        sc.nextLine();
                        //crée le produit
                        //Produit produitCreer = new Refrigere(nom,prix,marque,estToxique,temperature);
                        //listeProduit.add(produitCreer);

                        //création produit non réfrigéré
                    }else {
                        /*
                        //crée le produit
                        Produit produitCreer = new non_réfrigéré();
                        listeProduit.add(produitCreer);
                        */
                    }
                    break;

                case 2:

            }
        }while (choixMenu!=6);

    }
}