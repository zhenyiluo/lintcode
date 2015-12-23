class Solution {
    /*
     * param a: The first integer
     * param b: The second integer
     * return: The sum of a and b
     */
    public int aplusb(int a, int b) {
        // write your code here, try to do it without arithmetic operators.
        int carryOver = 0;
        int ret = 0;
        for(int i= 0; i < 32; i++){
            int x = (a >> i) & 1;
            int y = (b >> i) & 1;
            if((x | y | carryOver) == 0){
                continue;
            }else if((x & y & carryOver) == 1){
                ret |= 1 << i;
                carryOver = 1;
            }else if((x ^ y ^ carryOver) == 0){
                carryOver = 1;
            }else{
                ret |= 1 << i;
                carryOver = 0;
            }
        }
        return ret;
    }
};