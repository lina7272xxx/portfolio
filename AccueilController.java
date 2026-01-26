import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import java.util.ArrayList;

public class AccueilController {

    @FXML private Button ajouter;
    @FXML private AnchorPane book;
    @FXML private TextField isbn;
    @FXML private Label isbn_lb;
    @FXML private Text nbre_livre;
    @FXML private TextField prix;
    @FXML private Label px_lb;
    @FXML private Button rechercher;
    @FXML private TextField titre;
    @FXML private Label titre_lb;


    private ArrayList<Livre> listeLivres = new ArrayList<>();


    @FXML
    private void initialize() {


        listeLivres.add(new Livre("1111111", "Le Petit Prince", "Antoine", 10));
        listeLivres.add(new Livre("2222222", "1984", "George Orwell", 12));
        listeLivres.add(new Livre("3333333", "Harry Potter", "J.K. Rowling", 15));
        listeLivres.add(new Livre("4444444", "Le Seigneur des Anneaux", "J.R.R. Tolkien", 20));

        updateNombreLivres();
    }

    @FXML
    private void handleRechercher() {
        String isbnRecherche = isbn.getText().trim();

        if (isbnRecherche.isEmpty()) {
            showAlert("Erreur", "Veuillez entrer un ISBN");
            return;
        }

        boolean trouve = false;
        for (Livre livre : listeLivres) {
            if (livre.getISBN().equals(isbnRecherche)) {
            
                titre.setText(livre.getTitre());
                prix.setText(livre.getPrix() + " €");
                trouve = true;
                break;
            }
        }

        if (!trouve) {
            
            titre.setText("ERREUR");
            prix.setText("ERREUR");
        }
    }


    @FXML
    private void handleAjouter() {
        try {

            String nouveauIsbn = isbn.getText().trim();
            String nouveauTitre = titre.getText().trim();
            String prixText = prix.getText().trim();


            if (nouveauIsbn.isEmpty() || nouveauTitre.isEmpty() || prixText.isEmpty()) {
                showAlert("Erreur", "Tous les champs doivent être remplis");
                return;
            }


            for (Livre livre : listeLivres) {
                if (livre.getISBN().equals(nouveauIsbn)) {
                    showAlert("Erreur", "ISBN déjà existant");
                    return;
                }
            }


            int nouveauPrix = Integer.parseInt(prixText);


            listeLivres.add(new Livre(nouveauIsbn, nouveauTitre, "Auteur inconnu", nouveauPrix));

            updateNombreLivres();


            isbn.clear();
            titre.clear();
            prix.clear();

            showAlert("Succès", "Livre ajouté ! Total: " + listeLivres.size() + " livres");

        } catch (NumberFormatException e) {
            showAlert("Erreur", "Le prix doit être un nombre");
        }
    }


    private void updateNombreLivres() {

        nbre_livre.setText("Nombre de livre :  " + listeLivres.size());
    }

    private void showAlert(String titre, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(titre);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}