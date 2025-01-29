package it.edu.iisgubbio.negozi.AgenziaViaggi;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class AgenziaViaggi extends Application{
	TextField tfNP= new TextField();
	TextField tfCA= new TextField();
	TextField tfCosto= new TextField();
	Label lAN= new Label("autubus necessari:");
	Label lCostoP= new Label("costo a persona:");
	Label lNP= new Label("numero persone");
	Label lCA= new Label("capienza autobus");
	Label lCosto= new Label("costo autubus ");
	
	public void start(Stage finestra) throws Exception {
		GridPane principale = new GridPane();
		
		principale.add(lNP, 0, 0);
		principale.add(lCA, 0, 1);
		principale.add(lCosto, 0, 2);
		principale.add(lAN, 0, 3,2,1);
		principale.add(lCostoP, 0, 4, 2,1);
		principale.add(tfNP, 1, 0);
		principale.add(tfCA, 1, 1);
		principale.add(tfCosto, 1, 2);
		
		Scene scena = new Scene(principale);
		scena.getStylesheets().add("it/edu/iisgubbio/negozi/AgenziaViaggi/AgenziaViaggi.css");
		principale.getStyleClass().add("principale");
		lAN.getStyleClass().add("lAN");
		lCostoP.getStyleClass().add("lCostoP");
		finestra.setTitle("Agenzia VIaggi");
		finestra.setScene(scena);
		finestra.show();
		
		tfCosto.setOnAction( e -> eseguiCosto () );
	}
	
	private void eseguiCosto() {
		double costoA,costoPers;
		int nPers,nA,capA;
		
		nPers=Integer.parseInt(tfNP.getText());
		capA=Integer.parseInt(tfCA.getText());
		costoA=Double.parseDouble(tfCosto.getText());
		
		if(nPers%capA!=0) {
			nA=(nPers/capA) +1;
		}else {
			nA=(nPers/capA);
		}
		costoPers=(nA*costoA)/nPers;
		lCostoP.setText("costo persona:"+(""+costoPers));
		lAN.setText("autobus necessari:"+(""+nA));
		
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}

