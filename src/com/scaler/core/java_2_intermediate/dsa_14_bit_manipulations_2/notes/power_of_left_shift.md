### Power of left shift (`<<`) with OR (`|`), XOR (`^`), and AND (`&`)
* The left shift operation (`<<`) is often used in combination with OR (`|`), XOR (`^`), and AND (`&`) operations to set, toggle, and check specific bits in an integer, respectively. Let's explore how these operations can be applied using left shift and provide pseudocode in Java for each case:
#### 1. Setting a Bit using OR (`|`) with Left Shift (`<<`):
* To set a specific bit at position `pos`, you can use the left shift operation to create a mask with only the bit at position `pos` set to 1, and then use OR to set that bit in the original number.
```java
public class SetBitExample {
    public static int setBit(int num, int pos) {
        // Use left shift to create a mask with only the bit at position pos set to 1
        int mask = 1 << pos;
        // Use OR to set the bit at position pos in the original number
        return num | mask;
    }
    public static void main(String[] args) {
        int originalNumber = 0b00001010; // Example: original number
        int positionToSet = 2; // Set A bit at position 2
        // Set the bit at positionToSet using OR with left shift
        int result = setBit(originalNumber, positionToSet);
        // Print the result
        System.out.println("Result after setting bit: " + Integer.toBinaryString(result));
    }
}
```

#### 2. Toggling a Bit using XOR (`^`) with Left Shift (`<<`):
* To toggle a specific bit at position `pos`, you can use the left shift operation to create a mask with only the bit at position `pos` set to 1, and then use XOR to toggle that bit in the original number.
```java
public class ToggleBitExample {
    public static int toggleBit(int num, int pos) {
        // Use left shift to create a mask with only the bit at position pos set to 1
        int mask = 1 << pos;
        // Use XOR to toggle the bit at position pos in the original number
        return num ^ mask;
    }

    public static void main(String[] args) {
        int originalNumber = 0b00001010; // Example: original number
        int positionToToggle = 2; // Toggle A bit at position 2
        // Toggle the bit at positionToToggle using XOR with left shift
        int result = toggleBit(originalNumber, positionToToggle);
        // Print the result
        System.out.println("Result after toggling bit: " + Integer.toBinaryString(result));
    }
}

```

#### 3. Checking a Bit using AND (`&`) with Left Shift (`<<`):
* To check the value of a specific bit at position `pos`, you can use the left shift operation to create a mask with only the bit at position `pos` set to 1, and then use AND to check that bit in the original number.
```java
public class CheckBitExample {
    public static boolean checkBit(int num, int pos) {
        // Use left shift to create a mask with only the bit at position pos set to 1
        int mask = 1 << pos;
        // Use AND to check the bit at position pos in the original number
        return (num & mask) != 0;
    }

    public static void main(String[] args) {
        int originalNumber = 0b00001010; // Example: original number
        int positionToCheck = 2; // Check bit at position 2
        // Check the value of the bit at positionToCheck using AND with left shift
        boolean result = checkBit(originalNumber, positionToCheck);
        // Print the result
        System.out.println("Bit at positionToCheck is set: " + result);
    }
}
```

