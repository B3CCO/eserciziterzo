package it.edu.iisgubbio.matematica.EquazioniSecondoGrado;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class EquazioniSecondoGrado extends Application{
	Label lA= new Label("a=");
	Label lB= new Label("b=");
	Label lC= new Label("c=");
	Label lX1= new Label("X1=");
	Label lX2= new Label("X2=");
	Label lRX1= new Label("??");
	Label lRX2= new Label("??");
	TextField tfA= new TextField();
	TextField tfB= new TextField();
	TextField tfC= new TextField();
	Button bRisolvi= new Button("risolvi");
	
	public void start(Stage finestra) throws Exception {
		GridPane principale = new GridPane();
		
		principale.add(lA, 0, 0);
		principale.add(tfA, 1, 0);
		principale.add(lB, 0, 1);
		principale.add(tfB, 1, 1);
		principale.add(lC, 0, 2);
		principale.add(tfC, 1, 2);
		principale.add(lX1, 0, 3);
		principale.add(lX2, 2, 3);
		principale.add(lRX1, 1, 3);
		principale.add(lRX2, 3, 3);
		principale.add(bRisolvi, 2, 0, 1, 3);
		principale.setHgap(10);
		principale.setVgap(10);
		Insets spazio=new Insets(10);
		principale.setPadding(spazio);
		bRisolvi.setMaxHeight(Integer.MAX_VALUE);		
		
		Scene scena = new Scene(principale);
		scena.getStylesheets().add("it/edu/iisgubbio/matematica/EquazioniSecondoGrado/EquazioniSecondoGrado.css");
		principale.getStyleClass().add("principale");
		lX1.getStyleClass().add("risultato");
		lX2.getStyleClass().add("risultato");
		lRX1.getStyleClass().add("risultato");
		lRX2.getStyleClass().add("risultato");
		finestra.setTitle("Equazioni Secondo Grado");
		finestra.setScene(scena);
		finestra.show();
		
		bRisolvi.setOnAction( e -> eseguiRisolvi () );
	}
	
	private void eseguiRisolvi() {
		double  a, b, c, d, x1, x2;
		String sX1,sX2;
		
		a=Double.parseDouble(tfA.getText());
		b=Double.parseDouble(tfB.getText());
		c=Double.parseDouble(tfC.getText());
		d=b*b-4*a*c;
		if(d>=0) {
			x1=((-b)+Math.sqrt(d))/(2*a);
			x2=((-b)-Math.sqrt(d))/(2*a);
			sX1=""+x1;	
			sX2=""+x2;
			lRX1.setText(sX1);
			lRX2.setText(sX2);
			
		}else {
			lRX1.setText("impossibile");
			lRX2.setText("impossibile");
		}
		
		
	}
	
	public static void main(String[] args) {
		launch(args);
	}

}
