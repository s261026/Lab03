/**
 * Sample Skeleton for 'Scene.fxml' Controller Class
 */

package it.polito.tdp.spellchecker;

import java.net.URL;
import java.util.LinkedList;
import java.util.ResourceBundle;

import it.polito.tdp.spellchecker.model.Dizionario;
import it.polito.tdp.spellchecker.model.Parola;
import javafx.fxml.FXML;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import javafx.scene.control.Button;
import javafx.scene.control.MenuButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FXMLController {
	
	private boolean italiano = false;

	/*
	 * dato un testo in input, il programma stampa le parole errate, il numero di
	 * errori, e il tempo impiegato per effettuare il controllo ortografico.
	 * L’interfaccia
	 */

		private Dizionario model;
	
	 	@FXML
	    private ResourceBundle resources;

	    @FXML
	    private URL location;

	    @FXML
	    private MenuButton menuLingua;

	    @FXML
	    private TextArea txtUtente;

	    @FXML
	    private TextArea txtSbagli;

	    @FXML
	    private TextField txtErrori;

	    @FXML
	    private Button btnClear;

	    @FXML
	    private TextField txtTime;

	    @FXML
	    void doClear(ActionEvent event) {

	    }

	    @FXML
	    void doTraduzione(ActionEvent event) {
	    	
	    	String testoInserito = this.txtUtente.getText();
	    	LinkedList <String> inserite = new LinkedList <String>();
	    	testoInserito.replaceAll("[.,\\/#!$%\\^&\\*;:{}=\\-_`~()\\[\\]\"]", "");
	    	String[] campi;
	    	campi = testoInserito.split(" ");
	    	
	    	for(int i=0; i< campi.length; i++)
	    		inserite.add(campi[i]);
	    	
	    	String risultato; 
	    	
	    	if(italiano = false)
	    		risultato = this.model.spellCheckText(inserite).toString();
	    	else
	    		risultato = this.model.spellCheckTextItaliano(inserite).toString();
	    		
	    	this.txtSbagli.setText(risultato);
	    	
	    	
	    	
	    }

	    @FXML
	    void writeInglese(ActionEvent event) {
	    	this.model.loadDictionary("English.txt");
	    	italiano = false;
	    }

	    @FXML
	    void writeItaliano(ActionEvent event) {
	    	this.model.caricaDizionario("Italian.txt");
	    	italiano = true;

	    }

	    @FXML
	    void initialize() {
	        assert menuLingua != null : "fx:id=\"menuLingua\" was not injected: check your FXML file 'Scene.fxml'.";
	        assert txtUtente != null : "fx:id=\"txtUtente\" was not injected: check your FXML file 'Scene.fxml'.";
	        assert txtSbagli != null : "fx:id=\"txtSbagli\" was not injected: check your FXML file 'Scene.fxml'.";
	        assert txtErrori != null : "fx:id=\"txtErrori\" was not injected: check your FXML file 'Scene.fxml'.";
	        assert btnClear != null : "fx:id=\"btnClear\" was not injected: check your FXML file 'Scene.fxml'.";
	        assert txtTime != null : "fx:id=\"txtTime\" was not injected: check your FXML file 'Scene.fxml'.";

	    }

		public void setModel(Dizionario model) {
			// TODO Auto-generated method stub
			this.model= model;
			
		}
}
