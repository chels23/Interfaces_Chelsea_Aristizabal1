package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.beans.property.StringProperty;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;

import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import javafx.scene.control.ToggleGroup;
import javafx.scene.text.Text;


import javafx.stage.Stage;
/**
* Contiene el el modelo artista
*/
import registro.Artista;
/**
 * Controlador de Artista para ver
 * @author chelsea
 *
 */
public class ArtistaController implements Initializable {

	@FXML
	private TextArea txtBiografia;

	@FXML
	private TextField txtCompany;

	@FXML
	private TextField txtEmail;

	@FXML
	private TextField txtNombreArt;

	@FXML
	private Button btnGuardar;

	@FXML
	private Button btnSalir;

	private Artista artista;

	@FXML
	private ComboBox<String> combo1;

	@FXML
	private ChoiceBox<String> choice1;
	@FXML
	private Text txtResultado;
	@FXML
	ToggleGroup gender;

	private ObservableList<Artista> artistas;

	// Listener para el campo de texto
	InvalidationListener textListener = new InvalidationListener() {
		@Override
		public void invalidated(Observable observable) {
			StringProperty sp = (StringProperty) observable;
			System.out.println(observable.toString() + ", " + sp.get());
		}
	};

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// Controles de JavaFX a los que se añaden directamente los items
		combo1.getItems().addAll("España", "Colombia", "Italia", "Alemania", "EEUU", "Ecuador", "China", "Japón",
				"Australia");

		choice1.getItems().addAll("Pop", "Rock", "Jazz", "R&B", "Electronic", "KPOP", "Salsa", "Bachata", "Blues");
		choice1.setValue("Selecciona Género Musical...");

		// Cualquier nueva selección del usuario se registra en el texto de debajo
		combo1.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
			txtResultado.setText("Antiguo -> " + oldValue + "\n" + "Nuevo -> " + newValue);
		});

	}

	// Voy a inicializar los atributos
	public void iniAttributtes(ObservableList<Artista> artistas) {
		this.artistas = artistas;
	}

	public void initAttributtes(ObservableList<Artista> artistas, Artista artista) {
		this.artistas = artistas;
		this.artista = artista;
		// cargo los datos de la persona
		this.txtNombreArt.setText(artista.getNombreArtistico());
		this.txtEmail.setText(artista.getEmail());
		this.txtCompany.setText(artista.getCompany());
		this.txtBiografia.setText(artista.getBiografia());
	}
	public Artista getArtista() {
		return artista;
	}
	



	@FXML
	public void guardar(ActionEvent event) {
		// Cojo los datos
		String nombreArtistico = this.txtNombreArt.getText();
		String email = this.txtEmail.getText();
		String company = this.txtCompany.getText();
		String biografia = this.txtBiografia.getText();
		// Creo la persona
		Artista a = new Artista(nombreArtistico, email, company, biografia);
		
		// Compruebo si la persona existe
		if (!artistas.contains(a)) {
			

            // Modificar
            if (this.artista != null) {
 
                // Modifico el objeto
               
                this.artista.setNombreArtistico(nombreArtistico);
                this.artista.setEmail(email);
                this.artista.setCompany(company);
                this.artista.setBiografia(biografia);
                
 
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setHeaderText(null);
                alert.setTitle("Informacion");
                alert.setContentText("Se ha modificado correctamente");
                alert.showAndWait();
 
			
            } else {
                // insertando
                this.artista=a;
                
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setHeaderText(null);
                alert.setTitle("Informacion");
                alert.setContentText("Se ha añadido correctamente");
                alert.showAndWait();
 
            }
 

			Stage stage = (Stage) this.btnGuardar.getScene().getWindow();
			stage.close();
		} else {
			Alert alert = new Alert(Alert.AlertType.ERROR);
			alert.setHeaderText(null);
			alert.setTitle("Error");
			alert.setContentText("La persona ya existe");
			alert.showAndWait();
		}



	}

	@FXML
	public void salir(ActionEvent event) {
		this.artista = null;
		// Cerrar Ventana
		Stage stage = (Stage) this.btnGuardar.getScene().getWindow();
		stage.close();

	}



}
