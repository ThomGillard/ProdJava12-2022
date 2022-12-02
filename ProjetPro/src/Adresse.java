public class Adresse {
    private String rue;
    private int numero;
    private String nomVille;
    private int codePostal;


    public String getRue() {
        return rue;
    }

    // Constructeur:
    public Adresse(String rue, int numero, String nomVille, int codePostal) {
        this.rue = rue;
        this.numero = numero;
        this.nomVille = nomVille;
        this.codePostal = codePostal;

    }

    public int getNumero() {
        return numero;
    }

    public void setRue(String rue) {
        this.rue = rue;
    }

    public String getNomVille() {
        return nomVille;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public int getCodePostal() {
        return codePostal;
    }

    public void setNomVille(String nomVille) {
        this.nomVille = nomVille;
    }

    public void setCodePostal(int codePostal) {
        this.codePostal = codePostal;
    }
}
