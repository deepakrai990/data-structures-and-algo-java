### Q4. Middle Element from Stack!
#### Problem Description
```text
Implement a stack which will support following types of operations:

    * Type 1: "1 x" : Push x into the stack.
    
    * Type 2: "2 0" : Pop the top element from the stack and return it.
    
    * Type 3: "3 0" : Return the middle element of the stack.
    
    * Type 4: "4 0" : Delete the middle element from the stack.

You have to perform Q operations given in a form of 2-D array A 
of size Q x 2 where A[i][0] and A[i][1] denotes the operation 
parameters as explained above.

NOTE:

    * You have to output only for operations of type-2 and type-3.
    
    * If the stack is empty return -1 for operations of type-2 and type-3.
    
    * If the stack size is even then the second middle element 
      will be considered as middle element for the operations to perform.
    
    * Try to implement each operation in O(1) time complexity.
```
#### Problem Constraints
<div style="background-color: #f9f9f9; padding: 5px 10px;">
    <p>1 &lt;= Q &lt;= 10<sup>5</sup></p>
    <p>1 &lt;= x &lt;= 10<sup>3</sup></p>
</div>

```text
1 <= Q <= 10^5

1 <= x <= 10^3
```
#### Input Format
```text
First and only argument A is and 2-D array of size Q x 2 denoting 
the operations.
```
#### Output Format
```text
Return a 1-D array consisting the output of operations 
of type-2 and type-3. The order must be same as in input.
```
#### Example Input
```text
Input 1:
 A = [
        [1, 3]
        [3, 0]
        [4, 0]
        [2 ,0]
        [1, 5]
        [1, 9]
        [3, 0]
     ]

Input 2:
 A = [
        [1, 1]
        [1, 2]
        [1, 3]
        [3, 0]
        [4, 0]
        [3, 0]
        [4, 0]
     ]
```
#### Example Output
```text
Output 1:
 [3, -1, 9]

Output 2:
 [2, 3]
```
#### Example Explanation
```text
Explanation 1:
    Initial stack S = [ ]
    Operation 1: "1 3" : Push 3 into stack so stack becomes S = [3]
    Operation 2: "3 0" : Middle element of stack is 3 so adding 3 to output array.
    Operation 3: "4 0" : Deleting the middle element i.e 3 so stack becomes S = [ ]
    Operation 4: "2 0" : Popping element from the stack but the stack is empty so adding -1 to the output array.
    Operation 5: "1 5" : Push 5 into stack so stack becomes S = [5]
    Operation 6: "1 9" : Push 9 into stack so stack becomes S = [5, 9] where 9 is the top element of the stack.
    Operation 7: "3 0" : As stack size is even so 9 will be consider as middle element and we will add 9 to output array. Stack S remains same.

Explanation 2:
    Initial stack S = [ ]
    Operation 1: "1 1" : Push 1 into stack so stack becomes S = [1]
    Operation 2: "1 2" : Push 2 into stack so stack becomes S = [1, 2]
    Operation 3: "1 3" : Push 3 into stack so stack becomes S = [1, 2, 3]
    Operation 4: "3 0" : Middle element of stack is 2 so adding 2 to output array. Stack S remains same [1, 2, 3].
    Operation 5: "4 0" : Deleting the middle element i.e 2 so stack becomes S = [1, 3]
    Operation 6: "3 0" : Middle element of stack is 3 so adding 3 to output array. Stack S remains same [1, 3].
    Operation 6: "4 0" : Deleting the middle element i.e 3 so stack becomes S = [1]
```
### Hints
* Hint 1
```text
The important question is whether to use a linked list or array 
for the implementation of the stack?

The idea is to use Doubly Linked List (DLL). We can delete the 
middle element in O(1) time by maintaining mid pointer.

We can move the mid pointer in both directions using previous 
and next pointers.
```
* Solution Approach
```text
The important question is whether to use a linked list or array 
for the implementation of the stack?

Please note that we need to find and delete the middle 
element. Deleting an element from the middle is not O(1) for 
an array. Also, we may need to move the middle pointer up 
when we push an element and move down when we pop().

In a singly linked list, moving the middle pointer in both 
directions is not possible.

The idea is to use Doubly Linked List (DLL). We can delete 
the middle element in O(1) time by maintaining mid pointer. 
We can move the mid pointer in both directions using previous 
and next pointers.

Whenever we get a push operation, we make that element as 
a head of the linked list and correspondingly update the mid pointer.

By doing this, we make sure that each operation is performed in O(1).
```
* Complete Solution
* * Solution in Java
```java
class DLLNode {
    public DLLNode prev;
    public int data;
    public DLLNode next;
};

/* Representation of the stack data structure
that supports findMiddle() in O(1) time.
The Stack is implemented using Doubly Linked List.
It maintains pointer to head node, pointer to
middle node and count of nodes */
class myStack {
    public DLLNode head;
    public DLLNode mid;
    public int count;
};

public class Solution {
    public ArrayList < Integer > solve(ArrayList < ArrayList < Integer >> A) {
        myStack ms = createMyStack();
        ArrayList < Integer > ans = new ArrayList < Integer > ();
        for (int i = 0; i < A.size(); i++) {
            int a = A.get(i).get(0);
            int b = A.get(i).get(1);
            if (a == 1)
                push(ms, b);
            else if (a == 2)
                ans.add(pop(ms));
            else if (a == 3)
                ans.add(findMiddle(ms));
            else if (a == 4)
                deleteMiddle(ms);
        }
        return ans;
    }

    /* Function to create the stack data structure */
    public myStack createMyStack() {
        myStack ms = new myStack();
        ms.count = 0;
        return ms;
    };
    /* Function to push an element to the stack */
    public void push(myStack ms, int new_data) {
        /* allocate DLLNode and put in data */
        DLLNode new_DLLNode = new DLLNode();
        new_DLLNode.data = new_data;
        /* Since we are adding at the beginning,
        prev is always null */
        new_DLLNode.prev = null;
        /* link the old list off the new DLLNode */
        new_DLLNode.next = ms.head;
        /* Increment count of items in stack */
        ms.count += 1;
        /* Change mid pointer in two cases
        1) Linked List is empty
        2) Number of nodes in linked list is odd */
        if (ms.count == 1) {
            ms.mid = new_DLLNode;
        } else {
            ms.head.prev = new_DLLNode;
            if ((ms.count & 1) == 0) // Update mid if ms->count is even
                ms.mid = ms.mid.prev;
        }
        /* move head to point to the new DLLNode */
        ms.head = new_DLLNode;
    }

    /* Function to pop an element from stack */
    public int pop(myStack ms) {
        /* Stack underflow */
        if (ms.count == 0) {
            return -1;
        }
        DLLNode head = ms.head;
        int item = head.data;
        ms.head = head.next;
        // If linked list doesn't
        // become empty, update prev
        // of new head as null
        if (ms.head != null)
            ms.head.prev = null;
        ms.count -= 1;
        // update the mid pointer when
        // we have odd number of
        // elements in the stack, i,e
        // move down the mid pointer.
        if ((ms.count & 1) != 0)
            ms.mid = ms.mid.next;
        return item;
    }

    // Function for finding middle of the stack
    public int findMiddle(myStack ms) {
        if (ms.count == 0) {
            return -1;
        }
        return ms.mid.data;
    }
    public void deleteMiddle(myStack ms) {
        if (ms.count == 0)
            return;
        else if (ms.count == 1) {
            ms.count = 0;
            ms.head = null;
            ms.mid = null;
        } else if (ms.count == 2) {
            ms.count = 1;
            DLLNode head = ms.head;
            ms.head = head.next;
            ms.head.prev = null;
            ms.mid = ms.head;
        } else {
            DLLNode fo = ms.mid.next;
            DLLNode bac = ms.mid.prev;
            ms.mid.prev.next = ms.mid.next;
            ms.mid.next.prev = ms.mid.prev;
            ms.count -= 1;
            if ((ms.count & 1) != 0) ms.mid = fo;
            else ms.mid = bac;
        }
        return;
    }
}
```
* * Solution in Javascript
```javascript
function DLLNode(prev, data, next) {
    this.prev = prev;
    this.data = data;
    this.next = next;
}

function myStack(head, mid, count) {
    this.head = head;
    this.mid = mid;
    this.count = count;
}

function createMyStack() {
    let ms = new myStack(null, null, 0);
    ms.count = 0;
    return ms;
};

/* Function to push an element to the stack */
function push(ms, new_data) {
    /* allocate DLLNode and put in data */
    let new_DLLNode = new DLLNode(null, 0, null);
    new_DLLNode.data = new_data;
    new_DLLNode.prev = null;
    new_DLLNode.next = ms.head;
    ms.count += 1;

    if (ms.count == 1) {
        ms.mid = new_DLLNode;
    } else {
        ms.head.prev = new_DLLNode;

        if ((ms.count & 1) == 0) // Update mid if ms->count is even
            ms.mid = ms.mid.prev;
    }

    /* move head to point to the new DLLNode */
    ms.head = new_DLLNode;
}

/* Function to pop an element from stack */
function pop(ms) {
    /* Stack underflow */
    if (ms.count == 0) {
        return -1;
    }

    let head = ms.head;
    let item = head.data;
    ms.head = head.next;

    // If linked list doesn't
    // become empty, update prev
    // of new head as null
    if (ms.head != null)
        ms.head.prev = null;

    ms.count -= 1;

    // update the mid pointer when
    // we have odd number of
    // elements in the stack, i,e
    // move down the mid pointer.
    if ((ms.count & 1) != 0)
        ms.mid = ms.mid.next;

    return item;
}

// Function for finding middle of the stack
function findMiddle(ms) {
    if (ms.count == 0) {
        return -1;
    }
    return ms.mid.data;
}

function deleteMiddle(ms) {
    if (ms.count == 0)
        return;
    else if (ms.count == 1) {
        ms.count = 0;
        ms.head = null;
        ms.mid = null;
    } else if (ms.count == 2) {
        ms.count = 1;
        let head = ms.head;
        ms.head = head.next;
        ms.head.prev = null;
        ms.mid = ms.head;
    } else {
        let fo = ms.mid.next;
        let bac = ms.mid.prev;
        ms.mid.prev.next = ms.mid.next;
        ms.mid.next.prev = ms.mid.prev;
        ms.count -= 1;
        if ((ms.count & 1) != 0) ms.mid = fo;
        else ms.mid = bac;
    }
}

module.exports = {
    //param A : array of array of integers
    //return a array of integers
    solve: function (A) {
        let ms = createMyStack();
        ans = [];
        for (let i = 0; i < A.length; i++) {
            let a = A[i][0];
            let b = A[i][1];
            if (a == 1)
                push(ms, b);
            else if (a == 2)
                ans.push(pop(ms));
            else if (a == 3)
                ans.push(findMiddle(ms));
            else if (a == 4)
                deleteMiddle(ms);
        }

        return ans;
    }
};
```
* * Solution in C++
```cpp
class DLLNode {
    public:
        DLLNode * prev;
        int data;
        DLLNode * next;
};

/* Representation of the stack data structure
that supports findMiddle() in O(1) time.
The Stack is implemented using Doubly Linked List.
It maintains pointer to head node, pointer to
middle node and count of nodes */
class myStack {
    public:
        DLLNode * head;
        DLLNode * mid;
        int count;
};

/* Function to create the stack data structure */
myStack * createMyStack() {
    myStack * ms = new myStack();
    ms -> count = 0;
    return ms;
};

/* Function to push an element to the stack */
void push(myStack * ms, int new_data) {
    /* allocate DLLNode and put in data */
    DLLNode * new_DLLNode = new DLLNode();
    new_DLLNode -> data = new_data;
    /* Since we are adding at the beginning,
    prev is always NULL */
    new_DLLNode -> prev = NULL;
    /* link the old list off the new DLLNode */
    new_DLLNode -> next = ms -> head;
    /* Increment count of items in stack */
    ms -> count += 1;
    /* Change mid pointer in two cases
    1) Linked List is empty
    2) Number of nodes in linked list is odd */
    if (ms -> count == 1) {
        ms -> mid = new_DLLNode;
    } else {
        ms -> head -> prev = new_DLLNode;
        if (!(ms -> count & 1)) // Update mid if ms->count is even
            ms -> mid = ms -> mid -> prev;
    }
    /* move head to point to the new DLLNode */
    ms -> head = new_DLLNode;
}

/* Function to pop an element from stack */
int pop(myStack * ms) {
    /* Stack underflow */
    if (ms -> count == 0) {
        return -1;
    }
    DLLNode * head = ms -> head;
    int item = head -> data;
    ms -> head = head -> next;
    // If linked list doesn't
    // become empty, update prev
    // of new head as NULL
    if (ms -> head != NULL)
        ms -> head -> prev = NULL;
    ms -> count -= 1;
    // update the mid pointer when
    // we have odd number of
    // elements in the stack, i,e
    // move down the mid pointer.
    if ((ms -> count) & 1)
        ms -> mid = ms -> mid -> next;
    free(head);
    return item;
}

// Function for finding middle of the stack
int findMiddle(myStack * ms) {
    if (ms -> count == 0) {
        return -1;
    }
    return ms -> mid -> data;
}
void deleteMiddle(myStack * ms) {
    if (ms -> count == 0)
        return;
    else if (ms -> count == 1) {
        ms -> count = 0;
        ms -> head = NULL;
        ms -> mid = NULL;
    } else if (ms -> count == 2) {
        ms -> count = 1;
        DLLNode * head = ms -> head;
        ms -> head = head -> next;
        ms -> head -> prev = NULL;
        ms -> mid = ms -> head;
        free(head);
    } else {
        DLLNode * fo = ms -> mid -> next;
        DLLNode * bac = ms -> mid -> prev;
        ms -> mid -> prev -> next = ms -> mid -> next;
        ms -> mid -> next -> prev = ms -> mid -> prev;
        ms -> count -= 1;
        if (ms -> count & 1) ms -> mid = fo;
        else ms -> mid = bac;
    }
    return;
}
vector < int > Solution::solve(vector < vector < int > > & A) {
    myStack * ms = createMyStack();
    vector < int > ans;
    for (int i = 0; i < A.size(); i++) {
        int a = A[i][0];
        int b = A[i][1];
        if (a == 1) push(ms, b);
        else if (a == 2) ans.push_back(pop(ms));
        else if (a == 3) ans.push_back(findMiddle(ms));
        else if (a == 4) deleteMiddle(ms);
    }
    return ans;
}
```

