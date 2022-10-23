package registro;


import java.util.Objects;


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
    private String company;
    private String biografia;

    
    /*Constructor*/
	public Artista(String nombreArtistico, String email, String company, String biografia) {
		
		this.NombreArtistico = nombreArtistico;
		this.email = email;
		this.company = company;
		this.biografia = biografia;
	}
    


    
    /*Métodos*/
    
    
    /*GETTERS AND SETTERS*/
	
	public String getNombreArtistico() {
		return NombreArtistico;
	}


	public String getEmail() {
		return email;
	}


	public String getCompany() {
		return company;
	}


	public String getBiografia() {
		return biografia;
	}
	
	public void setNombreArtistico(String nombreArtistico) {
		NombreArtistico = nombreArtistico;
	}




	public void setEmail(String email) {
		this.email = email;
	}




	public void setCompany(String company) {
		this.company = company;
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