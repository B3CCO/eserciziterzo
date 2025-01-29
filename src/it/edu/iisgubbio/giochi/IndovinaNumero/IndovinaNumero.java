package it.edu.iisgubbio.giochi.IndovinaNumero;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class IndovinaNumero extends Application{
	TextField tfN= new TextField();
	Button bProva= new Button("prova");
	Label lRisultato= new Label("??");
	int numero=(int)(Math.random()*100)+1;
	
	public void start(Stage finestra) throws Exception {
		GridPane principale = new GridPane();
		
		principale.add(tfN, 0, 0);
		principale.add(bProva, 0, 1);
		principale.add(lRisultato, 0, 2);
		
		Scene scena = new Scene(principale);
		scena.getStylesheets().add("it/edu/iisgubbio/giochi/IndovinaNumero/IndovinaNumero.css");
		principale.getStyleClass().add("principale");
		finestra.setTitle("Indovina");
		finestra.setScene(scena);
		finestra.show();
		
		
		bProva.setOnAction( e -> eseguiProva () );
		
		//System.out.println(numero);
	}
	
	private void eseguiProva() {
		int n;
		
		n=Integer.parseInt(tfN.getText());
		if(n==numero) {
			lRisultato.setText("hai indovinato");
			
		}else
			if(n<numero) {
				lRisultato.setText("il numero da indovinare è più grande");	
			}else {
				lRisultato.setText("il numero da indovinare è più piccolo");
			}
	}
	
	public static void main(String[] args) {
		launch(args);
	}

}
