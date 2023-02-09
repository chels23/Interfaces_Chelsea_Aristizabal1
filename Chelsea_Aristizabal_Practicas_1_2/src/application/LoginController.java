package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;

import javafx.stage.Stage;

public class LoginController {
	// Pantalla principal en la que se agregade o quita contenido
	private BorderPane rootLayout;
	private AnchorPane rootLayout2;

	@FXML
	private TextField txtUser;
	@FXML
	private PasswordField txtPassword;

	@FXML
	private void initialize() {

	}

	@FXML
	public void Ingresar(ActionEvent event) throws IOException {
		if (txtUser.getText().equals("Admin") && txtPassword.getText().equals("123456")) {

			// Cargo la vista
			try {
				Node source = (Node) event.getSource();
				Stage stage = (Stage) source.getScene().getWindow();                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                   
				// Cargamos el ARCHIVO
				FXMLLoader loader = new FXMLLoader();
				
				loader.setLocation(MenuController.class.getResource("/view/MenuPantalla.fxml"));
				
				//stage=FXMLLoader.load(getClass().getClassLoader().getResource("/resources/menuPantalla.css"));
				rootLayout = (BorderPane) loader.load();
				stage.setTitle("Menu");
				
				MenuController menuCon = loader.getController();
				
				menuCon.setRoot1(rootLayout);
				Scene scene = new Scene(rootLayout);
			
				stage.setScene(scene);
				stage.show();
				// Se situ en elo principal

			} catch (IOException e) {
				e.printStackTrace();
			}

		} else if (txtUser.getText().equals("User") && txtPassword.getText().equals("123456")) {

			try {
				// Cargo la vista
				FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/PerfilUsuario.fxml"));

				// Cargo la ventana
				Parent root = loader.load();

				// crear una escena que viene del padre
				Scene scene = new Scene(root);
				Stage stage = new Stage();
				stage.setTitle("Mi perfil");
				scene.getStylesheets().add("resources/perfilusuario.css");

		
				stage.setScene(scene);
				stage.showAndWait();

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

//		// Cargo la vista
//		try {
//			// Cargamos el ARCHIVO
//			FXMLLoader loader = new FXMLLoader();
//			// Cargamos el ARCHIVO
//			Parent home =FXMLLoader.load(getClass().getResource("/view/MenuPantalla.fxml"));
//			Scene homeScene = new Scene(home);
//			Stage appstage=(Stage)((Node) event.getSource()).getScene().getWindow();
//			appstage.setScene(homeScene);
//			
//			
//			MenuController menuCon = loader.getController();
//			menuCon.setRoot1(rootLayout);
//			
//			
//			appstage.setTitle("Menu");
//			
//	
//			
//		
//			appstage.show();
//			

	}
	/**
	* Getter para que los controladores accedan al Stage con la ventana
	* principal
	*
	* @return El Stage con la ventana principal
	*/


	public AnchorPane getRootLayout2() {
		return rootLayout2;
	}

	public void setRootLayout2(AnchorPane rootLayout2) {
		this.rootLayout2 = rootLayout2;
	}

	public BorderPane getRootLayout() {
		return rootLayout;
	}

	public void setRootLayout(BorderPane rootLayout) {
		this.rootLayout = rootLayout;
	}

}