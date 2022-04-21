package com.mt.practice.codesignal;


/**
 * Ratiorg got statues of different sizes as a present from CodeMaster for his birthday, each statue having an non-negative integer size. Since he likes to make things perfect, he wants to arrange them from smallest to largest so that each statue will be bigger than the previous one exactly by 1. He may need some additional statues to be able to accomplish that. Help him figure out the minimum number of additional statues needed.
 *
 * Example
 *
 * For statues = [6, 2, 3, 8], the output should be
 * solution(statues) = 3.
 *
 * Ratiorg needs statues of sizes 4, 5 and 7.
 *
 * Input/Output
 *
 * [execution time limit] 3 seconds (java)
 *
 * [input] array.integer statues
 *
 * An array of distinct non-negative integers.
 *
 * Guaranteed constraints:
 * 1 ≤ statues.length ≤ 10,
 * 0 ≤ statues[i] ≤ 20.
 *
 * [output] integer
 *
 * The minimal number of statues that need to be added to existing statues such that it contains every integer size from an interval [L, R] (for some L, R) and no other sizes
 */
public class MakeArrayConsecutive {
	public static void main(String[] args) {
		new MakeArrayConsecutive().solution(new int[]{6, 2, 3, 8}); // 3
		new MakeArrayConsecutive().solution(new int[]{0, 3});  // 2
		new MakeArrayConsecutive().solution(new int[]{5,4,6});  // 0
	}

	int solution(int[] statues) {
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		for(int i = 0; i < statues.length; i++){
			if (statues[i] < min){
				min = statues[i];
			}
			if (statues[i] > max){
				max = statues[i];
			}
		}
		return max - min + 1 - statues.length;
	}
}
