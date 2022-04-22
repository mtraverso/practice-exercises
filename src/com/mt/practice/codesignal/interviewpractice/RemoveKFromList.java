package com.mt.practice.codesignal.interviewpractice;

import com.mt.practice.codesignal.interviewpractice.util.ListNode;

/**
 * Note: Try to solve this task in O(n) time using O(1) additional space, where n is the number of elements in the list, since this is what you'll be asked to do during an interview.
 *
 * Given a singly linked list of integers l and an integer k, remove all elements from list l that have a value equal to k.
 *
 * Example
 *
 * For l = [3, 1, 2, 3, 4, 5] and k = 3, the output should be
 * solution(l, k) = [1, 2, 4, 5];
 * For l = [1, 2, 3, 4, 5, 6, 7] and k = 10, the output should be
 * solution(l, k) = [1, 2, 3, 4, 5, 6, 7].
 * Input/Output
 *
 * [execution time limit] 3 seconds (java)
 *
 * [input] linkedlist.integer l
 *
 * A singly linked list of integers.
 *
 * Guaranteed constraints:
 * 0 ≤ list size ≤ 105,
 * -1000 ≤ element value ≤ 1000.
 *
 * [input] integer k
 *
 * An integer.
 *
 * Guaranteed constraints:
 * -1000 ≤ k ≤ 1000.
 *
 * [output] linkedlist.integer
 *
 * Return l with all the values equal to k removed.
 */
public class RemoveKFromList {

	public static void main(String[] args) {
		/*ListNode<Integer> values = new ListNode<Integer>().createWithValues(3, 1, 2, 3, 4, 5);
		System.out.println(new RemoveKFromList().solution(values, 3));
		values = new ListNode<Integer>().createWithValues(1,2,3,4,5,6,7);
		System.out.println(new RemoveKFromList().solution(values, 10));*/
		ListNode<Integer> values = new ListNode<Integer>().createWithValues(1000, 1000);
		System.out.println(new RemoveKFromList().solution(values, 1000));
	}

	ListNode<Integer> solution(ListNode<Integer> l, int k) {
		ListNode<Integer> dummy = new ListNode<>(-1);
		dummy.next = l;
		ListNode<Integer> prev = dummy;
		ListNode<Integer> actual = dummy;
		while(actual != null){
			if(actual.value == k){
				prev.next = actual.next;
			}else {
				prev = actual;
			}
			actual = actual.next;
		}
		return dummy.next;
	}


}
