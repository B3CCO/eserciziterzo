package it.edu.iisgubbio.battaglianavale;


import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class BattagliaNavale extends Application{
	ImageView[][]q;
	Image acqua = new Image(getClass().getResourceAsStream("acqua.png"));
	Image affondato = new Image(getClass().getResourceAsStream("affondato.png"));
	Image colpito = new Image(getClass().getResourceAsStream("colpito.png"));
	Image nonColpito=new Image(getClass().getResourceAsStream("nonColpito.png"));
	
	TextField cordinataX= new TextField();
	TextField cordinataY= new TextField();
	Button colpo=new Button("spara");
	Label tfEsito= new Label("??");
	
	/*se la nave è lunga 2 si chiama incrociatore 
	 * se lunga 3 sottomarino
	 * se lunga 4 porta aerei
	 */
	
	int[] misure= {3,3,4,4,4};
	Nave[] flotta= new Nave[misure.length];
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		q=new ImageView[10][10];
		GridPane principale = new GridPane();
		
		for(int i=0;i<flotta.length;i++) {
			String nomeNave=" ";
			boolean sonoSovrapposte;
			do {
				switch (misure[i]) {
				case 2:
					nomeNave="incrociatore";
					break;
				case 3:
					nomeNave="sottomarino";
					break;
				case 4:
					nomeNave="porta aerei";
					break;
				
				default:
					nomeNave="nave";
				}
				
				if(Math.random()<0.5) {
					flotta[i]=new Nave(""+nomeNave,
							(int)(Math.random()*(10-misure[i])),
							(int)(Math.random()*10),
							misure[i],
							false);
				}else {
					flotta[i]=new Nave(""+nomeNave,
							(int)(Math.random()*10),
							(int)(Math.random()*(10-misure[i])),
							misure[i],
							false);
				}
				
				
				
				sonoSovrapposte=false;
				for(int p=0;p<i;p++) {
					if(flotta[i].sovrappone(flotta[p])) {
						sonoSovrapposte=true;
					}
				}
				System.out.println(i+" "+sonoSovrapposte);
			}while(sonoSovrapposte==true);
			System.out.println(flotta[i]);
			
		}
		
		for(int x=0; x<q.length; x++) {
			for(int y=0; y<q[x].length; y++) {
				q[x][y]=new ImageView(acqua);
				principale.add(q[x][y], x, y);
			}
		}
		
		principale.add(cordinataX, 0,10);
		principale.add(cordinataY, 1, 10);
		principale.add(colpo, 2, 10,2,1);
		principale.add(tfEsito,4,10,3,1);
		
		cordinataX.setPrefWidth(30);
		cordinataX.setPromptText("'x'");
		cordinataY.setPrefWidth(30);
		cordinataY.setPromptText("'y'");
		
		colpo.setOnAction(e->eseguiColpo());
		
		Scene scena = new Scene(principale);
		primaryStage.setTitle("Battaglia Navale");
		primaryStage.setScene(scena);
		primaryStage.show();
		
	}
	
	private void eseguiColpo() {
		boolean colpo=false;
		boolean aff=false;
		Pezzo[] k= null;
		
		int cX=Integer.parseInt(cordinataX.getText());
		int cY=Integer.parseInt(cordinataY.getText());
		
		for(int i=0;i<flotta.length;i++) {
			if(flotta[i].colpo(cX, cY)) {
				colpo=true;
				if(flotta[i].affondata()) {
					aff=true;
					k=flotta[i].getPezzi();	
					for(int pos=0;pos<k.length;pos++) {
						q[k[pos].x][k[pos].y].setImage(affondato);
					}
				}

			}
		}
		if(!aff) {
			if(colpo) {
				q[cX][cY].setImage(colpito);
				tfEsito.setText("hai colpito");
				
			}else {
				q[cX][cY].setImage(nonColpito);
				tfEsito.setText("non hai colpito");
			}
		}
	}
	public static void main(String[] args) {
		launch(args);
	}
}
