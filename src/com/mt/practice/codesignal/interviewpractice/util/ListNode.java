package com.mt.practice.codesignal.interviewpractice.util;

public class ListNode<T> {
	public T value;
	public ListNode<T> next;

	public ListNode(T x) {
		value = x;
	}

	public ListNode() {
	}

	public ListNode<T> createWithValues(T... values) {
		ListNode<T> first = new ListNode<>(values[0]);
		ListNode<T> actual = first;
		for (int i = 1; i < values.length; i++) {
			actual.next = new ListNode<>(values[i]);
			actual = actual.next;
		}
		return first;
	}

	public String toString() {
		StringBuilder builder = new StringBuilder();
		ListNode<T> actual = this;
		builder.append("[");
		while (actual != null) {
			builder.append(actual.value);
			if (actual.next != null) {
				builder.append(", ");
			}
			actual = actual.next;
		}
		builder.append("]");
		return builder.toString();
	}
}
