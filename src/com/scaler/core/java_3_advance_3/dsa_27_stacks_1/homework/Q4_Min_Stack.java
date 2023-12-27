package com.scaler.core.java_3_advance_3.dsa_27_stacks_1.homework;

import java.util.Stack;

/**
 * @created 02/04/23 6:39 pm
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class Q4_Min_Stack {
    class Pair {
        int ele;
        int minEle;

        Pair(int ele, int minEle) {
            this.ele = ele;
            this.minEle = minEle;
        }
    }

    Stack<Pair> st = new Stack<>();

    public void push(int x) {
        if (st.empty()) st.push(new Pair(x, x));
        else {
            int newMin = Math.min(x, st.peek().minEle);
            st.push(new Pair(x, newMin));
        }
    }

    public void pop() {
        if (st.empty()) return;
        st.pop();
    }

    public int top() {
        if (!st.empty()) return st.peek().ele;
        return -1;
    }

    public int getMin() {
        if (!st.empty()) return st.peek().minEle;
        return -1;

    }
}
