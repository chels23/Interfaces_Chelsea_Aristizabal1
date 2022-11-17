package registro;

import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Slider;

/**
 * 
 * Clase auxiliar que se empleará para el modelo de datos del TableView
 * 
 * @author SBF
 * 
 */
public class Artista {





	/*Atributos de la clase Artista*/
    private String NombreArtistico;
    private String email;
    //private RadioButton genero;
    //private ComboBox pais;
    
    //private CheckBox redesSociales;
    private String company;
    //private ChoiceBox generomusical;
    private String biografia;
	public Artista(String nombreArtistico, String email,String company, String biografia) {
		super();
		NombreArtistico = nombreArtistico;
		this.email = email;
		
		this.company = company;
		this.biografia = biografia;
	}
	public String getNombreArtistico() {
		return NombreArtistico;
	}
	public void setNombreArtistico(String nombreArtistico) {
		NombreArtistico = nombreArtistico;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public String getBiografia() {
		return biografia;
	}
	public void setBiografia(String biografia) {
		this.biografia = biografia;
	}
    

    
 
}