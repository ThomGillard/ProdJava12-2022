class Refrigéré extends Produit{
    public Refrigéré(String nom, double prix, String marque, boolean estToxique, double temperature) {
        super(nom, prix, marque, estToxique);
        this.temperature = temperature;
    }
    final double temperature;

    public double getTemperature() {
        return temperature;
    }
}