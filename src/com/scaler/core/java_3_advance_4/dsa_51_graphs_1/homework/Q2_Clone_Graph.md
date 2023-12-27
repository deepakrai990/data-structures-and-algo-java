### Q2. Clone Graph
#### Problem Description
<div style="background-color: #f9f9f9; padding: 5px 10px;">
    <p>Clone an undirected graph. Each node in the graph contains a label and a 
    list of its neighbors.</p>
    <p><b>Note:</b> The test cases are generated in the following format (use the 
    following format to use <b>See Expected Output</b> option):<br>
    First integer N is the number of nodes.<br>
    Then, N intgers follow denoting the label (or hash) of the N nodes.<br>
    Then, N<sup>2</sup> integers following denoting the adjacency matrix of a graph, 
    where <b>Adj[i][j] = 1</b> denotes presence of an undirected edge between 
    the i<sup>th</sup> and j<sup>th</sup> node, <b>O</b> otherwise.</p>
</div>

```text
Clone an undirected graph. Each node in the graph contains a label and a list of 
its neighbors.

Note: The test cases are generated in the following format (use the following format 
to use See Expected Output option):

First integer N is the number of nodes.

Then, N intgers follow denoting the label (or hash) of the N nodes.

Then, N^2 integers following denoting the adjacency matrix of a graph, 
where Adj[i][j] = 1 denotes presence of an undirected edge between the i^th and j^th 
node, O otherwise.
```
#### Problem Constraints
<div style="background-color: #f9f9f9; padding: 5px 10px;">
    <p>1 &lt;= Number of nodes &lt;= 10<sup>5</sup></p>
</div>

```text
1 <= Number of nodes <= 10^5
```
#### Input Format
```text
First and only argument is a node A denoting the root of the undirected graph.
```
#### Output Format
```text
Return the node denoting the root of the new clone graph.
```
#### Example Input
```text
Input 1:

      1
    / | \
   3  2  4
        / \
       5   6

Input 2:

      1
     / \
    3   4
   /   /|\
  2   5 7 6
```
#### Example Output
```text
Output 1:

 Output will the same graph but with new pointers:
      1
    / | \
   3  2  4
        / \
       5   6

Output 2:

      1
     / \
    3   4
   /   /|\
  2   5 7 6
```
#### Example Explanation
```text
Explanation 1:
    We need to return the same graph, but the pointers to the node should be different.
```
### Hints
* Hint 1
```text
This problem is a classical application of graph traversal algorithm.
```
* Solution Approach
```text
There are two main ways to traverse a graph: Breadth-first or Depth-first. Let’s try the Breadth-first approach first, which requires a queue. For the Depth-first approach, please see Clone Graph Part II.

How does the breadth-first traversal works? Easy, as we pop a node off the queue, we copy each of its neighbors, and push them to the queue.

A straight forward breadth-first traversal seemed to work. But some details are still missing. For example, how do we connect the nodes of the cloned graph?

Before we continue, we first need to make sure if the graph is directed or not. If you notice how Node is defined above, it is quite obvious that the graph is a directed graph. Why?

For example, A can have a neighbor called B. Therefore, we may traverse from A to B. An undirected graph implies that B can always traverse back to A. Is it true here? No, because whether B could traverse back to A depends if one of B’s neighbor is A.

The fact that B can traverse back to A implies that the graph may contain a cycle. You must take extra care to handle this case. Imagine that you finished implementing without considering this case, and later being pointed out by your interviewer that your code has an infinite loop, yuck!

Let’s analyze this further by using the below example:

A simple graph

A <-> B

Assume that the starting point of the graph is A. First, you make a copy of node A (A2), and found that A has only one neighbor B. You make a copy of B (B2) and connects A2->B2 by pushing B2 as A2′s neighbor. Next, you find that B has A as neighbor, which you have already made a copy of. Here, we have to be careful not to make a copy of A again, but to connect B2->A2 by pushing A2 as B2′s neighbor. But, how do we know if a node has already been copied?

Easy, we could use a hash table! As we copy a node, we insert it into the table. If we later find that one of a node’s neighbor is already in the table, we do not make a copy of that neighbor, but to push its neighbor’s copy to its copy instead. Therefore, the hash table would need to store a mapping of key-value pairs, where the key is a node in the original graph and its value is the node’s copy.
```
* Complete Solution
* * Solution in Java
```java
/**
 * Definition for undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     List<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */
public class Solution {
    HashMap<UndirectedGraphNode,UndirectedGraphNode> map;
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        map=new HashMap<UndirectedGraphNode,UndirectedGraphNode>();
        return auxCloneGraph(node);
    }
    public UndirectedGraphNode auxCloneGraph(UndirectedGraphNode node){
        if(node==null)
            return node;
        if(map.containsKey(node)){
            return map.get(node);
        }
        UndirectedGraphNode clone=new UndirectedGraphNode(node.label);
        map.put(node,clone);
        for(UndirectedGraphNode neighbor:node.neighbors){
            clone.neighbors.add(auxCloneGraph(neighbor));
        }
        return clone;
    }
}
```
* * Solution in Javascript
```javascript
//  Definition for UndirectedGraphNode.
//	function UndirectedGraphNode(data) {
//	    this.label = data;
//	    this.neighbours = [];
//  }
let map = new Map();

function auxCloneGraph(node) {
    if (node == null)
        return node;
    if (map.has(node)) {
        return map.get(node);
    }
    let clone = new UndirectedGraphNode(node.label);
    map.set(node, clone);
    for (let i = 0; i < node.neighbors.length; i++) {
        let neighbor = node.neighbors[i];
        clone.neighbors.push(auxCloneGraph(neighbor));
    }
    return clone;
}
module.exports = {
    //param A : root of the undirected graph.
    //Return the node denoting the root of the new clone graph.
    cloneGraph: function (A) {
        map = new Map();
        return auxCloneGraph(A);
    }
};
```
* * Solution in C++
```cpp
/**
 * Definition for undirected graph.
 * struct UndirectedGraphNode {
 *     int label;
 *     vector<UndirectedGraphNode *> neighbors;
 *     UndirectedGraphNode(int x) : label(x) {};
 * };
 */
UndirectedGraphNode* Solution::cloneGraph(UndirectedGraphNode *graph) {
    if (!graph) return NULL;

    map<UndirectedGraphNode *, UndirectedGraphNode *> map;
    queue<UndirectedGraphNode *> q;
    q.push(graph);

    UndirectedGraphNode *graphCopy = new UndirectedGraphNode(graph->label);
    map[graph] = graphCopy;

    while (!q.empty()) {
        UndirectedGraphNode *node = q.front();
        q.pop();
        int n = node->neighbors.size();
        for (int i = 0; i < n; i++) {
            UndirectedGraphNode *neighbor = node->neighbors[i];
            // no copy exists
            if (map.find(neighbor) == map.end()) {
                UndirectedGraphNode *p = new UndirectedGraphNode(neighbor->label);
                map[node]->neighbors.push_back(p);
                map[neighbor] = p;
                q.push(neighbor);
            } else {     // a copy already exists
                map[node]->neighbors.push_back(map[neighbor]);
            }
        }
    }

    return graphCopy;
}
```

