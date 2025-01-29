package it.edu.iisgubbio.vettori;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Media extends Application{
	TextField tfNumeri= new TextField();
	Button bMedia=new Button("Media");
	Label lRisultato=new Label("??");
	
	public void start(Stage finestra) throws Exception {
		GridPane principale = new GridPane();
		principale.add(tfNumeri, 0, 0);
		principale.add(bMedia, 0, 1,5,1);
		principale.add(lRisultato, 0, 2);
		principale.setVgap(10);
		Insets spazio=new Insets(10);
		principale.setPadding(spazio);
		bMedia.setMaxWidth(Integer.MAX_VALUE);	
		lRisultato.setMaxWidth(Integer.MAX_VALUE);
		lRisultato.setAlignment(Pos.CENTER);
		
		Scene scena = new Scene(principale);
		finestra.setTitle("Media Vettori");
		finestra.setScene(scena);
		finestra.show();
		
		bMedia.setOnAction( e -> eseguiMedia () );
	}
	private void eseguiMedia() {
		String testo, parti[], sMedia;
		double media,somma=0;
		testo=tfNumeri.getText();
		parti=testo.split(" ");
		int numeri[]=new int[parti.length];
		for(int i=0; i<parti.length;i++) {
			numeri[i]=Integer.parseInt(parti[i]);
			somma=somma+numeri[i];	
		}
		media=somma/numeri.length;
		sMedia=""+media;
		lRisultato.setText(sMedia);
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
