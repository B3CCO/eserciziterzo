package it.edu.iisgubbio.negozi;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Panini extends Application{
	TextField tfPersone= new TextField();
	TextField tfPrezzo= new TextField();
	Label lPersone= new Label("persone");
	Label lPrezzo= new Label("prezzo");
	Label lScontato= new Label("scontato");
	Label lPrezzoScontato= new Label("??");
	Label lPrezzoTotale= new Label("??");
	Button bTotale= new Button("totale");
	
	public void start(Stage finestra) throws Exception {
		GridPane principale = new GridPane();
		
		principale.add(lPersone, 0, 0);
		principale.add(lPrezzo, 0, 1);
		principale.add(bTotale, 0, 2);
		principale.add(lScontato, 0, 3);
		principale.add(lPrezzoTotale, 1, 2);
		principale.add(lPrezzoScontato, 1, 3);
		principale.add(tfPersone, 1, 0);
		principale.add(tfPrezzo, 1, 1);
		
		Scene scena = new Scene(principale);
		scena.getStylesheets().add("it/edu/iisgubbio/negozi/Panini.css");
		principale.getStyleClass().add("principale");
		finestra.setTitle("Panini");
		finestra.setScene(scena);
		finestra.show();
		
		bTotale.setOnAction( e -> eseguiTotale () );
	}
	
	private void eseguiTotale() {
		int persone;
		double prezzo,sconto,totale;
		String sScontato,sPrezzoTotale;
		
		persone=Integer.parseInt(tfPersone.getText());
		prezzo=Double.parseDouble(tfPrezzo.getText());
		sconto=0;
		totale=persone*prezzo;
		if(totale>=100) {
			sconto=totale*20/100;
		}else {
			if(totale>=50) {
				sconto=totale*10/100;
			}
		}
		sScontato=""+sconto;
		sPrezzoTotale=""+totale;
		lScontato.setText(sScontato);
		lPrezzoScontato.setText(sPrezzoTotale);
		
		
	}
	
	public static void main(String[] args) {
		launch(args);
	}
	

}
