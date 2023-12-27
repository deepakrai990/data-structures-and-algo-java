# Overview 

An Array is a special fixed-length container that holds a collection of values having a 
common data type. A two-dimensional array is an array of arrays i.e., it's a collection 
of arrays in which elements are arranged in rows and columns (tabular format). 
We can access the elements using both the row index and column index

## Scope of the Article

* This article provides an overview of two-dimensional arrays in Java.
* The article covers all the theoretical aspects related to 2D array in Java along with their
implementation in the Java programming language.
* The overall article meets the desired scope.

## Introduction to 2D Array in Java

Data represented in tabular form (organized in rows and columns) is a very effective means 
for communicating many different types of information. For example, we use tables 
to represent our expenditure or daily schedule, etc. In short, we generally use a 
rectangular grid (a collection of rows and columns) to organize the data.

In Java, this tabular representation of data is implemented using a two-dimensional array. 
A two-dimensional array (or 2D array in Java) is a linear data structure that is used to 
store data in tabular format.

![alt text](/Users/deepakkumar/Desktop/deepak/workspace_related/intellij_workspace/Scaler_Beginners_Module/src/com/scaler/core/utils/files_readme/img.png)

In Java, an array is a homogeneous collection of a fixed number of values that are stored 
in contiguous memory locations i.e., the elements are of the same type (homogeneous data) 
and are linearly placed in memory such that each element is connected to its previous and 
the next element.

Java treats the two-dimensional array as an array of multiple one-dimensional 
arrays i.e., it is a collection of various one-dimensional arrays. Hence, 
when we create a 2D array object, Java creates a simple one-dimensional array that 
references (points to) other one-dimensional arrays which form the rows of the 2D array.

![alt text](/Users/deepakkumar/Desktop/deepak/workspace_related/intellij_workspace/Scaler_Beginners_Module/src/com/scaler/core/utils/files_readme/img_1.png)

Hence, in Java, a two-dimensional array is a collection of pointers, where each pointer 
refers to a one-dimensional array that represents a particular row of the 2D array.

## Two Dimensional Array Declaration in Java

Since a 2D array consists of rows and columns, we need two indices, one to refer rows and 
the other to a particular column in that row. Hence, the syntax of declaring a 
two-dimensional array is similar to that of a one-dimensional array with the exception 
of having two square brackets instead of one:

```text
DataType[][] ArrayName;
```

Here, the **_DataType_** describes the type of values that the array can store, while the 
**_ArrayName_** is the reference variable for the two-dimensional array object.

The above-described syntax only declares the array i.e., the memory is allocated for the 
array object but the values will be added later.

## Create Two Dimensional Array in Java

In Java, everything including the array data structure is treated as objects. Hence, 
to create a two-dimensional array object we need to use the new keyword as shown below:

```text
// Declaring 2D array
DataType[][] ArrayName;

// Creating a 2D array
ArrayName = new DataType[r][c];
```
Here, the new **_DataType[r][c]_** statement creates a two dimensional array object that 
contains **_r_** rows and **_c_** columns and elements of **_DataType_** type. This array object is 
referenced by the reference variable **_ArrayName_**.

Let's understand the creation of Java's two-dimensional array with an example:

```text
//Declaring 2D array
int[][] a;

//Creating a 2D array
a = new int[3][3];
```

Here, the reference variable **_a_** points to a two-dimensional array object that represents 
a **_3X3_** integer matrix _i.e._, the array object contains **_3_** rows and **_3_** columns, 
and can only store integer **_(int)_** values.

```text
Note: When we create a 2D array object using the new keyword, the JVM (Java Virtual Machine)
allocates the memory required for the two-dimensional array and initializes the memory 
spaces with the default values according to the data type of the array object. 
For example, in the case of the Integer array (int[][]), every element of the array 
is initialized with the default value of 0.
```
## Java Two Dimensional Array of Primitive Type





