class Solution:
    # @param pages: a list of integers
    # @param k: an integer
    # @return: an integer
    def copyBooks(self, pages, k):
        # write your code here
        if k >= len(pages):
            return max(pages)
            
        sum = 0;
        for page in pages:
            sum += page
            
        lowerBound = sum / k
        upperBound = sum
        
        return self.binarySearch(pages, k, lowerBound, upperBound)
        
        
    def binarySearch(self, pages, k, left, right):
        while left <= right:
            mid = left + ((right - left) >> 1)
            if self.isValid(mid, pages, k):
                right = mid - 1
            else:
                left = mid + 1
        
        return left
        
    def isValid(self, minute, pages, k):
        cnt = 1
        tmp = minute
        for page in pages:
            if page > minute:
                return False
            
            if page > tmp:
                cnt += 1
                tmp = minute - page
            else:
                tmp -= page
        
        return cnt <= k
            