## Post-lecture Content

### StringBuilder

```text
It also provides us mutable strings but here we lack thread 
safety. It cannot be used by multiple threads simultaneously. Since 
the class is not applying this extra feature like StringBuffer 
here it becomes faster than it.
```
* Syntax

```java
StringBuilder a = new StringBuilder("Scaler");
```
* Code
```java
StringBuilder temp = new StringBuilder();
//Initial size of object
System.out.println(temp.capacity());
StringBuilder a= new StringBuilder("String");
System.out.println(a);
//updating the string
a.append(" Articles");
System.out.println(a);
a=new StringBuilder("InterviewBit");
System.out.println(a);
```
* Output
```text
16
String
String Articles
InterviewBit
```