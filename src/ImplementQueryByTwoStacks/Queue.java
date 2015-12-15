public class Queue {
    private Stack<Integer> stack1;
    private Stack<Integer> stack2;

    public Queue() {
       // do initialization if necessary
       stack1 = new Stack<>();
       stack2 = new Stack<>();
    }
    
    public void push(int element) {
        // write your code here
        stack1.push(element);
    }

    public int pop() {
        // write your code here
        if(stack2.isEmpty()){
            putStack1ToStack2();
        }
        return stack2.pop();
    }

    public int top() {
        // write your code here
        if(stack2.isEmpty()){
            putStack1ToStack2();
        }
        return stack2.peek();
    }
    
    private void putStack1ToStack2(){
        while(!stack1.isEmpty()){
                stack2.push(stack1.pop());
        }
    }
}