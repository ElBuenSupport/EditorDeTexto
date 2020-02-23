package vista.menu;

import java.awt.Dimension;
import java.awt.GraphicsEnvironment;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JToolBar;

import recursos.Recursos;
												 
public class MenuHerramientas  extends JToolBar implements Recursos{

	//Iniciamos los elementos del menu
	
	private JButton guardar = new JButton();
	private JButton nuevo = new JButton();
	private JButton abrir = new JButton();
	
	private JButton negrita = new JButton();
	private JButton cursiva = new JButton();
	private JButton subrayado = new JButton();
	private JButton alinearDerecha = new JButton();
	private JButton alinearIzquierda = new JButton();
	private JButton alinearCentro = new JButton();
	private JButton justificar = new JButton();	
	
	private JComboBox tamanyo = new JComboBox();
	private JComboBox tipoLetra = new JComboBox();
	
	private JButton deshacer = new JButton();
	
	private JButton buscar = new JButton();
	private JTextField textoBuscar = new JTextField(textoBuscarAqui);
	
	private JButton copiar = new JButton();
	private JButton cortar = new JButton();
	private JButton pegar = new JButton();
	
	//--------------------------------------------------------
	
	//Geters que traen el los item de los menus para usarlos en el Frame
	public JButton getGuardar() {return guardar;}
	public JButton getNuevo() {return nuevo;}
	public JButton getAbrir() {return abrir;}
	public JButton getNegrita() {return negrita;}
	public JButton getCursiva() {return cursiva;}
	public JButton getSubrayado() {return subrayado;}
	public JButton getAlinearDerecha() {return alinearDerecha;}
	public JButton getAlinearIzquierda() {return alinearIzquierda;}
	public JButton getAlinearCentro() {return alinearCentro;}
	public JButton getJustificar() {return justificar;}
	public JButton getDeshacer() {return deshacer;}
	public JComboBox getTamanyo() {return tamanyo;}
	public JComboBox getTipoLetra() {return tipoLetra;}
	
	public JButton getCopiar() {return copiar;}
	public JButton getCortar() {return cortar;}
	public JButton getPegar() {return pegar;}
	
	public JButton getBuscar() {return buscar;}
	public JTextField getTextoBuscar() {return textoBuscar;}
	
	//--------------------------------------------------------
	
	public MenuHerramientas() {
		
	//Añadimos las imagenes a los botones
			
		guardar.setIcon(new ImageIcon(getClass().getResource(iGuardar)));
		abrir.setIcon(new ImageIcon(getClass().getResource(iAbrir)));
		nuevo.setIcon(new ImageIcon(getClass().getResource(iNuevo)));
			
		negrita.setIcon(new ImageIcon(getClass().getResource(iNegrita)));
		cursiva.setIcon(new ImageIcon(getClass().getResource(iCursiva)));
		subrayado.setIcon(new ImageIcon(getClass().getResource(iSubrayado)));
		alinearDerecha.setIcon(new ImageIcon(getClass().getResource(iAlinearDerecha)));
		alinearIzquierda.setIcon(new ImageIcon(getClass().getResource(iAlinearIzquierda)));
		alinearCentro.setIcon(new ImageIcon(getClass().getResource(iAlinearCentro)));
		justificar.setIcon(new ImageIcon(getClass().getResource(iJustificar)));
		deshacer.setIcon(new ImageIcon(getClass().getResource(iDeshacer)));
		
		copiar.setIcon(new ImageIcon(getClass().getResource(iCopiar)));
		cortar.setIcon(new ImageIcon(getClass().getResource(iCortar)));
		pegar.setIcon(new ImageIcon(getClass().getResource(iPegar)));
			
		buscar.setIcon(new ImageIcon(getClass().getResource(iBuscar)));

	//Añadimos un tamaño a los comboBox	y los elementos que tendra
		Dimension d = new Dimension(50,35);
		tamanyo.setMaximumSize(d);
			
		for (int i=14;i<50;i=i+2) {
			String p = i+"";
			tamanyo.addItem(p);
		}
				
		tamanyo.setRequestFocusEnabled(false);
			
		 d = new Dimension(180,35);
		tipoLetra.setMaximumSize(d);
		
		String[] ge = GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();
        for (String font : ge) {
        	tipoLetra.addItem(font.toString());
        }
		
	//Añadimos un tamaño al textField
	
		d = new Dimension(200,35);
		textoBuscar.setMaximumSize(d);
			
			
	//Añadimos los botones al menu y con espacios
			
		add(guardar);
		addSeparator();
		add(abrir);
		addSeparator();
		add(nuevo);
			
		addSeparator();
		addSeparator();
			
		add(tipoLetra);
		addSeparator();
		add(tamanyo);
			
		addSeparator();
		addSeparator();
		addSeparator();

		add(negrita);
		addSeparator();
		add(cursiva);
		addSeparator();
		add(subrayado);
			
		addSeparator();
		addSeparator();
		addSeparator();
		
		add(alinearIzquierda);
		addSeparator();
		add(alinearCentro);
		addSeparator();
		add(alinearDerecha);
		addSeparator();
		add(justificar);
		addSeparator();
		addSeparator();
		addSeparator();
		add(deshacer);
		addSeparator();
		addSeparator();
		addSeparator();
		
		add(copiar);
		addSeparator();
		add(cortar);
		addSeparator();
		add(pegar);
		
		addSeparator();
		addSeparator();
		addSeparator();
		add(textoBuscar);
		addSeparator();
		add(buscar);
		addSeparator();
		addSeparator();
		addSeparator();

	}
	
}
