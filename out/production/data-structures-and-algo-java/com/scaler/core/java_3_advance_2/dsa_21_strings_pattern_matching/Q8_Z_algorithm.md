### Solution in Java
```java
class z_algo {
    //  prints all occurrences of pattern in text using
    // Z algo
    public static void find(String text, String pattern) {
        // Create concatenated string "P$T"
        String concat = pattern + "$" + text;
        int l = concat.length();
        int Z[] = new int[l];
        // Construct Z array
        create_Zarr(concat, Z);
        // now looping through Z array for matching condition
        for (int i = 0; i < l; ++i) {
            // if Z[i] (matched region) is equal to pattern
            // length we got the pattern
            if (Z[i] == pattern.length()) {
                System.out.println("Pattern found at index "
                        + (i - pattern.length() - 1));
            }
        }
    }

    // Fills Z array for given string str[]
    private static void create_Zarr(String str, int[] Z) {
        int n = str.length();
        // [left,right] make a window which matches with
        // prefix of s
        int left = 0, right = 0;
        for (int i = 1; i < n; ++i) {
            // if i>right nothing matches so we will calculate.
            // Z[i] using naive way.
            if (i > right) {
                left = right = i;
                while (right < n && str.charAt(right - left) == str.charAt(right))
                    right++;
                Z[i] = right - left;
                right--;
            } else {
                // k = i-left so k corresponds to number which
                // matches in [left,right] interval.
                int k = i - left;
                if (Z[k] < right - i + 1)
                    Z[i] = Z[k];
                else {
                    // else start from right and check manually
                    left = i;
                    while (right < n && str.charAt(right - left) == str.charAt(right))
                        right++;
                    Z[i] = right - left;
                    right--;
                }
            }
        }
    }

    // Driver program
    public static void main(String[] args) {
        String text = "faabbcdeffghiaaabbcdfgaabf";
        String pattern = "aabb";
        find(text, pattern);
    }
}

```

### Solution in Javascript
```javascript

```

### Solution in C++
```c++
#include<iostream>
using namespace std;
 
void create_Zarr(string str, int Z[])
{
    int n = str.length();
    int left, right, k;
 
    // [left,right] make a window which matches with prefix of str
    left = right = 0;
    for (int i = 1; i < n; ++i)
    {
        // if i>right nothing matches so we will calculate.
        // Z[i] using naive way.
        if (i > right)
        {
            left = right = i;
            // right-left = 0 in starting, so it will start
            // checking from 0'th index. 
            while (right<n && str[right-left] == str[right])
                right++;
            Z[i] = right-left;
            right--;
        }
        else
        {
            // k = i-left so k corresponds to number which
            // matches in [left,right] interval.
            k = i-left;
            // if Z[k] is less than remaining interval
            // then Z[i] will be equal to Z[k]. 
            if (Z[k] < right-i+1)
                Z[i] = Z[k];
            else
            {
                // else start from right and check manually
                left = i;
                while (right<n && str[right-left] == str[right])
                    right++;
                Z[i] = right-left;
                right--;
            }
        }
    }
}
void find(string text, string pattern)
{
    // Create concatenated string "P$T with additional character"
    string concat = pattern + "$" + text;
    int l = concat.length();
 
    // Constructing Z array
    int Z[l];
    create_Zarr(concat, Z);
 
    // now looping through Z array for matching condition
    for (int i = 0; i < l; ++i)
    {
        // if Z[i] (matched region) is equal to pattern
        // length we got the pattern
        if (Z[i] == pattern.length())
            cout << "Pattern found at index "
                << i - pattern.length() -1 << endl;
    }
}
// Driver program
int main()
{
    string text = "faabbcdeffghiaaabbcdfgaabf";
    string pattern = "aabb";
    find(text, pattern);
    return 0;
}
```

### Solution in Python
```python
# Fills Z array for given string str[]
def create_Zarr(string, z):
    n = len(string)
 
    # [L,R] make a window which matches
    # with prefix of s
    left, right, k = 0, 0, 0
    for i in range(1, n):
 
        # if i>R nothing matches so we will calculate.
        # Z[i] using naive way.
        if i > right:
            left, right = i, i
 
            # R-L = 0 in starting, so it will start
            # checking from 0'th index.
            while right < n and string[right - left] == string[right]:
                right += 1
            z[i] = right - left
            right -= 1
        else:
 
            # k = i-L so k corresponds to number which
            # matches in [L,R] interval.
            k = i - left
 
            # if Z[k] is less than remaining interval
            # then Z[i] will be equal to Z[k].
            
            if z[k] < right - i + 1:
                z[i] = z[k]
 
           
            else:
 
                # else start from R and check manually
                left = i
                while right < n and string[right - left] == string[right]:
                    right += 1
                z[i] = right - left
                right -= 1
 
# prints all occurrences of pattern
# in text using Z algo
def find(text, pattern):
 
    # Create concatenated string "P$T"
    concat = pattern + "$" + text
    left = len(concat)
 
    # Construct Z array
    z = [0] * left
    create_Zarr(concat, z)
 
    # now looping through Z array for matching condition
    for i in range(left):
 
        # if Z[i] (matched region) is equal to pattern
        # length we got the pattern
        if z[i] == len(pattern):
            print("Pattern found at index",
                      i - len(pattern) - 1)
 
# Driver Code
if __name__ == "__main__":
    text = "faabbcdeffghiaaabbcdfgaabf"
    pattern = "aabb"
    find(text, pattern)

```