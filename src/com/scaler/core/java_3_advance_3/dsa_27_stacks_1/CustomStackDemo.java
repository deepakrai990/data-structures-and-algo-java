package com.scaler.core.java_3_advance_3.dsa_27_stacks_1;

import com.scaler.core.utils.PrintUtils;

/**
 * @created 30/09/23 8:14 pm
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class CustomStackDemo {
    public static void main(String[] args) {
        MyStack<String> stack = new MyStack<>();
        stack.push("Deepak");
        stack.push("Tinku");
        stack.push("Priya");

        System.out.println("Stack with Array size: " + stack.size());
        System.out.println("Stack with Array Peek: " + stack.peek());
        System.out.println("Stack with Array Pop: " + stack.pop());
        System.out.println("Stack with Array size after pop: " + stack.size());

        PrintUtils.printNewLine();

        MyNodeStack<String> stackWithNode = new MyNodeStack<>();
        stackWithNode.push("Priya");
        stackWithNode.push("Piu");
        stackWithNode.push("Deepak");

        System.out.println("Stack with node size: " + stackWithNode.size());
        System.out.println("Stack with node Peek: " + stackWithNode.peek());
        System.out.println("Stack with node Pop: " + stackWithNode.pop());
        System.out.println("Stack with node size after pop: " + stackWithNode.size());
    }
}
