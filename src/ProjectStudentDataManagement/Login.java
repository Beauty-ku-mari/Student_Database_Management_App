package ProjectStudentDataManagement;

import java.awt.EventQueue;
import javax.swing.JFrame;
import java.awt.Toolkit;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
public class Login {
    private JFrame loginsdm;
    private JTextField tf1;
    private JPasswordField tf2;
    Connection sdm;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Login window = new Login();
                    window.loginsdm.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
 public Login() {
        sdm = DataBaseConnection.dbConn();
        initialize();
    }
 private void initialize() {
        loginsdm = new JFrame();
        loginsdm.getContentPane().setBackground(new Color(0, 0, 0));
        loginsdm.setTitle("STUDENT DATA MANAGEMENT Login\r\n");
loginsdm.setIconImage(Toolkit.getDefaultToolkit().getImage("resources/images/unnamed.png"));
        loginsdm.setBounds(100, 110, 858, 559);
 loginsdm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        loginsdm.getContentPane().setLayout(null);

tf1 = new JTextField();
        tf1.setBackground(new Color(175, 238, 238));
        tf1.setBounds(117, 173, 265, 41);
loginsdm.getContentPane().add(tf1);
        tf1.setColumns(10);

JLabel lblNewLabel = new JLabel("Enter Username");
        lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
 lblNewLabel.setForeground(new Color(135, 206, 250));
        lblNewLabel.setBounds(118, 131, 233, 41);
        loginsdm.getContentPane().add(lblNewLabel);

JLabel lblEnterPassword = new JLabel("Enter Password");
        lblEnterPassword.setFont(new Font("Tahoma", Font.BOLD, 20));
        lblEnterPassword.setForeground(new Color(135, 206, 250));
lblEnterPassword.setBounds(117, 259, 198, 33);
        loginsdm.getContentPane().add(lblEnterPassword);

