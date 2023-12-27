### Q2. Linked-List
#### Problem Description
```text
Design and implement a Linked List data structure.
A node in a linked list should have the following 
attributes - an integer value and a pointer to the next node. 
It should support the following operations:
```
```text
insert_node(position, value) - To insert the input value at 
the given position in the linked list.
delete_node(position) - Delete the value at the given position 
from the linked list.
print_ll() - Print the entire linked list, such that each 
element is followed by a single space (no trailing spaces).
```
<p><strong>Note:</strong></p>
<ul>
    <li>If an input position does not satisfy the constraint,
    <strong> no action</strong> is required.</li>
    <li>Each print query has to be executed in a new line.</li>
</ul>

#### Problem Constraints
```text
1 <= value <= 10^5
1 <= position <= n where, n is the size of the linked-list.
```
#### Input Format
```text
First line contains an integer denoting number of cases, let's say t.
Next t line denotes the cases.
```
#### Output Format
```text
When there is a case of print_ll(),  Print the entire linked list, 
such that each element is followed by a single space. 

There should not be any trailing space.

NOTE: You don't need to return anything.
```
#### Example Input
```text
Input 1:
 5
 i 1 23
 i 2 24
 p
 d 1
 p
```
#### Example Output
```text
Output 1:
 23 24
 24
```
#### Example Explanation
```text
Explanation 1:
    After first two cases linked list contains two elements 23 and 24.
    At third case print: 23 24.
    At fourth case delete value at first position, only one element left 24.
    At fifth case print: 24.
```
### Hints
* Hint 1
```text
Try to fill out the linked list and maintain head always for printing it.
```
* Solution Approach
```text
We will maintain the head of the LinkedList.

    1. For Insert operation - Firstly, we will traverse the 
       list and keep two pointers, current and previous. 
    
       So if the position is 1, we will add the node in the beginning 
       and update the head. 
    
       Otherwise, we will traverse the list up to the desired position 
       and add the node by making the current node, the next node of 
       the newly added node, and the next node of the previous node 
       will be the newly added node.

    2. For Print LinkedList Operation - We will print the data 
       of all the nodes by traversing through the list and stop when 
       our current pointer becomes null.

    3. For Delete LinkedList Operation - We will traverse the 
       list up to the desired position and keep track of 
       two pointers, current and previous. 
       
       If the position is 1, we will make the new head of the 
       list the next element of the last head. 
       
       Otherwise, make the next element of the previous node 
       the next element of the current node. At last, free the 
       pointer of the current node.
```
* Complete Solution
* * Solution in Java
```java
public class Solution {
    static class node {
        int data;
        node next;

        public node() {
            this.data = 0;
            this.next = null;
        }
    }

    static node root = null;
    static int size_of_ll = 0;

    public static void insert_node(int position, int value) {
        // @params position, integer
        // @params value, integer
        if (position >= 1 && position <= size_of_ll + 1) {
            node temp = new node();
            temp.data = value;
            // insert at head
            if (position == 1) {
                temp.next = root;
                root = temp;
            } else {
                int count = 1;
                node prev = root;
                // traverse till the previous node
                while (count < position - 1) {
                    prev = prev.next;
                    count++;
                }
                temp.next = prev.next;
                prev.next = temp;

            }
            size_of_ll++;
        }
    }

    public static void delete_node(int position) {
        // @params position, integer
        if (position >= 1 && position <= size_of_ll) {
            node temp = null;
            // remove at head
            if (position == 1) {
                temp = root;
                root = root.next;
            } else {
                int count = 1;
                node prev = root;
                // traverse till the previous node
                while (count < position - 1) {
                    prev = prev.next;
                    count++;
                }
                temp = prev.next;
                prev.next = prev.next.next;
            }
            size_of_ll--;
        }
    }

    public static void print_ll() {
        // Output each element followed by a space
        node temp = root;
        int flag = 0;
        // traverse the entire linked list
        while (temp != null) {
            if (flag == 0) {
                System.out.print(temp.data);
                flag = 1;
            } else
                System.out.print(" " + temp.data);
            temp = temp.next;
        }
    }
}
```
* * Solution in Javascript
```javascript
// Please take input and print output to standard input/output (stdin/stdout)
// DO NOT USE ARGUMENTS FOR INPUTS
let root = new Node();
let size_of_ll = 0;
class LinkedList {
    constructor() {
        root = null;
        size_of_ll = 0;
    }

    insert_node(position, value) {
        let temp = new Node(0);
        temp.data = value;
        // insert at head
        if (position == 1) {
            temp.next = root;
            root = temp;
        } else {
            let count = 1;
            let prev = root;
            // traverse till the previous node
            while (count < position - 1) {
                prev = prev.next;
                count++;
            }
            temp.next = prev.next;
            prev.next = temp;

        }
        size_of_ll++;
    }

    delete_node(position) {
        if (position >= 1 && position <= size_of_ll) {
            let temp = null;
            // delete at head
            if (position == 1) {
                temp = root;
                root = root.next;
            } else {
                let count = 1;
                let prev = root;
                // traverse till the previous node
                while (count < position - 1) {
                    prev = prev.next;
                    count++;
                }
                temp = prev.next;
                prev.next = prev.next.next;
            }
            size_of_ll--;
        }
    }

    print_ll() {
        let temp = root;
        let flag = 0;
        // traverse the entire linked list
        while (temp != null) {
            if (flag == 0) {
                process.stdout.write(temp.data);
                flag = 1;
            } else
                process.stdout.write(" " + temp.data);
            temp = temp.next;
        }
        process.stdout.write("\n");
    }
}
```
* * Solution in C++
```cpp
#include<iostream>
using namespace std;

struct Node {
    int data;
    struct Node * next;
};

struct Node * root = NULL;
int size_of_ll = 0;

void print_ll() {
    // Output each element followed by a space
    struct Node * temp = root;
    int flag = 0;
    // traverse the entire linked list
    while (temp != NULL) {
        if (flag == 0) {
            cout << temp -> data;
            flag = 1;
        } else
            cout << " " << temp -> data;
        temp = temp -> next;
    }
}

void insert_node(int position, int value) {
    // @params position, integer
    // @params value, integer
    if (position >= 1 && position <= size_of_ll + 1) {
        struct Node * temp = new Node;
        temp -> data = value;
        // insert at head
        if (position == 1) {
            temp -> next = root;
            root = temp;
        } else {
            int count = 1;
            struct Node * prev = root;
            // traverse till the previous node
            while (count < position - 1) {
                prev = prev -> next;
                count++;
            }
            temp -> next = prev -> next;
            prev -> next = temp;

        }
        size_of_ll++;
    }
}

void delete_node(int position) {
    // @params position, integer
    if (position >= 1 && position <= size_of_ll) {
        struct Node * temp = NULL;
        // remove at head
        if (position == 1) {
            temp = root;
            root = root -> next;
        } else {
            int count = 1;
            struct Node * prev = root;
            // traverse till the previous node
            while (count < position - 1) {
                prev = prev -> next;
                count++;
            }
            temp = prev -> next;
            prev -> next = prev -> next -> next;
        }
        size_of_ll--;
    }
}
```

