package application;

import java.net.URL;
import java.util.ResourceBundle;

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
    
    
    
    
    
    private ObservableList<Artista> artistas;
	




	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// Controles de JavaFX a los que se añaden directamente los items
		 combo1.getItems().addAll("España", "Combo2", "Combo3",
		"Combo4", "Combo5", "Combo6", "Combo7", "Combo8", "Combo9");
		 
		 choice1.getItems().addAll("Combo1", "Combo2", "Combo3",
					"Combo4", "Combo5", "Combo6", "Combo7", "Combo8", "Combo9");
		 choice1.setValue("Selecciona Género Musical...");

	}
	//Voy a inicializar los atributos
	public void iniAttributtes(ObservableList<Artista> artistas) {
		this.artistas=artistas;
	}
	
    @FXML
    public void guardar(ActionEvent event) {
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
