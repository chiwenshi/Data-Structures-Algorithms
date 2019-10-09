class Solution {
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        // BFS
        Queue<int[]> queue = new LinkedList<>();
        Map<Integer, Set<Integer>> visited = new HashMap<>();
        // Initialize
        add(start, queue, visited);
        
        // there is a better way to name the 2D array dir, that is name it as "dirs", and then in for loop, we can name as for(int[] dir : dirs), that will be more clear and can save us some names
        while(!queue.isEmpty()){
            int[] cur = queue.poll();
            int[][] dir = {{-1,0}, {1,0}, {0, -1}, {0, 1}};
            for(int[] offset: dir){
                int[] nextPos = helper(offset, cur, maze);
                if(nextPos[0] == destination[0] && nextPos[1] == destination[1]){
                    return true;
                }
                add(nextPos, queue, visited);
            }
        }
        return false;
        
    }
    
    // helper function to help me find when to stop
    public int[] helper(int[] offset, int[] cur, int[][] maze){
        int row = cur[0];
        int col = cur[1];
        
        while(true){
            int newRow = row + offset[0];
            int newCol = col + offset[1];
            if(newRow >= maze.length || newCol >= maze[0].length || newRow < 0 || newCol < 0 || maze[newRow][newCol] == 1){
                break;
            }
            row = newRow;
            col = newCol;
        }
        
        return new int[]{row, col};
    }
    
    // helper : to decide whether a space is visited, if not, add it to visited and also add it to queue
    public void add(int[] arr, Queue<int[]> q, Map<Integer, Set<Integer>> visited){
        int row = arr[0]; // which row the space in
        if(visited.get(arr[0]) == null){
            Set<Integer> set = new HashSet<>();
            set.add(arr[1]);
            q.offer(arr);
            visited.put(arr[0], set);
        }else if(!visited.get(arr[0]).contains(arr[1])){
            visited.get(arr[0]).add(arr[1]);
            q.offer(arr);
        }
    }
}