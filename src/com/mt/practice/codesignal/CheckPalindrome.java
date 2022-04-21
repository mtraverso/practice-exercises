package com.mt.practice.codesignal;

/**
 * Given the string, check if it is a palindrome.
 *
 * Example
 *
 * For inputString = "aabaa", the output should be
 * solution(inputString) = true;
 * For inputString = "abac", the output should be
 * solution(inputString) = false;
 * For inputString = "a", the output should be
 * solution(inputString) = true.
 * Input/Output
 *
 * [execution time limit] 3 seconds (java)
 *
 * [input] string inputString
 *
 * A non-empty string consisting of lowercase characters.
 *
 * Guaranteed constraints:
 * 1 ≤ inputString.length ≤ 105.
 *
 * [output] boolean
 *
 * true if inputString is a palindrome, false otherwise.
 */
public class CheckPalindrome {
	public static void main(String[] args) {
		new CheckPalindrome().solution("aabaa"); // true
		new CheckPalindrome().solution("a"); // true
		new CheckPalindrome().solution("zzzazzazz"); // false

	}

	boolean solution(String inputString) {
		char[] letters = inputString.toCharArray();
		for(int i =0 ; i< letters.length/2; i++){
			if(letters[i] != letters[letters.length-1-i]){
				return false;
			}
		}
		return true;
	}
}
