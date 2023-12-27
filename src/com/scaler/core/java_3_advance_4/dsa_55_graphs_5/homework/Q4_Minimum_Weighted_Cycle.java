package com.scaler.core.java_3_advance_4.dsa_55_graphs_5.homework;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;

/**
 * @created 01/04/23 11:39 pm
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class Q4_Minimum_Weighted_Cycle {
    class Node {
        int v;
        int wgt;

        Node(int v, int wgt) {
            this.v = v;
            this.wgt = wgt;
        }
    }

    class Pair {
        int a;
        int b;

        Pair(int a, int b) {
            this.a = a;
            this.b = b;
        }
    }

    HashMap<String, Pair> mapEdge;

    public int solve(int A, int[][] B) {
        mapEdge = new HashMap<>();
        ArrayList<ArrayList<Node>> list = new ArrayList<>();
        int ans = Graph(A, B, list);
        for (String key : mapEdge.keySet()) {
            int u = mapEdge.get(key).a;
            int v = mapEdge.get(key).b;
            if (u == v) continue;
            int idx1 = -1;
            for (int i = 0; i < list.get(u).size(); i++) {
                if (list.get(u).get(i).v == v) {
                    idx1 = i;
                    break;
                }
            }
            Node temp1 = list.get(u).get(idx1);
            list.get(u).remove(idx1);

            int idx2 = -1;
            for (int i = 0; i < list.get(v).size(); i++) {
                if (list.get(v).get(i).v == u) {
                    idx2 = i;
                    break;
                }
            }
            Node temp2 = list.get(v).get(idx2);
            list.get(v).remove(idx2);

            int subAns = DijktraAlgo(A, list, u, v);
            if (subAns != Integer.MAX_VALUE)
                subAns = subAns + temp1.wgt;
            ans = Math.min(ans, subAns);
            list.get(u).add(temp1);
            list.get(v).add(temp2);
        }
        return ans == Integer.MAX_VALUE ? -1 : ans;

    }

    private int Graph(int A, int[][] B, ArrayList<ArrayList<Node>> list) {
        int ans = Integer.MAX_VALUE;
        HashMap<String, Pair> map = new HashMap<>();
        HashMap<String, Pair> map2 = new HashMap<>();
        for (int i = 0; i < B.length; i++) {
            String key = Math.min(B[i][0], B[i][1]) + "_" + Math.max(B[i][0], B[i][1]);

            if (map.containsKey(key)) {
                int min1 = map.get(key).a;
                int min2 = map.get(key).b;

                if (min1 >= B[i][2]) {
                    min2 = min1;
                    min1 = B[i][2];
                }
                if (min2 > B[i][2] && B[i][2] != min1) {
                    min2 = B[i][2];
                }

                map.put(key, new Pair(min1, min2));
            } else {
                map.put(key, new Pair(B[i][2], Integer.MAX_VALUE));
                map2.put(key, new Pair(Math.min(B[i][0], B[i][1]), Math.max(B[i][0], B[i][1])));
            }
        }

        for (int i = 0; i <= A; i++) {
            ArrayList<Node> temp = new ArrayList<>();
            list.add(temp);
        }
        mapEdge = map2;
        for (String key : map.keySet()) {
            int u = map2.get(key).a;
            int v = map2.get(key).b;
            if (u != v) {
                list.get(u).add(new Node(v, map.get(key).a));
                list.get(v).add(new Node(u, map.get(key).a));

                if (map.get(key).b != Integer.MAX_VALUE)
                    ans = Math.min(ans, map.get(key).b + map.get(key).a);
            } else {
                ans = Math.min(ans, map.get(key).a);
            }
        }
        return ans;
    }

    private int DijktraAlgo(int A, ArrayList<ArrayList<Node>> list, int S, int D) {
        int[] weight = new int[A + 1];
        for (int i = 0; i < A + 1; i++) {
            weight[i] = Integer.MAX_VALUE;
        }
        weight[S] = 0;
        PriorityQueue<Node> pq = new PriorityQueue<>(new Comparator<Node>() {
            public int compare(Node n1, Node n2) {
                return n1.wgt - n2.wgt;
            }
        });
        pq.add(new Node(S, 0));
        while (!pq.isEmpty()) {
            Node temp = pq.poll();
            if (temp.v == D) {
                return temp.wgt;
            }
            for (Node ele : list.get(temp.v)) {
                if (temp.wgt + ele.wgt < weight[ele.v]) {
                    weight[ele.v] = temp.wgt + ele.wgt;
                    pq.add(new Node(ele.v, temp.wgt + ele.wgt));
                }
            }
        }
        return Integer.MAX_VALUE;
    }
}
