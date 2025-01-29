package it.edu.iisgubbio.vettori;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class MinimoMassimo extends Application{
	TextField tfNumeri= new TextField();
	Button bMinimo=new Button("Minimo");
	Button bMassimo=new Button("Massimo");
	Label lRisultatoMinimo=new Label("??");
	Label lRisultatoMassimo=new Label("??");
	
	public void start(Stage finestra) throws Exception {
		GridPane principale = new GridPane();
		principale.add(tfNumeri, 0, 0,5,1);
		principale.add(bMinimo, 0, 1);
		principale.add(bMassimo, 1,1);
		principale.add(lRisultatoMinimo, 0, 2);
		principale.add(lRisultatoMassimo, 0, 3);
		principale.setVgap(10);
		principale.setHgap(10);
		Insets spazio=new Insets(10);
		principale.setPadding(spazio);
		
		Scene scena = new Scene(principale);
		finestra.setTitle("Minimo e Massimo");
		finestra.setScene(scena);
		finestra.show();
		
		bMinimo.setOnAction( e -> eseguiMinimo () );
		bMassimo.setOnAction( e -> eseguiMassimo () );
	}
	private void eseguiMinimo() {
		String testo, parti[];
		int minimo;
		testo=tfNumeri.getText();
		parti=testo.split(" ");
		int numeri[]=new int[parti.length];
		for(int pos=0; pos<parti.length;pos++) {
			numeri[pos]=Integer.parseInt(parti[pos]);	
		}
		minimo=numeri[0];
		for(int pos=1; pos<numeri.length;pos++) {
			if(numeri[pos]<minimo) {
				minimo=numeri[pos];
			}	
		}
		lRisultatoMinimo.setText("il numero minimo è "+minimo);
	}
	private void eseguiMassimo() {
		String testo, parti[];
		int massimo;
		testo=tfNumeri.getText();
		parti=testo.split(" ");
		int numeri[]=new int[parti.length];
		for(int pos=0; pos<parti.length;pos++) {
			numeri[pos]=Integer.parseInt(parti[pos]);	
		}
		massimo=numeri[0];
		for(int pos=1; pos<numeri.length;pos++) {
			if(numeri[pos]>massimo) {
				massimo=numeri[pos];
			}	
		}
		lRisultatoMassimo.setText("il numero massimo è "+massimo);
	}
	public static void main(String[] args) {
		launch(args);
	}


}
