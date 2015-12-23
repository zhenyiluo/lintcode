class Solution1 {
    /*
     * param a: The first integer
     * param b: The second integer
     * return: The sum of a and b
     */
    public int aplusb(int a, int b) {
        // write your code here, try to do it without arithmetic operators.
        if(b == 0){
            return a;
        }
        
        int sum = a ^ b;
        int carry = (a & b) << 1;
        return aplusb(sum, carry);
    }
};