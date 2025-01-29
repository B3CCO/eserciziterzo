package it.edu.iisgubbio.testi;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Palindromo extends Application{
	Label lTesto= new Label("testo");
	TextField tfTesto= new TextField();
	Button bControlla=new Button("controlla");
	Label lRisposta= new Label();
	
	public void start(Stage finestra) throws Exception {
		GridPane principale = new GridPane();
		
		principale.add(lTesto,0,0);
		principale.add(tfTesto,1,0);
		principale.add(bControlla,0,1,2,1);
		principale.add(lRisposta,0,2,2,1);
		bControlla.setMaxWidth(Integer.MAX_VALUE);
		principale.setVgap(5);
		principale.setHgap(5);
		Insets spazio=new Insets(5);
		principale.setPadding(spazio);
		
		Scene scena = new Scene(principale);
		finestra.setTitle("Indovina la parola");
		finestra.setScene(scena);
		finestra.show();
		
		bControlla.setOnAction( e -> eseguiControlla() );
	}
	private void eseguiControlla() {
		char parola[];
		String testo=tfTesto.getText();
		parola=testo.toCharArray();
		char contrario[]=new char[parola.length];
		for(int i=0;i<contrario.length;i++) {
			contrario[i]=parola[parola.length-(i+1)];
		}
		System.out.println(contrario);
		
		String scritta= new String(parola);
		String inverso= new String(contrario);
		
		if(scritta.equals(inverso)) {
			lRisposta.setText("è un palindromo");
		}else {
			lRisposta.setText("non è un palindromo");
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
