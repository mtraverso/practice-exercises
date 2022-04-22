package com.mt.practice.codesignal.interviewpractice;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a string s consisting of small English letters, find and return the first instance of a non-repeating character in it. If there is no such character, return '_'.
 *
 * Example
 *
 * For s = "abacabad", the output should be
 * solution(s) = 'c'.
 *
 * There are 2 non-repeating characters in the string: 'c' and 'd'. Return c since it appears in the string first.
 *
 * For s = "abacabaabacaba", the output should be
 * solution(s) = '_'.
 *
 * There are no characters in this string that do not repeat.
 *
 * Input/Output
 *
 * [execution time limit] 3 seconds (java)
 *
 * [input] string s
 *
 * A string that contains only lowercase English letters.
 *
 * Guaranteed constraints:
 * 1 ≤ s.length ≤ 105.
 *
 * [output] char
 *
 * The first non-repeating character in s, or '_' if there are no characters that do not repeat.
 */
public class FirstNonRepeatingCharacter {
	public static void main(String[] args) {
		System.out.println(new FirstNonRepeatingCharacter().solution("abacabad")); // c
		System.out.println(new FirstNonRepeatingCharacter().solution("abacabaabacaba")); // _
	}

	char solution(String s) {
		Map<Character, Integer> charactersRepetitions = new HashMap<>();
		s.indexOf('c');
		char[] chars = s.toCharArray();
		for (char aChar : chars) {
			charactersRepetitions.merge(aChar, 1, Integer::sum);
		}
		for (char aChar : chars) {
			if (charactersRepetitions.get(aChar) == 1) {
				return aChar;
			}
		}
		return '_';
	}
}
