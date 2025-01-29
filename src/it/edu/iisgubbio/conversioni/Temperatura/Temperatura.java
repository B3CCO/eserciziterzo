package it.edu.iisgubbio.conversioni.Temperatura;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Temperatura extends Application{
	Label lCelsius= new Label("Gradi Celsius");
	Label lFar= new Label("Gradi Fahrenheit");
	TextField tfCelsius= new TextField();
	TextField tfFar= new TextField();
	Button bCelsius= new Button("Celsius");
	Button bFar=new Button("Fahrenheit");
	
	public void start(Stage finestra) throws Exception {
		GridPane principale = new GridPane();
		
		principale.add(lCelsius, 0, 0);
		principale.add(lFar, 1, 0);
		principale.add(tfCelsius, 0, 1);
		principale.add(tfFar, 1, 1);
		principale.add(bCelsius, 0, 3);
		principale.add(bFar, 1, 3);
		
		Scene scena = new Scene(principale);
		finestra.setTitle("Temperatura");
		finestra.setScene(scena);
		finestra.show();
		
		bCelsius.setOnAction( e -> eseguiCelsius () );
		bFar.setOnAction( e -> eseguiFahrenheit() );
		
			
	}
	private void eseguiCelsius() {
		double vCelsius, vFar;
		String far, celsius;
		
		far=tfFar.getText();
		vFar=Double.parseDouble(far);
		vCelsius=(vFar-32)*5/9;
		celsius=""+vCelsius;
		tfCelsius.setText(celsius);
		
	}
	
	private void eseguiFahrenheit() {
		double vCelsius, vFar;
		String far, celsius;
		
		celsius=tfCelsius.getText();
		vCelsius=Double.parseDouble(celsius);
		vFar=32+vCelsius*9/5;
		far=""+vFar;
		tfFar.setText(far);
	}
	
	public static void main(String[] args) {
		launch(args);
	}
	

}
