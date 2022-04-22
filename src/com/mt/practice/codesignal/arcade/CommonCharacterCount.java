package com.mt.practice.codesignal.arcade;

import java.util.HashMap;
import java.util.Map;

/**
 * Given two strings, find the number of common characters between them.
 *
 * Example
 *
 * For s1 = "aabcc" and s2 = "adcaa", the output should be
 * solution(s1, s2) = 3.
 *
 * Strings have 3 common characters - 2 "a"s and 1 "c".
 *
 * Input/Output
 *
 * [execution time limit] 3 seconds (java)
 *
 * [input] string s1
 *
 * A string consisting of lowercase English letters.
 *
 * Guaranteed constraints:
 * 1 ≤ s1.length < 15.
 *
 * [input] string s2
 *
 * A string consisting of lowercase English letters.
 *
 * Guaranteed constraints:
 * 1 ≤ s2.length < 15.
 *
 * [output] integer
 */
public class CommonCharacterCount {
	public static void main(String[] args) {
		System.out.println(new CommonCharacterCount().solution("aabcc", "adcaa")); // 3
	}

	int solution(String s1, String s2) {
		int commonCharCount = 0;
		Map<Character, Integer> ocurrencesByCharString1 = new HashMap<>();
		Map<Character, Integer> ocurrencesByCharString2 = new HashMap<>();
		for(Character c : s1.toCharArray()){
			ocurrencesByCharString1.put(c,ocurrencesByCharString1.computeIfAbsent(c, val -> 0)+1);
		}

		for(Character c : s2.toCharArray()){
			ocurrencesByCharString2.put(c,ocurrencesByCharString2.computeIfAbsent(c, val -> 0)+1);
		}

		for(Character c : ocurrencesByCharString1.keySet()){
			commonCharCount+= Math.min(ocurrencesByCharString1.getOrDefault(c, 0), ocurrencesByCharString2.getOrDefault(c, 0));
		}

		return commonCharCount;
	}
}
