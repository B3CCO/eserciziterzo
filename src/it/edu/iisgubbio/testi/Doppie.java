package it.edu.iisgubbio.testi;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Doppie extends Application{
	Label lTesto= new Label("testo");
	TextField tfParola= new TextField();
	Button bDoppie=new Button("conta");
	Label lNumeroDoppie= new Label("n.doppie");
	Label lRisultato=new Label("??");
	
	public void start(Stage finestra) throws Exception {
		GridPane principale = new GridPane();
		principale.add(lTesto,0,0);
		principale.add(tfParola, 1, 0,5,1);
		principale.add(bDoppie, 1, 1,5,1);
		principale.add(lNumeroDoppie,0,2);
		principale.add(lRisultato, 1, 2);
		bDoppie.setMaxWidth(Integer.MAX_VALUE);	
		principale.setVgap(10);
		principale.setHgap(10);
		Insets spazio=new Insets(10);
		principale.setPadding(spazio);
		
		Scene scena = new Scene(principale);
		finestra.setTitle("Doppie");
		finestra.setScene(scena);
		finestra.show();
		
		bDoppie.setOnAction( e -> eseguiDoppie () );
		
	}
	private void eseguiDoppie() {
		char lettere[]=tfParola.getText().toCharArray();
		int c=0;
		for(int pos=0; pos<lettere.length-1;pos++) {
			if(lettere[pos+1]==lettere[pos]) {
				c=c+1;
				//inserire i cancelletti al posto della doppia
				lettere[pos]='#';
				lettere[pos+1]='#';
			}
		}
		String testo=new String(lettere);
		lRisultato.setText(""+c+" "+testo);
		
	}
	public static void main(String[] args) {
		launch(args);
	}

}
