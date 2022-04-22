package com.mt.practice.codesignal.arcade;

/**
 * Below we will define an n-interesting polygon. Your task is to find the area of a polygon for a given n.
 *
 * A 1-interesting polygon is just a square with a side of length 1. An n-interesting polygon is obtained by taking the n - 1-interesting polygon and appending 1-interesting polygons to its rim, side by side. You can see the 1-, 2-, 3- and 4-interesting polygons in the picture below.
 *
 *
 *
 * Example
 *
 * For n = 2, the output should be
 * solution(n) = 5;
 * For n = 3, the output should be
 * solution(n) = 13.
 * Input/Output
 *
 * [execution time limit] 3 seconds (java)
 *
 * [input] integer n
 *
 * Guaranteed constraints:
 * 1 ≤ n < 104.
 *
 * [output] integer
 *
 * The area of the n-interesting polygon.
 */
public class ShapeArea {

	public static void main(String[] args) {
		new ShapeArea().solution(2); // 5
		new ShapeArea().solution(3); // 13
		new ShapeArea().solution(1); // 1
		new ShapeArea().solution(8999); // 161946005
	}

	int solution(int n) {
		int squares = 0;
		for (int i = 0; i<n; i++){
			squares+=(2*i)+1;
		}
		for (int i = n-2; i>=0; i--){

			squares+=(2*i)+1;
		}
		return squares;
	}
}
