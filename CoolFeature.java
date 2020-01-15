import java.util.List;
import java.util.Map;
import java.util.*;

public class CoolFeature {
	/*
	 * Input:
	 * a = [1, 2, 3]
	 * b = [3, 4]
	 * query = [[1, 5], [1, 1, 1], [1, 5]]
	 * Output: [2, 1]

     * Explain:
		Just ignore every first element in sub-array in the query.
		So we will get a new query like this query = [[5], [1, 1], [5]]
		Only record the result when meet the single number in new query array.
		And the rule of record is find the sum of the single number.
		The example above is 5 = 1 + 4 and 5 = 2 + 3, there are two result.
		So currently the output is [2]
		When we meet the array length is larger than 1, such as [1, 1]. That means we will replace the
		b[x] = y, x is the first element, y is second element. So in this example, the b will be modify like
		this b = [1, 4]
		And finally, we meet the [5] again. So we will find sum again. This time the result is 5 = 1 + 4.
		So currently the output is [2, 1]
		note: Don't have to modify the query array, just ignore the first element.
	 * 
	 * */
	
	public List<Integer> coolFeature(int[] a, int[] b, int[][] query) {
		Map<Integer, Integer> mapA = new HashMap<>();
		List<Integer> res = new ArrayList<>();
		
		for (int num : a) {
			mapA.put(num, mapA.getOrDefault(num, 0) + 1);
		}
		
		for (int[] q : query) {
			if (q.length == 3) {
				b[q[1] - 0] = q[2];
			} else {
				int sum = q[1];
				int count = 0;
				for (int i = 0; i < b.length; i++) {
					int target = sum - b[i];
					if (mapA.containsKey(target)) {
						count += mapA.get(target);
					}
				}
				res.add(count);
			}
		}
		
		return res;
	}
	
}
