package UI.Faculty;

import Business.AirlineBusiness;
import Faculty.FacultyProfile;
import UI.Distributor.PriceManagementJPanel;
import UI.LoginInJPanel;
import java.awt.CardLayout;
import javax.swing.JPanel;



/**
 *
 * @author Rushabh
 */
public class FacultyWorkAreaJPanel extends javax.swing.JPanel {
    JPanel mainWorkArea;
    AirlineBusiness ab;
    FacultyProfile fp;
    
    public FacultyWorkAreaJPanel(AirlineBusiness ab,JPanel mainWorkArea, FacultyProfile fp) {
        initComponents();
        this.ab = ab;
        this.mainWorkArea = mainWorkArea; 
        this.fp = fp;
    }

   
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        splitPane = new javax.swing.JSplitPane();
        menuBar = new javax.swing.JPanel();
        btnUpdateMyProfile = new javax.swing.JButton();
        btnViewMyFlight = new javax.swing.JButton();
        btnlogout = new javax.swing.JButton();
        workArea = new javax.swing.JPanel();

        splitPane.setDividerLocation(50);
        splitPane.setOrientation(javax.swing.JSplitPane.VERTICAL_SPLIT);

        menuBar.setBackground(new java.awt.Color(255, 255, 255));

        btnUpdateMyProfile.setText("Update My Profile");
        btnUpdateMyProfile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateMyProfileActionPerformed(evt);
            }
        });

        btnViewMyFlight.setText("View My Flight");
        btnViewMyFlight.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnViewMyFlightActionPerformed(evt);
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
                .addComponent(btnViewMyFlight)
                .addGap(18, 18, 18)
                .addComponent(btnUpdateMyProfile)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 390, Short.MAX_VALUE)
                .addComponent(btnlogout)
                .addGap(31, 31, 31))
        );
        menuBarLayout.setVerticalGroup(
            menuBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, menuBarLayout.createSequentialGroup()
                .addContainerGap(21, Short.MAX_VALUE)
                .addGroup(menuBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnUpdateMyProfile)
                    .addComponent(btnViewMyFlight)
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

    private void btnViewMyFlightActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnViewMyFlightActionPerformed
        // TODO add your handling code here:
        ViewMyFlightJPanel vmfjp = new ViewMyFlightJPanel(ab,workArea,fp);
        workArea.add("ViewMyFlightJPanel",vmfjp);
        CardLayout layout = (CardLayout) workArea.getLayout();
        layout.next(workArea);
    }//GEN-LAST:event_btnViewMyFlightActionPerformed

    private void btnUpdateMyProfileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateMyProfileActionPerformed
        // TODO add your handling code here:
        UpdateMyProfileJPanel umpjp = new UpdateMyProfileJPanel(ab,workArea,fp);
        workArea.add("UpdateMyProfileJPanel",umpjp);
        CardLayout layout = (CardLayout) workArea.getLayout();
        layout.next(workArea);
    }//GEN-LAST:event_btnUpdateMyProfileActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnUpdateMyProfile;
    private javax.swing.JButton btnViewMyFlight;
    private javax.swing.JButton btnlogout;
    private javax.swing.JPanel menuBar;
    private javax.swing.JSplitPane splitPane;
    private javax.swing.JPanel workArea;
    // End of variables declaration//GEN-END:variables
}
