class Solution:
    """
    @param nums: The integer array you should partition
    @param k: As description
    @return: The index after partition
    """
    def partitionArray(self, nums, k):
        # write your code here
        # you should partition the nums by k
        # and return the partition index as description
        if len(nums) == 0:
            return 0
            
        start = 0
        end = len(nums) - 1
        while start <= end:
            while start <= end and nums[start] < k:
                start += 1
            while start <= end and nums[end] >= k:
                end -= 1
                
            if start <= end:
                tmp = nums[start]
                nums[start] = nums[end]
                nums[end] = tmp
                start += 1
                end -= 1
                
        return start
