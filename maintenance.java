package camera;

import java.awt.Color;
import java.awt.EventQueue;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Map;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.DriverManager;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import main.mainpage;

import javax.swing.JButton;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.font.TextAttribute;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

public class maintenance extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	String database = "jdbc:mysql://localhost:3306/attendancesystem";
	String database1 = "jdbc:mysql://localhost:3306/dates";
	String username = "root";
	String password = "12312004";
	JComboBox comboBox = new JComboBox();
	JButton btn6 = button("Search", 954, 681, 140, 55);
	JButton btn7 = button("Search", 954, 681, 140, 55);
	JButton btn8 = button("Search", 954, 681, 140, 55);
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					maintenance frame = new maintenance();
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
	public maintenance() {
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
		
		btn8 = button("Create Table", 954, 681, 140, 55);
		btn8.setBackground(Color.gray);
		btn8.setOpaque(true);
		btn8.addMouseListener(new java.awt.event.MouseAdapter() {
		    Font originalFont = null;

		    public void mouseEntered(java.awt.event.MouseEvent evt) {
		        originalFont = btn8.getFont();
		        Map attributes = originalFont.getAttributes();
		        attributes.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
		        btn8.setFont(originalFont.deriveFont(attributes));
		    }

		    public void mouseExited(java.awt.event.MouseEvent evt) {
		    	btn8.setFont(originalFont);
		    	btn8.setBackground(Color.gray);
		    }
		});
		btn8.addMouseListener(new java.awt.event.MouseAdapter() {
	        public void mouseEntered(java.awt.event.MouseEvent evt) {
	        	btn8.setBackground(Color.WHITE);
	        	btn8.setForeground(Color.BLACK);
	        	btn8.setOpaque(true);
	       }
	        public void mouseExited(java.awt.event.MouseEvent evt) {
	        	btn8.setBackground(Color.GRAY);
	        	btn8.setOpaque(true);
	        	btn8.setForeground(Color.BLACK);
	        }
	    });
		

		btn8.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        try {
		            Class.forName("com.mysql.cj.jdbc.Driver");
		            Connection con = DriverManager.getConnection(database, username, password);
		            Connection con1 = DriverManager.getConnection(database1, username, password);
		            
		            LocalDate now = LocalDate.now();
		            String date = "date_" + now.toString().replace("-", "_");

		       
		            String sql = "CREATE TABLE IF NOT EXISTS " + date + " ("
		                    + "SNUM INT NOT NULL, "
		                    + "Fullname VARCHAR(50) NULL, "
		                    + "Section VARCHAR(50) NULL, "
		                    + "Age INT NULL, "
		                    + "DateAndTime DATETIME NULL)";
		            
		            PreparedStatement pst = con.prepareStatement("insert into dropbox (Dates) Values (?)");
		            PreparedStatement pst1 = con1.prepareStatement(sql);
		            
		            pst.setString(1, date);
		            
		            pst.executeUpdate();
		            pst1.executeUpdate();
		        
		            JOptionPane.showMessageDialog(null , "Created");
		
		            // Close resources
		            pst.close();
		            con1.close();

		        } catch (Exception e1) {
		            e1.printStackTrace(); 
		        }
		    }
		});
		
		JButton btnNewButton = new JButton("RESET FACTORY");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					
					
					
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con = DriverManager.getConnection(database,username,password);
			
			
					
					 int response = JOptionPane.showConfirmDialog(null, "Warning: This action will truncate all tables but the date and its data stays intact", "Confirm", JOptionPane.YES_NO_OPTION);
			            if (response == JOptionPane.YES_OPTION) {
			                String input = JOptionPane.showInputDialog(null, "Enter password");
			                if (input != null && input.equalsIgnoreCase("cvsuimus")) {
			                    PreparedStatement pst1 = con.prepareStatement("TRUNCATE TABLE attendance");
			                    PreparedStatement pst2 = con.prepareStatement("TRUNCATE TABLE image"); 
			                    PreparedStatement pst3 = con.prepareStatement("TRUNCATE TABLE studentinfo"); 
			                   
			            
 
			                    pst1.executeUpdate();
			                    pst2.executeUpdate();
			                    pst3.executeUpdate();
			               
			                
			      
			                    pst1.close();
			                    pst2.close();
			                    pst3.close();
			                 
			                
			      
			                    
			                    JOptionPane.showMessageDialog(null, "Tables have been truncated.");
			                } else {
			                    JOptionPane.showMessageDialog(null, "Password Incorrect");
			                }
			            }
			            con.close();
			        } catch (Exception ex) {
			            ex.printStackTrace();
			            JOptionPane.showMessageDialog(null, "Error truncating tables.");
			        }
			}
		});
		btnNewButton.setFont(new Font("Microsoft Himalaya", Font.PLAIN, 67));
		btnNewButton.setBounds(268, 569, 636, 64);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_1_4_1 = new JLabel("MAINTENANCE");
		lblNewLabel_1_4_1.setForeground(Color.BLACK);
		lblNewLabel_1_4_1.setFont(new Font("Microsoft Himalaya", Font.BOLD, 66));
		lblNewLabel_1_4_1.setBackground(Color.BLACK);
		lblNewLabel_1_4_1.setBounds(411, 180, 357, 45);
		contentPane.add(lblNewLabel_1_4_1);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setOpaque(true);
		lblNewLabel_1.setBackground(Color.BLACK);
		lblNewLabel_1.setBounds(-52, 105, 1177, 1);
		contentPane.add(lblNewLabel_1);

		btn8.setFont(new Font("Tahoma", Font.BOLD, 26));
		btn8.setBounds(452, 253, 258, 49);
		contentPane.add(btn8);
		
		
		 JButton btn2 = button("Main Menu",225,2, 225, 75);;
		 btn2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mainpage mp = new mainpage();
				mp.setLocationRelativeTo(null);
				mp.show();
				dispose();
			}
		});
		 btn2.setBounds(0, 0, 188, 106);
		contentPane.add(btn2);
		
		btn7 = button("Truncate Data", 954, 681, 140, 55);
		btn7.setBackground(Color.gray);
		btn7.setOpaque(true);
		btn7.addMouseListener(new java.awt.event.MouseAdapter() {
		    Font originalFont = null;

		    public void mouseEntered(java.awt.event.MouseEvent evt) {
		        originalFont = btn7.getFont();
		        Map attributes = originalFont.getAttributes();
		        attributes.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
		        btn7.setFont(originalFont.deriveFont(attributes));
		    }

		    public void mouseExited(java.awt.event.MouseEvent evt) {
		    	btn7.setFont(originalFont);
		    	btn7.setBackground(Color.gray);
		    }
		});
		btn7.addMouseListener(new java.awt.event.MouseAdapter() {
	        public void mouseEntered(java.awt.event.MouseEvent evt) {
	        	btn7.setBackground(Color.WHITE);
	        	btn7.setForeground(Color.BLACK);
	        	btn7.setOpaque(true);
	       }
	        public void mouseExited(java.awt.event.MouseEvent evt) {
	        	btn7.setBackground(Color.GRAY);
	        	btn7.setOpaque(true);
	        	btn7.setForeground(Color.BLACK);
	        }
	    });
        btn7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					
					
					
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con = DriverManager.getConnection(database1,username,password);
					
					String selectedTable = comboBox.getSelectedItem().toString(); 

				    String query = "Truncate table " + selectedTable; 
					
				    PreparedStatement pst = con.prepareStatement(query);
				    
				    
				    int response = JOptionPane.showConfirmDialog(null, "Are you sure?", "Confirm", JOptionPane.YES_NO_OPTION);
				    if (response == JOptionPane.YES_OPTION) {
				    	JOptionPane.showMessageDialog(null, "Table '" + selectedTable + "' has been truncated.");
				    	 pst.executeUpdate();
				    }
				    
				 
				} catch(Exception e2) {
					e2.printStackTrace();
					JOptionPane.showMessageDialog(null, "Error");
				}
				
				
			}
		});
        btn7.setFont(new Font("Tahoma", Font.BOLD, 26));
        btn7.setBounds(639, 387, 258, 49);
		contentPane.add(btn7);
		
		comboBox = new JComboBox();
		comboBox.setFont(new Font("Tahoma", Font.BOLD, 24));
		comboBox.setBounds(393, 487, 365, 49);
		contentPane.add(comboBox);
		
		
		btn6 = button("Delete Table", 954, 681, 140, 55);
        btn6.setBackground(Color.gray);
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
		    	   btn6.setBackground(Color.gray);
		    }
		});
        btn6.addMouseListener(new java.awt.event.MouseAdapter() {
	        public void mouseEntered(java.awt.event.MouseEvent evt) {
	        	btn6.setBackground(Color.WHITE);
	        	btn6.setForeground(Color.BLACK);
	        	btn6.setOpaque(true);
	       }
	        public void mouseExited(java.awt.event.MouseEvent evt) {
	        	btn6.setBackground(Color.GRAY);
	        	btn6.setOpaque(true);
	        	btn6.setForeground(Color.BLACK);
	        }
	    });
        btn6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection con = DriverManager.getConnection(database,username,password);
				Connection con1 = DriverManager.getConnection(database1,username,password);
				
				String selectedTable = comboBox.getSelectedItem().toString(); 
				
				String query = "Delete from dropbox where Dates = ?";
				
			    String query1 = "Drop table " + selectedTable; 
				
			    PreparedStatement pst = con.prepareStatement(query);
			    pst.setString(1, selectedTable);
			    PreparedStatement pst1 = con1.prepareStatement(query1);

			    
			    int response = JOptionPane.showConfirmDialog(null, "Are you sure?", "Confirm", JOptionPane.YES_NO_OPTION);
			    if (response == JOptionPane.YES_OPTION) {
			    	 pst.executeUpdate();
					 pst1.executeUpdate();
					 JOptionPane.showMessageDialog(null, "Table '" + selectedTable + "' has been deleted.");
			    }
				
				
			}catch(Exception e4) {
				e4.printStackTrace();
			}
			
			}
		});
        btn6.setFont(new Font("Tahoma", Font.BOLD, 26));
        btn6.setBounds(271, 387, 258, 49);
		contentPane.add(btn6);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setOpaque(true);
		lblNewLabel_3.setBounds(218, 344, 748, 300);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setBorder(new LineBorder(new Color(255, 255, 255), 6, true));
		lblNewLabel_2.setBackground(new Color(60, 179, 113));
		lblNewLabel_2.setOpaque(true);
		lblNewLabel_2.setBounds(195, 135, 797, 528);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Zelpha\\OneDrive\\Documents\\Prens\\Comprog\\Web Dev\\HTML\\Images\\school.png"));
		lblNewLabel.setBounds(10, 0, 1125, 764);
		contentPane.add(lblNewLabel);
		
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(database,username,password);
			
			PreparedStatement pst = con.prepareStatement("SELECT Dates FROM dropbox");
            ResultSet rs = pst.executeQuery();
            
            while(rs.next()) {
            	comboBox.addItem(rs.getString("Dates"));
            }
		
			
		}catch (Exception e3) {
			e3.printStackTrace();
			
		}
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
}
