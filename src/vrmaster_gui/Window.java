package vrmaster_gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.UIManager;

import vrmaster_database.Database;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;

public class Window {
	public JFrame frame;
	
	protected void initHeader(String headername, Dimension paddingSize, Database db) {
		frame = new JFrame();
		frame.getContentPane().setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		JPanel headerpanel = new JPanel();
		frame.getContentPane().add(headerpanel, BorderLayout.NORTH);
		
		JLabel title = new JLabel(headername);
		title.setFont(new Font("Tahoma", Font.PLAIN, 25));
		title.setHorizontalAlignment(SwingConstants.TRAILING);
		headerpanel.add(title);
		
		JButton btnGoBack = new JButton("Back");
		btnGoBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				new Homepage(db);
			}
		});
		
		JPanel padding = new JPanel();
		padding.setPreferredSize(paddingSize);
		headerpanel.add(padding);
		headerpanel.add(btnGoBack);
	}
	
	@SuppressWarnings("unused")
	private void initialize() {
		
	}
	
	protected void initFinal() {
		frame.setBounds(200, 200, 600, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
	
	protected JTextArea newTextBox(String text) {
		JTextArea textBox = new JTextArea(text);
		textBox.setWrapStyleWord(true);
		textBox.setLineWrap(true);
		textBox.setOpaque(false);
	    textBox.setEditable(false);
	    textBox.setFocusable(false);
	    textBox.setBackground(UIManager.getColor("Label.background"));
	    textBox.setFont(new Font("Tahoma", Font.PLAIN, 15));
	    textBox.setBorder(UIManager.getBorder("Label.border"));
		return textBox;
	}
}
