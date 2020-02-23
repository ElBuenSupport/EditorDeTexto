package vista.menu;

import javax.swing.JMenu;
import javax.swing.JMenuItem;

import recursos.Recursos;

public class MenuAyuda extends JMenu implements Recursos{
	
	//Iniciamos los elementos del menu
	
	JMenuItem enlace = new JMenuItem(textoEnlace);
	JMenuItem info = new JMenuItem(textoAcercaDe);

	//--------------------------------------------------------
	
	//Geters que traen el los item de los menus para usarlos en el Frame
	public JMenuItem getEnlace() {return enlace;}
	public JMenuItem getInfo() {return info;}
	
	//--------------------------------------------------------
	
	public MenuAyuda() {
		
	//Añadimos los botones al menu con espacios al menu y le damos un nombre al menu
		
		setText("Ayuda");
		
		add(enlace);
		addSeparator();
		add(info);
	}
	
}
