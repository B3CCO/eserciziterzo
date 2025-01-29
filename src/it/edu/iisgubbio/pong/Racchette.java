package it.edu.iisgubbio.pong;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class Racchette extends Application{
	static final double DIMENSIONE_X=400;
	static final double DIMENSIONE_Y=400;
	Rectangle racchettaSinistra=new Rectangle(20,100);
	Rectangle racchettaDestra=new Rectangle(20,100);
	double ySinistra=40;
	double yDestra=40;


	public void start(Stage primaryStage) {
		Pane areaDiGioco = new Pane();
		areaDiGioco.setPrefSize(DIMENSIONE_X, DIMENSIONE_Y);
		areaDiGioco.getChildren().add(racchettaSinistra);
		areaDiGioco.getChildren().add(racchettaDestra);

		racchettaSinistra.setY(ySinistra);
		racchettaDestra.setY(yDestra);
		racchettaDestra.setX(380);

		Scene scena = new Scene(areaDiGioco);
		primaryStage.setScene(scena);
		primaryStage.setTitle("Racchetta");
		primaryStage.show();

		scena.setOnKeyPressed(e -> TastoPremuto(e));
	}
	private void TastoPremuto(KeyEvent tasto){
		System.out.println(tasto.getText());
		
		if(tasto.getText().equals("s")) {
			ySinistra=ySinistra+10;	
		}
		if(tasto.getText().equals("w")) {
			ySinistra=ySinistra-10;
		}
		racchettaSinistra.setY(ySinistra);
		if(tasto.getCode()==KeyCode.DOWN) {
			yDestra=yDestra+10;	
		}
		if(tasto.getCode()==KeyCode.UP) {
			yDestra=yDestra-10;
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

	public static void main(String[] args) {
		launch(args);
	}
}
