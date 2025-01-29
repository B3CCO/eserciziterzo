package it.edu.iisgubbio.vettori;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Push extends Application{
	
	int numeroCaselle=16;
	TextField tfNumeri= new TextField();
	TextField caselle[]= new TextField[numeroCaselle];
	Button bPush=new Button("Push");
	
	public void start(Stage finestra) throws Exception {
		GridPane principale = new GridPane();
		for(int pos=0; pos<caselle.length; pos++) {
			caselle[pos]= new TextField(""+pos);
			principale.add(caselle[pos], 0, pos);
		}
		principale.add(tfNumeri, 0, numeroCaselle);
		principale.add(bPush, 1, numeroCaselle);
		
		Scene scena = new Scene(principale);
		finestra.setTitle("Push");
		finestra.setScene(scena);
		finestra.show();
		
		bPush.setOnAction( e -> eseguiPush () );
	}
	private void eseguiPush() {
		String testo;
		for(int pos=0; pos<numeroCaselle;pos++ ) {
			testo=caselle[numeroCaselle-1].getText();
			caselle[pos].setText(testo);
			// leggo da sotto
			// scrivo sopra
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
