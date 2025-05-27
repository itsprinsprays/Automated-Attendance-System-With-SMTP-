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
import javax.swing.JTextField;

public class dashboards extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	String username = "root";
	String password = "12312004";
	String database = "jdbc:mysql://localhost:3306/attendancesystem";
	private JLabel lblNewLabel_1_4;
	private JTextField txtsearch;
	private JButton btnSearch;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					dashboards frame = new dashboards();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public dashboards() {
		setTitle("Cavite State University");
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Zelpha\\OneDrive\\Documents\\Prens\\Comprog\\Web Dev\\HTML\\Images\\cvsulogo.png"));
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1127, 595); 

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("TRUNCATE");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					
					
					
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con = DriverManager.getConnection(database,username,password);
					
				    PreparedStatement pst = con.prepareStatement("truncate table attendance");
				    
				    
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
		
		btnSearch = new JButton("SEARCH");
		btnSearch.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        if (txtsearch.getText().trim().isEmpty()) {
		            JOptionPane.showMessageDialog(null, "Please enter a Student Number to search.");
		            return;
		        }

		        try {
		            Class.forName("com.mysql.cj.jdbc.Driver");
		            Connection con = DriverManager.getConnection(database, username, password);

		            String query = "SELECT * FROM attendance WHERE SNUM LIKE ?";
		            PreparedStatement pst = con.prepareStatement(query);
		            pst.setString(1,  txtsearch.getText());

		            ResultSet rs = pst.executeQuery();
		            ResultSetMetaData rsmd = rs.getMetaData();
		            DefaultTableModel model = new DefaultTableModel();

		            int cols = rsmd.getColumnCount();
		            String[] colName = new String[cols];
		            for (int i = 0; i < cols; i++) {
		                colName[i] = rsmd.getColumnName(i + 1);
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

		            rs.close();
		            pst.close();
		            con.close();

		        } catch (Exception ex) {
		            ex.printStackTrace();
		            JOptionPane.showMessageDialog(null, "Error while searching.");
		        }
		    }
		});

		btnSearch.setFont(new Font("Microsoft Himalaya", Font.PLAIN, 22));
		btnSearch.setBounds(825, 463, 134, 60);
		contentPane.add(btnSearch);
		
		txtsearch = new JTextField();
		txtsearch.setFont(new Font("Tahoma", Font.BOLD, 22));
		txtsearch.setColumns(10);
		txtsearch.setBounds(505, 463, 294, 60);
		contentPane.add(txtsearch);
		btnNewButton.setFont(new Font("Microsoft Himalaya", Font.PLAIN, 22));
		btnNewButton.setBounds(969, 463, 134, 60);
		contentPane.add(btnNewButton);
		
		lblNewLabel_1_4 = new JLabel("ATTENDANCE DASHBOARDS");
		lblNewLabel_1_4.setForeground(new Color(0, 255, 64));
		lblNewLabel_1_4.setFont(new Font("Microsoft Himalaya", Font.BOLD, 46));
		lblNewLabel_1_4.setBackground(Color.BLACK);
		lblNewLabel_1_4.setBounds(20, 472, 466, 45);
		contentPane.add(lblNewLabel_1_4);

	
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setFont(new Font("Microsoft Himalaya", Font.PLAIN, 10));
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

			PreparedStatement pst = con.prepareStatement("select * from attendance");
			ResultSet rs = pst.executeQuery();
			ResultSetMetaData rsmd = rs.getMetaData();
			DefaultTableModel model = new DefaultTableModel();
			
			int cols = rsmd.getColumnCount();
			String[] colName = new String[cols];
			for (int i = 0; i < cols; i++) {
				colName[i] = rsmd.getColumnName(i + 1);
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
