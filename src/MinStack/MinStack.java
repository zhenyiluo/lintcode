public class MinStack {
    Stack<Integer> st;
    Stack<Integer> minSt;
    
    public MinStack() {
        // do initialize if necessary
        st = new Stack<>();
        minSt = new Stack<>();
    }

    public void push(int number) {
        // write your code here
        st.push(number);
        if(minSt.isEmpty() || number <= minSt.peek()){
            minSt.push(number);
        }
    }

    public int pop() {
        // write your code here
        if(st.peek().equals(minSt.peek())){
            minSt.pop();
        }
        return st.pop();
    }

    public int min() {
        // write your code here
        return minSt.peek();
    }
}
