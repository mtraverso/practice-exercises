package com.mt.practice.codesignal.arcade;

import java.util.Stack;

/**
 * Write a function that reverses characters in (possibly nested) parentheses in the input string.
 *
 * Input strings will always be well-formed with matching ()s.
 *
 * Example
 *
 * For inputString = "(bar)", the output should be
 * solution(inputString) = "rab";
 * For inputString = "foo(bar)baz", the output should be
 * solution(inputString) = "foorabbaz";
 * For inputString = "foo(bar)baz(blim)", the output should be
 * solution(inputString) = "foorabbazmilb";
 * For inputString = "foo(bar(baz))blim", the output should be
 * solution(inputString) = "foobazrabblim".
 * Because "foo(bar(baz))blim" becomes "foo(barzab)blim" and then "foobazrabblim".
 * Input/Output
 *
 * [execution time limit] 3 seconds (java)
 *
 * [input] string inputString
 *
 * A string consisting of lowercase English letters and the characters ( and ). It is guaranteed that all parentheses in inputString form a regular bracket sequence.
 *
 * Guaranteed constraints:
 * 0 ≤ inputString.length ≤ 50.
 *
 * [output] string
 *
 * Return inputString, with all the characters that were in parentheses reversed.
 */
public class ReverseInParenthesis {
	public static void main(String[] args) {
		System.out.println(new ReverseInParenthesis().solution("(bar)")); // rab
		System.out.println(new ReverseInParenthesis().solution("foo(bar)baz")); // foorabbaz
		System.out.println(new ReverseInParenthesis().solution("foo(bar)baz(blim)")); // foorabbazmilb
		System.out.println(new ReverseInParenthesis().solution("foo(bar(baz))blim")); // foobazrabblim
	}

	String solution(String inputString) {
		Stack<Integer> positionStack = new Stack<>();
		StringBuilder builder = new StringBuilder();
		char[] chars = inputString.toCharArray();
		for(int i = 0; i< chars.length; i++){
			if(chars[i] == '('){
				positionStack.push(i);
			}
			if(chars[i] == ')'){
				reverse(chars, positionStack.pop()+1, i);
			}

		}
		for(char i : chars){
			if(i != '(' && i != ')'){
				builder.append(i);
			}
		}
		return builder.toString();
	}

	void reverse(char[] toReverse, int from, int to){
		if(from < to){
			char tmp = toReverse[from];
			toReverse[from] = toReverse[to];
			toReverse[to] = tmp;
			reverse(toReverse, from+1, to-1);
		}
	}
}
