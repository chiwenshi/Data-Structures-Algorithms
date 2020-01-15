
public class LongestEqualSubarray {
	/*
	 * 给一个array，由0和1组成，求0,1个数相同的Subarray的最大长度
	 * */
	
	public static int longestEqualSubarray(int[] a) {
		for (int i = 0; i < a.length; i++) {
			if (a[i] == 0) {
				a[i] = -1;
			}
		}
		
		int[] prefixSum = new int[a.length + 1];
		for (int i = 0; i < a.length; i++) {
			prefixSum[i + 1] = prefixSum[i] + a[i];
		}
		
		int result = 0;
		for (int i = 1; i <= a.length; i++) {
			for (int j = 0; j < i; j++) {
				if (prefixSum[i] == prefixSum[j]) {
					result = Math.max(result, i - j);
				}
			}
		}
		
		return result;
	}
}
