package it.edu.iisgubbio.pong;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.geometry.Bounds;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Pong extends Application{
	static final double DIMENSIONE_X=400;
	static final double DIMENSIONE_Y=400;
	Rectangle racchettaSinistra=new Rectangle(20,100);
	Rectangle racchettaDestra=new Rectangle(20,100);
	double ySinistra=40;
	double yDestra=40;
	double r=15;
	Circle cerchio = new Circle(r);
	Text puntiSinistra= new Text();
	int puntiS=0;
	Text puntiDestra= new Text();
	int puntiD=0;


	public void start(Stage primaryStage) {
		Pane areaDiGioco = new Pane();
		areaDiGioco.setPrefSize(DIMENSIONE_X, DIMENSIONE_Y);
		areaDiGioco.getChildren().add(racchettaSinistra);
		areaDiGioco.getChildren().add(racchettaDestra);
		areaDiGioco.getChildren().add(puntiSinistra);
		puntiSinistra.setX(100);
		puntiSinistra.setY(50);
		areaDiGioco.getChildren().add(puntiDestra);
		puntiDestra.setX(300);
		puntiDestra.setY(50);

		racchettaSinistra.setY(ySinistra);
		racchettaDestra.setY(yDestra);
		racchettaDestra.setX(380);
		
		cerchio.setFill( Color.WHITE);
		cerchio.setCenterX(15);
		cerchio.setCenterY(15);
		areaDiGioco.getChildren().add(cerchio);

		Scene scena = new Scene(areaDiGioco);
		scena.getStylesheets().add("it/edu/iisgubbio/Pong/Pong.css");
		puntiDestra.getStyleClass().add("punteggio");
		puntiSinistra.getStyleClass().add("punteggio");
		areaDiGioco.getStyleClass().add("areaDiGioco");
		primaryStage.setScene(scena);
		primaryStage.setTitle("Pong");
		primaryStage.show();
		Timeline timeline = new Timeline(new KeyFrame(
				Duration.seconds(0.01),
				x -> aggiornaTimer()));
		timeline.setCycleCount(-1);
		timeline.play();

		scena.setOnKeyPressed(e -> TastoPremuto(e));
	}
	private void TastoPremuto(KeyEvent tasto){
		System.out.println(tasto.getText());
		
		if(tasto.getText().equals("s")) {
			ySinistra=ySinistra+40;	
		}
		if(tasto.getText().equals("w")) {
			ySinistra=ySinistra-40;
		}
		racchettaSinistra.setY(ySinistra);
		if(tasto.getCode()==KeyCode.DOWN) {
			yDestra=yDestra+40;	
		}
		if(tasto.getCode()==KeyCode.UP) {
			yDestra=yDestra-40;
		}
		racchettaDestra.setY(yDestra);
		if(ySinistra>=300) {
			ySinistra=300;
			racchettaSinistra.setY(300);;
		}
		if(ySinistra<=0) {
			ySinistra=0;
			racchettaSinistra.setY(0);;
		}
		if(yDestra>=300) {
			yDestra=300;
			racchettaDestra.setY(300);;
		}
		if(yDestra<=0) {
			yDestra=0;
			racchettaDestra.setY(0);;
		}
	}
	double orizzontale=4;
	double verticale=3;
	private void aggiornaTimer(){
		cerchio.setCenterY(cerchio.getCenterY()+verticale);
		double z=Math.random()-0.5;
		if (cerchio.getCenterY()>=DIMENSIONE_Y-r) {
			verticale=-3+z;
		}
		if (cerchio.getCenterY()<=r) {
			verticale=3+z;
		}
		cerchio.setCenterX(cerchio.getCenterX()+orizzontale);
		if (cerchio.getCenterX()>=DIMENSIONE_X-r) {
			orizzontale=-4+z;
		}
		if (cerchio.getCenterX()<=r) {
			orizzontale=4+z;
		}
		Bounds b1 = cerchio.getBoundsInParent();
		Bounds b2 = racchettaSinistra.getBoundsInParent();
		Bounds b3 = racchettaDestra.getBoundsInParent();
		if(b1.intersects(b2)) {
			orizzontale=4;
		}
		if(b1.intersects(b3)) {
			orizzontale=-4;
		}
		if(cerchio.getCenterX()>=DIMENSIONE_X-r) {
			puntiS++;
			puntiSinistra.setText(""+puntiS);
			cerchio.setCenterX(200);
			cerchio.setCenterY(200);
			orizzontale=4;
			verticale=3;
		}
		if(cerchio.getCenterX()<=r) {
			puntiD++;
			puntiDestra.setText(""+puntiD);
			cerchio.setCenterX(200);
			cerchio.setCenterY(200);
			orizzontale=-5;
			verticale=4.5;
		}
	}    

	public static void main(String[] args) {
		launch(args);
	}

}
