class MinStack(object):

    def __init__(self):
        # do some intialize if necessary
        self.stack = []
        self.minStack = []

    def push(self, number):
        # write yout code here
        self.stack.append(number)
        if len(self.minStack) == 0 or number <= self.minStack[-1]:
            self.minStack.append(number)

    def pop(self):
        # pop and return the top item in stack
        if self.stack[-1] == self.minStack[-1]:
            self.minStack.pop()
        return self.stack.pop()

    def min(self):
        # return the minimum number in stack
        return self.minStack[-1]