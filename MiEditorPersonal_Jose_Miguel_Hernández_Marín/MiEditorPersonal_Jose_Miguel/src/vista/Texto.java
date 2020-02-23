package vista;

import javax.swing.JMenuItem;
import javax.swing.JTextPane;

import vista.menu.MenuPopUp;

public class Texto extends JTextPane{
	
	//Iniciamos los elementos del texto

	MenuPopUp popUp = new MenuPopUp();
			
	//--------------------------------------------------------
	
	//Añadimos los botones al menu con espacios al menu y le damos un nombre al menu
	public String getTexto() {return getText();}
	public void setTexto(String texto) {this.setText(texto.toString());}
	
	public MenuPopUp getPopUp() {return popUp;}
	
	public JMenuItem getPopupNegrita() {return popUp.getNegrita();}
	public JMenuItem getPopuCursiva() {return popUp.getCursiva();}
	public JMenuItem getPopuSubrayado() {return popUp.getSubrayado();}
	public JMenuItem getPopuAlinearDerecha() {return popUp.getAlinearDerecha();}
	public JMenuItem getPopuAlinearIzquierda() {return popUp.getAlinearIzquierda();}
	public JMenuItem getPopuAlinearCentro() {return popUp.getAlinearCentro();}
	public JMenuItem getPopuJustificar() {return popUp.getJustificar();}
	
	//--------------------------------------------------------
	
	//Añadimos un menuPopup al texto y
	
	public Texto() {
		add(popUp);
	}
	
}
