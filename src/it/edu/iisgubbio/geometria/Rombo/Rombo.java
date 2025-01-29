package it.edu.iisgubbio.geometria.Rombo;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Rombo extends Application{
	Button pArea = new Button("area");
	Button pPerimetro=new Button("perimetro");
	Label eDiagMagg = new Label("diag magg");
	Label eDiagMin= new Label("diag min");
	Label eRisultatoArea = new Label ("");
	Label eRisultatoPeri=new Label("");
	TextField cDiagMagg = new TextField();
	TextField cDiagMin = new TextField();
	
	public void start(Stage finestra) throws Exception {
		GridPane principale = new GridPane();
		principale.add(eDiagMagg, 0, 0);
		principale.add(eDiagMin, 0, 1);
		principale.add(pArea, 0, 2);
		principale.add(pPerimetro, 0, 3);
		principale.add(cDiagMagg, 1, 0);
		principale.add(cDiagMin, 1, 1);
		principale.add(eRisultatoArea, 1, 2);
		principale.add(eRisultatoPeri, 1, 3);
		

		Scene scena = new Scene(principale);
		finestra.setTitle("rombo");
		finestra.setScene(scena);
		finestra.show();
		
		pArea.setOnAction ( e -> eseguiArea() );
		pPerimetro.setOnAction ( e -> eseguiPerimetro() );
		
		
	}
	
	private void eseguiArea() {
		String dMaggiore,dMinore,testo;
		int vDMaggiore,vDMinore,area;
		
		dMaggiore=cDiagMagg.getText();
		dMinore=cDiagMin.getText();
		vDMaggiore= Integer.parseInt(dMaggiore);
		vDMinore= Integer.parseInt(dMinore);
		area=(vDMinore*vDMaggiore)/2;
		testo=""+area;
		eRisultatoArea.setText(testo);
		
	}
	
	private void eseguiPerimetro() {
		double perimetro;
		int vdMag,vdMin;
		String dMag,dMin,testo;
		
		dMag=cDiagMagg.getText();
		dMin=cDiagMin.getText();
		vdMag = Integer.parseInt(dMag);
		vdMin= Integer.parseInt(dMin);
		perimetro= Math.sqrt((vdMag/2)*(vdMag/2) + (vdMin/2)*(vdMin/2))*4;
		testo=""+perimetro;
		eRisultatoPeri.setText(testo);
	}
	
	public static void main(String[] args) {
		launch(args);
	}

	
	

}
