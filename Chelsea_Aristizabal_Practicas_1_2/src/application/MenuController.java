package application;


import java.awt.Insets;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Cursor;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import registro.Artista;


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
    private Button btnEditar;


    @FXML
    private TableColumn<Artista, String> colArt;
    @FXML
    private TableColumn<Artista, RadioButton> colGenero;


	@FXML
	private TableColumn<Artista, String> colEmail;
	@FXML
	private TableColumn<Artista, String> colCompany;

	@FXML
	private TableColumn<Artista, String> colBiografia;
	 private ObservableList<Artista> filtroArtistas;


	    @FXML
	    private TextField txtFiltrarNombre;
	// Tablas diferentes

	@FXML
	private TableView<Artista> tblArtista;


    // Lista auxiliar para TableView
    private ObservableList<Artista> artistas = FXCollections.observableArrayList(
    	    new Artista("Jorja Smith ",      "jacob.smith@example.com",    "RCA Records.", ""),
    	    new Artista("Giveon",            "giveon.johnson@example.com", "Columbia Records (CBS)",""),
    	    new Artista("Rihanna",           "ethan.williams@example.com", "MCA Records.", ""),
    	    new Artista("Taylor Swift",      "emma.jones@example.com",      "PolyGram. ",""),
    	    new Artista("Dijon",             "michael.brown@example.com", "WEA Music (ex Warner Bros Records)",""),
    	    new Artista("Burna Boy",         "michael.brown@example.com", "Epic Records.",""),
    	    new Artista("Jazmine Sullivan",  "michael.brown@example.com", "Island Records.",""),
    	    new Artista("Snoh Aalegra",      "michael.brown@example.com",  "Universal Music Group",""),
    	    new Artista("Kiana Ledé",        "michael.brown@example.com", "Warner Bros. Records","")
    	    
    	);
	

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {


        filtroArtistas=FXCollections.observableArrayList();

		// Se cambia el tipo de cursor cuando nos posicionamos por encima
		txtFiltrarNombre.setOnMouseEntered((event) -> {
			txtFiltrarNombre.setCursor(Cursor.HAND);
		});	

		// ***********************************ARTISTAS********************************************************

		// Tabla que se puede guardar los datos en la tbl Artistas


		this.tblArtista.setItems(artistas);

		// Hay que asociar los atributos con las columnas de la tabla
		this.colArt.setCellValueFactory(new PropertyValueFactory<Artista, String>("NombreArtistico") );
		this.colEmail.setCellValueFactory(new PropertyValueFactory<Artista, String>("email"));

		this.colCompany.setCellValueFactory(new PropertyValueFactory<Artista, String>("company"));
		this.colBiografia.setCellValueFactory(new PropertyValueFactory<Artista, String>("biografia"));

	}

	@FXML
	public void agregarPersona(ActionEvent event) {
		tblArtista.setEditable(true);
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
			stage.setTitle("Formulario");
	    	

			// Modal hasta que no termine con el formulario no me deja volver a la ventana
			// anterior
			stage.initModality(Modality.APPLICATION_MODAL);
			stage.setScene(scene);
			stage.showAndWait();

			// cojo el artistadevuelta
			Artista a = controlador.getArtista();
			if (a != null) {

				// Añado la persona
				this.artistas.add(a);

				// Refresco la tabla
				this.tblArtista.refresh();
			}

		} catch (IOException e) {
			Alert alert = new Alert(Alert.AlertType.ERROR);
			alert.setHeaderText(null);
			alert.setTitle("Error");
			alert.setContentText("El artista existe");
			alert.showAndWait();
		}

	

		}
	
    @FXML
    void modificar(ActionEvent event) {
    	 Artista a = this.tblArtista.getSelectionModel().getSelectedItem();
    	 
         if (a == null) {
             Alert alert = new Alert(Alert.AlertType.ERROR);
             alert.setHeaderText(null);
             alert.setTitle("Error");
             alert.setContentText("Debes seleccionar una persona");
             alert.showAndWait();
         } else {
  
             try {
  
                 // Cargo la vista
                 FXMLLoader loader = new FXMLLoader(getClass().
                         getResource("/view/Registro.fxml"));
  
                 // Cargo la ventana
                 Parent root = loader.load();
  
                 // Cojo el controlador
                 ArtistaController controlador = loader.getController();
                 controlador.initAttributtes(artistas, a);
                
                 // Creo el Scene
                 Scene scene = new Scene(root);
                 Stage stage = new Stage();
                 stage.initModality(Modality.APPLICATION_MODAL);
                 stage.setScene(scene);
                 stage.showAndWait();
                  
                 // cojo la persona devuelta
                 Artista aSeleccionado = controlador.getArtista();
                 if (aSeleccionado != null) {
                     if (!aSeleccionado.getNombreArtistico().toLowerCase().
                             contains(this.txtFiltrarNombre.getText().toLowerCase())) {
                         this.filtroArtistas.remove(aSeleccionado);
                     }
                     this.tblArtista.refresh();
                 }
  
             } catch (IOException e) {
                 Alert alert = new Alert(Alert.AlertType.ERROR);
                 alert.setHeaderText(null);
                 alert.setTitle("Error");
                 alert.setContentText(e.getMessage());
                 alert.showAndWait();
             }
  
         }
  

    }
	


	  @FXML
	    private void eliminar(ActionEvent event) {
	 
	        Artista a = this.tblArtista.getSelectionModel().getSelectedItem();
	 
	        if (a == null) {
	            Alert alert = new Alert(Alert.AlertType.ERROR);
	            alert.setHeaderText(null);
	            alert.setTitle("Error");
	            alert.setContentText("Debes seleccionar una persona");
	            alert.showAndWait();
	        } else {
	            // Elimino la persona
	            this.artistas.remove(a);
	            //this.filtroPersonas.remove(p);
	            this.tblArtista.refresh();
	 
	            Alert alert = new Alert(Alert.AlertType.INFORMATION);
	            alert.setHeaderText(null);
	            alert.setTitle("Info");
	            alert.setContentText("Persona eliminada");
	            alert.showAndWait();
	 
	        }
	 
	    }

	    @FXML
	    private void filtrarNombre(KeyEvent event) {
	    	 String filtroNombre = this.txtFiltrarNombre.getText();
	    	 
		        // Si el texto del nombre esta vacio, seteamos la tabla de personas con el original
		        if (filtroNombre.isEmpty()) {
		            this.tblArtista.setItems(artistas);
		        } else {
		 
		            // Limpio la lista
		            this.filtroArtistas.clear();
		 
		            for (Artista a : this.artistas) {
		                if (a.getNombreArtistico().toLowerCase().contains(filtroNombre.toLowerCase())) {
		                    this.filtroArtistas.add(a);
		                }
		            }
		 
		            this.tblArtista.setItems(filtroArtistas);
		 
		        }
		 
	    }
	  

	@FXML
	private void abrirArtistas(ActionEvent event) throws IOException {
		try {
			Node source = (Node) event.getSource();
			Stage stage = (Stage) source.getScene().getWindow();
			// Cargamos el ARCHIVO
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MenuController.class.getResource("/view/MenuPantalla.fxml"));
			root1 = (BorderPane) loader.load();
			stage.setTitle("Menu");
			MenuController menuCon = loader.getController();
			menuCon.setRoot1(root1);
			Scene scene = new Scene(root1);
			stage.setScene(scene);
			stage.show();
			// Se sitúa en el centro del diseño principal

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@FXML
	private void abrirDiscos(ActionEvent event) throws IOException {
		// Cargamos el archivo Controles Dinámicos
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(MenuController.class.getResource("/view/Discos.fxml"));
	    AnchorPane root = (AnchorPane) loader.load();
	    
	
	    root1.setCenter(root);

		
//
//		// Asociamos cada columna del TableView a una propiedad de la clase Person
//		colNombreDisco.setCellValueFactory(new PropertyValueFactory<Discos, String>("NombreDisco"));
//		colPrecio.setCellValueFactory(new PropertyValueFactory<Discos, Integer>("Precio"));
//		colInterprete.setCellValueFactory(new PropertyValueFactory<Discos, String>("Interprete"));
//		colDescripcion.setCellValueFactory(new PropertyValueFactory<Discos, String>("Descripcion"));
//
//		// Se rellena la tabla con objetos de la clase Person
//		tableDiscos.setItems(data);

	}

	@FXML
	void abrirUsuarios(ActionEvent event) {
		try {
			// Cargamos el archivo Controles Dinámicos
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MenuController.class.getResource("/view/Podcast.fxml"));
			AnchorPane lisr = (AnchorPane) loader.load();

			// Se sitúa en el centro del diseño principal
			root1.setCenter(lisr);
		} catch (IOException e) {
			e.printStackTrace();
		}

	

	}

	@FXML
	void abrirbandas(ActionEvent event) {
		try {
			// Cargamos el archivo Controles Dinámicos
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MenuController.class.getResource("/view/Bandas.fxml"));
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
			stage.setTitle("Manual");
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

    @FXML
    void abrirEstadistica(ActionEvent event) {
		try {
			// Cargo la vista
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/Estadisticas.fxml"));

			// Cargo la ventana
			Parent root = loader.load();

			// crear una escena que viene del padre
			Scene scene = new Scene(root);
			Stage stage = new Stage();
			stage.setTitle("Estadísticas");

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
