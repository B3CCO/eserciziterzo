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

public class AnimaliRari extends Application{
	
	Label lEsito=new Label("???");
	Label lNome=new Label("Nome");
	Button bCerca=new Button("cerca");
	TextField tfNome=new TextField("Inserisci nome animale");
	
	
	public void start(Stage finestra) throws Exception {
		GridPane principale = new GridPane();
		
		principale.add(lNome,0,0);
		principale.add(tfNome,1,0);
		principale.add(bCerca,0,1);
		principale.add(lEsito,0,2);

		Scene scena = new Scene(principale);
		finestra.setTitle("AnimaliRari");
		finestra.setScene(scena);
		finestra.show();

		bCerca.setOnAction( e -> eseguiCerca() );
	}
	private void eseguiCerca() {
		String rigaLetta=null;
		String nomeAnimale=tfNome.getText();
		boolean trovato=false;
		try (
				FileReader flussoCaratteri = new FileReader("c:\\Users\\nicolabecchetti\\Desktop\\animaliRari.txt");
				BufferedReader lettoreDiRighe = new BufferedReader(flussoCaratteri);
		){
			while( (rigaLetta = lettoreDiRighe.readLine())!=null ) {
				if(rigaLetta.equals(nomeAnimale)) {
					trovato=true;
				}
			}
			if(trovato==true) {
				lEsito.setText(nomeAnimale+" è presente");
				
			}else {
				lEsito.setText(nomeAnimale+" NON è presente");
			}
			
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
