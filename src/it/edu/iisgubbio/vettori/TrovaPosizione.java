package it.edu.iisgubbio.vettori;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class TrovaPosizione extends Application{
	TextField tfNumeri= new TextField();
	Button bCerca=new Button("Cerca");
	Label lRisultato=new Label("??");
	Label lNumero=new Label("Numero");
	TextField tfCerca= new TextField();
	
	public void start(Stage finestra) throws Exception {
		GridPane principale = new GridPane();
		principale.add(tfNumeri, 0, 0,5,1);
		principale.add(lNumero, 0, 1);
		principale.add(tfCerca, 1, 1);
		principale.add(bCerca, 2, 1);
		principale.add(lRisultato, 0, 2);
		principale.setVgap(10);
		principale.setHgap(10);
		Insets spazio=new Insets(10);
		principale.setPadding(spazio);
		
		Scene scena = new Scene(principale);
		finestra.setTitle("Trova Posizione");
		finestra.setScene(scena);
		finestra.show();
		
		bCerca.setOnAction( e -> eseguiCerca () );
	}
	private void eseguiCerca() {
		String testo, parti[];
		int numero;
		numero=Integer.parseInt(tfCerca.getText());
		testo=tfNumeri.getText();
		parti=testo.split(" ");
		int numeri[]=new int[parti.length];
		for(int pos=0; pos<parti.length;pos++) {
			numeri[pos]=Integer.parseInt(parti[pos]);	
		}
		boolean presente=false;
		String se="";
		for(int pos=0; pos<numeri.length;pos++) {
			if(numeri[pos]==numero) {
				presente=true;
				se+=","+(pos+1);
			}
		}
		if(presente) {
			lRisultato.setText("trovato "+numero+" alla posizione "+se);
		}else {
			lRisultato.setText("non trovo "+numero);
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}

}
