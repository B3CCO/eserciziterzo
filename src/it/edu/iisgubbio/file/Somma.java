package it.edu.iisgubbio.file;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Somma extends Application{
	
	Label lEsito=new Label("???");
	Button bSomma=new Button("somma");
	
	
	
	public void start(Stage finestra) throws Exception {
		GridPane principale = new GridPane();
		
		principale.add(bSomma,0,0);
		principale.add(lEsito,0,1);
		
		Scene scena = new Scene(principale);
		finestra.setTitle("demo");
		finestra.setScene(scena);
		finestra.show();
		
		bSomma.setOnAction( e -> eseguiSomma() );
	}
	private void eseguiSomma() {
		String rigaLetta=null;
		int somma=0;
		
		try {
			FileReader flussoCaratteri = new FileReader("c:\\Users\\nicolabecchetti\\Desktop\\prova.txt");
			BufferedReader lettoreDiRighe = new BufferedReader(flussoCaratteri);
			
			do {
				rigaLetta=lettoreDiRighe.readLine();
				if(rigaLetta!=null) {
					somma+=Integer.parseInt(rigaLetta);
					
				}
			}while(rigaLetta!=null);
			
			lEsito.setText(""+somma);
			lettoreDiRighe.close();
			flussoCaratteri.close();
			
		} catch (FileNotFoundException e) {
			lEsito.setText(e.getLocalizedMessage());
			
		} catch (IOException m) {
		
			m.printStackTrace();
		}
		
	}
	public static void main(String[] args) {
	    launch(args);
	}


}
