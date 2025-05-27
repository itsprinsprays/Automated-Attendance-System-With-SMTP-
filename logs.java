package camera;
import main.mainpage;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.font.TextAttribute;
import java.util.Map;

public class logs extends JFrame {

    private JPanel contentPane;
    JButton btnNewButton = new JButton("Dashboards");

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                logs frame = new logs();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public logs() {
        setTitle("Cavite State University");
        setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Zelpha\\OneDrive\\Documents\\Prens\\Comprog\\Web Dev\\HTML\\Images\\cvsulogo.png"));
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 1139, 801);

        contentPane = new JPanel();
        contentPane.setBackground(Color.LIGHT_GRAY);
        contentPane.setLayout(null);
        setContentPane(contentPane);

        // 5 Navigation Buttons (Preserved Design)
        JButton btn1 = button("Logs", 0, 2, 227, 75);
        JButton btn2 = button("Register", 225, 2, 225, 75);
        btn2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
            cameras c = new cameras();
            c.setLocationRelativeTo(null);
            c.show();
            dispose();
			}
        });

        JButton btn3 = button("Attendance", 450, 2, 225, 75);
        btn3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
            mainpage c = new mainpage();
            c.show();
            c.setLocationRelativeTo(null);
            dispose();
			}
        });

        JButton btn4 = button("About", 675, 2, 225, 75);
        JButton btn5 = button("Maintenance", 900, 2, 225, 75);
        btn5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
            securityM m1 = new securityM();
            m1.show();
            m1.setLocationRelativeTo(null);
            dispose();
			}
        });
        
        JButton btnStudentInfo = new JButton("Student Info");
        btnStudentInfo.setFont(new Font("Tahoma", Font.BOLD, 20));
        btnStudentInfo.setBounds(650, 321, 224, 110);
        contentPane.add(btnStudentInfo);
        btnStudentInfo.addActionListener(e -> {
            info ds = new info();
            ds.setLocationRelativeTo(null);
            ds.show();
        });
        
        JLabel lblNewLabel = new JLabel("");
        lblNewLabel.setOpaque(true);
        lblNewLabel.setForeground(Color.BLACK);
        lblNewLabel.setBackground(Color.BLACK);
        lblNewLabel.setBounds(-11, 78, 1136, 1);
        contentPane.add(lblNewLabel);
        
        JLabel lblNewLabel_1_4_1 = new JLabel("LOGS");
        lblNewLabel_1_4_1.setForeground(Color.BLACK);
        lblNewLabel_1_4_1.setFont(new Font("Microsoft Himalaya", Font.BOLD, 66));
        lblNewLabel_1_4_1.setBackground(Color.BLACK);
        lblNewLabel_1_4_1.setBounds(472, 127, 142, 45);
        contentPane.add(lblNewLabel_1_4_1);

        contentPane.add(btn1);
        contentPane.add(btn2);
        contentPane.add(btn3);
        contentPane.add(btn4);
        contentPane.add(btn5);
        
        btnNewButton = new JButton("Dashboards");
        btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 20));
        btnNewButton.setBounds(121, 319, 224, 110);
        contentPane.add(btnNewButton);
        btnNewButton.addActionListener(e -> {
            dashboards ds = new dashboards();
            ds.setLocationRelativeTo(null);
            ds.show();
        });

        // Background image (Preserved)
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
        button.setBounds(x, y, width, height);
        button.setFont(new Font("Tahoma", Font.BOLD, 18));
        button.setForeground(Color.BLACK);
        button.setBackground(Color.WHITE);
        button.setFocusPainted(false);
        button.setBorderPainted(false);
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
