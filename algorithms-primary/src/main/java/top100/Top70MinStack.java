package top100;

import java.util.Stack;

public class Top70MinStack {
    public Top70MinStack() {

    }

    Stack<Integer> data = new Stack<>();
    Stack<Integer> min = new Stack<>();

    public void push(int val) {
        data.push(val);
        if (min.isEmpty()) {
            min.push(val);
        } else {
            min.push(Math.min(min.peek(), val));
        }
    }

    public void pop() {
        if (!data.isEmpty()) {
            data.pop();
        }
    }

    public int top() {
        if (!data.isEmpty()) {
            return data.peek();
        } else {
            return -1;
        }
    }

    public int getMin() {
        if (!min.isEmpty()) {
            return min.peek();
        } else {
            return -1;
        }
    }
}
