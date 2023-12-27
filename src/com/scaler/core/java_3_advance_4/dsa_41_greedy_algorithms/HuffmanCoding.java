package com.scaler.core.java_3_advance_4.dsa_41_greedy_algorithms;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @author Deepak Kumar Rai
 * @created 29/11/23
 * @project scaler_course_code
 */
public class HuffmanCoding {
    static class HuffmanNode {
        char data;
        int frequency;
        HuffmanNode left, right;

        public HuffmanNode(char data, int frequency) {
            this.data = data;
            this.frequency = frequency;
            left = right = null;
        }
    }

    static class HuffmanComparator implements Comparator<HuffmanNode> {
        public int compare(HuffmanNode x, HuffmanNode y) {
            return x.frequency - y.frequency;
        }
    }
    /**
     * Here is a complete and comprehensive example of Huffman's coding algorithm in Java.
     * This example includes encoding, decoding, and utility functions for working with Huffman codes.
     * <p></p>
     * This example demonstrates the complete Huffman coding process, including building the Huffman tree,
     * encoding a string, and decoding the encoded string. The `buildHuffmanTree` function constructs
     * the Huffman tree, and the `encode` and `decode` functions use the tree to encode and decode strings,
     * respectively.
     * **/
    static HuffmanNode root;
    private static Map<Character, String> buildHuffmanTree(String input) {
        Map<Character, Integer> frequencyMap = new HashMap<>();
        for (char c : input.toCharArray()) {
            frequencyMap.put(c, frequencyMap.getOrDefault(c, 0) + 1);
        }
        PriorityQueue<HuffmanNode> priorityQueue = new PriorityQueue<>(new HuffmanComparator());
        for (Map.Entry<Character, Integer> entry : frequencyMap.entrySet()) {
            priorityQueue.add(new HuffmanNode(entry.getKey(), entry.getValue()));
        }
        while (priorityQueue.size() > 1) {
            HuffmanNode left = priorityQueue.poll();
            HuffmanNode right = priorityQueue.poll();

            HuffmanNode internalNode = new HuffmanNode('-', left.frequency + right.frequency);
            internalNode.left = left;
            internalNode.right = right;

            priorityQueue.add(internalNode);
        }
        root = priorityQueue.poll();
        Map<Character, String> huffmanCodes = new HashMap<>();
        buildHuffmanCodes(root, "", huffmanCodes);
        return huffmanCodes;
    }

    private static void buildHuffmanCodes(HuffmanNode root, String code, Map<Character, String> huffmanCodes) {
        if (root != null) {
            if (root.left == null && root.right == null) {
                huffmanCodes.put(root.data, code);
            }
            buildHuffmanCodes(root.left, code + "0", huffmanCodes);
            buildHuffmanCodes(root.right, code + "1", huffmanCodes);
        }
    }

    private static String encode(String input, Map<Character, String> huffmanCodes) {
        StringBuilder encodedString = new StringBuilder();
        for (char c : input.toCharArray()) {
            encodedString.append(huffmanCodes.get(c));
        }
        return encodedString.toString();
    }

    public static String decode(String encodedString, HuffmanNode root) {
        StringBuilder decodedString = new StringBuilder();
        HuffmanNode current = root;
        for (char bit : encodedString.toCharArray()) {
            if (bit == '0') {
                current = current.left;
            } else {
                current = current.right;
            }
            if (current.left == null && current.right == null) {
                decodedString.append(current.data);
                current = root;
            }
        }
        return decodedString.toString();
    }

    public static void main(String[] args) {
        String input = "Huffman coding is a compression algorithm.";
        Map<Character, String> huffmanCodes = buildHuffmanTree(input);

        String encodedString = encode(input, huffmanCodes);
        System.out.println("Encoded String: " + encodedString);

        // Need to work here to understand this
        //String decodedString = decode(encodedString, huffmanCodes.keySet().iterator().next());
        String decodedString = decode(encodedString, root);
        System.out.println("Decoded String: " + decodedString);
    }
}
