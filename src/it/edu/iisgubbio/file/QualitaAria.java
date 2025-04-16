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

public class QualitaAria extends Application{
	Label lNomeComune=new Label("nome comune ");
	TextField tfNomeComune=new TextField();
	Button bCerca=new Button("Cerca");
	Button bPulita=new Button("Più pulita");
	Label lCerca=new Label("??");
	Label lPulita=new Label("??");
	
	public void start(Stage finestra) throws Exception {
		GridPane principale = new GridPane();
		
		principale.add(lNomeComune, 0,0);
		principale.add(tfNomeComune, 1,0);
		principale.add(bCerca, 0,1);
		principale.add(lCerca, 1,1);
		principale.add(bPulita, 0,2);
		principale.add(lPulita,1,2);

		Scene scena = new Scene(principale);
		finestra.setTitle("Comuni");
		finestra.setScene(scena);
		finestra.show();
		
		bCerca.setOnAction( e -> eseguiCerca() );
		bPulita.setOnAction( e -> eseguiPulita() );
	}
	
	private void eseguiCerca() {
		String rigaLetta=null;
		boolean trovato=false;
		String x[]=null;
		String giorniSopraMedia=null;
		
		try (
				FileReader flussoCaratteri = new FileReader("c:\\Users\\nicolabecchetti\\Desktop\\qualitaDellAria.csv");
				BufferedReader lettoreDiRighe = new BufferedReader(flussoCaratteri);
		){
			while( (rigaLetta = lettoreDiRighe.readLine())!=null ) {
				x=rigaLetta.split(",");
				if(x[0].equals(tfNomeComune.getText())) {
					giorniSopraMedia=x[2];
					trovato=true;
					
				}
			}
			System.out.println(giorniSopraMedia);
			
			if(trovato==true) {
				lCerca.setText(giorniSopraMedia);
			}else {
				lCerca.setText(tfNomeComune.getText()+" NON è presente");
			}
			
		}catch (FileNotFoundException e) {
			lCerca.setText(e.getLocalizedMessage());

		} catch (IOException m) {

			m.printStackTrace();
		}
	}
	
	private void eseguiPulita() {
		String rigaLetta=null;
		String x[]=null;
		String comune=null;
		int minore=Integer.MAX_VALUE;
		
		try (
				FileReader flussoCaratteri = new FileReader("c:\\Users\\nicolabecchetti\\Desktop\\qualitaDellAria.csv");
				BufferedReader lettoreDiRighe = new BufferedReader(flussoCaratteri);
		){
			lettoreDiRighe.readLine();
			while( (rigaLetta = lettoreDiRighe.readLine())!=null ) {
				x=rigaLetta.split(",");
				if(!(x[3].equals("-"))) {
					if(Integer.parseInt(x[3])<minore) {
						minore=Integer.parseInt(x[3]);
						comune=x[0];
					}
				}
			}
			
			lPulita.setText(comune);
			
		}catch (FileNotFoundException e) {
			lCerca.setText(e.getLocalizedMessage());

		} catch (IOException m) {

			m.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}

}
