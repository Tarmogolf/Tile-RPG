package dev.stan.tilerpg.input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Keymanager implements KeyListener {

	private boolean[] keys;
	public boolean up, down, left, right;
	
	public Keymanager(){
		keys = new boolean[256];
	}
	
	public void tick(){
		up = keys[KeyEvent.VK_W];
		down = keys[KeyEvent.VK_S];
		left = keys[KeyEvent.VK_A];
		right = keys[KeyEvent.VK_D];
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		keys[e.getKeyCode()] = true;
	}

	@Override
	public void keyReleased(KeyEvent e) {
		keys[e.getKeyCode()] = false;
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

}
