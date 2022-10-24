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

import javafx.stage.Modality;
import javafx.stage.Stage;
import registro.Artista;


public class MenuController implements Initializable{
	
	
	
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
    private TableColumn <Artista, String>colCompany;

    @FXML
    private TableColumn <Artista, String>colBiografia;

    @FXML
    private TableColumn <Artista, String>colEmail;

    @FXML
    private TableColumn <Artista, String>colNombreArtistico;

    @FXML
    private TableView<Artista> tblArtista;
	
	private ObservableList<Artista> artistas;


	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		  
        
		artistas=FXCollections.observableArrayList();
		
		
		this.tblArtista.setItems(artistas);
		
		//Hay que asociar los atributos con las columnas de la tabla
		this.colNombreArtistico.setCellValueFactory(new PropertyValueFactory<Artista, String>("NombreArtistico"));
		this.colEmail.setCellValueFactory(new PropertyValueFactory<Artista, String>("email"));
		this.colCompany.setCellValueFactory(new PropertyValueFactory<Artista, String>("company"));
		this.colBiografia.setCellValueFactory(new PropertyValueFactory<Artista, String>("biografia"));
		
	}
    @FXML
   public void agregarPersona(ActionEvent event) {
    	
    	
    	
    	try {
    		// Cargo la vista
    		FXMLLoader loader=new FXMLLoader(getClass().getResource("/view/Registro.fxml"));
    		
    		// Cargo la ventana
			Parent root=loader.load();
			
			// Cojo el controlador
			ArtistaController controlador=loader.getController();
			controlador.iniAttributtes(artistas);
			
			//crear una escena que viene del padre
			Scene scene =new Scene(root);
			Stage stage= new Stage();
			
			//Modal hasta que no termine con el formulario no me deja volver a la ventana anterior
			stage.initModality(Modality.APPLICATION_MODAL);
			stage.setScene(scene);
			stage.showAndWait();
			
		    // cojo la persona devuelta
            Artista a = controlador.getArtista();
            if (a != null) {
 
                // Añado la persona
                this.artistas.add(a);
 
                // Refresco la tabla
                this.tblArtista.refresh();
            }
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	String nombreArtistico= this.txtNombreArtistico.getText();
    	String email=this.txtEmail.getText();
    	String company=this.txtCompany.getText();
    	String biografia=this.txtBiografia.getText();
    	Artista a=new Artista(nombreArtistico, email, company, biografia);
    	
    	//Comprobamos si existe el observableList es como un ArrayList
    	if(!this.artistas.contains(a)) {
    		this.artistas.add(a);
    		
    		this.tblArtista.setItems(artistas);
    		
    	}else {
    		
    		Alert alert =new Alert(Alert.AlertType.ERROR);
    		alert.setHeaderText(null);
    		alert.setTitle("Error");
    		alert.setContentText("El artista existe");
    		alert.showAndWait();
    		
    		
    		
    	}

    }


}

