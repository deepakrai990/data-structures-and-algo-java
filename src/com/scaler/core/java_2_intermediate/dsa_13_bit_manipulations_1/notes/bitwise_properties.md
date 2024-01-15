### Bitwise properties refer to certain characteristics and rules that apply to bitwise operations in programming languages like Java. Understanding these properties is crucial for effectively using bitwise operations and ensuring the correctness of your code. Let's explore some important bitwise properties:
### 1. Identity Properties:
* 0b11001100 = 204
* 0b00110011 = 51
* 0b11110000 = 240
#### Identity for AND (&):
* Any number ANDed with 0 is 0.
```java
int A = 0b11001100;
int result = A & 0;
// the result will be 0
```
#### Identity for OR (|):
* Any number ORed with 0 is itself
```java
int A = 0b11001100;
int result = A | 0;
// the result will be x (unchanged)
```
#### Identity for XOR (^):
* Any number XORed with 0 is itself.
```java
int A = 0b11001100;
int result = A ^ 0;
// the result will be x (unchanged)
```

### 2. Zero Properties:
#### Zero for AND (&):
* Any number ANDed with 1 is itself.
```java
int A = 0b11001100;
int result = A & 1;
// the result will be x (unchanged)
```
#### Zero for OR (|):
* Any number ORed with 1 is 1.
```java
int A = 0b11001100;
int result = A | 1;
// the result will be 1
```
#### Zero for XOR (^):
* Any number XORed with itself is 0.
```java
int A = 0b11001100;
int result = A ^ A;
// the result will be 0
```

### 3. Complement Properties:
#### Complement for AND (&):
* Any number ANDed with its complement is 0.
```java
int A = 0b11001100;
int result = A & ~A;
// the result will be 0
```
#### Complement for OR (|):
* Any number ORed with its complement is all 1s.
```java
int A = 0b11001100;
int result = A | ~A;
// the result will be all 1s
```
#### Complement for XOR (^):
* XORing a number with its complement is all 1s.
```java
int A = 0b11001100;
int result = A ^ ~A;
// the result will be all 1s
```
### 4. Shift Properties:
#### Left Shift (<<):
* Shifting a number to the left is equivalent to multiplying by 2.
```java
int A = 0b11001100;
int result = A << 1;
// the result will be 0b110011000
```
#### Right Shift (>>):
* Shifting a number to the right is equivalent to dividing by 2 (for positive integers).
```java
int A = 0b11001100;
int result = A >> 1;
// the result will be 0b01100110
```
#### Unsigned Right Shift (>>>):
* Unsigned right shift fills in with zeros, similar to right shift.
```java
int A = 0b11001100;
int result = S >>> 1;
// result will be 0b01100110
```

### 4. Commutative Property
* Bitwise commutative properties state that the order of operands does not affect the result of certain bitwise operations. The commutative properties are applicable to the bitwise AND (`&`), OR (`|`), and XOR (`^`) operations. Let's explore each of these properties:
#### 1. Commutative Property for AND (`&`):
* The bitwise AND operation is commutative. This means that the result of `a & b` is the same as the result of `b & a`. In other words, the order of operands does not matter.
```java
int a = 0b11001100;
int b = 0b00110011;

// Commutative property for AND
int result1 = a & b;
int result2 = b & a;

// result1 and result2 will be the same
```
#### 2. Commutative Property for OR (`|`):
* The bitwise OR operation is also commutative. This means that the result of `a | b` is the same as the result of `b | a`.
```java
int a = 0b11001100;
int b = 0b00110011;

// Commutative property for OR
int result1 = a | b;
int result2 = b | a;

// result1 and result2 will be the same
```
#### 3. Commutative Property for XOR (`^`):
* The bitwise XOR operation is commutative as well. This means that the result of `a ^ b` is the same as the result of `b ^ a`.
```java
int a = 0b11001100;
int b = 0b00110011;

// Commutative property for XOR
int result1 = a ^ b;
int result2 = b ^ a;

// result1 and result2 will be the same
```

### Associative Property
* Bitwise associative properties state that the grouping of operands does not affect the result of certain bitwise operations. The associative properties are applicable to the bitwise AND (`&`), OR (`|`), and XOR (`^`) operations. Let's explore each of these properties:
#### 1. Associative Property for AND (`&`):
* The bitwise AND operation is associative. This means that the result of `(a & b) & c` is the same as the result of `a & (b & c)`. In other words, the grouping of operands with parentheses does not affect the final result.
```java
int a = 0b11001100;
int b = 0b00110011;
int c = 0b11110000;

// Associative property for AND
int result1 = (a & b) & c;
int result2 = a & (b & c);

// result1 and result2 will be the same
```
#### 2. Associative Property for OR (`|`):
* The bitwise OR operation is also associative. This means that the result of `(a | b) | c` is the same as the result of `a | (b | c)`.
```java
int a = 0b11001100;
int b = 0b00110011;
int c = 0b11110000;

// Associative property for OR
int result1 = (a | b) | c;
int result2 = a | (b | c);

// result1 and result2 will be the same
```
#### 3. Associative Property for XOR (`^`):
* The bitwise XOR operation is associative as well. This means that the result of `(a ^ b) ^ c` is the same as the result of `a ^ (b ^ c)`.
```java
int a = 0b11001100;
int b = 0b00110011;
int c = 0b11110000;

// Associative property for XOR
int result1 = (a ^ b) ^ c;
int result2 = a ^ (b ^ c);

// result1 and result2 will be the same
```
