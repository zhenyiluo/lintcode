class Solution {
    /**
     * @return: The same instance of this class every time
     */
    static Solution instance = null;
    public static Solution getInstance() {
        // write your code here
        if(instance == null){
            instance = new Solution();
        }
        
        return instance;
    }
};
