package it.edu.iisgubbio.matematica;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Tabellina  extends Application{
	TextField tfNumero= new TextField();
	Button bTabellina= new Button("tabellina");
	Label lRisultato= new Label("??");
	
	public void start(Stage finestra) throws Exception {
		GridPane principale = new GridPane();
		
		principale.add(tfNumero, 0, 0);
		principale.add(bTabellina, 0, 1);
		principale.add(lRisultato, 0, 2);
		
		Scene scena = new Scene(principale);
		finestra.setTitle("Tabellina");
		finestra.setScene(scena);
		finestra.show();
		
		bTabellina.setOnAction( e -> eseguiTabellina () );
		
	}
	
	private void eseguiTabellina() {
		int numero, x;
		 String sequenza;
		 
		 numero=Integer.parseInt(tfNumero.getText());
		 sequenza="" +numero;
		 for(x=numero*2 ; x<=numero*10; x+=numero) {
			 sequenza+= ", "+x;
			 
		 }
		lRisultato.setText(sequenza);
	}
	
	public static void main(String[] args) {
		launch(args);
	}

}
