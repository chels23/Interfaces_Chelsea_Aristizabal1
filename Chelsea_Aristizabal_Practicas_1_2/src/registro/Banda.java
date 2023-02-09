package registro;
/**
 * 
 * Clase auxiliar que se empleará para el modelo de datos del TableView
 * 
 * @author chelsea DAM2
 * 
 */
public class Banda {

	/*Atributos de la clase Artista*/
    private String NombreBanda;
    private String FechaInicio;
    private String Historia;
    private Integer NumIntegrantes;
    private String Productor;
    
	public Banda(String nombreBanda, String fechaInicio, String historia, Integer numIntegrantes, String productor) {
		
		NombreBanda = nombreBanda;
		FechaInicio = fechaInicio;
		Historia = historia;
		NumIntegrantes = numIntegrantes;
		Productor = productor;
	}

	public String getNombreBanda() {
		return NombreBanda;
	}

	public void setNombreBanda(String nombreBanda) {
		NombreBanda = nombreBanda;
	}

	public String getFechaInicio() {
		return FechaInicio;
	}

	public void setFechaInicio(String fechaInicio) {
		FechaInicio = fechaInicio;
	}

	public String getHistoria() {
		return Historia;
	}

	public void setHistoria(String historia) {
		Historia = historia;
	}

	public Integer getNumIntegrantes() {
		return NumIntegrantes;
	}

	public void setNumIntegrantes(Integer numIntegrantes) {
		NumIntegrantes = numIntegrantes;
	}

	public String getProductor() {
		return Productor;
	}

	public void setProductor(String productor) {
		Productor = productor;
	}
    

	


}
