## Hint 1
```text
Any number can be written in the sum of the power of 10’s

For example: 123 = (1 * 100) + (2 * 10) + (3)
Similarly, 1234 = (1 * 1000) + (2 * 100) + (3 * 10) + 4

Try to use the above fact to find a solution to the problem.
```
## Solution Approach
```text
Step by step process for better understanding of how the algorithm works.
Let the number be 12345.
Step 1-> 12345 % 10 which is equal-too 5 + ( send 12345/10 to next step ),
Step 2-> 1234 % 10 which is equal-too 4 + ( send 1234/10 to next step ),
Step 3-> 123 % 10 which is equal-too 3 + ( send 123/10 to next step ),
Step 4-> 12 % 10 which is equal-too 2 + ( send 12/10 to next step ),
Step 5-> 1 % 10 which is equal-too 1 + ( send 1/10 to next step ),
Step 6-> 0 algorithm stops.
Following diagram will illustrate the process of recursion.
```
![alt text](QHomework2.png)
```java
public class Solution {
    public int solve(int A) {
        return sum_of_digit(A);
    }
    static int sum_of_digit(int n) {  
        if (n == 0) 
            return 0; 
        return (n % 10 + sum_of_digit(n / 10)); 
    }
}
```