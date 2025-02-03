package practice.linearRecurrencesAndMatrixExponentiation.MatrixExponentional;

import java.util.Scanner;

/**
 * @author Atul.Dhadse 
 * suppose this is a square matrix
 */
class Matrix {

	int n;
	long[][] mat;
	static final int MOD = 1_000_000_000 + 7;

	Matrix(int n) {
		this.n = n;
		mat = new long[n][n];
	}

	public void identity() {
		for (int i = 0; i < n; i++) {
			mat[i][i] = 1l;
		}
	}

	public void multiply(Matrix mat2) {
		long[][] temp = new long[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				for (int k = 0; k < n; k++) {
					temp[i][j] = (temp[i][j] + (this.mat[i][k] * mat2.mat[k][j]) % MOD) % MOD;
				}
			}
		}
		this.mat = temp;
	}

	public void print() {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print(mat[i][j] + " ");
			}
			System.out.println();
		}
	}
	
}

public class FibonacciUsingMatrixExponent {

	static Scanner scn = new Scanner(System.in);

	public static long calculateFibonacci(long n) {
		if (n <= 2) {
			return 1l;
		}
		Matrix T = new Matrix(2);
		long[][] mat = {{1, 1}, {1, 0}};
		T.mat = mat;
		n -= 2;
		Matrix res = new Matrix(2);
		res.identity();
		while (n > 0) {
			if ((n & 1) != 0) {
				res.multiply(T);
			}
			n /= 2;
			T.multiply(T);
		}
		return (res.mat[0][0]) + (res.mat[0][1]) % Matrix.MOD;
	}
	
	public static void main(String[] args) {
		long n = scn.nextLong();
		System.out.println(calculateFibonacci(n));
	}

}
