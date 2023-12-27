package com.scaler.core.java_3_advance_4.dsa_51_graphs_1.homework;

import com.scaler.core.java_3_advance_4.dsa_51_graphs_1.model.UndirectedGraphNode;

import java.util.HashMap;
import java.util.Map;

/**
 * @created 02/04/23 8:32 am
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class Q2_Clone_Graph {
    /**
     * Definition for undirected graph.
     * class UndirectedGraphNode {
     *     int label;
     *     List<UndirectedGraphNode> neighbors;
     *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
     * };
     */
    Map<UndirectedGraphNode, UndirectedGraphNode> visited = new HashMap<>();

    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node == null)
            return node;
        if (visited.containsKey(node)) return visited.get(node);
        UndirectedGraphNode root = new UndirectedGraphNode(node.label);
        visited.put(node, root);
        for (UndirectedGraphNode neighborNode : node.neighbors) {
            root.neighbors.add(cloneGraph(neighborNode));
        }
        return root;
    }
}
