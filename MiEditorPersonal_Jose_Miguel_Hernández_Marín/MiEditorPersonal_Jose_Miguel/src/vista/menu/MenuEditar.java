package vista.menu;

import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JSeparator;
import javax.swing.text.DefaultEditorKit;

import recursos.Recursos;

public class MenuEditar extends JMenu implements Recursos{
	
	//Iniciamos los elementos del menu
	
	private JMenuItem deshacer = new JMenuItem(textoDeshacer);
	private JMenuItem cortar = new JMenuItem(textoCortar);
	private JMenuItem copiar = new JMenuItem(textoCopiar);	
	private JMenuItem pegar = new JMenuItem(textoPegar);
	private JMenuItem eliminar = new JMenuItem(textoEliminar);
	private JMenuItem selecionarTodo = new JMenuItem(textoSeleccionarTodo);
	private JMenuItem horaFecha = new JMenuItem(TextoHoraFecha);	
	
	//------------------------------------------------------------------------------
	
	//Geters que traen el los item de los menus para usarlos en el Frame
	public JMenuItem getDeshacer() {return deshacer;}
	public JMenuItem getCortar() {return cortar;}
	public JMenuItem getCopiar() {return copiar;}
	public JMenuItem getPegar() {return pegar;}
	public JMenuItem getEliminar() {return eliminar;}
	public JMenuItem getSelecionarTodo() {return selecionarTodo;}
	public JMenuItem getHoraFecha() {return horaFecha;}
	
	//--------------------------------------------------------
	
	public MenuEditar() {					
		
	//Añadimos los elementos al menu y le damos un nombre
		
		setText("Editar");
		
		add(deshacer);
		add(cortar);
		add(copiar);
		add(pegar);
		add(eliminar);
		add(selecionarTodo);
		add(new JSeparator());
		add(horaFecha);
		
	}

}
