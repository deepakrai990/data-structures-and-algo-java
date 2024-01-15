package com.scaler.core.java_3_advance_3.dsa_36_tries_1.assignment;

import java.util.*;

/**
 * @created 02/04/23 12:39 pm
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class Q2_Auto_Complete {

    static class AutoCompleteSuggestion {
        String str;
        int weight;

        public AutoCompleteSuggestion(String str, int weight) {
            this.str = str;
            this.weight = weight;
        }
    }

    static class Node {
        boolean isEnd;
        HashMap<Character, Node> hm;
        ArrayList<AutoCompleteSuggestion> ar;

        Node() {
            this.hm = new HashMap<Character, Node>();
            this.isEnd = false;
            this.ar = new ArrayList<AutoCompleteSuggestion>();
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = Integer.parseInt(scanner.nextLine());
        for (int k = 0; k < t; k++) {
            // read the second line of input
            String line2 = scanner.nextLine();
            String[] NandM = line2.split(" ");
            int[] nums2 = new int[NandM.length];
            for (int i = 0; i < NandM.length; i++) {
                nums2[i] = Integer.parseInt(NandM[i]);
            }
            // read the third line of input
            String line3 = scanner.nextLine();
            String[] words = line3.split(" ");
            // read the fourth line of input
            String line4 = scanner.nextLine();
            String[] weights = line4.split(" ");

            AutoCompleteSuggestion[] suggestions = new AutoCompleteSuggestion[weights.length];
            for (int i = 0; i < weights.length; i++) {
                suggestions[i] = new AutoCompleteSuggestion(words[i], Integer.parseInt(weights[i]));
            }

            Arrays.sort(suggestions, new Comparator<AutoCompleteSuggestion>() {
                public int compare(AutoCompleteSuggestion p1, AutoCompleteSuggestion p2) {
                    int indexA = p1.weight;
                    int indexB = p2.weight;
                    return indexB - indexA;
                }
            });

            Node root = new Node();
            for (int i = 0; i < suggestions.length; i++) {
                insert(suggestions[i].str, root, i);
            }
            // read the fifth line of input
            String line5 = scanner.nextLine();
            String[] searchwords = line5.split(" ");
            for (int i = 0; i < searchwords.length; i++) {
                search(searchwords[i], root);
            }
        }
        scanner.close();
    }

    public static void insert(String word, Node root, int wt) {
        Node t = root;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (t.hm.containsKey(ch)) {
                t = t.hm.get(ch);
                if (t.ar.size() < 5) {
                    t.ar.add(new AutoCompleteSuggestion(word, wt));
                }
            } else {
                Node nn = new Node();
                t.hm.put(ch, nn);
                t = nn;
                t.ar.add(new AutoCompleteSuggestion(word, wt));
            }
        }
        t.isEnd = true;
    }

    public static void search(String word, Node root) {
        Node t = root;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (t.hm.containsKey(ch)) {
                t = t.hm.get(ch);
            } else {
                System.out.print("-1 ");
                System.out.println();
                return;
            }
        }
        for (int j = 0; j < t.ar.size(); j++) {
            System.out.print(t.ar.get(j).str + " ");
        }
        System.out.println();
    }


}
