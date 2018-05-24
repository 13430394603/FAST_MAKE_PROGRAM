package com.awt.util;
/**
 * <b>属性值接受表达式的输入</b>
 * <p>
 * 描述:<br>
 * @author 威 
 * <br>2018年5月24日 上午11:28:20 
 * @since 1.0
 */
public class Arithmetic {
	public static void main(String[] args){
		Arithmetic a = new Arithmetic();
		print(a.toValue(a.toPosifix("12*4")));
	}
	public Arithmetic(){
		
	}
	
	public static String toPosifixStr(String infix){
		if(infix.indexOf("+") != -1
				||infix.indexOf("-") != -1
				||infix.indexOf("*") != -1
				||infix.indexOf("/") != -1){
			return String.valueOf(toValue(toPosifix(infix)));
		}
		return infix;
	}
	
	public static StringBuilder toPosifix(String infix){
		Stack<String> stack = new NodeStackEX<String>();
		StringBuilder sb = new StringBuilder();
		int i = 0;
		while(i < infix.length()){
			char ch = infix.charAt(i);
			switch(ch){
				case '-' : case '+' :
					while(!stack.isEmpty() && !stack.peek().equals("("))
						sb.append(stack.pop());
					stack.push(ch+"");
					i++; break;
				case '*' : case '/' :
					if(!stack.isEmpty() 
						&& (stack.peek().equals("*") 
						|| stack.peek().equals("/")))
						sb.append(stack.pop());
					stack.push(ch+"");
					i++; break;
				case '(' :
					stack.push(ch+"");
					i++; break;
				case ')' :
					String out = stack.pop();
					while(out != null && !out.equals("(")){
						sb.append(out);
						out = stack.pop();
					}
					i++; break;
				default :
					while(i < infix.length()
					&& ch >= '0' 
					&& ch <= '9'){
						sb.append(ch);
						if(i == infix.length() - 1){
							i++;
							break;
						}
						if(i < infix.length()-1)
							ch = infix.charAt(++i);
					}
					sb.append(" ");
			}
		}
		while(!stack.isEmpty())
			sb.append(stack.pop());
		return sb;
	}
	public static int toValue(StringBuilder sb){
		Stack<Integer> sta = new ArrayStackEX<Integer>(20);
		int i = 0;
		int value = 0;
		while(i < sb.length()){
			char ch = sb.charAt(i);
			if(ch >= '0' && ch <= '9'){
				value = 0;
				while(ch != ' '){
					value = value*10 + ch - '0';
					ch = sb.charAt(++i);
				}
				sta.push(value);
			}else{
				if(ch != ' '){
					int n = sta.pop(), m = sta.pop();
					switch(ch){
						case '+' : value = m+n; break;
						case '-' : value = m-n; break;
						case '*' : value = m*n; break;
						case '/' : value = m/n; break;
					}
					sta.push(value);
					print("运算:"+m + ch + n + "=" + value);
				}
			}
			i++;
		}
		return sta.pop();
	}
	public static void print(Object object){
		System.out.println(object);
	}
}
