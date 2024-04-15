/*
 * ProductManagerWorkAreaJPanel.java
 *
 * Created on October 3, 2008, 8:06 AM
 */
package UI.Airline;

import Airline.AirlineCompany;
import Business.AirlineBusiness;
import UI.Faculty.*;
import UI.LoginInJPanel;
import java.awt.CardLayout;
import javax.swing.JPanel;



/**
 *
 * @author Rushabh
 */
public class AirlineWorkAreaJPanel extends javax.swing.JPanel {
    JPanel mainWorkArea;
    AirlineBusiness ab;
    AirlineCompany ac;
    

    public AirlineWorkAreaJPanel(AirlineBusiness ab,JPanel mainWorkArea, AirlineCompany ac) {
        initComponents();
        this.ab = ab;
        this.mainWorkArea = mainWorkArea;    
        this.ac = ac;
    }

   


    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        splitPane = new javax.swing.JSplitPane();
        menuBar = new javax.swing.JPanel();
        btnAssignFaculty = new javax.swing.JButton();
        btnMngFaculty = new javax.swing.JButton();
        btnMngFlight = new javax.swing.JButton();
        btnlogout = new javax.swing.JButton();
        workArea = new javax.swing.JPanel();

        splitPane.setDividerLocation(50);
        splitPane.setOrientation(javax.swing.JSplitPane.VERTICAL_SPLIT);

        menuBar.setBackground(new java.awt.Color(255, 255, 255));

        btnAssignFaculty.setText("Assign Faculty");
        btnAssignFaculty.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAssignFacultyActionPerformed(evt);
            }
        });

        btnMngFaculty.setText("Manage Faculty");
        btnMngFaculty.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMngFacultyActionPerformed(evt);
            }
        });

        btnMngFlight.setText("Manage Flight");
        btnMngFlight.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMngFlightActionPerformed(evt);
            }
        });

        btnlogout.setText("Logout");
        btnlogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnlogoutActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout menuBarLayout = new javax.swing.GroupLayout(menuBar);
        menuBar.setLayout(menuBarLayout);
        menuBarLayout.setHorizontalGroup(
            menuBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, menuBarLayout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(btnMngFaculty)
                .addGap(18, 18, 18)
                .addComponent(btnAssignFaculty)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnMngFlight)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 260, Short.MAX_VALUE)
                .addComponent(btnlogout)
                .addGap(54, 54, 54))
        );
        menuBarLayout.setVerticalGroup(
            menuBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, menuBarLayout.createSequentialGroup()
                .addContainerGap(21, Short.MAX_VALUE)
                .addGroup(menuBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAssignFaculty)
                    .addComponent(btnMngFaculty)
                    .addComponent(btnMngFlight)
                    .addComponent(btnlogout))
                .addContainerGap())
        );

        splitPane.setTopComponent(menuBar);

        workArea.setBackground(new java.awt.Color(255, 255, 255));
        workArea.setLayout(new java.awt.CardLayout());
        splitPane.setRightComponent(workArea);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 800, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(splitPane, javax.swing.GroupLayout.PREFERRED_SIZE, 800, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 600, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(splitPane, javax.swing.GroupLayout.PREFERRED_SIZE, 600, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnlogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnlogoutActionPerformed

        mainWorkArea.removeAll();
        LoginInJPanel ljp = new LoginInJPanel(ab,mainWorkArea);
        mainWorkArea.add("LoginInJPanel",ljp);
        ((java.awt.CardLayout) mainWorkArea.getLayout()).next(mainWorkArea);
    }//GEN-LAST:event_btnlogoutActionPerformed

    private void btnMngFacultyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMngFacultyActionPerformed
        // TODO add your handling code here:
        ManageFacultyJPanel mfjp = new ManageFacultyJPanel(ab,workArea,ac);
        workArea.add("ManageFacultyJPanel",mfjp);
        CardLayout layout = (CardLayout) workArea.getLayout();
        layout.next(workArea);
    }//GEN-LAST:event_btnMngFacultyActionPerformed

    private void btnAssignFacultyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAssignFacultyActionPerformed
        // TODO add your handling code here:
        AssignFacultyJPanel afjp = new AssignFacultyJPanel(ab,workArea,ac);
        workArea.add("AssignFacultyJPanel",afjp);
        CardLayout layout = (CardLayout) workArea.getLayout();
        layout.next(workArea);
    }//GEN-LAST:event_btnAssignFacultyActionPerformed

    private void btnMngFlightActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMngFlightActionPerformed
        // TODO add your handling code here:
        ManageFlightsJPanel manageflights = new ManageFlightsJPanel(ab,workArea,ac);
        workArea.add("ManageFlightsJPanel",manageflights);
        CardLayout layout = (CardLayout) workArea.getLayout();
        layout.next(workArea);
    }//GEN-LAST:event_btnMngFlightActionPerformed



   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAssignFaculty;
    private javax.swing.JButton btnMngFaculty;
    private javax.swing.JButton btnMngFlight;
    private javax.swing.JButton btnlogout;
    private javax.swing.JPanel menuBar;
    private javax.swing.JSplitPane splitPane;
    private javax.swing.JPanel workArea;
    // End of variables declaration//GEN-END:variables
}
