## Q3. Time and Space Complexity - II
#### Problem Description
```text
Find the time and space complexity for printing sum of each subarray?
```

```java
public class Solution {
    void printSums(int ar[]) {
        int n = ar.length;

        int pf[] = new int[n];
        pf[0] = ar[0];
        for (int i = 1; i < n; i++) {
            pf[i] = pf[i - 1] + ar[i];
        }

        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                if (i == 0) {
                    print(pf[j]);
                } else {
                    print(pf[j] - pf[i - 1]);
                }
            }
        }
    }
}
```
### Options
```text
1. TC = O(N) , SC = O(1)
2. TC = O(N^2) , SC = O(1)
3. TC = O(N) , SC = O(N)
4. TC = O(N^2) , SC = O(N)
```
* Complete Solution
```text
Complete Solution
The time complexity of the given code is O(N^2) while
the space complexity is O(N).
```