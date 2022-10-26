package registro;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Discos {
	

	private SimpleStringProperty NombreDisco;
	private SimpleIntegerProperty Precio;
    private SimpleStringProperty Interprete;
    private SimpleStringProperty Descripcion;
    
    public Discos(String sName, Integer iPrecio, String sInterprete, String sDescripcion) {
        this.NombreDisco = new SimpleStringProperty(sName);
        this.Precio= new SimpleIntegerProperty(iPrecio);
        this.Interprete = new SimpleStringProperty(sInterprete);
        this.Descripcion = new SimpleStringProperty(sDescripcion);
    }

	public SimpleStringProperty getNombreDisco() {
		return NombreDisco;
	}

	public void setNombreDisco(SimpleStringProperty nombreDisco) {
		NombreDisco = nombreDisco;
	}

	public SimpleIntegerProperty getPrecio() {
		return Precio;
	}

	public void setPrecio(SimpleIntegerProperty precio) {
		Precio = precio;
	}

	public SimpleStringProperty getInterprete() {
		return Interprete;
	}

	public void setInterprete(SimpleStringProperty interprete) {
		Interprete = interprete;
	}

	public SimpleStringProperty getDescripcion() {
		return Descripcion;
	}

	public void setDescripcion(SimpleStringProperty descripcion) {
		Descripcion = descripcion;
	}
    
    

   

}
