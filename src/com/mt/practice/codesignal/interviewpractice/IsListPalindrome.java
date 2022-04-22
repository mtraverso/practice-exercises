package com.mt.practice.codesignal.interviewpractice;

import com.mt.practice.codesignal.interviewpractice.util.ListNode;

import java.util.Stack;

/**
 * Note: Try to solve this task in O(n) time using O(1) additional space, where n is the number of elements in l, since this is what you'll be asked to do during an interview.
 *
 * Given a singly linked list of integers, determine whether or not it's a palindrome.
 *
 * Note: in examples below and tests preview linked lists are presented as arrays just for simplicity of visualization: in real data you will be given a head node l of the linked list
 *
 * Example
 *
 * For l = [0, 1, 0], the output should be
 * solution(l) = true;
 *
 * For l = [1, 2, 2, 3], the output should be
 * solution(l) = false.
 *
 * Input/Output
 *
 * [execution time limit] 3 seconds (java)
 *
 * [input] linkedlist.integer l
 *
 * A singly linked list of integers.
 *
 * Guaranteed constraints:
 * 0 ≤ list size ≤ 5 · 105,
 * -109 ≤ element value ≤ 109.
 *
 * [output] boolean
 *
 * Return true if l is a palindrome, otherwise return false.
 */

public class IsListPalindrome {
	public static void main(String[] args) {
		ListNode<Integer> firstEx = new ListNode<Integer>().createWithValues(0,1,0);
		ListNode<Integer> secondEx = new ListNode<Integer>().createWithValues(1,2,2,3);
		ListNode<Integer> thirdEx = new ListNode<Integer>().createWithValues(1, 1000000000, -1000000000, -1000000000, 1000000000, 1);
		ListNode<Integer> fourthEx = new ListNode<Integer>().createWithValues(10);

		System.out.println(new IsListPalindrome().solution(firstEx)); //true
		System.out.println(new IsListPalindrome().solution(secondEx)); //false
		System.out.println(new IsListPalindrome().solution(thirdEx)); //true
		System.out.println(new IsListPalindrome().solution(fourthEx)); //true
	}

	boolean solution(ListNode<Integer> l) {
		if(l== null){
			return true;
		}
		if(l.next == null){
			return true;
		}

		ListNode<Integer> fast = l;
		ListNode<Integer> prevSlow = l;
		ListNode<Integer> slow = l;
		ListNode<Integer> midnode = null;
		while(fast != null && fast.next != null){
			fast = fast.next.next;
			prevSlow = slow;
			slow = slow.next;
		}
		if(fast != null){
			midnode = slow;
			slow = slow.next;
		}
		if(prevSlow != null)
			prevSlow.next = null;
		ListNode<Integer> toCompare = reverse(slow);


		return compare(l, toCompare);
	}

	private boolean compare(ListNode<Integer> prevSlow, ListNode<Integer> slow) {
		if(prevSlow == null && slow == null){
			return true;
		}
		if(prevSlow != null && slow == null){
			return false;
		}
		if(prevSlow == null && slow != null){
			return false;
		}
		if(!prevSlow.value.equals(slow.value)){
			return false;
		}
		return compare(prevSlow.next, slow.next);
	}

	ListNode<Integer> reverse(ListNode<Integer> listNode){
		ListNode<Integer> prev = null;
		ListNode<Integer> current = listNode;
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
