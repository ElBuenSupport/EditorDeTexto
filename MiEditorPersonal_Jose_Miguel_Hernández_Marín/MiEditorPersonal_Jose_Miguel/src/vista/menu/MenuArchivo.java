package vista.menu;

import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JSeparator;

import recursos.Recursos;

public class MenuArchivo extends JMenu implements Recursos{
		
	//Iniciamos los elementos del menu
	
	private JMenuItem nuevo = new JMenuItem(textoNuevo);
	private JMenuItem abrir = new JMenuItem(textoAbrir);
	private JMenuItem guardar = new JMenuItem(textoGuardar);
	private JMenuItem salir = new JMenuItem(textoSalir);
	
	//--------------------------------------------------------
		
	//Geters que traen el los item de los menus para usarlos en el Frame
	public JMenuItem getSalir() {return salir;}
	public JMenuItem getNuevo() {return nuevo;}
	public JMenuItem getAbrir() {return abrir;}
	public JMenuItem getGuardar() {return guardar;}
	
	//--------------------------------------------------------
	
	public MenuArchivo() {
				
	//Añadimos los elementos al menu y le damos un nombre
		setText("Archivo");
		
		add(nuevo);
		add(abrir);
		add(guardar);
		add(new JSeparator());
		add(salir);	
		
	}
		
}
