package br.pro.hashi.ensino.desagil.tequilada;

import javax.swing.JFrame;
import javax.swing.Timer;

// Estrutura básica de um programa Java.
public class Tequilada {
	// Estrutura básica de um programa Java.
	public static void main(String[] args) {
		// Estrutura básica de um programa Swing.
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			// Estrutura básica de um programa Swing.
            public void run() {
            	// Constrói o modelo.
            	Model model = new Model();

            	// Constrói a visão.
            	View view = new View(model);

            	// Constrói o controlador.
            	Controller controller = new Controller(model, view);

            	// Constrói a janela.
            	JFrame frame = new JFrame();

            	// Coloca a visão dentro da janela.
            	frame.setContentPane(view);

            	// Configura a janela para encerrar o programa quando for fechada.
            	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            	// Configura a janela para não ser redimensionável.
            	frame.setResizable(false);

            	// Redimensiona a janela de acordo com o tamanho do conteúdo.
            	frame.pack();

            	// Exibe a janela.
            	frame.setVisible(true);

            	// Cria o relogio
            	Timer timer = new Timer(1000, controller);

            	// Inicia o relogio
            	timer.start();
            }
        });
	}
}
