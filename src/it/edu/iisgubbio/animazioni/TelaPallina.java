package it.edu.iisgubbio.animazioni;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Duration;

public class TelaPallina extends Application{
	
	int x=0;
	Canvas tela = new Canvas(400, 400);
	GraphicsContext gc = tela.getGraphicsContext2D();
	
	@Override
	public void start(Stage primaryStage) {
		GridPane principale = new GridPane();
		principale.add(tela, 0, 2, 3, 1);
		
		Scene scene = new Scene(principale);
		primaryStage.setTitle("TelaPallina");
		primaryStage.setScene(scene);
		primaryStage.show();
		Timeline timeline = new Timeline(new KeyFrame(
				Duration.seconds(0.05),
				x -> aggiornaTimer()));
		timeline.setCycleCount(100);
		timeline.play();
	}
	
	 private void aggiornaTimer(){
		 gc.setFill(Color.WHITE);
		 gc.fillOval(x-1, 0-1, 25, 25);
		 x=x+5;
		 gc.setFill(Color.RED);
		 gc.fillOval(x, 0, 23, 23);
		 
	 }
	
	public static void main(String[] args) {
		 launch(args);
	 }

}
