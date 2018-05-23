package it.polito.tdp.porto;

import java.net.URL;
import java.util.ResourceBundle;

import it.polito.tdp.porto.model.Author;
import it.polito.tdp.porto.model.Model;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;

public class PortoController {
	
	private Model model;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ComboBox<Author> boxPrimo;

    @FXML
    private ComboBox<Author> boxSecondo;

    @FXML
    private TextArea txtResult;

    @FXML
    void handleCoautori(ActionEvent event) {
    		txtResult.clear();
    		boxSecondo.getItems().addAll(model.getNoCoauthors(boxPrimo.getValue()));
    		for(Author a: model.getCoautori(boxPrimo.getValue())) {
    			txtResult.appendText(a+"\n");
    		}
    }

    @FXML
    void handlePopolaTenda2(MouseEvent event) {
    		//boxSecondo.getItems().addAll(model.getNoCoauthors(boxPrimo.getValue()));
    }

    @FXML
    void handleSequenza(ActionEvent event) {
    		
    }

    @FXML
    void initialize() {
        assert boxPrimo != null : "fx:id=\"boxPrimo\" was not injected: check your FXML file 'Porto.fxml'.";
        assert boxSecondo != null : "fx:id=\"boxSecondo\" was not injected: check your FXML file 'Porto.fxml'.";
        assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'Porto.fxml'.";

    }
    
    public void setModel(Model model) {
		this.model = model;
		boxPrimo.getItems().addAll(model.getAutori());
}
    
}
