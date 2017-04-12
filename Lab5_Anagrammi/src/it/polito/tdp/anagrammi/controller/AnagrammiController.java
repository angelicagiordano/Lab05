package it.polito.tdp.anagrammi.controller;



import java.net.URL;
import java.util.ResourceBundle;

import it.polito.anagrammi.model.Model;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class AnagrammiController {
	
	private Model model;
	

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField txtParola;

    @FXML
    private Button btnCalcola;

    @FXML
    private TextArea txtResultCorretti;

    @FXML
    private TextArea txtResultErrati;

    @FXML
    private Button btnReset;

    @FXML
    void doCalcola(ActionEvent event) {

    	String parola= txtParola.getText();
    	model.risolvi(parola);
    	for (String s: model.getAnagrammi(true)){
    		txtResultCorretti.appendText(s+"\n");
    	}
    	for (String s: model.getAnagrammi(false)){
    		txtResultErrati.appendText(s+"\n");
    	}
    }

    @FXML
    void doReset(ActionEvent event) {

    	txtResultCorretti.clear();
    	txtResultErrati.clear();
    	txtParola.clear();
    }

    @FXML
    void initialize() {
        assert txtParola != null : "fx:id=\"txtParola\" was not injected: check your FXML file 'Anagrammi.fxml'.";
        assert btnCalcola != null : "fx:id=\"btnCalcola\" was not injected: check your FXML file 'Anagrammi.fxml'.";
        assert txtResultCorretti != null : "fx:id=\"txtResultCorretti\" was not injected: check your FXML file 'Anagrammi.fxml'.";
        assert txtResultErrati != null : "fx:id=\"txtResultErrati\" was not injected: check your FXML file 'Anagrammi.fxml'.";
        assert btnReset != null : "fx:id=\"btnReset\" was not injected: check your FXML file 'Anagrammi.fxml'.";

    }

	public void setModel(Model model) {
		// TODO Auto-generated method stub
		
		this.model=model;
	}
}

