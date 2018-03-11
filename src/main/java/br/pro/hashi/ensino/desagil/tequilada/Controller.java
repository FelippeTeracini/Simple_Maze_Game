package br.pro.hashi.ensino.desagil.tequilada;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//A expressão "implements ActionListener" estabelece
//que objetos dessa classe podem reagir ao relógio.
public class Controller implements ActionListener {
	private Model model;
	private View view;

	public Controller(Model model, View view) {
		this.model = model;
		this.view = view;
	}

	// Esse método especial, que a expressão "implements ActionListener"
	// obriga a ter, é o método chamado pelo relógio a cada segundo.
	@Override
	public void actionPerformed(ActionEvent event) {
		model.update();
		view.repaint();
	}
}
