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

public class LoseFrame extends JDialog {

	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public LoseFrame(int attempts, String message) {

		this.setUndecorated(true);
		this.setBackground(Color.BLUE);
		// Jframe
		setType(Type.POPUP);
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 365, 253);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0xff9900));//yellow; I love hexadecimals
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
// this is for winFrame i have absolutely no idea why its there
//		JLabel lblTitle = new JLabel("Level Completed!");
//		lblTitle.setForeground(new Color(0x39fe39));
//		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
//		lblTitle.setFont(new Font("Stencil", Font.ITALIC, 24));
//		lblTitle.setBounds(0, 32, 369, 61);
//		contentPane.add(lblTitle);

		JLabel lblPickup = new JLabel(String.format("Level Failed :( !!!"));// message
		lblPickup.setHorizontalAlignment(SwingConstants.CENTER);
		lblPickup.setForeground(new Color(0xff1a1a)); // The text will be in read
		lblPickup.setFont(new Font("Stencil", Font.PLAIN, 42));
		lblPickup.setBounds(0, 87, 369, 61);
		contentPane.add(lblPickup);

		JButton btnPlay = new JButton(message);
		btnPlay.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				btnPlay_mouseClicked(e);
			}
		});
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
