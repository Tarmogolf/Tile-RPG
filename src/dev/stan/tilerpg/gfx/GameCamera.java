package dev.stan.tilerpg.gfx;

import dev.stan.tilerpg.Game;
import dev.stan.tilerpg.entities.Entity;

public class GameCamera {

	private float xOffset, yOffset;
	private Game game;
	
	public GameCamera(Game game, float xOffset, float yOffset){
		this.xOffset = xOffset;
		this.yOffset = yOffset;
		this.game = game;
	}
	
	public void centerOnEntity(Entity e){
		xOffset = e.getX() - game.getWidth() / 2 + e.getWidth() / 2;
		yOffset = e.getY() - game.getHeight() / 2 + e.getHeight() /2;
	}
	
	public void move(Game game, float xAmt, float yAmt){
		xOffset += xAmt;
		yOffset += yAmt;
	}

	public float getxOffset() {
		return xOffset;
	}

	public void setxOffset(float xOffset) {
		this.xOffset = xOffset;
	}

	public float getyOffset() {
		return yOffset;
	}

	public void setyOffset(float yOffset) {
		this.yOffset = yOffset;
	}
	
	
}
