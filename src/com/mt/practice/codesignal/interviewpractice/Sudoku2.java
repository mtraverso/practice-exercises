package com.mt.practice.codesignal.interviewpractice;

import java.util.HashSet;
import java.util.Set;

/**
 * Codewriting
 *
 * 1000
 *
 * Sudoku is a number-placement puzzle. The objective is to fill a 9 × 9 grid with numbers in such a way that each column,
 * each row, and each of the nine 3 × 3 sub-grids that compose the grid all contain all of the numbers from 1 to 9 one time.
 *
 * Implement an algorithm that will check whether the given grid of numbers represents a valid Sudoku puzzle according to
 * the layout rules described above. Note that the puzzle represented by grid does not have to be solvable.
 *
 * Example
 *
 * For
 *
 * grid = [['.', '.', '.', '1', '4', '.', '.', '2', '.'],
 *         ['.', '.', '6', '.', '.', '.', '.', '.', '.'],
 *         ['.', '.', '.', '.', '.', '.', '.', '.', '.'],
 *         ['.', '.', '1', '.', '.', '.', '.', '.', '.'],
 *         ['.', '6', '7', '.', '.', '.', '.', '.', '9'],
 *         ['.', '.', '.', '.', '.', '.', '8', '1', '.'],
 *         ['.', '3', '.', '.', '.', '.', '.', '.', '6'],
 *         ['.', '.', '.', '.', '.', '7', '.', '.', '.'],
 *         ['.', '.', '.', '5', '.', '.', '.', '7', '.']]
 * the output should be
 * solution(grid) = true;
 *
 * For
 *
 * grid = [['.', '.', '.', '.', '2', '.', '.', '9', '.'],
 *         ['.', '.', '.', '.', '6', '.', '.', '.', '.'],
 *         ['7', '1', '.', '.', '7', '5', '.', '.', '.'],
 *         ['.', '7', '.', '.', '.', '.', '.', '.', '.'],
 *         ['.', '.', '.', '.', '8', '3', '.', '.', '.'],
 *         ['.', '.', '8', '.', '.', '7', '.', '6', '.'],
 *         ['.', '.', '.', '.', '.', '2', '.', '.', '.'],
 *         ['.', '1', '.', '2', '.', '.', '.', '.', '.'],
 *         ['.', '2', '.', '.', '3', '.', '.', '.', '.']]
 * the output should be
 * solution(grid) = false.
 *
 * The given grid is not correct because there are two 1s in the second column. Each column, each row, and each 3 × 3
 * subgrid can only contain the numbers 1 through 9 one time.
 *
 * Input/Output
 *
 * [execution time limit] 3 seconds (java)
 *
 * [input] array.array.char grid
 *
 * A 9 × 9 array of characters, in which each character is either a digit from '1' to '9' or a period '.'.
 *
 * [output] boolean
 *
 * Return true if grid represents a valid Sudoku puzzle, otherwise return false.
 */
public class Sudoku2 {
	private static char[][] gridError = {{'.', '.', '.', '.', '2', '.', '.', '9', '.'},
			{'.', '.', '.', '.', '6', '.', '.', '.', '.'},
	{'7', '1', '.', '.', '7', '5', '.', '.', '.'},
		{'.', '7', '.', '.', '.', '.', '.', '.', '.'},
			{'.', '.', '.', '.', '8', '3', '.', '.', '.'},
				{'.', '.', '8', '.', '.', '7', '.', '6', '.'},
					{'.', '.', '.', '.', '.', '2', '.', '.', '.'},
						{'.', '1', '.', '2', '.', '.', '.', '.', '.'},
							{'.', '2', '.', '.', '3', '.', '.', '.', '.'}};

	private static char[][] gridOk = {{'.', '.', '.', '1', '4', '.', '.', '2', '.'},
		{'.', '.', '6', '.', '.', '.', '.', '.', '.'},
		{'.', '.', '.', '.', '.', '.', '.', '.', '.'},
			{'.', '.', '1', '.', '.', '.', '.', '.', '.'},
		{'.', '6', '7', '.', '.', '.', '.', '.', '9'},
		{'.', '.', '.', '.', '.', '.', '8', '1', '.'},
		{'.', '3', '.', '.', '.', '.', '.', '.', '6'},
		{'.', '.', '.', '.', '.', '7', '.', '.', '.'},
		{'.', '.', '.', '5', '.', '.', '.', '7', '.'}};


	public static void main(String[] args) {
		System.out.println(new Sudoku2().solution(gridOk)); //true
		System.out.println(new Sudoku2().solution(gridError)); //false
	}

	boolean solution(char[][] grid) {
		for(int i = 0; i < grid.length; i++){
			if(checkDuplicateInColumn(grid, i) || checkDuplicateInRow(grid, i) || checkDuplicateInSquare(grid, i)) {
				return false;
			}
		}
		return true;
	}

	private boolean checkDuplicateInColumn(char[][] grid, int column) {
		Set<Integer> visitedElements = new HashSet<>();
		for(int i = 0; i< grid.length; i++){
			if(grid[i][column] != '.'){
				int value = grid[i][column];
				if(value != '.') {
					if (visitedElements.contains(value)) {
						return true;
					}
					visitedElements.add(value);
				}
			}
		}
		return false;
	}

	private boolean checkDuplicateInRow(char[][] grid, int row) {
		Set<Integer> visitedElements = new HashSet<>();
		for(int i = 0; i< grid.length; i++) {
			if (grid[row][i] != '.') {
				int value = grid[row][i];
				if(value != '.') {
					if (visitedElements.contains(value)) {
						return true;
					}
					visitedElements.add(value);
				}
			}
		}
		return false;
	}

	private boolean checkDuplicateInSquare(char[][] grid, int square) {
		Set<Integer> visitedElements = new HashSet<>();
		for(int i = (square/3)*3%9; i<((square/3)+1)*3%10; i++){
			for(int j = (square%3*3); j<=((square+1)*3-1)%9; j++){

				int value = grid[i][j];
				if(value != '.') {
					if (visitedElements.contains(value)) {
						return true;
					}
					visitedElements.add(value);
				}
			}
		}
		return false;
	}
}
