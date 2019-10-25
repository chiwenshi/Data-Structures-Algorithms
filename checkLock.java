import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Set;

public class checkLock {
	
	public static void main(String[] args) {
		String[] sequences = {"ACQUIRE 364", "RELEASE 84", "ACQUIRE 84"};
		// note: 如果我把lock方法变成static，那么我就可以不用先instantiate an instance，然后再用这个对象调用这个方法了，就可以直接调用了
		checkLock obj = new checkLock();
		int result = obj.lock(sequences);
		System.out.println(result);
	}
	// function to check if there is any problem with the lock sequences
	public int lock(String[] sequences) {
		Set<String> set = new HashSet<>();
		Deque<String> stack = new ArrayDeque<>();
		
		for (int i = 0; i < sequences.length; i++) {
			String[] curState = sequences[i].split(" ", 2);
			String state = curState[0];
			String id = curState[1];
			
			if (state.equals("ACQUIRE")) {
				if (set.contains(id)) {
					return i + 1;
				}else {
					set.add(id);
					stack.offerFirst(id);
				}
			}else {
				if (!stack.isEmpty() && stack.peek().contentEquals(id)) {
					String popid = stack.pollFirst();
					set.remove(popid);
				}else {
					// note : 要注意这里为什么是return i + 1; 因为我们的index是从0开始，但是我们处理开锁的sequence是从第一步开始看的
					return i + 1; 
				}
			}
		}
		
		return stack.isEmpty() ? 0 : sequences.length + 1;
	}
}
