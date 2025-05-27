package camera;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;


import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.LineBorder;

import org.opencv.core.*;
import org.opencv.videoio.VideoCapture;

import main.mainpage;

import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;
import java.awt.event.ActionListener;
import java.awt.font.TextAttribute;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Map;

public class cameras extends JFrame { // Renamed class to 'Cameras' (Java convention)
    private JLabel cameraLabel;
    private VideoCapture capture;
    private boolean isCameraRunning = true; // Set to true so the loop runs
    private JTextField txtname;
    private JTextField txtsection;
    private JTextField txtnumber;
    private JTextField txtguardians;
    JLabel cameralabs = new JLabel();
    JButton btn6 = button("Delete Table", 954, 681, 140, 55);
    JButton btn7 = button("Delete Table", 954, 681, 140, 55);
    
    String username = "root";
	String password = "12312004";
	String database = "jdbc:mysql://localhost:3306/attendancesystem";
	private JTextField txtage;
	JLabel txtregister = new JLabel("Date of Registry ");
	 JLabel txtregister2 = new JLabel("");
	 private JTextField textField;
    public cameras() {
    	setTitle("Cavite State University");
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Zelpha\\OneDrive\\Documents\\Prens\\Comprog\\Web Dev\\HTML\\Images\\cvsulogo.png"));
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1100, 801);
		JPanel contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 191, 255));
		contentPane.setBorder(new LineBorder(new Color(0, 0, 0)));
		contentPane.setLayout(null);

		

		setContentPane(contentPane);
		contentPane.setLayout(null);

    	System.loadLibrary(Core.NATIVE_LIBRARY_NAME); 
        
    	txtguardians = new JTextField();
    	txtguardians.setFont(new Font("Tahoma", Font.PLAIN, 18));
    	txtguardians.setColumns(10);
    	txtguardians.setBounds(696, 653, 317, 45);
        contentPane.add(txtguardians);
        
        JLabel lblGuardiansEmail = new JLabel("Guardian's Email :");
        lblGuardiansEmail.setFont(new Font("Tahoma", Font.PLAIN, 26));
        lblGuardiansEmail.setBounds(738, 600, 316, 59);
        contentPane.add(lblGuardiansEmail);
        
        JLabel lblNewLabel_3 = new JLabel("");
        lblNewLabel_3.setOpaque(true);
        lblNewLabel_3.setForeground(Color.BLACK);
        lblNewLabel_3.setBackground(Color.BLACK);
        lblNewLabel_3.setBounds(-7, 76, 1136, 1);
        contentPane.add(lblNewLabel_3);

        // Create JLabel for camera preview
        cameraLabel = new JLabel();
        cameraLabel.setForeground(Color.GREEN);
        cameraLabel.setBounds(48, 213, 576, 398);
        cameraLabel.setBackground(Color.PINK);
        getContentPane().add(cameraLabel);

        // Capture button
//        JButton captureButton = new JButton("Capture Image");
//        captureButton.setBounds(152, 427, 225, 45);
//        captureButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
//        captureButton.addActionListener((ActionEvent e) -> captureImage());
//        getContentPane().add(captureButton);
        
        
        
        JLabel lblNewLabel = new JLabel("Name : ");
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 26));
        lblNewLabel.setBounds(803, 152, 107, 59);
        getContentPane().add(lblNewLabel);
        
        JLabel lblSection = new JLabel("Section :");
        lblSection.setFont(new Font("Tahoma", Font.PLAIN, 26));
        lblSection.setBounds(803, 263, 107, 59);
        getContentPane().add(lblSection);
        
        JLabel lblStudentNumber = new JLabel("Student Number : ");
        lblStudentNumber.setFont(new Font("Tahoma", Font.PLAIN, 26));
        lblStudentNumber.setBounds(738, 488, 316, 59);
        getContentPane().add(lblStudentNumber);
        
        txtname = new JTextField();
        txtname.setFont(new Font("Tahoma", Font.PLAIN, 26));
        txtname.setBounds(696, 208, 317, 45);
        getContentPane().add(txtname);
        txtname.setColumns(10);
        
        txtsection = new JTextField();
        txtsection.setFont(new Font("Tahoma", Font.PLAIN, 26));
        txtsection.setColumns(10);
        txtsection.setBounds(697, 321, 317, 45);
        getContentPane().add(txtsection);
        
        txtnumber = new JTextField();
        txtnumber.setFont(new Font("Tahoma", Font.PLAIN, 18));
        txtnumber.setColumns(10);
        txtnumber.setBounds(696, 545, 317, 45);
        getContentPane().add(txtnumber);
        
        cameralabs = new JLabel();
        cameralabs.setForeground(Color.GREEN);
        cameralabs.setBackground(Color.PINK);
        cameralabs.setBounds(650, 152, 5, 110);
        cameralabs.setLocation(HIDE_ON_CLOSE, ABORT);
        getContentPane().add(cameralabs);
        
        
        
        btn6 = button("Capture", 954, 681, 140, 55);
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
		    	   btn6.setBackground(Color.WHITE);
		    }
		});
        btn6.addMouseListener(new java.awt.event.MouseAdapter() {
	        public void mouseEntered(java.awt.event.MouseEvent evt) {
	        	btn6.setBackground(Color.GRAY);
	        	btn6.setForeground(Color.WHITE);
	        	btn6.setOpaque(true);
	       }
	        public void mouseExited(java.awt.event.MouseEvent evt) {
	        	btn6.setBackground(Color.WHITE);
	        	btn6.setOpaque(true);
	        	btn6.setForeground(Color.BLACK);
	        }
	    });
        btn6.setFont(new Font("Tahoma", Font.PLAIN, 18));
        btn6.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		captureImage();
//                getContentPane().add(btnNewButton);
        		try {
        			
        			Class.forName("com.mysql.cj.jdbc.Driver");
        			Connection con = DriverManager.getConnection(database,username,password);
        			
        			LocalDateTime now = LocalDateTime.now();
			        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
			        
			        String formattedDateTime = now.format(formatter);
			        txtregister2.setText("Date of Registry : ");
			        txtregister.setText(formattedDateTime);
        			
        			PreparedStatement pst = con.prepareStatement("INSERT INTO studentinfo (SNUM, Fullname, Section, Age, DateAndTime, Email) VALUES (?,?, ?, ?, ?, ?)");
        			PreparedStatement pst1 = con.prepareStatement("Insert into image (SNUM,Fullname,Section,Image) Values(?,?,?,?)");

        			
        			pst.setString(1, txtnumber.getText());
        			pst.setString(2, txtname.getText());
        			pst.setString(3, txtsection.getText());
        			pst.setString(4, txtage.getText());
        			pst.setString(5, formattedDateTime);
        			pst.setString(6, txtguardians.getText());
        			
        			
        			pst1.setString(1, txtnumber.getText());
        			pst1.setString(2, txtname.getText());
        			pst1.setString(3, txtsection.getText());
        			// Convert image and store as a BLOB
        			ImageIcon icon = (ImageIcon) cameralabs.getIcon();
        			byte[] imageBytes = convertIconToBytes(icon);

        			if (imageBytes != null) {
        			    pst1.setBytes(4, imageBytes);
        			} else {
        			    pst1.setNull(4, java.sql.Types.BLOB); // If no image is set
        			}
        		
			        
	
        			int rows = pst.executeUpdate();
        			int rows1 = pst1.executeUpdate();
        
        			
					if(rows>0 && rows1 >0) {				
						JOptionPane.showMessageDialog(null, "Thank you for registry");
						txtnumber.setText("");
						txtname.setText("");
						txtsection.setText("");
						txtage.setText("");
						txtguardians.setText("");

					}
					
					else
						JOptionPane.showMessageDialog(null, "Student Number Duplication");
        			
        			
        			
        		}catch(Exception e1) {
        			System.out.print(e1);
        		}
        	}
        });
        btn6.setBounds(122, 651, 146, 47);
        getContentPane().add(btn6);
        
        btn7 = button("Clear", 954, 681, 140, 55);
        btn7.setBackground(Color.WHITE);
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
		    	btn7.setBackground(Color.WHITE);
		    }
		});
        btn7.addMouseListener(new java.awt.event.MouseAdapter() {
	        public void mouseEntered(java.awt.event.MouseEvent evt) {
	        	btn7.setBackground(Color.GRAY);
	        	btn7.setForeground(Color.WHITE);
	        	btn7.setOpaque(true);
	       }
	        public void mouseExited(java.awt.event.MouseEvent evt) {
	        	btn7.setBackground(Color.WHITE);
	        	btn7.setOpaque(true);
	        	btn7.setForeground(Color.BLACK);
	        }
	    });
        btn7.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		
        		txtnumber.setText("");
    			txtname.setText("");
    			txtsection.setText("");
    			txtage.setText("");
    			cameralabs.setBackground(getForeground());;
        	}
        });
        btn7.setFont(new Font("Tahoma", Font.PLAIN, 18));
        btn7.setBounds(310, 651, 146, 47);
        getContentPane().add(btn7);
        
        JButton btn1 = button("Logs", 0, 0, 200, 75);
        btn1.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		logs lg = new logs();
        		lg.setLocationRelativeTo(null);
        		lg.show();
        		dispose();
        	}
        });
        JButton btn2 = button("Register",225,0, 200, 75);
        JButton btn3 = button("Attendance", 450, 0, 200, 75);
        btn3.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		mainpage mp = new mainpage();
        		mp.setLocationRelativeTo(null);
        		mp.show();
        		dispose();
        	}
        });
        JButton btn4 = button("About",675,0, 200, 75);
        JButton btn5 = button("Maintenance",900,0, 200, 75);
        btn5.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		securityM m = new securityM();
	    		m.setLocationRelativeTo(null);
	    		m.show();
	    		dispose();
	    	}});
        contentPane.add(btn1);
        contentPane.add(btn2);
        contentPane.add(btn3);
        contentPane.add(btn4);
        contentPane.add(btn5);
        
        txtage = new JTextField();
        txtage.setFont(new Font("Tahoma", Font.PLAIN, 18));
        txtage.setColumns(10);
        txtage.setBounds(696, 433, 318, 45);
        contentPane.add(txtage);
        
        JLabel lblage = new JLabel("Age :");
        lblage.setFont(new Font("Tahoma", Font.PLAIN, 26));
        lblage.setBounds(820, 376, 102, 59);
        contentPane.add(lblage);
        
        JLabel lblNewLabel_2 = new JLabel("");
        lblNewLabel_2.setBorder(new LineBorder(new Color(255, 255, 255), 6, true));
        lblNewLabel_2.setOpaque(true);
        lblNewLabel_2.setBackground(new Color(60, 179, 113));
        lblNewLabel_2.setBounds(670, 139, 372, 589);
        contentPane.add(lblNewLabel_2);
        
        txtregister = new JLabel("");
        txtregister.setFont(new Font("Tahoma", Font.PLAIN, 26));
        txtregister.setBounds(65, 695, 316, 59);
        contentPane.add(txtregister);
        
        txtregister2 = new JLabel("");
        txtregister2.setFont(new Font("Tahoma", Font.PLAIN, 26));
        txtregister2.setBounds(696, 609, 316, 45);
        contentPane.add(txtregister2);
        
        JLabel lblNewLabel_1_4_1 = new JLabel("REGISTER");
        lblNewLabel_1_4_1.setForeground(Color.BLACK);
        lblNewLabel_1_4_1.setFont(new Font("Microsoft Himalaya", Font.BOLD, 66));
        lblNewLabel_1_4_1.setBackground(Color.BLACK);
        lblNewLabel_1_4_1.setBounds(425, 113, 246, 45);
        contentPane.add(lblNewLabel_1_4_1);
        
        JLabel lblNewLabel_1 = new JLabel("");
        lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\Zelpha\\OneDrive\\Documents\\Prens\\Comprog\\Web Dev\\HTML\\Images\\school.jpg"));
        lblNewLabel_1.setBounds(0, 0, 1125, 764);
        contentPane.add(lblNewLabel_1);

        // Start the camera preview in a new thread
        new Thread(() -> startCamera()).start();
        
    }
    
 // Convert ImageIcon to byte[]
    private byte[] convertIconToBytes(ImageIcon icon) {
        if (icon == null) {
            return null; // Handle the case where no image is present
        }

        BufferedImage bufferedImage = new BufferedImage(
                icon.getIconWidth(),
                icon.getIconHeight(),
                BufferedImage.TYPE_INT_RGB);

        Graphics g = bufferedImage.createGraphics();
        icon.paintIcon(null, g, 0, 0);
        g.dispose();

        try (ByteArrayOutputStream baos = new ByteArrayOutputStream()) {
            ImageIO.write(bufferedImage, "jpg", baos);
            return baos.toByteArray();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }


    private void startCamera() {
        capture = new VideoCapture(0); 
        if (!capture.isOpened()) {
            JOptionPane.showMessageDialog(this, "Error: Camera not found!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        Mat frame = new Mat();
        while (isCameraRunning) {
            capture.read(frame);
            if (!frame.empty()) {
                ImageIcon image = new ImageIcon(convertMatToBufferedImage(frame));
                cameraLabel.setIcon(image);
                cameraLabel.repaint();
            }
        }
        capture.release();
    }

    private void captureImage() {
        if (capture.isOpened()) {
            Mat frame = new Mat();
            capture.read(frame);
            if (!frame.empty()) {
            	
            	JOptionPane.showMessageDialog(this, "Image Captured");

                // Convert and display the captured image
                ImageIcon image = new ImageIcon(convertMatToBufferedImage(frame));

                cameraLabel.setIcon(image); // Show captured image in the JLabel
                cameralabs.setIcon(image);
  
            }
        }
    }
    
    

    private BufferedImage convertMatToBufferedImage(Mat mat) {
        int width = mat.width(), height = mat.height(), channels = mat.channels();
        byte[] sourcePixels = new byte[width * height * channels];
        mat.get(0, 0, sourcePixels);

        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_3BYTE_BGR);
        image.getRaster().setDataElements(0, 0, width, height, sourcePixels);
        return image;
    }

    public static void main(String[] args) {
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME); // Load OpenCV
        SwingUtilities.invokeLater(() -> new cameras().setVisible(true));
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
    
    @Override
    public void dispose() {
        isCameraRunning = false;           // Stop camera thread loop
        if (capture != null && capture.isOpened()) {
            capture.release();             // Release camera resource
        }
        super.dispose();                   // Dispose the JFrame
    }
}
