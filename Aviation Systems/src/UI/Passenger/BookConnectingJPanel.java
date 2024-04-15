/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package UI.Passenger;

import Business.AirlineBusiness;
import Flight.Flight;
import Order.Order;
import Passenger.PassengerProfile;
import Ticket.ConnectTicket;
import Ticket.Ticket;
import com.github.javafaker.Faker;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Jiaen
 */
public class BookConnectingJPanel extends javax.swing.JPanel {
    JPanel mainWorkArea;
    AirlineBusiness ab;
    PassengerProfile pp;
    private final Faker faker = new Faker();
    /**
     * Creates new form BookConnectingJPanel
     */
    public BookConnectingJPanel(AirlineBusiness ab,JPanel mainWorkArea,PassengerProfile pp) {
        initComponents();
        this.ab = ab;
        this.mainWorkArea = mainWorkArea;
        this.pp = pp;
        
        populateComboBoxes();
    }
    
    private void populateComboBoxes() {
        String[] cities = ab.getAvailableCities().toArray(new String[0]);
        Arrays.sort(cities);
        cmbDeparture.setModel(new DefaultComboBoxModel<>(cities));
        cmbDestination.setModel(new DefaultComboBoxModel<>(cities));

        String[] dates = generateDateOptions();
        cmbDate.setModel(new DefaultComboBoxModel<>(dates));

        String[] seatClasses = {"ECONOMY", "BUSINESS", "FIRST_CLASS"};
        cmbSeatClass.setModel(new DefaultComboBoxModel<>(seatClasses));
    }

    private String[] generateDateOptions() {
        List<String> dateOptions = new ArrayList<>();
        dateOptions.add("Any Date");
        LocalDate start = LocalDate.now();
        LocalDate end = start.plusYears(1);
        while (!start.isAfter(end)) {
            dateOptions.add(start.toString());
            start = start.plusDays(1);
        }
        return dateOptions.toArray(new String[0]);
    }
    
    private void populateTable() {
        DefaultTableModel model = (DefaultTableModel) tblFlights.getModel();
        model.setRowCount(0);

        String selectedDeparture = cmbDeparture.getSelectedItem().toString();
        String selectedDestination = cmbDestination.getSelectedItem().toString();
        String selectedDate = cmbDate.getSelectedItem().toString();
        String selectedClass = cmbSeatClass.getSelectedItem().toString();

        List<Flight> flights = ab.getFlightDirectory().getFlights();
        HashMap<String, Object[]> bestPrices = new HashMap<>();

        // filter for connecting flights
        for (int i = 0; i < flights.size(); i++) {
            Flight firstLeg = flights.get(i);
            if (firstLeg.getDepartureStation().getCityName().equals(selectedDeparture) &&
                (selectedDate.equals("Any Date") || firstLeg.getDepartureTime().toLocalDate().toString().equals(selectedDate))) {
                for (int j = 0; j < flights.size(); j++) {
                    Flight secondLeg = flights.get(j);
                    if (secondLeg.getArrivalStation().getCityName().equals(selectedDestination) &&
                        firstLeg.getArrivalStation().getCityName().equals(secondLeg.getDepartureStation().getCityName()) &&
                        firstLeg.getArrivalTime().isBefore(secondLeg.getDepartureTime())) {

                        double firstLegPrice = getLowestPrice(firstLeg, selectedClass);
                        double secondLegPrice = getLowestPrice(secondLeg, selectedClass);

                        if (firstLegPrice >= 0 && secondLegPrice >= 0) {  // Make sure two legs all have legal prices
                            double totalPrice = firstLegPrice + secondLegPrice;
                            String key = firstLeg.getFlightNumber() + "->" + secondLeg.getFlightNumber();

                            if (!bestPrices.containsKey(key) || (Double) bestPrices.get(key)[6] > totalPrice) {
                                bestPrices.put(key, new Object[]{
                                    firstLeg.getDepartureTime(),
                                    secondLeg.getDepartureStation().getCityName(),
                                    secondLeg.getArrivalTime(),
                                    firstLeg.getAirlineCompany().getName(),
                                    key,
                                    selectedClass,
                                    totalPrice
                                });
                            }
                        }
                    }
                }
            }
        }

        for (Object[] row : bestPrices.values()) {
            model.addRow(new Object[]{
                row[0], row[1], row[2], row[3], row[4], row[5], String.format("%.2f", row[6])
            });
        }
    }

    private double getLowestPrice(Flight flight, String seatClass) {
        return flight.getTickets().stream()
            .filter(ticket -> ticket.getCabinClass().name().equalsIgnoreCase(seatClass) && ticket.getStatus() == Ticket.TicketStatus.AVAILABLE)
            .mapToDouble(Ticket::getPrice)
            .min()
            .orElse(-1);  // -1 means no suitable price
    }
    
    // Helper method to get available tickets for a flight
    private List<Ticket> getAvailableTickets(String flightNumber, int requiredTickets) {
        return ab.getFlightDirectory().getFlightByNumber(flightNumber).getTickets().stream()
            .filter(ticket -> ticket.getStatus() == Ticket.TicketStatus.AVAILABLE)
            .limit(requiredTickets)
            .collect(Collectors.toList());
    }



    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblBookTickets = new javax.swing.JLabel();
        lblName = new javax.swing.JLabel();
        cmbDeparture = new javax.swing.JComboBox<>();
        cmbDestination = new javax.swing.JComboBox<>();
        lblDepartureDate = new javax.swing.JLabel();
        cmbDate = new javax.swing.JComboBox<>();
        btnSearch = new javax.swing.JButton();
        lblClass = new javax.swing.JLabel();
        cmbSeatClass = new javax.swing.JComboBox<>();
        lblNumberOfPassengers = new javax.swing.JLabel();
        txtNoOfPassengers = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblFlights = new javax.swing.JTable();
        btnBook = new javax.swing.JButton();

        lblBookTickets.setText("Book Tickets(Connecting Trip)");

        lblName.setFont(new java.awt.Font("Helvetica Neue", 1, 13)); // NOI18N
        lblName.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblName.setText("Departure Airport");

        cmbDeparture.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        cmbDestination.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        lblDepartureDate.setFont(new java.awt.Font("Helvetica Neue", 1, 13)); // NOI18N
        lblDepartureDate.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblDepartureDate.setText("Departure Date");

        cmbDate.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        btnSearch.setText("Search");
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });

        lblClass.setFont(new java.awt.Font("Helvetica Neue", 1, 13)); // NOI18N
        lblClass.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblClass.setText("Seat Class");

        cmbSeatClass.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cmbSeatClass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbSeatClassActionPerformed(evt);
            }
        });

        lblNumberOfPassengers.setFont(new java.awt.Font("Helvetica Neue", 1, 13)); // NOI18N
        lblNumberOfPassengers.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblNumberOfPassengers.setText("No. of Passengers");

        txtNoOfPassengers.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNoOfPassengersActionPerformed(evt);
            }
        });

        tblFlights.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Departure Time", "Transit Station", "Arrival Time", "Airline", "Flight No.", "Class", "Lowest Price"
            }
        ));
        jScrollPane1.setViewportView(tblFlights);

        btnBook.setText("Book");
        btnBook.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBookActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(lblBookTickets)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(lblName)
                                    .addComponent(lblDepartureDate))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(cmbDate, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(cmbDeparture, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(89, 89, 89)
                                        .addComponent(cmbDestination, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 240, Short.MAX_VALUE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addGap(251, 251, 251)
                                        .addComponent(btnSearch))))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblClass)
                                .addGap(18, 18, 18)
                                .addComponent(cmbSeatClass, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(lblNumberOfPassengers)
                                .addGap(18, 18, 18)
                                .addComponent(txtNoOfPassengers, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGap(36, 36, 36))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 556, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnBook)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addComponent(lblBookTickets)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblName)
                    .addComponent(cmbDeparture, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbDestination, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblDepartureDate)
                        .addComponent(cmbDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnSearch))
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblClass)
                    .addComponent(cmbSeatClass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblNumberOfPassengers)
                    .addComponent(txtNoOfPassengers, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnBook)
                .addContainerGap(162, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        // TODO add your handling code here:
        populateTable();
    }//GEN-LAST:event_btnSearchActionPerformed

    private void cmbSeatClassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbSeatClassActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbSeatClassActionPerformed

    private void txtNoOfPassengersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNoOfPassengersActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNoOfPassengersActionPerformed

    private void btnBookActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBookActionPerformed
    int selectedRow = tblFlights.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(null, "Please select a connecting flight to book.");
            return;
        }

        String noOfPassengersText = txtNoOfPassengers.getText();
        if (noOfPassengersText.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please enter the number of passengers.");
            return;
        }

        int numberOfPassengers;
        try {
            numberOfPassengers = Integer.parseInt(noOfPassengersText);
            if (numberOfPassengers <= 0) {
                throw new NumberFormatException("Number of passengers must be positive.");
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Please enter a valid number of passengers.");
            return;
        }

        // get two flight numbers
        String flightNumbers = tblFlights.getValueAt(selectedRow, 4).toString();
        String[] flights = flightNumbers.split("->");
        if (flights.length != 2) {
            JOptionPane.showMessageDialog(null, "Error in flight number format.");
            return;
        }

        // 验证两段航班都有足够的票
        List<Ticket> firstLegTickets = getAvailableTickets(flights[0], numberOfPassengers);
        List<Ticket> secondLegTickets = getAvailableTickets(flights[1], numberOfPassengers);

        if (firstLegTickets.size() < numberOfPassengers || secondLegTickets.size() < numberOfPassengers) {
            JOptionPane.showMessageDialog(null, "Not enough available tickets for this connecting flight.");
            return;
        }

        // 创建订单并添加两段航班的票
        Order order = new Order(faker.bothify("ORD###"), pp);
        firstLegTickets.forEach(ticket -> {
            ticket.reserveTicket();
            order.addTicket(ticket);
        });
        secondLegTickets.forEach(ticket -> {
            ticket.reserveTicket();
            order.addTicket(ticket);
        });

        ab.getOrderDirectory().addOrder(order);
        pp.addOrder(order);
        JOptionPane.showMessageDialog(null, "Tickets booked successfully!");
    }//GEN-LAST:event_btnBookActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBook;
    private javax.swing.JButton btnSearch;
    private javax.swing.JComboBox<String> cmbDate;
    private javax.swing.JComboBox<String> cmbDeparture;
    private javax.swing.JComboBox<String> cmbDestination;
    private javax.swing.JComboBox<String> cmbSeatClass;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblBookTickets;
    private javax.swing.JLabel lblClass;
    private javax.swing.JLabel lblDepartureDate;
    private javax.swing.JLabel lblName;
    private javax.swing.JLabel lblNumberOfPassengers;
    private javax.swing.JTable tblFlights;
    private javax.swing.JTextField txtNoOfPassengers;
    // End of variables declaration//GEN-END:variables
}
