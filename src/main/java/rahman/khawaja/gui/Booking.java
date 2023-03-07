package rahman.khawaja.gui;

import rahman.khawaja.Session;
import rahman.khawaja.database.LoginDB;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Collection;
import java.util.HashSet;


public class Booking {
    private JFrame frame = new JFrame();
    private JPanel currentPanel;
    private JComboBox concertCombo;
    private JLabel concertLabel;
    private JComboBox timeCombo;
    private JComboBox dateCombo;
    private JTextField numberOfTicketsField;
    private JButton bookTicketsButton;
    private JButton backButton;
    private JPanel primaryPanel;
    private JLabel numberOfTicketsLabel;
    private JLabel dateLabel;
    private JLabel timeLabel;

    public Booking(Session page) {
    }

        public ConcertBooking() {
            final int capacity = 50;
            setTitle("Book a concert ticket for this coming week");
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setBounds(100, 100, 500, 400); // x, y, width, height //
            currentPanel = new JPanel();
            currentPanel.setBorder(new EmptyBorder(5, 5, 5, 5)); // TODO: 5555?

            setContentPane(currentPanel);
            currentPanel.setLayout(null); // all seems good so far

            JLabel concertLabel = new JLabel("Pick a Concert");
            concertLabel.setBounds(31, 19, 109, 16); // x, y, width, height
            currentPanel.add(concertLabel);

            String names[] = {"Rolling Loud Thailand - $400", "Travis Scott - $300", "Lil Uzi Vert - $300", "The Weeknd - $600"};
            JComboBox concertcombo = new JComboBox<Object>(names);
            concertcombo.setToolTipText("Rolling Loud Thailand");
            concertcombo.setMaximumRowCount(4);

            concertcombo.setBounds(141, 15, 152, 27); // x, y, width, height
            currentPanel.add(concertcombo);

            JLabel dateLabel = new JLabel("Pick a Date");
            dateLabel.setBounds(31, 82, 133, 16); // x, y, width, height
            currentPanel.add(dateLabel);

            String days[] = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};
            JComboBox<Object> dateCombo = new JComboBox<Object>(days);
            dateCombo.setToolTipText("Monday");
            dateCombo.setMaximumRowCount(7);
            dateCombo.setBounds(153, 78, 152, 27); // x, y, width, height
            currentPanel.add(dateCombo);

            JLabel timeLabel = new JLabel("Choose Your Time");
            timeLabel.setBounds(31, 110, 133, 16); // x, y, width, height
            currentPanel.add(timeLabel);

            String time[] = {"7:00 PM", "8:00PM", "8:00PM", "7:00PM"};
            JComboBox<Object> comboTime = new JComboBox<Object>(time);
            comboTime.setToolTipText("7:00 PM");
            comboTime.setMaximumRowCount(4);
            comboTime.setBounds(153, 110, 152, 27); // x, y, width, height
            currentPanel.add(comboTime);

            JLabel numberOfTicketsLabel = new JLabel("Number of Tickets");
            numberOfTicketsLabel.setBounds(31, 179, 133, 16); // x, y, width, height
            currentPanel.add(numberOfTicketsLabel);

            numberOfTicketsField = new JTextField();
            numberOfTicketsField.setBounds(163, 174, 130, 26); // x, y, width, height
            currentPanel.add(numberOfTicketsField);
            numberOfTicketsField.setColumns(10);

            JButton btnBook = new JButton("Book");
            btnBook.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    String movie = concertcombo.getSelectedItem().toString();
                    String date = dateCombo.getSelectedItem().toString();
                    String time = comboTime.getSelectedItem().toString();
                    int num = Integer.parseInt(numberOfTicketsField.getText());

                    Collection<String> Bookings = new HashSet<String>(); // TODO: create collection to store bookings
                    Bookings.add();

                    String sql = "select * from \"Booking\" where \"Moviename\" =" + "'" + movie + "'" + " and \"Day\"=" + "'" + date + "' and \"Time\" = '" + time + "'"; // CHANGE

                    try {
                        ResultSet rs = null;
                        rs = DatabaseConnection.getData(sql);
                        rs.first();
                        int numbr = (rs.getInt(4));
                        if (numbr + num > capacity)
                            JOptionPane.showMessageDialog(null, "Booking exceeds capacity");
                        else {
                            sql = "Update \"Booking\" set \"Number\" =  \"Number\" +" + num + " where \"Moviename\"=" + "'" + movie
                                    + "' and \"Day\"=" + "'" + date + "' and \"Time\" = '" + time + "'";
                            DataConnection.insertData(sql);
                            if (num == 1) {
                                JOptionPane.showMessageDialog(null, "Booking Done" + "\n Ticket Number " + (numbr + 1));
                            } else {
                                JOptionPane.showMessageDialog(null, "Booking Done" + "\n Ticket Number " + (numbr + 1) + " to " + (numbr + num));
                            }
                        }


                    } catch (Exception e1) {
                    }
                }
            });
            bookTicketsButton.setBounds(153, 230, 117, 29); // x, y, width, height
            currentPanel.add(bookTicketsButton);

            JButton backButton = new JButton("Go back to choice");
            backButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    page.setCurrentPanel(page.getLoginPage().getPrimaryPanel());
                }

            });


        }
    }

