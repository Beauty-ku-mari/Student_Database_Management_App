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
setContentPane(contentPane);
        contentPane.setLayout(null);
JLabel lblNewLabel = new JLabel("STUDENT    DATA    MANAGEMENT");
        lblNewLabel.setForeground(new Color(95, 158, 160));
        lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 36));
 lblNewLabel.setBounds(192, 28, 642, 44);
        contentPane.add(lblNewLabel);

 JLabel lblNewLabel_1 = new JLabel("First Name");
        lblNewLabel_1.setForeground(new Color(0, 128, 128));
        lblNewLabel_1.setBackground(new Color(0, 128, 128));
lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblNewLabel_1.setBounds(43, 104, 104, 33);
        contentPane.add(lblNewLabel_1);

tf1 = new JTextField();
        tf1.setBounds(175, 103, 190, 33);
        contentPane.add(tf1);
        tf1.setColumns(10);

JLabel lblLastName = new JLabel("Last Name");
        lblLastName.setForeground(new Color(0, 128, 128));
        lblLastName.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblLastName.setBounds(43, 169, 104, 24);
        contentPane.add(lblLastName);

tf2 = new JTextField();
        tf2.setColumns(10);
        tf2.setBounds(175, 166, 190, 33);
        contentPane.add(tf2);

JLabel lblEmail = new JLabel("Email");
        lblEmail.setForeground(new Color(0, 128, 128));
        lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblEmail.setBounds(43, 235, 104, 24);
        contentPane.add(lblEmail);

 tf3 = new JTextField();
        tf3.setColumns(10);
        tf3.setBounds(175, 229, 190, 33);
        contentPane.add(tf3);

JLabel lblCourse = new JLabel("Course");
        lblCourse.setForeground(new Color(0, 128, 128));
        lblCourse.setFont(new Font("Tahoma", Font.PLAIN, 18));
lblCourse.setBounds(43, 297, 104, 24);
        contentPane.add(lblCourse);

JComboBox<String> comboBox = new JComboBox<>();
        comboBox.setModel(new DefaultComboBoxModel<>(new String[]{"Select", "MCA", "MBA", "B.TECH", "BCA", "BBA"}));
        comboBox.setFont(new Font("Tahoma", Font.PLAIN, 18));
        comboBox.setBounds(175, 292, 190, 33);
        contentPane.add(comboBox);

JLabel lblGender = new JLabel("Gender");
        lblGender.setForeground(new Color(0, 128, 128));
        lblGender.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblGender.setBounds(43, 354, 104, 24);
        contentPane.add(lblGender);

JRadioButton r4 = new JRadioButton("Male");
        r4.setFont(new Font("Tahoma", Font.PLAIN, 18));
r4.setBackground(new Color(173, 216, 230));
        r4.setBounds(175, 351, 104, 33);
        contentPane.add(r4);

 JRadioButton r5 = new JRadioButton("Female");
        r5.setFont(new Font("Tahoma", Font.PLAIN, 18));
 r5.setBackground(new Color(173, 216, 230));
        r5.setBounds(281, 351, 104, 33);
        contentPane.add(r5);

 ButtonGroup bg = new ButtonGroup(); 
        bg.add(r4);
        bg.add(r5);

JButton btnNewButton = new JButton("Load");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                showData();
            }
    });