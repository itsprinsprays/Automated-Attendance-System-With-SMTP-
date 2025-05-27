package camera;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class info extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	String username = "root";
	String password = "12312004";
	String database = "jdbc:mysql://localhost:3306/attendancesystem";
	private JLabel lblNewLabel_1_4;
	private JButton btnUpdate;
	private JButton btnTruncate;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					info frame = new info();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public info() {
		setTitle("Cavite State University");
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Zelpha\\OneDrive\\Documents\\Prens\\Comprog\\Web Dev\\HTML\\Images\\cvsulogo.png"));
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1127, 595); 

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		btnUpdate = new JButton("UPDATE");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String input = JOptionPane.showInputDialog(null,"Enter password");
		    	if(input.equalsIgnoreCase("cvsuimus")) {
		    		updateinfo c = new updateinfo();
					c.setLocationRelativeTo(null);
					c.show();
					dispose();
		    	}else JOptionPane.showMessageDialog(null, "Password Incorrect");
		  	
			}
		});
		
		btnTruncate = new JButton("TRUNCATE");
		btnTruncate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					
					
					
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con = DriverManager.getConnection(database,username,password);
					
				    PreparedStatement pst = con.prepareStatement("truncate table studentinfo");
				    
				    
				    int response = JOptionPane.showConfirmDialog(null, "Are you sure?", "Confirm", JOptionPane.YES_NO_OPTION);
				    if (response == JOptionPane.YES_OPTION) {
				    	String input = JOptionPane.showInputDialog(null,"Enter password");
				    	if(input.equalsIgnoreCase("cvsuimus")) {
				    		JOptionPane.showMessageDialog(null, "Dashboard has been truncated.");
				    		pst.executeUpdate();
				    	}else JOptionPane.showMessageDialog(null, "Password Incorrect");
				    }	
				    
				 
				} catch(Exception e2) {
					e2.printStackTrace();
					JOptionPane.showMessageDialog(null, "Error");
				}
			}
		});
		btnTruncate.setFont(new Font("Microsoft Himalaya", Font.PLAIN, 39));
		btnTruncate.setBounds(711, 471, 191, 52);
		contentPane.add(btnTruncate);
		btnUpdate.setFont(new Font("Microsoft Himalaya", Font.PLAIN, 51));
		btnUpdate.setBounds(912, 471, 191, 52);
		contentPane.add(btnUpdate);
		
		lblNewLabel_1_4 = new JLabel("STUDENT INFORMATION");
		lblNewLabel_1_4.setForeground(new Color(0, 255, 64));
		lblNewLabel_1_4.setFont(new Font("Microsoft Himalaya", Font.BOLD, 66));
		lblNewLabel_1_4.setBackground(Color.BLACK);
		lblNewLabel_1_4.setBounds(68, 473, 562, 45);
		contentPane.add(lblNewLabel_1_4);

	
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Zelpha\\OneDrive\\Documents\\Prens\\Comprog\\Web Dev\\HTML\\Images\\school.jpg"));
		lblNewLabel.setBounds(0, 10, 1141, 754);
		contentPane.add(lblNewLabel);
		lblNewLabel.setLayout(null); 

		
		table = new JTable();
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(10, 25, 1093, 410);
		lblNewLabel.add(scrollPane); 

		
		autotable();
		
		JTableHeader header = table.getTableHeader();
		header.setFont(new Font("Tahoma", Font.PLAIN, 20));
		header.setForeground(Color.WHITE);
		header.setBackground(new Color(60, 179, 113));
		header.setReorderingAllowed(false);
		
		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment(DefaultTableCellRenderer.CENTER);
		table.setDefaultRenderer(Object.class, centerRenderer);
		table.setFont(new Font("Tahoma", Font.PLAIN, 18)); 
		table.setRowHeight(35);
	}

	public void autotable() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(database, username, password);

			PreparedStatement pst = con.prepareStatement("SELECT SNUM AS 'Student Number', Fullname, Section, Age, DateAndTime AS 'Date Registry', Email AS 'Guardians Email' FROM studentinfo");
			ResultSet rs = pst.executeQuery();
			ResultSetMetaData rsmd = rs.getMetaData();
			DefaultTableModel model = new DefaultTableModel();
			
			int cols = rsmd.getColumnCount();
			String[] colName = new String[cols];
			for (int i = 0; i < cols; i++) {
				colName[i] = rsmd.getColumnLabel(i + 1);
			}
			model.setColumnIdentifiers(colName);

			while (rs.next()) {
				String[] row = new String[cols];
				for (int i = 0; i < cols; i++) {
					row[i] = rs.getString(i + 1);
				}
				model.addRow(row);
			}

			table.setModel(model);

			con.close();
			pst.close();
		} catch (Exception e1) {
			System.out.print(e1);
		}
	}
}
