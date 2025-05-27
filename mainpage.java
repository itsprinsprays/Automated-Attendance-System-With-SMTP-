package main;
import camera.*;
import main.sda;

//import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;



import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.font.TextAttribute;
import java.io.InputStream;
import java.awt.event.ActionEvent;
import javax.swing.border.LineBorder;
import java.awt.Toolkit;
import javax.swing.border.MatteBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.JComboBox;

public class mainpage extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtid;
	JLabel lblimage = new JLabel("");
	JLabel lbltime = new JLabel("Name : ");
	JLabel lblname = new JLabel("Name : ");
	JLabel lblsnum = new JLabel("Student # :");
	JLabel lblsection = new JLabel("Student # :");
	JLabel lblage = new JLabel("Student # :");
	JComboBox comboBox = new JComboBox();
	private Timer timer;
	String username = "root";
	String password = "12312004";
	String database = "jdbc:mysql://localhost:3306/attendancesystem";
	String database1 = "jdbc:mysql://localhost:3306/dates";
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					homepage frame = new homepage();
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
	public mainpage() {
		setTitle("Cavite State University");
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Zelpha\\OneDrive\\Documents\\Prens\\Comprog\\Web Dev\\HTML\\Images\\cvsulogo.png"));
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1139, 801);
		contentPane = new JPanel();
		contentPane.setForeground(Color.LIGHT_GRAY);
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new LineBorder(new Color(0, 0, 0)));
		contentPane.setLayout(null);
		

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnShow = new JButton("SHOW");
		btnShow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
				    Class.forName("com.mysql.cj.jdbc.Driver");
				    Connection con1 = DriverManager.getConnection(database1, username, password);

				    // ✅ Get selected table name from JComboBox
				    String selectedTable = comboBox.getSelectedItem().toString(); 

				        String query = "SELECT * FROM " + selectedTable; // Corrected query

				        PreparedStatement pst2 = con1.prepareStatement(query);
				        ResultSet rs2 = pst2.executeQuery();
				        ResultSetMetaData rsmd = rs2.getMetaData();

				        DefaultTableModel model = (DefaultTableModel) table.getModel();

				        // ✅ Get column names
				        int cols = rsmd.getColumnCount();
				        String[] colName = new String[cols];
				        for (int i = 0; i < cols; i++) 
				            colName[i] = rsmd.getColumnName(i + 1);
				        model.setColumnIdentifiers(colName);

				        // ✅ Clear table before adding new data
				        model.setRowCount(0);

				        // ✅ Fetch and add data to the table
				        while (rs2.next()) {
				            String[] row = new String[cols];
				            for (int i = 0; i < cols; i++) {
				                row[i] = rs2.getString(i + 1); // Fetch each column value
				            }
				            model.addRow(row);
				        }

				        // ✅ Close connection
				        rs2.close();
				        pst2.close();
				        con1.close();
				    
				} catch (Exception e4) {
				    e4.printStackTrace();
				}
			}
		});
		btnShow.setFont(new Font("Tahoma", Font.BOLD, 23));
		btnShow.setBackground(Color.WHITE);
		btnShow.setBounds(900, 182, 140, 45);
		contentPane.add(btnShow);
		
		comboBox = new JComboBox();
		comboBox.setFont(new Font("Tahoma", Font.BOLD, 25));
		comboBox.setBounds(546, 187, 344, 38);
		
		 try {
	            // 1. Load MySQL JDBC Driver
	            Class.forName("com.mysql.cj.jdbc.Driver");
	            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/attendancesystem", "root", "12312004");

	            // 2. Fetch Data from Database
	            PreparedStatement pst = con.prepareStatement("SELECT Dates FROM dropbox");
	            ResultSet rs = pst.executeQuery();

	            // 3. Add Data to JComboBox
	            while (rs.next()) {
	                comboBox.addItem(rs.getString("Dates")); // Insert data from DB
	            }

	            con.close(); // Close connection
	        } catch (Exception e) {
	            e.printStackTrace();
	        }

		contentPane.add(comboBox);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setOpaque(true);
		lblNewLabel.setBackground(Color.BLACK);
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setBounds(0, 77, 1136, 1);
		contentPane.add(lblNewLabel);
		
		txtid = new JTextField();
		txtid.setFont(new Font("Tahoma", Font.BOLD, 22));
		txtid.setBounds(559, 680, 375, 60);
		contentPane.add(txtid);
		txtid.setColumns(10);
		
		
	
		
		txtid.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                startAutoSaveTimer();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                startAutoSaveTimer();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                startAutoSaveTimer();
            }
        });
		



        setVisible(true);
		
		
		
		JLabel lblNewLabel_1 = new JLabel("Student Number:");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(390, 679, 160, 60);
		contentPane.add(lblNewLabel_1);
		
		lblname = new JLabel("Name : ");
		lblname.setForeground(new Color(255, 255, 255));
		lblname.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblname.setBounds(38, 427, 279, 60);
		contentPane.add(lblname);
		
		lblsection = new JLabel("Section : ");
		lblsection.setForeground(new Color(255, 255, 255));
		lblsection.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblsection.setBounds(38, 497, 279, 60);
		contentPane.add(lblsection);
		
		lblage =  new JLabel("Age : ");
		lblage.setForeground(new Color(255, 255, 255));
		lblage.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblage.setBounds(38, 560, 279, 60);
		contentPane.add(lblage);
		
		lblsnum = new JLabel("Student # :");
		lblsnum.setForeground(new Color(255, 255, 255));
		lblsnum.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblsnum.setBounds(38, 629, 295, 60);
		contentPane.add(lblsnum);
		
		
		
		table = new JTable();
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBackground(Color.GREEN);
		scrollPane.setBounds(373, 235, 742, 424);
		contentPane.add(scrollPane);
		
		autotable();
		
		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment(DefaultTableCellRenderer.CENTER);
		table.setDefaultRenderer(Object.class, centerRenderer);
		table.setFont(new Font("Tahoma", Font.PLAIN, 18)); 
		table.setRowHeight(35);
		
		
		
		JTableHeader header = table.getTableHeader();
		header.setFont(new Font("Tahoma", Font.PLAIN, 20));
		header.setForeground(Color.WHITE);
		header.setBackground(new Color(60, 179, 113));
		header.setReorderingAllowed(false);
		
		
		

        JButton btn1 = button("Logs", 0, 2, 227, 75);
        btn1.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		logs lg = new logs();
        		lg.setVisible(true);
        		lg.setLocationRelativeTo(null);
        		dispose();
        	}
        });
        JButton btn2 = button("Register",225,2, 225, 75);
        btn2.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		cameras c = new cameras();
	    		c.setLocationRelativeTo(null);
	    		c.show();
	    		dispose();
	    	}
	    });
        JButton btn3 = button("Attendance", 450, 2, 225, 75);
        JButton btn4 = button("About",675,2, 225, 75);
        JButton btn5 = button("Maintenance",900,2, 225, 75);
        btn5.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		securityM m1 = new securityM();
	    		m1.setLocationRelativeTo(null);
	    		m1.show();
	    		dispose();
	    	}});

        JButton btn6 = button("Search", 954, 681, 140, 55);
        btn6.setBackground(Color.WHITE);
        btn6.setOpaque(true);
        btn6.addMouseListener(new java.awt.event.MouseAdapter() {
		    Font originalFont = null;

		    public void mouseEntered(java.awt.event.MouseEvent evt) {
		        originalFont = btn6.getFont();
		        Map attributes = originalFont.getAttributes();
		        attributes.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
		        btn6.setFont(originalFont.deriveFont(attributes));
		    }

		    public void mouseExited(java.awt.event.MouseEvent evt) {
		    	btn6.setFont(originalFont);
		    }
		});
        btn6.addMouseListener(new java.awt.event.MouseAdapter() {
	        public void mouseEntered(java.awt.event.MouseEvent evt) {
	        	btn6.setBackground(Color.BLACK);
	        	btn6.setForeground(Color.WHITE);
	        	btn6.setOpaque(true);
	       }
	        public void mouseExited(java.awt.event.MouseEvent evt) {
	        	btn6.setBackground(Color.WHITE);
	        	btn6.setOpaque(true);
	        	btn6.setForeground(Color.BLACK);
	        }
	    });
        
        btn6.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		try {
	    			
	    			   if (txtid.getText().trim().isEmpty()) {
	   		            JOptionPane.showMessageDialog(null, "Please enter a Student Number to search.");
	   		            return;
	   		        }
	    			//jdbc
	    			Class.forName("com.mysql.cj.jdbc.Driver");
	    			Connection con = DriverManager.getConnection(database,username,password);
	    			PreparedStatement pst = con.prepareStatement("Select * from studentinfo inner join image on studentinfo.SNUm = image.SNUM where studentinfo.SNUM = ?");
//	    			PreparedStatement pst1 = con.prepareStatement("Select * from image where SNUM = ?");
	    			PreparedStatement pst2 = con.prepareStatement("Select * from studentinfo where SNUM = ?");
	    			
	    			pst.setString(1, txtid.getText());
//	    			pst1.setString(1, txtid.getText());
	    			pst2.setString(1, txtid.getText());
	    			
	    			ResultSet rs = pst.executeQuery();
//	    			ResultSet rs1 = pst1.executeQuery();
	    			ResultSet rs2 = pst2.executeQuery();
					ResultSetMetaData rsmd = rs2.getMetaData();  // balikan mo to aralin mo ulit kasi pwedeng mas maikli pa pagsamahin ang rs and rs2
					DefaultTableModel model = (DefaultTableModel) table.getModel();
					
					// Get column names
				    int cols = rsmd.getColumnCount();
				    String[] colName = new String[cols];
				    for (int i = 0; i < cols; i++) 
				        colName[i] = rsmd.getColumnName(i + 1);
				    model.setColumnIdentifiers(colName);

				    // ✅ Clear table before adding new data
				    model.setRowCount(0);

				    // Fetch and add data to the table
				    while (rs2.next()) {
				        String SNUM = rs2.getString(1);
				        String Fullname = rs2.getString(2);
				        String Section = rs2.getString(3);
				        String Age = rs2.getString(4);
				        String DateAndTime = rs2.getString(5);

				        String[] row = {SNUM, Fullname, Section, Age, DateAndTime};
				        model.insertRow(0,row);
				    }

	    			
	    			if(rs.next()) {
	    				
	    				//retrieve string data from database to lbl
	    				String name = rs.getString("Fullname");
	    				String section = rs.getString("Section");
	    				int age = rs.getInt("Age");
	    				int snum = rs.getInt("SNUM");
	    				
	    				lblname.setText("Name       : " + name);
	    				lblsection.setText("Section     : " + section);
	    				lblage.setText("Age          : " + age);
	    				lblsnum.setText("Student # : " + snum);
	    				
	    				Blob image = rs.getBlob("Image");
	    				InputStream inputStream = image.getBinaryStream();  // Convert to InputStream
	    				Image images = ImageIO.read(inputStream);
	    				
	    				Image resizedImage = images.getScaledInstance(lblimage.getWidth(), lblimage.getHeight(), Image.SCALE_SMOOTH);

	    				lblimage.setIcon(new ImageIcon(resizedImage));
	    				
	    				txtid.setText("");
	    				
	    			} 
	    			
	    			rs.close();
//	                rs1.close();
	                rs2.close();

	          
	                pst.close();
//	                pst1.close();
	                pst2.close();

	     
	                con.close();
	    			
	    		} catch (Exception e3) {
	    			e3.printStackTrace();
	    		}
	    	}
	    });
        
        
        contentPane.add(btn1);
        contentPane.add(btn2);
        contentPane.add(btn3);
        contentPane.add(btn4);
        contentPane.add(btn5);
        contentPane.add(btn6);
        
        JLabel lblNewLabel_1_4_1 = new JLabel("ATTENDANCE");
        lblNewLabel_1_4_1.setBackground(Color.BLACK);
        lblNewLabel_1_4_1.setForeground(Color.BLACK);
        lblNewLabel_1_4_1.setFont(new Font("Microsoft Himalaya", Font.BOLD, 66));
        lblNewLabel_1_4_1.setBounds(565, 142, 325, 45);
        contentPane.add(lblNewLabel_1_4_1);
        
        JPanel panel = new JPanel();
        panel.setBorder(new LineBorder(Color.WHITE, 6, true));
        panel.setBackground(new Color(60, 179, 113));
        panel.setBounds(21, 146, 342, 608);
        contentPane.add(panel);
        panel.setLayout(null);
        
        lblimage = new JLabel("");
        lblimage.setBounds(59, 36, 225, 225);
        lblimage.setOpaque(true);
        lblimage.setIcon(new ImageIcon("C:\\Users\\Zelpha\\OneDrive\\Documents\\Prens\\Comprog\\Web Dev\\HTML\\Images\\cvsulogo.png"));
        lblimage.setHorizontalAlignment(SwingConstants.CENTER);
        lblimage.setFont(new Font("Tahoma", Font.PLAIN, 29));
        lblimage.setBackground(Color.WHITE);
        panel.add(lblimage);
        
        lbltime = new JLabel("Name : ");
        lbltime.setForeground(Color.WHITE);
        lbltime.setFont(new Font("Tahoma", Font.PLAIN, 22));
        lbltime.setBounds(59, 56, 215, 60);
        panel.add(lbltime);
        
        JPanel panel_1 = new JPanel();
        panel_1.setBackground(new Color(60, 179, 113));
        panel_1.setBounds(373, 669, 741, 85);
        contentPane.add(panel_1);
        
        JLabel lblNewLabel_2_1 = new JLabel("");
        lblNewLabel_2_1.setOpaque(true);
        lblNewLabel_2_1.setIcon(new ImageIcon("C:\\Users\\Zelpha\\OneDrive\\Documents\\Prens\\Comprog\\Web Dev\\HTML\\Images\\school.png"));
        lblNewLabel_2_1.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_2_1.setFont(new Font("Tahoma", Font.PLAIN, 29));
        lblNewLabel_2_1.setBackground(Color.WHITE);
        lblNewLabel_2_1.setBounds(0, 2, 1125, 762);
        contentPane.add(lblNewLabel_2_1);
        
      
        
	}
	public JButton button(String text, int x, int y, int width, int height) {
	    JButton button = new JButton(text);
	    button.setOpaque(false);
	    button.setBounds(x, y, width, height); // Set position and size
	    button.setFont(new Font("Tahoma", Font.BOLD, 18)); // Set font style
	    button.setForeground(Color.BLACK); // Set text color
	    button.setBackground(Color.WHITE);
	    button.setFocusPainted(false); // Remove focus border
	    button.setBorderPainted(false); // Remove border
	    button.addMouseListener(new java.awt.event.MouseAdapter() {
	        public void mouseEntered(java.awt.event.MouseEvent evt) {
	        	button.setBackground(new Color(60, 179, 113));
	        	button.setOpaque(true);
	       }
	        public void mouseExited(java.awt.event.MouseEvent evt) {
	            button.setBackground(Color.BLUE);
	            button.setOpaque(false);
	        }
	    });
	    return button;
	}
	
	public void autotable() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(database1,username,password);
			
			String selectedTable = comboBox.getSelectedItem().toString(); 

		    String query = "SELECT * FROM " + selectedTable; // Corrected query
			
			PreparedStatement pst = con.prepareStatement(query);
			
			ResultSet rs = pst.executeQuery();
			ResultSetMetaData rsmd = rs.getMetaData();
			DefaultTableModel model = (DefaultTableModel) table.getModel();
			
			int cols = rsmd.getColumnCount();
			String[] colName = new String[cols];
			for (int i = 0 ; i < cols; i++) 
				colName[i] = rsmd.getColumnName(i+1);
			model.setColumnIdentifiers(colName);
			
			String SNUM,Fullname,Section,Age,DateAndTime;

			model.setRowCount(0);
			
			while(rs.next()) {
				SNUM = rs.getString(1);
				Fullname = rs.getString(2);
				Section = rs.getString(3);
				Age = rs.getString(4);
				DateAndTime = rs.getString(5);
				
				String[] row = {SNUM,Fullname,Section,Age,DateAndTime};
				model.insertRow(0, row);

			}
			con.close();
			pst.close();
			}
			catch (Exception e1){
				System.out.print(e1);
			}
		
	}
	
	  private void saveToDatabase(String data) {
	        if (data.trim().isEmpty()) return; // Ignore empty input
	        

	        try {
    			//jdbc
    			Class.forName("com.mysql.cj.jdbc.Driver");
    			Connection con = DriverManager.getConnection(database,username,password);
    			Connection con1 = DriverManager.getConnection(database1,username,password);
    			
    			String selectedTable = comboBox.getSelectedItem().toString(); 

			    String query = "SELECT * FROM " + selectedTable; // Corrected query

    			
    			PreparedStatement pst = con.prepareStatement("Select * from studentinfo inner join image on studentinfo.SNUM = image.SNUM where studentinfo.SNUM = ?");
    			PreparedStatement pst2 = con1.prepareStatement(query);
   
    			
    			pst.setString(1, txtid.getText());

    			
    			
    			ResultSet rs = pst.executeQuery();
//    			ResultSet rs1 = pst1.executeQuery();
    			ResultSet rs2 = pst2.executeQuery();
    
				ResultSetMetaData rsmd = rs2.getMetaData();  // balikan mo to aralin mo ulit kasi pwedeng mas maikli pa pagsamahin ang rs and rs2
				DefaultTableModel model = (DefaultTableModel) table.getModel();
				
				// Get column names
			    int cols = rsmd.getColumnCount();
			    String[] colName = new String[cols];
			    for (int i = 0; i < cols; i++) 
			        colName[i] = rsmd.getColumnName(i + 1);
			    model.setColumnIdentifiers(colName);

			    // ✅ Clear table before adding new data
			    model.setRowCount(0);

			    // Fetch and add data to the table
			    while (rs2.next()) {
			        String SNUM = rs2.getString(1);
			        String Fullname = rs2.getString(2);
			        String Section = rs2.getString(3);
			        String Age = rs2.getString(4);
			        String DateAndTime = rs2.getString(5);

			        String[] row = {SNUM, Fullname, Section, Age, DateAndTime};
			        model.addRow(row);
			    }

    			
    			if(rs.next()) {
    				
    				//retrieve string data from database to lbl
    				String name = rs.getString("Fullname");
    				String section = rs.getString("Section");
    				int age = rs.getInt("Age");
    				int snum = rs.getInt("SNUM");
    				
    				lblname.setText("Name       : " + name);
    				lblsection.setText("Section     : " + section);
    				lblage.setText("Age          : " + age);
    				lblsnum.setText("Student # : " + snum);
    				
    				LocalDateTime now = LocalDateTime.now();
			        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
			        String formattedDateTime = now.format(formatter);
			        lbltime.setText(formattedDateTime);
    				
        			PreparedStatement pst3 = con.prepareStatement("insert into attendance (SNUM,Fullname,Section,Age,DateAndTime) VALUES (?,?,?,?,?)");
        			
        			pst3.setString(1, Integer.toString(snum));
        			pst3.setString(2, name);
        			pst3.setString(3, section);
        			pst3.setString(4, Integer.toString(age));
        			pst3.setString(5, formattedDateTime);
        			
        			String selectedTable1 = comboBox.getSelectedItem().toString(); 
	    				
	        		String query1 = "INSERT INTO " +  selectedTable1 + " (SNUM,Fullname,Section,Age,DateAndTime) VALUES (?,?,?,?,?)";
	        		
	        			// aralin ko ulit kasi sa ibaba nalabas
	        		PreparedStatement pst4 = con1.prepareStatement(query1);
	        		pst4.setString(1, Integer.toString(snum));
	        		pst4.setString(2, name);
	        		pst4.setString(3, section);
	        		pst4.setString(4, Integer.toString(age));
	        		pst4.setString(5, formattedDateTime);
	        		
	        		
//	        			
	        		pst3.executeUpdate();
	        		int rows =	pst4.executeUpdate();
	        		JOptionPane.showMessageDialog(null, "Attendance Successfully");

        		
        			
        			Blob image = rs.getBlob("Image");
    				InputStream inputStream = image.getBinaryStream();  // Convert to InputStream
    				Image images = ImageIO.read(inputStream);
    				
    				Image resizedImage = images.getScaledInstance(lblimage.getWidth(), lblimage.getHeight(), Image.SCALE_SMOOTH);

    				lblimage.setIcon(new ImageIcon(resizedImage));
    				
    				txtid.setText("");
    				
    				
    			}

				    // Fetch and add data to the table
				    autotable();
    			rs.close();
                rs2.close();

          
                pst.close();
                pst2.close();

     
                con.close();
    			con1.close();
	        } catch (Exception e3) {
    			e3.printStackTrace();
    		}
	        
    	}
    
	    
	  
	  private void startAutoSaveTimer() {
	        if (timer != null) {
	            timer.cancel(); // Reset the timer if user is still typing
	        }
	        
	        timer = new Timer();
	        timer.schedule(new TimerTask() {
	            @Override
	            public void run() {
	                saveToDatabase(txtid.getText()); // Auto-save after delay
	            }
	        }, 1000); // Auto-save after 1 seconds of inactivity
	    }

	
}


