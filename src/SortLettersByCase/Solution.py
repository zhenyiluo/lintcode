class Solution:
    """
    @param chars: The letters array you should sort.
    """
    def sortLetters(self, chars):
        # write your code here
        if len(chars) == 0:
            return
        
        start = 0
        end = len(chars) -1
        while start < end:
            while start < end and not self.isUpperCase(chars[start]):
                start += 1
                
            while start < end and self.isUpperCase(chars[end]):
                end -= 1
                
            self.swap(chars, start, end)
            
    
    def isUpperCase(self, char):
        if char >= 'A' and char <= 'Z':
            return True
            
    def swap(self, chars, start, end):
        tmp = chars[start]
        chars[start] = chars[end]
        chars[end] = tmp
