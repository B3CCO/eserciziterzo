package it.edu.iisgubbio.testi;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Impiccato extends Application{
	TextField tfParola= new TextField();
	Button bVia=new Button("via");
	Label lLettera= new Label("lettera");
	TextField tfLettera= new TextField();
	Button bProva=new Button("prova");
	Label lVittoria= new Label();
	Label lErrori= new Label();
	char finale[];
	char parola[];
	
	public void start(Stage finestra) throws Exception {
		GridPane principale = new GridPane();
		
		principale.add(tfParola,0,0);
		principale.add(bVia,1,0);
		principale.add(lLettera,0,1);
		principale.add(tfLettera,1,1);
		principale.add(bProva,2,1);
		principale.add(lVittoria,1,2);
		principale.add(lErrori,1,3);
		bVia.setMaxWidth(Integer.MAX_VALUE);
		principale.setVgap(10);
		principale.setHgap(10);
		Insets spazio=new Insets(10);
		principale.setPadding(spazio);
		

		Scene scena = new Scene(principale);
		finestra.setTitle("Indovina la parola");
		finestra.setScene(scena);
		finestra.show();
		
		bVia.setOnAction( e -> eseguiVia() );
		bProva.setOnAction( e -> eseguiProva() );
	}
	private void eseguiVia() {
		parola=tfParola.getText().toCharArray();
		finale=tfParola.getText().toCharArray();
		for(int i=1;i<parola.length-1;i++){
			parola[i]='-';	
		}
		
		String testo=new String(parola);
		tfParola.setText(""+testo);
		
	}
	private void eseguiProva() {
		boolean presente=false;
		char lettera=tfLettera.getText().charAt(0);
		for(int i=0;i<parola.length;i++) {
			if(lettera==finale[i]) {
				parola[i]=lettera;
			}
			
			for(int a=0;a<parola.length;a++) {
				if(parola[a]=='-') {
					presente=true;
				}
				if(presente==true) {
					lVittoria.setText("non è presente");
				}else {
					lVittoria.setText("è presente");
				}
			}
		}
		String testo=new String(parola);
		tfParola.setText(""+testo);
	}
	public static void main(String[] args) {
		launch(args);
	}
}
