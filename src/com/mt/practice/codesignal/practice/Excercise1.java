package com.mt.practice.codesignal.practice;

/**
 * You are given an array of integers numbers and two integers left and right. You task is to calculate a boolean array result, where result[i] = true if there exists an integer x, such that numbers[i] = (i + 1) * x and left ≤ x ≤ right. Otherwise, result[i] should be set to false.
 * <p>
 * Example
 * <p>
 * For numbers = [8, 5, 6, 16, 5], left = 1, and right = 3, the output should be solution(numbers, left, right) = [false, false, true, false, true].
 * <p>
 * For numbers[0] = 8, we need to find a value of x such that 1 * x = 8, but the only value that would work is x = 8 which doesn't satisfy the boundaries 1 ≤ x ≤ 3, so result[0] = false.
 * For numbers[1] = 5, we need to find a value of x such that 2 * x = 5, but there is no integer value that would satisfy this equation, so result[1] = false.
 * For numbers[2] = 6, we can choose x = 2 because 3 * 2 = 6 and 1 ≤ 2 ≤ 3, so result[2] = true.
 * For numbers[3] = 16, there is no an integer 1 ≤ x ≤ 3, such that 4 * x = 16, so result[3] = false.
 * For numbers[4] = 5, we can choose x = 1 because 5 * 1 = 5 and 1 ≤ 1 ≤ 3, so result[4] = true.
 * Input/Output
 * <p>
 * [execution time limit] 3 seconds (java)
 * <p>
 * [input] array.integer numbers
 * <p>
 * An array of integers.
 * <p>
 * Guaranteed constraints:
 * 1 ≤ numbers.length ≤ 100,
 * 1 ≤ numbers[i] ≤ 106.
 * <p>
 * [input] integer left
 * <p>
 * An integer representing the lower bound for x.
 * <p>
 * Guaranteed constraints:
 * 1 ≤ left ≤ 104.
 * <p>
 * [input] integer right
 * <p>
 * An integer representing the upper bound for x.
 * <p>
 * Guaranteed constraints:
 * 1 ≤ left ≤ right ≤ 104.
 * <p>
 * [output] array.boolean
 * <p>
 * A boolean array result described above.
 */
public class Excercise1 {
	public static void main(String[] args) {
		int[] numbers = new int[]{8, 5, 6, 16, 5};
		int left = 1;
		int right = 3;

		System.out.println(print(new Excercise1().solution(numbers, left, right)));
	}

	boolean[] solution(int[] numbers, int left, int right) {
		boolean[] result = new boolean[numbers.length];
		for (int i = 0; i < numbers.length; i++) {

			if (numbers[i] / (i + 1) >= left && numbers[i] / (i+1) <= right) {
				if(numbers[i] % (i+1) != 0){
					result[i]= false;
				}else {
					result[i] = true;
				}
			} else {
				result[i] =false;
			}
		}
		return result;
	}

	static String print(boolean[] array){
		StringBuilder builder = new StringBuilder("[");
		for(boolean b : array){
			builder.append(b);
			builder.append(", ");
		}
		builder.deleteCharAt(builder.length()-1);
		builder.append("]");
		return builder.toString();
	}
}
