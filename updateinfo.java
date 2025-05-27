package camera;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;

public class updateinfo extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtchange;
	private JTextField txtid;
	JComboBox comboBox = new JComboBox();
	String username = "root";
	String password = "12312004";
	String database = "jdbc:mysql://localhost:3306/attendancesystem";

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					updateinfo frame = new updateinfo();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public updateinfo() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Zelpha\\OneDrive\\Documents\\Prens\\Comprog\\Web Dev\\HTML\\Images\\cvsulogo.png"));
		setBounds(100, 100, 498, 644);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnBack = new JButton("BACK");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				info c = new info();
				c.setLocationRelativeTo(null);
				c.show();
				dispose();
			}
		});
		btnBack.setFont(new Font("Microsoft Himalaya", Font.PLAIN, 43));
		btnBack.setBounds(0, 0, 191, 52);
		contentPane.add(btnBack);
		
		JButton btnUpdate = new JButton("UPDATE");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con = DriverManager.getConnection(database,username,password);
					
					String selectedTable = comboBox.getSelectedItem().toString();
					if(selectedTable.equalsIgnoreCase("Student Number")) {
						selectedTable = "SNUM";
					} else if (selectedTable.equalsIgnoreCase("Guardian's Email")) {
						selectedTable = "Email";
					}

				    String query = "Update studentinfo set " + selectedTable + " = ? where SNUM = ?"; // Corrected query
					
					PreparedStatement pst = con.prepareStatement(query);
					
					
					pst.setString(1, txtchange.getText());
					pst.setString(2, txtid.getText());
					
					int rows = pst.executeUpdate();
					if(rows>0) {
						JOptionPane.showMessageDialog(null, "Updated");		
						txtchange.setText("");
						txtid.setText("");
					}
					
					else
						JOptionPane.showMessageDialog(null, "Updating Failed");
					
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		btnUpdate.setFont(new Font("Microsoft Himalaya", Font.PLAIN, 43));
		btnUpdate.setBounds(136, 468, 191, 52);
		contentPane.add(btnUpdate);
		
		comboBox = new JComboBox();
		comboBox.setFont(new Font("Microsoft Himalaya", Font.PLAIN, 36));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Fullname", "Section", "Age", "Student Number", "Guardian's Email"}));
		comboBox.setToolTipText("");
		comboBox.setBounds(188, 114, 241, 38);
		contentPane.add(comboBox);
		
		JLabel lblNewLabel_1 = new JLabel("Student Number");
		lblNewLabel_1.setFont(new Font("Microsoft Himalaya", Font.PLAIN, 46));
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setBounds(70, 330, 282, 44);
		contentPane.add(lblNewLabel_1);
		
		txtid = new JTextField();
		txtid.setFont(new Font("Microsoft Himalaya", Font.PLAIN, 36));
		txtid.setColumns(10);
		txtid.setBounds(70, 372, 359, 62);
		contentPane.add(txtid);
		
		txtchange = new JTextField();
		txtchange.setFont(new Font("Microsoft Himalaya", Font.PLAIN, 36));
		txtchange.setBounds(70, 182, 359, 62);
		contentPane.add(txtchange);
		txtchange.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Zelpha\\OneDrive\\Documents\\Prens\\Comprog\\Web Dev\\HTML\\Images\\school.png"));
		lblNewLabel.setBounds(0, 0, 484, 607);
		contentPane.add(lblNewLabel);
	}
}
