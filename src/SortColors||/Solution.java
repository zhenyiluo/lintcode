class Solution {
    /**
     * @param colors: A list of integer
     * @param k: An integer
     * @return: nothing
     */
    public void sortColors2(int[] colors, int k) {
        // write your code here
        if(colors == null || colors.length == 0 || k > colors.length){
            return;
        }
        
        int len = colors.length;
        int index = 0;
        for(int j = 1; j <= k; j++){
            for(int i = 0; i < len; i++){
                if(colors[i] == j){
                    swap(colors, index++, i);
                }
            }
        }
    }
    
    private void swap(int[] colors, int i , int j){
        int tmp = colors[i];
        colors[i] = colors[j];
        colors[j] = tmp;
    }
}
