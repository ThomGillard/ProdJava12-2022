class Réfrigéré extends Produit{
    public Réfrigéré(String nom, double prix, String marque, boolean estToxique) {
        super(nom, prix, marque, estToxique);
        this.temperature = temperature;
    }
    final double temperature;

    public double getTemperature() {
        return temperature;
    }
}