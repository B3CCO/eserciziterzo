package it.edu.iisgubbio.matematica;

import javafx.application.Application;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.scene.layout.GridPane;
import javafx.scene.Scene;

public class MinimoComuneMultiplo extends Application{
	Label lNumero1=new Label("N1");
	Label lNumero2=new Label("N2");
	Button bMcm=new Button("MCM");
	Label lRisultato=new Label("??");
	TextField tfNumero1=new TextField();
	TextField tfNumero2=new TextField();

	

	public void start(Stage finestra) throws Exception{
		GridPane principale=new GridPane();

		principale.add(lNumero1, 0, 0);
		principale.add(lNumero2, 0, 1);
		principale.add(bMcm, 0, 2);
		principale.add(lRisultato, 1, 2);
		principale.add(tfNumero1, 1, 0);
		principale.add(tfNumero2, 1, 1);

		Scene scena=new Scene(principale);
		finestra.setTitle("Divisori");
		finestra.setScene(scena);
		finestra.show();

		bMcm.setOnAction( e -> eseguiMcm() );

	}

	private void eseguiMcm() {
		int n1, n2, mcm;
		String sMcm;

		n1=Integer.parseInt(tfNumero1.getText());
		n2=Integer.parseInt(tfNumero2.getText());
		sMcm="";
		
		for(int x=n1*n2;x>0; x--) {
			mcm=n1*x;
			if(mcm%n2==0) {
				sMcm=""+mcm;
			}		
		}
		lRisultato.setText(sMcm);	

	}

	public static void main(String[] args) {

		launch(args);

	}	

}

