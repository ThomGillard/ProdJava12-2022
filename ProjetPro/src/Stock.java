public class Stock  {

    private Adresse adresse;
    private int tailleMax;

    int[] tabQuantite = new int[tailleMax];
    Produit[] tabProduit = new Produit [tailleMax];

    int nbProduits=0;



    //Constructeur
    public Stock(Adresse adresse, int tailleMax) {
        this.adresse = adresse;
        this.tailleMax = tailleMax;
    }
    public int getTailleMax() {
        return tailleMax;
    }
    public void ajouterProduit(Produit produit){
        tabProduit[nbProduits]=produit;
        nbProduits++;
    }

}
