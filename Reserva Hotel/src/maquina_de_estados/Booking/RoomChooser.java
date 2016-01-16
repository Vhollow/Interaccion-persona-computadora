/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package maquina_de_estados.Booking;

import static java.lang.String.valueOf;
import maquina_de_estados.BookingStateMachine;
import maquina_de_estados.Main;

/**
 *
 * @author alber_000
 */
public class RoomChooser extends javax.swing.JFrame {
    
    private RoomChooserControler controlador;
    private ModeloReservaHotel modelo;
    /**
     * Creates new form RoomChoser
     */
    public RoomChooser() {
        
        modelo=Main.getBoockingStateMachine().getModelo();
        
        initComponents();
        controlador=new RoomChooserControler(this,modelo);
        
        actualizar();
       
    }
    public void actualizar(){
        for(int i=3;i>=0;i--){
            if(!modelo.comprobar(modelo.getInicio(),modelo.getFin(),i,modelo.getPersonas())){
            
            tipoComboBox.removeItemAt(i);
        }
        }
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tipoComboBox = new javax.swing.JComboBox();
        etiqueta_th = new javax.swing.JLabel();
        etiqueta_ta = new javax.swing.JLabel();
        alojamientoComboBox = new javax.swing.JComboBox();
        jLabel3 = new javax.swing.JLabel();
        etiqueta_precio = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        precioLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(400, 250));

        tipoComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Individual", "Doble", "Superior", "Suite" }));
        tipoComboBox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                tipoComboBoxItemStateChanged(evt);
            }
        });
        tipoComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tipoComboBoxActionPerformed(evt);
            }
        });

        etiqueta_th.setText("Tipo de habitacion");

        etiqueta_ta.setText("Tipo de alojamiento");

        alojamientoComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Solo alojamiento (SA)", "Alojamiento y desayuno (AD)", "Media pension (MP)", "Pension completa (PC)" }));
        alojamientoComboBox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                alojamientoComboBoxItemStateChanged(evt);
            }
        });

        jLabel3.setText("Precio total:");

        jButton1.setText("Reservar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Cambiar fecha");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addComponent(etiqueta_precio, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(35, 35, 35)
                        .addComponent(precioLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jButton2)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton1))
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(etiqueta_th)
                                .addComponent(etiqueta_ta))
                            .addGap(35, 35, 35)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(alojamientoComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(tipoComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                .addContainerGap(28, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(etiqueta_th)
                    .addComponent(tipoComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(etiqueta_ta)
                    .addComponent(alojamientoComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel3)
                        .addComponent(etiqueta_precio, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(precioLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addContainerGap(28, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tipoComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tipoComboBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tipoComboBoxActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        controlador.reservar();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        controlador.cambiarFecha();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void setprecio(){
        int precio=0;
        String item=(String) tipoComboBox.getSelectedItem();
        switch(item){
        
        case"Individual":
            precio=0;
            break;
        case"Doble":
            precio=1;
            break;
        case "Superior":
            precio=2;
            break;
        case "Suite":
            precio=3;
            break;
    }
        
        modelo.setTipo(precio);
        modelo.setPension(alojamientoComboBox.getSelectedIndex());

        precio=modelo.getPrecio(modelo.getTipo());
        precio+=modelo.getPrecioPension(modelo.getPension());
        precioLabel.setText(valueOf(precio));
    }
    private void alojamientoComboBoxItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_alojamientoComboBoxItemStateChanged
       
        setprecio();
    }//GEN-LAST:event_alojamientoComboBoxItemStateChanged

    private void tipoComboBoxItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_tipoComboBoxItemStateChanged
        
        setprecio();
    }//GEN-LAST:event_tipoComboBoxItemStateChanged

    /**
     * @param args the command line arguments
     */
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox alojamientoComboBox;
    private javax.swing.JLabel etiqueta_precio;
    private javax.swing.JLabel etiqueta_ta;
    private javax.swing.JLabel etiqueta_th;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel precioLabel;
    private javax.swing.JComboBox tipoComboBox;
    // End of variables declaration//GEN-END:variables
}
