/*
 * ProductManagerWorkAreaJPanel.java
 *
 * Created on October 3, 2008, 8:06 AM
 */
package UI.Faculty;



/**
 *
 * @author Rushabh
 */
public class FacultyWorkAreaJPanel extends javax.swing.JPanel {

    
    // MasterOrderCatalog masterOrderCatalog;

    /**
     * Creates new form ProductManagerWorkAreaJPanel
     */

    public FacultyWorkAreaJPanel() {
        
        
    }

   


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        splitPane = new javax.swing.JSplitPane();
        menuBar = new javax.swing.JPanel();
        btnLogOut = new javax.swing.JButton();
        btnUpdateMyProfile = new javax.swing.JButton();
        btnViewMyFlight = new javax.swing.JButton();
        workArea = new javax.swing.JPanel();

        splitPane.setDividerLocation(50);
        splitPane.setOrientation(javax.swing.JSplitPane.VERTICAL_SPLIT);

        menuBar.setBackground(new java.awt.Color(242, 249, 255));

<<<<<<< Updated upstream
        btnLogOut.setText("Log Out");
        btnLogOut.addActionListener(new java.awt.event.ActionListener() {
=======
        btnUpdateMyProfile.setFont(new java.awt.Font("Amazon Ember", 0, 14)); // NOI18N
        btnUpdateMyProfile.setText("Update My Profile");
        btnUpdateMyProfile.addActionListener(new java.awt.event.ActionListener() {
>>>>>>> Stashed changes
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLogOutActionPerformed(evt);
            }
        });

<<<<<<< Updated upstream
        btnUpdateMyProfile.setText("Update My Profile");

        btnViewMyFlight.setText("View My Flight");
=======
        btnViewMyFlight.setFont(new java.awt.Font("Amazon Ember", 0, 14)); // NOI18N
        btnViewMyFlight.setText("View My Flight");
        btnViewMyFlight.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnViewMyFlightActionPerformed(evt);
            }
        });

        btnlogout.setFont(new java.awt.Font("Amazon Ember", 1, 14)); // NOI18N
        btnlogout.setText("Logout");
        btnlogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnlogoutActionPerformed(evt);
            }
        });
>>>>>>> Stashed changes

        javax.swing.GroupLayout menuBarLayout = new javax.swing.GroupLayout(menuBar);
        menuBar.setLayout(menuBarLayout);
        menuBarLayout.setHorizontalGroup(
            menuBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, menuBarLayout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(btnViewMyFlight)
                .addGap(18, 18, 18)
                .addComponent(btnUpdateMyProfile)
<<<<<<< Updated upstream
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 371, Short.MAX_VALUE)
                .addComponent(btnLogOut)
                .addGap(46, 46, 46))
=======
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 369, Short.MAX_VALUE)
                .addComponent(btnlogout)
                .addGap(31, 31, 31))
>>>>>>> Stashed changes
        );
        menuBarLayout.setVerticalGroup(
            menuBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, menuBarLayout.createSequentialGroup()
                .addContainerGap(20, Short.MAX_VALUE)
                .addGroup(menuBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnLogOut)
                    .addComponent(btnUpdateMyProfile)
                    .addComponent(btnViewMyFlight))
                .addContainerGap())
        );

        splitPane.setTopComponent(menuBar);

        workArea.setBackground(new java.awt.Color(242, 249, 255));
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

    private void btnManageProductCatalogActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnManageProductCatalogActionPerformed
        // TODO add your handling code here:
        
    }// GEN-LAST:event_btnManageProductCatalogActionPerformed

    private void PerformanceActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_PerformanceActionPerformed
        // TODO add your handling code here:
        // ProductReportJPanel prjp = new workArea(userProcessContainer, supplier);
        // workArea.add("ProductReportJPanelSupplier", prjp);
        // CardLayout layout = (CardLayout)workArea.getLayout();
        // layout.next(userProcessContainer);
    }// GEN-LAST:event_PerformanceActionPerformed

    private void btnSupplierProfileActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnSupplierProfileActionPerformed
        
    }// GEN-LAST:event_btnSupplierProfileActionPerformed

    private void btnLogOutActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnLogOutActionPerformed
        // TODO add your handling code here:

       

    }// GEN-LAST:event_btnLogOutActionPerformed

   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLogOut;
    private javax.swing.JButton btnUpdateMyProfile;
    private javax.swing.JButton btnViewMyFlight;
    private javax.swing.JPanel menuBar;
    private javax.swing.JSplitPane splitPane;
    private javax.swing.JPanel workArea;
    // End of variables declaration//GEN-END:variables
}
