import java.awt.event.KeyEvent;
import static java.awt.event.KeyEvent.VK_BACK_SPACE;
import static java.awt.event.KeyEvent.VK_ENTER;
import java.awt.event.KeyListener;
import javax.swing.JTextArea;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;


public class OyenteBox implements CaretListener, KeyListener {
        
    Vista vista;
    Actualizador modelo;

    public OyenteBox(Vista vista, Actualizador modelo) {
        this.vista = vista;
        this.modelo = modelo;
    }
      
    public void caretUpdate(CaretEvent e) { //Actualizacion del apuntador al escribir
        modelo.actualizarApuntador(vista, e);
    }
 
    @Override
    public void keyTyped(KeyEvent e) { 
    }

    @Override
    public void keyPressed(KeyEvent e) { //Tecla pusheada
        
        if(e.getKeyCode()==VK_ENTER)
        {
            modelo.rowCounter++;
            modelo.actualizarCounter(vista);
        }
        
        if( (modelo.columna==0 && e.getKeyCode()==VK_BACK_SPACE) && modelo.linea!=1  )
        {
            System.out.print("Salto");
            modelo.rowCounter--;
            modelo.actualizarCounter(vista);
        }
        modelo.editado=true;
        modelo.guardado=false;
    }

    @Override
    public void keyReleased(KeyEvent e) { //Tecla Soltada   
        modelo.actualizarBloqueo(vista);
    }
    


}

