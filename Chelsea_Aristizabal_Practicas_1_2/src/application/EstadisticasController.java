package application;

import java.util.ArrayList;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.chart.AreaChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Label;
import javafx.scene.control.Pagination;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.VBox;

public class EstadisticasController {
	
    @FXML
    private Pagination pagination;
        
    @FXML
    private ProgressBar progressBar;
	
    private ArrayList<String> canciones = new ArrayList<String>();
    private static final int ITEMSPERPAGE = 5;
	@FXML
    private AreaChart<String, Integer> areaChart;
	
	@FXML
    private PieChart pieChart;
    /**
     * 
     */
    @FXML
    private void initialize() {  
    	
    	initAreaChart();
		// Rellenamos los datos del gr�fico
		ObservableList<PieChart.Data> valueList = FXCollections.observableArrayList(
                new PieChart.Data("Pop", 80),
                new PieChart.Data("Rap", 25),
                new PieChart.Data("Hip-hop", 10),
                new PieChart.Data("trap Latino", 22),
                new PieChart.Data("R&B", 30));
		
		
		pieChart.setData(valueList);
		
		//PieChart pieChart = new PieChart(valueList);
		pieChart.setTitle("Albumn m�s escuchados");
		pieChart.getData().forEach(data -> {
		 String percentage = String.format("%.2f%%", (data.getPieValue() / 100));
		 Tooltip toolTip = new Tooltip(percentage);
		 toolTip.setStyle("-fx-background-color: gray; -fx-text-fill: whitesmoke;");
		 Tooltip.install(data.getNode(), toolTip);
		});

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
	private void initAreaChart() {
		// Para los AreaChart, SceneBuilder obliga a emplear un CategoryAxis cuyos valores deben ser String
		// aunque sean n�meros. Es posible indicar las categor�as con el m�todo setCategories de xAxis
		// pero si no se indica se crea autom�ticamente seg�n los datos de las series
		areaChart.setTitle("Visitas en CloudsMusic");
		// Se crean dos series con datos
		XYChart.Series<String, Integer> seriesApril= new XYChart.Series<String, Integer>();
		seriesApril.setName("2020");
        seriesApril.getData().add(new XYChart.Data<String, Integer>("Enero", 4));
        seriesApril.getData().add(new XYChart.Data<String, Integer>("Febrero", 10));
        seriesApril.getData().add(new XYChart.Data<String, Integer>("Marzo", 15));
        seriesApril.getData().add(new XYChart.Data<String, Integer>("Abril", 8));
        seriesApril.getData().add(new XYChart.Data<String, Integer>("Mayo", 5));
        seriesApril.getData().add(new XYChart.Data<String, Integer>("Junio", 18));
        seriesApril.getData().add(new XYChart.Data<String, Integer>("Julio", 15));
        seriesApril.getData().add(new XYChart.Data<String, Integer>("Agosto", 13));
        seriesApril.getData().add(new XYChart.Data<String, Integer>("Septiembre", 19));
        seriesApril.getData().add(new XYChart.Data<String, Integer>("Octubre", 21));
        seriesApril.getData().add(new XYChart.Data<String, Integer>("Noviembre", 21));
        
        XYChart.Series<String, Integer> seriesMay = new XYChart.Series<String, Integer>();
        seriesMay.setName("2021");
        seriesMay.getData().add(new XYChart.Data<String, Integer>("Enero", 20));
        seriesMay.getData().add(new XYChart.Data<String, Integer>("Febrero", 15));
        seriesMay.getData().add(new XYChart.Data<String, Integer>("Marzo", 13));
        seriesMay.getData().add(new XYChart.Data<String, Integer>("Abril", 12));
        seriesMay.getData().add(new XYChart.Data<String, Integer>("Mayo", 14));
        seriesMay.getData().add(new XYChart.Data<String, Integer>("Junio", 18));
        seriesMay.getData().add(new XYChart.Data<String, Integer>("Julio", 25));
        seriesMay.getData().add(new XYChart.Data<String, Integer>("Agosto", 25));
        seriesMay.getData().add(new XYChart.Data<String, Integer>("Septiembre", 23));
        seriesMay.getData().add(new XYChart.Data<String, Integer>("Octubre", 26));
        seriesMay.getData().add(new XYChart.Data<String, Integer>("Noviembre", 26));
        
        XYChart.Series<String, Integer> seriesA�o1 = new XYChart.Series<String, Integer>();
        seriesA�o1.setName("2022");
        seriesA�o1.getData().add(new XYChart.Data<String, Integer>("Enero", 30));
        seriesA�o1.getData().add(new XYChart.Data<String, Integer>("Febrero", 10));
        seriesA�o1.getData().add(new XYChart.Data<String, Integer>("Marzo", 8));
        seriesA�o1.getData().add(new XYChart.Data<String, Integer>("Abril", 14));
        seriesA�o1.getData().add(new XYChart.Data<String, Integer>("Mayo", 14));
        seriesA�o1.getData().add(new XYChart.Data<String, Integer>("Junio", 22));
        seriesA�o1.getData().add(new XYChart.Data<String, Integer>("Julio", 25));
        seriesA�o1.getData().add(new XYChart.Data<String, Integer>("Agosto", 25));
        seriesA�o1.getData().add(new XYChart.Data<String, Integer>("Septiembre", 38));
        seriesA�o1.getData().add(new XYChart.Data<String, Integer>("Octubre", 29));
        seriesA�o1.getData().add(new XYChart.Data<String, Integer>("Noviembre", 29));
        // Se a�aden las series al gr�fico de tipo AreaChart
        areaChart.getData().add(seriesApril);
        areaChart.getData().add(seriesMay);
        areaChart.getData().add(seriesA�o1);
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
