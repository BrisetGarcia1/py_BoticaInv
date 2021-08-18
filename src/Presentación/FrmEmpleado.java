/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentación;
import Entidad.ClsEEmpleado;
import Entidad.ClsETipoEmpleado;
import Negocio.ClsNEmpleado;
import Negocio.ClsNTipoEmpleado;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

        

/**
 *
 * @author Usuario
 */
public class FrmEmpleado extends javax.swing.JInternalFrame {

    /**
     * Creates new form FrmEmpleado
     */
   
    public FrmEmpleado() {
        initComponents();
        try {
            this.setMaximum(true);
        
        } catch (Exception e) {
        }
        rbtnActivo.setSelected(true);
        rbtnIdEmpleado.setSelected(true);
        MtdListarEmpleado();
        cmbTipoUsuario.removeAllItems();
        LlenarCombo();
        MtdLimpiarCaja();
            
    }
    DefaultTableModel modelo;
    TableRowSorter trs;
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        buttonGroup3 = new javax.swing.ButtonGroup();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        rbtnIdEmpleado = new javax.swing.JRadioButton();
        rbtnNombre = new javax.swing.JRadioButton();
        rbtnDni = new javax.swing.JRadioButton();
        txtBuscar = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbEmpleado = new javax.swing.JTable();
        fondoformulario = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        lblIdEmpleado = new javax.swing.JLabel();
        txtIdEmpleado = new javax.swing.JTextField();
        lblNombre = new javax.swing.JLabel();
        lblApellidos = new javax.swing.JLabel();
        txtApellidos = new javax.swing.JTextField();
        lblSexo = new javax.swing.JLabel();
        rbtnMasculino = new javax.swing.JRadioButton();
        rbtnFemenino = new javax.swing.JRadioButton();
        lblFechaIn = new javax.swing.JLabel();
        lblFechaNac = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        jSeparator4 = new javax.swing.JSeparator();
        lblDireccion = new javax.swing.JLabel();
        txtDireccion = new javax.swing.JTextField();
        lblTelefono = new javax.swing.JLabel();
        txtTelefono = new javax.swing.JTextField();
        lblDni = new javax.swing.JLabel();
        txtDni = new javax.swing.JTextField();
        lblContraseña = new javax.swing.JLabel();
        lblTipoUsuario = new javax.swing.JLabel();
        cmbTipoUsuario = new javax.swing.JComboBox<>();
        btnGuardar = new javax.swing.JButton();
        btnNuevo = new javax.swing.JButton();
        txtNombre = new javax.swing.JTextField();
        txtContraseña = new javax.swing.JPasswordField();
        btnModificar = new javax.swing.JButton();
        lblEstado = new javax.swing.JLabel();
        rbtnActivo = new javax.swing.JRadioButton();
        jdcFechaNac = new com.toedter.calendar.JDateChooser();
        rbtnInactivo = new javax.swing.JRadioButton();
        jdcFechaIn = new com.toedter.calendar.JDateChooser();
        jPanel3 = new javax.swing.JPanel();
        lblDatosEmpleado = new javax.swing.JLabel();
        fondo = new javax.swing.JLabel();

        setRequestFocusEnabled(false);

        jTabbedPane1.setPreferredSize(new java.awt.Dimension(800, 650));

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        rbtnIdEmpleado.setBackground(new java.awt.Color(51, 51, 51));
        buttonGroup3.add(rbtnIdEmpleado);
        rbtnIdEmpleado.setFont(new java.awt.Font("Cambria", 0, 18)); // NOI18N
        rbtnIdEmpleado.setText("ID  Empleado");
        jPanel1.add(rbtnIdEmpleado, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 50, -1, -1));

        rbtnNombre.setBackground(new java.awt.Color(51, 51, 51));
        buttonGroup3.add(rbtnNombre);
        rbtnNombre.setFont(new java.awt.Font("Cambria", 0, 18)); // NOI18N
        rbtnNombre.setText("Nombre");
        jPanel1.add(rbtnNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 50, -1, -1));

        rbtnDni.setBackground(new java.awt.Color(51, 51, 51));
        buttonGroup3.add(rbtnDni);
        rbtnDni.setFont(new java.awt.Font("Cambria", 0, 18)); // NOI18N
        rbtnDni.setText("DNI");
        jPanel1.add(rbtnDni, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 50, 60, -1));

        txtBuscar.setBackground(new java.awt.Color(204, 204, 255));
        txtBuscar.setFont(new java.awt.Font("Cambria", 0, 14)); // NOI18N
        txtBuscar.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(255, 255, 255)));
        txtBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtBuscarKeyTyped(evt);
            }
        });
        jPanel1.add(txtBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 130, 250, 30));
        jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 30, 690, 10));
        jPanel1.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 100, 690, 10));

        tbEmpleado.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tbEmpleado.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbEmpleadoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbEmpleado);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 190, 740, 287));

        fondoformulario.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.add(fondoformulario, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 790, 600));

        jTabbedPane1.addTab("Buscar", jPanel1);

        jPanel2.setBackground(new java.awt.Color(55, 61, 84));
        jPanel2.setRequestFocusEnabled(false);
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblIdEmpleado.setFont(new java.awt.Font("Cambria", 0, 18)); // NOI18N
        lblIdEmpleado.setForeground(new java.awt.Color(255, 255, 255));
        lblIdEmpleado.setText("ID empleado");
        jPanel2.add(lblIdEmpleado, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 110, -1, 30));

        txtIdEmpleado.setFont(new java.awt.Font("Cambria", 0, 14)); // NOI18N
        txtIdEmpleado.setText("01");
        txtIdEmpleado.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(255, 255, 255)));
        jPanel2.add(txtIdEmpleado, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 110, 70, 30));

        lblNombre.setFont(new java.awt.Font("Cambria", 0, 18)); // NOI18N
        lblNombre.setForeground(new java.awt.Color(255, 255, 255));
        lblNombre.setText("Nombre");
        jPanel2.add(lblNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 160, 70, 30));

        lblApellidos.setFont(new java.awt.Font("Cambria", 0, 18)); // NOI18N
        lblApellidos.setForeground(new java.awt.Color(255, 255, 255));
        lblApellidos.setText("Apellidos");
        jPanel2.add(lblApellidos, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 210, -1, 30));

        txtApellidos.setFont(new java.awt.Font("Cambria", 0, 14)); // NOI18N
        txtApellidos.setText("Flores Querie");
        txtApellidos.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(255, 255, 255)));
        jPanel2.add(txtApellidos, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 210, 190, 30));

        lblSexo.setFont(new java.awt.Font("Cambria", 0, 18)); // NOI18N
        lblSexo.setForeground(new java.awt.Color(255, 255, 255));
        lblSexo.setText("Sexo");
        jPanel2.add(lblSexo, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 310, 40, 30));

        rbtnMasculino.setBackground(new java.awt.Color(55, 61, 84));
        buttonGroup1.add(rbtnMasculino);
        rbtnMasculino.setFont(new java.awt.Font("Cambria", 0, 14)); // NOI18N
        rbtnMasculino.setForeground(new java.awt.Color(255, 255, 255));
        rbtnMasculino.setText("Masculino");
        jPanel2.add(rbtnMasculino, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 310, -1, 30));

        rbtnFemenino.setBackground(new java.awt.Color(55, 61, 84));
        buttonGroup1.add(rbtnFemenino);
        rbtnFemenino.setFont(new java.awt.Font("Cambria", 0, 14)); // NOI18N
        rbtnFemenino.setForeground(new java.awt.Color(255, 255, 255));
        rbtnFemenino.setText("Femenino");
        jPanel2.add(rbtnFemenino, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 310, 100, 30));

        lblFechaIn.setFont(new java.awt.Font("Cambria", 0, 18)); // NOI18N
        lblFechaIn.setForeground(new java.awt.Color(255, 255, 255));
        lblFechaIn.setText("Fecha de ingreso");
        jPanel2.add(lblFechaIn, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 160, -1, 30));

        lblFechaNac.setFont(new java.awt.Font("Cambria", 0, 18)); // NOI18N
        lblFechaNac.setForeground(new java.awt.Color(255, 255, 255));
        lblFechaNac.setText("Fecha de nacimiento");
        jPanel2.add(lblFechaNac, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 260, 160, 30));
        jPanel2.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 470, 720, 10));
        jPanel2.add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 560, 720, 10));

        lblDireccion.setFont(new java.awt.Font("Cambria", 0, 18)); // NOI18N
        lblDireccion.setForeground(new java.awt.Color(255, 255, 255));
        lblDireccion.setText("Direccion");
        jPanel2.add(lblDireccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 360, 80, 30));

        txtDireccion.setFont(new java.awt.Font("Cambria", 0, 14)); // NOI18N
        txtDireccion.setText("Mi casa");
        txtDireccion.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(255, 255, 255)));
        jPanel2.add(txtDireccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 360, 190, 30));

        lblTelefono.setFont(new java.awt.Font("Cambria", 0, 18)); // NOI18N
        lblTelefono.setForeground(new java.awt.Color(255, 255, 255));
        lblTelefono.setText("Telefono");
        jPanel2.add(lblTelefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 410, -1, 30));

        txtTelefono.setFont(new java.awt.Font("Cambria", 0, 14)); // NOI18N
        txtTelefono.setText("992200011");
        txtTelefono.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(255, 255, 255)));
        jPanel2.add(txtTelefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 410, 190, 30));

        lblDni.setFont(new java.awt.Font("Cambria", 0, 18)); // NOI18N
        lblDni.setForeground(new java.awt.Color(255, 255, 255));
        lblDni.setText("DNI");
        jPanel2.add(lblDni, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 110, 40, 30));

        txtDni.setFont(new java.awt.Font("Cambria", 0, 14)); // NOI18N
        txtDni.setText("60606060");
        txtDni.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(255, 255, 255)));
        jPanel2.add(txtDni, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 110, 140, 30));

        lblContraseña.setFont(new java.awt.Font("Cambria", 0, 18)); // NOI18N
        lblContraseña.setForeground(new java.awt.Color(255, 255, 255));
        lblContraseña.setText("Contraseña");
        jPanel2.add(lblContraseña, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 310, -1, 30));

        lblTipoUsuario.setFont(new java.awt.Font("Cambria", 0, 18)); // NOI18N
        lblTipoUsuario.setForeground(new java.awt.Color(255, 255, 255));
        lblTipoUsuario.setText("Tipo de usuario");
        jPanel2.add(lblTipoUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 360, -1, 30));

        cmbTipoUsuario.setFont(new java.awt.Font("Cambria", 0, 14)); // NOI18N
        cmbTipoUsuario.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Administrador", "Vendedor" }));
        jPanel2.add(cmbTipoUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 360, 140, 30));

        btnGuardar.setFont(new java.awt.Font("Cambria", 0, 14)); // NOI18N
        btnGuardar.setText(" GUARDAR");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });
        jPanel2.add(btnGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 490, 220, 50));

        btnNuevo.setFont(new java.awt.Font("Cambria", 0, 14)); // NOI18N
        btnNuevo.setText("NUEVO");
        btnNuevo.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoActionPerformed(evt);
            }
        });
        jPanel2.add(btnNuevo, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 490, 210, 50));

        txtNombre.setFont(new java.awt.Font("Cambria", 0, 14)); // NOI18N
        txtNombre.setText("Luis Fernando");
        txtNombre.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(255, 255, 255)));
        jPanel2.add(txtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 160, 190, 30));

        txtContraseña.setFont(new java.awt.Font("Cambria", 0, 14)); // NOI18N
        txtContraseña.setText("asd");
        txtContraseña.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(255, 255, 255)));
        jPanel2.add(txtContraseña, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 310, 140, 30));

        btnModificar.setFont(new java.awt.Font("Cambria", 0, 14)); // NOI18N
        btnModificar.setText(" MODIFICAR");
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });
        jPanel2.add(btnModificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 490, 210, 50));

        lblEstado.setFont(new java.awt.Font("Cambria", 0, 18)); // NOI18N
        lblEstado.setForeground(new java.awt.Color(255, 255, 255));
        lblEstado.setText("Estado");
        jPanel2.add(lblEstado, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 210, -1, 30));

        rbtnActivo.setBackground(new java.awt.Color(55, 61, 84));
        buttonGroup2.add(rbtnActivo);
        rbtnActivo.setFont(new java.awt.Font("Cambria", 0, 14)); // NOI18N
        rbtnActivo.setForeground(new java.awt.Color(255, 255, 255));
        rbtnActivo.setText("Activo");
        jPanel2.add(rbtnActivo, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 210, -1, 30));
        jPanel2.add(jdcFechaNac, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 270, 190, -1));

        rbtnInactivo.setBackground(new java.awt.Color(55, 61, 84));
        buttonGroup2.add(rbtnInactivo);
        rbtnInactivo.setFont(new java.awt.Font("Cambria", 0, 14)); // NOI18N
        rbtnInactivo.setForeground(new java.awt.Color(255, 255, 255));
        rbtnInactivo.setText("Inactivo");
        jPanel2.add(rbtnInactivo, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 210, 80, 30));
        jPanel2.add(jdcFechaIn, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 170, 140, -1));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        lblDatosEmpleado.setFont(new java.awt.Font("Cambria", 0, 24)); // NOI18N
        lblDatosEmpleado.setForeground(new java.awt.Color(55, 61, 84));
        lblDatosEmpleado.setText("Datos empleado");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblDatosEmpleado)
                .addContainerGap(594, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblDatosEmpleado, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
        );

        jPanel2.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 770, 50));

        fondo.setToolTipText("");
        jPanel2.add(fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(-20, 20, 780, 590));

        jTabbedPane1.addTab("Nuevo / Modificar", jPanel2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 785, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 617, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtBuscarKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarKeyTyped
        // TODO add your handling code here:
        txtBuscar.addKeyListener(new KeyAdapter()
        {
            public void keyRelease(KeyEvent e){
                if(rbtnIdEmpleado.isSelected()){
                    trs.setRowFilter(RowFilter.regexFilter("(?i)"+ txtBuscar.getText(),0));
                }
                if(rbtnNombre.isSelected()){
                    trs.setRowFilter(RowFilter.regexFilter("(?i)"+txtBuscar.getText(),2));
                }
                if(rbtnDni.isSelected()){
                    trs.setRowFilter(RowFilter.regexFilter("(?i)"+txtBuscar.getText(),1));
                }
                        
            }
        }
        );
        trs=new TableRowSorter(modelo);
        tbEmpleado.setRowSorter(trs);
        
    }//GEN-LAST:event_txtBuscarKeyTyped

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        // TODO add your handling code here:
        MtdLimpiarCaja();
       
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
       
        java.util.Date fecha=jdcFechaNac.getDate();
        java.util.Date fecha2=jdcFechaIn.getDate();
        DateFormat formato=new SimpleDateFormat("yyyy-MM-dd");
        String f=formato.format(fecha);
        String f2=formato.format(fecha2);
        ClsEEmpleado objEE=new ClsEEmpleado();
        ClsNEmpleado objNE=new ClsNEmpleado();
        objEE.setDniEmpleado(txtDni.getText());
        objEE.setNombreEmpleado(txtNombre.getText());
        objEE.setApellidosEmpleado(txtApellidos.getText());
        if(rbtnMasculino.isSelected())
        {
            objEE.setSexoEmpleado("Masculino");
        }
        else
        {
            objEE.setSexoEmpleado("Femenino");
        }
        objEE.setFnacimientoEmpleado(f);
        objEE.setDireccionEmpleado(txtDireccion.getText());
        objEE.setTelefonoEmpleado(txtTelefono.getText());
        objEE.setTipoEmpleado(cmbTipoUsuario.getSelectedIndex()+1);
        objEE.setFingresoEmpleado(f2);
        objEE.setContraseñaEmpleado(txtContraseña.getText());
        if(rbtnActivo.isSelected())
        {
            objEE.setEstadoEmpleado(1);
        }
        else
        {
            objEE.setEstadoEmpleado(0);
        }
            
        if(objNE.MtdResgistrarEmpleado(objEE)==true)
        {
            JOptionPane.showMessageDialog(null, "EMPLEADO AGREGADO");
        }
        else
        {
            JOptionPane.showMessageDialog(null, "NO SE PUDO GUARDAR DATOS");
        }
        MtdListarEmpleado();
        
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        java.util.Date fecha=jdcFechaNac.getDate();
        java.util.Date fecha2=jdcFechaIn.getDate();
        DateFormat formato=new SimpleDateFormat("yyyy-MM-dd");
        String f=formato.format(fecha);
        String f2=formato.format(fecha2);
        ClsEEmpleado objEE=new ClsEEmpleado();
        ClsNEmpleado objNE=new ClsNEmpleado();
        objEE.setIdEmpleado(Integer.parseInt(txtIdEmpleado.getText()));
        objEE.setDniEmpleado(txtDni.getText());
        objEE.setNombreEmpleado(txtNombre.getText());
        objEE.setApellidosEmpleado(txtApellidos.getText());
        if(rbtnMasculino.isSelected())
        {
            objEE.setSexoEmpleado("Masculino");
        }
        else
        {
            objEE.setSexoEmpleado("Femenino");
        }
        objEE.setFnacimientoEmpleado(f);
        objEE.setDireccionEmpleado(txtDireccion.getText());
        objEE.setTelefonoEmpleado(txtTelefono.getText());
        objEE.setTipoEmpleado(cmbTipoUsuario.getSelectedIndex()+1);
        objEE.setFingresoEmpleado(f2);
        objEE.setContraseñaEmpleado(txtContraseña.getText());
        if(rbtnActivo.isSelected())
        {
            objEE.setEstadoEmpleado(1);
        }
        else
        {
            objEE.setEstadoEmpleado(0);
        }
        if(objNE.MtdModificarEmpleado(objEE)==true)
        {
            JOptionPane.showMessageDialog(null, "DATOS MODIFICADOS CORRECTAMENTE");
        }
        else
        {
            JOptionPane.showMessageDialog(null, "NO SE PUDO MODIFICAR EL DATO");
        }
        MtdListarEmpleado();
                
    }//GEN-LAST:event_btnModificarActionPerformed

    private void tbEmpleadoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbEmpleadoMouseClicked
        int filam;                                   //PASAR DATOS DE LA TABLA A LAS CAJAS DE TEXTO
        filam=tbEmpleado.getSelectedRow();   
        txtIdEmpleado.setText(tbEmpleado.getValueAt(filam, 0).toString());
        txtDni.setText(tbEmpleado.getValueAt(filam, 1).toString());
        txtNombre.setText(tbEmpleado.getValueAt(filam, 2).toString());
        txtApellidos.setText(tbEmpleado.getValueAt(filam, 3).toString());
        if(tbEmpleado.getValueAt(filam, 4).toString().equals("Masculino"))
        {
            rbtnMasculino.setSelected(true);
        }
        else
        {
            rbtnFemenino.setSelected(true);
        }
         DateFormat formato=new SimpleDateFormat("yyyy-MM-dd");
        String f=(String)tbEmpleado.getValueAt(filam, 5);
        java.util.Date fechaa=null;       
        try {
            fechaa=formato.parse(f);
            jdcFechaNac.setDate(fechaa);
        } catch (ParseException ex) {
            ex.printStackTrace();
        }
        txtDireccion.setText(tbEmpleado.getValueAt(filam, 6).toString());
        txtTelefono.setText(tbEmpleado.getValueAt(filam, 7).toString());

        cmbTipoUsuario.setSelectedIndex(Integer.parseInt(tbEmpleado.getValueAt(filam, 8).toString())-1);
        String f2=(String)tbEmpleado.getValueAt(filam, 9);
        java.util.Date fechaa2=null;       
        try {
            fechaa2=formato.parse(f2);
           jdcFechaIn.setDate(fechaa2);
        } catch (ParseException ex) {
            ex.printStackTrace();
        }
        txtContraseña.setText(tbEmpleado.getValueAt(filam, 10).toString());
        if(tbEmpleado.getValueAt(filam, 11).toString().equals("ACTIVO"))
        {
            rbtnActivo.setSelected(true);
        }
        else
        {
            rbtnInactivo.setSelected(true);
        }
        jTabbedPane1.setSelectedIndex(1);
          
    }//GEN-LAST:event_tbEmpleadoMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnModificar;
    private javax.swing.JButton btnNuevo;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.ButtonGroup buttonGroup3;
    private javax.swing.JComboBox<String> cmbTipoUsuario;
    private javax.swing.JLabel fondo;
    private javax.swing.JLabel fondoformulario;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JTabbedPane jTabbedPane1;
    private com.toedter.calendar.JDateChooser jdcFechaIn;
    private com.toedter.calendar.JDateChooser jdcFechaNac;
    private javax.swing.JLabel lblApellidos;
    private javax.swing.JLabel lblContraseña;
    private javax.swing.JLabel lblDatosEmpleado;
    private javax.swing.JLabel lblDireccion;
    private javax.swing.JLabel lblDni;
    private javax.swing.JLabel lblEstado;
    private javax.swing.JLabel lblFechaIn;
    private javax.swing.JLabel lblFechaNac;
    private javax.swing.JLabel lblIdEmpleado;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblSexo;
    private javax.swing.JLabel lblTelefono;
    private javax.swing.JLabel lblTipoUsuario;
    private javax.swing.JRadioButton rbtnActivo;
    private javax.swing.JRadioButton rbtnDni;
    private javax.swing.JRadioButton rbtnFemenino;
    private javax.swing.JRadioButton rbtnIdEmpleado;
    private javax.swing.JRadioButton rbtnInactivo;
    private javax.swing.JRadioButton rbtnMasculino;
    private javax.swing.JRadioButton rbtnNombre;
    private javax.swing.JTable tbEmpleado;
    private javax.swing.JTextField txtApellidos;
    private javax.swing.JTextField txtBuscar;
    private javax.swing.JPasswordField txtContraseña;
    private javax.swing.JTextField txtDireccion;
    private javax.swing.JTextField txtDni;
    private javax.swing.JTextField txtIdEmpleado;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtTelefono;
    // End of variables declaration//GEN-END:variables

    public void MtdListarEmpleado() {
       modelo=new DefaultTableModel();
        modelo.addColumn("ID");
        modelo.addColumn("DNI");
        modelo.addColumn("NOMBRE");
        modelo.addColumn("APELLIDOS");
        modelo.addColumn("SEXO");
        modelo.addColumn("F-NACIMIENTO");
        modelo.addColumn("DIRECCION");
        modelo.addColumn("TELEFONO");
        modelo.addColumn("TIPO");
        modelo.addColumn("F-INGRESO");
        modelo.addColumn("CONTRASEÑA");
        modelo.addColumn("ESTADO");
        ClsNEmpleado objNE=new ClsNEmpleado();
        String[] datos=new String[12];
        for(ClsEEmpleado objE : objNE.MtdListarEmpleado())
        {
            datos[0]=String.valueOf(objE.getIdEmpleado());
            datos[1]=objE.getDniEmpleado();
            datos[2]=objE.getNombreEmpleado();
            datos[3]=objE.getApellidosEmpleado();
            datos[4]=objE.getSexoEmpleado();
            datos[5]=objE.getFnacimientoEmpleado();
            datos[6]=objE.getDireccionEmpleado();
            datos[7]=objE.getTelefonoEmpleado();
            datos[8]=String.valueOf(objE.getTipoEmpleado());
            datos[9]=objE.getFingresoEmpleado();
            datos[10]=String.valueOf(objE.getContraseñaEmpleado());
            if(objE.getEstadoEmpleado()==0)
            {
                datos[11]="INACTIVO";
            }
            else
            {
                datos[11]="ACTIVO";  
            }
            modelo.addRow(datos);
        }
        this.tbEmpleado.setModel(modelo);
    }
    
     public void LlenarCombo() {
        String []prueba=new String[1];
        DefaultComboBoxModel value = new DefaultComboBoxModel();
        cmbTipoUsuario.removeAllItems();
        cmbTipoUsuario.setModel(value);    
        ClsNTipoEmpleado objNC =new ClsNTipoEmpleado();
        for(ClsETipoEmpleado objE : objNC.LlenarTipoEmpleado())
        {
            prueba[0]=objE.getDescripcionTipo();
            value.addElement(prueba[0]);         
        }    
    }

    private void MtdLimpiarCaja() {
        txtIdEmpleado.setText("");
         txtNombre.setText("");
         txtApellidos.setText("");

         txtDireccion.setText("");
         txtTelefono.setText("");
         txtDni.setText("");

         txtContraseña.setText("");
         cmbTipoUsuario.setSelectedIndex(0);
    }
    
}
