# Parallel Matrix–Vector Multiplication in Java

Implementation of matrix–vector multiplication (A * v) using multithreading in Java.

This project focuses on parallel computation by utilizing k threads (where k is a power of 2) to efficiently compute the result vector.

## 📚 Information
- Course: PLH 47
- Assignment: Matrix–Vector Multiplication with Threads
- Language: Java

## 📝 Description

Given a matrix A of size n × m and a vector v of size m × 1, where:

- n is a power of 2  
- k (number of threads) is also a power of 2  
- n > k  

the program computes the product A * v, producing a vector of size n × 1.

The program:

- Initializes matrix A and vector v with random values in the range [0, 10]
- Uses k threads to perform the computation in parallel
- Each thread processes a subset of the matrix rows
- Combines partial results into the final output vector
- Measures execution time for different numbers of threads

## 🛠️ Technologies
- Java
- Java Threads
- System.nanoTime() for timing measurements
