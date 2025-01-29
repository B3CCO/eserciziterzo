package it.edu.iisgubbio.animazioni;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.util.Duration;

public class PannelloPallina extends Application{
	int cerchioX=20;
	double r=20;
	Circle cerchio = new Circle(r);
	@Override
	public void start(Stage primaryStage) {
		Pane areaDiGioco = new Pane();
		areaDiGioco.setPrefSize(400, 400);
		
		cerchio.setFill( Color.RED);
        cerchio.setCenterX(cerchioX);
        cerchio.setCenterY(20);
        areaDiGioco.getChildren().add(cerchio);
        
        Scene scena = new Scene(areaDiGioco);
        primaryStage.setScene(scena);
        primaryStage.setTitle("Pannello Pallina");
        primaryStage.show();
        Timeline timeline = new Timeline(new KeyFrame(
				Duration.seconds(0.05),
				x -> aggiornaTimer()));
		timeline.setCycleCount(1000);
		timeline.play();
	}
	private void aggiornaTimer(){
		cerchioX+=5;
		cerchio.setCenterX(cerchioX);
		r-=0.3;
		cerchio.setRadius(r);
	}
	
	
	public static void main(String[] args) {
		 launch(args);
	 }

}
