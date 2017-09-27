package calculator;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Main extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main frame = new Main();
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
	public Main() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 540, 411);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(10, 10, 502, 30);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("1");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText(textField.getText()+"1");
			}
		});
		btnNewButton.setBounds(28, 68, 52, 48);
		contentPane.add(btnNewButton);
		
		JButton button = new JButton("2");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText(textField.getText()+"2");
			}
		});
		button.setBounds(113, 68, 52, 48);
		contentPane.add(button);
		
		JButton button_1 = new JButton("3");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText(textField.getText()+"3");
			}
		});
		button_1.setBounds(195, 68, 52, 48);
		contentPane.add(button_1);
		
		JButton button_2 = new JButton("4");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText(textField.getText()+"4");
			}
		});
		button_2.setBounds(28, 145, 52, 48);
		contentPane.add(button_2);
		
		JButton button_3 = new JButton("5");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText(textField.getText()+"5");
			}
		});
		button_3.setBounds(113, 145, 52, 48);
		contentPane.add(button_3);
		
		JButton button_4 = new JButton("6");
		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText(textField.getText()+"6");
			}
		});
		button_4.setBounds(195, 145, 52, 48);
		contentPane.add(button_4);
		
		JButton button_5 = new JButton("7");
		button_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText(textField.getText()+"7");
			}
		});
		button_5.setBounds(28, 220, 52, 48);
		contentPane.add(button_5);
		
		JButton button_6 = new JButton("8");
		button_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText(textField.getText()+"8");
			}
		});
		button_6.setBounds(113, 220, 52, 48);
		contentPane.add(button_6);
		
		JButton button_7 = new JButton("9");
		button_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText(textField.getText()+"9");
			}
		});
		button_7.setBounds(195, 220, 52, 48);
		contentPane.add(button_7);
		
		JButton button_8 = new JButton("0");
		button_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText(textField.getText()+"0");
			}
		});
		button_8.setBounds(283, 68, 52, 48);
		contentPane.add(button_8);
		
		JButton button_9 = new JButton("+");
		button_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText(textField.getText()+"+");
			}
		});
		button_9.setBounds(370, 68, 52, 48);
		contentPane.add(button_9);
		
		JButton button_10 = new JButton("(");
		button_10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText(textField.getText()+"(");
			}
		});
		button_10.setBounds(283, 145, 52, 48);
		contentPane.add(button_10);
		
		JButton button_11 = new JButton("×");
		button_11.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText(textField.getText()+"×");
			}
		});
		button_11.setBounds(370, 145, 52, 48);
		contentPane.add(button_11);
		
		JButton button_12 = new JButton(")");
		button_12.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText(textField.getText()+")");
			}
		});
		button_12.setBounds(283, 220, 52, 48);
		contentPane.add(button_12);
		
		JButton button_13 = new JButton("/");
		button_13.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText(textField.getText()+"/");
			}
		});
		button_13.setBounds(370, 220, 52, 48);
		contentPane.add(button_13);
		
		JButton button_14 = new JButton("-");
		button_14.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText(textField.getText()+"-");
			}
		});
		button_14.setBounds(446, 68, 52, 48);
		contentPane.add(button_14);
		
		JButton button_15 = new JButton("÷");
		button_15.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText(textField.getText()+"÷");
			}
		});
		button_15.setBounds(446, 145, 52, 48);
		contentPane.add(button_15);
		
		JButton button_16 = new JButton("?");
		button_16.setBounds(446, 220, 52, 48);
		contentPane.add(button_16);
		
		JButton button_17 = new JButton("=");
		button_17.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			   	DoubleStack testStack = new DoubleStack(textField.getText());  
			   	testStack.analysisString();  
			   	testStack.printCreString();
		    	textField.setText(testStack.compute());
			}
		});
		button_17.setBounds(422, 293, 76, 48);
		contentPane.add(button_17);
		
		JLabel lblNewLabel = new JLabel("正确题目");
		lblNewLabel.setBounds(28, 293, 52, 15);
		contentPane.add(lblNewLabel);
		
		JLabel label = new JLabel("错误题目");
		label.setBounds(28, 318, 52, 15);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("正确率");
		label_1.setBounds(28, 343, 52, 15);
		contentPane.add(label_1);
		
		JLabel lblNewLabel_1 = new JLabel("0");
		lblNewLabel_1.setBounds(86, 293, 54, 15);
		contentPane.add(lblNewLabel_1);
		
		JLabel label_2 = new JLabel("0");
		label_2.setBounds(86, 318, 54, 15);
		contentPane.add(label_2);
		
		JLabel label_3 = new JLabel("0");
		label_3.setBounds(86, 343, 54, 15);
		contentPane.add(label_3);
		
		JButton button_18 = new JButton("退格");
		button_18.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int length=textField.getText().length();
				if(length>0){
					textField.setText(textField.getText().substring(0,length-1));
				}
			}
		});
		button_18.setBounds(322, 293, 76, 48);
		contentPane.add(button_18);
		
		JButton button_19 = new JButton("清除");
		button_19.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText("");
			}
		});
		button_19.setBounds(224, 293, 76, 48);
		contentPane.add(button_19);
		
		JButton button_20 = new JButton("重置");
		button_20.setBounds(127, 293, 76, 48);
		contentPane.add(button_20);
	}
}
