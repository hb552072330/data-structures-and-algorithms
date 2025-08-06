package top100;

import java.util.Stack;

public class Top73DailyTemperatures {
    public int[] dailyTemperatures(int[] temperatures) {
        if (temperatures == null) {
            return null;
        }
        int[] ans = new int[temperatures.length];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < temperatures.length; i++) {
            while (!stack.isEmpty() && temperatures[stack.peek()] < temperatures[i]) {
                Integer index = stack.pop();
                ans[index] = i - index;
            }
            stack.push(i);
        }
        while (!stack.isEmpty()) {
            Integer index = stack.pop();
            ans[index] = 0;
        }
        return ans;
    }

}
