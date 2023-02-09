package application;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import registro.Banda;
/**
 * Controlador de Album para la tabla de album
 * @author chelsea
 *
 */

public class AlbumController {

	@FXML
	private TableColumn<Banda, String> colFechaInicio;

	@FXML
	private TableColumn<Banda, String> colHistoria;

	@FXML
	private TableColumn<Banda, String> colNombre;

	@FXML
	private TableColumn<Banda, Integer> colNumIntegrantes;

	@FXML
	private TableColumn<Banda, String> colProductor;

	@FXML
	private TableView<Banda> tableBandas;

	// Lista auxiliar para TableView
	private ObservableList<Banda> bandaslis = FXCollections.observableArrayList(
			new Banda("Speak Now", "Taylor Swift", "",4,""),
			new Banda(" Thriller", "Michael Jackson", "",4,""),
			new Banda("The Dark Side of the Moon",  "Pink Floyd", "",4,""),
			new Banda("guardaespaldas", "Whitney Houston", "",4,""),
			new Banda("Bat out of Hell", "Meat Loaf", "",4,""),
			new Banda("Their Greatest Hits",  "Eagles", "",4,""),
			new Banda("Come On Over",  "Shania Twain", "",4,""),
			new Banda("Daydream",  "Mariah Carey ", "",4,""),
			new Banda("25", "Adele", "",4,""),
			new Banda("Hybrid Theory",  "Linkin Park", "",4,""),
			new Banda("Back in Black",  "AC/DC", "",4,"")

	);

	@FXML
	private void initialize() {
		// Asociamos cada columna del TableView a una propiedad de la clase Person
		colNombre.setCellValueFactory(new PropertyValueFactory<Banda, String>("NombreBanda"));
		colFechaInicio.setCellValueFactory(new PropertyValueFactory<Banda, String>("FechaInicio"));
		colHistoria.setCellValueFactory(new PropertyValueFactory<Banda, String>("Historia"));
		colNumIntegrantes.setCellValueFactory(new PropertyValueFactory<Banda, Integer>("NumIntegrantes"));
		colProductor.setCellValueFactory(new PropertyValueFactory<Banda, String>("Productor"));

		// Se rellena la tabla con objetos de la clase Banda
		tableBandas.setItems(bandaslis);

	}
}
