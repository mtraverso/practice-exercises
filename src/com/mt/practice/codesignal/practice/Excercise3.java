package com.mt.practice.codesignal.practice;

import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.function.BiFunction;
import java.util.stream.Collectors;

/**
 * Given a matrix of integers, we'd like to consider the sum of the elements within the area of a 45° rotated rectangle.
 * More formally, the area is bounded by two diagonals parallel to the main diagonal and two diagonals parallel to the
 * secondary diagonal. The dimensions of the rotated rectangle are defined by the number of elements along the borders
 * of the rectangle.
 * <p>
 * dimensions
 * <p>
 * Given integers a and b representing the dimensions of the rotated rectangle, and matrix (a matrix of integers), your
 * task is to find the greatest sum of integers contained within an a x b rotated rectangle.
 * <p>
 * Note: The order of the dimensions is not important - consider all a x b and b x a rectangles.
 * <p>
 * Example
 * <p>
 * For
 * <p>
 * matrix = [
 * [1, 2, 3, 4, 0],
 * [5, 6, 7, 8, 1],
 * [3, 2, 4, 1, 4],
 * [4, 3, 5, 1, 6]]
 * a = 2, and b = 3, the output should be solution(matrix, a, b) = 36.
 * <p>
 * example 1
 * <p>
 * For
 * <p>
 * matrix = [[-2, 3, 5, -1],
 * [4, 3, -10, 10]]
 * a = 1, and b = 1, the output should be solution(matrix, a, b) = 10.
 * <p>
 * example 2
 * <p>
 * The rotated rectangle with dimensions 1x1 is just one element, so the answer is the maximal element in matrix.
 * <p>
 * For
 * <p>
 * matrix = [[-2, 3],
 * [4, 3]]
 * a = 1, and b = 2, the output should be solution(matrix, a, b) = 7.
 * <p>
 * example 3
 * <p>
 * Input/Output
 * <p>
 * [execution time limit] 3 seconds (java)
 * <p>
 * [input] array.array.integer matrix
 * <p>
 * A matrix of integers.
 * <p>
 * Guaranteed constraints:
 * 1 ≤ matrix.length, matrix[i].length ≤ 50,
 * -103 ≤ matrix[i][j] ≤ 103.
 * <p>
 * [input] integer a
 * <p>
 * The first rotated rectangle dimension.
 * <p>
 * Guaranteed constraints:
 * 1 ≤ a ≤ 25.
 * <p>
 * [input] integer b
 * <p>
 * The second rotated rectangle dimension.
 * It's guaranteed that at least one rotated rectangle will fit in the given matrix.
 * <p>
 * Guaranteed constraints:
 * a ≤ b ≤ 25.
 * <p>
 * [output] integer
 * <p>
 * The maximal sum of elements of a rotated rectangle with dimensions a and b.
 */

public class Excercise3 {
	public static void main(String[] args) {
		int[][] matrix = new int[][]{
				{1, 2, 3, 4, 0},
				{5, 6, 7, 8, 1},
				{3, 2, 4, 1, 4},
				{4, 3, 5, 1, 6}};
		System.out.println(new Excercise3().solution(matrix, 3, 2)); //36
		matrix = new int[][]{
				{-2, 3, 5, -1},
				{4, 3, -10, 10}};
		System.out.println(new Excercise3().solution(matrix, 1, 1)); //10
		matrix = new int[][]{
				{-2, 3},
				{4, 3}};
		System.out.println(new Excercise3().solution(matrix, 1, 2)); //7
	}

	int solution(int[][] matrix, int a, int b) {
		List<Rectangle> rectangles = computeRectangles(matrix, a, b);
		rectangles.addAll(computeRectangles(matrix, b, a));
		int sum = 0;
		for (Rectangle rectangle : rectangles) {
			sum = Math.max(computeSum(matrix, rectangle), sum);
		}
		return sum;
	}

	private int computeSum(int[][] matrix, Rectangle rectangle) {
		Set<SideFunction> sides = getSides(rectangle);
		Map<Integer, List<Point>> pointsPerRow = new HashMap<>();
		for (int i = 0; i < matrix[0].length; i++) {
			for (int j = 0; j < matrix.length; j++) {
				if (sides.size() == 1 && sides.stream().map(s -> s.pend).reduce(Integer::sum).orElse(-1) == 0) {
					return matrix[rectangle.points.get(0).y][rectangle.points.get(0).x];
				}
				int finalI = i;
				int finalJ = j;
				List<SideFunction> appliedOk = sides.stream().filter(side -> side.evaluate.apply(finalI, finalJ)).collect(Collectors.toList());
				if (!appliedOk.isEmpty()) {
					pointsPerRow.computeIfAbsent(i, p -> new ArrayList<>()).add(new Point(i, j));
				}
			}
		}
		int sum = 0;
		for (int i = 0; i < matrix.length; i++) {
			List<Point> points = pointsPerRow.get(i);
			if (points != null) {
				int max = points.stream().map(p1 -> p1.y).reduce(Math::max).orElse(-1);
				int min = points.stream().map(p1 -> p1.y).reduce(Math::min).orElse(-1);
				for (int j = min; j <= max; j++) {
					sum += matrix[i][j];
				}
			}
		}
		return sum;
	}

	private Set<SideFunction> getSides(Rectangle rectangle) {
		List<Point> points = rectangle.points;
		Set<SideFunction> rects = new HashSet<>();

		for (int x1 = 0; x1 < points.size(); x1++) {
			Point p1 = points.get(x1);
			int aux = x1;

			if (x1 + 1 > points.size() - 1) {
				aux = -1;
			}

			Point p2 = points.get(aux + 1);

			SideFunction sideFunction = new SideFunction();
			sideFunction.pend = (p2.x - p1.x) == 0 ? 0 : (p2.y - p1.y) / (p2.x - p1.x);
			sideFunction.ord = (p2.x - p1.x) == 0 ? 0 : (p2.x * p1.y - p1.x * p2.y) / (p2.x - p1.x);
			sideFunction.lowerBoundX = Math.min(p1.x, p2.x);
			sideFunction.upperBoundX = Math.max(p1.x, p2.x);
			rects.add(sideFunction);
		}
		return rects;
	}

	private List<Rectangle> computeRectangles(int[][] matrix, int a, int b) {
		List<Integer[]> xVertices = new ArrayList<>();
		for (int i = 0; i < matrix.length; i++) {
			int x2 = i - a + 1;
			int x3 = i + b - a;
			int x4 = i + b - 1;
			if (insideMatrix(x2, matrix.length) && insideMatrix(x3, matrix.length) && insideMatrix(x4, matrix.length)) {
				Integer[] xVertex = new Integer[4];
				xVertex[0] = i;
				xVertex[1] = x2;
				xVertex[2] = x3;
				xVertex[3] = x4;
				xVertices.add(xVertex);
			}
		}
		List<Integer[]> yVertices = new ArrayList<>();
		for (int i = 0; i < matrix[0].length; i++) {
			int y2 = i - a + 1;
			int y3 = i + b - a;
			int y4 = i + b - 1;
			if (insideMatrix(y2, matrix[0].length) && insideMatrix(y3, matrix[0].length) && insideMatrix(y4, matrix[0].length)) {
				Integer[] vertexY = new Integer[4];
				vertexY[0] = y2;
				vertexY[1] = i;
				vertexY[3] = y3;
				vertexY[2] = y4;
				yVertices.add(vertexY);
			}
		}

		List<Rectangle> rectangles = new ArrayList<>();
		for (Integer[] yVertex : xVertices) {
			for (Integer[] xVertex : yVertices) {
				Rectangle rect = new Rectangle();
				for (int k = 0; k < xVertices.get(0).length; k++) {
					if (!rect.points.contains(new Point(xVertex[k], yVertex[k]))) {
						rect.points.add(new Point(xVertex[k], yVertex[k]));
					}
				}
				rectangles.add(rect);
			}
		}
		return rectangles;
	}

	private boolean insideMatrix(int x, int length) {
		return x >= 0 && x < length;
	}


	static class Point {
		int x, y;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || getClass() != o.getClass()) return false;
			Point point = (Point) o;
			return x == point.x && y == point.y;
		}

		@Override
		public int hashCode() {
			return Objects.hash(x, y);
		}

		@Override
		public String toString() {
			return "Point{" +
					"x=" + x +
					", y=" + y +
					'}';
		}
	}

	static class Rectangle {
		List<Point> points = new ArrayList<>();

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || getClass() != o.getClass()) return false;
			Rectangle rectangle = (Rectangle) o;
			return Objects.equals(points, rectangle.points);
		}

		@Override
		public int hashCode() {
			return Objects.hash(points);
		}

		@Override
		public String toString() {
			return "Rectangle{" +
					"points=" + points +
					'}';
		}
	}

	static class SideFunction {
		int pend;
		int ord;
		int lowerBoundX;
		int upperBoundX;

		public BiFunction<Integer, Integer, Boolean> evaluate = (x, y) -> {
			if (pend == 0) {
				return true;
			}
			return pend * x + ord == y && x >= lowerBoundX && x <= upperBoundX;
		};

		@Override
		public String toString() {
			return pend + "*x" + (ord > 0 ? "+" : "-") + Math.abs(ord);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || getClass() != o.getClass()) return false;
			SideFunction rect = (SideFunction) o;
			return pend == rect.pend && ord == rect.ord;
		}

		@Override
		public int hashCode() {
			return Objects.hash(pend, ord);
		}
	}
}
