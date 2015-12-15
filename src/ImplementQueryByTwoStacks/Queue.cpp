class Queue {
public:
    stack<int> stack1;
    stack<int> stack2;

    Queue() {
        // do intialization if necessary
    }

    void push(int element) {
        // write your code here
        stack1.push(element);
    }
    
    int pop() {
        // write your code here
        adjust();
        int tmp = stack2.top();
        stack2.pop();
        return tmp;
    }

    int top() {
        // write your code here
        adjust();
        return stack2.top();
    }
    
    void adjust(){
        if(stack2.empty()){
            while(!stack1.empty()){
                stack2.push(stack1.top());
                stack1.pop();
            }
        }
    }
};
