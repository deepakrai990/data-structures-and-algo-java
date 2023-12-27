### Q3. Copy List
#### Problem Description
```text
A linked list A is given such that each node contains 
an additional random pointer which could point to any 
node in the list or NULL.

Return a deep copy of the list.
```
#### Problem Constraints
```text
0 <= |A| <= 10^6
```
#### Input Format
```text
The first argument of input contains a pointer to the head 
of linked list A.
```
#### Output Format
```text
Return a pointer to the head of the required linked list.
```
#### Example Input
```text
Input 1:
 Given list
    1 -> 2 -> 3
 with random pointers going from
   1 -> 3
   2 -> 1
   3 -> 1
```
#### Example Output
```text
Output 1:
 1 -> 2 -> 3
 with random pointers going from
   1 -> 3
   2 -> 1
   3 -> 1
```
#### Example Explanation
```text
Explanation 1:
    You should return a deep copy of the list. The returned answer 
    should not contain the same node as the original list, but a 
    copy of them. The pointers in the returned list should not 
    link to any node in the original input list.
```
### Hints
* Hint 1
```text
The easiest way to approach this problem is using a hashmap. 
How? Try to think about how you can maintain a link between 
old nodes and new nodes.

Another efficient way can be creating new nodes and updating 
the random connections by traversing the list again.
```
* Solution Approach
```text
There are 2 approaches to solving this problem.

Approach 1: Using hashmap.
Use a hashmap to store the mapping from oldListNode to the newListNode. 
Whenever you encounter a new node in the oldListNode (either via a 
random pointer or through the next pointer ), create the newListNode, 
store the mapping. And update the next and random pointers of the 
newListNode using the mapping from the hashmap.

Approach 2 : Using 2 traversals of the list.
Step 1: create a new node for each existing node and join them 
together eg: A->B->C will be A->A’->B->B’->C->C’

Step2: copy the random links: for each 
new node n’, n’.random = n.random.next

Step3: detach the list: 
basically n.next = n.next.next; n’.next = n’.next.next
```
* Complete Solution
* * Solution in Java
```java
/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
public class Solution {
    private HashMap < RandomListNode, RandomListNode > hashMap;
    public RandomListNode copyRandomList(RandomListNode head) {
        RandomListNode node, newHead, newNode;
        hashMap = new HashMap < > ();
        node = head;
        newHead = null;
        while (node != null) {
            newNode = new RandomListNode(node.label);
            if (newHead == null)
                newHead = newNode;
            hashMap.put(node, newNode);
            node = node.next;
        }
        for (Map.Entry < RandomListNode, RandomListNode > entry: hashMap.entrySet()) {
            node = entry.getKey();
            newNode = entry.getValue();
            if (node.next != null) {
                newNode.next = hashMap.get(node.next);
            }
            if (node.random != null) {
                newNode.random = hashMap.get(node.random);
            }
        }
        return newHead;
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
 * Definition for singly-linked list.
 * struct RandomListNode {
 *     int label;
 *     RandomListNode *next, *random;
 *     RandomListNode(int x) : label(x), next(NULL), random(NULL) {}
 * };
 */
RandomListNode * Solution::copyRandomList(RandomListNode * head) {
    if (head == NULL) {
        return NULL;
    }

    // Step 1: create a new node for each existing node and join them together 
    // eg: A->B->C will be A->A'->B->B'->C->C'
    RandomListNode * node = head;
    while (node != NULL) {
        RandomListNode * copyNode = new RandomListNode(node -> label);
        RandomListNode * nextNode = node -> next;
        node -> next = copyNode;
        copyNode -> next = nextNode;
        node = nextNode;
    }

    // Step2: copy the random links: for each new node n', 
    // n'.random = n.random.next
    node = head;
    while (node != NULL) {
        RandomListNode * copyNode = node -> next;
        if (node -> random != NULL)
            copyNode -> random = node -> random -> next;
        else
            copyNode -> random = NULL;
        node = copyNode -> next;
    }

    // Step3: detach the list: 
    // basically n.next = n.next.next; n'.next = n'.next.next
    node = head;
    RandomListNode * copyNode = node -> next;
    RandomListNode * copyHead = head -> next;
    while (copyNode != NULL && node != NULL) {
        node -> next = node -> next -> next;
        if (copyNode -> next == NULL) {
            break;
        }
        copyNode -> next = copyNode -> next -> next;

        copyNode = copyNode -> next;
        node = node -> next;
    }

    return copyHead;
}
```

