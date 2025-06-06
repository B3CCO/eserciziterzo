
package it.edu.iisgubbio.saluti;


import javafx.application.Application;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBase;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 * La mia prima classe
 */
public class CiaoMondo extends Application {

  Button pSaluto = new Button(); 
  Button pUno = new Button();
  Button pDue = new Button();
  Label eCiao = new Label ();

  public void start(Stage finestra) {
    pSaluto.setText("Saluta!");
    pSaluto.setOnAction(e -> esegui());
    pUno.setText("Uno");
    pUno.setOnAction(e -> esegui());
    pDue.setText("Due");
    pDue.setOnAction(e -> esegui());
    eCiao.setText("Ciao");

    GridPane principale = new GridPane();
    principale.add(pSaluto,0,0);
    principale.add(pUno,1,0);
    principale.add(pDue,0,1);
    principale.add(eCiao, 2,1);

    Scene scena = new Scene(principale);

    finestra.setTitle("Hello World!");
    finestra.setScene(scena);
    finestra.show();
  }

  private void esegui(){
    pSaluto.setText("Ciao Mondo!");
  }

  public static void main(String[] args) {
    launch(args);
  }
}