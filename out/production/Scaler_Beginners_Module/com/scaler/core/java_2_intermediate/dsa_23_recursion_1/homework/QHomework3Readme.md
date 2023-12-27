### Q3. Simple Recursion
#### Problem Description
```text
What will be the output of following program ?
```
<ul>
    <li>C++</li>
    <li>Java</li>
    <li>Python</li>
</ul>

```cpp
#include <bits/stdc++.h>
using namespace std;

int bar(int x, int y){
    if (y == 0)   return 0;
    return (x + bar(x, y-1));
}

int foo(int x, int y){
    if (y == 0) return 1;
    return bar(x, foo(x, y-1));
}

int main(){
    cout &lt;&lt; foo(3, 5);
}
```
```java
public class solve {
    static int bar(int x, int y) {
        if (y == 0) return 0;
        return (x + bar(x, y - 1));
    }

    static int foo(int x, int y) {
        if (y == 0) return 1;
        return bar(x, foo(x, y - 1));
    }

    public static void main(String[] args) {
        System.out.println(foo(3, 5));
    }
}
```

```python
def bar(x, y):
    if y == 0:
        return 0
    return (x + bar(x, y-1))

def foo(x, y):
    if(y == 0):
        return 1
    return bar(x, foo(x, y-1))

print(foo(3, 5))
```

#### Options
```text
1. 243
2. 15
3. 18
4. 125
```

* Solution Approach
```text
Try to find the recurrence relation of the recursive 
function or try to dry run the code.
```
* Complete Solution
<div>
    <p>Recurrence relation for bar(x,y)<br>is</p>
    <pre>bar(x, y) = x + bar(x, y−1) = 2x + bar(x, y−2) = … = yx 
    + bar(x, 0) = yx</pre>
    <p>That is bar(x,y)<br>
    returns the product of x and y</p>
    <p>Now, recurrence relation for foo</p>
    <p>is</p>
    <pre>foo(a, b) = a × foo(a, b−1) = a × a × foo(a, b−2) = … = ab × foo(a, 0) = ab × 1 = ab</pre>
    <p>The given code returns a<sup>b</sup></p>
</div>

