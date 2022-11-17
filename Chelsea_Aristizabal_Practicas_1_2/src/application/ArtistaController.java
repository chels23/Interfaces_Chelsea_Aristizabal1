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
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import javafx.scene.text.Text;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Modality;
import javafx.stage.Stage;
import registro.Artista;

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
    private ToggleGroup tg = new ToggleGroup();
    
    
    
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
		 combo1.getItems().addAll("España", "Colombia", "Italia",
		"Alemania", "EEUU", "Ecuador", "China", "Japón", "Australia");
		 
		 choice1.getItems().addAll("Pop", "Rock", "Jazz",
					"R&B", "Electronic", "KPOP", "Salsa", "Bachata", "Blues");
		 choice1.setValue("Selecciona Género Musical...");
		 
	       	 	
	    	
	    	// Cualquier nueva selección del usuario se registra en el texto de debajo
	    	combo1.getSelectionModel().selectedItemProperty().addListener(
	    		(observable, oldValue, newValue) -> {
	    			txtResultado.setText("Antiguo -> " + oldValue + "\n" + "Nuevo -> " + newValue);
	    		});   

	}
	//Voy a inicializar los atributos
	public void iniAttributtes(ObservableList<Artista> artistas) {
		this.artistas=artistas;
	}
	   public void initAttributtes(ObservableList<Artista> artistas, Artista a) {
	        this.artistas = artistas;
	        this.artista = a;
	        // cargo los datos de la persona
	        this.txtNombreArt.setText(a.getNombreArtistico());
	        this.txtEmail.setText(a.getEmail());
	        this.txtCompany.setText(a.getCompany());
	        this.txtBiografia.setText(a.getBiografia());
	    }
	 
	
    @FXML
    public boolean guardar(ActionEvent event) {
    	
    	String nombreArtistico= this.txtNombreArt.getText();
    	String email=this.txtEmail.getText();
    	String company=this.txtCompany.getText();
    	String biografia=this.txtBiografia.getText();
    	
    
    	
    	Artista a=new Artista(nombreArtistico,email, company, biografia);
    	
    	if (!artistas.contains(a)) {
    		this.artista=a;
    		Alert alert =new Alert(Alert.AlertType.INFORMATION);
    		alert.setHeaderText(null);
    		alert.setTitle("Información");
    		alert.setContentText("Se ha añadido correctamente");
    		alert.showAndWait();
    		
			Stage stage=(Stage) this.btnGuardar.getScene().getWindow();
			stage.close();
		}else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setTitle("Error");
            alert.setContentText("La persona ya existe");
            alert.showAndWait();
        }
    	
        String errorMessage = "";

        if (txtNombreArt.getText() == null || txtNombreArt.getText().length() == 0) {
            errorMessage += "El campo first name está vacío\n"; 
        }
        if (txtEmail.getText() == null || txtEmail.getText().length() == 0) {
            errorMessage += "El campo last name está vacío\n"; 
        }
        if (txtCompany.getText() == null || txtCompany.getText().length() == 0) {
            errorMessage += "El campo street está vacío\n"; 
        }

    

        if (errorMessage.length() == 0) {
            return true;
        } else {
        	// Se muestra un alert si no se puede eliminar la fila
    		Alert errorAlert = new Alert(AlertType.ERROR);
        	
    		errorAlert.setTitle("Hay campos incorrectos");
    		errorAlert.setHeaderText("Por favor, rellena correctamente los campos");
    		errorAlert.setContentText(errorMessage);
    		
    		errorAlert.showAndWait();
            return false;
        }
    

    }
    



    @FXML
    public void salir(ActionEvent event) {
    	
    	//Cerrar Ventana
    	Stage stage =(Stage) this.btnGuardar.getScene().getWindow();
    	stage.close();

    }
	public Artista getArtista() {
		return artista;
	}



	


	


	
	
}
