package it.edu.iisgubbio.testi;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Anagrammi extends Application{
	Label lParola1= new Label("parola1");
	Label lParola2= new Label("parola2");
	TextField tfParola1= new TextField();
	TextField tfParola2= new TextField();
	Button bAnagramma=new Button("anagramma?");
	Label lRisposta= new Label("??");
	
	public void start(Stage finestra) throws Exception {
		GridPane principale = new GridPane();
		
		principale.add(lParola1,0,0);
		principale.add(lParola2,0,1);
		principale.add(tfParola1,1,0);
		principale.add(tfParola2,1,1);
		principale.add(bAnagramma,0,2);
		principale.add(lRisposta,1,2);
		bAnagramma.setMaxWidth(Integer.MAX_VALUE);
		principale.setVgap(10);
		principale.setHgap(10);
		Insets spazio=new Insets(10);
		principale.setPadding(spazio);
		
		Scene scena = new Scene(principale);
		finestra.setTitle("Anagramma");
		finestra.setScene(scena);
		finestra.show();
		
		bAnagramma.setOnAction( e -> eseguiAnagramma() );
	}
	
	private void eseguiAnagramma() {
		
		char parola1[]=tfParola1.getText().toCharArray();
		char parola2[]=tfParola2.getText().toCharArray();
		int contatore=0;
		
		if(parola1.length==parola2.length) {
			for(int i=0; i<parola1.length;i++) {
				boolean presente=false;
				for(int indice=0; indice<parola2.length;indice++) {
					if(parola1[i]==parola2[indice]) {
						presente=true;
					}
					if(presente==true) {
						contatore++;
					}
				}
			}
			lRisposta.setText("è un anagramma");
		}else {
			lRisposta.setText("non è un anagramma");
		}
	}
	
	
	public static void main(String[] args) {
		launch(args);
	}
}
