import java.awt.Color;
import javax.swing.JTextPane;
import javax.swing.text.BadLocationException;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

public class TextoColor extends JTextPane {



    public void append(Color color, String texto) {
        StyledDocument doc = getStyledDocument();
        javax.swing.text.Style syle = doc.addStyle("txt", null);
        StyleConstants.setForeground(syle, color);
        try {
             doc.insertString(doc.getLength(), texto, syle);
             setCaretPosition(doc.getLength());
         } catch (BadLocationException ex) {
             ex.printStackTrace();
         }
    }



    public void appendRed(String texto) {
        append(Color.RED, texto);
    }


	public void appendBlue(String texto) {
        append(Color.BLUE, texto);
    }

	public void appendGreen(String texto) {
        append(Color.GREEN, texto);
    }
        
    public void appendYellow(String texto) {
        append(Color.YELLOW, texto);
    }   
    
    public void appendMagenta(String texto) {
        append(Color.MAGENTA, texto);
    } 
    

    public void append(String texto) {
        append(Color.BLACK, texto);
    }
    


}
