package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
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
    private TextField txtNombreArtistico;

	
	@FXML
    private Button btnGuardar;

    @FXML
    private Button btnSalir;
    
    private Artista artista;
    
    private ObservableList<Artista> artistas;
	




	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
	  

	}
	//Voy a inicializar los atributos
	public void iniAttributtes(ObservableList<Artista> artistas) {
		this.artistas=artistas;
	}
	
    @FXML
    public void guardar(ActionEvent event) {
    	String nombreArtistico= this.txtNombreArtistico.getText();
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
		}
    	

    }

    @FXML
    public void salir(ActionEvent event) {

    }
	public Artista getArtista() {
		return artista;
	}


	


	


	
	
}
