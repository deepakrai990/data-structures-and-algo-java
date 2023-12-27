### Q3. Free Cars
#### Problem Description
<div style="background-color: #f9f9f9; padding: 5px 10px;">
    <p>Given two arrays, <strong>A</strong> and <strong>B</strong> of size 
    <strong>N</strong>. <strong>A[i]</strong> represents the time by which you can 
    buy the <strong>i<sup>th</sup></strong> car without paying any money.</p>
    <p><strong>B[i]</strong> represents the profit you can earn by buying the 
    <strong>i<sup>th</sup></strong> car. It takes <strong>1</strong> minute to buy a 
    car, so you can only buy the <strong>i<sup>th</sup></strong> car when the 
    <strong>current time &lt;= A[i] - 1</strong>.</p>
    <p>Your task is to find the <strong>maximum profit</strong> one can earn by 
    buying cars considering that you can only buy <strong>one car at a time.</strong></p>
    <p><strong>NOTE: </strong></p>
    <ul>
        <li>You can start buying from time = 0.</li>
        <li>Return your answer modulo 10<sup>9</sup> + 7.</li>
    </ul>
</div>

#### Problem Constraints
<div style="background-color: #f9f9f9; padding: 5px 10px;">
    <p>1 &lt;= N &lt;= 10<sup>5</sup><br>
    1 &lt;= A[i] &lt;= 10<sup>9</sup><br>
    0 &lt;= B[i] &lt;= 10<sup>9</sup></p>
</div>

```text
1 <= N <= 10^5
1 <= A[i] <= 10^9
0 <= B[i] <= 10^9
```
#### Input Format
```text
The first argument is an integer array A represents the deadline for buying the cars.

The second argument is an integer array B represents the profit obtained after buying 
the cars.
```
#### Output Format
```text
Return an integer denoting the maximum profit you can earn.
```
#### Example Input
```text
Input 1:
 A = [1, 3, 2, 3, 3]
 B = [5, 6, 1, 3, 9]

Input 2:
 A = [3, 8, 7, 5]
 B = [3, 1, 7, 19]
```
#### Example Output
```text
Output 1:
 20

Output 2:
 30
```
#### Example Explanation
```text
Explanation 1:
    At time 0, buy car with profit 5.
    At time 1, buy car with profit 6.
    At time 2, buy car with profit 9.
    At time = 3 or after , you can't buy any car, as there is no car with deadline >= 4.
    So, total profit that one can earn is 20.

Explanation 2:
     At time 0, buy car with profit 3.
     At time 1, buy car with profit 1.
     At time 2, buy car with profit 7.
     At time 3, buy car with profit 19.
     We are able to buy all cars within their deadline. So, total profit that one 
     can earn is 30.
```
### Hints
* Hint 1
```text
Suppose there are two cars you can buy at ith time with profit p1 and p2 respectively 
and you can buy only one car.

Which car should you prefer to buy in order to maximize the profit?
```
* Solution Approach
```text
If at any time we have the option to buy a car which gives more profit than any of the 
car already taken.

At a particular time, We can buy a car or not.

If we are able to buy all the cars, then it’s fine. If not then we should remove a car 
with minimum profit which we had bought earlier and take the car with more profit.

Think why this will give us maximum profit.
```
* Complete Solution
* * Solution in Java
```java
public class Solution {
    public int solve(int[] A, int[] B) {
        int mod = (int)1e9 + 7;
        int n = A.length;
        PriorityQueue < Integer > pending = new PriorityQueue<Integer>(Collections.reverseOrder());
    
        ArrayList<pair> v = new ArrayList<pair>();
    
        for (int i = 0; i < n; i++){
            v.add(new pair(A[i], B[i]));
        }
    
        Collections.sort(v);
    
        int ans = 0;
        int tim = v.get(n-1).first - 1;
        for (int i = n - 1; i >= 0; i--) {
            while (tim >= v.get(i).first && pending.size() > 0) {
                tim--;
                ans = (ans + pending.poll()) % mod;
            }
            if (pending.size() == 0)
                tim = v.get(i).first - 1;
            pending.add(v.get(i).second);
        }
        while (tim >= 0 && pending.size() > 0) {
            tim--;
            ans = (ans + pending.poll()) % mod;
        }
        return ans;
    }
    class pair implements Comparable <pair> {
        int first;
        int second;
        public pair(int a, int b){
            this.first = a;
            this.second = b;
        }
        //@Override
        public int compareTo(pair b){
            if(this.first == b.first)
                return -(b.second - this.second);
            else
                return -(b.first - this.first);
        }
    }
}
```
* * Solution in Javascript
```javascript
module.exports = {
	solve: function(A, B) {
		let n = A.length;
		let v = [];
		for (let i = 0; i < n; i++) {
			v.push([A[i], B[i]]);
		}
		v.sort((a, b) => {
			if (a[0] == b[0]) return a[1] - b[1];
			return a[0] - b[0];
		});

		let curTime = 0,
			i = 0;

		let pq = new PriorityQueue(1);

		while (i < n) {
			if (v[i][0] > curTime) {
				pq.push(v[i][1]);
				curTime += 1;
			} else {
				if (pq.top() < v[i][1]) {
					pq.pop();
					pq.push(v[i][1]);
				}
			}
			i++;
		}

		let ans = 0,
			Mod = 1000000007;
		while (!pq.empty()) {
			ans += pq.pop();
			ans %= Mod;
		}
		return ans;
	},
};

class PriorityQueue {
	constructor(fct) {
		this.heap = [];
		this.fct = fct;
	}
	top() {
		if (this.heap.length == 0) return undefined;
		return this.heap[0] * this.fct;
	}
	push(node) {
		this.heap.push(node * this.fct);
		let id = this.heap.length - 1;
		let par = Math.floor((id - 1) / 2);

		while (id > 0 && this.heap[id] < this.heap[par]) {
			[this.heap[id], this.heap[par]] = [this.heap[par], this.heap[id]];
			id = Math.floor((id - 1) / 2);
			par = Math.floor((id - 1) / 2);
		}
	}
	pop() {
		let ret = this.heap[0];
		this.heap[0] = this.heap[this.heap.length - 1];
		this.heap.pop();
		this.recurDown(0);
		return ret * this.fct;
	}
	recurDown(node) {
		let l = node * 2 + 1;
		let r = node * 2 + 2;

		let cur = node;
		if (l < this.heap.length && this.heap[cur] > this.heap[l]) cur = l;
		if (r < this.heap.length && this.heap[cur] > this.heap[r]) cur = r;
		if (cur != node) {
			[this.heap[node], this.heap[cur]] = [this.heap[cur], this.heap[node]];
			this.recurDown(cur);
		}
	}
	size() {
		return this.heap.length;
	}
	empty() {
		return this.heap.length == 0;
	}
}
```
* * Solution in C++
```cpp
// Method 1

int Solution::solve(vector < int > & A, vector < int > & B) {
    int n = A.size();
    vector < pair < int, int >> v;
    for (int i = 0; i < n; i++) {
        v.push_back({
            A[i],
            B[i]
        });
    }
    sort(v.begin(), v.end());
    set < pair < int, int >> s;
    int curTime = 0, i = 0;
    priority_queue < int, vector < int > , greater < int >> pq;

    while (i < n) {
        // we can buy the ith car
        if (v[i].first > curTime) {
            pq.push(v[i].second);
            curTime += 1;
        } else {
            // reomve the already buy car giving minimum profit
            if (pq.top() < v[i].second) {
                pq.pop();
                pq.push(v[i].second);
            }
        }
        i++;
    }

    long long int ans = 0, Mod = 1000000007;
    while (!pq.empty()) {
        ans += pq.top();
        ans %= Mod;
        pq.pop();
    }
    return ans;
}

// Method 2

int Solution::solve(vector < int > & A, vector < int > & B) {
    int mod = 1e9 + 7;
    priority_queue < int > pending;

    vector < pair < int, int > > v;

    for (int i = 0; i < A.size(); i++)
        v.push_back(make_pair(A[i], B[i]));

    sort(v.begin(), v.end());

    int ans = 0;
    int tim = v.back().first - 1;
    for (int i = A.size() - 1; i >= 0; i--) {
        while (tim >= v[i].first and pending.size()) {
            tim--;
            ans = (ans + pending.top()) % mod;
            pending.pop();
        }
        if (pending.empty())
            tim = v[i].first - 1;
        pending.push(v[i].second);
    }
    while (tim >= 0 and pending.size()) {
        tim--;
        ans = (ans + pending.top()) % mod;
        pending.pop();
    }
    return ans;
}
```

