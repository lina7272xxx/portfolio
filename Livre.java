public class Livre {

    private String ISBN, titre, Auteur;
    private int prix;

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getAuteur() {
        return Auteur;
    }

    public void setAuteur(String auteur) {
        Auteur = auteur;
    }

    public int getPrix() {
        return prix;
    }

    public void setPrix(int prix) {
        this.prix = prix;
    }


    public Livre(String ISBN, String titre, String auteur, int prix) {
        this.ISBN = ISBN;
        this.titre = titre;
        Auteur = auteur;
        this.prix = prix;
    }


    public void Afficher() {
        System.out.println("ISBN: " + ISBN +
                ", Titre: " + titre +
                ", Auteur: " + Auteur +
                ", Prix: " + prix + "€");
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

}
