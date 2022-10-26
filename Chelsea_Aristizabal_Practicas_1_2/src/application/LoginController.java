package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;

import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class LoginController {
	// Pantalla principal en la que se añade o quita contenido
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
			Node source = (Node) event.getSource();
			Stage stage = (Stage) source.getScene().getWindow();
			// Cargamos el ARCHIVO
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MenuController.class.getResource("/view/MenuPantalla.fxml"));
			rootLayout = (BorderPane) loader.load();
			stage.setTitle("Menu");
			
			MenuController menuCon = loader.getController();
			menuCon.setRoot1(rootLayout);
			Scene scene = new Scene(rootLayout);
			stage.setScene(scene);
			stage.show();
			// Se sitúa en el centro del diseño principal

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public BorderPane getRootLayout() {
		return rootLayout;
	}

	public void setRootLayout(BorderPane rootLayout) {
		this.rootLayout = rootLayout;
	}

}