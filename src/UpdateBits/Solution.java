class Solution {
    /**
     *@param n, m: Two integer
     *@param i, j: Two bit positions
     *return: An integer
     */
    public int updateBits(int n, int m, int i, int j) {
        // write your code here
        // create mask xxx0000xxxx
        long rightMask = ~0 >> i;
        rightMask = ~(rightMask << i);
        long leftMask = ~0 >> (j+1);
        leftMask = leftMask << (j+1);
        long mask = leftMask | rightMask;
        n = (int) (n & mask);
        n = (int) (n | (m << i));
        return n;
    }
}

