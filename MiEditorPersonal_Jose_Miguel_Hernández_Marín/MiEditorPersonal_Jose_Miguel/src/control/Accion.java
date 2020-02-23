package control;

import java.awt.Color;
import java.awt.Desktop;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.net.URI;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.StringTokenizer;

import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.event.UndoableEditEvent;
import javax.swing.event.UndoableEditListener;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.text.DefaultHighlighter;
import javax.swing.text.Document;
import javax.swing.text.Highlighter;
import javax.swing.undo.UndoManager;

import java.awt.Label;

import recursos.Recursos;
import vista.Texto;
import vista.menu.*;

public class Accion  implements MouseMotionListener,DocumentListener,MouseListener,ActionListener,Recursos {
	
	Highlighter.HighlightPainter myHighlightPainter = new GenerarColor(Color.green);

	
	DateFormat dateFormat = new SimpleDateFormat("HH:mm dd/MM/yyyy");
	Date date = new Date();
	
	Texto texto = new Texto();	
	


	private String accion;
	
	private String ruta;
	private boolean nuevo = true;
	private JTextField jtextfile;
	
	private UndoManager manager = new UndoManager();
	
	private JComboBox cb1 = new JComboBox();
	private JComboBox cb2 = new JComboBox();
	
	private Label etiqueta1 = new Label();
	private Label etiqueta2 = new Label();
	
	public Accion() {} 
	public Accion(String accion) {
		this.accion = accion;
	} 
	
	public Accion(String accion,Texto texto,JTextField jtextfile) {
		this.accion = accion;
		this.texto=texto;
		this.jtextfile=jtextfile;
	}
		
	public Accion(String accion,Texto texto,JComboBox cb1,JComboBox cb2) {
		this.accion = accion;
		this.texto=texto;
		this.cb1=cb1;
		this.cb2=cb2;
	}
	
	public Accion(Texto texto,Label etiqueta1,Label etiqueta2) {
		this.texto=texto;
		this.etiqueta1 = etiqueta1;
		this.etiqueta2=etiqueta2;
	}	
	
	public Accion(String accion,Texto texto) {
		this.accion = accion;
		this.texto=texto;
		
		this.texto.getDocument().addUndoableEditListener(new UndoableEditListener() {
            public void undoableEditHappened(UndoableEditEvent e) {
                manager.addEdit(e.getEdit());
            }
        });
	}
		

	MenuArchivo menuArchivo = new MenuArchivo();	
	MenuEditar menuEditar = new MenuEditar();	
	MenuAyuda 	menuAyuda = new MenuAyuda();	
	MenuHerramientas menuHerramientas = new MenuHerramientas();
	MenuHerramientasAbajo menuInfo = new MenuHerramientasAbajo();
	

	
	JFileChooser explorador = new JFileChooser();
	FileNameExtensionFilter filter = new FileNameExtensionFilter("Archivos.txt", "txt");
	
	public void actionPerformed(ActionEvent e) {
			
		//		Accion que te pregunta si quieres guardar
		
		if (accion.contentEquals(textoNuevo)){
			if (!texto.getTexto().equals("")) {		
			
				String cosas[] = {"Guardar","No guardar","Cancelar"};
				int eleccion = JOptionPane.showOptionDialog(null, "¿Desea guardar los cambios?", "Editor de Texto",
					JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, cosas, cosas[0]);
	
				if (eleccion == 0) {guardarArchivo();texto.setTexto("");ruta="";nuevo=true;}
				if (eleccion == 1) {texto.setTexto("");ruta="";nuevo=true;}
			}
			else texto.setTexto("");
		}		
		//----------------------------------------------------------------------------------------------
		//			Accion para abrir un fichero
		
		if (accion.contentEquals(textoAbrir)) {

			explorador.setFileFilter(filter);
			explorador.setDialogTitle("Abrir un archivo .txt");
			
				if (explorador.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
					
					ruta = explorador.getSelectedFile().getPath();
					nuevo = false;

				try {
					BufferedReader reader = new BufferedReader(new FileReader(ruta));
					String textoTota = "";
					String linea = reader.readLine();
					while (linea != null) {
						textoTota = textoTota + linea + System.getProperty("line.separator");
						linea = reader.readLine();
					}
					texto.setTexto(textoTota);
					reader.close();
				} catch (Exception e1) {
					System.out.println(e1.getMessage());
				}
			}	
		}		
		//----------------------------------------------------------------------------------------------
		//				Accion para guardar un fichero
		
		if (accion.contentEquals(textoGuardar)) {
			 guardarArchivo();
		}		
		//----------------------------------------------------------------------------------------------
		//				Accion para Salir 
		
		if (accion.equals(textoSalir)) {
			String cosas[] = { "Si", "No"};
			int eleccion = JOptionPane.showOptionDialog(null, "¿Quieres salir?", "Cerrar aplicación",
					JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, cosas, cosas[0]);
			if (eleccion == 0) {
				System.exit(0);
			}
		}
		//----------------------------------------------------------------------------------------------
		//				Accion para deshacer una accion
		
		if (accion.equals(textoDeshacer)) {
			try {
				manager.undo();
			}catch(Exception ex) {}
		}		
		//----------------------------------------------------------------------------------------------
		//				Accion para eliminar texto seleccionado
		
		if (accion.equals(textoEliminar)) {
			texto.replaceSelection("");
		}
		//----------------------------------------------------------------------------------------------
		//				Accion para seleccionarlo todo
		
		if (accion.equals(textoSeleccionarTodo)) {
			texto.selectAll();
		}
		//----------------------------------------------------------------------------------------------
		//				Accion para añadir la hora y fecha al texto
		
		if (accion.equals(TextoHoraFecha)) {
			texto.setText(texto.getText()+dateFormat.format(date));
		}
		//----------------------------------------------------------------------------------------------
		//				Accion que te lleva a un enlace
		
		if (accion.equals(textoEnlace)) {
	        try {
	        	Desktop.getDesktop().browse(new URI("https://github.com/ElBuenSupport/EditorDeTexto"));
	        } catch (Exception ex) {} 
	    }
		//----------------------------------------------------------------------------------------------
		//				Accion para mostrar informacion
		
		if (accion.equals(textoAcercaDe)) {
			JOptionPane.showMessageDialog(null, "Editor de texto creado por Jose Miguel Hernández Marín ","Información",1);
		}
		//----------------------------------------------------------------------------------------------
		//				Accion para seleccionar un tamaño de letra
		
		if (accion.equals(textoTamanyo) || accion.equals(textoEstiloLetra)) {
			
			texto.setFont(new Font(cb2.getSelectedItem().toString(),texto.getFont().getStyle(), Integer.parseInt(cb1.getSelectedItem().toString())));
		 
		}
		//----------------------------------------------------------------------------------------------
		//				Accion para buscar una palabra en el testo
		
		if (accion.equals(textoBuscar)) {
			
			 
			jtextfile.setText(jtextfile.getText().toString());
			String buscarPalabra= jtextfile.getText().toString();
			 
			try {
				Highlighter hilite = texto.getHighlighter();
				Document doc = texto.getDocument();
				String text = doc.getText(0, doc.getLength());
				int pos = 0;

				while ((pos = text.toUpperCase().indexOf(buscarPalabra.toUpperCase(), pos)) >= 0) {
					hilite.addHighlight(pos, pos + buscarPalabra.length(), myHighlightPainter);
					pos += buscarPalabra.length();
				}
			} catch (Exception ex) {
			}
		}
		
	}	
	//----------------------------------------------------------------------------------------------
	//Metodo que comprueba si fichero existe o es nuevo
	//Si existe lo guarda y si es nuevo te pregunta donde deseas guardarlo 
	
    public void guardarArchivo(){
		if (nuevo == true){
			explorador.setFileFilter(filter);
			explorador.setDialogTitle("Guardar archivo .txt");
		
			if (JFileChooser.APPROVE_OPTION == explorador.showSaveDialog(null)) {
				ruta = explorador.getSelectedFile().getPath()+".txt";
				nuevo=false;
			}
		}
			
    	try {
        	FileWriter fichero = new FileWriter(ruta);
    		fichero.write(texto +"\n");
    		fichero.close();
    	}catch(Exception ex) {}    
		
	}
	//----------------------------------------------------------------------------------------------
	//Accion para mostrar el menu popup
    
	public void mouseClicked(MouseEvent e) {}
	public void mousePressed(MouseEvent e) {
		showPopup(e);
	}
	public void mouseReleased(MouseEvent e) {
		 showPopup(e);
	}
	public void mouseEntered(MouseEvent e) {}
	public void mouseExited(MouseEvent e) {}
	private void showPopup(MouseEvent e) {
		if (e.isPopupTrigger()) {
			texto.getPopUp().show(e.getComponent(),e.getX(), e.getY());
        }

    
    
	}
	//----------------------------------------------------------------------------------------------
	//Actualiza las etiquetas de los caracteres ypalabras del texto y las coordenadas
	public void insertUpdate(DocumentEvent e) {
		String miVariable = String.valueOf(texto.getText().length());
		etiqueta1.setText(miVariable);

		StringTokenizer st = new StringTokenizer(texto.getText());
		etiqueta2.setText(String.valueOf(st.countTokens()));
	
		
	}

	public void removeUpdate(DocumentEvent e) {
		String miVariable = String.valueOf(texto.getText().length());
		etiqueta1.setText(miVariable);

		StringTokenizer st = new StringTokenizer(texto.getText());
		etiqueta2.setText(String.valueOf(st.countTokens()));
		
	}

	public void changedUpdate(DocumentEvent e) {

		
	}
	//----------------------------------------------------------------------------------------------
	//Actualiza las coordenadas del raton sobre el texto
	public void mouseDragged(MouseEvent e) {
		etiqueta1.setText(String.valueOf(e.getX()));
		etiqueta2.setText(String.valueOf(e.getY()));
		
	}

	public void mouseMoved(MouseEvent e) {
		etiqueta1.setText(String.valueOf(e.getX()));
		etiqueta2.setText(String.valueOf(e.getY()));
		
	}
	private class GenerarColor extends DefaultHighlighter.DefaultHighlightPainter {
		public GenerarColor(Color color) {
			super(color);
		}
	}
}
