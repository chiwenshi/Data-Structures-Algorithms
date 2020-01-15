
public class GoodTuples {
	public static void main(String[] args) {
		int[] test = new int[] {1, 1, 2, 1, 5, 3, 2, 3};
		int[] test1 = new int[] {2, 8, 7, 8, 9};
		System.out.println(goodTuples(test));
		System.out.println(goodTuples(test1));
	}
	
	public static int goodTuples(int[] arr) {
		if (arr.length <= 2) {
			return 0;
		}
		
		int prev1 = arr[1];
		int prev2 = arr[0];
		int result = 0;
		for (int i = 2; i < arr.length; i++) {
			if (arr[i] != prev1 && arr[i] != prev2 && prev1 != prev2) {
				prev2 = prev1;
				prev1 = arr[i];
				continue;
			} else {
				result++;
				prev2 = prev1;
				prev1 = arr[i];
			}
		}
		
		return result;
	}
}
