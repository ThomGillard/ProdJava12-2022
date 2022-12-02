class Réfrigéré extends Produit{

    public Réfrigéré(String nom, double prix, String marque, boolean estToxique) {
        super(nom, prix, marque, estToxique);
        this.temperature = temperature;
    }
    double temperature = 0;

    public double getTemperature() {
        return temperature;
    }
}