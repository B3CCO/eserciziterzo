package it.edu.iisgubbio.numeri;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Fibonacci extends Application{
	Label lNumeri= new Label("n:");
	TextField tfNumeri= new TextField();
	Button bCalcola=new Button("calcola");
	Label lFibonacci= new Label("fib");
	Label lRisultato= new Label("??");
	public void start(Stage finestra) throws Exception {
		GridPane principale = new GridPane();
		
		principale.add(lNumeri,0,0);
		principale.add(tfNumeri,1,0);
		principale.add(bCalcola,1,1);
		principale.add(lFibonacci,0,2);
		principale.add(lRisultato,1,2);
		bCalcola.setMaxWidth(Integer.MAX_VALUE);	
		principale.setVgap(10);
		principale.setHgap(10);
		Insets spazio=new Insets(10);
		principale.setPadding(spazio);
		
		Scene scena = new Scene(principale);
		finestra.setTitle("Fibonacci");
		finestra.setScene(scena);
		finestra.show();
		
		bCalcola.setOnAction( e -> eseguiCalcola() );
		
	}
	int fib(int n) {
		if(n==0) {
			return 0;
		}else if(n==1) {
			return 1;
		}else {
			return fib(n-2)+fib(n-1);
		}
	}
	private void eseguiCalcola() {
		int numero;
		numero=Integer.parseInt(tfNumeri.getText());
		int f=fib(numero);
		lRisultato.setText(""+f);
	}
	
	
	public static void main(String[] args) {
		launch(args);
	}
}
