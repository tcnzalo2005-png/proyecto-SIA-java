
package gestorcampania.Vent;
import gestorcampania.GestorCampania;
import gestorcampania.ControladorCampania;
import gestorcampania.herramientas.ValidadorCamposDeVentana;
import java.time.LocalDate;
import javax.swing.JOptionPane;

/*Ventana encargada de mostrar la interfaz para poder crear una campaña movil*/
public class CrearCampaniaMovil extends javax.swing.JFrame {
    private GestorCampania gestor;
    private ControladorCampania controlador;
    private ValidadorCamposDeVentana validadorCampos;
   
    public CrearCampaniaMovil(GestorCampania gestor){
        initComponents();
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);/*Para cerrar unicamente esta ventana y que no cierre todo el programa*/
        this.gestor = gestor;
        validadorCampos = new ValidadorCamposDeVentana();/*Validacion de diferentes campos segun lo requerido*/
    }
    public CrearCampaniaMovil() {
        initComponents();
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);/*Para cerrar unicamente esta ventana y que no cierre todo el programa*/
        validadorCampos = new ValidadorCamposDeVentana();/*Validacion de diferentes campos segun lo requerido*/
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtIdCampania = new javax.swing.JTextField();
        txtNombre = new javax.swing.JTextField();
        txtFecha = new javax.swing.JTextField();
        txtUbicacion = new javax.swing.JTextField();
        btnCrear = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("Crear campaña movil");

        jLabel2.setText("ID campaña:");

        jLabel3.setText("Nombre:");

        jLabel4.setText("Fecha (AÑO-MES-DIA):");

        jLabel5.setText("Ubicacion:");

        btnCrear.setText("Crear");
        btnCrear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCrearActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtIdCampania))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(8, 8, 8)
                        .addComponent(txtFecha, javax.swing.GroupLayout.DEFAULT_SIZE, 155, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtNombre))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(8, 8, 8)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnCrear)
                            .addComponent(txtUbicacion))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtIdCampania, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(txtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtUbicacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addComponent(btnCrear)
                .addContainerGap(87, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(311, 311, 311)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(256, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(295, 295, 295))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(70, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /*Boton encargado de hacer la accion para crear una campaña movil*/
    private void btnCrearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrearActionPerformed
        String texto = txtIdCampania.getText();
        int idCampania = 0;
        if(validadorCampos.esNumInt(texto) == true){/*Valida que sea de tipo numerico*/
             idCampania = Integer.parseInt(texto);
        }else{
            JOptionPane.showMessageDialog(this, "Debe ingresar un número entero válido.");
            return;
        }
        
        texto = txtNombre.getText();
        String nombre;
        if(validadorCampos.esTexto(texto) == true){/*Valida que no contenga datos numericos*/
            nombre = texto;
        }else{
            JOptionPane.showMessageDialog(this, "Debe ingresar un texto valido (no vacion ni con numeros)");
            return;
        }
        
        texto = txtUbicacion.getText();
        String ubicacion;
        if(validadorCampos.esTexto(texto) == true){/*Valida que no contenga datos numericos*/
            ubicacion = texto;
        }else{
            JOptionPane.showMessageDialog(this, "Debe ingresar un texto valido (no vacion ni con numeros)");
            return;
        }
        
        texto = txtFecha.getText();
        LocalDate fecha;
        controlador = new ControladorCampania(this.gestor);
        if(texto.equals("")){/*Permite al sistema de forma automatica ingresar la fecha actual si el campo de la fecha esta vacia*/
            controlador.crearCampaniaMovil(idCampania, nombre, ubicacion);
        }else{
            if(validadorCampos.esFecha(texto) == true){/*Valida que contenga una fecha correcta y en el orden pedido*/
                fecha = LocalDate.parse(texto);
            }else{
                JOptionPane.showMessageDialog(this, "Debe ingresar una fecha correcta (AÑO-MES-DIA)");
                return;
            }
            controlador.crearCampaniaMovil(idCampania,nombre, fecha, ubicacion);
        }
    }//GEN-LAST:event_btnCrearActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCrear;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField txtFecha;
    private javax.swing.JTextField txtIdCampania;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtUbicacion;
    // End of variables declaration//GEN-END:variables
}
