package com.scaler.core.java_3_advance_4.dsa_51_graphs_1.model;

import java.util.ArrayList;
import java.util.List;

/**
 * @created 09/04/23 11:33 am
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class UndirectedGraphNode {
    public int label;
    public List<UndirectedGraphNode> neighbors;
    public UndirectedGraphNode(int x) {
        label = x;
        neighbors = new ArrayList<>();
    }
}
