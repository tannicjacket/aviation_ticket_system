/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package UI.Distributor;

/**
 *
 * @author martta
 */
public class PriceManagementJPanel extends javax.swing.JPanel {

    /**
     * Creates new form PriceManagementJPanel
     */
    public PriceManagementJPanel() {
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

        lblMonth = new javax.swing.JLabel();
        cmbMonth = new javax.swing.JComboBox<>();
        btnSearch = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblPrices = new javax.swing.JTable();
        btnEdit = new javax.swing.JButton();
<<<<<<< Updated upstream
=======
        cmbMonth = new javax.swing.JComboBox<>();
        cmbAdjust = new javax.swing.JComboBox<>();
        cmbPercentage = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
>>>>>>> Stashed changes

        setBackground(new java.awt.Color(242, 249, 255));

        lblMonth.setFont(new java.awt.Font("Amazon Ember", 1, 14)); // NOI18N
        lblMonth.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblMonth.setText("Month:");

<<<<<<< Updated upstream
        cmbMonth.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cmbMonth.addActionListener(new java.awt.event.ActionListener() {
=======
        btnSearch.setFont(new java.awt.Font("Amazon Ember", 0, 14)); // NOI18N
        btnSearch.setText("Search");
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
>>>>>>> Stashed changes
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbMonthActionPerformed(evt);
            }
        });

<<<<<<< Updated upstream
        btnSearch.setText("Search");

=======
        tblPrices.setFont(new java.awt.Font("Amazon Ember", 0, 14)); // NOI18N
>>>>>>> Stashed changes
        tblPrices.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Flight No.", "Month", "First Class Price", "Business Class Price", "Economy Class Price"
            }
        ));
        jScrollPane1.setViewportView(tblPrices);

        btnEdit.setFont(new java.awt.Font("Amazon Ember", 0, 14)); // NOI18N
        btnEdit.setText("Edit");

        jLabel1.setFont(new java.awt.Font("Amazon Ember", 3, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(102, 204, 255));
        jLabel1.setText("Price Management");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
<<<<<<< Updated upstream
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addComponent(lblPriceManagement))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addComponent(lblMonth)
                        .addGap(18, 18, 18)
                        .addComponent(cmbMonth, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnSearch)))
                .addContainerGap(346, Short.MAX_VALUE))
=======
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 766, Short.MAX_VALUE)
                .addGap(28, 28, 28))
>>>>>>> Stashed changes
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnEdit)
<<<<<<< Updated upstream
                .addGap(54, 54, 54))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 668, Short.MAX_VALUE)
                    .addContainerGap()))
=======
                .addGap(139, 139, 139))
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblMonth)
                        .addGap(18, 18, 18)
                        .addComponent(cmbMonth, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnSearch)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
>>>>>>> Stashed changes
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(77, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
<<<<<<< Updated upstream
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblMonth)
                    .addComponent(cmbMonth, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSearch))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 243, Short.MAX_VALUE)
                .addComponent(btnEdit)
                .addGap(100, 100, 100))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(140, 140, 140)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(141, Short.MAX_VALUE)))
=======
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(cmbAdjust, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(cmbPercentage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(51, 51, 51))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblMonth)
                            .addComponent(cmbMonth, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnSearch))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(56, 56, 56)
                        .addComponent(btnEdit)
                        .addGap(76, 76, 76))))
>>>>>>> Stashed changes
        );
    }// </editor-fold>//GEN-END:initComponents

    private void cmbMonthActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbMonthActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbMonthActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnSearch;
<<<<<<< Updated upstream
    private javax.swing.JComboBox<String> cmbMonth;
=======
    private javax.swing.JComboBox<Object> cmbAdjust;
    private javax.swing.JComboBox<Object> cmbMonth;
    private javax.swing.JComboBox<Object> cmbPercentage;
    private javax.swing.JLabel jLabel1;
>>>>>>> Stashed changes
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblMonth;
    private javax.swing.JTable tblPrices;
    // End of variables declaration//GEN-END:variables
}
