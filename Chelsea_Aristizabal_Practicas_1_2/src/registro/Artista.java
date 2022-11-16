package registro;




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
    //private String genero;
    //private String pais;
    //private int añosIndustria;
   // private String redesSociales;
    private String company;
    //private String generomusical;
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






	


    


    
 
}