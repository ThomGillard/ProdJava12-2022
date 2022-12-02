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

        do {
            String message="";
            System.out.println(affichageMenu);
            System.out.println("Que voulez vous faire ?");
            choixMenu=sc.nextInt();
            while(choixMenu < 0 || choixMenu > 6){

                System.out.println(affichageMenu);
                System.out.println("Veuillez entrer un choix entre 1 et 6");
                choixMenu=sc.nextInt();
            }
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
                        System.out.println("Taper 1 si le produit est toxique et 2 si non");
                        choixToxique=sc.nextInt();
                    }while (choixToxique <1 || choixToxique >2);

                    //attribution du choix à toxique
                    estToxique = choixToxique == 1;

                    // création produit réfrigéré
                    if (choixFroid ==1){
                        System.out.println("Température de conservation du produit :");
                        double temperature = sc.nextDouble();
                        //crée le produit
                        Produit produitCreer = new Réfrigéré(nom,prix,marque,estToxique,temperature);
                        listeProduit.add(produitCreer);
                    //création produit non réfrigéré
                    }else {

                        //crée le produit
                        Produit produitCreer = new NonRéfrigéré(nom,prix,marque,estToxique);
                        listeProduit.add(produitCreer);

                    }
                    message = "\n\nProduit créé avec succès";
                    break;

                case 2:
                    System.out.println("Rue : ");
                    String rue = sc.next();

                    System.out.println("Numéro : ");
                    int numéro = sc.nextInt();
                    sc.nextLine();

                    System.out.println("Nom de la ville/du village : ");
                    String nomVille = sc.next();

                    System.out.println("Code postal :");
                    int codePostal = sc.nextInt();
                    sc.nextLine();

                    Adresse adresse = new Adresse(rue,numéro,nomVille,codePostal);

                    System.out.println("Taille max du stock :");
                    int tailleMax = sc.nextInt();

                    Stock stock = new Stock(adresse,tailleMax);
                    listeStock.add(stock);
                    message = "\n\nStock créé avec succès";
                    break;
                    case 3:
                        if (listeProduit.get(0 )!= null){
                            listeStock.get(0).ajouterProduit(listeProduit.get(0));
                            listeProduit.remove(0);
                        }
                        

                        break;
            }
            System.out.println(message);
        }while (choixMenu!=6);

    }
}