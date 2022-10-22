package com.registro;


import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;

/**
 * 
 * Clase auxiliar que se empleará para el modelo de datos del TableView
 * 
 * @author SBF
 * 
 */
public class Artista {
	
	/*Atributos de la clase Artista*/


	private final SimpleStringProperty sNombreArtistico;
    private final SimpleObjectProperty fecha;
    private final SimpleStringProperty company;
    private final SimpleStringProperty email;
    
    /*Constructor*/
    

    public Artista(SimpleStringProperty sNombreArtistico, SimpleObjectProperty fecha, SimpleStringProperty company,
			SimpleStringProperty email) {
		super();
		this.sNombreArtistico = sNombreArtistico;
		this.fecha = fecha;
		this.company = company;
		this.email = email;
	}
    
    /*Métodos*/
    
    
    /*GETTERS AND SETTERS*/
    

	public SimpleStringProperty getsNombreArtistico() {
		return sNombreArtistico;
	}

	public SimpleObjectProperty getFecha() {
		return fecha;
	}

	public SimpleStringProperty getCompany() {
		return company;
	}

	public SimpleStringProperty getEmail() {
		return email;
	}
    
 
}