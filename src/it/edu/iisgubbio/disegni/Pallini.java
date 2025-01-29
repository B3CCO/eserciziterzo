package it.edu.iisgubbio.disegni;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Pallini extends Application{
	Button bVai= new Button("vai");
	Button bPulisci= new Button("pulisci");
	TextField tfNumero= new TextField();
	Label lNumero= new Label("numero");
	Canvas tela = new Canvas(400, 400);
	GraphicsContext gc = tela.getGraphicsContext2D();
	
	@Override
	public void start(Stage primaryStage) {
		GridPane principale = new GridPane();
		principale.add(tela, 0, 2, 3, 1);
		principale.add(lNumero, 0, 0);
		principale.add(tfNumero, 1, 0);
		principale.add(bVai, 2, 0);
		principale.add(bPulisci, 2, 1);
		
		Scene scene = new Scene(principale);
		primaryStage.setTitle("Pallini");
		primaryStage.setScene(scene);
		primaryStage.show();
		
		bVai.setOnAction( e -> eseguiVai() );
		bPulisci.setOnAction( e -> eseguiPulisci() );
		
	}
	
	private void eseguiVai() {
		int numero;
		numero=Integer.parseInt(tfNumero.getText());
		gc.setFill(Color.BLACK);
		int limite=numero;
		for(int y=0;y<numero; y++ ) {
			for(int x=0; x<limite; x++) {
				gc.fillOval(x*25, y*25, 23, 23);
			}
			limite--;
		}
	}
	private void eseguiPulisci() {
		gc.setFill(Color.WHITE);
		gc.fillRect(0, 0, 400, 400);
	}
	
	public static void main(String[] args) {
		 launch(args);
	 }
}
