class Solution:
    """
    @param numbersbers : Give an array numbersbers of n integer
    @return : Find all unique triplets in the array which gives the sum of zero.
    """
    def threeSum(self, numbers):
        # write your code here
        res = []
        numbers.sort()
        
        if len(numbers) < 3:
            return res
        
        for i in range(len(numbers)-2):
            if i > 0 and numbers[i] == numbers[i-1]:
                continue
            j = i + 1
            k = len(numbers) - 1
            while j < k:
                sum = numbers[i] + numbers[j] + numbers[k]
                if sum == 0 and [numbers[i], numbers[j], numbers[k]] not in res:
                    res.append([numbers[i], numbers[j], numbers[k]])
                    j += 1
                    k -= 1
                elif sum < 0:
                    j += 1
                else:
                    k -= 1
        
        return res