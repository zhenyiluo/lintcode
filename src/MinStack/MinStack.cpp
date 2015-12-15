class MinStack {
public:
    stack<int> st, minst;
    
    MinStack() {
        // do initialization if necessary
    }

    void push(int number) {
        // write your code here
        st.push(number);
        if(minst.empty() || number <= minst.top()){
            minst.push(number);
        }
    }

    int pop() {
        // write your code here
        int tmp = st.top();
        st.pop();
        if(tmp == minst.top()){
            minst.pop();
        }
        return tmp;
    }

    int min() {
        // write your code here
        return minst.top();
    }
};
