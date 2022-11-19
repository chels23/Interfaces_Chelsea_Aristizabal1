package application;

import java.util.ArrayList;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.Pagination;
import javafx.scene.control.ProgressBar;
import javafx.scene.layout.VBox;

public class EstadisticasController {
	
    @FXML
    private Pagination pagination;
        
    @FXML
    private ProgressBar progressBar;
	
    private ArrayList<String> canciones = new ArrayList<String>();
    private static final int ITEMSPERPAGE = 5;
   
    
    /**
     * 
     */
    @FXML
    private void initialize() {   
    	// Se inicializa el listado
    	this.initCanciones(this.canciones);
    	
    	// Se calcula el n�mero de p�ginas en funci�n de los �tems del listado
    	// Si el n�mero no es divisor del n�mero de �tems, entonces se a�ade una p�gina
    	pagination.setPageCount((canciones.size() / ITEMSPERPAGE) + 
    			(((canciones.size() % ITEMSPERPAGE) > 0)?1:0));
    	    	    	
    	pagination.setPageFactory((Integer pageIndex) -> {
    		return createPage(pageIndex);   
        });
    	
    	// Cada vez que se selecciona una p�gina se cambia la barra de progreso
    	pagination.currentPageIndexProperty().addListener(
    		(observable, oldValue, newValue) -> {
    			progressBar.setProgress((newValue.doubleValue() + 1) / 
    					pagination.getPageCount());    			
    		});
    	    	 	
    	// Valor inicial de la barra de progreso
    	progressBar.setProgress((double) 1 / pagination.getPageCount()); 
    }
    
    private VBox createPage(int pageIndex) {        
        // �tems por pagina
        VBox box = new VBox(); // Contenedor
        int page = pageIndex * ITEMSPERPAGE;
        
        // Se recorren los �tems sumando el n�mero de p�ginas, o el l�mite de �tems del listado
        int limit = Math.min(page + ITEMSPERPAGE, canciones.size());
        for (int i = page; i < limit; i++) {
        	// Crea un Label con un nombre aleatorio
            Label text = new Label( (i+1) + ".- " + canciones.get(i));
               
            // Se a�ade el label al VBox
            box.getChildren().add(text);           
        }
        
        return box;
    }
    
    private void initCanciones (ArrayList<String> canciones) {
    	canciones.add("La bachata Manuel Turizo ");
    	canciones.add("I'm good (Blue) Bebe Rexha");
    	canciones.add("Unholy Sam Smith");
    	canciones.add("Anti-Hero Taylor Swift ");
    	canciones.add("Rich Flex Drake");
    	canciones.add("As it Was Harry Styles");
    	canciones.add("Another Love Tom Odell");
    	canciones.add("Golden Hour JVKE");
    	canciones.add("CUFF IT Beyonce ");
    	canciones.add("Monotonia Shakira");
    	canciones.add("Die For You Joji");
    	
    }
       
}
