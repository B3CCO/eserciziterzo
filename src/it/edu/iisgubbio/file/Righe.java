package it.edu.iisgubbio.file;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Righe extends Application{
	
	Label lEsito=new Label("???");
	Label lRiga=new Label("n");
	Button bLeggi=new Button("Leggi");
	TextField tfRiga=new TextField("Inserisci numero riga");
	
	
	public void start(Stage finestra) throws Exception {
		GridPane principale = new GridPane();
		
		principale.add(lRiga,0,0);
		principale.add(tfRiga,1,0);
		principale.add(bLeggi,0,1);
		principale.add(lEsito,0,2);
		
		Scene scena = new Scene(principale);
		finestra.setTitle("demo");
		finestra.setScene(scena);
		finestra.show();
		
		bLeggi.setOnAction( e -> eseguiLettura() );
	}
	private void eseguiLettura() {
		FileReader flussoCaratteri = null;
		String testo=null;
		int numeroRiga=Integer.parseInt(tfRiga.getText());
		try {
			flussoCaratteri = new FileReader("c:\\Users\\nicolabecchetti\\Desktop\\prova.txt");
			BufferedReader lettoreDiRighe = new BufferedReader(flussoCaratteri);
			for(int r=0;r<numeroRiga;r++) {
				testo = lettoreDiRighe.readLine();
			}
		
			System.out.println(testo);
			lettoreDiRighe.close();
			flussoCaratteri.close();
			lEsito.setText(testo);
			
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
