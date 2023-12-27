### Q4. Nodes Distance K in Binary Tree
#### Problem Description
```text
Given the root of a binary tree A, the value of a target node B, and an integer C.

Return an array of the values of all nodes that have a distance C from the target node B.

Note :- The target node B always exist. All the nodes has unique value
```
#### Problem Constraints
<div style="background-color: #f9f9f9; padding: 5px 10px;">
    <p>1 &lt;= number of nodes &lt;= 10<sup>5</sup></p>
    <p>1 &lt;= B &lt;= 10<sup>5</sup></p>
    <p>1 &lt;= C &lt;= 10<sup>5</sup></p>
</div>

```text
1 <= number of nodes <= 10^5

1 <= B <= 10^5

1 <= C <= 10^5
```
#### Input Format
```text
First argument is the root node of the binary tree, A.

Second argument is an integer denoting the value of the target node B.

Third argument is an integer denoting C.
```
#### Output Format
```text
Return an integer array denoting the nodes at a distance C from targer node B
```
#### Example Input
```text
Input 1:

A = 1
     \
      2
     /
    3

B = 2
C = 1

Input 2:

A = 1
   / \
  6   2
     /
    3

B = 6
C = 2
```
#### Example Output
```text
Output 1:
 [1, 3]

Output 2:
 [2]
```
#### Example Explanation
```text
Explanation 1:
    The nodes 1 and 3 are at a distance 1 from node 2.

Explanation 2:
    The node 2 is at a distance 2 from node 6.
```
### Hints
* Hint 1
```text
Can you find the nodes at a distance K from a node in a graph?
Try converting the binary tree to a undirected graph.
```
* Solution Approach
```text
We convert the binary tree into a undirected graph.
Then we do a BFS traversal from the target node. At every
level, we find the nodes equidistance from the target node. We
continue this till we encounter the nodes at a distance of C.

Time Complexity : O(N)
Space Complexity : O(N)
where N is the number of nodes of A
```
* Complete Solution
* * Solution in Java
```java
/**
 * Definition for binary tree
 * class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) {
 *      val = x;
 *      left=null;
 *      right=null;
 *     }
 * }
 */
 
public class Solution {
    private void buildGraph(TreeNode node, TreeNode parent, Map<Integer, List<Integer>> graph) {
        if (node == null) return;
        if (!graph.containsKey(node.val)) {
            graph.put(node.val, new ArrayList<Integer>());
            if (parent != null)  { 
                graph.get(node.val).add(parent.val); 
                graph.get(parent.val).add(node.val) ; 
            }
            buildGraph(node.left, node, graph);
            buildGraph(node.right, node, graph);
        }
    }    
    public ArrayList<Integer> solve(TreeNode A, int B, int C) {
        Map<Integer, List<Integer>> graph = new HashMap();
        Set<Integer> visited = new HashSet<Integer>();
        ArrayList<Integer> res = new ArrayList<Integer>();
        Queue<Integer> q = new LinkedList<Integer>();
        int cnt = 0;
        
        // build the graph
        buildGraph(A, null, graph);
        
        // push the target to start bfs with
        q.add(B);
        visited.add(B);
        
        // bfs
        while (!q.isEmpty()) {
            int size = q.size();
            // we reached the Cth layer, push the layer in res vector and break bfs
            if (C == 0) {
                for (int i = 0; i < size ; i++) 
                    res.add(q.poll());
                return res;
            }
            for (int i = 0; i < size; i++) {
                int node = q.poll();
                for (Integer next : graph.get(node)) {
                    if (visited.contains(next)) 
                        continue;
                    visited.add(next);
                    q.add(next);
                }
            }
            C--;
        }
        return res;
    }
}
```
* * Solution in Javascript
```javascript
/** not available **/
```
* * Solution in C++
```cpp
/**
 * Definition for binary tree
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode(int x) : val(x), left(NULL), right(NULL) {}
 * };
 */
void buildGraph(TreeNode* A,unordered_map<int,vector<int>>& graph){
    if(A->left != NULL){
        graph[A->val].push_back(A->left->val);
        graph[A->left->val].push_back(A->val);
        buildGraph(A->left,graph);
    }
    if(A->right!=NULL){            
        graph[A->val].push_back(A->right->val);
        graph[A->right->val].push_back(A->val);
        buildGraph(A->right,graph);            
    }
}
vector<int> Solution::solve(TreeNode* A, int B, int C) {
    if(C == 0)
        return {B};

    unordered_map<int,vector<int>> graph;
    unordered_map<int,bool> visited;
    vector<int> res;
    queue<int> q;
    int cnt = 0;
    
    // build the graph
    buildGraph(A,graph);
    
    // push the target to start bfs with
    q.push(B);
    
    // bfs
    while(!q.empty()){
        int sz = q.size();
        for(int i = 0; i < sz; i++){
            int curr = q.front();
            q.pop();
            visited[curr] = true;
            for(int x : graph[curr])
                if(!visited[x])
                    q.push(x);
        }
        cnt++;
        // we reached the Cth layer, push the layer in res vector and break bfs
        if(cnt == C){
            while(!q.empty()){
                res.push_back(q.front());
                q.pop();
            }
            break;
        }
    }
    
    return res;
}
```

