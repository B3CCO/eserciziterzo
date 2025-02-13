package it.edu.iisgubbio.testi;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class IP extends Application{
	Label lIndirizzo= new Label("indirizzo");
	TextField tfIndirizzo= new TextField();
	Button bVerifica=new Button("verifica");
	Label lRisposta= new Label("??");
	
	public void start(Stage finestra) throws Exception {
		GridPane principale = new GridPane();
		
		principale.add(lIndirizzo,0,0);
		principale.add(tfIndirizzo,1,0);
		principale.add(bVerifica,0,1);
		principale.add(lRisposta,1,1);
		principale.setVgap(10);
		principale.setHgap(10);
		Insets spazio=new Insets(10);
		principale.setPadding(spazio);
		
		Scene scena = new Scene(principale);
		finestra.setTitle("Cesare");
		finestra.setScene(scena);
		finestra.show();
		
		bVerifica.setOnAction( e -> eseguiVerifica() );
		
	}
	
	private void eseguiVerifica() {
		String indirizzo=tfIndirizzo.getText();
		String parti[];
		boolean indirizzoGiusto =false;
		
		parti=indirizzo.split("\\.");
		char [] controllo=indirizzo.toCharArray();
		for(int pos=0;pos<controllo.length;pos++) {
			if(controllo[pos]>='A' && controllo[pos]<='z') {
				
				indirizzoGiusto=true;
			}
		}
		
		if(indirizzoGiusto==false) {
			int ip[]=new int[parti.length];
			for(int i=0;i<parti.length;i++) {
				ip[i]=Integer.parseInt(parti[i]);
			}
			if(parti.length==4) {
				boolean valido=true;
				for(int i=0;i<ip.length;i++) {
					if(ip[i]>=255 || ip[i]<=0) {
						valido=false;
					}
					if(valido==false) {
						lRisposta.setText("l'indirizzo è errato");
					}else {
						lRisposta.setText("l'indirizzo è valido");
					}
				}
			}else {
				lRisposta.setText("l'indirizzo è errato");
			}

		}else {
			lRisposta.setText("l'indirizzo è errato");
		}
		
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
