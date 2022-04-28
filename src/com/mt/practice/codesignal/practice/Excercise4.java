package com.mt.practice.codesignal.practice;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;

/**
 * You are given two arrays of integers a and b, and two integers lower and upper. Your task is to find the number of
 * pairs (i, j) such that lower ≤ a[i] * a[i] + b[j] * b[j] ≤ upper.
 * <p>
 * Example
 * <p>
 * For a = [3, -1, 9], b = [100, 5, -2], lower = 7, and upper = 99, the output should be solution(a, b, lower, upper) = 4.
 * <p>
 * There are only four pairs that satisfy the requirement:
 * <p>
 * If i = 0 and j = 1, then a[0] = 3, b[1] = 5, and 7 ≤ 3 * 3 + 5 * 5 = 9 + 25 = 36 ≤ 99.
 * If i = 0 and j = 2, then a[0] = 3, b[2] = -2, and 7 ≤ 3 * 3 + (-2) * (-2) = 9 + 4 = 13 ≤ 99.
 * If i = 1 and j = 1, then a[1] = -1, b[1] = 5, and 7 ≤ (-1) * (-1) + 5 * 5 = 1 + 25 = 26 ≤ 99.
 * If i = 2 and j = 2, then a[2] = 9, b[2] = -2, and 7 ≤ 9 * 9 + (-2) * (-2) = 81 + 4 = 85 ≤ 99.
 * For a = [1, 2, 3, -1, -2, -3], b = [10], lower = 0, and upper = 100, the output should be solution(a, b, lower, upper) = 0.
 * <p>
 * Since the array b contains only one element 10 and the array a does not contain 0, it is not possible to satisfy 0 ≤ a[i] * a[i] + 10 * 10 ≤ 100.
 * <p>
 * Input/Output
 * <p>
 * [execution time limit] 3 seconds (java)
 * <p>
 * [input] array.integer a
 * <p>
 * A first array of integers.
 * <p>
 * Guaranteed constraints:
 * 1 ≤ a.length ≤ 105,
 * -104 ≤ a[i] ≤ 104.
 * <p>
 * [input] array.integer b
 * <p>
 * A second array of integers.
 * <p>
 * Guaranteed constraints:
 * 1 ≤ b.length ≤ 105,
 * -104 ≤ b[i] ≤ 104.
 * <p>
 * [input] integer lower
 * <p>
 * An integer representing a lower bound of a satisfiable square sum.
 * <p>
 * Guaranteed constraints:
 * 0 ≤ lower ≤ 109.
 * <p>
 * [input] integer upper
 * <p>
 * An integer representing an upper bound of a satisfiable square sum.
 * <p>
 * Guaranteed constraints:
 * lower ≤ upper,
 * 0 ≤ upper ≤ 109.
 * <p>
 * [output] integer
 * <p>
 * The number of pairs (i, j) such, that lower ≤ a[i] * a[i] + b[j] * b[j] ≤ upper. It is guaranteed that the answer fits in 32-bit value type.
 */
public class Excercise4 {
	public static void main(String[] args) {
		int[] a = new int[]{3, -1, 9};
		int[] b = new int[]{100, 5, -2};
		int lower = 7;
		int upper = 99;
		long timeStart = System.currentTimeMillis();
		int solution = new Excercise4().solution(a, b, lower, upper);
		long timeEnd = System.currentTimeMillis();

		System.out.println(solution + " " + ((timeEnd - timeStart)) / 1000);  //4
	}

	private static Integer[] buildArray(int n) {
		Random random = new Random(2);
		Integer[] array = new Integer[n];
		for (int i = 0; i < n; i++) {
			array[i] = random.nextInt() % 10;
		}
		return array;
	}

	int solution(int[] a, int[] b, int lower, int upper) {
		int count = 0;

		Arrays.sort(a);
		Arrays.sort(b);
		int left = b.length-1;
		int right = b.length-1;

		for (int i = 0; i < a.length; i++) {
			while(left >= 0 && a[i]*a[i]+b[left]*b[left] >= lower){
				left--;
			}

			while(right >= 0 && a[i]*a[i]+b[right]*b[right] > upper){
				right--;
			}

			if(right > left){
				count += right-left;
			}
		}
		return count;
	}

	// O(n2) does not pass all tests
	int solutionProposed(int[] a, int[] b, int lower, int upper){
			int count = 0;
			for(int i = 0; i< a.length;i++){
				for (int j = 0; j< b.length; j++){
					if(a[i]*a[i] + b[j]*b[j] >= lower && a[i]*a[i] + b[j]*b[j] <= upper){
						count++;
					}
				}
			}
			return count;
	}
}
