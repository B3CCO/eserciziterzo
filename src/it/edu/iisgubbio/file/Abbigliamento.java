package it.edu.iisgubbio.file;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Abbigliamento extends Application{
	Button bControlla=new Button("controlla");
	Button bControllaDettagliato=new Button("controlla dettagliato");
	
	ListView<String> lvAbbigliamento = new ListView<>();
	
	public void start(Stage finestra) throws Exception {
		GridPane principale = new GridPane();
		
		principale.add(bControlla, 0,0);
		principale.add(bControllaDettagliato, 0,1);
		principale.add(lvAbbigliamento, 0,2);
		
		Insets spazio=new Insets(10);
		principale.setPadding(spazio);
		principale.setVgap(10);
		bControlla.setMaxWidth(Integer.MAX_VALUE);
		bControllaDettagliato.setMaxWidth(Integer.MAX_VALUE);
		
		Scene scena = new Scene(principale);
		finestra.setTitle("Abbigliamento");
		finestra.setScene(scena);
		finestra.show();
		
		bControlla.setOnAction( e -> eseguiControlla() );
		bControllaDettagliato.setOnAction( e -> eseguiControllaDettagliato() );
	}
	
	private void eseguiControlla() {
		lvAbbigliamento.getItems().clear();
		
		String rigaLetta=null;
		String x[]=null;
		int c=0;
		
		try (
				FileReader flussoCaratteri = new FileReader("c:\\Users\\nicolabecchetti\\Desktop\\Abbigliamento.csv");
				BufferedReader lettoreDiRighe = new BufferedReader(flussoCaratteri);
		){
			lettoreDiRighe.readLine();
			while( (rigaLetta = lettoreDiRighe.readLine())!=null ) {
				c++;
				x=rigaLetta.split(",");
				if(x[0].length()==5 &&
						x[1].length()<=50 && 
						(x[2].equals("S") || 
						x[2].equals("M") || 
						x[2].equals("L")) && 
						(x[3].equals("bianco")||x[3].equals("nero") ||
						x[3].equals("blu")|| x[3].equals("rosso")||
						x[3].equals("giallo")|| x[3].equals("marrone")||
						x[3].equals("viola")||x[3].equals("fucsia")) &&
						Double.parseDouble(x[4])<=200) {
					
					lvAbbigliamento.getItems().add(c+" giusto");
					
				}else {
					lvAbbigliamento.getItems().add(c+" errore");
				}		
			}	
		
		} catch (IOException m) {
			m.printStackTrace();
		}

	}
	
	private void eseguiControllaDettagliato() {
		lvAbbigliamento.getItems().clear();
		
		String rigaLetta=null;
		String x[]=null;
		int c=0;
		
		try (
				FileReader flussoCaratteri = new FileReader("c:\\Users\\nicolabecchetti\\Desktop\\Abbigliamento.csv");
				BufferedReader lettoreDiRighe = new BufferedReader(flussoCaratteri);
				){
			lettoreDiRighe.readLine();
			while( (rigaLetta = lettoreDiRighe.readLine())!=null ) {
				c++;
				x=rigaLetta.split(",");
				
				boolean codice=false;
				boolean lunghezza=false;
				boolean taglia=false;
				boolean colore=false;
				boolean prezzo=false;
				String errore=c+" errore";
				
				if(x[0].length()==5) {
					codice=true;
				}
				if(x[1].length()<=50) {
					lunghezza=true;
				}
				if(x[2].equals("S") || x[2].equals("M") || x[2].equals("L")){
					taglia=true;
				}
				if(x[3].equals("bianco")||x[3].equals("nero") ||x[3].equals("blu")|| x[3].equals("rosso")||x[3].equals("giallo")|| x[3].equals("marrone")||x[3].equals("viola")||x[3].equals("fucsia")) {
					colore=true;
				}
				if(Double.parseDouble(x[4])<=200) {
					prezzo=true;
					
				}
				
				if(!codice) {
					errore+= " (codice)";
				}
				
				if(!lunghezza) {
					errore+= " (lunghezza)";
					
				}
				if(!taglia) {
					errore+=" (taglia)";
				}
				
				if(!colore) {
					errore+=" (colore)";
				}
				
				if(!prezzo) {
					errore+=" (prezzo)";
				}
				
				if(codice && lunghezza && taglia && colore && prezzo) {
					lvAbbigliamento.getItems().add(c+" giusto");
				}else {
					lvAbbigliamento.getItems().add(errore);
				}
			
			}

		}catch (IOException m) {
			m.printStackTrace();
		}

	}
	
	public static void main(String[] args) {
		launch(args);
	}

}
