package registro;

import java.util.Objects;



/**
 * 
 * Clase auxiliar que se emplear para el modelo de datos del TableView
 * 
 * @author chelsea DAM2
 * 
 */
public class Artista {





	/*Atributos de la clase Artista*/
    private String NombreArtistico;
    private String email;
    
    //private String genero;
    //private ComboBox pais;
    
    //private CheckBox redesSociales;
    private String company;
    //private ChoiceBox generomusical;
    private String biografia;
    
    /**
    * Constructor con nombre email, company y biografia
    *
    * @param nombreArtistico Nombre del artista
    * @param email correo electronico del artista
    * @param company las disquera del artista
    * @param biografia peque�a descripcion del artista
    * 
    */

	public Artista(String nombreArtistico, String email,  String company, String biografia) {
		super();
		NombreArtistico = nombreArtistico;
		this.email = email;
		//this.genero = genero;
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
	@Override
	public int hashCode() {
		return Objects.hash(NombreArtistico, biografia, company, email);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Artista other = (Artista) obj;
		return Objects.equals(NombreArtistico, other.NombreArtistico) && Objects.equals(biografia, other.biografia)
				&& Objects.equals(company, other.company) && Objects.equals(email, other.email);
	}
    

    
 
}