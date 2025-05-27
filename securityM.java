package camera;

import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JPasswordField;
import javax.swing.SwingUtilities;
import javax.swing.JButton;

public class securityM extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPasswordField txtpassword;
	private Timer timer;
	String database = "jdbc:mysql://localhost:3306/attendancesystem";
	String username = "root";
	String password = "12312004";
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					securityM frame = new securityM();
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
	public securityM() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1028, 562);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtpassword = new JPasswordField();
		txtpassword.setBounds(283, 214, 407, 82);
		contentPane.add(txtpassword);
		
		txtpassword.getDocument().addDocumentListener(new DocumentListener() {
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
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Zelpha\\OneDrive\\Documents\\Prens\\Comprog\\Web Dev\\HTML\\Images\\school.png"));
		lblNewLabel.setBounds(-35, 0, 1062, 539);
		contentPane.add(lblNewLabel);
	}
	private void saveToDatabase(String data) {
        if (data.trim().isEmpty()) return; // Ignore empty input
        
        try {
        	Class.forName("com.mysql.cj.jdbc.Driver");
        	Connection con = DriverManager.getConnection(database,username,password);
        	
        	PreparedStatement pst = con.prepareStatement("Select * from securityM where password = ?");
        	pst.setString(1, txtpassword.getText());
        	
        	ResultSet rs = pst.executeQuery();
        	
        	if(rs.next()) {
        	maintenance m = new maintenance();
        	m.setLocationRelativeTo(null);
        	m.show();
        	dispose();
        	} else 
				JOptionPane.showMessageDialog(null, "Wrong");
        	
        } catch(Exception e2) {
        	e2.printStackTrace();
        	JOptionPane.showMessageDialog(null, "Error");
        }
        
	}
	
	private void startAutoSaveTimer() {
	    if (timer != null) {
	        timer.cancel(); // Reset the timer if the user is still typing
	    }
	    
	    timer = new Timer();
	    timer.schedule(new TimerTask() {
	        @Override
	        public void run() {
	            // Ensure saveToDatabase runs on the correct thread
	            SwingUtilities.invokeLater(() -> {
	                saveToDatabase(txtpassword.getText()); // Auto-save after delay
	            });
	        }
	    }, 1000); // Auto-save after 1 second of inactivity
	}
}
