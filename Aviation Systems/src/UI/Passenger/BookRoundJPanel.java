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
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author martta
 */
public class BookRoundJPanel extends javax.swing.JPanel {
    JPanel mainWorkArea;
    AirlineBusiness ab;
    PassengerProfile pp;
    private final Faker faker = new Faker();
    /**
     * Creates new form BookOneWayJPanel
     */
    public BookRoundJPanel(AirlineBusiness ab,JPanel mainWorkArea,PassengerProfile pp) {
        initComponents();
        this.ab = ab;
        this.mainWorkArea = mainWorkArea;
        this.pp = pp;
        
        populateComboBoxes();
    }
    
    private void populateComboBoxes() {
        // Assuming the method getAvailableCities() returns all unique cities from the flights
        String[] cities = ab.getAvailableCities().toArray(new String[0]);
        Arrays.sort(cities);
        cmbDeparture.setModel(new DefaultComboBoxModel<>(cities));
        cmbDestination.setModel(new DefaultComboBoxModel<>(cities));

        // Populate date comboboxes with dates including an "Anytime" option
        String[] dates = generateDateOptions();
        cmbDepartDate.setModel(new DefaultComboBoxModel<>(dates));
        cmbReturnDate.setModel(new DefaultComboBoxModel<>(dates));

        // Set seat classes
        String[] seatClasses = {"ECONOMY", "BUSINESS", "FIRST_CLASS"};
        cmbSeatClass.setModel(new DefaultComboBoxModel<>(seatClasses));
    }

    private String[] generateDateOptions() {
        List<String> dateOptions = new ArrayList<>();
        dateOptions.add("Any Date");
        LocalDate start = LocalDate.now();
        LocalDate end = start.plusYears(1); // Adjust the range as necessary
        while (!start.isAfter(end)) {
            dateOptions.add(start.toString());
            start = start.plusDays(1);
        }
        return dateOptions.toArray(new String[0]);
    }
    
    private void populateFlightsTable(JTable table, String departure, String destination, String date, String seatClass) {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setRowCount(0);
        HashMap<String, Object[]> bestPrices = new HashMap<>();

        for (Flight flight : ab.getFlightDirectory().getFlights()) {
            if (flight.getDepartureStation().getCityName().equals(departure) && 
                flight.getArrivalStation().getCityName().equals(destination) &&
                (date.equals("Any Date") || flight.getDepartureTime().toLocalDate().toString().equals(date))) {
                for (Ticket ticket : flight.getTickets()) {
                    if (ticket.getCabinClass().name().equalsIgnoreCase(seatClass) && ticket.getStatus() == Ticket.TicketStatus.AVAILABLE) {
                        String key = flight.getFlightNumber();
                        double price = ticket.getPrice();
                        if (!bestPrices.containsKey(key) || (Double) bestPrices.get(key)[5] > price) {
                            bestPrices.put(key, new Object[]{
                                flight.getDepartureTime(), flight.getArrivalTime(), flight.getAirlineCompany().getName(),
                                flight.getFlightNumber(), ticket.getCabinClass().name(), price  // Directly use double
                            });
                        }
                    }
                }
            }
        }

        for (Object[] row : bestPrices.values()) {
            model.addRow(new Object[] {
                row[0], row[1], row[2], row[3], row[4], String.format("%.2f", row[5])  // Format when adding to model
            });
        }
    }




    private boolean bookTicketsFromTable(JTable table, int passengers, Order order) {
        int selectedRow = table.getSelectedRow();
        if (selectedRow != -1) {
            String flightNumber = table.getValueAt(selectedRow, 3).toString();
            List<Ticket> availableTickets = ab.getTicketDirectory().getTicketsByFlightAndClass(flightNumber, cmbSeatClass.getSelectedItem().toString());

            if (availableTickets.size() >= passengers) {
                for (int i = 0; i < passengers; i++) {
                    Ticket ticket = availableTickets.get(i);
                    ticket.reserveTicket();
                    order.addTicket(ticket); // Add the ticket to the existing order
                }
                return true; // Return true to indicate success
            } else {
                JOptionPane.showMessageDialog(null, "Not enough available tickets for " + flightNumber);
                return false; // Return false to indicate not enough tickets
            }
        } else {
            JOptionPane.showMessageDialog(null, "Please select a flight to book.");
            return false; // Return false to indicate no flight selected
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
        lblReturnDate = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblReturnFlights = new javax.swing.JTable();
        lblDepart = new javax.swing.JLabel();
        lblReturn = new javax.swing.JLabel();
        cmbDeparture = new javax.swing.JComboBox<>();
        cmbDestination = new javax.swing.JComboBox<>();
        cmbDepartDate = new javax.swing.JComboBox<>();
        cmbReturnDate = new javax.swing.JComboBox<>();

        lblBookTickets.setText("Book Tickets(Round Trip)");

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

        lblReturnDate.setFont(new java.awt.Font("Helvetica Neue", 1, 13)); // NOI18N
        lblReturnDate.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblReturnDate.setText("Return Date");

        tblReturnFlights.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(tblReturnFlights);

        lblDepart.setText("Depart");

        lblReturn.setText("Return");

        cmbDeparture.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        cmbDestination.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        cmbDepartDate.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        cmbReturnDate.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

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
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(cmbDepartDate, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(lblReturnDate)
                                .addGap(18, 18, 18)
                                .addComponent(cmbReturnDate, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnSearch))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(cmbDeparture, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(lblAge)
                                .addGap(18, 18, 18)
                                .addComponent(cmbDestination, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(221, 353, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblClass)
                        .addGap(18, 18, 18)
                        .addComponent(cmbSeatClass, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lblNumberOfPassengers)
                        .addGap(18, 18, 18)
                        .addComponent(txtNoOfPassengers, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lblBookTickets))
                .addGap(40, 40, 40))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnBook)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblDepart)
                    .addComponent(lblReturn))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(lblBookTickets)
                .addGap(42, 42, 42)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblName)
                    .addComponent(lblAge)
                    .addComponent(cmbDeparture, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbDestination, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblDepartureDate)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(lblReturnDate)
                                .addComponent(cmbDepartDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(cmbReturnDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(btnSearch))))
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblClass)
                    .addComponent(cmbSeatClass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblNumberOfPassengers)
                    .addComponent(txtNoOfPassengers, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addComponent(lblDepart)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23)
                .addComponent(lblReturn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnBook)
                .addContainerGap(54, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        // TODO add your handling code here:
        populateFlightsTable(tblFlights, (String) cmbDeparture.getSelectedItem(), (String) cmbDestination.getSelectedItem(), (String) cmbDepartDate.getSelectedItem(), (String) cmbSeatClass.getSelectedItem());
        populateFlightsTable(tblReturnFlights, (String) cmbDestination.getSelectedItem(), (String) cmbDeparture.getSelectedItem(), (String) cmbReturnDate.getSelectedItem(), (String) cmbSeatClass.getSelectedItem());
    }//GEN-LAST:event_btnSearchActionPerformed

    private void cmbSeatClassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbSeatClassActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbSeatClassActionPerformed

    private void btnBookActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBookActionPerformed
        int passengers;
        try {
            passengers = Integer.parseInt(txtNoOfPassengers.getText());
            if (passengers <= 0) throw new Exception("Number of passengers must be positive.");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Please enter a valid number of passengers.");
            return;
        }

        int selectedRowDepart = tblFlights.getSelectedRow();
        int selectedRowReturn = tblReturnFlights.getSelectedRow();

        if (selectedRowDepart == -1 || selectedRowReturn == -1) {
            JOptionPane.showMessageDialog(null, "Please select a flight from both Depart and Return tables.");
            return;
        }

        // Create a single Order object for the round trip
        Order roundTripOrder = new Order(faker.bothify("ORD###"), pp);

        // Book tickets for the departure flight and add them to the order
        boolean departBooked = bookTicketsFromTable(tblFlights, passengers, roundTripOrder);
        // Book tickets for the return flight and add them to the same order
        boolean returnBooked = bookTicketsFromTable(tblReturnFlights, passengers, roundTripOrder);

        // If both flights are successfully booked, then finalize the order
        if (departBooked && returnBooked) {
            ab.getOrderDirectory().addOrder(roundTripOrder);
            pp.addOrder(roundTripOrder);
            JOptionPane.showMessageDialog(null, "Round trip tickets booked successfully!");
        } else {
            JOptionPane.showMessageDialog(null, "Failed to book round trip tickets.");
        }
    }//GEN-LAST:event_btnBookActionPerformed

    private void txtNoOfPassengersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNoOfPassengersActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNoOfPassengersActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBook;
    private javax.swing.JButton btnSearch;
    private javax.swing.JComboBox<String> cmbDepartDate;
    private javax.swing.JComboBox<String> cmbDeparture;
    private javax.swing.JComboBox<String> cmbDestination;
    private javax.swing.JComboBox<String> cmbReturnDate;
    private javax.swing.JComboBox<String> cmbSeatClass;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblAge;
    private javax.swing.JLabel lblBookTickets;
    private javax.swing.JLabel lblClass;
    private javax.swing.JLabel lblDepart;
    private javax.swing.JLabel lblDepartureDate;
    private javax.swing.JLabel lblName;
    private javax.swing.JLabel lblNumberOfPassengers;
    private javax.swing.JLabel lblReturn;
    private javax.swing.JLabel lblReturnDate;
    private javax.swing.JTable tblFlights;
    private javax.swing.JTable tblReturnFlights;
    private javax.swing.JTextField txtNoOfPassengers;
    // End of variables declaration//GEN-END:variables
}
