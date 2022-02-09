import java.util.Scanner;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Calculator implements ActionListener{
	JFrame frame;
	JTextField textField;
	JButton[] numbers = new JButton[10];
	JButton[] functions = new JButton[9];
	JButton add, sub, mult, div;
	JButton decimal, equals, delete, clear, negative;
	JPanel panel;

	Font font = new Font("Courier", Font.ITALIC,35);

	double num1 = 0;
	double num2 = 0;
	double result = 0;
	char operator;

	public Calculator(){
		frame = new JFrame("Calculator");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(450, 550);
		frame.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(55, 30, 300, 55);
		textField.setFont(font);
		textField.setEditable(false);//not editable

		mult = new JButton("*");
		div = new JButton("/");
		sub = new JButton("-");
		add = new JButton("+");
		decimal = new JButton(".");
		equals = new JButton("=");
		delete = new JButton("Delete");
		clear = new JButton("Clear");
		negative = new JButton("(-)");

		functions[0] = mult;
		functions[1] = div;
		functions[2] = sub;
		functions[3] = add;
		functions[4] = decimal;
		functions[5] = equals;
		functions[6] = delete;
		functions[7] = clear;
		functions[8] = negative;
		
		for(JButton i : functions){
			i.addActionListener(this);
			i.setFont(font);
			i.setFocusable(false);//gets rid of outline around buttons
		}

		for(int i = 0; i< 10; i++){
			numbers[i] = new JButton(String.valueOf(i));
			numbers[i].addActionListener(this);
			numbers[i].setFont(font);
			numbers[i].setFocusable(false);
		}
		negative.setBounds(50, 430, 100, 50);
		delete.setBounds(150, 430, 165, 50);
		clear.setBounds(205, 430, 165, 50);
		
		panel = new JPanel();
		panel.setBounds(50, 100, 300, 300);
		panel.setLayout(new GridLayout(4,4,10,10));//4 by 4, and 10 pixels of space
		panel.setBackground(Color.ORANGE);

		panel.add(numbers[1]);
		panel.add(numbers[2]);
		panel.add(numbers[3]);
		panel.add(add);
		panel.add(numbers[4]);
		panel.add(numbers[5]);
		panel.add(numbers[6]);
		panel.add(sub);
		panel.add(numbers[7]);
		panel.add(numbers[8]);
		panel.add(numbers[9]);
		panel.add(mult);
		panel.add(decimal);
		panel.add(mult);
		panel.add(numbers[0]);
		panel.add(equals);
		panel.add(div);
		
		frame.add(panel);
		frame.add(delete);
		frame.add(clear);
		frame.add(textField);
		frame.setVisible(true);
		frame.add(negative);
	}

	public void actionPerformed(ActionEvent e){
		for(int i = 0; i < 10; i++){
			if(e.getSource() == numbers[i]){
				textField.setText(textField.getText().concat(String.valueOf(i)));
			}
		}	
		if(e.getSource() == decimal){
			textField.setText(textField.getText().concat(String.valueOf(".")));

		}
		if(e.getSource() == add){
			num1 = Double.parseDouble(textField.getText());
			operator = '+';
			textField.setText("");	
		}
		if(e.getSource() == sub){
			num1 = Double.parseDouble(textField.getText());
			operator = '-';
			textField.setText("");
		}
		if(e.getSource() == mult){
			num1 = Double.parseDouble(textField.getText());
			operator = '*';
			textField.setText("");
		}
		if(e.getSource() == div){
			num1 = Double.parseDouble(textField.getText());
			operator = '/';
			textField.setText("");
		}
		if(e.getSource() == equals){
			num2 = Double.parseDouble(textField.getText());

			switch(operator){
				case '+':
					result = num1 + num2;
					break;
				case '-':
					result = num1 - num2;
					break;
				case '*':
					result = num1 * num2;
					break;
				case '/':{
					if(num2 == 0){
						textField.setText("Domain Error");
						break;
					}
					result = num1 / num2;
					break;
				}
			}
			if(textField.getText().equals("Domain Error")){
				num1 = 0;
				num2 = 0;
				result = 0;
			}else{
				textField.setText(String.valueOf(result));
				num1 = result;
			}
		}
		if(e.getSource() == clear){
			num1 = 0;
			num2 = 0;
			result = 0;
			textField.setText("");
		}
		if(e.getSource() == delete){
			String str = textField.getText();
			String newStr = str.substring(0, str.length() -1);
			textField.setText(newStr);
		}
		if(e.getSource() == negative){
			double temp = Double.parseDouble(textField.getText());
			temp *= -1;
			textField.setText(String.valueOf(temp));
		}
	}

	public static void main(String[] args){
		Calculator calculator = new Calculator();

	}


}
