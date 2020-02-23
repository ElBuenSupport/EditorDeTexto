package vista.menu;
 
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;

import recursos.Recursos;

public class MenuPopUp extends JPopupMenu implements Recursos{
	
	//Iniciamos los elementos del Popupmenu	
	
	private JMenuItem negrita = new JMenuItem(textoNegrita);
	private JMenuItem cursiva = new JMenuItem(textoCursiva);
	private JMenuItem subrayado = new JMenuItem(textSubrayadoo);
	private JMenuItem alinearDerecha = new JMenuItem(textoAlinearDerecha);
	private JMenuItem alinearIzquierda = new JMenuItem(textoAlinearIzquierda);
	private JMenuItem alinearCentro = new JMenuItem(textoAlinearCentro);
	private JMenuItem justificar = new JMenuItem(textoJustificar);
	
	//------------------------------------------------------------------------------
	
	//Geters que traen el los item de los menus para usarlos en el Frame
	public JMenuItem getNegrita() {return negrita;}
	public JMenuItem getCursiva() {return cursiva;}
	public JMenuItem getSubrayado() {return subrayado;}
	public JMenuItem getAlinearDerecha() {return alinearDerecha;}
	public JMenuItem getAlinearIzquierda() {return alinearIzquierda;}
	public JMenuItem getAlinearCentro() {return alinearCentro;}
	public JMenuItem getJustificar() {return justificar;}
	
	//------------------------------------------------------------------------------
	
	public MenuPopUp() {
		
	//Añadimos los botones al menu con espacios al menu
		
		add(negrita);
		addSeparator();
		add(cursiva);
		addSeparator();
		add(subrayado);
		addSeparator();
		add(alinearIzquierda);
		addSeparator();
		add(alinearCentro);
		addSeparator();
		add(alinearDerecha);
		addSeparator();
		add(justificar);
		
	}

}
