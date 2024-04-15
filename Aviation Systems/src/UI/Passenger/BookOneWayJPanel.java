/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package UI.Passenger;

import Business.AirlineBusiness;
import Flight.Flight;
import Order.Order;
import Passenger.PassengerProfile;
import Ticket.Ticket;
import com.github.javafaker.Faker;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.stream.Collectors;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author martta
 */
public class BookOneWayJPanel extends javax.swing.JPanel {
    JPanel mainWorkArea;
    AirlineBusiness ab;
    PassengerProfile pp;
    private final Faker faker = new Faker();
    
    /**
     * Creates new form BookOneWayJPanel
     */
    public BookOneWayJPanel(AirlineBusiness ab,JPanel mainWorkArea,PassengerProfile pp) {
        initComponents();
        this.ab = ab;
        this.mainWorkArea = mainWorkArea;
        this.pp = pp;
        
        populateComboBoxes();
    }
    
    private void populateComboBoxes() {
        // Set available cities
        Set<String> cities = ab.getAvailableCities();
        String[] cityArray = cities.toArray(new String[0]);
        Arrays.sort(cityArray);
        cmbDeparture.setModel(new DefaultComboBoxModel<>(cityArray));
        cmbDestination.setModel(new DefaultComboBoxModel<>(cityArray));

        // Set seat classes
        cmbSeatClass.setModel(new DefaultComboBoxModel<>(new String[] {"ECONOMY", "BUSINESS", "FIRST_CLASS"}));

        // Set dates including "All Year"
        cmbDate.setModel(new DefaultComboBoxModel<>(generateDatesForYear().toArray(new String[0])));
        cmbDate.setSelectedIndex(0); // Select "All Year" by default
    }

    
    private List<String> generateDatesForYear() {
        List<String> dates = new ArrayList<>();
        dates.add("Any Date"); // Add "All Year" at the start of the list
        LocalDate startDate = LocalDate.now();
        LocalDate endDate = LocalDate.of(startDate.getYear(), 12, 31);
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd", Locale.ENGLISH);

        while (!startDate.isAfter(endDate)) {
            dates.add(dateFormatter.format(startDate));
            startDate = startDate.plusDays(1);
        }

        return dates;
    }

    private void populateTable() {
        DefaultTableModel model = (DefaultTableModel) tblFlights.getModel();
        model.setRowCount(0);

        String selectedDeparture = cmbDeparture.getSelectedItem().toString();
        String selectedDestination = cmbDestination.getSelectedItem().toString();
        String selectedDate = cmbDate.getSelectedItem().toString();
        String selectedClass = cmbSeatClass.getSelectedItem().toString();

        Set<String> addedFlights = new HashSet<>();  // To track added flights to avoid duplication

        for (Flight flight : ab.getFlightDirectory().getFlights()) {
            boolean matchDate = selectedDate.equals("Any Date") ||
                                flight.getDepartureTime().format(DateTimeFormatter.ofPattern("MMMM yyyy")).equals(selectedDate);

            if (flight.getDepartureStation().getCityName().equals(selectedDeparture) &&
                flight.getArrivalStation().getCityName().equals(selectedDestination) &&
                matchDate && !addedFlights.contains(flight.getFlightNumber())) {

                List<Ticket> matchingTickets = flight.getTickets().stream()
                    .filter(ticket -> ticket.getCabinClass().toString().equalsIgnoreCase(selectedClass) &&
                                      ticket.getStatus() == Ticket.TicketStatus.AVAILABLE)
                    .collect(Collectors.toList());

                if (!matchingTickets.isEmpty()) {
                    double minPrice = matchingTickets.stream()
                        .mapToDouble(Ticket::getPrice)
                        .min()
                        .orElse(Double.MAX_VALUE);

                    model.addRow(new Object[]{
                        DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm").format(flight.getDepartureTime()),
                        DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm").format(flight.getArrivalTime()),
                        flight.getAirlineCompany().getName(),
                        flight.getFlightNumber(),
                        selectedClass,
                        String.format("%.2f", minPrice)
                    });

                    addedFlights.add(flight.getFlightNumber()); // Mark this flight as added
                }
            }
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

        lblBookTickets = new javax.swing.JLabel();
        lblNumberOfPassengers = new javax.swing.JLabel();
        txtNoOfPassengers = new javax.swing.JTextField();
        lblName = new javax.swing.JLabel();
        lblAge = new javax.swing.JLabel();
        lblDepartureDate = new javax.swing.JLabel();
        btnSearch = new javax.swing.JButton();
        lblClass = new javax.swing.JLabel();
        cmbSeatClass = new javax.swing.JComboBox<>();
        btnBook = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblFlights = new javax.swing.JTable();
        cmbDeparture = new javax.swing.JComboBox<>();
        cmbDestination = new javax.swing.JComboBox<>();
        cmbDate = new javax.swing.JComboBox<>();

        lblBookTickets.setText("Book Tickets(One Way)");

        lblNumberOfPassengers.setFont(new java.awt.Font("Helvetica Neue", 1, 13)); // NOI18N
        lblNumberOfPassengers.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblNumberOfPassengers.setText("No. of Passengers");

        txtNoOfPassengers.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNoOfPassengersActionPerformed(evt);
            }
        });

        lblName.setFont(new java.awt.Font("Helvetica Neue", 1, 13)); // NOI18N
        lblName.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblName.setText("Departure Airport");

        lblAge.setFont(new java.awt.Font("Helvetica Neue", 1, 13)); // NOI18N
        lblAge.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblAge.setText("Destination");

        lblDepartureDate.setFont(new java.awt.Font("Helvetica Neue", 1, 13)); // NOI18N
        lblDepartureDate.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblDepartureDate.setText("Departure Date");

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

        btnBook.setText("Book");
        btnBook.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBookActionPerformed(evt);
            }
        });

        tblFlights.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Departure Time", "Arrival Time", "Airline", "Flight No.", "Class", "Lowest Price"
            }
        ));
        jScrollPane1.setViewportView(tblFlights);

        cmbDeparture.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        cmbDestination.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        cmbDate.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblName)
                            .addComponent(lblDepartureDate))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cmbDate, 0, 126, Short.MAX_VALUE)
                            .addComponent(cmbDeparture, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lblAge)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cmbDestination, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(251, 251, 251)
                                .addComponent(btnSearch))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblClass)
                                .addGap(18, 18, 18)
                                .addComponent(cmbSeatClass, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(lblNumberOfPassengers)
                                .addGap(18, 18, 18)
                                .addComponent(txtNoOfPassengers, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(lblBookTickets))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(42, 42, 42))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 628, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnBook)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(lblBookTickets)
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblName)
                    .addComponent(lblAge)
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
                .addContainerGap(64, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtNoOfPassengersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNoOfPassengersActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNoOfPassengersActionPerformed

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        // TODO add your handling code here:
        populateTable();
    }//GEN-LAST:event_btnSearchActionPerformed

    private void cmbSeatClassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbSeatClassActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbSeatClassActionPerformed

    private void btnBookActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBookActionPerformed
        // TODO add your handling code here:
        int selectedRow = tblFlights.getSelectedRow();
        if (selectedRow >= 0) {
            if (txtNoOfPassengers.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Please enter the number of passengers.");
                return;
            }

            int numberOfPassengers;
            try {
                numberOfPassengers = Integer.parseInt(txtNoOfPassengers.getText());
                if (numberOfPassengers <= 0) {
                    throw new NumberFormatException();
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Please enter a valid number of passengers.");
                return;
            }

            String flightNumber = tblFlights.getValueAt(selectedRow, 3).toString();
            List<Ticket> tickets = ab.getTicketDirectory().getTicketsByFlight(flightNumber);
            List<Ticket> availableTickets = tickets.stream()
                                                   .filter(ticket -> ticket.getStatus() == Ticket.TicketStatus.AVAILABLE)
                                                   .limit(numberOfPassengers)
                                                   .collect(Collectors.toList());

            if (availableTickets.size() == numberOfPassengers) {
                Order order = new Order(faker.bothify("ORD###"), pp);
                for (Ticket ticket : availableTickets) {
                    ticket.reserveTicket(); // Mark as reserved
                    order.addTicket(ticket);
                }
                ab.getOrderDirectory().addOrder(order);
                pp.addOrder(order);
                JOptionPane.showMessageDialog(null, "Tickets booked successfully!");
            } else {
                JOptionPane.showMessageDialog(null, "Not enough available tickets for this flight.");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Please select a flight to book tickets.");
        }
    }//GEN-LAST:event_btnBookActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBook;
    private javax.swing.JButton btnSearch;
    private javax.swing.JComboBox<String> cmbDate;
    private javax.swing.JComboBox<String> cmbDeparture;
    private javax.swing.JComboBox<String> cmbDestination;
    private javax.swing.JComboBox<String> cmbSeatClass;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblAge;
    private javax.swing.JLabel lblBookTickets;
    private javax.swing.JLabel lblClass;
    private javax.swing.JLabel lblDepartureDate;
    private javax.swing.JLabel lblName;
    private javax.swing.JLabel lblNumberOfPassengers;
    private javax.swing.JTable tblFlights;
    private javax.swing.JTextField txtNoOfPassengers;
    // End of variables declaration//GEN-END:variables
}
