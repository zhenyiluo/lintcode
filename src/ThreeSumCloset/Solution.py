class Solution:
    """
    @param numbers: Give an array numbers of n integer
    @param target : An integer
    @return : return the sum of the three integers, the sum closest target.
    """
    def threeSumClosest(self, numbers, target):
        # write your code here
        numbers.sort()
        res = 0
        min = 1 << 31
        for i in xrange(len(numbers)):
            j = i+1
            k = len(numbers) - 1
            while j < k:
                sum = numbers[i] + numbers[j] + numbers[k]
                diff = target - sum
                if(abs(diff) < min):
                    min = abs(diff)
                    res = sum
                if diff == 0:
                    return sum
                elif diff > 0:
                    j += 1
                else:
                    k -= 1
        return res