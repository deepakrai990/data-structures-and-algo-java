### Q3. Merge K Sorted Lists
#### Problem Description
```text
Given a list containing head pointers of N sorted linked lists.
Merge these given sorted linked lists and return them as one sorted list.
```
#### Problem Constraints
```text
1 <= total number of elements in given linked lists <= 100000
```
#### Input Format
```text
The first and only argument is a list containing N head pointers.
```
#### Output Format
```text
Return a pointer to the head of the sorted linked list after merging all the given 
linked lists.
```
#### Example Input
```text
Input 1:
 1 -> 10 -> 20
 4 -> 11 -> 13
 3 -> 8 -> 9

Input 2:
 10 -> 12
 13
 5 -> 6
```
#### Example Output
```text
Output 1:
 1 -> 3 -> 4 -> 8 -> 9 -> 10 -> 11 -> 13 -> 20

Output 2:
 5 -> 6 -> 10 -> 12 ->13
```
#### Example Explanation
```text
Explanation 1:
    The resulting sorted Linked List formed after merging 
    is 1 -> 3 -> 4 -> 8 -> 9 -> 10 -> 11 -> 13 -> 20.

Explanation 2:
    The resulting sorted Linked List formed after merging is 5 -> 6 -> 10 -> 12 ->13.
```
### Hints
* Hint 1
```text
Let’s keep a pointer for every linked list.
At any instant, you will need to know the minimum of elements at all pointers.
Following it, you will need to advance that pointer. Can you do this in complexity 
better than O(K)?

Preferably O(logK). But how?
```
* Solution Approach
```text
There are two approaches to solving the problem.

Approach 1: Using heap.
You need the minimum of the head of all the K linked lists at every instant.
Once you know the minimum, you can push the node to your answer list and move it over 
to the next node in that linked list.

Approach 2: Divide and conquer.
Solve the problem for the first k/2 and last k/2 list. Then you have two sorted lists. 
Then merge the lists.

Analyze the time complexity.

T(N) = 2 T(N/2) + N
T(N) = O (N log N)
```
* Complete Solution
* * Solution in Java
```java
/**
 * Definition for singly-linked list.
 * class ListNode {
 *     public int val;
 *     public ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 */
public class Solution {
    public ListNode mergeKLists(ArrayList<ListNode> A) {
        TreeMap<Integer, ArrayList<ListNode>> map = new TreeMap<>();
        ListNode node;
        ArrayList<ListNode> list;
        int val;
        
        for (ListNode head : A) {
            node = head;
            while (node != null) {
                val = node.val;
                if (map.containsKey(val)) {
                    list = map.get(val);
                    list.add(node);
                } else {
                    list = new ArrayList<>();
                    list.add(node);
                    map.put(val, list);
                }
                node = node.next;
            }
        }
        ListNode head = null;
        node = null;
        for (Map.Entry<Integer, ArrayList<ListNode>> entry : map.entrySet()) {
            list = entry.getValue();
            for (ListNode n : list) {
                if (head == null)
                    head = n;
                if (node != null)
                    node.next = n;
                node = n;
            }
            
        }
        return head;
    }
}
```
* * Solution in Javascript
```javascript
// Definition for singly-linked list.
//			function Node(data){
//				this.data = data
//				this.next = null
//			}

const top = 0;
const parent = (i) => ((i + 1) >>> 1) - 1;
const left = (i) => (i << 1) + 1;
const right = (i) => (i + 1) << 1;

class PriorityQueue {
  constructor(comparator = (a, b) => a > b) {
    this._heap = [];
    this._comparator = comparator;
  }
  size() {
    return this._heap.length;
  }
  isEmpty() {
    return this.size() == 0;
  }
  peek() {
    return this._heap[top];
  }
  push(...values) {
    values.forEach((value) => {
      this._heap.push(value);
      this._siftUp();
    });
    return this.size();
  }
  pop() {
    const poppedValue = this.peek();
    const bottom = this.size() - 1;
    if (bottom > top) {
      this._swap(top, bottom);
    }
    this._heap.pop();
    this._siftDown();
    return poppedValue;
  }
  replace(value) {
    const replacedValue = this.peek();
    this._heap[top] = value;
    this._siftDown();
    return replacedValue;
  }
  _greater(i, j) {
    return this._comparator(this._heap[i], this._heap[j]);
  }
  _swap(i, j) {
    [this._heap[i], this._heap[j]] = [this._heap[j], this._heap[i]];
  }
  _siftUp() {
    let node = this.size() - 1;
    while (node > top && this._greater(node, parent(node))) {
      this._swap(node, parent(node));
      node = parent(node);
    }
  }
  _siftDown() {
    let node = top;
    while (
      (left(node) < this.size() && this._greater(left(node), node)) ||
      (right(node) < this.size() && this._greater(right(node), node))
    ) {
      let maxChild =
        right(node) < this.size() && this._greater(right(node), left(node))
          ? right(node)
          : left(node);
      this._swap(node, maxChild);
      node = maxChild;
    }
  }
}

module.exports = {
  //param A : array of integers
  //return the head node in the linked list
  mergeKLists: function (A) {
    let dummy = new Node(0);
    let tail = dummy;

    let queue = new PriorityQueue((a, b) => a.data < b.data);
    for (let i = 0; i < A.length; i++) {
      if (A[i] != null) {
        queue.push(A[i]);
      }
    }

    while (!queue.isEmpty()) {
      tail.next = queue.pop();
      tail = tail.next;

      // add the next element of the list into the queue.
      if (tail.next) {
        queue.push(tail.next);
      }
    }
    return dummy.next;
  },
};
```
* * Solution in C++
```cpp
/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode(int x) : val(x), next(NULL) {}
 * };
 */
 
struct CompareNode {
    bool operator()(ListNode *
        const & p1, ListNode *
        const & p2) {
        // return "true" if "p1" is ordered before "p2", for example:
        return p1 -> val > p2 -> val;
    }
};

ListNode * Solution::mergeKLists(vector < ListNode * > & A) {
    ListNode * dummy = new ListNode(0);
    ListNode * tail = dummy;

    priority_queue < ListNode * , vector < ListNode * > , CompareNode > queue;

    for (int i = 0; i < A.size(); i++) {
        //insert the first element of all the lists into the queue.
        if (A[i] != NULL) {
            queue.push(A[i]);
        }
    }

    while (!queue.empty()) {

        // take out the minimum element and add it to the tail 
        tail -> next = queue.top();
        queue.pop();
        tail = tail -> next;

        // add the next element of the list into the queue.
        if (tail -> next) {
            queue.push(tail -> next);
        }
    }

    return dummy -> next;
}
```

