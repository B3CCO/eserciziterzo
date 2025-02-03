package it.edu.iisgubbio.testi;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Cesare extends Application{
	
	TextField tfParola1= new TextField();
	Button bCifra=new Button("cifra ⬇");
	Button bDecifra=new Button("decifra ⬆");
	TextField tfParola2= new TextField();
	
	public void start(Stage finestra) throws Exception {
		GridPane principale = new GridPane();
		
		principale.add(tfParola1,0,0,2,1);
		principale.add(bCifra,0,1);
		principale.add(bDecifra,1,1);
		principale.add(tfParola2,0,2,2,1);
		bCifra.setMaxWidth(Integer.MAX_VALUE);
		bDecifra.setMaxWidth(Integer.MAX_VALUE);
		principale.setVgap(10);
		principale.setHgap(10);
		Insets spazio=new Insets(10);
		principale.setPadding(spazio);
		
		Scene scena = new Scene(principale);
		finestra.setTitle("Cesare");
		finestra.setScene(scena);
		finestra.show();
		
		bCifra.setOnAction( e -> eseguiCifra() );
		bDecifra.setOnAction( e -> eseguiDecifra() );
	}
	
	private void eseguiCifra() {
		char lettere[]=tfParola1.getText().toCharArray();
		
		for(int i=0;i<lettere.length;i++) {
			
			switch(lettere[i]) {
			case 'z':
				lettere[i]='c';
				break;
			case 'y':
				lettere[i]='b';
				break;
			case 'x':
				lettere[i]='a';
				break;
			default:
					lettere[i]=(char)(lettere[i]+3);
			}
		}
		
		String parole=new String(lettere);
		tfParola2.setText(parole);
	}
	private void eseguiDecifra() {
		char frase[]=tfParola2.getText().toCharArray();

		for(int i=0;i<frase.length;i++) {
			switch(frase[i]) {
			case 'c':
				frase[i]='z';
				break;
			case 'b':
				frase[i]='y';
				break;
			case 'a':
				frase[i]='x';
				break;
			default:
					frase[i]=(char)(frase[i]-3);
			}
			
		}
		String parole=new String(frase);
		tfParola1.setText(parole);
		
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
