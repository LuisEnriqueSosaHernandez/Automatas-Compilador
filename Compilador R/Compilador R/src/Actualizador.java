import java.awt.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.event.CaretEvent;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.border.Border;
import javax.swing.*;

public class Actualizador {

    int linea = 1;  //en que fila y columna está el cursor
    int columna = 1;
    int rowCounter = 1; //Cuantos renglones tiene el codigo
    public boolean editado = false; //Para saber si el text box ha sido editado
    public boolean vacio = true; //Para saber si está vacío
    public boolean guardado=false;
    public boolean existe=false;
    String nombre; //El nombre del archivo con ruta
    String archivo; //Solo el nombre del archiv con la extension .light
	public boolean encendido=true;

    //**********G   E   S   T   I   O   N       D   E       A   R   C   H   I   V   O   S  ******************
   
//Funcion para abrir un nuevo archivo de texto    
    public void abrir(Vista vista) {
       
        if(vacio)
        {
        abrirArchivo(vista);
        }
        else
        {
        if(guardado)
        {
        abrirArchivo(vista);
        }
        else
        {
         int seleccion= JOptionPane.showOptionDialog(
                    vista,
                    "\u00BFGuardar Archivo?",
                    "Desea Guardar el Archivo Actual?",
                    JOptionPane.YES_NO_CANCEL_OPTION,
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    null,
                    "opcion 1");
            
            if (seleccion == JOptionPane.YES_OPTION) {
                guardar(vista);
                  
            }
            if(seleccion!= JOptionPane.CANCEL_OPTION )
            {
            abrirArchivo(vista);
            this.editado=false;
                    this.guardado=true;
                    this.vacio=false;
            }   
        }
        }
      
     
       
    }

    public void abrirArchivo(Vista vista)
    {
    
      String name = "";
        JFileChooser seleccion = new JFileChooser();
        seleccion.setCurrentDirectory(new File("Archivos"));
        FileNameExtensionFilter filtro = new FileNameExtensionFilter("Codigo Fuente R", "R");
        seleccion.setFileFilter(filtro);
        int opcion = seleccion.showOpenDialog(vista);
        if (opcion == JFileChooser.APPROVE_OPTION) {
            name = "" + seleccion.getSelectedFile();
            this.nombre=name;
            vista.setTitle("<" + seleccion.getSelectedFile().getPath() + ">" + " - R");
            archivo=seleccion.getSelectedFile().getName();
        }
        if (name != "") {
            leerArchivo(name, vista);
        }
        this.existe=true;
		vista.output.setText("");
                vista.output2.setText("");
                vista.output3.setText("");
     }
    
    //Funcion al cerrar la ventana
    public void salir(Vista vista) {
            
            
        if(vacio)
        {
        System.exit(0);
        }
        else
        {
        if(guardado)
        {
        System.exit(0);
        }
        else
        {
         int seleccion= JOptionPane.showOptionDialog(
                    vista,
                    "\u00BFGuardar Archivo?",
                    "Desea Guardar el Archivo Actual?",
                    JOptionPane.YES_NO_CANCEL_OPTION,
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    null,
                    "opcion 1");
            
            if (seleccion == JOptionPane.YES_OPTION) {
                guardar(vista);
            }
            if(seleccion!= JOptionPane.CANCEL_OPTION )
            {
            System.exit(0);
            }   
        }
        }
            
            
    }

//Funcion para leer un archivo de Texto
    public void leerArchivo(String nombre, Vista vista) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(nombre));
            String temp = "";
            String bfRead;
            limpiar(vista);
            int cc = 0;
            while ((bfRead = reader.readLine()) != null) {
                vista.input.append(bfRead + "\r\n");
                cc++;
            }
            rowCounter = cc;
            actualizarCounter(vista);
            reader.close();
        } catch (Exception e) {
            System.err.println("Error al leer o buscar el archivo");
        }
    }

    public void nuevo(Vista vista){
        
        int seleccion;
        if(!guardado){
        
        if (!this.vacio) {
                    seleccion= JOptionPane.showOptionDialog(
                    vista,
                    "\u00BFGuardar Archivo?",
                    "Desea Guardar el Archivo Actual?",
                    JOptionPane.YES_NO_CANCEL_OPTION,
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    null,
                    "opcion 1");
            
            if (seleccion == JOptionPane.YES_OPTION) {
                guardar(vista);
            }
            if(seleccion!= JOptionPane.CANCEL_OPTION )
            {
            vista.input.setText("");
            vista.input.setText("");
            vista.numeros.setText("");
            this.linea=this.columna=this.rowCounter=1;
            editado = false;
            vacio = true; 
            this.existe=false;
            this.guardado=false;
            nombre="";
            this.actualizarBloqueo(vista);
            this.actualizarCounter(vista);
            vista.setTitle("<Nuevo> - R");
            this.limpiar(vista);
            
            }
        }
    }else
    {
       vista.input.setText("");
            vista.input.setText("");
            vista.numeros.setText("");
            this.linea=this.columna=this.rowCounter=1;
            editado = false;
            vacio = true; 
            nombre="";
            this.actualizarBloqueo(vista);
            this.actualizarCounter(vista);
            vista.setTitle("<Nuevo> - R");  
    }

    }
    
public void guardarComo(Vista vista){
        
        JFileChooser guardo = new JFileChooser();
        guardo.setCurrentDirectory(new File("Archivos"));
        FileNameExtensionFilter filtro = new FileNameExtensionFilter("Codigo Fuente R", "R");
        guardo.setFileFilter(filtro);

        int opcion = guardo.showSaveDialog(vista);
        
        
        if (opcion == JFileChooser.APPROVE_OPTION) {
            //Crea el archivo
            File archivo;
            nombre = anadirExtension(guardo.getSelectedFile().getPath());
            
            vista.setTitle("<" + nombre + ">" + " - R ");
            archivo = new File(nombre);
            
            
            if (!archivo.exists()) {
                try {
                    archivo.createNewFile();
                } catch (IOException ex) {
                    System.out.println("Error al crear");
                }
            }
           
            
            try { //Escribe en el archivo
                FileWriter w = new FileWriter(archivo);
                //BufferedWriter bw = new BufferedWriter(w);
                String txt = vista.input.getText();
                w.append(txt);
                w.close();
                this.guardado=true;
                this.existe=true;
            } catch (IOException ex) {
                System.out.println("Error al escribir");
            }
            
        }
        System.out.println("Archivo guardado");
        System.out.println("G: "+guardado);
        System.out.println("E: "+editado);
        
}

public void soloGuardar(Vista vista)
{
//Crea el archivo
            

                System.out.println("nombre antes de"+nombre);
            
            
            vista.setTitle("<" + nombre + ">" + " - R ");
            
            File archivo;
            archivo = new File(nombre);
            
            
            if(archivo.exists()) {
                try { //Escribe en el archivo
                FileWriter w = new FileWriter(archivo);
                String txt = vista.input.getText();
                w.append(txt);
                w.close();
                System.out.println("Guardado con éxito");
                this.guardado=true;
              
               } catch (IOException ex) {
                System.out.println("Error al escribir en arch que existe");
            }
            
            }
}
    
    
//Funcion para guardar el contenido
    public void guardar(Vista vista) {
            if(!vacio)
            {
            if(existe)
            {
            soloGuardar(vista);
            }
            else
            {
            guardarComo(vista);
            }
            }
        
            
       
    }

    public String anadirExtension(String nombre) {
        
        String ext = nombre.substring(nombre.length() - 2, nombre.length());
        
        if (!ext.equals(".R")) {
            nombre = nombre + ".R";
        }


        return nombre;
    }

    public void limpiar(Vista vista) {
        vista.input.setText("");
        vista.input.setText("");
    }

    ///GESTION DE ACTUALIZACION DE PARAMETROS
        
    public void actualizarCounter(Vista vista) {
        vista.numeros.setText("");
        int cc = this.rowCounter;

        for (int i = 1; i <= cc; i++) {
            vista.numeros.append(Integer.toString(i) + "\n\r");
        }

    }

    public void actualizarApuntador(Vista vista, CaretEvent e) {
        JTextArea tx = (JTextArea) e.getSource();

        try {
            int caretpos = tx.getCaretPosition();
            linea = tx.getLineOfOffset(caretpos);
            columna = caretpos - tx.getLineStartOffset(linea);

            // Ya que las líneas las cuenta desde la 0
            linea += 1;
        } catch (Exception ex) {
        }
    }

    public boolean estaVacio(Vista vista) {
        boolean vacio;
        String texto = vista.input.getText();

        if (!texto.matches("[[ ]*[\n]*[\t]]*")) {
            vacio = false;
        } else {
            vacio = true;
        }

        this.vacio = vacio;
        return vacio;
    }

    public void actualizarBloqueo(Vista vista) {
        if (estaVacio(vista)) {
            bloqDesbloq(false, vista);
        } else {
            bloqDesbloq(true, vista);
        }

        contarRenglones(vista);
        //actualizarCounter(vista);//Al parecer esto era lo que movia la barra de desplazamiento
        System.out.println("G: "+guardado);
        System.out.println("E: "+editado);
    }

    public void bloqDesbloq(boolean bloq, Vista vista) {
        vista.guardar.setEnabled(bloq);
        vista.compilar.setEnabled(bloq);
        vista.nuevo.setEnabled(bloq);
        vista.a.setEnabled(bloq);
        vista.c.setEnabled(bloq);
        vista.e.setEnabled(bloq);
        vista.h.setEnabled(bloq);
    }

    public void contarRenglones(Vista vista) {
        String text = vista.input.getText();
        int cont = 1;
        char s = "\n".charAt(0);

        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) == s) {
                cont++;
            }
        }
        this.rowCounter = cont;
    }

	public void apagar(Vista vista)
	{
	if(encendido)onoff( vista, Color.black , false);
			
        else onoff( vista, Color.white, true);		
	}
        
        public void onoff(Vista vista, Color color, boolean togle)
{
            vista.central.setBorder(BorderFactory.createLineBorder(color, 25));	
            
            if(togle)
            {
                
            //vista.icono.setIcon(vista.im1); //Ya no tenemos icono
            vista.input.setBackground(Color.white);
            vista.input.setForeground(Color.BLACK);
            vista.input.setCaretColor(Color.BLUE);
            vista.output.setBackground(Color.WHITE);
            vista.output.setForeground(Color.BLACK);
            vista.output2.setBackground(Color.WHITE);
            vista.output2.setForeground(Color.BLACK);
            vista.output3.setBackground(Color.WHITE);
            vista.output3.setForeground(Color.BLACK);
            }
            
            else{
            //vista.icono.setIcon(vista.im2); //Ya no tenemos icono
            vista.input.setBackground(Color.DARK_GRAY);
            vista.input.setForeground(Color.WHITE);
            vista.input.setCaretColor(Color.CYAN);
            vista.output.setBackground(Color.DARK_GRAY);
            vista.output.setForeground(Color.WHITE);
             vista.output2.setBackground(Color.DARK_GRAY);
            vista.output2.setForeground(Color.WHITE);
             vista.output3.setBackground(Color.DARK_GRAY);
            vista.output3.setForeground(Color.WHITE);
            }
            
            vista.colorearSplit(vista.principal, color);
            vista.colorearSplit(vista.sp, color);
            vista.colorearSplit(vista.sl, color);
            //vista.iconPane.setBackground(color);////Ya no tenemos icono
            encendido=togle;	
            vista.repaint();
          
            
            
        }
	
	
    
}//Fin de la CLASE;

   


