public class Stock  {

    private Adresse adresse;
    private int tailleMax;

    public int getTailleMax() {
        return tailleMax;
    }

    public void setTailleMax(int tailleMax) {
        this.tailleMax = tailleMax;
    }


    int[] tabQuantite = new int[tailleMax];
    Produit[] tabProduit = new Produit [tailleMax];


}
