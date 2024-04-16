/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package UI.Passenger;

/**
 *
 * @author martta
 */
public class BookOneWayJPanel extends javax.swing.JPanel {

    /**
     * Creates new form BookOneWayJPanel
     */
    public BookOneWayJPanel() {
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

        lblNumberOfPassengers = new javax.swing.JLabel();
        txtNoOfPassengers = new javax.swing.JTextField();
        lblName = new javax.swing.JLabel();
        txtDepartureAirport = new javax.swing.JTextField();
        lblAge = new javax.swing.JLabel();
        txtDestination = new javax.swing.JTextField();
        lblDepartureDate = new javax.swing.JLabel();
        txtDepartureDate = new javax.swing.JTextField();
        btnSearch = new javax.swing.JButton();
        lblClass = new javax.swing.JLabel();
        cmbSeatClass = new javax.swing.JComboBox<>();
        btnBook = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblFlights = new javax.swing.JTable();
<<<<<<< Updated upstream
=======
        cmbDeparture = new javax.swing.JComboBox<>();
        cmbDestination = new javax.swing.JComboBox<>();
        cmbDate = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
>>>>>>> Stashed changes

        setBackground(new java.awt.Color(242, 249, 255));

        lblNumberOfPassengers.setFont(new java.awt.Font("Amazon Ember", 1, 14)); // NOI18N
        lblNumberOfPassengers.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblNumberOfPassengers.setText("No. of Passengers");

        txtNoOfPassengers.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNoOfPassengersActionPerformed(evt);
            }
        });

        lblName.setFont(new java.awt.Font("Amazon Ember", 1, 14)); // NOI18N
        lblName.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblName.setText("Departure Airport");

<<<<<<< Updated upstream
        txtDepartureAirport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDepartureAirportActionPerformed(evt);
            }
        });

        lblAge.setFont(new java.awt.Font("Helvetica Neue", 1, 13)); // NOI18N
        lblAge.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblAge.setText("Destination");

        txtDestination.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDestinationActionPerformed(evt);
            }
        });

        lblDepartureDate.setFont(new java.awt.Font("Helvetica Neue", 1, 13)); // NOI18N
        lblDepartureDate.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblDepartureDate.setText("Departure Date");

        txtDepartureDate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDepartureDateActionPerformed(evt);
            }
        });

=======
        lblAge.setFont(new java.awt.Font("Amazon Ember", 1, 14)); // NOI18N
        lblAge.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblAge.setText("Destination");

        lblDepartureDate.setFont(new java.awt.Font("Amazon Ember", 1, 14)); // NOI18N
        lblDepartureDate.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblDepartureDate.setText("Departure Date");

        btnSearch.setFont(new java.awt.Font("Amazon Ember", 0, 14)); // NOI18N
>>>>>>> Stashed changes
        btnSearch.setText("Search");
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });

        lblClass.setFont(new java.awt.Font("Amazon Ember", 1, 14)); // NOI18N
        lblClass.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblClass.setText("Seat Class");

        cmbSeatClass.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cmbSeatClass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbSeatClassActionPerformed(evt);
            }
        });

        btnBook.setFont(new java.awt.Font("Amazon Ember", 0, 14)); // NOI18N
        btnBook.setText("Book");
        btnBook.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBookActionPerformed(evt);
            }
        });

        tblFlights.setFont(new java.awt.Font("Amazon Ember", 0, 14)); // NOI18N
        tblFlights.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Departure Time", "Arrival Time", "Airline", "Flight No.", "Class", "Price"
            }
        ));
        jScrollPane1.setViewportView(tblFlights);

<<<<<<< Updated upstream
=======
        cmbDeparture.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        cmbDestination.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        cmbDate.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel1.setFont(new java.awt.Font("Amazon Ember", 3, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(102, 204, 255));
        jLabel1.setText("Book Tickets(One Way)");

>>>>>>> Stashed changes
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
<<<<<<< Updated upstream
                            .addComponent(lblName)
                            .addComponent(lblDepartureDate))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtDepartureAirport, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(27, 27, 27)
                                .addComponent(lblAge)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtDestination, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtDepartureDate, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnSearch))))
=======
                            .addComponent(jLabel1)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblName)
                                    .addComponent(lblDepartureDate))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(cmbDate, 0, 126, Short.MAX_VALUE)
                                    .addComponent(cmbDeparture, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblAge)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cmbDestination, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 286, Short.MAX_VALUE))
>>>>>>> Stashed changes
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblClass)
                        .addGap(18, 18, 18)
                        .addComponent(cmbSeatClass, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lblNumberOfPassengers)
                        .addGap(18, 18, 18)
                        .addComponent(txtNoOfPassengers, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
<<<<<<< Updated upstream
                        .addComponent(btnBook))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblBookTickets)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(42, 42, 42))
=======
                        .addComponent(btnSearch)
                        .addGap(39, 39, 39))))
>>>>>>> Stashed changes
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 788, Short.MAX_VALUE)
                .addContainerGap())
<<<<<<< Updated upstream
=======
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnBook)
                .addGap(36, 36, 36))
>>>>>>> Stashed changes
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblName)
                    .addComponent(txtDepartureAirport, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblAge)
<<<<<<< Updated upstream
                    .addComponent(txtDestination, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblDepartureDate)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(txtDepartureDate, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnSearch)))
                .addGap(23, 23, 23)
=======
                    .addComponent(cmbDeparture, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbDestination, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDepartureDate)
                    .addComponent(cmbDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
>>>>>>> Stashed changes
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblClass)
                    .addComponent(cmbSeatClass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblNumberOfPassengers)
                    .addComponent(txtNoOfPassengers, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
<<<<<<< Updated upstream
                    .addComponent(btnBook))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 62, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(48, 48, 48))
=======
                    .addComponent(btnSearch))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnBook)
                .addContainerGap(48, Short.MAX_VALUE))
>>>>>>> Stashed changes
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtNoOfPassengersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNoOfPassengersActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNoOfPassengersActionPerformed

    private void txtDepartureAirportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDepartureAirportActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDepartureAirportActionPerformed

    private void txtDestinationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDestinationActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDestinationActionPerformed

    private void txtDepartureDateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDepartureDateActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDepartureDateActionPerformed

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnSearchActionPerformed

    private void cmbSeatClassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbSeatClassActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbSeatClassActionPerformed

    private void btnBookActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBookActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnBookActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBook;
    private javax.swing.JButton btnSearch;
    private javax.swing.JComboBox<String> cmbSeatClass;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblAge;
    private javax.swing.JLabel lblClass;
    private javax.swing.JLabel lblDepartureDate;
    private javax.swing.JLabel lblName;
    private javax.swing.JLabel lblNumberOfPassengers;
    private javax.swing.JTable tblFlights;
    private javax.swing.JTextField txtDepartureAirport;
    private javax.swing.JTextField txtDepartureDate;
    private javax.swing.JTextField txtDestination;
    private javax.swing.JTextField txtNoOfPassengers;
    // End of variables declaration//GEN-END:variables
}
