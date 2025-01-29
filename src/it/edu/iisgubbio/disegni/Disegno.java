package it.edu.iisgubbio.disegni;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Disegno extends Application{
	
	Button bottoneNero= new Button("nero");
	Canvas tela = new Canvas(400, 300);
	GraphicsContext gc = tela.getGraphicsContext2D();
	
	@Override
	 public void start(Stage primaryStage) {
 
		 gc.setFill(Color.RED);
		 gc.fillOval(0, 0, 150, 150);
		 gc.setFill(Color.BLUE);
		 gc.fillOval(300, 200, 100, 100);
		 gc.setStroke(Color.GREEN);
		 gc.setLineWidth(30);
		 gc.strokeLine(0, 300, 400, 0);
		 gc.setStroke(Color.ORANGE);
		 gc.setLineWidth(15);
		 gc.strokeOval(250, 0, 150, 50);
		  
		 
		 
		 GridPane principale = new GridPane();
		 principale.add(tela, 0, 0);
		 principale.add(bottoneNero, 0, 1);
		 
		 Scene scene = new Scene(principale);
		    primaryStage.setTitle("Disegno");
		    primaryStage.setScene(scene);
		    primaryStage.show();
		    
		    bottoneNero.setOnAction( e -> eseguiNero() );
	}
	
	private void eseguiNero() {
		
		gc.setFill(Color.BLACK);
		gc.fillOval(25, 25, 100, 100);
		
		
	}
	
	 public static void main(String[] args) {
		 launch(args);
	 }
}
