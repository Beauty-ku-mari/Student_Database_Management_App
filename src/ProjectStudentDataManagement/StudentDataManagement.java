package ProjectStudentDataManagement;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JInternalFrame;
import javax.swing.table.DefaultTableModel;
import net.proteanit.sql.DbUtils;
import javax.swing.border.MatteBorder;
import java.awt.Color;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.awt.print.PrinterException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class StudentDataManagement extends JFrame {
    private JPanel contentPane;
    private JTextField tf1;
    private JTextField tf2;
    private JTextField tf3;
    private JTextField tf5;
    private JTextField tf6;
    private JTextField tf7;
    private JTextField tf8;
    private JTextField tf9;
    private JTextField tf4;
    private JTable table;
    Connection conn;
    JRadioButton r4, r5;
    JComboBox comboBox;

 private JTextField tf10;
    private JTextField tf11;
    private JTextField tf12;


    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
StudentDataManagement frame = new StudentDataManagement();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

@SuppressWarnings("unchecked")
    void addItemToComboBox() throws SQLException {
        String query = "SELECT * from studentdatamgmt";
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(query);

 while (rs.next()) {
            comboBox.addItem(rs.getString("FirstName"));
        }
    }
public StudentDataManagement() {
        conn = DataBaseConnection.dbConn();
        setFont(new Font("Dialog", Font.BOLD, 18));
        setBackground(SystemColor.activeCaption);
setTitle("Student Data Management");
        setIconImage(Toolkit.getDefaultToolkit().getImage("resources/images/unnamed.png"));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 1273, 680);
contentPane = new JPanel();
        contentPane.setBackground(new Color(176, 224, 230));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
