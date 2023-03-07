package rahman.khawaja;

import rahman.khawaja.database.LoginDB;
import rahman.khawaja.gui.Booking;
import rahman.khawaja.gui.Home;
import rahman.khawaja.gui.Login;
import rahman.khawaja.gui.Register;
import rahman.khawaja.objects.User;

import javax.swing.*;

public class Session {
    private LoginDB userDatabase = new LoginDB();
    private Login loginPage = new Login(this);
    private Register registerPage = new Register(this);
    private Home homePage = new Home(this);
    private Booking bookingPage = new Booking(this);
    private User signedUser;
    private JPanel currentPanel;
    private JFrame frame = new JFrame();

    public Session() {
        setCurrentPanel(loginPage.getPrimaryPanel());
    }

    public void setCurrentPanel(JPanel panel) {
        this.currentPanel = panel;
        frame.setContentPane(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setSize(1000, 750);
        frame.setVisible(true);
    }

    public Login getLoginPage() {
        return loginPage;
    }

    public Register getRegisterPage() {
        return registerPage;
    }

    public Home getHomePage() {
        return homePage;
    }

    public Booking getBookingPage() {
        return bookingPage;
    }

    public LoginDB getUserDatabase() {
        return userDatabase;
    }

    public User getSignedUser() {
        return signedUser;
    }

    public void setSignedUser(User signedUser) {
        this.signedUser = signedUser;
    }
}
