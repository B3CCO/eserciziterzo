package it.edu.iisgubbio.file;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class ComuniArrayList extends Application{
	Label lEsitoCodice=new Label();
	Label lNomeComune=new Label("Nome comune");
	Label lNomeProvincia=new Label("Nome provincia");
	Button bCodice=new Button("Cerca codice");
	Button bProvincia=new Button("Cerca provincia");
	TextField tfNomeComune=new TextField();
	TextField tfNomeProvincia=new TextField();
	
	ListView<String> lvComuni = new ListView<>();
	ArrayList <Comune> comuni= new ArrayList<Comune>();
	
	public void start(Stage finestra) throws Exception {
		GridPane principale = new GridPane();
		String rigaLetta=null;
		
		try (
				FileReader flussoCaratteri = new FileReader("c:\\Users\\nicolabecchetti\\Desktop\\comuni.txt");
				BufferedReader lettoreDiRighe = new BufferedReader(flussoCaratteri);
		){
			while( (rigaLetta = lettoreDiRighe.readLine())!=null ) {
				comuni.add(new Comune(rigaLetta));
			}
			
		}catch (FileNotFoundException e) {
			lEsitoCodice.setText(e.getLocalizedMessage());

		} catch (IOException m) {

			m.printStackTrace();
		}
		
		principale.add(lNomeComune,0,0);
		principale.add(tfNomeComune,1,0);
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
		boolean trovato=false;
		String codice="";
		
		for(int i=0;i<comuni.size();i++) {
			if(comuni.get(i).nome.equals(tfNomeComune.getText())) {
				trovato=true;
				codice=comuni.get(i).codice;
			}
		}
		if(trovato) {
			lEsitoCodice.setText(codice);
		}else {
			lEsitoCodice.setText(tfNomeComune.getText()+" NON trovato");
		}
		
	}
	
	private void eseguiProvincia() {
		lvComuni.getItems().clear();
		
		for(int i=0;i<comuni.size();i++) {
			if(comuni.get(i).provincia.trim().equals(tfNomeProvincia.getText())) {
				lvComuni.getItems().add(comuni.get(i).nome);
			}
			
		}
			
	}
	
	public static void main(String[] args) {
		launch(args);
	}

}
