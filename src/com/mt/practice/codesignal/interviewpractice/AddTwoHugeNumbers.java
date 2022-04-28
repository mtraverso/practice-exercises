package com.mt.practice.codesignal.interviewpractice;

import com.mt.practice.codesignal.interviewpractice.util.ListNode;

/**
 * You're given 2 huge integers represented by linked lists. Each linked list element is a number from 0 to 9999 that represents a number with exactly 4 digits. The represented number might have leading zeros. Your task is to add up these huge integers and return the result in the same format.
 *
 * Example
 *
 * For a = [9876, 5432, 1999] and b = [1, 8001], the output should be
 * solution(a, b) = [9876, 5434, 0].
 *
 * Explanation: 987654321999 + 18001 = 987654340000.
 *
 * For a = [123, 4, 5] and b = [100, 100, 100], the output should be
 * solution(a, b) = [223, 104, 105].
 *
 * Explanation: 12300040005 + 10001000100 = 22301040105.
 *
 * Input/Output
 *
 * [execution time limit] 3 seconds (java)
 *
 * [input] linkedlist.integer a
 *
 * The first number, without its leading zeros.
 *
 * Guaranteed constraints:
 * 0 ≤ a size ≤ 104,
 * 0 ≤ element value ≤ 9999.
 *
 * [input] linkedlist.integer b
 *
 * The second number, without its leading zeros.
 *
 * Guaranteed constraints:
 * 0 ≤ b size ≤ 104,
 * 0 ≤ element value ≤ 9999.
 *
 * [output] linkedlist.integer
 *
 * The result of adding a and b together, returned without leading zeros in the same format.
 */

public class AddTwoHugeNumbers {
	public static void main(String[] args) {
		//ListNode<Integer> listNodeFirstArg1 = new ListNode<Integer>().createWithValues(9876, 5432,1999);
		//ListNode<Integer> listNodeSecondArg1 = new ListNode<Integer>().createWithValues(1, 8001);
		//System.out.println(new AddTwoHugeNumbers().solution(listNodeFirstArg1, listNodeSecondArg1)); //9876, 5434, 0

		ListNode<Integer> listNodeFirstArg2 = new ListNode<Integer>().createWithValues(1);
		ListNode<Integer> listNodeSecondArg2 = new ListNode<Integer>().createWithValues(9999, 9999, 9999, 9999, 9999, 9999);
		System.out.println(new AddTwoHugeNumbers().solution(listNodeFirstArg2, listNodeSecondArg2)); //9876, 5434, 0
	}

	ListNode<Integer> solution(ListNode<Integer> a, ListNode<Integer> b) {
		ListNode<Integer> aReversed = reverse(a);
		ListNode<Integer> bReversed = reverse(b);
		ListNode<Integer> dummy = new ListNode<>(-1);
		ListNode<Integer> aux = dummy;
		while(aReversed != null && bReversed != null) {
			aux.next = new ListNode<>(aReversed.value+bReversed.value);
			aReversed = aReversed.next;
			bReversed = bReversed.next;
			aux = aux.next;
		}
		while (aReversed != null){
			aux.next = new ListNode<>(aReversed.value);
			aux = aux.next;
			aReversed = aReversed.next;
		}
		while (bReversed != null){
			aux.next = new ListNode<>(bReversed.value);
			aux = aux.next;
			bReversed = bReversed.next;
		}
		aux = dummy.next;
		int carry = 0;
		while(aux != null){
			int prevValue = aux.value+carry;
			aux.value = (aux.value+carry)%10000;
			carry = prevValue/10000;
			aux = aux.next;
		}

		ListNode<Integer> remaining = reverse(dummy.next);
		if(carry > 0){
			ListNode<Integer> newFirst = new ListNode<>(carry);
			newFirst.next = remaining;
			return newFirst;
		}
		return remaining;
	}

	private ListNode<Integer> reverse(ListNode<Integer> b) {
		ListNode<Integer> prev = null;
		ListNode<Integer> current = b;
		ListNode<Integer> next;
		while(current != null){
			next = current.next;
			current.next = prev;
			prev = current;
			current = next;
		}
		return prev;
	}
}
