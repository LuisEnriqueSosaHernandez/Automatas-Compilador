
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

public class OyenteBotones implements ActionListener {

    Vista vista;
    Actualizador modelo;

    public OyenteBotones(Vista vista, Actualizador modelo) {
        this.vista = vista;
        this.modelo = modelo;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        switch (((Component) e.getSource()).getName()) {
            case "nuevo":
                modelo.nuevo(vista);
                break;

            case "abrir":
                System.out.println("VACIO= " + modelo.vacio);
                System.out.println("EDITADO= " + modelo.editado);
                System.out.println("GUARDADO " + modelo.guardado);
                modelo.abrir(vista);
                modelo.actualizarBloqueo(vista);
                
                break;

            case "guardar":
                modelo.guardar(vista);
                break;

            case "guardarcomo":
                System.out.println("Save As");
                modelo.guardarComo(vista);
                break;

            case "salir":
                modelo.salir(vista);
                break;

            case "compilar":

                compilar(vista);

                break;
            case "luz":
                modelo.apagar(vista);
                break;

            case "acerca":
                JOptionPane.showMessageDialog(vista,"        Instituto Tecnol\u00F3gico de Veracruz\n\r        Ingenieria en Sistemas Computacionales\n\r        Ana Laura Jácome González\n\r\t        Alejandra Hernández Bretón\n\r\n\r        Fernando Turrubiates Pérez\n\r\t        Lenguajes y Aut\u00F3matas II\n\r        Catedr\u00e1tico: Lourdes","Acerca de", JOptionPane.PLAIN_MESSAGE);
                break;
        }
    }

    public void compilar(Vista vista) {

        if(modelo.vacio)
        {
        
        }
        else
        {
        if(modelo.guardado)
        {
            this.compilarArchivo(vista);
        }
        else
        {
        
            modelo.guardar(vista);    
            
            
            if(modelo.guardado==true )
            {
            this.compilarArchivo(vista);
            }   
        }
        }

    }

     
public void compilarArchivo(Vista v)
{
vista.output.setText("");
vista.output2.setText("");
vista.output3.setText("");
vista.numErr=0;
vista.numErrS=0;
vista.errores="";
vista.erroresS="";
VerificacionToken.vaciar();
            System.out.println("Si compila");

            //ANALISIS LÉXICO
            try {
                vista.output3.appendBlue(">>ANALISIS L\u00c9XICO INICIADO...");
               vista.output3.appendYellow("\n\tValor\t\t\tTipo");
               vista.output3.appendYellow("\n=============================================================\n");

                Compilador compLex;
                Compilador compSint;
                Compilador compS;
                try {
                    compLex = new Compilador(new java.io.FileInputStream(modelo.nombre));
                    compLex.analisisLexico(vista, compLex);
                    
                    compSint = new Compilador(new java.io.FileInputStream(modelo.nombre));
                    compSint.analisisSintactico(vista, compSint);
                    compS = new Compilador(new java.io.FileInputStream(modelo.nombre));
                    compS.analisisSemantico(vista, compS);
                } catch (java.io.FileNotFoundException e) {
                    System.out.println("Error de archivo");
                }

            } catch (ParseException e) {
                vista.output.append("ERROR DE COMPILACI\u00d3N: (Palabra No valida) " + e.getMessage());
                JOptionPane.showMessageDialog(null, "Error de Compilaci\u00F3n", "Error", JOptionPane.ERROR_MESSAGE, null);
            }
}
    
}; //Fin de la clase

