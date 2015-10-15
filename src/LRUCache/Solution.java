public class Solution {

    int capacity;
    // @param capacity, an integer
    public Solution(int capacity) {
        // write your code here
        this.capacity = capacity;
    }
    
    private LinkedHashMap<Integer, Integer> cache = new LinkedHashMap<Integer, Integer>(10, 0.75f, true){
        @Override
        public boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest){
            return size() > capacity;
        }
    };

    // @return an integer
    public int get(int key) {
        // write your code here
        if(cache.containsKey(key)){
            return cache.get(key);
        }else{
            return -1;
        }
    }

    // @param key, an integer
    // @param value, an integer
    // @return nothing
    public void set(int key, int value) {
        // write your code here
        cache.put(key, value);
    }
}
