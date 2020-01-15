
public class ProductSum {
	public static void main(String[] args) {
		System.out.println(productSum(234));
		System.out.println(productSum(123));
	}
	
	/*
	 * 一个数字，求所有digit的乘积减去所有digit的和
	 * clarification : positive num? negative num? 仔细看清题目要求
	 * */
	public static int productSum(int num) {
		int prod = 1;
		int sum = 0;
		while (num != 0) {
			int curDig = num % 10;
			num = num / 10;
			sum += curDig;
			prod *= curDig;
		}
		
		return prod - sum;
	}
}
