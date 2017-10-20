using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;
using System.Diagnostics;
using System.IO;

namespace AnalisisLexico
{
    public partial class  Form1 : Form

    {
        OpenFileDialog BuscarArchivotxt = new OpenFileDialog();
        SaveFileDialog GuardarArchivotxt = new SaveFileDialog();
        string name = "";
        public Form1()
        {
            InitializeComponent();
        }

        private void Form1_Load(object sender, EventArgs e)
        {

        }

        private void AbrirArchivo_Click(object sender, EventArgs e)
        {
            try
            {
                
                BuscarArchivotxt.Filter = "Flip Flop Compiler(*.flip)|*.flip|Todos los archivos (*.*)|*.*";
                BuscarArchivotxt.Title = "Abrir el archivo de Texto Flip Flop";
                string CombinedPath = System.IO.Path.Combine(Directory.GetCurrentDirectory(), "..\\..\\archivos");
                BuscarArchivotxt.InitialDirectory = System.IO.Path.GetFullPath(CombinedPath);
               
                if (BuscarArchivotxt.ShowDialog() == System.Windows.Forms.DialogResult.OK)
                {
                    System.IO.StreamReader LeerArchivo = new
                    System.IO.StreamReader(BuscarArchivotxt.FileName);
                    MessageBox.Show("Archivo abierto correctamente!");
                    string txt = File.ReadAllText(BuscarArchivotxt.FileName);
                    textBox1.Text = txt;
                    Ruta.Text = BuscarArchivotxt.FileName;
                    name = BuscarArchivotxt.FileName;
                    LeerArchivo.Close();
                }
                }catch (Exception)
                {
                    MessageBox.Show("Ocurrio un problema, vuelve a intentarlo");
                    Console.WriteLine("Error al abrir", e);
                }
        }

        private void GuardarArchivo_Click(object sender, EventArgs e)
        {
            try
            {
                File.WriteAllText(BuscarArchivotxt.FileName, textBox1.Text);
                MessageBox.Show("Archivo guardado correctamente!");
            }catch (Exception)
            {
                MessageBox.Show("Ocurrio un problema, o el Archivo esta vacio");
                Console.WriteLine("Error al guardar", e);
            }
        }

        private void GuardarComo_Click(object sender, EventArgs e)
        {
            try
            {
                GuardarArchivotxt.Filter = "Flip Flop Compiler(*.flip)|*.flip|Todos los archivos (*.*)|*.*";
                GuardarArchivotxt.Title = "Guardar el archivo de Texto Flip Flop";
                if (GuardarArchivotxt.ShowDialog() == DialogResult.OK)
                {
                    File.WriteAllText(GuardarArchivotxt.FileName, textBox1.Text);
                    MessageBox.Show("Archivo guardado correctamente!");
                }
            }catch (Exception)
            {
                MessageBox.Show("Ocurrio un problema, vuelve a intentarlo");
                Console.WriteLine("Error al guardar como", e);
            }
            GuardarArchivotxt.Dispose();
        }

        private void NuevoArchivo_Click(object sender, EventArgs e)
        {
            MessageBox.Show("Archivo en Blanco, <empieza a programar!>");
            textBox1.Text = "";
        }

        private void CerrarPrograma_Click(object sender, EventArgs e)
        {
            Application.Exit();
        }

        private void textBox2_TextChanged(object sender, EventArgs e)
        {

        }

        private void Compilar_Click(object sender, EventArgs e)
             
        {
            textBox2.Clear();
            string uno = "";
            string dos = "";
            string result = "";
            for (int i = name.Length - 1; i >= 0; i--)
            {
                if (Convert.ToChar(name.Substring(i, 1)) == 92)
                {
                    break;
                }

                uno += name.Substring(i, 1);
            }
            for (int i = uno.Length -1;i >= 0; i--)
            {
                dos +=uno.Substring(i, 1);
            }

            Process compiladorlexico = new Process();
            compiladorlexico.StartInfo.UseShellExecute = false;
            compiladorlexico.StartInfo.RedirectStandardOutput = true;
            compiladorlexico.StartInfo.FileName = "Compilable.exe";
            compiladorlexico.StartInfo.Arguments = "../../archivos/"+dos;//esto es para maquinas feas
            //compiladorlexico.StartInfo.Arguments = name;//para mi maquina que es chida
            compiladorlexico.Start();
            result = compiladorlexico.StandardOutput.ReadToEnd();
            compiladorlexico.WaitForExit();
            textBox2.AppendText(result);
        }
    }
}
