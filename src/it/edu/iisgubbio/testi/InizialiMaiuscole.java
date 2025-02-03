package it.edu.iisgubbio.testi;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class InizialiMaiuscole extends Application{
	TextField tfParola= new TextField();
	Button bMaiuscole=new Button("maiuscole");
	
	public void start(Stage finestra) throws Exception {
		GridPane principale = new GridPane();
		
		principale.add(tfParola,0,0);
		principale.add(bMaiuscole,0,1);
		bMaiuscole.setMaxWidth(Integer.MAX_VALUE);
		principale.setVgap(10);
		principale.setHgap(10);
		Insets spazio=new Insets(10);
		principale.setPadding(spazio);
		
		Scene scena = new Scene(principale);
		finestra.setTitle("Iniziali Maiuscole");
		finestra.setScene(scena);
		finestra.show();
		
		bMaiuscole.setOnAction( e -> eseguiMaiuscole() );
	}
	
	private void eseguiMaiuscole() {
		char frase[]=tfParola.getText().toCharArray();
		
		frase[0]=(char) (frase[0]-32);
		for(int i=0; i<frase.length;i++) {
			if(frase[i]=='.' && frase[i+1]==' ') {
				frase[i+2]=(char) (frase[i+2]-32);
			}
		}
		
		String parole=new String(frase);
		tfParola.setText(parole);
	}
	public static void main(String[] args) {
		launch(args);
	}
}
