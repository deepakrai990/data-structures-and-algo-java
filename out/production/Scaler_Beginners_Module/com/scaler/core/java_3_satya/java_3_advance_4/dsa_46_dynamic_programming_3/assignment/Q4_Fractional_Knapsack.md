### Q4. Fractional Knapsack
#### Problem Description
```text
Given two integer arrays A and B of size N each which represent values and weights 
associated with N items respectively.

Also given an integer C which represents knapsack capacity.

Find out the maximum total value that we can fit in the knapsack. If the maximum total 
value is ans, then return ⌊ans × 100⌋ , i.e., floor of (ans × 100).

NOTE:
    * You can break an item for maximizing the total value of the knapsack
```
#### Problem Constraints
<div style="background-color: #f9f9f9; padding: 5px 10px;">
    <p>1 &lt;= N &lt;= 10<sup>5</sup></p>
    <p>1 &lt;= A[i], B[i] &lt;= 10<sup>3</sup></p>
    <p>1 &lt;= C &lt;= 10<sup>3</sup></p>
</div>

```text
1 <= N <= 10^5

1 <= A[i], B[i] <= 10^3

1 <= C <= 10^3
```
#### Input Format
```text
First argument is an integer array A of size N denoting the values on N items.

Second argument is an integer array B of size N denoting the weights on N items.

Third argument is an integer C denoting the knapsack capacity.
```
#### Output Format
```text
Return a single integer denoting the maximum total value of A such that 
sum of the weights of this subset is smaller than or equal to C.
```
#### Example Input
```text
Input 1:
 A = [60, 100, 120]
 B = [10, 20, 30]
 C = 50

Input 2:
 A = [10, 20, 30, 40]
 B = [12, 13, 15, 19]
 C = 10
```
#### Example Output
```text
Output 1:
 24000

Output 2:
 2105
```
#### Example Explanation
```text
Explanation 1:
    Taking the full items with weight 10 and 20 and 2/3 of the item with weight 30 will 
    give us the maximum value i.e 60 + 100 + 80 = 240. So we return 24000.

Explanation 2:
    Taking 10/19 the fourth item gives us the maximum value i.e. 21.0526. So we return 2105.
```
### Hints
* Hint 1
```text
Try choosing the best item everytime. How will we sort
to find the best item ?
```
* Solution Approach
```text
We will sort the items by there A[i] / B[i] ratio or (value / weight) ratio
in descending order. Then we keep choosing the first element till our knapsack
is not filled. The last item maybe be present in fractional amount.

Time Complexity : O(NlogN)
Space Complexity : O(N)
```
* Complete Solution
* * Solution in Java
```java
public class Solution {
    class Items {
        double cost;
        double weight, value, ind;
        Items(int weight, int value, int ind){
            this.weight = weight;
            this.value = value;
            this.ind = ind;
            this.cost = new Double((double)value / (double)weight);
        }
    }
    
    public int solve(int[] A, int[] B, int C) {
        Items[] iVal = new Items[A.length];
        for (int i = 0; i < A.length; i++) {
            iVal[i] = new Items(B[i], A[i], i);
        }
        Arrays.sort(iVal, new Comparator<Items>() {
            @Override
            public int compare(Items o1, Items o2){
                if(o1.cost >= o2.cost){
                    return -1;
                }
                return 1;
            }
        });
        double totalValue = 0d;
        for (Items i : iVal) {
            int curWt = (int)i.weight;
            int curVal = (int)i.value;
            if (C - curWt >= 0) {
                C = C - curWt;
                totalValue += curVal;
            }
            else {
                double fraction = ((double)C / (double)curWt);
                totalValue += (curVal * fraction);
                C = (int)(C - (curWt * fraction));
                break;
            }
        }
        return (int)(totalValue * 100);
    }
}
```
* * Solution in Javascript
```javascript
module.exports = {
    //param A : array of integers
    //param B : array of integers
    //param C : integer
    //return an integer
    solve: function (A, B, C) {
        let n = A.length;
        let vp = [];
        for (let i = 0; i < n; i++) {
            let temp = A[i] / B[i];
            vp.push([temp, i]);
        }
        vp.sort((a, b) => a[0] - b[0]);
        let ans = 0;
        for (let i = n - 1; i >= 0; i--) {
            if (C == 0) {
                break;
            }
            let idx = vp[i][1];
            let wt = Math.min(C, B[idx]);
            C -= wt;
            ans += (vp[i][0] * wt);
        }
        return Math.floor(ans * 100);
    }
};
```
* * Solution in C++
```cpp
int Solution::solve(vector<int> &A, vector<int> &B, int C) {
    int n = A.size();
    vector<pair<double,int>> vp;
    for(int i = 0 ; i < n ; i ++){
        double temp = (double)(A[i]) / (double)(B[i]);
        vp.push_back({temp, i});
    }
    sort(vp.begin(), vp.end());
    double ans = 0;
    for(int i = n - 1 ; i >= 0 ; i--){
        if(C == 0){
            break;
        }
        int idx = vp[i].second;
        int wt = min(C, B[idx]);
        C -= wt;
        ans += (vp[i].first * wt);
    }
    return (int)(ans * 100);
}
```

