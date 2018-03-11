package br.pro.hashi.ensino.desagil.tequilada;

public class Player {
	private int row;
	private int col;

	public Player(int row, int col) {
		this.row = row;
		this.col = col;
	}

	public void move(int rowShift, int colShift) {
		row += rowShift;
		col += colShift;
	}

	public int getRow() {
		return row;
	}
	public int getCol() {
		return col;
	}
}
