class MyHashMap {
    
    Node[] array;
    
    /** Initialize your data structure here. */
    public MyHashMap() {
        array = new Node[10000];
    }
    
    /** value will always be non-negative. */
    public void put(int key, int value) {
        int i = getIndex(key);
        if (array[i] == null) {
            array[i] = new Node(-1, -1); // 这相当于一个dummy node，题目中给了all keys and values will be in the range of [0, 1000000]，所以我们这里声明成-1， -1 就不会担心和input有冲突了
        }
        
        Node prev = find(array[i], key);
        if (prev.next != null) {
            prev.next.val = value;
        } else {
            prev.next = new Node(key, value);
        }
    }
    
    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        int i = getIndex(key);
        if(array[i] == null) {
            return -1;
        }
        
        Node prev = find(array[i], key);
        
        return prev.next == null ? -1 : prev.next.val;
    }
    
    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        int i = getIndex(key);
        if (array[i] == null) {
            return;
        }
        
        Node prev = find(array[i], key);
        
        if(prev.next == null) {
            return;
        } else {
            prev.next = prev.next.next;
        }
    }
    
    // hash the key and map it to an index of the array
    public int getIndex(int key) {
        return Integer.hashCode(key) % (array.length);
    }
    
    // to find the previous node of the target node, if there is not a node's key == key, then previous will be the tail node of the list
    public Node find(Node head, int key) {
        Node prev = null;
        Node cur = head;
        
        while (cur != null && cur.key != key) {
            prev = cur;
            cur = cur.next;
        }
        
        return prev;
    }
    
    // Node class
    class Node {
        int key;
        int val;
        Node next;
        
        public Node(int key, int value) {
            this.key = key;
            this.val = value;
        }
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */