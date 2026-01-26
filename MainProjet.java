import java.util.ArrayList;

public class MainProjet {



        public static void main(String[] args) {

            Livre livre1, livre2, livre3, livre4;

            livre1 = new Livre("1111111", "titre 1", "auteur 1", 1);
            livre2 = new Livre("2222222", "titre 2", "auteur 2", 2);

            livre1.Afficher();
            System.out.println();  // Simplifié
            livre2.Afficher();
            System.out.println();

            // QUESTION 1 : Créer ArrayList et ajouter livre1 & livre2
            ArrayList<Livre> listeLivres = new ArrayList<>();
            listeLivres.add(livre1);
            listeLivres.add(livre2);

            // QUESTION 2 : Ajouter 2 autres livres
            livre3 = new Livre("3333333", "titre 3", "auteur 3", 3);
            livre4 = new Livre("4444444", "titre 4", "auteur 4", 4);

            listeLivres.add(livre3);
            listeLivres.add(livre4);

            livre3.Afficher();
            System.out.println();
            livre4.Afficher();
            System.out.println();

            // QUESTION 3 : Afficher l'ensemble des livres
            System.out.println("Liste complète des livres");
            for (Livre livre : listeLivres) {
                livre.Afficher();
                System.out.println();
            }
            System.out.println("Nombre total de livres dans l'ArrayList : " + listeLivres.size());

        }
    }
