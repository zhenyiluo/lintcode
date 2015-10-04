public class Solution {
    /**
     * @param height: A list of integer
     * @return: The area of largest rectangle in the histogram
     */
    public int largestRectangleArea(int[] height) {
        // write your code here
        if(height == null || height.length == 0){
            return 0;
        }
        
        int ret = height[0];
        Stack<Integer> stack = new Stack<Integer>();
        stack.add(height[0]);
        for(int i = 1; i < height.length; i++){
            if(height[i] >= stack.peek()){
                stack.add(height[i]);
            }else{
                int count = 0;
                
                while(!stack.isEmpty() && stack.peek() > height[i]){
                    count ++;
                    ret = Math.max(ret, stack.pop() * count);
                }
                
                for(int j = 0; j < count + 1; j++){
                    stack.push(height[i]);
                }
            }
        }
        int cnt = 0;
        while(!stack.isEmpty()){
            cnt ++;
            ret= Math.max(ret, cnt * stack.pop());
        }
        return ret;
    }
}

