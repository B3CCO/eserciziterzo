package it.edu.iisgubbio.vettori;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class EliminaDuplicati extends Application{
	TextField tfNumeri= new TextField();
	Label lNumeri=new Label("numeri:");
	Button bEliminaDuplicati=new Button("elimina duplicati");
	Button bContaDuplicati=new Button("conta duplicati");
	Label lRisposta=new Label("risposta:");
	Label lRisultatoElimina=new Label("??");
	Label lRisultatoConta=new Label();
	
	public void start(Stage finestra) throws Exception {
		GridPane principale = new GridPane();
		principale.add(tfNumeri, 1, 0,5,1);
		principale.add(lNumeri, 0, 0);
		principale.add(bEliminaDuplicati, 1,1,5,1);
		principale.add(bContaDuplicati, 1, 2,5,1);
		principale.add(lRisposta, 0, 3);
		principale.add(lRisultatoElimina, 1, 3,5,1);
		principale.add(lRisultatoConta, 1, 4,5,1);
		bEliminaDuplicati.setMaxWidth(Integer.MAX_VALUE);
		bContaDuplicati.setMaxWidth(Integer.MAX_VALUE);
		principale.setVgap(10);
		principale.setHgap(10);
		Insets spazio=new Insets(10);
		principale.setPadding(spazio);
		
		Scene scena = new Scene(principale);
		finestra.setTitle("Elimina duplicati");
		finestra.setScene(scena);
		finestra.show();
		
		bEliminaDuplicati.setOnAction( e -> eseguiEliminaDuplicati () );
		bContaDuplicati.setOnAction( e -> eseguiContaDuplicati () );
	}
	int[] testoNumeri (String testo) {
		String parti[];
		int vettoreNumero[];
		parti=testo.split(" ");
		vettoreNumero= new int[parti.length];
		for(int pos=0;pos<parti.length;pos++) {
			vettoreNumero[pos]=Integer.parseInt(parti[pos]);
		}
		return vettoreNumero;
	}
	private void eseguiEliminaDuplicati() {
		String se="";
		int numeri[], nuovo[] ,c=0, q=1;
		boolean presente;
		numeri=testoNumeri(tfNumeri.getText());
		int senzaDuplicati[]= new int[numeri.length];
		senzaDuplicati[0]=numeri[0];
		for(int pos=0 ; pos<numeri.length ; pos++) {
			c=numeri[pos];
			presente=false;
			for(int x=0; x<q;x++) {
				if(c==senzaDuplicati[x]){
					presente=true;
				}
			}
			if(presente==false) {
				senzaDuplicati[q]=c;
				q+=1;
			}
		}
		// creo vettore della dimensione giusta
		nuovo = new int[q];
		for(int pos=0; pos<q; pos++) {
			nuovo[pos]=senzaDuplicati[pos];
		}
		for(int pos=0;pos<nuovo.length;pos++) {
			se+=" "+(nuovo[pos]);
		}
		lRisultatoElimina.setText(se);
	}
	private void eseguiContaDuplicati() {
		int numeri[], c=0;
		numeri=testoNumeri(tfNumeri.getText());
		for(int pos=0 ; pos<numeri.length-1 ; pos++) {
			for(int a=pos+1;a<numeri.length;a++) {
				if(numeri[a]==numeri[pos]) {
					c++;
				}
			}
		}
		lRisultatoConta.setText("ci sono "+c+" duplicati");
	}
	public static void main(String[] args) {
		launch(args);
	}
}
