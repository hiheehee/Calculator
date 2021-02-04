Eclipse의 플러그인 windowbuilder를 사용해 계산기를 만들었다.
계산기의 형태는 Google에 계산기를 검색했을 때 나오는 다음 그림을 참고했다.


내가 완성한 계산기의 모습은 다음과 같다.

* * *
계산기를 구현했을때 가장 중요하게 생각했던 점은 두 가지다.
1. 연산자의 우선순위 처리
2. 예외처리
* * *

우선순위
========
후위 표기법
-----------
연산자의 우선순위를 계산하기 위해서는 후위 표기법을 사용했다.
* 중위 표기법 : 연산자가 피연산자 사이에 위치한 표기법 A+B
* 후기 표기법 : 연산자가 피연산자 뒤에 위치한 표기법 AB+

후위 표기법을 구현하기 위해는 Stack을 사용했고 연산자 별로 우선순위를 지정했다.
우선순위가 높다는 것은 크다고 표시했다.

연산자 우선순위
---------------
% > X == / > + == - > 나머지
<pre>
<code>
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
 </pre>
</code>

사용한 변수는 다음과 같다.
<pre>
<code>
char operation[] = {'+', '-', 'X', '/', '(', ')', '%'};	
ArrayList<String> postfix = new ArrayList<>(); // 후위 표기법
Stack<Character> opStack = new Stack<>(); // 연산자 Stack
Stack<String> calStack = new Stack<>(); // 후위 표기법 계산을 위한 Stack
String num = ""; // 피연산자 저장
 </pre>
</code>

입력받은 결괏값 String에 다음과 같은 알고리즘을 적용한다.

1. 피연산자는 스택(opStack)에 넣지 않고 num에 저장하고 연산자가 나올 때 num에 저장된 피연산자를 ArrayList(postfix)에 저장한다.
2. "(" 이면 무조건 스택(opStack)에 push 한다.
3. ")"이면 스택(opStack)에서 "("가 나올 때까지 pop을 한 후 출력한다. 
4. 그밖에 연산자라면 
   4-1. 연산자는 스택(opStack)이 비었으면 push 한다. 
   4-2. 연산자는 스택(opStack)이 비어있지 않으면 스택(opStack)에 있는 연산자와의 우선순위를 비교해
          4-2-1. 스택에 있는 연산자의 우선순위가 같거나 크다면
                  스택(opStack)에 있는 연산자를 pop을 해 ArrayList(postfix)에 저장하고
                  현재 연산자는 스택(opStack)에 push한다.
          4-2-2. 만약 3번에서 우선순위가 현재 연산자가 더 크면 현재 연산자를 push한다.

7. 수식이 끝나면 마지막 num에 저장된 피연산자를 ArrayList(postfix)에 저장한다.
8. 수식이 끝나면 스택(opStack)이 빌 때까지 pop을 해서 ArrayList(postfix)에 저장한다. 

ArrayList에 저장된 후위 표기법을 계산해야 한다.
1. 우선 ArrayList(postfix)의 값을 스택(calStack)에 저장한다.
2. 스택(calStack)의 top값이 연산자라면 pop을 한 뒤 연산자에 맞는 계산을 수행한다.
3. 계산을 전부 마치면 스택(calStack)의 top값이 계산의 최종 결과가 된다.
4. 3의 결과를  "."으로 구분해 실수인지 정수인지 판단하고 결과를 return 한다.
* * *
예외처리
=======
1. AC 처리
<pre>
<code>
if(cur.equals("AC")) { //AllClear
	this.label.setText("0");
}
</pre>
</code>
2. 첫 입력이 0일 때
<pre>
<code>
else if(this.label.getText().equals("0") && (cur.equals("0") || cur.equals(")"))){
	this.label.setText("0");
}
</pre>
</code>
3. ")" 일 경우
첫 입력으로 주어진 경우 => 입력 안됨
바로 앞 글자가 "(" 또는 "%"를 제외한 연산자인 경우 => 입력 안됨
<pre>
<code> 
else if(cur.equals(")")){
	char preString = this.label.getText().charAt(this.label.getText().length()-1);
	if(preString == '(' || preString == '+' || preString == '-' || preString == 'X' || preString == '/') { 
		this.label.setText(this.label.getText());
	}else {
		this.label.setText(this.label.getText() + this.text);
	}
}
</pre>
</code>
4. 연산자일 경우
첫입력으로 주어진 경우 => "-"는 음수 처리, 나머지 연산자는 0 붙여 주기
연산자 중복으로 입력된 경우 => 이전 연산자 대신 새로 입력된 연산자 입력
// -로 시작하는 경우 예외 처리
<pre>
<code>
if(str.charAt(0) == '-') {
	str = "0" + str;
}
else if(cur.equals("+") || cur.equals("-") || cur.equals("X") || cur.equals("/") || cur.equals("%")){
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
}
</pre>
</code>
5. 올바른 괄호인지 체크
<pre>
<code>
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
//올바른 괄호가 아니면 Error 메시지 출력
if(!checkCorrectBracket(str)) { 
	return "Bracket Error";
}
</pre>
</code>
