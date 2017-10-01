import javax.swing.*;
import java.awt.*;
import javax.swing.plaf.basic.BasicSplitPaneDivider;
import javax.swing.plaf.basic.BasicSplitPaneUI;
import javax.swing.border.Border;

public class Vista extends JFrame {

    JMenuBar barra; //Barra de menú
    JMenu archivo, compiler, ayuda; //Menús de la barra anterior
    JMenuItem a, b, c, d, e, f, g, h; //Opciones del menú
    JButton nuevo, abrir, guardar, salir, compilar, light; //Botones
    public JTextArea input, numeros;
    public ImageIcon im2, im1;
    JLabel icono;
    JPanel iconPane;
    TextoColor output,output2;
    JSplitPane principal, sp,sl;
	JPanel central ;
	String errores;
	int numErr;
    
    
    public Vista() {
        acomodar();
    }

    public void acomodar() {
        this.setTitle("R");
        this.setSize(1360, 720);
        this.setDefaultCloseOperation(3);
        //this.setLocation(550,30);
        
        //Titulo
        Image icon = new ImageIcon(getClass().getResource("/iconos/R.png")).getImage();
        setIconImage(icon);

        //Barra de Menú Superior
        barra = new JMenuBar();

        archivo = new JMenu("Archivo");
        compiler = new JMenu("Compilador");
        ayuda = new JMenu("Ayuda");

        a = new JMenuItem("Nuevo");
        a.setName("nuevo");
        b = new JMenuItem("Abrir");
        b.setName("abrir");
        c = new JMenuItem("Guardar");
        c.setName("guardar");
        d = new JMenuItem("Salir");
        d.setName("salir");
        e = new JMenuItem("Compilar");
        e.setName("compilar");
        f = new JMenuItem("R On/Off");
        f.setName("luz");
        g = new JMenuItem("Acerca de");
        g.setName("acerca");
        h= new JMenuItem("Guardar Como");
        h.setName("guardarcomo");
        
        ayuda.add(g);

        archivo.add(a);
        archivo.add(b);
        archivo.add(c);
        archivo.add(h);
        archivo.add(new JSeparator());
        archivo.add(d);

        compiler.add(e);
        compiler.add(new JSeparator());
        compiler.add(f);
        compiler.add(new JSeparator());

        barra.add(archivo);
        barra.add(compiler);
        barra.add(ayuda);
        barra.setBorder(BorderFactory.createRaisedSoftBevelBorder());

        //Barra de Botones Superior
        JToolBar botones = new JToolBar();
        botones.setBorder(BorderFactory.createRaisedSoftBevelBorder());

        nuevo = new JButton();
        abrir = new JButton();
        guardar = new JButton();
        salir = new JButton();
        compilar = new JButton();
        light = new JButton();

        nuevo.setName("nuevo");
        abrir.setName("abrir");
        guardar.setName("guardar");
        salir.setName("salir");
        compilar.setName("compilar");
        light.setName("luz");

        //Asignación de iconos
        nuevo.setIcon(new ImageIcon(getClass().getResource("/iconos/nuevo.png")));
        abrir.setIcon(new ImageIcon(getClass().getResource("/iconos/abrir.png")));
        guardar.setIcon(new ImageIcon(getClass().getResource("/iconos/guardar.png")));
        salir.setIcon(new ImageIcon(getClass().getResource("/iconos/cerrar.png")));
        compilar.setIcon(new ImageIcon(getClass().getResource("/iconos/compilar.png")));
        light.setIcon(new ImageIcon(getClass().getResource("/iconos/luz.png")));
        botones.add(light);
        nuevo.setToolTipText("Nuevo");
        abrir.setToolTipText("Abrir Archivo");
        guardar.setToolTipText("Guardar Archivo");
        salir.setToolTipText("Salir");
        compilar.setToolTipText("Compilar");
        light.setToolTipText("Encender/Apagar");
        a.setToolTipText("Nuevo");
        b.setToolTipText("Abrir Archivo");
        c.setToolTipText("Guardar Archivo");
        d.setToolTipText("Salir");
        e.setToolTipText("Compilar");
        f.setToolTipText("Encender/Apagar");
        g.setToolTipText("Acerca de los desarrolladores");
        h.setToolTipText("Guardar como...");

        //Opciones Visuales
        nuevo.setFocusPainted(false);
        abrir.setFocusPainted(false);
        guardar.setFocusPainted(false);
        salir.setFocusPainted(false);
        compilar.setFocusPainted(false);
        light.setFocusPainted(false);
        botones.add(nuevo);
        botones.add(abrir);
        botones.add(guardar);
        botones.add(salir);
        botones.add(compilar);

        //Panel Central
        JPanel centro = new JPanel();
		

        //Panel     ENTRADA
        JPanel in = new JPanel();
        Font fuente = new Font("Consolas", Font.PLAIN, 14);
        numeros = new JTextArea();
        numeros.setColumns(2);
        numeros.append("1");
        numeros.setBackground(Color.LIGHT_GRAY);
        numeros.setEditable(false);
        numeros.setFocusable(false);
        numeros.setFont(fuente);
        input = new JTextArea();
        input.setFont(fuente);
        input.setBackground(Color.WHITE);
        in.setLayout(new BorderLayout());
        in.add(numeros, BorderLayout.WEST);
        in.add(input, BorderLayout.CENTER);
        in.setBorder(null);
        JScrollPane scroll1 = new JScrollPane(in);
        scroll1.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));

		
        //Panel del icono
        im1 = new ImageIcon(getClass().getResource("/iconos/R1.png")); //Icono encendido
        im2 = new ImageIcon(getClass().getResource("/iconos/R2.png")); //Icono apagado
        iconPane = new JPanel();
        iconPane.setBackground(Color.white);
        icono = new JLabel();
        icono.setIcon(im1);
        //JPanel pc= new JPanel();//no se que hace
        //pc.add(icono);//tampoco se que hace
        JPanel border = new JPanel(new BorderLayout());
        border.add(icono, BorderLayout.CENTER);
        iconPane.add(border);
        iconPane.setBorder(null);
        sp = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, scroll1, iconPane); 
        sp.setBorder(null);iconPane.add(icono, BorderLayout.CENTER);
       // sp.setDividerSize(0);Esto no sirve por que ya lo tiene el principal

        //PANEL SALIDA lexico
        output = new TextoColor();
        JScrollPane out = new JScrollPane(output);
        out.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
        //PANEL SALIDA sintactico
        output2 = new TextoColor();
         JScrollPane out2 = new JScrollPane(output2);
        out.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
        //agrego los dos a unos solo uwu
        sl = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, out, out2); 
        
        ///CREACION DEL SPLIT
        principal = new JSplitPane(JSplitPane.VERTICAL_SPLIT, sp, sl);
        principal.setBorder(null);
        principal.setDividerSize(8);
        central= new JPanel();
        central.setBorder(BorderFactory.createLineBorder(Color.WHITE, 25));
        central.setLayout(new BorderLayout());
        central.add(principal);

        //Acomodo del panel central
        centro.setLayout(new BorderLayout());
        centro.add(botones, BorderLayout.NORTH);
        centro.add(central, BorderLayout.CENTER);
        centro.setBorder(null);
        //Otras opciones
        
        nuevo.setEnabled(false);
        guardar.setEnabled(false);
        compilar.setEnabled(false);
        a.setEnabled(false);
        c.setEnabled(false);
        e.setEnabled(false);
        h.setEnabled(false);
        
        output.setEditable(false);
        output2.setEditable(false);
        
        colorearSplit(principal, Color.WHITE);
        colorearSplit(sp, Color.white);
       
        
        this.setTitle("<Nuevo> - R");
        //Acomodo General
        this.add(barra, BorderLayout.NORTH);
        this.add(barra, BorderLayout.NORTH);
        this.add(centro, BorderLayout.CENTER);
        this.setVisible(true);
         principal.setDividerLocation(0.7);
        sp.setDividerLocation(0.9);
        sl.setDividerLocation(0.5);
        this.setLocationRelativeTo(null);
        //welcome w= new welcome(this, true);
       // w.setLocationRelativeTo(null);
        
    }

    public void paint(Graphics g) {
        super.paint(g);     
    }

    public void colorearSplit(JSplitPane splitPane, Color color) {
        splitPane.setUI(new BasicSplitPaneUI() {
            public BasicSplitPaneDivider createDefaultDivider() {
                return new BasicSplitPaneDivider(this) {
                    public void setBorder(Border b) {
                    }

                    @Override
                    public void paint(Graphics g) {
                        g.setColor(color);
                        g.fillRect(0, 0, getSize().width, getSize().height);
                        super.paint(g);
                    }
                };
            }
        });
        splitPane.setBorder(null);
    }

    public void addEventoCounter(OyenteBox box) {
        this.input.addCaretListener(box);
        this.input.addKeyListener(box);
    }

    public void addEventoBotones(OyenteBotones oye) {
        a.addActionListener(oye);
        b.addActionListener(oye);
        c.addActionListener(oye);
        d.addActionListener(oye);
        e.addActionListener(oye);
        f.addActionListener(oye);
        g.addActionListener(oye);
        h.addActionListener(oye);
        nuevo.addActionListener(oye);
        abrir.addActionListener(oye);
        guardar.addActionListener(oye);
        salir.addActionListener(oye);
        compilar.addActionListener(oye);
        light.addActionListener(oye);
    }
       
}

