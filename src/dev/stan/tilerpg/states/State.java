package dev.stan.tilerpg.states;

import java.awt.Graphics;

import dev.stan.tilerpg.Game;
import dev.stan.tilerpg.Handler;

public abstract class State {
	
	private static State currentState = null;
	
	public static void setState(State state){
		currentState = state;
	}
	
	public static State getState(){
		return currentState;
	}
	
	//CLASS
	
	protected Handler handler;
	
	public State(Handler handler){
		this.handler = handler;
	}
	
	public abstract void tick();
	
	public abstract void render(Graphics g);
}
