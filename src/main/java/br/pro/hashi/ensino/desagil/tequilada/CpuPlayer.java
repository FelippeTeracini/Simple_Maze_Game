package br.pro.hashi.ensino.desagil.tequilada;

import java.util.Stack;

public class CpuPlayer extends Player {
	private boolean[][] isVisited;
	int numRows;
	int numCols;
	private Stack<Crumb> stack;


	public CpuPlayer(int row, int col, Board board) {
		super(row, col);

		numRows = board.getNumRows();
		numCols = board.getNumCols();

		isVisited = new boolean[numRows][numCols];

		for(int i = 0; i < numRows; i++) {
			for(int j = 0; j < numCols; j++) {
				isVisited[i][j] = board.isWall(i,  j);
			}
		}

		stack = new Stack<>();

		isVisited[row][col] = true;
		stack.push(new Crumb(row, col));
	}


	public void move() {
		if(!stack.isEmpty()) {
			Crumb crumb = stack.peek();

			int i = crumb.getRow();
			int j = crumb.getCol();

			if(i > 0 && !isVisited[i - 1][j]) {
				move(-1, 0);
				isVisited[row][col] = true;
				stack.push(new Crumb(row, col));
			}
			else if(j > 0 && !isVisited[i][j - 1]) {
				move(0, -1);
				isVisited[row][col] = true;
				stack.push(new Crumb(row, col));
			}
			else if(i < numRows - 1 && !isVisited[i + 1][j]) {
				move(1, 0);
				isVisited[row][col] = true;
				stack.push(new Crumb(row, col));
			}
			else if(j < numCols - 1 && !isVisited[i][j + 1]) {
				move(0, 1);
				isVisited[row][col] = true;
				stack.push(new Crumb(row, col));
			}
			else {
				stack.pop();

				if(!stack.isEmpty()) {
					crumb = stack.peek();

					int rowShift = crumb.getRow() - row;
					int colShift = crumb.getCol() - col;

					move(rowShift, colShift);
				}
			}
		}
	}
}