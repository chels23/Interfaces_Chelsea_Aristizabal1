package registro;


/**
 * 
 * Clase auxiliar que se emplear para el modelo de datos del TableView
 * 
 * @author chelsea DAM2
 * 
 */
public class Discos {
	

	private String NombreDisco;
	private Integer Precio;
    private String Interprete;
    private String Descripcion;
    
    public Discos(String sName, Integer iPrecio, String sInterprete, String sDescripcion) {
        this.NombreDisco = sName;
        this.Precio= iPrecio;
        this.Interprete = sInterprete;
        this.Descripcion = sDescripcion;
    }

	public String getNombreDisco() {
		return NombreDisco;
	}

	public void setNombreDisco(String nombreDisco) {
		NombreDisco = nombreDisco;
	}

	public Integer getPrecio() {
		return Precio;
	}

	public void setPrecio(Integer precio) {
		Precio = precio;
	}

	public String getInterprete() {
		return Interprete;
	}

	public void setInterprete(String interprete) {
		Interprete = interprete;
	}

	public String getDescripcion() {
		return Descripcion;
	}

	public void setDescripcion(String descripcion) {
		Descripcion = descripcion;
	}


    
    

   

}
