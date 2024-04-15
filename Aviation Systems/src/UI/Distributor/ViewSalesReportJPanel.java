
package UI.Distributor;

import Airline.AirlineCompany;
import Business.AirlineBusiness;
import Distributor.Distributor;
import Order.Order;
import Order.OrderDirectory;
import Ticket.Ticket;
import java.time.LocalDateTime;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.stream.Collectors;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author martta
 */
public class ViewSalesReportJPanel extends javax.swing.JPanel {
    JPanel mainWorkArea;
    AirlineBusiness ab;
    Distributor dis;
    
    /**
     * Creates new form ViewSalesReportJPanel
     */
    public ViewSalesReportJPanel(AirlineBusiness ab,JPanel mainWorkArea,Distributor dis) {
        initComponents();
        this.ab = ab;
        this.mainWorkArea = mainWorkArea;    
        this.dis = dis;
        
        populateMonthComboBox();
        populateClassComboBox();
        populateAgeComboBox();
        updateSalesTable();
    }
    
    private void populateMonthComboBox() {
        String[] months = {"All Year", "January", "February", "March", "April", "May", "June",
                           "July", "August", "September", "October", "November", "December"};
        cmbMonth.setModel(new javax.swing.DefaultComboBoxModel<>(months));
        cmbMonth.setSelectedIndex(0); // Set default to 'All Year'
    }


    private void populateClassComboBox() {
        String[] classes = {"ECONOMY", "BUSINESS", "FIRST_CLASS"};
        cmbClass.setModel(new javax.swing.DefaultComboBoxModel<>(classes));
    }

    private void populateAgeComboBox() {
            String[] ageRanges = {"All Ages", "0-18", "19-35", "36-60", "61+"};
            cmbAge.setModel(new javax.swing.DefaultComboBoxModel<>(ageRanges));
        }
    
    private List<Order> filterOrders(String selectedMonth, String selectedClass, String selectedAgeRange) {
        List<Order> filteredOrders = new ArrayList<>();
        for (Order order : ab.getOrderDirectory().getAllOrders()) {
            for (Ticket ticket : order.getTickets()) {
                boolean monthMatch = selectedMonth.equals("All Year") ||
                                     ticket.getFlight().getDepartureTime().getMonth().toString().equalsIgnoreCase(selectedMonth);
          
                boolean classMatch = ticket.getCabinClass().name().equalsIgnoreCase(selectedClass);
                if (monthMatch && classMatch &&
                    isAgeMatch(order.getPassenger().getAge(), selectedAgeRange) &&
                    isOrderFromDistributor(ticket, dis)) {
                    filteredOrders.add(order);
                    break; // Avoid adding the same order multiple times
                }
            }
        }
        return filteredOrders;
    }

    private boolean isOrderFromDistributor(Ticket ticket, Distributor distributor) {
        // To get Distributor from Order: order-ticket-flight-AirlineCompany, the go through ADAssignment to match the distributor with AirlineCompany
        AirlineCompany company = ticket.getFlight().getAirlineCompany();
        // Find matched distributor with company
        return ab.getADassignmentDirectory().getAssignments().stream()
            .anyMatch(assignment -> assignment.getAirlineCompany().equals(company) &&
                                    assignment.getDistributor().equals(distributor));
    }



    private boolean isAgeMatch(int age, String ageRange) {
        if (ageRange.equals("All Ages")) return true;
        if (ageRange.contains("-")) {
            int lowerBound = Integer.parseInt(ageRange.split("-")[0].trim());
            int upperBound = Integer.parseInt(ageRange.split("-")[1].trim());
            return age >= lowerBound && age <= upperBound;
        }
        // Special Ops
        if (ageRange.equals("61+")) {
            return age >= 61;
        }
        return false; // Default false
    }

    
    private void updateSalesTable() {
        String selectedMonth = cmbMonth.getSelectedItem().toString();
        String selectedClass = cmbClass.getSelectedItem().toString();
        String selectedAgeRange = cmbAge.getSelectedItem().toString();

        List<Order> filteredOrders = filterOrders(selectedMonth, selectedClass, selectedAgeRange);

        DefaultTableModel model = (DefaultTableModel) tblSales.getModel();
        model.setRowCount(0);

        Map<String, List<Ticket>> ticketsByFlight = filteredOrders.stream()
            .flatMap(order -> order.getTickets().stream())
            .collect(Collectors.groupingBy(ticket -> ticket.getFlight().getFlightNumber()));

        for (Map.Entry<String, List<Ticket>> entry : ticketsByFlight.entrySet()) {
            String flightNumber = entry.getKey();
            List<Ticket> tickets = entry.getValue();
            double price = tickets.get(0).getPrice(); // Assume Same flight Same price for all tickets
            long bookingCount = tickets.size();
            double totalSales = price * bookingCount;
            
            String formattedPrice = String.format("%.2f", price);
            String formattedTotalSales = String.format("%.2f", totalSales);
            
            model.addRow(new Object[]{flightNumber, selectedClass, formattedPrice, bookingCount, formattedTotalSales});
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

        lblViewSalesReport = new javax.swing.JLabel();
        lblClass = new javax.swing.JLabel();
        lblMonth = new javax.swing.JLabel();
        cmbMonth = new javax.swing.JComboBox<>();
        cmbClass = new javax.swing.JComboBox<>();
        lblPassengerAge = new javax.swing.JLabel();
        cmbAge = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblSales = new javax.swing.JTable();

        lblViewSalesReport.setText("View Sales Report");

        lblClass.setFont(new java.awt.Font("Helvetica Neue", 1, 13)); // NOI18N
        lblClass.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblClass.setText("CabinClass");

        lblMonth.setFont(new java.awt.Font("Helvetica Neue", 1, 13)); // NOI18N
        lblMonth.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblMonth.setText("Month:");

        cmbMonth.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cmbMonth.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbMonthActionPerformed(evt);
            }
        });

        cmbClass.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cmbClass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbClassActionPerformed(evt);
            }
        });

        lblPassengerAge.setFont(new java.awt.Font("Helvetica Neue", 1, 13)); // NOI18N
        lblPassengerAge.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblPassengerAge.setText("Passenger Age");

        cmbAge.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cmbAge.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbAgeActionPerformed(evt);
            }
        });

        tblSales.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Flight No.", "Class", "Price", "Booking Quantity", "Total Sales"
            }
        ));
        jScrollPane1.setViewportView(tblSales);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblMonth)
                        .addGap(18, 18, 18)
                        .addComponent(cmbMonth, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblClass)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cmbClass, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addComponent(lblPassengerAge)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cmbAge, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lblViewSalesReport))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(lblViewSalesReport)
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblMonth)
                    .addComponent(cmbMonth, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblClass)
                    .addComponent(cmbClass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblPassengerAge)
                    .addComponent(cmbAge, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(277, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void cmbMonthActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbMonthActionPerformed
        // TODO add your handling code here:
        updateSalesTable();
    }//GEN-LAST:event_cmbMonthActionPerformed

    private void cmbClassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbClassActionPerformed
        // TODO add your handling code here:
        updateSalesTable();
    }//GEN-LAST:event_cmbClassActionPerformed

    private void cmbAgeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbAgeActionPerformed
        // TODO add your handling code here:
        updateSalesTable();
    }//GEN-LAST:event_cmbAgeActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cmbAge;
    private javax.swing.JComboBox<String> cmbClass;
    private javax.swing.JComboBox<String> cmbMonth;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblClass;
    private javax.swing.JLabel lblMonth;
    private javax.swing.JLabel lblPassengerAge;
    private javax.swing.JLabel lblViewSalesReport;
    private javax.swing.JTable tblSales;
    // End of variables declaration//GEN-END:variables
}
