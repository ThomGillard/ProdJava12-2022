package produit;

public class ProduitFroid extends Produit {


    double temperature = 0;

    //Contructeur:

    public ProduitFroid(String nom, double prix, String marque, boolean estToxique, double temperature) {
        super(nom, prix, marque, estToxique);
        this.temperature = temperature;
    }
    public double getTemperature() {
        return temperature;
    }
}