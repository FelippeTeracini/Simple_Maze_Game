package br.pro.hashi.ensino.desagil.tequilada;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

//A express�o "implements ActionListener" estabelece
//que objetos dessa classe podem reagir ao rel�gio.
public class Controller implements ActionListener, KeyListener {
	private Model model;
	private View view;

	public Controller(Model model, View view) {
		this.model = model;
		this.view = view;
	}

	// Esse m�todo especial, que a express�o "implements ActionListener"
	// obriga a ter, � o m�todo chamado pelo rel�gio a cada segundo.
	@Override
	public void actionPerformed(ActionEvent event) {
		model.update();
		view.repaint();
	}

	// Esses m�todos especiais, que a express�o "implements KeyListener"
	// obriga a ter, s�o os m�todos chamados em rea��o ao teclado.
	@Override
	public void keyPressed(KeyEvent event) {
		Board board = model.getBoard();
		Player humanPlayer = model.getHumanPlayer();
		int row = humanPlayer.getRow();
		int col = humanPlayer.getCol();

		if(event.getKeyCode() == KeyEvent.VK_UP) {
			if(row > 0 && !board.isWall(row - 1, col)) {
				humanPlayer.move(-1, 0);
			}
		}
		if(event.getKeyCode() == KeyEvent.VK_LEFT) {
			if(col > 0 && !board.isWall(row, col - 1)) {
				humanPlayer.move(0, -1);
			}
		}
		if(event.getKeyCode() == KeyEvent.VK_DOWN) {
			if(row < board.getNumRows() - 1 && !board.isWall(row + 1, col)) {
				humanPlayer.move(1, 0);
			}
		}
		if(event.getKeyCode() == KeyEvent.VK_RIGHT) {
			if(col < board.getNumCols() - 1 && !board.isWall(row, col + 1)) {
				humanPlayer.move(0, 1);
			}
		}
	}
	@Override
	public void keyReleased(KeyEvent event) {
	}
	@Override
	public void keyTyped(KeyEvent event) {
	}
}