package it.edu.iisgubbio.disegni;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Quadrati extends Application{
	Button bDisegna= new Button("disegna");
	Canvas tela = new Canvas(400, 400);
	GraphicsContext gc = tela.getGraphicsContext2D();
	
	@Override
	public void start(Stage primaryStage) {
		GridPane principale = new GridPane();
		principale.add(tela, 0, 0, 3, 1);
		principale.add(bDisegna, 0, 1);
		
		Scene scene = new Scene(principale);
		primaryStage.setTitle("Scacchiera");
		primaryStage.setScene(scene);
		primaryStage.show();

		bDisegna.setOnAction( e -> eseguiDisegna() );
		
	}
	private void eseguiDisegna() {
		double dimensione;
		dimensione=20;
		for(double y=0;y<400; y+=dimensione+1) {
			for(double x=0; x<400; x+=dimensione+1) {
				double z=Math.random();
				//System.out.println(z);
				if(z<0.5) {
					gc.setFill(Color.BLUE);
				}else{
					gc.setFill(Color.YELLOW);
				}
				gc.fillRect(x, y, dimensione, dimensione);
			}
		}
	}
	
	public static void main(String[] args) {
		 launch(args);
	 }

}
