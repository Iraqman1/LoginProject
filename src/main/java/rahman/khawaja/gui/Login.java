package rahman.khawaja.gui;

import rahman.khawaja.Session;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

public class Login {
    private JButton loginButton;
    private JPanel primaryPanel;
    private JButton signupButton;
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JLabel headerLabel;
    private JLabel subtitleLabel;
    private JCheckBox showPasswordBox;

    public Login(Session page) {

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (page.getUserDatabase().checkValidity(usernameField.getText(),passwordField.getText())) {
                    page.setSignedUser(page.getUserDatabase().getUser(usernameField.getText()));
                    page.setCurrentPanel(page.getHomePage().getPrimaryPanel());
                } else {
                    JOptionPane.showMessageDialog(null, "Incorrect Password (Hacker?)");
                }
            }
        });
        signupButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                page.setCurrentPanel(page.getRegisterPage().getPrimaryPanel());
            }
        });
        KeyboardFocusManager.getCurrentKeyboardFocusManager().addKeyEventDispatcher(e -> {
            if (e.getID() == java.awt.event.KeyEvent.KEY_PRESSED) {
                if (e.getKeyCode() == java.awt.event.KeyEvent.VK_ENTER) {
                    loginButton.doClick();
                }
            }

            return false;
        });

        showPasswordBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (showPasswordBox.isSelected()) {
                    passwordField.setEchoChar((char) 0);
                } else {
                    passwordField.setEchoChar('*');
                }
            }
        });
    }

    public JButton getLoginButton() {
        return loginButton;
    }

    public JPanel getPrimaryPanel() {
        return primaryPanel;
    }

    public JButton getSignupButton() {
        return signupButton;
    }

    public JTextField getUsernameField() {
        return usernameField;
    }

    public JPasswordField getPasswordField() {
        return passwordField;
    }

    public JLabel getHeaderLabel() {
        return headerLabel;
    }

    public JLabel getSubtitleLabel() {
        return subtitleLabel;
    }

    public JCheckBox getShowPasswordBox() {
        return showPasswordBox;
    }
}
