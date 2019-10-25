package number_score;

public class number_score {
	public static void main(String[] args) {
	    int num = 765;
	    int result = 0;
	    int r1 = rule1(num);
	    int r2 = rule2(num);
	    int r3 = rule3(num);
	    int r4 = rule4(num);
	    int r5 = rule5(num);
	    result = r1 + r2 + r3 + r4 + r5;
	    System.out.println(result);
	}
		 
	 // Rule 1 : find '7'
	 public static int rule1(int num) {
		 char[] arr = Integer.toString(num).toCharArray();
		 int sum = 0; 
		 for (int i = 0; i < arr.length; i++) {
			 if (arr[i] == '7') {
				 sum += 5;
			 }
		 }
		 return sum;
	 }
		 
	 // Rule 2 : find consecutive 2s
	 public static int rule2(int num) {
		 char[] arr = Integer.toString(num).toCharArray();
		 int sum = 0; 
		  
		 // this means we just add 6 points for each 2 from the second two, 因为题目要求前面两个2加6分，后面每一个加6分，那么我们把这个转换一下，就相当于从第二个2开始，每一个2都加6分
		 for (int i = 0; i < arr.length; i++) {
		     if (i != 0 && arr[i] == '2' && arr[i - 1] == '2') {
		         sum += 6;
		     }
		 }
		 return sum;
	 }
		 
	 // Rule 3 : find consecutive numbers
	 public static int rule3(int num) {
		 char[] arr = Integer.toString(num).toCharArray();
		 int sum = 0; 
		 int curLength = 1;
	  
		 for (int i = 1; i < arr.length; i++) {
		     if (arr[i] - arr[i - 1] == - 1) {
		    	 curLength++;
		     }else {
		    	 sum += curLength * curLength;
		    	 curLength = 1; // remember to reset the curLength
		   }
		 }
		  
		 // this function， 这个function还是挺容易错的，要想清楚，应该是在每一个下一位的时候把之前的连续的长度的分数给加上，所以循环到最后一位，最后一部分长度没有加
		 sum += curLength * curLength;
		 return sum;
	}
		 
	 // Rule 4 : whether its multiple of 3
	 public static int rule4(int num) {
		 if (num % 3 == 0) {
		     return 4;
		 }
		 return 0;
	 }
		 
	 // Rule 5 : scan every digit to determine whether is even or not
	 public static int rule5(int num) {
		 char[] arr = Integer.toString(num).toCharArray();
		 int sum = 0;
		 for (int i = 0; i < arr.length; i++) {
			 if ((arr[i] - '0') % 2 == 0) {
				 sum += 3;
			 }
		 }
		 return sum;
	 }
}
