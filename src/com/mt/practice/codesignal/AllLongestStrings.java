package com.mt.practice.codesignal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Given an array of strings, return another array containing all of its longest strings.
 *
 * Example
 *
 * For inputArray = ["aba", "aa", "ad", "vcd", "aba"], the output should be
 * solution(inputArray) = ["aba", "vcd", "aba"].
 *
 * Input/Output
 *
 * [execution time limit] 3 seconds (java)
 *
 * [input] array.string inputArray
 *
 * A non-empty array.
 *
 * Guaranteed constraints:
 * 1 ≤ inputArray.length ≤ 10,
 * 1 ≤ inputArray[i].length ≤ 10.
 *
 * [output] array.string
 *
 * Array of the longest strings, stored in the same order as in the inputArray.
 */
public class AllLongestStrings {
	public static void main(String[] args) {
		System.out.println(Arrays.toString(new AllLongestStrings().solution(new String[]{"aba", "aa", "ad", "vcd", "aba"})));
		System.out.println(Arrays.toString(new AllLongestStrings().solution2(new String[]{"aba", "aa", "ad", "vcd", "aba"})));
	}

	String[] solution(String[] inputArray) {
		int longestStringsChars = 0;
		List<String> resultingArray = new ArrayList<>();
		for (String s : inputArray) {
			if (s.length() > longestStringsChars) {
				longestStringsChars = s.length();
			}
		}
		for (String s : inputArray) {
			if (s.length() == longestStringsChars) {
				resultingArray.add(s);
			}
		}
		return resultingArray.toArray(new String[0]);
	}

	String[] solution2(String[] inputArray) {
		Map<Integer, List<String>> valuesPerSize = new HashMap<>();

		for (String s : inputArray) {
			valuesPerSize.computeIfAbsent(s.length(), val -> new ArrayList<>()).add(s);
		}

		int max = Collections.max(valuesPerSize.keySet());
		return valuesPerSize.get(max).toArray(new String[0]);
	}
}
