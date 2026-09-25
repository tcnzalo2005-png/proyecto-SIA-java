
package gestorcampania.Vent;
import gestorcampania.GestorCampania;
import gestorcampania.ControladorDonantes;
import gestorcampania.Sangre;
import gestorcampania.herramientas.ValidadorCamposDeVentana;
import javax.swing.JOptionPane;

/*Ventana encargada de mostrar la interfaz para modificar un donante en especifico*/
public class ModificarDonant extends javax.swing.JFrame {
    private GestorCampania gestor;
    private ControladorDonantes controlador;
    private ValidadorCamposDeVentana validadorCampos;
   
    public ModificarDonant(GestorCampania gestor){
        initComponents();
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);/*Para cerrar unicamente esta ventana y que no cierre todo el programa*/
        this.gestor = gestor;
        validadorCampos = new ValidadorCamposDeVentana();/*Validacion de diferentes campos segun lo requerido*/
    }
    public ModificarDonant() {
        initComponents();
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);/*Para cerrar unicamente esta ventana y que no cierre todo el programa*/
        validadorCampos = new ValidadorCamposDeVentana();/*Validacion de diferentes campos segun lo requerido*/
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtIdCampania = new javax.swing.JTextField();
        txtRut = new javax.swing.JTextField();
        btnModificar = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        cmbTipoSangre = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("Modificar donante");

        jLabel2.setText("ID campaña:");

        jLabel3.setText("Rut (con punto y guion):");

        btnModificar.setText("Modificar");
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });

        jLabel4.setText("Nombre:");

        jLabel6.setText("Tipo de sangre");

        cmbTipoSangre.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-", "A_POSITIVO", "A_NEGATIVO", "B_POSITIVO", "B_NEGATIVO", "AB_POSITIVO", "AB_NEGATIVO", "O_POSITIVO", "O_NEGATIVO" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(317, 317, 317)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtIdCampania, javax.swing.GroupLayout.DEFAULT_SIZE, 190, Short.MAX_VALUE)
                    .addComponent(txtRut)
                    .addComponent(txtNombre)
                    .addComponent(cmbTipoSangre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(222, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(357, 357, 357))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnModificar)
                        .addGap(362, 362, 362))))
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
                    .addComponent(txtRut, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbTipoSangre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(34, 34, 34)
                .addComponent(btnModificar)
                .addContainerGap(104, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /*Boton encargado de hacer la accio de modificar un donante*/
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
        if(validadorCampos.esTexto(texto) == true){/*Valida que el nombre del donante no contengan numeros*/
            nombre = texto;
        }else{
            JOptionPane.showMessageDialog(this, "Debe ingresar un texto valido (no vacio ni con numeros)");
            return;
        }
        
        String rut = txtRut.getText();
        
        String seleccion = (String) cmbTipoSangre.getSelectedItem();/*Selecciona el tipo de sangre*/
        
        if(seleccion.equals("-")){/*para caso que no se ingrese ningun tipo de sangre*/
            JOptionPane.showMessageDialog(null,"Seleccione un tipo de sangre");
            return;
        }
        
        Sangre tipoSangre = Sangre.valueOf(seleccion);/*Para transformar el tipo de sangre al enum declarado*/
        controlador = new ControladorDonantes(gestor);
        
        controlador.modificarDonante(idCampania, rut, nombre, tipoSangre);
    }//GEN-LAST:event_btnModificarActionPerformed

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnModificar;
    private javax.swing.JComboBox<String> cmbTipoSangre;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JTextField txtIdCampania;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtRut;
    // End of variables declaration//GEN-END:variables
}
