package it.edu.iisgubbio.vettori;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Inverti extends Application{
	Label lNumeri= new Label("Numeri");
	TextField tfNumeri= new TextField();
	Button bInverti=new Button("Inverti");
	Label lVettoreB= new Label("Vettore B:");
	Label lRisultato= new Label("??");
	public void start(Stage finestra) throws Exception {
		GridPane principale = new GridPane();
		principale.add(lNumeri,0,0);
		principale.add(tfNumeri,1,0);
		principale.add(bInverti,1,1);
		principale.add(lVettoreB,0,2);
		principale.add(lRisultato,1,2);
		bInverti.setMaxWidth(Integer.MAX_VALUE);	
		principale.setVgap(10);
		principale.setHgap(10);
		Insets spazio=new Insets(10);
		principale.setPadding(spazio);
		
		Scene scena = new Scene(principale);
		finestra.setTitle("Inverti");
		finestra.setScene(scena);
		finestra.show();
		
		bInverti.setOnAction( e -> eseguiInverti() );
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
	private void eseguiInverti() {
		int numeri[],c=0;
		numeri=testoNumeri(tfNumeri.getText());
		int inverti[]= new int[numeri.length];
		for(int pos=numeri.length-1 ; pos>-1;pos--,c++) {
			inverti[c]=numeri[pos];
		}
		String se="";
		for(int pos=0; pos<inverti.length; pos++) {
			if(pos==0) {
				se+=" "+inverti[pos];
			}else {
				se+=" "+inverti[pos];
			}
		}
		lRisultato.setText(se);
		
		
	}
	public static void main(String[] args) {
		launch(args);
	}

}
