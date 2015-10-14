class Solution {
    /*
     * @param a, b, n: 32bit integers
     * @return: An integer
     */
    public int fastPower(int a, int b, int n) {
        // write your code here
        if(n == 1){
            return a % b;
        }
        
        if(n == 0){
            return 1 % b;
        }
        
        long prod = fastPower(a, b, n /2);
        prod = (prod * prod) % b;
        if(n % 2 == 1){
            prod = (prod * a) % b;
        }
        return (int)prod;
    }
};
