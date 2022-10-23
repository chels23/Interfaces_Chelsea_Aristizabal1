package application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class LoginController{
	// Pantalla principal en la que se añade o quita contenido
	private BorderPane rootLayout1;
	private Stage stage;
	
	@FXML
	private TextField txtUser;
	
	   @FXML
	    private void initialize() {
	        
	    }
	





    @FXML
    public void Ingresar(ActionEvent event) throws IOException {
    	// Cargo la vista
    	try {
			// Cargamos el archivo Controles Dinámicos
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MenuController.class.getResource("/view/MenuPantalla.fxml"));
			BorderPane listadoControles = (BorderPane) loader.load();

			// Se sitúa en el centro del diseño principal
			rootLayout1.setCenter(listadoControles);
		} catch (IOException e) {
			e.printStackTrace();
		}
	

		

    }
	public BorderPane getRootLayout() {
		return rootLayout1;
	}

	public void setRootLayout(BorderPane rootLayout1) {
		this.rootLayout1 = rootLayout1;
	}	
    


}