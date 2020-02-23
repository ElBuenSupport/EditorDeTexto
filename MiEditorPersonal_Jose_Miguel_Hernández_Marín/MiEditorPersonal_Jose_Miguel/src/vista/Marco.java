package vista;

import java.awt.BorderLayout;
import java.awt.Label;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.text.DefaultEditorKit;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledEditorKit;

import control.Accion;
import recursos.Recursos;
import vista.menu.Menu;
import vista.menu.MenuHerramientas;
import vista.menu.MenuHerramientasAbajo;

public class Marco extends JFrame implements Recursos{

	//Iniciamos los elementos para el marco
	
	Menu menu = new Menu();
	MenuHerramientas menuHerramientas =  new MenuHerramientas();
	MenuHerramientasAbajo menuInfo = new MenuHerramientasAbajo();
	

	Texto texto = new Texto();
    JScrollPane scrollTexto = new JScrollPane(texto);
    
	
	//--------------------------------------------------------
    
	public Marco() {

	//Añadimos los menus y el panel al marco
				
		add(menuHerramientas, BorderLayout.NORTH);
		add(menuInfo, BorderLayout.SOUTH);
		
		setJMenuBar(menu);
		
		add(scrollTexto);
			
		
	//Le damos un icono de aplicacion al frame, lo hacemos visible y le asignamos un tamaño
		this.setIconImage(new ImageIcon(getClass().getResource(iIconoPrograma)).getImage());		
	    setSize(1300,720);
		setLocationRelativeTo(null);
	    setVisible(true);

	    //Preparamos los botones para que realicen una accion cuando sean pulsados
	    
	    
	    texto.addMouseListener(new Accion(textoPopUp,texto));
		texto.getDocument().addDocumentListener(new Accion(texto,getEtiquetaNCaracteres(),getEtiquetaNPalabras()));
		texto.addMouseMotionListener(new Accion(texto,getEtiquetaCoordenadaX(),getEtiquetaCoordenadaY()));


	    getBotonNuevo().addActionListener(new Accion(textoNuevo,texto));
	    getBotonAbrir().addActionListener(new Accion(textoAbrir,texto));
	    getBotonGuardar().addActionListener(new Accion(textoGuardar,texto));
	    getBotonSalir().addActionListener(new Accion(textoSalir));
	    
	    
	    getBotonDeshacer().addActionListener(new Accion(textoDeshacer,texto));
	    
	    getBotonEliminar().addActionListener(new Accion(textoEliminar,texto));
	    

	    getBotonSelecionarTodo().addActionListener(new Accion(textoSeleccionarTodo,texto));
	    getBotonHoraFecha().addActionListener(new Accion(TextoHoraFecha,texto));
	    
	    getBotonEnlace().addActionListener(new Accion(textoEnlace));
	    getBotonInfo().addActionListener(new Accion(textoAcercaDe));
	      
	    getBotonImagenGuardar().addActionListener(new Accion(textoGuardar));
	    getBotonImagenAbrir().addActionListener(new Accion(textoAbrir));
	    getBotonImagenNuevo().addActionListener(new Accion(textoNuevo,texto));
	    

	    getBotonImagenNegrita().addActionListener(new StyledEditorKit.BoldAction());
	    getBotonImagenCursiva().addActionListener(new StyledEditorKit.ItalicAction());
	    getBotonImagenSubrayado().addActionListener(new StyledEditorKit.UnderlineAction());

	    getBotonImagenAlinearDerecha().addActionListener(new StyledEditorKit.AlignmentAction("Derecha", StyleConstants.ALIGN_RIGHT));
	    getBotonImagenAlinearCentro().addActionListener(new StyledEditorKit.AlignmentAction("Centrado", StyleConstants.ALIGN_CENTER));
	    getBotonImagenAlinearIzquierda().addActionListener(new StyledEditorKit.AlignmentAction("Izquierda", StyleConstants.ALIGN_LEFT));
	    getBotonImagenJustificar().addActionListener(new StyledEditorKit.AlignmentAction("Justificado", StyleConstants.ALIGN_JUSTIFIED));

	    
	    getComboBoxTamanyo().addActionListener(new Accion(textoTamanyo,texto,getComboBoxTamanyo(),getComboBoxTipoLetra()));
	    getComboBoxTipoLetra().addActionListener(new Accion(textoTamanyo,texto,getComboBoxTamanyo(),getComboBoxTipoLetra()));
	    
	    getBotonCopiar().addActionListener(new DefaultEditorKit.CopyAction());
	    getBotonCortar().addActionListener(new DefaultEditorKit.CutAction());
	    getBotonPegar().addActionListener(new DefaultEditorKit.PasteAction());
	         
	    getPopupNegrita().addActionListener(new StyledEditorKit.BoldAction());
	    getPopuCursiva().addActionListener(new StyledEditorKit.ItalicAction());
	    getPopuSubrayado().addActionListener(new StyledEditorKit.UnderlineAction());
	    getPopuAlinearDerecha().addActionListener(new StyledEditorKit.AlignmentAction("Derecha", StyleConstants.ALIGN_RIGHT));
	    getPopuAlinearCentro().addActionListener(new StyledEditorKit.AlignmentAction("Centrado", StyleConstants.ALIGN_CENTER));
	    getPopuAlinearIzquierda().addActionListener(new StyledEditorKit.AlignmentAction("Izquierda", StyleConstants.ALIGN_LEFT));
	    getPopuJustificar().addActionListener(new StyledEditorKit.AlignmentAction("Justificado", StyleConstants.ALIGN_JUSTIFIED));
	    
	    getBotonImagenDeshacer().addActionListener(new Accion(textoDeshacer,texto));
	    
	    getBotonImagenCopiar().addActionListener(new DefaultEditorKit.CopyAction());
	    getBotonImagenCortar().addActionListener(new DefaultEditorKit.CutAction());
	    getBotonImagenPegar().addActionListener(new DefaultEditorKit.PasteAction());
	   
	    getBotonImagenBuscar().addActionListener(new Accion(textoBuscar,texto,getTextoBuscar()));
	    

	}

	//--------------------------------------------------------
	
	//Geters que traen el los item de los menus para usarlos en el Frame
	public String getTexto() {return texto.getText();}
	public void setTexto(String text) {texto.setText(text);}
	

	public JMenuItem getBotonSalir() {return menu.getBotonSalir();}
	public JMenuItem getBotonNuevo() {return menu.getBotonNuevo();}
	public JMenuItem getBotonAbrir() {return menu.getBotonAbrir();}
	public JMenuItem getBotonGuardar() {return menu.getBotonGuardar();}
	
	public JMenuItem getBotonDeshacer() {return menu.getBotonDeshacer();}
	public JMenuItem getBotonCortar() {return menu.getBotonCortar();}
	public JMenuItem getBotonCopiar() {return menu.getBotonCopiar();}
	public JMenuItem getBotonPegar() {return menu.getBotonPegar();}
	public JMenuItem getBotonEliminar() {return menu.getBotonEliminar();}
	public JMenuItem getBotonSelecionarTodo() {return menu.getBotonSelecionarTodo();}
	public JMenuItem getBotonHoraFecha() {return menu.getBotonHoraFecha();}
	
	public JMenuItem getBotonEnlace() {return menu.getBotonEnlace();}
	public JMenuItem getBotonInfo() {return menu.getBotonInfo();}
	
	public JButton getBotonImagenGuardar() {return menuHerramientas.getGuardar();}
	public JButton getBotonImagenAbrir() {return menuHerramientas.getAbrir();}
	public JButton getBotonImagenNuevo() {return menuHerramientas.getNuevo();}
	public JButton getBotonImagenNegrita() {return menuHerramientas.getNegrita();}
	public JButton getBotonImagenCursiva() {return menuHerramientas.getCursiva();}
	public JButton getBotonImagenSubrayado() {return menuHerramientas.getSubrayado();}
	public JButton getBotonImagenAlinearDerecha() {return menuHerramientas.getAlinearDerecha();}
	public JButton getBotonImagenAlinearIzquierda() {return menuHerramientas.getAlinearIzquierda();}
	public JButton getBotonImagenAlinearCentro() {return menuHerramientas.getAlinearCentro();}
	public JButton getBotonImagenJustificar() {return menuHerramientas.getJustificar();}
	public JButton getBotonImagenDeshacer() {return menuHerramientas.getDeshacer();}
	
	public JButton getBotonImagenCopiar() {return menuHerramientas.getCopiar();}
	public JButton getBotonImagenCortar() {return menuHerramientas.getCortar();}
	public JButton getBotonImagenPegar() {return menuHerramientas.getPegar();}
	
	public JComboBox getComboBoxTamanyo() {return menuHerramientas.getTamanyo();}
	public JComboBox getComboBoxTipoLetra() {return menuHerramientas.getTipoLetra();}
	public JButton getBotonImagenBuscar() {return menuHerramientas.getBuscar();}
	public JTextField getTextoBuscar() {return menuHerramientas.getTextoBuscar();}
	
	public Label getEtiquetaNCaracteres() {return menuInfo.getNCaracteres();}
	public Label getEtiquetaNPalabras() {return menuInfo.getNPalabras();}
	public Label getEtiquetaCoordenadaX() {return menuInfo.getCoordenadaX();}
	public Label getEtiquetaCoordenadaY() {return menuInfo.getCoordenadaY();}
	
	public JMenuItem getPopupNegrita() {return texto.getPopupNegrita();}
	public JMenuItem getPopuCursiva() {return texto.getPopuCursiva();}
	public JMenuItem getPopuSubrayado() {return texto.getPopuSubrayado();}
	public JMenuItem getPopuAlinearDerecha() {return texto.getPopuAlinearDerecha();}
	public JMenuItem getPopuAlinearIzquierda() {return texto.getPopuAlinearIzquierda();}
	public JMenuItem getPopuAlinearCentro() {return texto.getPopuAlinearCentro();}
	public JMenuItem getPopuJustificar() {return texto.getPopuJustificar();}
	
}
