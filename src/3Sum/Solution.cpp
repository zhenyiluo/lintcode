class Solution {
public:    
    /**
     * @param numbers : Give an array numbers of n integer
     * @return : Find all unique triplets in the array which gives the sum of zero.
     */
    vector<vector<int> > threeSum(vector<int> &nums) {
        // write your code here
        vector<vector<int>> res;
        
        if(nums.size() < 3){
            return res;
        }
        
        sort(nums.begin(), nums.end());
        
        for(int i = 0; i < nums.size() - 2; i++){
            if(i > 0 && nums[i] == nums[i-1]){
                continue;
            }
            int j = i + 1;
            int k = nums.size() - 1;
            while(j < k){
                if(j > i+1 && nums[j] == nums[j-1]){
                    j++;
                    continue;
                }
                int sum = nums[i] + nums[j] + nums[k];
                if(sum == 0){
                    vector<int> triple;
                    triple.push_back(nums[i]);
                    triple.push_back(nums[j]);
                    triple.push_back(nums[k]);
                    res.push_back(triple);
                    j++;
                    k--;
                }else if (sum < 0){
                    j++;
                }else{
                    k--;
                }
            }
        }
        
        return res;
    }
};
