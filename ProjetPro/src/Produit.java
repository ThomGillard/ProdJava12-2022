abstract class Produit {
    private final String nom;
    private int prix;
    private final String marque;

    public Produit(String nom, int prix, String marque, boolean estToxique) {
        this.nom = nom;
        this.prix = prix;
        this.marque = marque;
        this.estToxique = estToxique;
    }

    private boolean estToxique;

    public String getNom() {
        return nom;
    }

    public int getPrix() {
        return prix;
    }

    public void setPrix(int prix) {
        this.prix = prix;
    }

    public String getMarque() {
        return marque;
    }

    public boolean isEstToxique() {
        return estToxique;
    }

    public void setEstToxique(boolean estToxique) {
        this.estToxique = estToxique;
    }
}
