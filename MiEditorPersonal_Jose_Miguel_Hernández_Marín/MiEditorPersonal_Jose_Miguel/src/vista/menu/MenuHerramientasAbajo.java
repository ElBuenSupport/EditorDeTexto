package vista.menu;


import java.awt.Label;
import javax.swing.JToolBar;

import recursos.Recursos;
												 
public class MenuHerramientasAbajo  extends JToolBar implements Recursos{

	//Iniciamos los elementos del menu
	
	private Label nLabelCaracteres = new Label("Nº Caracteres : ");
	private Label nCaracteres = new Label();
	private Label nLabelPalabras = new Label("Nº de Palabras : ");
	private Label nPalabras = new Label();
	private Label nLabelCoordenadas = new Label("Coordenadas : ");
	private Label coordenadaX = new Label();
	private Label cooredenadaY = new Label();
	
	//--------------------------------------------------------
	
	//Geters que traen el los item de los menus para usarlos en el Frame
	public Label getNCaracteres() {return nCaracteres;}
	public Label getNPalabras() {return nPalabras;}
	public Label getCoordenadaX() {return coordenadaX;}
	public Label getCoordenadaY() {return cooredenadaY;}
	
	//--------------------------------------------------------
	
	public MenuHerramientasAbajo() {
			
	//Añadimos los botones al menu con espacios al menu
		
		add(nLabelCaracteres);
		add(nCaracteres);
		add(nLabelPalabras);
		add(nPalabras);
		add(nLabelCoordenadas);
		add(coordenadaX);
		add(cooredenadaY);
		
	}
	
}
