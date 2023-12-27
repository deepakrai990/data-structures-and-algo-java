### Q1. Class Matrix
#### Problem Description
```text
Construct a class called Matrix which stores a 2D Array. It should store

The number of rows

The number of columns

The 2D Array itself

Implement the following functionalities inside this class :-

input() -> Reads the input from the user. This method 
           should read the input from the user and populate the 
           entire array. Each row will be in a new line and all 
           the elements in a row will be space-separated.

add(Matrix) -> Returns the sum of two matrices. Assume 
               the matrices provided have the same dimensions.

subtract(Matrix) -> Returns the sum of two matrices. Assume 
                    the matrices provided have the same dimensions.

transpose() -> Returns a new matrix containing the transpose 
               of the given original matrix.

print() -> prints the entire matrix row by row. Each row 
           will be in a new line and values in each row should be 
           separated by a single space.

You may define any properties in the class as you see appropriate.
```

* Complete Solution
* * Solution in Java
```java
static class Matrix {
    // Define properties here
    int row, column;
    int[][] mat;

    // Define constructor here
    Matrix(int r, int c) {
        this.row = r;
        this.column = c;
        this.mat = new int[r][c];
    }

    void input(Scanner sc) {
        // Use the Scanner object passed as argument for taking input and not a new Scanner object
        // Complete the function
        for (int i = 0; i < this.row; i++) {
            for (int j = 0; j < this.column; j++) {
                mat[i][j] = sc.nextInt();
                ;
            }
        }
    }

    Matrix add(Matrix x) {
        // Complete the function
        Matrix res = new Matrix(this.row, this.column);
        for (int i = 0; i < this.row; i++) {
            for (int j = 0; j < this.column; j++) {
                res.mat[i][j] = this.mat[i][j] + x.mat[i][j];
            }
        }
        return res;
    }

    Matrix subtract(Matrix x) {
        // Complete the function
        Matrix res = new Matrix(this.row, this.column);
        for (int i = 0; i < this.row; i++) {
            for (int j = 0; j < this.column; j++) {
                res.mat[i][j] = this.mat[i][j] - x.mat[i][j];
            }
        }
        return res;
    }

    Matrix transpose() {
        // Complete the function
        Matrix res = new Matrix(this.column, this.row);
        for (int i = 0; i < this.row; i++) {
            for (int j = 0; j < this.column; j++) {
                res.mat[j][i] = this.mat[i][j];
            }
        }
        return res;
    }

    void print() {
        // Complete the function
        for (int i = 0; i < this.row; i++) {
            for (int j = 0; j < this.column; j++) {
                System.out.print(this.mat[i][j] + " ");
            }
            System.out.print("\n");
        }
    }
}
```
* * Solution in Javascript
```javascript
class Matrix {
    // Define constructor here
    constructor(r, c) {
        this.row = r;
        this.column = c;
        this.mat = Array.from(Array(r), e => Array(c));
    }

    input() {
        // Complete the function
        // use readLine() to read individual integers/strings
        for (let i = 0; i < this.row; i++) {
            var inp = readLine().split(" ");
            for (let j = 0; j < this.column; j++) {
                this.mat[i][j] = Number(inp[j]);
            }
        }
    }

    add(x) {
        // Complete the function
        let res = new Matrix(this.row, this.column);
        for (let i = 0; i < this.row; i++) {
            for (let j = 0; j < this.column; j++) {
                res.mat[i][j] = this.mat[i][j] + x.mat[i][j];
            }
        }
        return res;
    }

    subtract(x) {
        // Complete the function
        let res = new Matrix(this.row, this.column);
        for (let i = 0; i < this.row; i++) {
            for (let j = 0; j < this.column; j++) {
                res.mat[i][j] = this.mat[i][j] - x.mat[i][j];
            }
        }
        return res;
    }

    transpose() {
        // Complete the function
        let res = new Matrix(this.column, this.row);
        for (let i = 0; i < this.row; i++) {
            for (let j = 0; j < this.column; j++) {
                res.mat[j][i] = this.mat[i][j];
            }
        }
        return res;
    }

    print() {
        // Complete the function
        for (let i = 0; i < this.row; i++) {
            for (let j = 0; j < this.column; j++) {
                process.stdout.write(this.mat[i][j] + " ");
            }
            process.stdout.write("\n");
        }
    }
};

/*
    a = new Matrix(10, 5)  // 10 rows, 5 columns
	a.input() 
	b = new Matrix(10, 5)  // 10 rows, 5 columns
	b.input()
    c1 = a.add(b)
    c2 = a.subtract(b)
    c3 = a.transpose()
    a.print()
*/
```
* * Solution in C++
```cpp
class Matrix {
	public :
	    // Define properties here
		int row, column;
		vector<vector<int>> mat;
		
		// Define constructor here
		Matrix(int r, int c){
			this->row = r;
			this->column = c;
			mat.resize(r, vector<int>(c, 0));
		}
		
		void input(){
			// Complete the function
			for(int i = 0 ; i < this->row ; i++){
				for(int j = 0 ; j < this->column ; j++){
					cin>>mat[i][j];
				}
			}
		}
		
		Matrix add(Matrix x){
			// Complete the function
			Matrix res = Matrix(this->row , this->column);
			for(int i = 0 ; i < this->row ; i++){
				for(int j = 0 ; j < this->column ; j++){
					res.mat[i][j] = this->mat[i][j] + x.mat[i][j];
				}
			}
			return res;
		}
		
		Matrix subtract(Matrix x){
			// Complete the function
			Matrix res = Matrix(this->row , this->column);
			for(int i = 0 ; i < this->row ; i++){
				for(int j = 0 ; j < this->column ; j++){
					res.mat[i][j] = this->mat[i][j] - x.mat[i][j];
				}
			}
			return res;
		}
		
		Matrix transpose(){
			// Complete the function
			Matrix res = Matrix(this->column , this->row);
			for(int i = 0 ; i < this->row ; i++){
				for(int j = 0 ; j < this->column ; j++){
					res.mat[j][i] = this->mat[i][j];
				}
			}
			return res;
		}
		
		void print(){
			// Complete the function
			for(int i = 0 ; i < this->row ; i++){
				for(int j = 0 ; j < this->column ; j++){
					cout<<this->mat[i][j]<<" ";
				}
				cout<<endl;
			}
		}
};
```