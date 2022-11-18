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
	
    private ArrayList<String> nombres = new ArrayList<String>();
    private static final int ITEMSPERPAGE = 5;
   
    
    /**
     * 
     */
    @FXML
    private void initialize() {   
    	// Se inicializa el listado
    	this.initNombres(this.nombres);
    	
    	// Se calcula el número de páginas en función de los ítems del listado
    	// Si el número no es divisor del número de ítems, entonces se añade una página
    	pagination.setPageCount((nombres.size() / ITEMSPERPAGE) + 
    			(((nombres.size() % ITEMSPERPAGE) > 0)?1:0));
    	    	    	
    	pagination.setPageFactory((Integer pageIndex) -> {
    		return createPage(pageIndex);   
        });
    	
    	// Cada vez que se selecciona una página se cambia la barra de progreso
    	pagination.currentPageIndexProperty().addListener(
    		(observable, oldValue, newValue) -> {
    			progressBar.setProgress((newValue.doubleValue() + 1) / 
    					pagination.getPageCount());    			
    		});
    	    	 	
    	// Valor inicial de la barra de progreso
    	progressBar.setProgress((double) 1 / pagination.getPageCount()); 
    }
    
    private VBox createPage(int pageIndex) {        
        // Ítems por pagina
        VBox box = new VBox(); // Contenedor
        int page = pageIndex * ITEMSPERPAGE;
        
        // Se recorren los ítems sumando el número de páginas, o el límite de ítems del listado
        int limit = Math.min(page + ITEMSPERPAGE, nombres.size());
        for (int i = page; i < limit; i++) {
        	// Crea un Label con un nombre aleatorio
            Label text = new Label( (i+1) + ".- " + nombres.get(i));
               
            // Se añade el label al VBox
            box.getChildren().add(text);           
        }
        
        return box;
    }
    
    private void initNombres(ArrayList<String> nombres) {
    	 nombres.add("Juan");
    	 nombres.add("Carmen");
    	 nombres.add("Maria");
    	 nombres.add("Camila");
    	 nombres.add("Pablo");
    	 nombres.add("Cornelio");
    	 nombres.add("Anibal");
    	 nombres.add("Ruben");
    	 nombres.add("Julio");
    	 nombres.add("Manfred");
    	 nombres.add("Ana");
    	 nombres.add("Luis");
    	 nombres.add("Luz");
    	 nombres.add("Lucas");
    	 nombres.add("Gretta");
    	 nombres.add("Lauren");
    	 nombres.add("Oscar");
    	 nombres.add("James");
    }
       
}
