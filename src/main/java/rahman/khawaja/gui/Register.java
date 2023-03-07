package rahman.khawaja.gui;

import rahman.khawaja.Session;
import rahman.khawaja.objects.User;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Register {
    private JButton registerButton;
    private JPanel primaryPanel;
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JTextField genderField;
    private JTextField ageField;
    private JTextField rizzField;
    private JTextField favoritePositionField;
    private JTextField thoughtsOnEmmaWatonField;
    private JTextField ricePurityTestScoreField;
    private JTextField favoriteEthnicityField;
    private JTextField inchesField;
    private JTextField lastImageInCameraRollField;
    private JTextField favouriteStudentField;
    private JTextField whatDoYouWantToBeWhenYouGrowUpField;
    private JLabel usernameLabel;
    private JLabel passwordLabel;
    private JLabel genderLabel;
    private JLabel ageLabel;
    private JLabel rizzLabel;
    private JLabel favoritePositionLabel;
    private JLabel thoughtsOnEmmaWatsonLabel;
    private JLabel ricePurityTestScoreLabel;
    private JLabel favoriteEthnicityLabel;
    private JLabel inchesLabel;
    private JLabel lastImageInCameraRollLabel;
    private JLabel favoriteStudentLabel;
    private JLabel whatDoYouWantToBeWhenYouGrowUp;
    private JButton backButton;
    private JCheckBox showPasswordBox;


    public Register(Session page) {
        // TODO: make error messages clearer(Done)
        // TODO: add numerical check for rice purity test (0-100) (Done)
        // TODO: fix password

        KeyboardFocusManager.getCurrentKeyboardFocusManager().addKeyEventDispatcher(e -> {
            if (e.getID() == java.awt.event.KeyEvent.KEY_PRESSED) {
                if (e.getKeyCode() == java.awt.event.KeyEvent.VK_ENTER) {
                    registerButton.doClick();
                }
            }

            return false;
        });

        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = usernameField.getText();
                String password = passwordField.getText().trim();
                String gender = genderField.getText();
                String age = ageField.getText();
                String rizz = rizzField.getText();
                String favoritePosition = favoritePositionField.getText();
                String thoughtsOnEmmaWatson = thoughtsOnEmmaWatonField.getText();
                String ricePurityTestScore = ricePurityTestScoreField.getText();
                String favoriteEthnicity = favoriteEthnicityField.getText();
                String inches = inchesField.getText();
                String lastImageInCameraRoll = lastImageInCameraRollField.getText();
                String favoriteStudent = favouriteStudentField.getText();
                String whatDoYouWantToBeWhenYouGrowUp = whatDoYouWantToBeWhenYouGrowUpField.getText();

                boolean freeUsername = false;
                boolean validPassword = false;
                boolean recognisedGender = false;
                boolean validAge = false;
                boolean validRizzScore = false;
                boolean validRicePurityTestScore = false;
                boolean validInches = false;
                boolean correctFavoriteStudent = false;

                if (username.isEmpty() || password.isEmpty() || gender.isEmpty() || age.isEmpty() || favoritePosition.isEmpty() || thoughtsOnEmmaWatson.isEmpty() || ricePurityTestScore.isEmpty() || favoriteEthnicity.isEmpty() || inches.isEmpty() || lastImageInCameraRoll.isEmpty() || favoriteStudent.isEmpty() || whatDoYouWantToBeWhenYouGrowUp.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "please enter all fields");
                } else {
                    if (page.getUserDatabase().checkUsername(username)) {
                        freeUsername = false;
                        JOptionPane.showMessageDialog(null, "Username is taken");
                    } else {
                        freeUsername = true;
                    }

                    if (password.matches(".*[A-Z]*.")) {
                        if (password.matches(".*[a-z]*.")) {
                            if (password.matches(".*\\d*.")) {
                                if (password.matches(".*[!@#$%^&*()_+\\-=\\[\\]{};':\"\\\\|,.<>\\/?].*")) {
                                    validPassword = true;
                                } else {
                                    validPassword = false;
                                    JOptionPane.showMessageDialog(null, "Password needs Special Characters such as: !@#$%");
                                }
                            } else {
                                validPassword = false;
                                JOptionPane.showMessageDialog(null, "Password requires numbers");
                            }
                        } else {
                            validPassword = false;
                            JOptionPane.showMessageDialog(null, "Password requires lower-case letters");
                        }
                    } else {
                        validPassword = false;
                        JOptionPane.showMessageDialog(null, "Password requires capitalized letters");
                    }

                    if (gender.toLowerCase().equals("male") || gender.toLowerCase().equals("female")) {
                        recognisedGender = true;
                    } else {
                        recognisedGender = false;
                        JOptionPane.showMessageDialog(null, "Please enter a valid gender (male or female)");
                    }

                    try {
                        Integer.parseInt(age);
                        validAge = true;
                    } catch (Exception x) {
                        validAge = false;
                        JOptionPane.showMessageDialog(null, "Please enter a numerical value for age");
                    }
                    try {
                        if (Integer.parseInt(rizz) <= 10 && Integer.parseInt(rizz) >= 1) {
                            validRizzScore = true;
                        } else {
                            validRizzScore = false;

                            JOptionPane.showMessageDialog(null, "Please enter a score from 1 to 10 for rizz");
                        }


                    } catch (Exception x) {
                        validRizzScore = false;
                        JOptionPane.showMessageDialog(null, "Please enter a numerical value from 1 to 10 for rizz");
                    }


                    try {
                        if (Integer.parseInt(ricePurityTestScore) <= 100 && Integer.parseInt(ricePurityTestScore) >= 1) {
                            validRicePurityTestScore = true;
                        } else {
                            validRicePurityTestScore = false;

                            JOptionPane.showMessageDialog(null, "Please enter a value for rice purity test from 1 to 100");
                        }
                    } catch (Exception y) {
                        validRicePurityTestScore = false;
                        JOptionPane.showMessageDialog(null, "Please enter a value for rice purity test from 1 to 100");
                    }

                    try {
                        if (Integer.parseInt(inches) <= 3) {
                            validInches = true;
                        } else {
                            JOptionPane.showMessageDialog(null, "Exaggeration?");
                        }

                    } catch (Exception z) {
                        validInches = false;
                        JOptionPane.showMessageDialog(null, "Please enter a numerical value for inches");
                    }

                    if (favoriteStudent.toLowerCase().equals("rahman")) {
                        correctFavoriteStudent = true;
                    } else {
                        correctFavoriteStudent = false;
                        JOptionPane.showMessageDialog(null, "Mr Isla don't lie to yourself");
                    }
                }

                if (freeUsername && validPassword && recognisedGender && validAge && validRizzScore && validRicePurityTestScore && validInches && correctFavoriteStudent) {
                    User user = new User(username, password, gender, age, rizz, favoritePosition, thoughtsOnEmmaWatson, ricePurityTestScore, favoriteEthnicity, inches, lastImageInCameraRoll, favoriteStudent, whatDoYouWantToBeWhenYouGrowUp);
                    page.getUserDatabase().addUser(user);
                    page.setSignedUser(user);
                    JOptionPane.showMessageDialog(null, "Congratulations!!! You have successfully signed up!");
                    page.setCurrentPanel(page.getLoginPage().getPrimaryPanel());
                }
            }


        });
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                page.setCurrentPanel(page.getLoginPage().getPrimaryPanel());
            }
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

    public JButton getRegisterButton() {
        return registerButton;
    }

    public JPanel getPrimaryPanel() {
        return primaryPanel;
    }

    public JTextField getUsernameField() {
        return usernameField;
    }

    public JTextField getPasswordField() {
        return passwordField;
    }

    public JTextField getGenderField() {
        return genderField;
    }

    public JTextField getAgeField() {
        return ageField;
    }

    public JTextField getRizzField() {
        return rizzField;
    }

    public JTextField getFavoritePositionField() {
        return favoritePositionField;
    }

    public JTextField getThoughtsOnEmmaWatonField() {
        return thoughtsOnEmmaWatonField;
    }

    public JTextField getRicePurityTestScoreField() {
        return ricePurityTestScoreField;
    }

    public JTextField getFavoriteEthnicityField() {
        return favoriteEthnicityField;
    }

    public JTextField getInchesField() {
        return inchesField;
    }

    public JTextField getLastImageInCameraRollField() {
        return lastImageInCameraRollField;
    }

    public JTextField getFavouriteStudentField() {
        return favouriteStudentField;
    }

    public JTextField getWhatDoYouWantToBeWhenYouGrowUpField() {
        return whatDoYouWantToBeWhenYouGrowUpField;
    }

    public JLabel getUsernameLabel() {
        return usernameLabel;
    }

    public JLabel getPasswordLabel() {
        return passwordLabel;
    }

    public JLabel getGenderLabel() {
        return genderLabel;
    }

    public JLabel getAgeLabel() {
        return ageLabel;
    }

    public JLabel getRizzLabel() {
        return rizzLabel;
    }

    public JLabel getFavoritePositionLabel() {
        return favoritePositionLabel;
    }

    public JLabel getThoughtsOnEmmaWatsonLabel() {
        return thoughtsOnEmmaWatsonLabel;
    }

    public JLabel getRicePurityTestScoreLabel() {
        return ricePurityTestScoreLabel;
    }

    public JLabel getFavoriteEthnicityLabel() {
        return favoriteEthnicityLabel;
    }

    public JLabel getInchesLabel() {
        return inchesLabel;
    }

    public JLabel getLastImageInCameraRollLabel() {
        return lastImageInCameraRollLabel;
    }

    public JLabel getFavoriteStudentLabel() {
        return favoriteStudentLabel;
    }

    public JLabel getWhatDoYouWantToBeWhenYouGrowUp() {
        return whatDoYouWantToBeWhenYouGrowUp;
    }

    public JButton getBackButton() {
        return backButton;
    }


}
