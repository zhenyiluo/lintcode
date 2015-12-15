class Solution:
    # @return a list of lists of length 4, [[val1,val2,val3,val4]]
    def fourSum(self, num, target):
        num.sort()
        result = []
        for i in range(len(num)-3):
            if num[i] > target/4.0:
                break
            if i > 0 and num[i] == num[i-1]:
                continue
            target2 = target - num[i]
            for j in range(i+1, len(num)-2):
                if num[j] > target2/3.0:
                    break
                if j > i+1 and num[j] == num[j-1]:
                    continue
                k = j + 1
                l = len(num) - 1
                target3 = target2 - num[j]
                # we should use continue not break
                # because target3 changes as j changes
                if num[k] > target3/2.0:
                    continue
                if num[l] < target3/2.0:
                    continue
                while k < l:
                    sum_value = num[k] + num[l]
                    if sum_value == target3:
                        result.append([num[i], num[j], num[k], num[l]])
                        kk = num[k]
                        k += 1
                        while k<l and num[k] == kk:
                            k += 1

                        ll = num[l]
                        l -= 1
                        while k<l and num[l] == ll:
                            l -= 1
                    elif sum_value < target3:
                        k += 1
                    else:
                        l -= 1
        return result