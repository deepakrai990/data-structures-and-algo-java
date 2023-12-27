package com.scaler.core.java_2_intermediate.dsa_25_class_and_object_basics.homework.qhomewor1;

import java.util.Scanner;

/**
 * @created 21/02/23 1:30 pm
 * @project scaler_course_code
 * @author Deepak Kumar Rai
 */
public class Matrix {
    // Define properties here
    int row;
    int column;
    int[][] data;

    // Define constructor here
    Matrix(int row, int column) {
        this.row = row;
        this.column = column;
        this.data = new int[row][column];
    }

    void input(Scanner sc) {
        // Use the Scanner object passed as argument for taking input and not a new Scanner object
        // Complete the function
        for (int i = 0; i < this.row; i++) {
            for (int j = 0; j < this.column; j++) {
                this.data[i][j] = sc.nextInt();
            }
        }
    }

    Matrix add(Matrix x) {
        // Complete the function
        Matrix A = this;
        if (x.row != A.row || x.column != A.column) throw new RuntimeException("Illegal matrix dimensions.");
        Matrix C = new Matrix(this.row, this.column);
        for (int i = 0; i < this.row; i++) {
            for (int j = 0; j < this.column; j++) {
                C.data[i][j] = A.data[i][j] + x.data[i][j];
            }
        }
        return C;
    }

    Matrix subtract(Matrix x) {
        // Complete the function
        Matrix A = this;
        if (x.row != A.row || x.column != A.column) throw new RuntimeException("Illegal matrix dimensions.");
        Matrix C = new Matrix(this.row, this.column);
        for (int i = 0; i < this.row; i++) {
            for (int j = 0; j < this.column; j++) {
                C.data[i][j] = A.data[i][j] - x.data[i][j];
            }
        }
        return C;
    }

    Matrix transpose() {
        // Complete the function
        Matrix A = new Matrix(this.column, this.row);
        for (int i = 0; i < this.row; i++) {
            for (int j = 0; j < this.column; j++) {
                A.data[j][i] = this.data[i][j];
            }
        }
        return A;
    }

    void print() {
        // Complete the function
        for (int i = 0; i < this.row; i++) {
            for (int j = 0; j < this.column; j++) {
                System.out.print(this.data[i][j] + " ");
            }
            System.out.println();
        }
    }
}
