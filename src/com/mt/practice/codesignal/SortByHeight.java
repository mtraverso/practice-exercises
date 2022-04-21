package com.mt.practice.codesignal;

import java.util.Arrays;

/**
 * Some people are standing in a row in a park. There are trees between them which cannot be moved. Your task is to rearrange the people by their heights in a non-descending order without moving the trees. People can be very tall!
 *
 * Example
 *
 * For a = [-1, 150, 190, 170, -1, -1, 160, 180], the output should be
 * solution(a) = [-1, 150, 160, 170, -1, -1, 180, 190].
 *
 * Input/Output
 *
 * [execution time limit] 3 seconds (java)
 *
 * [input] array.integer a
 *
 * If a[i] = -1, then the ith position is occupied by a tree. Otherwise a[i] is the height of a person standing in the ith position.
 *
 * Guaranteed constraints:
 * 1 ≤ a.length ≤ 1000,
 * -1 ≤ a[i] ≤ 1000.
 *
 * [output] array.integer
 *
 * Sorted array a with all the trees untouched.
 */

public class SortByHeight {

	public static void main(String[] args) {
		System.out.println(Arrays.toString(new SortByHeight().solution(new int[]{-1, 150, 190, 170, -1, -1, 160, 180}))); // [-1, 150, 160, 170, -1, -1, 180, 190]
	}

	int[] solution(int[] a) {
		int[] people = Arrays.stream(a).filter(i -> i != -1).toArray();
		Arrays.sort(people);
		int peopleCounter = 0;
		for(int i = 0; i< a.length; i++){
			if(a[i] != -1){
				a[i] = people[peopleCounter++];
			}
		}
		return a;
	}

}
