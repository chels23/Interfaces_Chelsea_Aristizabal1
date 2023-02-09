package application;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
/**
* Contiene el el modelo Discos
*/
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
			new Discos("Speak Now", 20, "Taylor Swift", ""),
			new Discos(" Thriller", 23, "Michael Jackson", "La historia que relatan los versos es la de un chico que lleva al cine a su novia para ver una pelicula de miedo"),
			new Discos("The Dark Side of the Moon", 33, "Pink Floyd", ""),
			new Discos("guardaespaldas", 45, "Whitney Houston", ""),
			new Discos("Bat out of Hell", 45, "Meat Loaf", ""),
			new Discos("Their Greatest Hits", 45, "Eagles", ""),
			new Discos("Come On Over", 45, "Shania Twain", ""),
			new Discos("Daydream", 45, "Mariah Carey ", ""),
			new Discos("25", 45, "Adele", ""),
			new Discos("Hybrid Theory", 45, "Linkin Park", ""),
			new Discos("Back in Black", 23, "AC/DC", "")
			
			
			);


	
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
