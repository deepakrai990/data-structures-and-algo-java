### Q4. Time Complexity-ii
#### Problem Description
```text
What is the time complexity of the following code snippet?
```
<ul >
    <li>C++</li>
    <li>Java</li>
    <li>Python</li>
</ul>

<pre>
vector v;
int n;
for(int i = 0; i &lt; n; i++){
    v.push_back(i);
}
sort(v.begin(), v.end());
</pre>

<pre>
ArrayList v = new ArrayList();
for(int i = 0; i &lt; n; i++){
    v.append(i);
}
Collections.sort(v);
</pre>

<pre>
v = []
for i in range(n):
    v.append(i)

v.sort()
</pre>

#### Options
```text
1. O(n)
2. O(n log n)
3. O(1)
4. O(n^2)
5. None of the above
```

* Solution Approach
```text
Calculate the time complexity of sorting function only
```
* Complete Solution
```text
Since sorting an array cost O(n log n) and appending an element 
to the back of array is O(1).

The overall time complexity will be O(n log n).
```
