class Solution {
public:    
    /**
     * @param numbers: Give an array numbers of n integer
     * @param target: An integer
     * @return: return the sum of the three integers, the sum closest target.
     */
    int threeSumClosest(vector<int> nums, int target) {
        // write your code here
        sort(nums.begin(), nums.end());
        int res = 0;
        int min = INT_MAX;
        int len = nums.size();
        for(int i = 0; i < len; i++){
            int j = i+1;
            int k = len-1;
            while(j < k){
                int sum = nums[i] + nums[j] + nums[k];
                int diff = target - sum;
                if(abs(diff) < min){
                    min = abs(diff);
                    res = sum;
                }
                
                if(diff == 0){
                    return sum;
                }else if (sum < target){
                    j++;
                }else{
                    k--;
                }
            }
        }
        return res;
    }
};
