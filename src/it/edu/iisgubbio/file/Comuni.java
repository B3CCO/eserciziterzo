package it.edu.iisgubbio.file;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Comuni extends Application{
	Label lEsitoCodice=new Label();
	Label lNomeComune=new Label("Nome comune");
	Label lNomeProvincia=new Label("Nome provincia");
	Button bCodice=new Button("Cerca codice");
	Button bProvincia=new Button("Cerca provincia");
	TextField tfNomecomune=new TextField();
	TextField tfNomeProvincia=new TextField();
	
	ListView<String> lvComuni = new ListView<>();
	
	public void start(Stage finestra) throws Exception {
		GridPane principale = new GridPane();
		
		principale.add(lNomeComune,0,0);
		principale.add(tfNomecomune,1,0);
		principale.add(lNomeProvincia,0,1);
		principale.add(tfNomeProvincia,1,1);
		principale.add(bCodice,0,2);
		principale.add(lEsitoCodice,1,2);
		principale.add(bProvincia,0,3);
		principale.add(lvComuni, 2,0,2,5);
		

		Scene scena = new Scene(principale);
		finestra.setTitle("Comuni");
		finestra.setScene(scena);
		finestra.show();
		
		bCodice.setOnAction( e -> eseguiCodice() );
		bProvincia.setOnAction( e -> eseguiProvincia() );
	}
	
	private void eseguiCodice() {
		String rigaLetta=null;
		boolean trovato=false;
		String codice="";
		
		try (
				FileReader flussoCaratteri = new FileReader("c:\\Users\\nicolabecchetti\\Desktop\\comuni.txt");
				BufferedReader lettoreDiRighe = new BufferedReader(flussoCaratteri);
		){
			while( (rigaLetta = lettoreDiRighe.readLine())!=null ) {
				if(rigaLetta.substring(4,54).trim().equals(tfNomecomune.getText())) {
					trovato=true;
					codice=rigaLetta.substring(0,4);
				}
			}
			if(trovato==true) {
				lEsitoCodice.setText(codice);
			}else {
				lEsitoCodice.setText(tfNomecomune.getText()+" NON è presente");
			}
			
		}catch (FileNotFoundException e) {
			lEsitoCodice.setText(e.getLocalizedMessage());

		} catch (IOException m) {

			m.printStackTrace();
		}
	}
	
	private void eseguiProvincia() {
		String rigaLetta=null;
		lvComuni.getItems().clear();
		
		try (
				FileReader flussoCaratteri = new FileReader("c:\\Users\\nicolabecchetti\\Desktop\\comuni.txt");
				BufferedReader lettoreDiRighe = new BufferedReader(flussoCaratteri);
		){
			while( (rigaLetta = lettoreDiRighe.readLine())!=null ) {
				if(rigaLetta.substring(54,56).trim().equals(tfNomeProvincia.getText())) {
					lvComuni.getItems().add(rigaLetta.substring(4,54).trim());
					
				}
			}
			
		}catch (FileNotFoundException e) {
			lEsitoCodice.setText(e.getLocalizedMessage());

		} catch (IOException m) {

			m.printStackTrace();
		}
		
	}
	
	public static void main(String[] args) {
		launch(args);
	}

}
