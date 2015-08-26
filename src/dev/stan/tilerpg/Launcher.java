package dev.stan.tilerpg;

import dev.stan.tilerpg.display.Display;

public class Launcher {

	public static void main(String[] args){
		Game myGame = new Game("My Game", 640, 360);
		
		myGame.start();
	}
}
