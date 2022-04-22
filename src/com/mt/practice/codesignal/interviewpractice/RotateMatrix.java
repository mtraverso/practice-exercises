package com.mt.practice.codesignal.interviewpractice;

import java.util.Arrays;

/**
 * Note: Try to solve this task in-place (with O(1) additional memory), since this is what you'll be asked to do during an interview.
 *
 * You are given an n x n 2D matrix that represents an image. Rotate the image by 90 degrees (clockwise).
 *
 * Example
 *
 * For
 *
 * a = [[1, 2, 3],
 *      [4, 5, 6],
 *      [7, 8, 9]]
 * the output should be
 *
 * solution(a) =
 *     [[7, 4, 1],
 *      [8, 5, 2],
 *      [9, 6, 3]]
 * Input/Output
 *
 * [execution time limit] 3 seconds (java)
 *
 * [input] array.array.integer a
 *
 * Guaranteed constraints:
 * 1 ≤ a.length ≤ 100,
 * a[i].length = a.length,
 * 1 ≤ a[i][j] ≤ 104.
 *
 * [output] array.array.integer
 */
public class RotateMatrix {
	public static void main(String[] args) {
		System.out.println(Arrays.deepToString(new RotateMatrix().solution(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}})));
	}

	int[][] solution(int[][] a) {
		int n = a.length;
		for(int layer = 0; layer< (n/2); layer++){
			int first = layer;
			int last = n - layer - 1;
			for(int j = first; j< last;j++){
				int offset = j - first;
				int tmp = a[first][j]; // Top left element
				a[first][j] = a[last-offset][first];
				a[last-offset][first] = a[last][last-offset];
				a[last][last-offset] = a[j][last];
				a[j][last] = tmp;

			}
		}
		return a;
	}
}
