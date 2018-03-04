package br.pro.hashi.ensino.desagil.tequilada;

public class Engine {
	Board board;
	Player cpuPlayer;
	Player humanPlayer;
	
	void update(){
		cpuPlayer.move(1, 2);
	}
	
}
