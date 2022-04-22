package com.mt.practice.codesignal.arcade;

/**
 * Ticket numbers usually consist of an even number of digits. A ticket number is considered lucky if the sum of the first half of the digits is equal to the sum of the second half.
 * <p>
 * Given a ticket number n, determine if it's lucky or not.
 * <p>
 * Example
 * <p>
 * For n = 1230, the output should be
 * solution(n) = true;
 * For n = 239017, the output should be
 * solution(n) = false.
 * Input/Output
 * <p>
 * [execution time limit] 3 seconds (java)
 * <p>
 * [input] integer n
 * <p>
 * A ticket number represented as a positive integer with an even number of digits.
 * <p>
 * Guaranteed constraints:
 * 10 ≤ n < 106.
 * <p>
 * [output] boolean
 * <p>
 * true if n is a lucky ticket number, false otherwise.
 */

public class IsLucky {
	public static void main(String[] args) {
		System.out.println(new IsLucky().solution(1230)); // true
		System.out.println(new IsLucky().solution(239017)); // false
	}

	boolean solution(int n) {
		String value = String.valueOf(n);
		String firstPart = value.substring(0, value.length() / 2);
		String secondPart = value.substring(value.length() / 2);
		int firstPartSum = getSum(firstPart);
		int secondPartSum = getSum(secondPart);
		return firstPartSum == secondPartSum;
	}

	private int getSum(String firstPart) {
		return firstPart.chars().mapToObj(i -> (char) i)
				.mapToInt(Character::getNumericValue)
				.sum();
	}
}
