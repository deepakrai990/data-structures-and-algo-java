## Pre-lecture Content
Arrays -

Array is defined as an ordered set of similar data items. All the 
data items of an array are stored in consecutive memory locations 
in RAM. The elements of an array are of the same data type and each 
item can be accessed using the same name.

Reference - https://www.scaler.com/topics/data-structures/array-data-structure/


Why do arrays have O(1) access time?

An array starts at a specific memory address. Each element occupies the 
same amount of bytes element_size. The array elements are located one 
after another in the memory from the start address on. So you can 
calculate the memory address of the 
element i with start + i * element_size. 

This computation is independent of the array size and is therefore O(1).

Ref - https://stackoverflow.com/a/23103837

Dynamic Arrays in different languages -

c++ (Vectors): https://www.scaler.com/topics/cpp/vector-in-cpp/



Java (ArrayList): https://www.interviewbit.com/problems/arraylist/

Concept of Autoboxing and Unboxing 
in Java - https://slides.com/tarunluthra/autoboxing-java



Python (List): https://www.scaler.com/topics/python/list-in-python/



Javascript (Array): https://www.scaler.com/topics/array-methods-in-javascript/ 
