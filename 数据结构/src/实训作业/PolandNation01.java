package ʵѵ��ҵ;

import java.util.ArrayList;
import java.util.Stack;

public class PolandNation01 {
	public static void main(String[] args) {
		String exp="300+51*(2+6)-109";
		//1.����׺���ʽת���ɺ�׺���ʽ
		ArrayList<String > list = toSuffixExpress(exp);
		System.out.println("300+51*(2+6)-109 ת���ɺ�׺���ʽ:\n"+list);
		//2.����׺���ʽ��ֵ
		int r= calculate(list);
		System.out.println("��׺���ʽ��������"+r);
	}
	//2.����׺���ʽ��ֵ
	public static int calculate (ArrayList<String > list){
		Stack<String> s = new Stack<>();
		for(String item:list){
			if(item.matches("\\d+")){//�ж�item�Ƿ�Ϊ���ָ�ʽ
				s.push(item);
			}else{
				int x2 = Integer.parseInt(s.pop()) ;
				int x1 = Integer.parseInt(s.pop()) ;
				int res;
				switch(item){
				case "+": res=x1+x2;break;
				case "-": res=x1-x2;break;
				case "*": res=x1*x2;break;
				case "/": res=x1/x2;break;
				default:
					throw new RuntimeException("���������~~");
				}
				s.push(res+"");
			}
		}
		return Integer.parseInt( s.pop());
	}
	
	//1.����׺���ʽת���ɺ�׺���ʽ
	public static ArrayList<String> toSuffixExpress(String s){
		Stack<String> s1 = new Stack<>();
		ArrayList<String> s2= new ArrayList<>();
		char c;						//��������ӱ��ʽȡ����ÿ���ַ�
		boolean lastIsNumber =false;		//������ʽ��һ���ַ��Ƿ�Ϊ����
		for(int i=0;i<s.length();i++){
			c=s.charAt(i);
			if(c>='0' && c<='9'){	//�������
				if(lastIsNumber==true){
					String mergeStr=s2.get(s2.size()-1)+c;	//�����һ�������֣�����һ�����뵱ǰ�ַ�ƴ��
					s2.set(s2.size()-1, mergeStr);			//��ƴ����ַ�����s2�Ķ���
				}else{
					s2.add(c+"");
				}
				lastIsNumber=true;
			}else if(isOPer(c)){//����������
				if(s1.isEmpty() || s1.peek().equals("(")){
					s1.push(c+"");
				}else {
					while(!s1.isEmpty() && !s1.peek().equals("(") 
							&& operLevel(c+"")<= operLevel(s1.peek())){
							s2.add(s1.pop());
					}
					s1.push(c+"");
				}
				lastIsNumber=false;
			}else if(c=='('){
				s1.push(c+"");
				lastIsNumber=false;
			}else if(c==')'){
				while(!s1.isEmpty() && !s1.peek().equals("(")){
					s2.add(s1.pop());
				}
				if(s1.peek().equals("(")){//���ջ��Ϊ�����ţ��������Ŷ���
					s1.pop();
				}
				lastIsNumber=false;
			}
			
		}
		//��ʣ��������ѹ��s2
		while(!s1.isEmpty()){
			s2.add(s1.pop());
		}
		
		return s2;
		
	}
	//�ж��Ƿ�Ϊ�����
	public static boolean isOPer(char oper){
		if(oper=='+' ||oper=='-' ||oper=='*' ||oper=='/'){
			return true;
		}
		else
			return false;
	}
	//������������ȼ�
	public static int operLevel(String oper){
		if(oper.equals("+") ||oper.equals("-")){
			return 1;
		}
		else if(oper.equals("*") ||oper.equals("/")){
			return 2;
		}else{
			throw new RuntimeException("�����쳣");
		}
		
	}

}

