
package gestorcampania.Vent;
import gestorcampania.GestorCampania;
import gestorcampania.ControladorCampania;
import gestorcampania.herramientas.ValidadorCamposDeVentana;
import java.time.LocalDate;
import javax.swing.JOptionPane;

/*Ventana encargada de mostrar la interfaz para modificar una campaña en especifico*/
public class ModificarCampania extends javax.swing.JFrame {
    private GestorCampania gestor;
    private ControladorCampania controlador;
    private ValidadorCamposDeVentana validadorCampos;
    
    public ModificarCampania(GestorCampania gestor){
        initComponents();
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);/*Para cerrar unicamente esta ventana y que no cierre todo el programa*/
        this.gestor = gestor;
        validadorCampos = new ValidadorCamposDeVentana();/*Validacion de diferentes campos segun lo requerido*/
    }
    public ModificarCampania() {
        initComponents();
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);/*Para cerrar unicamente esta ventana y que no cierre todo el programa*/
        validadorCampos = new ValidadorCamposDeVentana();/*Validacion de diferentes campos segun lo requerido*/
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtFecha = new javax.swing.JTextField();
        txtUbicacion = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtIdCampania = new javax.swing.JTextField();
        txtNombre = new javax.swing.JTextField();
        btnModificar = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel5.setText("Ubicacion");

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("Modificar campaña");

        jLabel2.setText("ID campaña:");

        jLabel3.setText("Nombre:");

        btnModificar.setText("Modificar");
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });

        jLabel4.setText("Fecha (AÑO-MES-DIA): ");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(317, 317, 317)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtIdCampania)
                            .addComponent(txtNombre)
                            .addComponent(txtFecha)
                            .addComponent(txtUbicacion, javax.swing.GroupLayout.DEFAULT_SIZE, 190, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addComponent(btnModificar)))
                .addContainerGap(229, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(347, 347, 347))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtIdCampania, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(txtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(txtUbicacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnModificar))
                .addContainerGap(153, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /*Boton encargado de hacer la accion para modificar una campaña*/
    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        String texto = txtIdCampania.getText();
        int idCampania;
        if(validadorCampos.esNumInt(texto) == true){/*Valida que sea de tipo numerico*/
            idCampania = Integer.parseInt(texto);
        }else{
            JOptionPane.showMessageDialog(this, "Debe ingresar un número entero válido.");
            return;
        }
        
        texto = txtNombre.getText();
        String nombre;
        if(validadorCampos.esTexto(texto) == true){/*Valida que no contenga valores numericos*/
            nombre = texto;
        }else{
            JOptionPane.showMessageDialog(this, "Debe ingresar un texto valido (no vacio ni con numeros)");
            return;
        }
        
        texto = txtUbicacion.getText();
        String ubicacion;
        if(validadorCampos.esTexto(texto) == true){/*Valida que no contenga valores numericos*/
            ubicacion = texto;
        }else{
            JOptionPane.showMessageDialog(this, "Debe ingresar un texto valido (no vacio ni con numeros)");
            return;
        }
        
        texto = txtFecha.getText();
        LocalDate fecha;
        controlador = new ControladorCampania(this.gestor);
        /*Implementar una modificacion pero sin ingreso de la fecha por el usuario(se agrega de forma automatica la fecha actual*/
        if(texto.equals("")){
            controlador.modificarCampania(idCampania, nombre, ubicacion);
            
        /*Implementa la modificacion con una fecha asignada por el usuario*/
        }else{
            if(validadorCampos.esFecha(texto) == true){/*Valida que se haya ingresado correctamente una fecha en el orden pedido */
                fecha = LocalDate.parse(texto);
            }else{
                JOptionPane.showMessageDialog(this, "Debe ingresar una fecha correcta (AÑO-MES-DIA)");
                return;
            }
            controlador.modificarCampania(idCampania,nombre, fecha, ubicacion);
        }
    }//GEN-LAST:event_btnModificarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnModificar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JTextField txtFecha;
    private javax.swing.JTextField txtIdCampania;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtUbicacion;
    // End of variables declaration//GEN-END:variables
}
