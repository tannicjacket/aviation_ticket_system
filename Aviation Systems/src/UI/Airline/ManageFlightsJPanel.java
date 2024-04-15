/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package UI.Airline;

import Airline.AirlineCompany;
import Business.AirlineBusiness;
import Flight.Flight;
import java.awt.CardLayout;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author martta
 */
public class ManageFlightsJPanel extends javax.swing.JPanel {
    JPanel mainWorkArea;
    AirlineBusiness ab;
    AirlineCompany ac;
    /**
     * Creates new form ManageFlightsJPanel
     */
    public ManageFlightsJPanel(AirlineBusiness ab,JPanel mainWorkArea, AirlineCompany ac) {
        initComponents();
        this.ab = ab;
        this.mainWorkArea = mainWorkArea;    
        this.ac = ac;
        
        populateTable();
    }
    
    public void populateTable() {
        List<Flight> flightsList = ac.getFlightDirectory().getFlights();

        DefaultTableModel model = (DefaultTableModel) tblFlights.getModel();
        model.setRowCount(0); 

        for (Flight flight : flightsList) {
            Object[] row = new Object[7]; 
            row[0] = flight.getFlightNumber();
            row[1] = flight.getDepartureStation();
            row[2] = flight.getArrivalStation();
            row[3] = flight.getDepartureTime();
            row[4] = flight.getArrivalTime();
            row[5] = flight.getDate(); 
            row[6] = flight.getSeatsCapacity();

            model.addRow(row); 
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

        jScrollPane1 = new javax.swing.JScrollPane();
        tblFlights = new javax.swing.JTable();
        lblMngFlights = new javax.swing.JLabel();
        btnAddNewFlights = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();

        tblFlights.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Flight No.", "Departure", "Destination", "Departure Time", "Arrival Time", "Date", "Seats Capacity"
            }
        ));
        jScrollPane1.setViewportView(tblFlights);

        lblMngFlights.setText("Manage Flights");

        btnAddNewFlights.setText("Add New Flights");
        btnAddNewFlights.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddNewFlightsActionPerformed(evt);
            }
        });

        btnDelete.setText("Delete");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(lblMngFlights))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 680, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(btnAddNewFlights)
                        .addGap(41, 41, 41)
                        .addComponent(btnDelete)))
                .addContainerGap(24, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(103, 103, 103)
                .addComponent(lblMngFlights)
                .addGap(12, 12, 12)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAddNewFlights)
                    .addComponent(btnDelete))
                .addContainerGap(118, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddNewFlightsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddNewFlightsActionPerformed
        // TODO add your handling code here:
        AddNewFlightJPanel afjp = new AddNewFlightJPanel(ac,mainWorkArea);
        mainWorkArea.add("AddNewFlightJPanel",afjp);
        CardLayout layout = (CardLayout) mainWorkArea.getLayout();
        layout.next(mainWorkArea);
        
    }//GEN-LAST:event_btnAddNewFlightsActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        // TODO add your handling code here:
        int selectedRow = tblFlights.getSelectedRow();
        if (selectedRow >= 0) {
            String flightNumber = (String) tblFlights.getValueAt(selectedRow, 0);
            ac.getFlightDirectory().removeFlight(flightNumber);
            populateTable();
            JOptionPane.showMessageDialog(null, "Flight deleted successfully!");
        } else {
            JOptionPane.showMessageDialog(null, "Please select a flight to delete.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnDeleteActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddNewFlights;
    private javax.swing.JButton btnDelete;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblMngFlights;
    private javax.swing.JTable tblFlights;
    // End of variables declaration//GEN-END:variables
}
