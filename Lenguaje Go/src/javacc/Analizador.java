package javacc;

import java.awt.Image;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Hashtable;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class Analizador extends javax.swing.JFrame {
    String[] deshacer = new String[100];
    int deshacerN=0;
    private Hashtable<String,String> tablaid = new Hashtable<>();
    public Analizador() {
        initComponents();
        ErroresSemanticos.setSize(0,0);
        jButton5.setVisible(false);
        jScrollPane3.setVisible(false);
        setIconImage(new ImageIcon(getClass().getResource("../iconos/go_icon.png")).getImage());
        AbrirArch.setIcon(new ImageIcon(this.getClass().getResource("../iconos/abrir.png")));
        BotonAnal.setIcon(new ImageIcon(this.getClass().getResource("../iconos/compilar.png")));
        BotonLimp.setIcon(new ImageIcon(this.getClass().getResource("../iconos/limpiar.png")));
        jButton1.setIcon(new ImageIcon(this.getClass().getResource("../iconos/go_icon.png")));
       
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        BotonAnal = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea2 = new javax.swing.JTextArea();
        jLabel2 = new javax.swing.JLabel();
        AbrirArch = new javax.swing.JButton();
        BotonLimp = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        ErroresSemanticos = new javax.swing.JTextArea();
        jLabel3 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        barra = new javax.swing.JMenuBar();
        archivo = new javax.swing.JMenu();
        abrir = new javax.swing.JMenuItem();
        funciones = new javax.swing.JMenu();
        compilar = new javax.swing.JMenuItem();
        limpiar = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Lenguaje Go");
        setBackground(new java.awt.Color(0, 51, 255));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jPanel1.setBackground(new java.awt.Color(51, 51, 51));

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jTextArea1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextArea1KeyTyped(evt);
            }
        });
        jScrollPane1.setViewportView(jTextArea1);

        BotonAnal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonAnalActionPerformed(evt);
            }
        });

        jTextArea2.setEditable(false);
        jTextArea2.setColumns(20);
        jTextArea2.setRows(5);
        jScrollPane2.setViewportView(jTextArea2);

        AbrirArch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AbrirArchActionPerformed(evt);
            }
        });

        BotonLimp.setToolTipText("");
        BotonLimp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonLimpActionPerformed(evt);
            }
        });

        jButton5.setText("Deshacer");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        ErroresSemanticos.setEditable(false);
        ErroresSemanticos.setColumns(20);
        ErroresSemanticos.setRows(5);
        ErroresSemanticos.setName(""); // NOI18N
        ErroresSemanticos.setPreferredSize(null);
        jScrollPane3.setViewportView(ErroresSemanticos);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(AbrirArch)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(BotonAnal)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(BotonLimp)
                        .addGap(17, 17, 17)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 9, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 680, Short.MAX_VALUE)
                            .addComponent(jScrollPane2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(324, 324, 324))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(AbrirArch, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(BotonAnal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(BotonLimp, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(132, 132, 132)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 166, Short.MAX_VALUE)
                        .addComponent(jLabel3))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2)))
                .addContainerGap())
        );

        archivo.setText("Archivo");

        abrir.setText("Abrir Archivo");
        abrir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                abrirActionPerformed(evt);
            }
        });
        archivo.add(abrir);

        barra.add(archivo);

        funciones.setText("Funciones");
        funciones.setName(""); // NOI18N

        compilar.setText("Compilar");
        compilar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                compilarActionPerformed(evt);
            }
        });
        funciones.add(compilar);

        limpiar.setText("Limpiar");
        limpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                limpiarActionPerformed(evt);
            }
        });
        funciones.add(limpiar);

        barra.add(funciones);

        setJMenuBar(barra);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 701, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void abrirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_abrirActionPerformed
        try {
            analizar2();
        } catch (IOException ex) {
            System.out.println("Parece que ocurrió un error.");
        }
    }//GEN-LAST:event_abrirActionPerformed

    private void compilarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_compilarActionPerformed
        try {
            analizar1();
           
        } catch (IOException ex) {
            System.out.println("Parece que ocurrio un error.");
           
        }
    }//GEN-LAST:event_compilarActionPerformed

    private void limpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_limpiarActionPerformed
        jTextArea1.setText("");
        jTextArea2.setText("");
        
        this.setTitle("Lenguaje Go");
    }//GEN-LAST:event_limpiarActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        if(deshacerN!=0){
            deshacerN--;
            jTextArea1.setText(deshacer[deshacerN]);
        }
    }//GEN-LAST:event_jButton5ActionPerformed

    private void BotonLimpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonLimpActionPerformed
        jTextArea1.setText("");
        jTextArea2.setText("");

        this.setTitle("Lenguaje Go");
    }//GEN-LAST:event_BotonLimpActionPerformed

    private void AbrirArchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AbrirArchActionPerformed
        try {
            analizar2();
        } catch (IOException ex) {
            System.out.println("Parece que ocurrió un error.");
        }
    }//GEN-LAST:event_AbrirArchActionPerformed

    private void BotonAnalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonAnalActionPerformed
        try {
            analizar1();
            System.out.println("Variables declaradas "+VerificacionToken.mostrar());
            if(!LenguajeGo.erroresS.equals("")){
            JOptionPane.showMessageDialog(null,"Total de errores semanticos: "+LenguajeGo.nerroresS+"\n"+LenguajeGo.erroresS,"ERRORES SEMANTICOS",JOptionPane.INFORMATION_MESSAGE);
            }
            LenguajeGo.erroresS="";
            LenguajeGo.nerroresS=0;
            VerificacionToken.vaciar();

        } catch (IOException ex) {
            System.out.println("Parece que ocurrio un error.");

        }
    }//GEN-LAST:event_BotonAnalActionPerformed

    private void jTextArea1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextArea1KeyTyped
        deshacer[deshacerN]=jTextArea1.getText();
        deshacerN++;
    }//GEN-LAST:event_jTextArea1KeyTyped

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Analizador().setVisible(true);
               
                
            }
        });
    }

    public void analizar2() throws IOException{
        String DireccionTemporal="";           
        JFileChooser fileChooser = new JFileChooser();
        //fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
        File dir = new File("EjemplosGO");
        
        fileChooser.setCurrentDirectory(dir);
        
        int result = fileChooser.showOpenDialog(this);
        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            DireccionTemporal=selectedFile.getAbsolutePath();
            this.setTitle(selectedFile.getName()+" - Archivo de Lenguaje Go");
            FileReader fr = new FileReader(selectedFile);
            BufferedReader br = new BufferedReader(fr);
            String LineaP;
            String LineaT="";
            while((LineaP=br.readLine())!=null) LineaT=LineaT+LineaP+"\n";
            jTextArea1.setText(LineaT);
            jTextArea2.setText("");
            //ErroresSemanticos.setText("");
            
        }
        deshacerN=0;
        deshacer[deshacerN]=jTextArea1.getText();
        deshacerN++;
        
    }
    
    public void analizar1() throws IOException{
        String DireccionTemporal =  System.getProperty("java.io.tmpdir")+"temp.txt";
        File archivo = new File(DireccionTemporal);  
        FileWriter fw = new FileWriter(archivo);  
        BufferedWriter bw = new BufferedWriter(fw);  
        
        bw.write(jTextArea1.getText());  
        
        bw.flush();  
        bw.close(); 
                 
        String nombre = new String (DireccionTemporal);
        LenguajeGo lex1 = new LenguajeGo(new FileInputStream(nombre));
        /*lex1.setTextArea(ErroresSemanticos);
       
          ErroresSemanticos.setText("");*/
        String resultado = "";
        try {
            lex1.procesar(); //Procesamiento de lexemas
            //lex1.Programa();
            resultado= lex1.resultado;
            jTextArea2.setText(resultado);
        } catch (Exception e){
            System.out.println(e.getMessage());
        } catch (Error e){
            System.out.println(e.getMessage());//Mensaje de error lexico
        }
        LenguajeGo lex2 = new LenguajeGo(new FileInputStream(nombre));
        try {
            //lex2.procesar(); //Procesamiento de lexemas
            lex2.prog();
        } catch (Exception e){
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(null,"Análisis Terminados.","FIN DEL ANALISIS",JOptionPane.INFORMATION_MESSAGE);
        } catch (Error e){
            System.out.println(e.getMessage());//Mensaje de error lexico
        }
        //
        
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AbrirArch;
    private javax.swing.JButton BotonAnal;
    private javax.swing.JButton BotonLimp;
    private javax.swing.JTextArea ErroresSemanticos;
    private javax.swing.JMenuItem abrir;
    private javax.swing.JMenu archivo;
    private javax.swing.JMenuBar barra;
    private javax.swing.JMenuItem compilar;
    private javax.swing.JMenu funciones;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextArea jTextArea2;
    private javax.swing.JMenuItem limpiar;
    // End of variables declaration//GEN-END:variables
}
