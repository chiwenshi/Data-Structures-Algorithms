import java.util.*;
public class candyCrush {
	/* 
	 * Description : Given a char array, finishing a elimination algorithm.
	 * Example 1 : [a, a, b, b, b, c] -> [a, a, c]
	 * Example 2 : [a, a, b, b, b, a, c] -> [c]
	 * 
	 * */
	public static void main(String[] args) {
		String[] tests = {"","aaa", "aaab", "aaaab", "baaa", "aabbbac"};
		for (String input : tests) {
			System.out.println(eliminate(input));
		}
		
	}
	
	/*
	 * Map.Entry<Character,Integer> cur = new AbstractMap.SimpleEntry<Character, Integer>(c, 1);
	 * */ 
	public static String eliminate(String str) {
		char[] input = str.toCharArray();
		Deque<Map.Entry<Character,Integer>> stack = new ArrayDeque<>();
		for (char c : input) {
			if (stack.isEmpty()) {
				Map.Entry<Character,Integer> cur = new AbstractMap.SimpleEntry<Character, Integer>(c, 1);
				stack.offerFirst(cur);
			} else {
				Map.Entry<Character,Integer> top = stack.peekFirst();
				// if the top one in stack is same as the current one
				if (c == top.getKey()) {
					stack.peekFirst().setValue(stack.peekFirst().getValue() + 1);
				} else {
					// see if the top one can be eliminated or not
					if (top.getValue() >= 2) {
						stack.pollFirst();
						if (stack.isEmpty()) {
							stack.offerFirst(new AbstractMap.SimpleEntry<Character, Integer>(c, 1));
						} else {
							Map.Entry<Character,Integer> curtop = stack.peekFirst();
							if (curtop.getKey() == c) {
								stack.peekFirst().setValue(stack.peekFirst().getValue() + 1);
							} else {
								stack.offerFirst(new AbstractMap.SimpleEntry<Character, Integer>(c, 1));
							}
						}
					} else {
						stack.offerFirst(new AbstractMap.SimpleEntry<Character, Integer>(c, 1));
					}
				}
			}
		}
		
		// now 再检查一下stack的栈顶有没有大于3次
		if (!stack.isEmpty()) {
			Map.Entry<Character, Integer> top = stack.peekFirst();
			if (top.getValue() >= 2) {
				stack.pollFirst();
			}
		}
		
		StringBuilder sb = new StringBuilder();
		
		while (!stack.isEmpty()) {
			Map.Entry<Character, Integer> curEntry = stack.pollFirst();
			while (curEntry.getValue() != 0) {
				sb.insert(0, curEntry.getKey());
				curEntry.setValue(curEntry.getValue() - 1);
			}
		}
		return sb.toString();
	}
	
}

//class MyEntry<K, V> implements Map.Entry<K, V> {
//	K key;
//	V value;
//	
//	public MyEntry(K key, V value) {
//		this.key = key;
//		this.value = value;
//	}
//	
//	@Override
//	public K getKey() {
//		return key;
//	}
//	
//	@Override
//	public V getValue() {
//		return value;
//	}
//	
//	@Override
//	public V setValue(V newValue) {
//		V old = this.value;
//		this.value = newValue;
//		return old;
//	}
//
//}
