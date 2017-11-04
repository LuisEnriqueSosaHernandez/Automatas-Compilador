

public class Actualizador {

    int linea = 1;  //en que fila y columna está el cursor
    int columna = 1;
    int rowCounter = 1; //Cuantos renglones tiene el codigo
    public boolean editado = false; //Para saber si el text box ha sido editado
    public boolean vacio = true; //Para saber si está vacío
    public boolean guardado=false;
    String nombre; //El nombre del archivo

    //**********G   E   S   T   I   O   N       D   E       A   R   C   H   I   V   O   S  ******************
    //Función para preguntar si deseamos guardar cambios
    public void preguntar(Vista vista) {
        
        if(!guardado){
        
        if (!this.vacio) {
            int seleccion2 = JOptionPane.showOptionDialog(
                    vista,
                    "¿Guardar Archivo?",
                    "Desea Guardar el Archivo Actual?",
                    JOptionPane.YES_NO_CANCEL_OPTION,
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    null,
                    "opcion 1");
            if (seleccion2 == JOptionPane.YES_OPTION) {
                guardar(vista);
            }
        }
    }
    }
    //Funcion para abrir un nuevo archivo de texto
    public void abrir(Vista vista) {
        preguntar(vista);

        String name = "";
        JFileChooser seleccion = new JFileChooser();
        seleccion.setCurrentDirectory(new File("C:\\Light"));
        FileNameExtensionFilter filtro = new FileNameExtensionFilter("Codigo Fuente Light", "light");
        seleccion.setFileFilter(filtro);
        int opcion = seleccion.showOpenDialog(vista);
        if (opcion == JFileChooser.APPROVE_OPTION) {
            name = "" + seleccion.getSelectedFile();
            vista.setTitle("<" + seleccion.getSelectedFile().getPath() + ">" + " -Light");
        }
        if (name != "") {
            leerArchivo(name, vista);
        }
        
        this.guardado=true;
        this.editado=false;
    }

    //Funcion al cerrar la ventana
    public void salir(Vista vista) {
        preguntar(vista);
//        if (JOptionPane.showConfirmDialog(vista, "Esta seguro de que quiere salir?",
//                "Salir", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
            System.exit(0);
//        }
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
        preguntar(vista);
        vista.input.setText("");
        vista.input.setText("");
        vista.numeros.setText("");
        this.linea=this.columna=this.rowCounter=1;
         editado = false;
         vacio = true; 
        nombre="";
    }

//Funcion para guardar el contenido
    public void guardar(Vista vista) {

        JFileChooser guardo = new JFileChooser();
        guardo.setCurrentDirectory(new File("C:\\Light"));
        FileNameExtensionFilter filtro = new FileNameExtensionFilter("Codigo Fuente Light", "light");
        guardo.setFileFilter(filtro);

        int opcion = guardo.showSaveDialog(vista);

        if (opcion == JFileChooser.APPROVE_OPTION) {
            //Crea el archivo
            File archivo;
            nombre = anadirExtension(guardo.getSelectedFile().getPath());
            vista.setTitle("<" + nombre + ">" + " -Light ");
            archivo = new File(nombre);
            this.guardado=true;
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
                //  guardado=true;
            } catch (IOException ex) {
                System.out.println("Error al escribir");
            }
        }
    }

    public String anadirExtension(String nombre) {
        String ext = nombre.substring(nombre.length() - 6, nombre.length());
        if (!ext.equals(".light")) {
            nombre = nombre + ".light";
        }

        System.out.println("Nombre " + nombre);
        System.out.println("Extension " + ext);

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
        actualizarCounter(vista);
    }

    public void bloqDesbloq(boolean bloq, Vista vista) {
        vista.guardar.setEnabled(bloq);
        vista.compilar.setEnabled(bloq);
        vista.nuevo.setEnabled(bloq);
        vista.a.setEnabled(bloq);
        vista.c.setEnabled(bloq);
        vista.e.setEnabled(bloq);
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

    
    public void compilar(Vista vista)
    {
                guardar(vista);
        if(guardado){
		vista.output.setText("");
		//if(vista.encendido==true){output.setForeground(Color.black);}
		//else {output.setForeground(Color.white);}
	
            vista.output.append(">>ANALISIS L\u00c9XICO INICIADO...");
            vista.output.append("\n\tValor\t\t\tTipo");
            vista.output.append("\n=============================================================\n");
            Compilador.analiza(nombre, this);
            
            vista.output.append("\n\t************FASE L\u00c9XICA TERMINADA************");
             JOptionPane.showMessageDialog(null,"ANALISIS L\u00c9XICO TERMINADO", "Analisis Finalizado", JOptionPane.INFORMATION_MESSAGE, null);
			
        
		
	}
    }
}
