import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.Window.Type;
import javax.swing.JButton;
import javax.swing.UIManager;
import javax.swing.JRadioButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class TitleFrame extends JDialog {

	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public TitleFrame() {
		
		this.setUndecorated(true);
		this.setBackground(Color.BLUE);
		
		setType(Type.POPUP);
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 365, 253);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0x1e1e21));// This colour will be Green
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblTitle = new JLabel("PACMAN");
		lblTitle.setForeground(new Color(0xfff82e));
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setFont(new Font("Stencil", Font.BOLD, 48));
		lblTitle.setBounds(0, 32, 369, 125);
		contentPane.add(lblTitle);
		
		JLabel lblTitle1 = new JLabel("Pac-Man: the champion of the arcade");
		lblTitle1.setForeground(new Color(0xfff82e));
		lblTitle1.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle1.setFont(new Font("Stencil", Font.PLAIN, 16));
		lblTitle1.setBounds(0, 32, 369, 225);
		contentPane.add(lblTitle1);
		
		JLabel lblTitle11 = new JLabel("Eat or be eaten with Pac-Man.");
		lblTitle11.setForeground(new Color(0xfff82e));
		lblTitle11.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle11.setFont(new Font("Stencil", Font.PLAIN, 15));
		lblTitle11.setBounds(0, 32, 369, 270);
		contentPane.add(lblTitle11);
		
		JButton btnPlay = new JButton("PLAY");
		btnPlay.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				btnPlay_mouseClicked(e);
			}
		});
		
		// Button Appearance
		btnPlay.setBorder(null);
		btnPlay.setForeground(Color.DARK_GRAY);
		btnPlay.setOpaque(true);
		btnPlay.setBackground(new Color(211, 211, 211));
		btnPlay.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnPlay.setBounds(114, 185, 145, 41);
		contentPane.add(btnPlay);
	}
	
	protected void btnPlay_mouseClicked(MouseEvent e) {
		this.setVisible(false);
	}
}
