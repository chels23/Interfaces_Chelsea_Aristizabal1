package login;




import application.MenuController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;

import javafx.scene.layout.GridPane;
import javafx.stage.Stage;


public class MainLogin extends Application {
private GridPane rootLayout;	

@Override
public void start(Stage primaryStage) {
	try {
		// Carga el diseño del archivo FXML en la variable rootLayout
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(MainLogin.class.getResource("login.fxml"));
		rootLayout = (GridPane) loader.load();
		

	

		// Mostramos la escena del BorderPane de la variable rootLayot
		Scene scene = new Scene(rootLayout);

		
		primaryStage.setMaximized(false);
		primaryStage.setScene(scene);
		primaryStage.setTitle("CloudsMusic");
		primaryStage.show();
	} catch (Exception e) {
		e.printStackTrace();
	} 
}

public static void main(String[] args) {
	launch(args);
}


}