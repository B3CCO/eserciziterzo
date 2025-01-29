package it.edu.iisgubbio.vettori;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class ElminiaPosizione extends Application{
	Label lElenco= new Label("Elenco");
	TextField tfElenco= new TextField();
	Label lEliminaPosizione= new Label("Elimina posizione");
	TextField tfPosizione= new TextField();
	Label lRisultato= new Label("Risultato");
	Label lRisposta= new Label("??");
	Button bScambia=new Button("Rcambia");
	
	public void start(Stage finestra) throws Exception {
		GridPane principale = new GridPane();
		principale.add(lElenco,0,0);
		principale.add(tfElenco,1,0);
		principale.add(lEliminaPosizione,0,1);
		principale.add(tfPosizione,1,1);
		principale.add(lRisultato,0,2);
		principale.add(lRisposta,1,2);
		principale.add(bScambia,1,3);
		bScambia.setMaxWidth(Integer.MAX_VALUE);	
		principale.setVgap(10);
		principale.setHgap(10);
		Insets spazio=new Insets(10);
		principale.setPadding(spazio);
		
		Scene scena = new Scene(principale);
		finestra.setTitle("Doppie");
		finestra.setScene(scena);
		finestra.show();
		
		bScambia.setOnAction( e -> eseguiScambia() );
	}
	private void eseguiScambia() {
		
		
	}
	
	public static void main(String[] args) {
		launch(args);
	}

}
