package PartI;

public class BalancedParentheses {

	public static boolean isBalanced(String inString) {
		MyStack<Character> stack = new MyStack<>();

		for (int i=0;i<inString.length();i++) {
			switch (inString.charAt(i)) {
				case '(':
					stack.push(inString.charAt(i));
					break;
				case ')':
					if(!stack.empty())
						stack.pop();
					else
						return false;
					break;
			}
		}
		if(stack.empty())
			return true;
		else
			return false;
	}
	
	public static void main(String[] args) {
		boolean result = isBalanced("(()()()())");
		System.out.println(result);
		result = isBalanced("(((())))");
		System.out.println(result);
		result = isBalanced("((((((())");
		System.out.println(result);
	}
}
