/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package UI.Airline;

/**
 *
 * @author martta
 */
public class AssignFacultyJPanel extends javax.swing.JPanel {

    /**
     * Creates new form AssignFacultyJPanel
     */
    public AssignFacultyJPanel() {
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

        lblFlightNumber = new javax.swing.JLabel();
        txtFlightNumber = new javax.swing.JTextField();
        btnSearch = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblFaculty = new javax.swing.JTable();
        btnAssign = new javax.swing.JButton();
<<<<<<< Updated upstream
=======
        jScrollPane2 = new javax.swing.JScrollPane();
        tblAvailableFaculty = new javax.swing.JTable();
        lblCurrentFaculty = new javax.swing.JLabel();
        lblAvailableFaculty = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
>>>>>>> Stashed changes

        setBackground(new java.awt.Color(242, 249, 255));

        lblFlightNumber.setFont(new java.awt.Font("Amazon Ember", 0, 14)); // NOI18N
        lblFlightNumber.setText("Flight Number:");

        txtFlightNumber.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFlightNumberActionPerformed(evt);
            }
        });

<<<<<<< Updated upstream
        btnSearch.setText("Search");

        tblFaculty.setModel(new javax.swing.table.DefaultTableModel(
=======
        btnSearch.setFont(new java.awt.Font("Amazon Ember", 0, 14)); // NOI18N
        btnSearch.setText("Search Flight");
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });

        tblCurrentFaculty.setFont(new java.awt.Font("Amazon Ember", 0, 14)); // NOI18N
        tblCurrentFaculty.setModel(new javax.swing.table.DefaultTableModel(
>>>>>>> Stashed changes
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Work ID", "Name", "Role"
            }
        ));
        jScrollPane1.setViewportView(tblFaculty);

        btnAssign.setFont(new java.awt.Font("Amazon Ember", 0, 14)); // NOI18N
        btnAssign.setText("Assign");
<<<<<<< Updated upstream
=======
        btnAssign.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAssignActionPerformed(evt);
            }
        });

        tblAvailableFaculty.setFont(new java.awt.Font("Amazon Ember", 0, 14)); // NOI18N
        tblAvailableFaculty.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Work ID", "Name", "Role"
            }
        ));
        jScrollPane2.setViewportView(tblAvailableFaculty);

        lblCurrentFaculty.setFont(new java.awt.Font("Amazon Ember", 0, 14)); // NOI18N
        lblCurrentFaculty.setText("Current Faculty:");

        lblAvailableFaculty.setFont(new java.awt.Font("Amazon Ember", 0, 14)); // NOI18N
        lblAvailableFaculty.setText("Available Faculty:");
>>>>>>> Stashed changes

        jLabel1.setFont(new java.awt.Font("Amazon Ember", 3, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(102, 204, 255));
        jLabel1.setText("Assign Faculty(Attendant)");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
<<<<<<< Updated upstream
                    .addGroup(layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addComponent(lblAssignFaculty))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(85, 85, 85)
                        .addComponent(lblFlightNumber)
                        .addGap(18, 18, 18)
                        .addComponent(txtFlightNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(39, 39, 39)
                        .addComponent(btnSearch)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 12, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 301, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(57, 57, 57)
                .addComponent(btnAssign)
                .addGap(186, 186, 186))
=======
                    .addComponent(jLabel1)
                    .addComponent(lblAvailableFaculty)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 442, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(lblCurrentFaculty)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 442, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(lblFlightNumber)
                                    .addGap(18, 18, 18)
                                    .addComponent(txtFlightNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(btnSearch))))
                        .addGap(30, 30, 30)
                        .addComponent(btnAssign)))
                .addContainerGap(234, Short.MAX_VALUE))
>>>>>>> Stashed changes
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnAssign)
                    .addGroup(layout.createSequentialGroup()
<<<<<<< Updated upstream
                        .addComponent(lblAssignFaculty)
                        .addGap(24, 24, 24)
=======
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnAssign))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(57, 57, 57)
                        .addComponent(jLabel1)
                        .addGap(27, 27, 27)
>>>>>>> Stashed changes
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblFlightNumber)
                            .addComponent(txtFlightNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnSearch))
<<<<<<< Updated upstream
                        .addGap(35, 35, 35)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(73, Short.MAX_VALUE))
=======
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                        .addComponent(lblCurrentFaculty)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)
                        .addComponent(lblAvailableFaculty)
                        .addGap(20, 20, 20)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(35, 35, 35))
>>>>>>> Stashed changes
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtFlightNumberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFlightNumberActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFlightNumberActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAssign;
    private javax.swing.JButton btnSearch;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
<<<<<<< Updated upstream
    private javax.swing.JLabel lblAssignFaculty;
=======
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblAvailableFaculty;
    private javax.swing.JLabel lblCurrentFaculty;
>>>>>>> Stashed changes
    private javax.swing.JLabel lblFlightNumber;
    private javax.swing.JTable tblFaculty;
    private javax.swing.JTextField txtFlightNumber;
    // End of variables declaration//GEN-END:variables
}
