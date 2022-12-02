public class Adresse {
    private String rue;

    public Adresse(String rue, int numero, String nomVille, int codePostal) {
        this.rue = rue;
        this.numero = numero;
        this.nomVille = nomVille;
        this.codePostal = codePostal;
    }

    private int numero;
    private String nomVille;
    private int codePostal;



    public String getRue() {
        return rue;
    }

    private void setRue(String rue) {
        this.rue = rue;
    }

    public int getNumero() {
        return numero;
    }

    private void setNumero(int numero) {
        this.numero = numero;
    }

    public String getNomVille() {
        return nomVille;
    }

    private void setNomVille(String nomVille) {
        this.nomVille = nomVille;
    }

    public int getCodePostal() {
        return codePostal;
    }

    private void setCodePostal(int codePostal) {
        this.codePostal = codePostal;
    }



}
