package application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
/**
* Clase Main donde se inicia la aplicación
*
* @author chelsea DAM
* @version 1.0
*
*/
public class Main extends Application {

	@Override
	public void start(Stage primaryStage) {
		try {

			Parent root = FXMLLoader.load(getClass().getResource("/view/Login.fxml"));

			// Mostramos la escena del BorderPane de la variable rootLayot
			Scene scene = new Scene(root);
			primaryStage.setResizable(false);
			primaryStage.setScene(scene);
			primaryStage.setTitle("CloudsMusic");
			// set icon 
			primaryStage.getIcons().add(new Image("/img/musicalog.jpg"));

			
			scene.getStylesheets().add("resources/login.css");
			
			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}
}
