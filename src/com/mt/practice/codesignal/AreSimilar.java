package com.mt.practice.codesignal;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Two arrays are called similar if one can be obtained from another by swapping at most one pair of elements in one of the arrays.
 * <p>
 * Given two arrays a and b, check whether they are similar.
 * <p>
 * Example
 * <p>
 * For a = [1, 2, 3] and b = [1, 2, 3], the output should be
 * solution(a, b) = true.
 * <p>
 * The arrays are equal, no need to swap any elements.
 * <p>
 * For a = [1, 2, 3] and b = [2, 1, 3], the output should be
 * solution(a, b) = true.
 * <p>
 * We can obtain b from a by swapping 2 and 1 in b.
 * <p>
 * For a = [1, 2, 2] and b = [2, 1, 1], the output should be
 * solution(a, b) = false.
 * <p>
 * Any swap of any two elements either in a or in b won't make a and b equal.
 * <p>
 * Input/Output
 * <p>
 * [execution time limit] 3 seconds (java)
 * <p>
 * [input] array.integer a
 * <p>
 * Array of integers.
 * <p>
 * Guaranteed constraints:
 * 3 ≤ a.length ≤ 105,
 * 1 ≤ a[i] ≤ 1000.
 * <p>
 * [input] array.integer b
 * <p>
 * Array of integers of the same length as a.
 * <p>
 * Guaranteed constraints:
 * b.length = a.length,
 * 1 ≤ b[i] ≤ 1000.
 * <p>
 * [output] boolean
 * <p>
 * true if a and b are similar, false otherwise.
 */
public class AreSimilar {
	public static void main(String[] args) {
		System.out.println(new AreSimilar().solution(new int[]{1, 2, 3}, new int[]{1, 2, 3})); // true
		System.out.println(new AreSimilar().solution(new int[]{1, 2, 3}, new int[]{2, 1, 3})); // true
		System.out.println(new AreSimilar().solution(new int[]{1, 2, 2}, new int[]{2, 1, 1})); // false
		System.out.println(new AreSimilar().solution(new int[]{1, 2, 3, 4}, new int[]{2, 3, 1, 4})); // false
		System.out.println(new AreSimilar().solution(new int[]{1, 1, 4}, new int[]{1, 2, 3})); // false
	}

	boolean solution(int[] a, int[] b) {

		int cnt = 0;
		boolean result = false;

		for (int i = 0; i < a.length; i++) {
			if (a[i] != b[i]) {
				cnt++;
			}
		}

		Arrays.sort(a);
		Arrays.sort(b);

		if (Arrays.equals(a, b)) {
			if (cnt <= 2) {
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}

	boolean solution3(int[] a, int[] b) {
		int countDifferences = 0;
		Map<Integer, Integer> valuesInA = new HashMap<>();

		for (Integer i : a) {
			valuesInA.merge(i, 1, Integer::sum);
		}

		for (int i = 0; i < a.length; i++) {
			if (a[i] != b[i]) {
				if (valuesInA.get(b[i]) != null) {
					countDifferences++;
				} else {
					return false;
				}
			}
		}
		return countDifferences <= 2;
	}

	boolean solution2(int[] a, int[] b) {
		if (Arrays.equals(a, b)) {
			return true;
		}
		for (int i = 0; i < a.length; i++) {
			for (int j = i + 1; j < a.length; j++) {
				swap(a, i, j);
				if (Arrays.equals(a, b)) {
					return true;
				}
				swap(a, i, j);
			}
		}
		return false;
	}

	void swap(int[] a, int i, int j) {
		int tmp = a[i];
		a[i] = a[j];
		a[j] = tmp;
	}
}
