### Q3. LRU Cache
#### Problem Description
```text
Design and implement a data structure for Least Recently Used (LRU) cache. 
It should support the following operations: get and set.

    * get(key) - Get the value (will always be positive) of the key if the 
    key exists in the cache, otherwise return -1.
    * set(key, value) - Set or insert the value if the key is 
    not already present. When the cache reaches its capacity, it should 
    invalidate the least recently used item before inserting the new item.

The LRUCache will be initialized with an integer corresponding to its capacity. 
Capacity indicates the maximum number of unique keys it can hold at a time.

Definition of "least recently used" : An access to an item is defined as a 
get or a set operation of the item. "Least recently used" item is the one 
with the oldest access time.

NOTE: If you are using any global variables, make sure to clear them in the constructor.
```
#### Problem Constraints
```text
/** Not available **/
```
#### Input Format
```text
Input : 
         capacity = 2
         set(1, 10)
         set(5, 12)
         get(5)        returns 12
         get(1)        returns 10
         get(10)       returns -1
         set(6, 14)    this pushes out key = 5 as LRU is full. 
         get(5)        returns -1 
```
#### Output Format
```text
/** Not available **/
```
#### Example Input
```text
/** Not available **/
```
#### Example Output
```text
/** Not available **/
```
#### Example Explanation
```text
/** Not available **/
```
### Hints
* Hint 1
```text
Lets approach this question bit by bit.
If lets say you never had to remove entries from the LRU cache because we had 
enough space, what would you use to support and get and set ?

A simple map / hashmap would suffice.

Alright, lets now look at the second part which is where the eviction comes in. 
We need a data structure which at any given instance can give me the least 
recently used objects in order. Lets see if we can maintain a linked list 
to do it. We try to keep the list ordered by the order in which they are 
used. So whenever, a get operation happens, we would need to move that 
object from a certain position in the list to the front of the list. 

Which means a delete followed by insert at the beginning.

Insert at the beginning of the list is trivial. How do we achieve erase of 
the object from a random position in least time possible ?

How about we maintain another map which stores the pointer to the 
corresponding linked list node.

Ok, now when we know the node, we would need to know its previous and 
next node in the list to enable the deletion of the node from the list. 
We can get the next in the list from next pointer ? What about the 
previous node ? To encounter that, we make the list doubly linked list.

Now, can you think of an approach using doubly linked list and the map(s) ?
```
* Solution Approach


* As discussed in the previous hint, we solve this problem using :
<pre>
    <ul>
        <li>originalMap : A hashmap which stores the original key to value mapping</li>
        <li>accessList : A doubly linked list which has keys ordered by their access 
        time ( Most recently used key in front of the list to least recently 
        used key at the end of the list ).
        </li>
        <li>addressMap : A hashmap which saves the mapping of key to address of 
        the key in <code class="highlighter-rouge">accessList</code>.
        </li>
    </ul>
</pre>
* Let's see now how the get and set operation would work :
<pre>
    <ul> <li><p>get(key) :<br>
        Look for the value corresponding to key in originalMap. <br>
        If key is not found, we don’t need to change accessList. So, return -1. <br>
        If key is found, then we need to move the node corresponding to the key to front of the list in accessList. <br>
        To do that, we find the address of the node for key from addressMap. We make the <code class="highlighter-rouge">node-&gt;prev-&gt;next = node-&gt;next;</code>, <code class="highlighter-rouge">node-&gt;next-&gt;prev = node-&gt;prev;</code>, <code class="highlighter-rouge">node-&gt;prev = NULL; node-&gt;next = head; head-&gt;prev = node;</code><br>
        We update the head of the accessList to be node now.</p>
        </li>
        <li><p>set(key, value) <br>
        If the <code class="highlighter-rouge">key</code> is a new entry (it does not exist in the originalMap) AND the cache is full(size = capacity), then we would need to remove the least recently used key <code class="highlighter-rouge">lkey</code>. <br>
        We know that this key is the key corresponding to the last node in accessList which is accessible in O(1). To evict, we delete the last node from accessList, and the entry corresponding to <code class="highlighter-rouge">lkey</code>(from last node) in addressMap and originalMap.
        </p><p>Post this, there are 2 cases.</p>
        </li>
        <li><code class="highlighter-rouge">key</code> is a new entry and is not present in originalMap. In this case, a new node is created for <code class="highlighter-rouge">key</code> and inserted at the head of accessList. A new (key,value) entry is created into originalMap and addressMap accordingly.</li>
        <li><code class="highlighter-rouge">key</code> is present in the map, in which case the value needs to be updated. We update the value in the originalMap and then we update the accessList for <code class="highlighter-rouge">key</code> exactly the way we did in the case of get operation.</li>
    </ul>
</pre>

* A couple of insights for clean code :
<pre>
<ul>
  <li>Note that the update of accessList for <code class="highlighter-rouge">key</code> when <code class="highlighter-rouge">key</code> is present is a common operation in <code class="highlighter-rouge">get</code> and a subcase of <code class="highlighter-rouge">set</code> function. We should create a function for it and call that function in both cases to reduce redundancy.</li>
  <li>Also, note that originalMap and addressMap are always of the same size with the same keys ( One with value and the other with address in linkedlist ). If you want to manage less maps, you can just have a masterMap which maps <code class="highlighter-rouge">key</code> to a pair of (<code class="highlighter-rouge">value</code>, <code class="highlighter-rouge">address_in_list</code>)</li>
</ul>
</pre>


* Complete Solution
* * Solution in Java
```java
public class Solution {
    
    static class Node {
        int key;
        int val;
        Node prev, next;
        public Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }
    
    Node head;
    Node tail;
    int N;
    int MAX;
    HashMap<Integer, Node> mMap;
    
    public void updateAccessList(Node node){
        Node temp = node.prev;
        temp.next = node.next;
        temp = node.next;
        if (temp != null)
            temp.prev = node.prev;
            
        node.next = head;
        head.prev = node;
        node.prev = null;
        head = node;
    }
    
    public Solution(int capacity) {
        head = null;
        tail = null;
        MAX = capacity;
        N = 0;
        mMap = new HashMap<>();
    }
    
    public int get(int key) {
        if (N == 0)
            return -1;
        
        if (mMap.containsKey(key)) {
            Node node = mMap.get(key);
            
            if (key == head.key) {
                return node.val;
            }
            if (tail.key == key) {
                tail = tail.prev;
            }
            
            updateAccessList(node);
            
            return node.val;
        }
        
        
        return -1;
    }
    
    public void set(int key, int value) {
        
        if (mMap.containsKey(key)) {
            
            Node node = mMap.get(key);
            
            if (node.key == head.key) {
                node.val = value;
                return;
            }
            
            if (tail.key == key) {
                tail = tail.prev;
            }
            
            updateAccessList(node);
            
            node.val = value;
            
            return;
        }
        
        if (N == MAX) {
            if (tail != null) {
                mMap.remove(tail.key);
                tail = tail.prev;
                
                if (tail != null) {
                    tail.next.prev = null;
                    tail.next = null;
                }
                N--;
            }
        }
        
        Node node = new Node(key, value);
        node.next = head;
        if (head != null)
            head.prev = node;
    
        head = node;
        N++;
        
        if (N == 1)
            tail = head;
        
        mMap.put(key, node);    
    }
}
```
* * Solution in Javascript
```javascript
/** Not available **/
```
* * Solution in C++
```cpp
class Node {
    public:
        int key;
    int val;
    Node * prev;
    Node * next;
    Node(int key, int val) {
        this -> key = key;
        this -> val = val;
        this -> prev = NULL;
        this -> next = NULL;
    }
};

Node * head;
Node * tail;
int N;
int MAX;
map < int, Node * > mMap;

void updateAccessList(Node * node){
    Node * temp = node -> prev;
    temp -> next = node -> next;
    temp = node -> next;
    if (temp != NULL)
        temp -> prev = node -> prev;

    node -> next = head;
    head -> prev = node;
    node -> prev = NULL;
    head = node;
}

LRUCache::LRUCache(int capacity) {
    head = NULL;
    tail = NULL;
    MAX = capacity;
    N = 0;
    mMap.clear();
}

int LRUCache::get(int key) {
    if (N == 0)
        return -1;

    if (mMap.find(key) != mMap.end()) {
        Node * node = mMap[key];
        
        if (key == head -> key) {
            return node -> val;
        }
        if (tail -> key == key) {
            tail = tail -> prev;
        }

        updateAccessList(node);

        return node -> val;
    }

    return -1;
}

void LRUCache::set(int key, int value) {

    if (mMap.find(key) != mMap.end()) {
        Node * node = mMap[key];

        if (node -> key == head -> key) {
            node -> val = value;
            return;
        }
        if (tail -> key == key) {
            tail = tail -> prev;
        }

        updateAccessList(node);

        node -> val = value;

        return;
    }

    if (N == MAX) {
        if (tail != NULL) {
            mMap.erase(tail -> key);
            tail = tail -> prev;

            if (tail != NULL) {
                tail -> next -> prev = NULL;
                tail -> next = NULL;
            }
            N--;
        }
    }

    Node * node = new Node(key, value);
    node -> next = head;
    if (head != NULL)
        head -> prev = node;

    head = node;
    N++;

    if (N == 1)
        tail = head;

    mMap[key] = node;
}
```

