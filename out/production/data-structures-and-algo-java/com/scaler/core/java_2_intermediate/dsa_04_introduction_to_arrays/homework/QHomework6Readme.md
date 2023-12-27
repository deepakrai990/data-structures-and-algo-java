### Q6. Problems on 1D Arrays-2 MCQ D
#### Problem Description
```text
What will be the output of the following code?
```
```java
class Main {
    static void fun(int[] arr) {
        arr[3] = 98;
        return;
    }
    
    public static void main(String args[]) {
        int[] arr = {10, 20, 30, 40, 50};
        fun(arr);
        System.out.println(arr[3]);
    }
}
```

#### Options
```text
1. 40
2. 30
3. 98
4. Error
```
* Complete Solution
```text
Correct answer -> 98 will get printed
```
