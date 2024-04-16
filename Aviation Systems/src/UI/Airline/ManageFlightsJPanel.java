/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package UI.Airline;

/**
 *
 * @author martta
 */
public class ManageFlightsJPanel extends javax.swing.JPanel {

    /**
     * Creates new form ManageFlightsJPanel
     */
    public ManageFlightsJPanel() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblFlights = new javax.swing.JTable();
        btnAddNewFlights = new javax.swing.JButton();
        btnUpdateFlights = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
<<<<<<< Updated upstream
        btnSave = new javax.swing.JButton();
=======
        jLabel1 = new javax.swing.JLabel();
>>>>>>> Stashed changes

        setBackground(new java.awt.Color(242, 249, 255));

        tblFlights.setFont(new java.awt.Font("Amazon Ember", 0, 14)); // NOI18N
        tblFlights.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Flight No.", "Departure Airport", "Destination", "Departure Time", "Arrival Time", "Date", "Available Seats"
            }
        ));
        jScrollPane1.setViewportView(tblFlights);

        btnAddNewFlights.setFont(new java.awt.Font("Amazon Ember", 0, 14)); // NOI18N
        btnAddNewFlights.setText("Add New Flights");

        btnUpdateFlights.setText("Update Flights");

        btnDelete.setFont(new java.awt.Font("Amazon Ember", 0, 14)); // NOI18N
        btnDelete.setText("Delete");

        btnSave.setText("Save");

        jLabel1.setFont(new java.awt.Font("Amazon Ember", 3, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(102, 204, 255));
        jLabel1.setText("Manage Flights");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
<<<<<<< Updated upstream
                        .addGap(29, 29, 29)
                        .addComponent(lblMngFlights))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 680, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(24, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(btnAddNewFlights)
                .addGap(18, 18, 18)
                .addComponent(btnUpdateFlights)
                .addGap(29, 29, 29)
                .addComponent(btnDelete)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnSave)
                .addGap(34, 34, 34))
=======
                        .addGap(30, 30, 30)
                        .addComponent(btnAddNewFlights)
                        .addGap(41, 41, 41)
                        .addComponent(btnDelete))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 680, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))))
                .addContainerGap(91, Short.MAX_VALUE))
>>>>>>> Stashed changes
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addComponent(jLabel1)
                .addGap(33, 33, 33)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(46, 46, 46)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAddNewFlights)
<<<<<<< Updated upstream
                    .addComponent(btnUpdateFlights)
                    .addComponent(btnDelete)
                    .addComponent(btnSave))
                .addContainerGap(118, Short.MAX_VALUE))
=======
                    .addComponent(btnDelete))
                .addContainerGap(135, Short.MAX_VALUE))
>>>>>>> Stashed changes
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddNewFlights;
    private javax.swing.JButton btnDelete;
<<<<<<< Updated upstream
    private javax.swing.JButton btnSave;
    private javax.swing.JButton btnUpdateFlights;
=======
    private javax.swing.JLabel jLabel1;
>>>>>>> Stashed changes
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblFlights;
    // End of variables declaration//GEN-END:variables
}
