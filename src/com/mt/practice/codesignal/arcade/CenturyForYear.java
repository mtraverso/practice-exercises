package com.mt.practice.codesignal.arcade;

/**
 * Given a year, return the century it is in. The first century spans from the year 1 up to and including the year 100, the second - from the year 101 up to and including the year 200, etc.
 *
 * Example
 *
 * For year = 1905, the output should be
 * solution(year) = 20;
 * For year = 1700, the output should be
 * solution(year) = 17.
 * Input/Output
 *
 * [execution time limit] 3 seconds (java)
 *
 * [input] integer year
 *
 * A positive integer, designating the year.
 *
 * Guaranteed constraints:
 * 1 ≤ year ≤ 2005.
 *
 * [output] integer
 *
 * The number of the century the year is in.
 */

public class CenturyForYear {
	public static void main(String[] args) {
		new CenturyForYear().solution(1905); // 20
		new CenturyForYear().solution(2001); // 21
		new CenturyForYear().solution(45); // 1
		new CenturyForYear().solution(1700); // 17
	}

	int solution(int year) {
		int firstDigits = 0;
		int number = year;
		while( number != 0){
			firstDigits = number % 100;
			number = number / 100;
		}
		if(year / 100 == 0){
			firstDigits = 0;
		}
		int century = firstDigits +1;
		if(year % 100 == 0){
			century --;
		}
		return century;

	}
}
