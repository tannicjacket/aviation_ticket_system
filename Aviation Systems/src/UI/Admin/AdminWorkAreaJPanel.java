/*
 * ProductManagerWorkAreaJPanel.java
 *
 * Created on October 3, 2008, 8:06 AM
 */
package UI.Supplier;



/**
 *
 * @author Rushabh
 */
public class SupplierWorkAreaJPanel extends javax.swing.JPanel {

    
    // MasterOrderCatalog masterOrderCatalog;

    /**
     * Creates new form ProductManagerWorkAreaJPanel
     */

    public SupplierWorkAreaJPanel() {
        
        
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
        btnViewFlightSchedule = new javax.swing.JButton();
        Performance = new javax.swing.JButton();
        btnMngAirlineCompany = new javax.swing.JButton();
        BtnManageDistributor = new javax.swing.JButton();
        workArea = new javax.swing.JPanel();

        splitPane.setDividerLocation(50);
        splitPane.setOrientation(javax.swing.JSplitPane.VERTICAL_SPLIT);

        menuBar.setBackground(new java.awt.Color(242, 249, 255));
        menuBar.setPreferredSize(new java.awt.Dimension(800, 100));

<<<<<<< Updated upstream:Aviation Systems/src/UI/Supplier/SupplierWorkAreaJPanel.java
        btnLogOut.setText("Log Out");
        btnLogOut.addActionListener(new java.awt.event.ActionListener() {
=======
        btnViewFlightSchedule.setFont(new java.awt.Font("Amazon Ember", 0, 14)); // NOI18N
        btnViewFlightSchedule.setText("View Flight Schedule");
        btnViewFlightSchedule.addActionListener(new java.awt.event.ActionListener() {
>>>>>>> Stashed changes:Aviation Systems/src/UI/Admin/AdminWorkAreaJPanel.java
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLogOutActionPerformed(evt);
            }
        });

        btnViewFlightSchedule.setText("View Flight Schedule");

        Performance.setText("Performance");
        Performance.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PerformanceActionPerformed(evt);
            }
        });

        btnMngAirlineCompany.setFont(new java.awt.Font("Amazon Ember", 0, 14)); // NOI18N
        btnMngAirlineCompany.setText("Manage Airline Company");

<<<<<<< Updated upstream:Aviation Systems/src/UI/Supplier/SupplierWorkAreaJPanel.java
        BtnManageDistributor.setText("Manage Distributor");
=======
        btnManageDistributor.setFont(new java.awt.Font("Amazon Ember", 0, 14)); // NOI18N
        btnManageDistributor.setText("Manage Distributor");
        btnManageDistributor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnManageDistributorActionPerformed(evt);
            }
        });

        btnViewAllTickets.setFont(new java.awt.Font("Amazon Ember", 0, 14)); // NOI18N
        btnViewAllTickets.setText("View All Tickets");
        btnViewAllTickets.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnViewAllTicketsActionPerformed(evt);
            }
        });

        btnlogout.setFont(new java.awt.Font("Amazon Ember", 1, 14)); // NOI18N
        btnlogout.setText("Logout");
        btnlogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnlogoutActionPerformed(evt);
            }
        });
>>>>>>> Stashed changes:Aviation Systems/src/UI/Admin/AdminWorkAreaJPanel.java

        javax.swing.GroupLayout menuBarLayout = new javax.swing.GroupLayout(menuBar);
        menuBar.setLayout(menuBarLayout);
        menuBarLayout.setHorizontalGroup(
            menuBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, menuBarLayout.createSequentialGroup()
                .addGap(15, 15, 15)
<<<<<<< Updated upstream:Aviation Systems/src/UI/Supplier/SupplierWorkAreaJPanel.java
                .addComponent(BtnManageDistributor)
                .addGap(26, 26, 26)
=======
                .addComponent(btnManageDistributor)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
>>>>>>> Stashed changes:Aviation Systems/src/UI/Admin/AdminWorkAreaJPanel.java
                .addComponent(btnMngAirlineCompany)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnViewFlightSchedule)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
<<<<<<< Updated upstream:Aviation Systems/src/UI/Supplier/SupplierWorkAreaJPanel.java
                .addComponent(Performance)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 44, Short.MAX_VALUE)
                .addComponent(btnLogOut)
                .addGap(46, 46, 46))
=======
                .addComponent(btnViewAllTickets)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
                .addComponent(btnlogout)
                .addGap(29, 29, 29))
>>>>>>> Stashed changes:Aviation Systems/src/UI/Admin/AdminWorkAreaJPanel.java
        );
        menuBarLayout.setVerticalGroup(
            menuBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, menuBarLayout.createSequentialGroup()
                .addContainerGap(20, Short.MAX_VALUE)
                .addGroup(menuBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnLogOut)
                    .addComponent(Performance)
                    .addComponent(btnViewFlightSchedule)
                    .addComponent(btnMngAirlineCompany)
                    .addComponent(BtnManageDistributor))
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
    private javax.swing.JButton BtnManageDistributor;
    private javax.swing.JButton Performance;
    private javax.swing.JButton btnLogOut;
    private javax.swing.JButton btnMngAirlineCompany;
    private javax.swing.JButton btnViewFlightSchedule;
    private javax.swing.JPanel menuBar;
    private javax.swing.JSplitPane splitPane;
    private javax.swing.JPanel workArea;
    // End of variables declaration//GEN-END:variables
}
