package it.edu.iisgubbio.geometria;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Rettangolo extends Application{
	Button pArea = new Button("area");
	Button pPerimetro=new Button("perimetro");
	Label eBase = new Label("base");
	Label eAltezza = new Label("altezza");
	Label eRisultato = new Label ("??");
	Label eRisultatop=new Label("??");
	TextField cBase = new TextField();
	TextField cAltezza = new TextField();
	
	
	public void start(Stage finestra) throws Exception {
		GridPane principale = new GridPane();
		principale.add(cBase, 1, 0);
		principale.add(cAltezza, 1, 1);
		principale.add(pArea, 1, 2);
		principale.add(pPerimetro, 2, 2);
		principale.add(eRisultato, 1, 3);
		principale.add(eRisultatop, 2, 3);
		principale.add(eBase, 0, 0);
		principale.add(eAltezza, 0, 1);
		
		Scene scena = new Scene(principale);
		finestra.setTitle("rettangolo");
		finestra.setScene(scena);
		finestra.show();
		
		pArea.setOnAction ( e -> eseguiArea() );
		pPerimetro.setOnAction ( e -> eseguiPerimetro() );
		
		
	}
	
	private void eseguiArea() {
		String base,altezza,testo;
		int vBase,vAltezza,Area;
		
		base= cBase.getText();
		altezza= cAltezza.getText();
		vBase= Integer.parseInt(base);
		vAltezza= Integer.parseInt(altezza);
		Area= vBase*vAltezza;
		testo=""+Area;
		eRisultato.setText(testo);
		
	}
	private void eseguiPerimetro() {
		
		String testoBase,testoAltezza,testoPerimetro;
		int base,altezza,perimetro;
		
		testoBase=cBase.getText();
		testoAltezza=cAltezza.getText();
		base=Integer.parseInt(testoBase);
		altezza= Integer.parseInt(testoAltezza);
		perimetro=(base*2)+(altezza*2);
		testoPerimetro=""+perimetro;
		eRisultatop.setText(testoPerimetro);
		
	}
	public static void main(String[] args) {
		launch(args);
	}
}
