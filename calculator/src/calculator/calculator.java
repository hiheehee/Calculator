package calculator;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Stack;
import java.awt.event.ActionEvent;

public class calculator {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					calculator window = new calculator();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public calculator() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel answer = new JLabel("0");
		answer.setHorizontalAlignment(SwingConstants.RIGHT);
		answer.setFont(new Font("굴림", Font.BOLD, 30));
		answer.setBounds(12, 10, 395, 69);
		frame.getContentPane().add(answer);
		
		JButton btnLeft = new JButton("(");
		btnLeft.addActionListener(new ButtonActListener(answer, "("));
		btnLeft.setBounds(10, 89, 90, 75);
		btnLeft.setFont(new Font("굴림", Font.BOLD, 30));
		frame.getContentPane().add(btnLeft);
		
		JButton btn7 = new JButton("7");
		btn7.addActionListener(new ButtonActListener(answer, "7"));
		btn7.setBounds(10, 174, 90, 75);
		btn7.setFont(new Font("굴림", Font.BOLD, 30));
		frame.getContentPane().add(btn7);
		
		JButton btn4 = new JButton("4");
		btn4.addActionListener(new ButtonActListener(answer, "4"));
		btn4.setFont(new Font("굴림", Font.BOLD, 30));
		btn4.setBounds(10, 259, 90, 75);
		frame.getContentPane().add(btn4);
		
		JButton btn1 = new JButton("1");
		btn1.addActionListener(new ButtonActListener(answer, "1"));
		btn1.setFont(new Font("굴림", Font.BOLD, 30));
		btn1.setBounds(10, 344, 90, 75);
		frame.getContentPane().add(btn1);
		
		JButton btn0 = new JButton("0");
		btn0.addActionListener(new ButtonActListener(answer, "0"));
		btn0.setFont(new Font("굴림", Font.BOLD, 30));
		btn0.setBounds(10, 429, 90, 75);
		frame.getContentPane().add(btn0);
		
		JButton btnRight = new JButton(")");
		btnRight.addActionListener(new ButtonActListener(answer, ")"));
		btnRight.setBounds(112, 89, 90, 75);
		btnRight.setFont(new Font("굴림", Font.BOLD, 30));
		frame.getContentPane().add(btnRight);
		
		JButton btn8 = new JButton("8");
		btn8.addActionListener(new ButtonActListener(answer, "8"));
		btn8.setFont(new Font("굴림", Font.BOLD, 30));
		btn8.setBounds(112, 174, 90, 75);
		frame.getContentPane().add(btn8);
		
		JButton btn5 = new JButton("5");
		btn5.addActionListener(new ButtonActListener(answer, "5"));
		btn5.setFont(new Font("굴림", Font.BOLD, 30));
		btn5.setBounds(112, 259, 90, 75);
		frame.getContentPane().add(btn5);
		
		JButton btn2 = new JButton("2");
		btn2.addActionListener(new ButtonActListener(answer, "2"));
		btn2.setFont(new Font("굴림", Font.BOLD, 30));
		btn2.setBounds(112, 344, 90, 75);
		frame.getContentPane().add(btn2);
		
		JButton btnDot = new JButton(".");
		btnDot.addActionListener(new ButtonActListener(answer, "."));
		btnDot.setFont(new Font("굴림", Font.BOLD, 30));
		btnDot.setBounds(112, 429, 90, 75);
		frame.getContentPane().add(btnDot);
		
		JButton btnPer = new JButton("%");
		btnPer.addActionListener(new ButtonActListener(answer, "%"));
		btnPer.setBounds(214, 89, 90, 75);
		btnPer.setFont(new Font("굴림", Font.BOLD, 30));
		frame.getContentPane().add(btnPer);
		
		JButton btn9 = new JButton("9");
		btn9.addActionListener(new ButtonActListener(answer, "9"));
		btn9.setFont(new Font("굴림", Font.BOLD, 30));
		btn9.setBounds(214, 174, 90, 75);
		frame.getContentPane().add(btn9);
		
		JButton btn6 = new JButton("6");
		btn6.addActionListener(new ButtonActListener(answer, "6"));
		btn6.setFont(new Font("굴림", Font.BOLD, 30));
		btn6.setBounds(214, 259, 90, 75);
		frame.getContentPane().add(btn6);
		
		JButton btn3 = new JButton("3");
		btn3.addActionListener(new ButtonActListener(answer, "3"));
		btn3.setFont(new Font("굴림", Font.BOLD, 30));
		btn3.setBounds(214, 344, 90, 75);
		frame.getContentPane().add(btn3);
		
		JButton btnEqual = new JButton("=");
		btnEqual.addActionListener(new ButtonActListener(answer, "="));
		btnEqual.setFont(new Font("굴림", Font.BOLD, 30));
		btnEqual.setBounds(214, 429, 90, 75);
		frame.getContentPane().add(btnEqual);
		
		JButton btnAllClear = new JButton("AC");
		btnAllClear.addActionListener(new ButtonActListener(answer, "AC"));
		btnAllClear.setBounds(317, 89, 90, 75);
		btnAllClear.setFont(new Font("굴림", Font.BOLD, 30));
		frame.getContentPane().add(btnAllClear);
		
		JButton btnPlus = new JButton("+");
		btnPlus.addActionListener(new ButtonActListener(answer, "+"));
		btnPlus.setFont(new Font("굴림", Font.BOLD, 30));
		btnPlus.setBounds(316, 174, 90, 75);
		frame.getContentPane().add(btnPlus);
		
		JButton btnSub = new JButton("-");
		btnSub.addActionListener(new ButtonActListener(answer, "-"));
		btnSub.setFont(new Font("굴림", Font.BOLD, 30));
		btnSub.setBounds(316, 259, 90, 75);
		frame.getContentPane().add(btnSub);
		
		JButton btnMul = new JButton("X");
		btnMul.addActionListener(new ButtonActListener(answer, "X"));
		btnMul.setFont(new Font("굴림", Font.BOLD, 30));
		btnMul.setBounds(317, 344, 90, 75);
		frame.getContentPane().add(btnMul);
		
		JButton btnDiv = new JButton("/");
		btnDiv.addActionListener(new ButtonActListener(answer, "/"));
		btnDiv.setFont(new Font("굴림", Font.BOLD, 30));
		btnDiv.setBounds(316, 429, 90, 75);
		frame.getContentPane().add(btnDiv);
		
	}
	
	class ButtonActListener implements ActionListener{
		private JLabel label;
		private String text;
		
		public ButtonActListener(JLabel label, String text) {
			this.label = label;
			this.text = text;
		}
		
		@Override
		public void actionPerformed(ActionEvent e) {
			String cur = e.getActionCommand();
			
			if(cur.equals("AC")) { //AllClear
				this.label.setText("0");
			}else if(this.label.getText().equals("0") && (cur.equals("0") || cur.equals(")"))){
				this.label.setText("0");
			}else if(cur.equals("=")){
				this.label.setText(getCalculate(this.label.getText()));
			}else if(cur.equals("+") || cur.equals("-") || cur.equals("X") || cur.equals("/") || cur.equals("%")){
				char preString = this.label.getText().charAt(this.label.getText().length()-1);
				
				if(this.label.getText().equals("0")) { // 아무 숫자도 입력되지 않았을 경우
					if(cur.equals("-")) {
						this.label.setText(this.text);
					}else {
						this.label.setText(this.label.getText() + this.text);
					}
				}else {
					if(cur.equals("%")) {
						if(preString == '+' || preString == '-' || preString == 'X' || preString == '/') { // 앞문자가 숫자가 아니라면
							this.label.setText(this.label.getText().subSequence(0, this.label.getText().length()-1) + this.text);
						}else {
							this.label.setText(this.label.getText() + this.text);
						}
					}else { // '+', '-', 'X', '/' 연산자 인 경우
						if(preString == '+' || preString == '-' || preString == 'X' || preString == '/'){
							this.label.setText(this.label.getText().subSequence(0, this.label.getText().length()-1) + this.text);
						}else {
							this.label.setText(this.label.getText() + this.text);
						}
					}
				}
			}else {
				if(this.label.getText().equals("0")) { 
					this.label.setText(this.text);
				}else {
					this.label.setText(this.label.getText() + this.text);
				}
			}
		}
		
	}
	
	// 올바른 괄호인지 판단
	static boolean checkCorrectBracket(String str) {
		Stack<Character> check = new Stack<>();
		
		for(int i = 0; i < str.length(); i++) {
			if(str.charAt(i) == '(') {
				check.push('(');
			}else if(str.charAt(i) == ')') {
				if(!check.isEmpty()) {
					check.pop();
				}else {
					return false;
				}
			}
		}
		
		if(check.isEmpty()) {
			return true;
		}else {
			return false;
		}
	}
	
	// 결과 구하기
	static String getCalculate(String str) {
		char operation[] = {'+', '-', 'X', '/', '(', ')', '%'};
		
		ArrayList<String> postfix = new ArrayList<>();
		Stack<Character> opStack = new Stack<>();
		Stack<String> calStack = new Stack<>();
		String num = "";
		
		// -로 시작하는 경우 예외 처리
		if(str.charAt(0) == '-') {
			str = "0" + str;
		}
		
		//올바른 괄호가 아니면 Error 메시지 출력
		if(!checkCorrectBracket(str)) { 
			return "Bracket Error";
		}
		
		// 후위 연산자로 변경
		for(int i = 0; i < str.length(); i++) {
			boolean checkOp = false;
			for(int j = 0; j < operation.length; j++) {
				if(str.charAt(i) == operation[j]) {
					
					checkOp = true;
					
					if(!num.equals("")) {
						postfix.add(num);
						num = "";
					}
					
					if(operation[j] == '(') { // '(' 이면 무조건 push
						opStack.push(operation[j]);
					}else if(operation[j] == ')') { 
						// '(' 나오기 전까지 
						while(opStack.peek() != '(' && !opStack.isEmpty()) {
							postfix.add(opStack.pop().toString());
						}
						// '(' pop
						opStack.pop();
					}else {
						if(opStack.isEmpty()) {
							opStack.push(operation[j]);
						}else {
							if(opOrder(opStack.peek()) < opOrder(operation[j])) {
								opStack.push(operation[j]);
							}else {
								postfix.add(opStack.pop().toString());
								opStack.push(operation[j]);
							}
						}
					}
				}
			}
			
			if(!checkOp) {
				num += str.charAt(i);
			}
			
		}
		
		// 남은 숫자 처리
		if(!num.equals("")) {
			postfix.add(num);
		}
		
		// 남은 연산자 처리
		while(!opStack.isEmpty()) {
			postfix.add(opStack.pop().toString());
		}
		
		System.out.println(postfix);
		
		// 후위 연산자를 이용해 최종 결과 구하기
		for(int i = 0; i < postfix.size(); i++) {
			calStack.push(postfix.get(i));
			for(int j = 0; j < operation.length; j++) {
				if(postfix.get(i).charAt(0) == operation[j]) {
					calStack.pop();
					Double n2 = Double.parseDouble(calStack.pop());
					String re = "";
					
					if(operation[j] == '%') {
						re = Double.toString(n2 * 0.01);
					}else {
						Double n1 = Double.parseDouble(calStack.pop());
						if(operation[j] == '+') {
							re = Double.toString(n1 + n2);
						}else if(operation[j] == '-') {
							re = Double.toString(n1 - n2);
						}else if(operation[j] == 'X') {
							re = Double.toString(n1 * n2);
						}else if(operation[j] == '/') {
							re = Double.toString(n1 / n2);
						}
					}
			
					calStack.push(re);
				}
			}
		}
		
		Double result = Double.parseDouble(calStack.pop());
		String calResult[] = Double.toString(result).split("\\.");
		System.out.println(result + " "+ calResult[0]+ " "+ Double.parseDouble(calResult[1])*10000);
		
		if(Double.parseDouble(calResult[1]) == 0) {  
			if(3 <= calResult[1].length() && calResult[1].substring(0, 2).equals("0E")) {
				return Double.toString(result);
			}else { // 정수 일때, 
				return calResult[0];
			}
		}else { //실수일때
			return String.format("%.10f", result);
		}
	}
	
	//연산자 우선순위
	// % > X == / > + == - > 나머지
	static int opOrder(char op) {
		switch(op) {
			case '+':
			case '-':
				return 1;
			case 'X':
			case '/':
				return 2;
			case '%':
				return 3;
			default:
				return -1;
		}
	}
}
