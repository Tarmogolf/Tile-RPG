package dev.stan.tilerpg;

import dev.stan.tilerpg.gfx.GameCamera;
import dev.stan.tilerpg.input.Keymanager;
import dev.stan.tilerpg.worlds.World;

public class Handler {

	private Game g;
	private World w;
	
	public Handler(Game g){
		this.g = g;
	}
	
	public GameCamera getGameCamera(){
		return g.getGameCamera();
	}
	
	public Keymanager getKeyManager(){
		return g.getKeyManager();
	}

	public int getWidth(){
		return g.getWidth();
	}
	
	public int getHeight(){
		return g.getHeight();
	}
	
	public Game getGame() {
		return g;
	}

	public void setGame(Game g) {
		this.g = g;
	}

	public World getWorld() {
		return w;
	}

	public void setWorld(World w) {
		this.w = w;
	}
}
