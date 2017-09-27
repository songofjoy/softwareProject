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
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.util.Locale;
import java.util.ResourceBundle;

public class Frame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;

    JLabel lblNewLabel_1 = new JLabel("0");
	JLabel label_2 = new JLabel("0");
	JLabel label_3 = new JLabel("0.0%");
	
	static JLabel lblNewLabel = new JLabel("正确题目");
	static JLabel label = new JLabel("错误题目");
	static JLabel label_1 = new JLabel("正确率");
	static JButton button_20 = new JButton("重置");
	static JButton button_19 = new JButton("清除");
	static JButton button_18 = new JButton("退格");
	static JButton button_23 = new JButton("简");
	static JButton button_21 = new JButton("繁");
	static JButton button_22 = new JButton("英");
	
	static final String EN="resource_english";
	static final String CH="resource_zh_CN_1";
	static final String HARD="resource_hard";
	
	static Score curScore=new Score();
	DecimalFormat df= new DecimalFormat("######0.0");   
	
	/**
	 * 字体中英繁切换
	 * @param resource
	 */
	public static void changeCharacter(String resource){
		
		ResourceBundle rb = ResourceBundle.getBundle(resource);
		lblNewLabel.setText(rb.getString("rightAmount"));	
		label.setText(rb.getString("wrongAmount"));	
		label_1.setText(rb.getString("radioAmount"));	
		button_20.setText(rb.getString("reset"));	
		button_19.setText(rb.getString("clear"));	
		button_18.setText(rb.getString("back"));	
		button_23.setText(rb.getString("simply"));	
		button_21.setText(rb.getString("hard"));	
		button_22.setText(rb.getString("english"));

	}
	/**
	 * Launch the application.
	 * @throws IOException 
	 * @throws ParseException 
	 */
	public static void main(String[] args) throws Exception{
		
		curScore=Util.readScore();
		changeCharacter(CH);
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Frame frame = new Frame();
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
	public Frame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 540, 431);
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
		
		JButton button_16 = new JButton("'='");
		button_16.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText(textField.getText()+"=");
			}
		});
		button_16.setBounds(446, 220, 52, 48);
		contentPane.add(button_16);
		
		JButton button_17 = new JButton("=");
		button_17.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(textField.getText().contains("=")){
					String[] strings=textField.getText().split("=");
				  	DoubleStack testStack = new DoubleStack(strings[0]);  
				   	testStack.analysisString();  
					String right=testStack.compute();
					if(strings[1].equals(right)){
						textField.setText("Right!");
						curScore.setRightAmount(curScore.getRightAmount()+1);
						System.out.println(curScore.getRightAmount());
						System.out.println(curScore.getWrongAmount());
						System.out.println(curScore.getRadioAmount());
						curScore.setRadioAmount((double)curScore.getRightAmount()/(double)(curScore.getRightAmount()+curScore.getWrongAmount()));
						lblNewLabel_1.setText(String.valueOf(curScore.getRightAmount()));
						label_2.setText(String.valueOf(curScore.getWrongAmount()));
						label_3.setText(String.valueOf(df.format(curScore.getRadioAmount()*100))+"%");

						try {
							Util.saveScore(curScore);
						} catch (IOException | ParseException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
					else{
						textField.setText("Wrong!");
						curScore.setWrongAmount(curScore.getWrongAmount()+1);
						curScore.setRadioAmount((double)curScore.getRightAmount()/(double)(curScore.getRightAmount()+curScore.getWrongAmount()));
						lblNewLabel_1.setText(String.valueOf(curScore.getRightAmount()));
						label_2.setText(String.valueOf(curScore.getWrongAmount()));
						label_3.setText(String.valueOf(df.format(curScore.getRadioAmount()*100))+"%");

						try {
							Util.saveScore(curScore);
						} catch (IOException | ParseException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
				}else{
				   	DoubleStack testStack = new DoubleStack(textField.getText());  
				   	testStack.analysisString();  
			    	textField.setText(testStack.compute());
				}
			
			}
		});
		button_17.setBounds(422, 293, 76, 48);
		contentPane.add(button_17);
		
		lblNewLabel.setBounds(28, 293, 52, 15);
		contentPane.add(lblNewLabel);
		
		label.setBounds(28, 318, 52, 15);
		contentPane.add(label);
		
		label_1.setBounds(28, 343, 52, 15);
		contentPane.add(label_1);
		
		lblNewLabel_1.setBounds(86, 293, 54, 15);
		lblNewLabel_1.setText(String.valueOf(curScore.getRightAmount()));
		contentPane.add(lblNewLabel_1);
		
		label_2.setBounds(86, 318, 54, 15);
		label_2.setText(String.valueOf(curScore.getWrongAmount()));
		contentPane.add(label_2);
		
		label_3.setBounds(86, 343, 54, 15);
		label_3.setText(String.valueOf(df.format(curScore.getRadioAmount()*100))+"%");
		contentPane.add(label_3);
		
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
		
		button_19.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText("");
			}
		});
		button_19.setBounds(224, 293, 76, 48);
		contentPane.add(button_19);
		
		button_20.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				curScore=new Score();
				lblNewLabel_1.setText("0");
				label_2.setText("0");
				label_3.setText("0.0%");
				try {
					Util.saveScore(curScore);
				} catch (IOException | ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		button_20.setBounds(127, 293, 76, 48);
		contentPane.add(button_20);
		button_22.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				changeCharacter(EN);
			}
		});
		
		button_22.setBounds(446, 351, 52, 31);
		contentPane.add(button_22);
		button_21.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				changeCharacter(HARD);
			}
		});
		
		button_21.setBounds(384, 351, 52, 31);
		contentPane.add(button_21);
		button_23.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				changeCharacter(CH);
			}
		});
		
		button_23.setBounds(318, 351, 52, 31);
		contentPane.add(button_23);
	}
	
}
