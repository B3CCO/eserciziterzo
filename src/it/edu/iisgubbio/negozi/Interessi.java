package it.edu.iisgubbio.negozi;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Interessi extends Application{
	TextField tfCapitaleIniziale= new TextField();
	TextField tfAnni= new TextField();
	TextField tfInteressi= new TextField();
	Label lCapitaleIniziale= new Label("Capitale iniziale");
	Label lAnni= new Label("Anni");
	Label lInteressi= new Label("Interessi");
	Label lCalcola= new Label("??");
	Button bCalcola= new Button("Calcola");
	
	public void start(Stage finestra) throws Exception {
		GridPane principale = new GridPane();
		
		principale.add(lCapitaleIniziale, 0, 0);
		principale.add(lAnni, 0, 1);
		principale.add(lInteressi, 0, 2);
		principale.add(lCalcola, 1, 3);
		principale.add(bCalcola, 0, 3);
		principale.add(tfCapitaleIniziale, 1, 0);
		principale.add(tfAnni, 1, 1);
		principale.add(tfInteressi, 1, 2);
		
		
		Scene scena = new Scene(principale);
		scena.getStylesheets().add("it/edu/iisgubbio/negozi/Interessi.css");
		principale.getStyleClass().add("principale");
		lCalcola.getStyleClass().add("lCalcola");
		finestra.setTitle("Interessi");
		finestra.setScene(scena);
		finestra.show();
		
		bCalcola.setOnAction( e -> eseguiInteressi () );
	
	}
	
	private void eseguiInteressi() {
		double capitaleiniziale, interessi, risultato;
		int anni;
		String sRisultato;
		
		capitaleiniziale=Double.parseDouble(tfCapitaleIniziale.getText());
		interessi=Double.parseDouble(tfInteressi.getText());
		anni=Integer.parseInt(tfAnni.getText());
		risultato=capitaleiniziale;
		
		for(int x=1; x<=anni; x++) {
			risultato=risultato+risultato/100*interessi;
		}
		sRisultato= ""+risultato;
		lCalcola.setText(sRisultato);
		
		
	}
	
	public static void main(String[] args) {
		launch(args);
	}

}
