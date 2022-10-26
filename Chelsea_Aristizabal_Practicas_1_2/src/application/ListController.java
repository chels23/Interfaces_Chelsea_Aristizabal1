package application;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import registro.Discos;

public class ListController {

	@FXML
	private TableView<Discos> tableDiscos;

	@FXML
	private TableColumn<Discos, String> colNombreDisco;
	@FXML
	private TableColumn<Discos, Integer> colPrecio;
	@FXML
	private TableColumn<Discos, String> colInterprete;
	@FXML
	private TableColumn<Discos, String> colDescripcion;

	// Lista auxiliar para TableView
	private ObservableList<Discos> data = FXCollections.observableArrayList(
			new Discos("Speak Now", 20, "Taylor Swift", "Su tercer disco, 'Speak Now', llegó en 2010 con singles como ‘Mean’, ‘Mine’ o ‘Back to December’, logrando vender millón y medio de copias en su primera"),
			new Discos("Isabella", 23, "isabella.johnson@example.com", ""),
			new Discos("Ethan", 33, "ethan.williams@example.com", ""),
			new Discos("Emma", 45, "emma.jones@example.com", ""),
			new Discos("Michael", 23, "michael.brown@example.com", ""));


	
	   @FXML
	    private void initialize() { 
			// Asociamos cada columna del TableView a una propiedad de la clase Person
			colNombreDisco.setCellValueFactory(new PropertyValueFactory<Discos, String>("NombreDisco"));
			colPrecio.setCellValueFactory(new PropertyValueFactory<Discos, Integer>("Precio"));
			colInterprete.setCellValueFactory(new PropertyValueFactory<Discos, String>("Interprete"));
			colDescripcion.setCellValueFactory(new PropertyValueFactory<Discos, String>("Descripcion"));
	
			// Se rellena la tabla con objetos de la clase Person
			tableDiscos.setItems(data);
		   
		   
	   }

}
