package application;

import java.io.IOException;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;

import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;


public class LoginController{
	// Pantalla principal en la que se a�ade o quita contenido
	private BorderPane rootLayout;

	
	
	
	@FXML
	private TextField txtUser;
	
	   @FXML
	    private void initialize() {
	        
	    }
	





    @FXML
    public void Ingresar(ActionEvent event) throws IOException {
    	// Cargo la vista
    	try {
    	
			// Cargamos el ARCHIVO
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MenuController.class.getResource("/view/MenuPantalla.fxml"));
			BorderPane listadoControles = (BorderPane) loader.load();

			// Se sit�a en el centro del dise�o principal
			rootLayout.setCenter(listadoControles);
		} catch (IOException e) {
			e.printStackTrace();
		}
	

		

    }
	public BorderPane getRootLayout() {
		return rootLayout;
	}

	public void setRootLayout(BorderPane rootLayout1) {
		this.rootLayout = rootLayout1;
	}	
    


}