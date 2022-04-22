package com.mt.practice.codesignal.arcade;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a string, find out if its characters can be rearranged to form a palindrome.
 *
 * Example
 *
 * For inputString = "aabb", the output should be
 * solution(inputString) = true.
 *
 * We can rearrange "aabb" to make "abba", which is a palindrome.
 *
 * Input/Output
 *
 * [execution time limit] 3 seconds (java)
 *
 * [input] string inputString
 *
 * A string consisting of lowercase English letters.
 *
 * Guaranteed constraints:
 * 1 ≤ inputString.length ≤ 50.
 *
 * [output] boolean
 *
 * true if the characters of the inputString can be rearranged to form a palindrome, false otherwise.
 */

public class PalindromeRearranging {
	public static void main(String[] args) {
		//System.out.println(new PalindromeRearranging().solution("aabb")); // true

		System.out.println(new PalindromeRearranging().solution("abbcabb")); // true
	}

	boolean solution(String inputString) {
		Map<Character, Integer> charMap = new HashMap<>();
		for(int i = 0; i< inputString.toCharArray().length; i++) {
			charMap.merge(inputString.toCharArray()[i], 1, Integer::sum);
		}
		int oddCount = (int) charMap.values().stream().filter(val -> val % 2 == 1).count();
		return oddCount <= 1;
	}
}
