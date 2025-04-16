package it.edu.iisgubbio.file;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Copia extends Application{
	Label lEsito=new Label("???");
	Label lNome=new Label("da:");
	Label lNomeFileNuovo=new Label("a:");
	Button bLeggi=new Button("Leggi");
	TextField tfNome=new TextField("Inserisci nome file");
	TextField tfNomeFileNuovo=new TextField("Inserisci nome file");
	
	
	
	public void start(Stage finestra) throws Exception {
		GridPane principale = new GridPane();
		
		principale.add(lNome,0,0);
		principale.add(lNomeFileNuovo,0,1);
		principale.add(tfNome,1,0);
		principale.add(tfNomeFileNuovo,1,1);
		principale.add(bLeggi,0,2);
		principale.add(lEsito,0,3);
		
		Scene scena = new Scene(principale);
		finestra.setTitle("copia");
		finestra.setScene(scena);
		finestra.show();
		
		bLeggi.setOnAction( e -> eseguiLettura() );
	}
	private void eseguiLettura() {
		FileReader flussoCaratteri = null;
		String nomeFile=tfNome.getText();
		String nomeFile2=tfNomeFileNuovo.getText();
		try {
			flussoCaratteri = new FileReader("c:\\Users\\nicolabecchetti\\Desktop\\"+nomeFile);
			char caratteri[] = new char[1000];
			int caratteriLetti = flussoCaratteri.read(caratteri);
			String testo = new String(caratteri,0,caratteriLetti);
			lEsito.setText(testo);
			flussoCaratteri.close();
			
			FileWriter scriviCaratteri = new FileWriter("c:\\Users\\nicolabecchetti\\Desktop\\"+nomeFile2);
			scriviCaratteri.write(testo);
			scriviCaratteri.close();
			
		} catch (FileNotFoundException e) {
			lEsito.setText(e.getLocalizedMessage());
			//e.printStackTrace();
		} catch (IOException m) {
			// TODO Auto-generated catch block
			m.printStackTrace();
		}
		
	}
	public static void main(String[] args) {
		launch(args);
	}

}
