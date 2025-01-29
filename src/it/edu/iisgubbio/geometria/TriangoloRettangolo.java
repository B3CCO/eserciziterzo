package it.edu.iisgubbio.geometria;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class TriangoloRettangolo extends Application{
	Label eCateto1=new Label("cateto 1");
	Label eCateto2=new Label("cateto 2");
	Label eIpotenusa=new Label("ipotenusa");
	TextField tfCateto1= new TextField();
	TextField tfCateto2= new TextField();
	TextField tfIpotenusa=new TextField();
	Button pCalcolaCateto1= new Button("calcola cateto 1");
	Button pCalcolaCateto2=new Button("calcola cateto 2");
	Button pCalcolaIpotenusa= new Button("calcola ipotenusa");
	
	public void start(Stage finestra) throws Exception {
		GridPane principale = new GridPane();
		principale.add(eCateto1,0,0);
		principale.add(eCateto2, 0, 1);
		principale.add(eIpotenusa, 0, 2);
		principale.add(tfCateto1, 1, 0);
		principale.add(tfCateto2, 1, 1);
		principale.add(tfIpotenusa, 1, 2);
		principale.add(pCalcolaCateto1,2,0);
		principale.add(pCalcolaCateto2, 2, 1);
		principale.add(pCalcolaIpotenusa, 2, 2);
		
		
		Scene scena = new Scene(principale);
		finestra.setTitle("trinagolo rettangolo");
		finestra.setScene(scena);
		finestra.show();
		
		pCalcolaCateto1.setOnAction ( e -> eseguiCateto1() );
		pCalcolaCateto2.setOnAction ( e -> eseguiCateto2() );
		pCalcolaIpotenusa.setOnAction ( e -> eseguiIpotenusa() );
		
	}
	
	private void eseguiCateto1() {
		double vCateto2, vIpotenusa, vCateto1;
		String Cateto2, ipotenusa, Cateto1;
		
		Cateto2=tfCateto2.getText();
		ipotenusa=tfIpotenusa.getText();
		vIpotenusa=Double.parseDouble(ipotenusa);
		vCateto2=Double.parseDouble(Cateto2);
		vCateto1=Math.sqrt(vIpotenusa*vIpotenusa-vCateto2*vCateto2);
		Cateto1=""+vCateto1;
		tfCateto1.setText(Cateto1);
		
	}
	
	private void eseguiCateto2() {
		double vCateto2, vIpotenusa, vCateto1;
		String Cateto2, ipotenusa, Cateto1;
		
		Cateto1=tfCateto1.getText();
		ipotenusa=tfIpotenusa.getText();
		vIpotenusa=Double.parseDouble(ipotenusa);
		vCateto1=Double.parseDouble(Cateto1);
		vCateto2=Math.sqrt(vIpotenusa*vIpotenusa-vCateto1*vCateto1);
		Cateto2=""+vCateto2;
		tfCateto2.setText(Cateto2);
	
	}
	
	private void eseguiIpotenusa() {
		double vCateto2, vIpotenusa, vCateto1;
		String Cateto2, ipotenusa, Cateto1;
		
		Cateto1=tfCateto1.getText();
		Cateto2=tfCateto2.getText();
		vCateto2=Double.parseDouble(Cateto2);
		vCateto1=Double.parseDouble(Cateto1);
		vIpotenusa=Math.sqrt(vCateto1*vCateto1+vCateto2*vCateto2);
		ipotenusa=""+vIpotenusa;
		tfIpotenusa.setText(ipotenusa);
	}
	
	public static void main(String[] args) {
		launch(args);
	}
	
}
