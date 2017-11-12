namespace AnalisisLexico
{
    partial class Form1
    {
        /// <summary>
        /// Variable del diseñador necesaria.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        /// Limpiar los recursos que se estén usando.
        /// </summary>
        /// <param name="disposing">true si los recursos administrados se deben desechar; false en caso contrario.</param>
        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null))
            {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        #region Código generado por el Diseñador de Windows Forms

        /// <summary>
        /// Método necesario para admitir el Diseñador. No se puede modificar
        /// el contenido de este método con el editor de código.
        /// </summary>
        private void InitializeComponent()
        {
            this.components = new System.ComponentModel.Container();
            System.ComponentModel.ComponentResourceManager resources = new System.ComponentModel.ComponentResourceManager(typeof(Form1));
            this.AbrirArchivo = new System.Windows.Forms.Button();
            this.NuevoArchivo = new System.Windows.Forms.Button();
            this.GuardarArchivo = new System.Windows.Forms.Button();
            this.Compilar = new System.Windows.Forms.Button();
            this.CerrarPrograma = new System.Windows.Forms.Button();
            this.label1 = new System.Windows.Forms.Label();
            this.textBox2 = new System.Windows.Forms.TextBox();
            this.label2 = new System.Windows.Forms.Label();
            this.GuardarComo = new System.Windows.Forms.Button();
            this.Ruta = new System.Windows.Forms.Label();
            this.toolTip1 = new System.Windows.Forms.ToolTip(this.components);
            this.richTextBox1 = new System.Windows.Forms.RichTextBox();
            this.pictureBox1 = new System.Windows.Forms.PictureBox();
            this.timer1 = new System.Windows.Forms.Timer(this.components);
            ((System.ComponentModel.ISupportInitialize)(this.pictureBox1)).BeginInit();
            this.SuspendLayout();
            // 
            // AbrirArchivo
            // 
            this.AbrirArchivo.Image = ((System.Drawing.Image)(resources.GetObject("AbrirArchivo.Image")));
            this.AbrirArchivo.Location = new System.Drawing.Point(55, 12);
            this.AbrirArchivo.Name = "AbrirArchivo";
            this.AbrirArchivo.Size = new System.Drawing.Size(37, 37);
            this.AbrirArchivo.TabIndex = 0;
            this.toolTip1.SetToolTip(this.AbrirArchivo, "Abrir Archivo");
            this.AbrirArchivo.UseVisualStyleBackColor = true;
            this.AbrirArchivo.Click += new System.EventHandler(this.AbrirArchivo_Click);
            // 
            // NuevoArchivo
            // 
            this.NuevoArchivo.Image = ((System.Drawing.Image)(resources.GetObject("NuevoArchivo.Image")));
            this.NuevoArchivo.Location = new System.Drawing.Point(12, 12);
            this.NuevoArchivo.Name = "NuevoArchivo";
            this.NuevoArchivo.Size = new System.Drawing.Size(37, 37);
            this.NuevoArchivo.TabIndex = 1;
            this.toolTip1.SetToolTip(this.NuevoArchivo, "Nuevo Archivo");
            this.NuevoArchivo.UseVisualStyleBackColor = true;
            this.NuevoArchivo.Click += new System.EventHandler(this.NuevoArchivo_Click);
            // 
            // GuardarArchivo
            // 
            this.GuardarArchivo.Image = ((System.Drawing.Image)(resources.GetObject("GuardarArchivo.Image")));
            this.GuardarArchivo.Location = new System.Drawing.Point(98, 12);
            this.GuardarArchivo.Name = "GuardarArchivo";
            this.GuardarArchivo.Size = new System.Drawing.Size(37, 37);
            this.GuardarArchivo.TabIndex = 2;
            this.toolTip1.SetToolTip(this.GuardarArchivo, "Guardar");
            this.GuardarArchivo.UseVisualStyleBackColor = true;
            this.GuardarArchivo.Click += new System.EventHandler(this.GuardarArchivo_Click);
            // 
            // Compilar
            // 
            this.Compilar.Image = ((System.Drawing.Image)(resources.GetObject("Compilar.Image")));
            this.Compilar.Location = new System.Drawing.Point(184, 12);
            this.Compilar.Name = "Compilar";
            this.Compilar.Size = new System.Drawing.Size(37, 37);
            this.Compilar.TabIndex = 3;
            this.toolTip1.SetToolTip(this.Compilar, "Compilar");
            this.Compilar.UseVisualStyleBackColor = true;
            this.Compilar.Click += new System.EventHandler(this.Compilar_Click);
            // 
            // CerrarPrograma
            // 
            this.CerrarPrograma.Image = ((System.Drawing.Image)(resources.GetObject("CerrarPrograma.Image")));
            this.CerrarPrograma.Location = new System.Drawing.Point(626, 12);
            this.CerrarPrograma.Name = "CerrarPrograma";
            this.CerrarPrograma.Size = new System.Drawing.Size(37, 37);
            this.CerrarPrograma.TabIndex = 4;
            this.CerrarPrograma.UseVisualStyleBackColor = true;
            this.CerrarPrograma.Click += new System.EventHandler(this.CerrarPrograma_Click);
            // 
            // label1
            // 
            this.label1.AutoSize = true;
            this.label1.Font = new System.Drawing.Font("Calibri", 12F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.label1.Location = new System.Drawing.Point(80, 78);
            this.label1.Name = "label1";
            this.label1.Size = new System.Drawing.Size(152, 19);
            this.label1.TabIndex = 6;
            this.label1.Text = "Inserte su código aqui";
            // 
            // textBox2
            // 
            this.textBox2.Location = new System.Drawing.Point(379, 110);
            this.textBox2.Multiline = true;
            this.textBox2.Name = "textBox2";
            this.textBox2.Size = new System.Drawing.Size(284, 185);
            this.textBox2.TabIndex = 7;
            this.textBox2.TextChanged += new System.EventHandler(this.textBox2_TextChanged);
            // 
            // label2
            // 
            this.label2.AutoSize = true;
            this.label2.Font = new System.Drawing.Font("Calibri", 12F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.label2.Location = new System.Drawing.Point(471, 78);
            this.label2.Name = "label2";
            this.label2.Size = new System.Drawing.Size(105, 19);
            this.label2.TabIndex = 8;
            this.label2.Text = "Analisis Léxico";
            // 
            // GuardarComo
            // 
            this.GuardarComo.Image = ((System.Drawing.Image)(resources.GetObject("GuardarComo.Image")));
            this.GuardarComo.Location = new System.Drawing.Point(141, 12);
            this.GuardarComo.Name = "GuardarComo";
            this.GuardarComo.Size = new System.Drawing.Size(37, 37);
            this.GuardarComo.TabIndex = 9;
            this.toolTip1.SetToolTip(this.GuardarComo, "Guardar como...");
            this.GuardarComo.UseVisualStyleBackColor = true;
            this.GuardarComo.Click += new System.EventHandler(this.GuardarComo_Click);
            // 
            // Ruta
            // 
            this.Ruta.AutoSize = true;
            this.Ruta.Location = new System.Drawing.Point(14, 304);
            this.Ruta.Name = "Ruta";
            this.Ruta.Size = new System.Drawing.Size(0, 13);
            this.Ruta.TabIndex = 10;
            // 
            // richTextBox1
            // 
            this.richTextBox1.Location = new System.Drawing.Point(37, 110);
            this.richTextBox1.Name = "richTextBox1";
            this.richTextBox1.Size = new System.Drawing.Size(294, 185);
            this.richTextBox1.TabIndex = 11;
            this.richTextBox1.Text = "";
            // 
            // pictureBox1
            // 
            this.pictureBox1.Location = new System.Drawing.Point(1, 110);
            this.pictureBox1.Name = "pictureBox1";
            this.pictureBox1.Size = new System.Drawing.Size(30, 185);
            this.pictureBox1.TabIndex = 12;
            this.pictureBox1.TabStop = false;
            this.pictureBox1.Click += new System.EventHandler(this.pictureBox1_Click);
            this.pictureBox1.Paint += new System.Windows.Forms.PaintEventHandler(this.pictureBox1_Paint);
            // 
            // timer1
            // 
            this.timer1.Tick += new System.EventHandler(this.timer1_Tick);
            // 
            // Form1
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.BackColor = System.Drawing.SystemColors.ActiveCaption;
            this.ClientSize = new System.Drawing.Size(675, 326);
            this.Controls.Add(this.pictureBox1);
            this.Controls.Add(this.richTextBox1);
            this.Controls.Add(this.Ruta);
            this.Controls.Add(this.GuardarComo);
            this.Controls.Add(this.label2);
            this.Controls.Add(this.textBox2);
            this.Controls.Add(this.label1);
            this.Controls.Add(this.CerrarPrograma);
            this.Controls.Add(this.Compilar);
            this.Controls.Add(this.GuardarArchivo);
            this.Controls.Add(this.NuevoArchivo);
            this.Controls.Add(this.AbrirArchivo);
            this.Name = "Form1";
            this.Text = "Analisis Léxico";
            this.Load += new System.EventHandler(this.Form1_Load);
            ((System.ComponentModel.ISupportInitialize)(this.pictureBox1)).EndInit();
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.Button AbrirArchivo;
        private System.Windows.Forms.Button NuevoArchivo;
        private System.Windows.Forms.Button GuardarArchivo;
        private System.Windows.Forms.Button Compilar;
        private System.Windows.Forms.Button CerrarPrograma;
        private System.Windows.Forms.Label label1;
        private System.Windows.Forms.TextBox textBox2;
        private System.Windows.Forms.Label label2;
        private System.Windows.Forms.Button GuardarComo;
        private System.Windows.Forms.Label Ruta;
        private System.Windows.Forms.ToolTip toolTip1;
        private System.Windows.Forms.RichTextBox richTextBox1;
        private System.Windows.Forms.PictureBox pictureBox1;
        private System.Windows.Forms.Timer timer1;
    }
}

