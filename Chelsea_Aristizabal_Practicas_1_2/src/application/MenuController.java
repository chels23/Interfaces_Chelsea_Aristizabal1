package application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;

import javafx.stage.Modality;
import javafx.stage.Stage;
import registro.Artista;
import registro.Discos;

public class MenuController implements Initializable {

	private BorderPane root1;

	public BorderPane getRoot1() {
		return root1;
	}

	public void setRoot1(BorderPane root1) {
		this.root1 = root1;
	}

	private AnchorPane root2;

	public AnchorPane getRoot2() {
		return root2;
	}

	public void setRoot2(AnchorPane root2) {
		this.root2 = root2;
	}

	@FXML
	private Button btnAgregar;

	@FXML
	private TextField txtNombreArtistico;

	@FXML
	private TextField txtEmail;

	@FXML
	private TextField txtCompany;

	@FXML
	private TextArea txtBiografia;

	@FXML
	private TableColumn<Artista, String> colCompany;

	@FXML
	private TableColumn<Artista, String> colBiografia;

	@FXML
	private TableColumn<Artista, String> colEmail;

	@FXML
	private TableColumn<Artista, String> colNombreArtistico;

	// para segunda tabla
	@FXML
	private TableColumn<Artista, String> tbl2Company;

	@FXML
	private TableColumn<Artista, String> tbl2Biografia;

	@FXML
	private TableColumn<Artista, String> tbl2Email;

	@FXML
	private TableColumn<Artista, String> tbl2NombreArtistico;

	// Tablas diferentes

	@FXML
	private TableView<Artista> tblArtista;

	private ObservableList<Artista> artistas;

	@FXML
	private TableView<Discos> tableDiscos;

	@FXML
	private TableColumn<Discos, String> colNombreDisco;
	@FXML
	private TableColumn<Discos, Integer> colPrecio;
	@FXML
	private TableColumn<Discos, String> colInterprete;
	@FXML
	private TableColumn<Discos, String> colDescripcion;



	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {


		// ***********************************ARTISTAS********************************************************
//
//		// Tabla que se puede guardar los datos en la tbl Artistas
//
//		artistas = FXCollections.observableArrayList();
//
//		this.tblArtista.setItems(artistas);
//
//		// Hay que asociar los atributos con las columnas de la tabla
//		this.colNombreArtistico.setCellValueFactory(new PropertyValueFactory<Artista, String>("NombreArtistico"));
//		this.colEmail.setCellValueFactory(new PropertyValueFactory<Artista, String>("email"));
//		this.colCompany.setCellValueFactory(new PropertyValueFactory<Artista, String>("company"));
//		this.colBiografia.setCellValueFactory(new PropertyValueFactory<Artista, String>("biografia"));

	}

	@FXML
	public void agregarPersona(ActionEvent event) {

		try {
			// Cargo la vista
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/Registro.fxml"));

			// Cargo la ventana
			Parent root = loader.load();

			// Cojo el controlador
			ArtistaController controlador = loader.getController();
			controlador.iniAttributtes(artistas);

			// crear una escena que viene del padre
			Scene scene = new Scene(root);
			Stage stage = new Stage();

			// Modal hasta que no termine con el formulario no me deja volver a la ventana
			// anterior
			stage.initModality(Modality.APPLICATION_MODAL);
			stage.setScene(scene);
			stage.showAndWait();

//			
			

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}



	

	@FXML
	private void abrirArtistas(ActionEvent event) {
		// Cargamos el archivo
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(LoginController.class.getResource("/view/MenuPantalla.fxml"));

	}

	@FXML
	private void abrirDiscos(ActionEvent event) {
		try {
			// Cargamos el archivo Controles Dinámicos
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(getClass().getResource("/view/Discos.fxml"));
			AnchorPane lis = (AnchorPane) loader.load();

			// Se sitúa en el centro del diseño principal
			root1.setCenter(lis);
		} catch (IOException e) {
			e.printStackTrace();
		}

	
	}

	@FXML
	void abrirUsuarios(ActionEvent event) {
		try {
			// Cargamos el archivo Controles Dinámicos
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(getClass().getResource("/view/Discos.fxml"));
			AnchorPane lis = (AnchorPane) loader.load();

			// Se sitúa en el centro del diseño principal
			root1.setCenter(lis);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	@FXML
	void abrirbandas(ActionEvent event) {
		try {
			// Cargamos el archivo Controles Dinámicos
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(getClass().getResource("/view/Bandas.fxml"));
			AnchorPane lis = (AnchorPane) loader.load();
			

			// Se sitúa en el centro del diseño principal
			root1.setCenter(lis);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	@FXML
	private void abrirManual(ActionEvent event) {

		try {
			// Cargo la vista
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/ManualUsuario.fxml"));

			// Cargo la ventana
			Parent root = loader.load();

			// crear una escena que viene del padre
			Scene scene = new Scene(root);
			Stage stage = new Stage();

			// Modal hasta que no termine con el formulario no me deja volver a la ventana
			// anterior
			stage.initModality(Modality.APPLICATION_MODAL);
			stage.setScene(scene);
			stage.showAndWait();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
