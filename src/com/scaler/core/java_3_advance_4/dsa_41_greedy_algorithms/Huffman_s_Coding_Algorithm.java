package com.scaler.core.java_3_advance_4.dsa_41_greedy_algorithms;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author Deepak Kumar Rai
 * @created 29/11/23
 * @project scaler_course_code
 */
public class Huffman_s_Coding_Algorithm {
    static class HuffmanNode {
        int data;
        char c;
        HuffmanNode left, right;

        public HuffmanNode(int data, char c) {
            this.data = data;
            this.c = c;
            this.left = this.right = null;
        }
    }
    static class MyComparator implements Comparator<HuffmanNode> {
        public int compare(HuffmanNode x, HuffmanNode y) {
            return x.data - y.data;
        }
    }
    public static void printCodes(HuffmanNode root, String s) {
        if (root.left == null && root.right == null && Character.isLetter(root.c)) {
            System.out.println(root.c + ":" + s);
            return;
        }
        printCodes(root.left, s + "0");
        printCodes(root.right, s + "1");
    }

    public static void main(String[] args) {
        int n = 6;
        char[] charArray = {'a', 'b', 'c', 'd', 'e', 'f'};
        int[] charFreq = {5, 9, 12, 13, 16, 45};

        PriorityQueue<HuffmanNode> priorityQueue = new PriorityQueue<>(n, new MyComparator());

        for (int i = 0; i < n; i++) {
            HuffmanNode hn = new HuffmanNode(charFreq[i], charArray[i]);
            priorityQueue.add(hn);
        }

        while (priorityQueue.size() > 1) {
            HuffmanNode x = priorityQueue.poll();
            HuffmanNode y = priorityQueue.poll();
            HuffmanNode z = new HuffmanNode(x.data + y.data, '-');
            z.left = x;
            z.right = y;
            priorityQueue.add(z);
        }
        HuffmanNode root = priorityQueue.peek();
        printCodes(root, "");
    }
}
