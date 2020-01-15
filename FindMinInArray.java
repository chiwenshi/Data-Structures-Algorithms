
public class FindMinInArray {
	/*
	 * 给一个2D array, 其中array[i][j] = (i+1) * (j+1)
	 * 按照query，返回结果。query有三种，[0] 打印array中active的数中的最小值，[1,i] deactive i行，[2,j] deactive j列。
	 * 例如3行4列，query = [ [0], [1, 0], [0], [2, 1], [0]].
	 * 一开始都是active, 第一次[0]就返回 1* 1 = 1
 	 * [1, 0] deactivate row = 0, 第二次[0]返回 2*1 = 2
	 * [2, 1] deactivate column = 1, 最后一个[0] 返回 2*1 = 2
	 * */
}
