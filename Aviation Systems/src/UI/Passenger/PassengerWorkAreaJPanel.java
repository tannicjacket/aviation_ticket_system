/*
 * ProductManagerWorkAreaJPanel.java
 *
 * Created on October 3, 2008, 8:06 AM
 */
package UI.Passenger;

import UI.Faculty.*;



/**
 *
 * @author Rushabh
 */
public class PassengerWorkAreaJPanel extends javax.swing.JPanel {

    
    // MasterOrderCatalog masterOrderCatalog;

    /**
     * Creates new form ProductManagerWorkAreaJPanel
     */

    public PassengerWorkAreaJPanel() {
        
        
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
        btnBookRoundTrip = new javax.swing.JButton();
        btnBookTickets = new javax.swing.JButton();
        workArea = new javax.swing.JPanel();

        splitPane.setDividerLocation(50);
        splitPane.setOrientation(javax.swing.JSplitPane.VERTICAL_SPLIT);

        menuBar.setBackground(new java.awt.Color(242, 249, 255));

<<<<<<< Updated upstream
        btnLogOut.setText("Log Out");
        btnLogOut.addActionListener(new java.awt.event.ActionListener() {
=======
        btnBookRoundTrip.setFont(new java.awt.Font("Amazon Ember", 0, 14)); // NOI18N
        btnBookRoundTrip.setText("Book RoundTrip Tickets");
        btnBookRoundTrip.addActionListener(new java.awt.event.ActionListener() {
>>>>>>> Stashed changes
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLogOutActionPerformed(evt);
            }
        });

<<<<<<< Updated upstream
        btnBookRoundTrip.setText("Book Round Trip");

        btnBookTickets.setText("Book Tickets");
=======
        btnBookTickets.setFont(new java.awt.Font("Amazon Ember", 0, 14)); // NOI18N
        btnBookTickets.setText("Book Tickets");
        btnBookTickets.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBookTicketsActionPerformed(evt);
            }
        });

        btnlogout.setFont(new java.awt.Font("Amazon Ember", 1, 14)); // NOI18N
        btnlogout.setText("Logout");
        btnlogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnlogoutActionPerformed(evt);
            }
        });

        btnBookConnecting.setFont(new java.awt.Font("Amazon Ember", 0, 14)); // NOI18N
        btnBookConnecting.setText("Book ConnectingTrip Tickets");
        btnBookConnecting.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBookConnectingActionPerformed(evt);
            }
        });

        btnOrder.setFont(new java.awt.Font("Amazon Ember", 0, 14)); // NOI18N
        btnOrder.setText("View My Order");
        btnOrder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOrderActionPerformed(evt);
            }
        });
>>>>>>> Stashed changes

        javax.swing.GroupLayout menuBarLayout = new javax.swing.GroupLayout(menuBar);
        menuBar.setLayout(menuBarLayout);
        menuBarLayout.setHorizontalGroup(
            menuBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, menuBarLayout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(btnBookTickets)
                .addGap(18, 18, 18)
                .addComponent(btnBookRoundTrip)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 387, Short.MAX_VALUE)
                .addComponent(btnLogOut)
                .addGap(46, 46, 46))
        );
        menuBarLayout.setVerticalGroup(
            menuBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, menuBarLayout.createSequentialGroup()
                .addContainerGap(20, Short.MAX_VALUE)
                .addGroup(menuBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnLogOut)
                    .addComponent(btnBookRoundTrip)
                    .addComponent(btnBookTickets))
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
    private javax.swing.JButton btnBookRoundTrip;
    private javax.swing.JButton btnBookTickets;
    private javax.swing.JButton btnLogOut;
    private javax.swing.JPanel menuBar;
    private javax.swing.JSplitPane splitPane;
    private javax.swing.JPanel workArea;
    // End of variables declaration//GEN-END:variables
}
