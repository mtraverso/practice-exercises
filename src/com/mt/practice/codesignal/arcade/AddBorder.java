package com.mt.practice.codesignal.arcade;

import java.util.Arrays;

/**
 * Codewriting
 *
 * 300
 *
 * Given a rectangular matrix of characters, add a border of asterisks(*) to it.
 *
 * Example
 *
 * For
 *
 * picture = ["abc",
 *            "ded"]
 * the output should be
 *
 * solution(picture) = ["*****",
 *                       "*abc*",
 *                       "*ded*",
 *                       "*****"]
 */
public class AddBorder {
	public static void main(String[] args) {
		System.out.println(Arrays.toString(new AddBorder().solution(new String[]{"abc", "ded"})));
	}

	String[] solution(String[] picture) {
		int strLength = picture[0].length();
		int borderedLength = strLength+2;
		String[] solution = new String[picture.length+2];
		StringBuilder topAndBottomBorder = new StringBuilder();
		int counter = 0;
		for(int i = 0; i< borderedLength;i++){
			topAndBottomBorder.append("*");
		}
		solution[counter++] = topAndBottomBorder.toString();
		for(String s : picture){
			solution[counter++] = "*"+s+"*";
		}
		solution[counter] = topAndBottomBorder.toString();
		return solution;
	}
}
