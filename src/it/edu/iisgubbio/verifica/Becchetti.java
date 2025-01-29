package it.edu.iisgubbio.verifica;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Becchetti extends Application{
	TextField tfNumeri= new TextField();
	Button bInverti=new Button("Inverti");
	Button bVisualizza=new Button("visualizza");
	TextField tfElimina= new TextField();
	Button bElimina=new Button("elimina numero");
	Label lRisultato= new Label("??");
	
	
	public void start(Stage finestra) throws Exception {
		GridPane principale = new GridPane();
		principale.add(tfNumeri, 0, 0,5,1);
		principale.add(bInverti, 0, 2,5,1);
		principale.add(tfElimina, 0, 1,5,1);
		principale.add(bElimina, 0, 3,5,1);
		principale.add(bVisualizza, 0, 4,5,1);
		principale.add(lRisultato, 0, 5);
		principale.setVgap(10);
		principale.setHgap(10);
		Insets spazio=new Insets(10);
		principale.setPadding(spazio);
		bInverti.setMaxWidth(Integer.MAX_VALUE);
		bElimina.setMaxWidth(Integer.MAX_VALUE);	
		bVisualizza.setMaxWidth(Integer.MAX_VALUE);	
		
		Scene scena = new Scene(principale);
		finestra.setTitle("Becchetti");
		finestra.setScene(scena);
		finestra.show();
		
		bInverti.setOnAction( e -> eseguiInverti() );
		bElimina.setOnAction( e -> eseguiElimina() );
		bVisualizza.setOnAction( e -> eseguiVisualizza() );
	}
	int[] testoNumeri (String testo) {
		String parti[];
		int vettoreNumeri[];
		parti=testo.split(" ");
		vettoreNumeri= new int[parti.length];
		for(int pos=0;pos<parti.length;pos++) {
			vettoreNumeri[pos]=Integer.parseInt(parti[pos]);
		}
		return vettoreNumeri;
	}
	private void eseguiInverti() {
		int numeri[];
		numeri=testoNumeri(tfNumeri.getText());
		int nuovo[]= new int[numeri.length];
		int nPiccolo=numeri[0];
		nuovo[0]=numeri[0];
		for(int pos=0 ; pos<numeri.length ; pos++) {
			if(numeri[pos]<nPiccolo) {
				nPiccolo=numeri[pos];
			}
			nuovo[pos]=nPiccolo;
		}
	
		int nMaggiore=numeri[0];
		for(int pos=0 ; pos<numeri.length ; pos++) {
			if(numeri[pos]>nMaggiore) {
				nMaggiore=numeri[pos];
			}
			nuovo[numeri[pos]]=nMaggiore;
		}
		lRisultato.setText(""+nuovo.length);
		
	}
	private void eseguiElimina() {
		String se="";
		int numeri[],posizione, c=0, q=1;
		boolean presente;
		posizione=Integer.parseInt(tfElimina.getText());
		numeri=testoNumeri(tfNumeri.getText());
		int vettore[]= new int[numeri.length];
		vettore[0]=numeri[0];
		for(int pos=0 ; pos<numeri.length ; pos++) {
			c=numeri[pos];
			presente=false;
			for(int x=0; x<q;x++) {
				if(c==vettore[x]){
					presente=true;
				}
			}
			if(presente==false) {
				vettore[q]=c;
				q+=1;
			}
		}
		lRisultato.setText();
	}
	private void eseguiVisualizza() {
		String testo, parti[];
		int numero=Integer.parseInt(tfNumeri.getText());
		testo=tfNumeri.getText();
		parti=testo.split(" ");
		int numeri[]=new int[parti.length];
		for(int pos=0; pos<parti.length;pos++) {
			numeri[pos]=Integer.parseInt(parti[pos]);	
		}
		lRisultato.setText(" ,");
	}
	public static void main(String[] args) {
		launch(args);
	}
}
