
public class SumOfString {
	/*
	 * 给两个字符串，每个char是一个digit，然后从后往前加起来，把结果放到一个字符串输出。 
	 * e.g. '99' + '99' = '1818'
	 * */
	
	public static void main(String[] args) {
		String s1 = "99";
		String s2 = "67";
		System.out.println(sumOfString(s1, s2));
	}
	
	public static String sumOfString(String s1, String s2) {
		// edge cases
		if (s1 == null || s1.length() == 0) {
			return s2;
		}
		
		if (s2 == null || s2.length() == 0) {
			return s1;
		}
		
		int idx1 = s1.length() - 1;
		int idx2 = s2.length() - 1;
		StringBuilder sb = new StringBuilder();
		
		while (idx1 >= 0 && idx2 >= 0) {
			char c1 = s1.charAt(idx1--);
			char c2 = s2.charAt(idx2--);
			int num1 = c1 - '0';
			int num2 = c2 - '0';
			int sum = num1 + num2;
			sb.insert(0, Integer.toString(sum));
		}
		
		while (idx1 >= 0) {
			sb.insert(0, s1.charAt(idx1--));
		}
		
		while (idx2 >= 0) {
			sb.insert(0, s2.charAt(idx2--));
		}
		
		return sb.toString();
	}
}
