package vista.menu;

import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class Menu extends JMenuBar{
	
	
	//Iniciamos los elementos del menu
	
	MenuArchivo menuArchivo =  new MenuArchivo();
	MenuEditar menuEditar =  new MenuEditar();
	MenuAyuda menuAyuda =  new MenuAyuda();
	
	//--------------------------------------------------------
	
	//Geters que traen el los item de los menus para usarlos en el Frame
	public JMenuItem getBotonSalir() {return menuArchivo.getSalir();}
	public JMenuItem getBotonNuevo() {return menuArchivo.getNuevo();}
	public JMenuItem getBotonAbrir() {return menuArchivo.getAbrir();}
	public JMenuItem getBotonGuardar() {return menuArchivo.getGuardar();}
	
	public JMenuItem getBotonDeshacer() {return menuEditar.getDeshacer();}
	public JMenuItem getBotonCortar() {return menuEditar.getCortar();}
	public JMenuItem getBotonCopiar() {return menuEditar.getCopiar();}
	public JMenuItem getBotonPegar() {return menuEditar.getPegar();}
	public JMenuItem getBotonEliminar() {return menuEditar.getEliminar();}
	public JMenuItem getBotonSelecionarTodo() {return menuEditar.getSelecionarTodo();}
	public JMenuItem getBotonHoraFecha() {return menuEditar.getHoraFecha();}

	public JMenuItem getBotonEnlace() {return menuAyuda.getEnlace();}
	public JMenuItem getBotonInfo() {return menuAyuda.getInfo();}
	
	//--------------------------------------------------------
	
	public Menu() {
		
	//Añadimos los diferentes menus al menu principal
		add(menuArchivo);
		add(menuEditar);
		add(menuAyuda);
	}
	

	

	
	
	

	

	


}
