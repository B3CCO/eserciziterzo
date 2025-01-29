package it.edu.iisgubbio.tempo.Bisestile;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Bisestile extends Application{
	Label lAnno= new Label("anno");
	Label lBis=new Label("??");
	TextField tfAnno= new TextField();
	Button bControlla= new Button("controlla");
	
	public void start(Stage finestra) throws Exception {
		GridPane principale = new GridPane();
		
		principale.add(lAnno, 0, 0);
		principale.add(tfAnno, 1, 0);
		principale.add(bControlla,0, 1, 2, 1);
		principale.add(lBis, 0 ,2, 2, 1);
		principale.setHgap(10);
		principale.setVgap(10);
		Insets spazio=new Insets(10);
		principale.setPadding(spazio);
		bControlla.setMaxWidth(Integer.MAX_VALUE);
		lBis.setMaxWidth(Integer.MAX_VALUE);
		
		Scene scena = new Scene(principale);
		finestra.setTitle("Bisestile");
		finestra.setScene(scena);
		finestra.show();
		
		bControlla.setOnAction( e -> eseguiControlla () );
	}
	
	private void eseguiControlla() {
		int anno;
		String sAnno;
		
		sAnno=tfAnno.getText();
		anno=Integer.parseInt(sAnno);
		if(anno%4!=0) {
			lBis.setText("non è un anno bisestile");
		}else
			if(anno%100==0 && anno%400==0 || anno%4==0 && anno%100!=0) {
				lBis.setText("è un anno bisestile");
				
			}else {
				lBis.setText("non è un anno bisestile");
			}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
	

}
