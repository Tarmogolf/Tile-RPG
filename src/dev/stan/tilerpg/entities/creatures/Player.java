package dev.stan.tilerpg.entities.creatures;

import java.awt.Graphics;

import dev.stan.tilerpg.Handler;
import dev.stan.tilerpg.gfx.Assets;

public class Player extends Creature{


	
	public Player(float x, float y, Handler handler) {
		super(handler, x, y, Creature.DEFAULT_CREATURE_WIDTH, Creature.DEFAULT_CREATURE_WIDTH);
	}

	@Override
	public void tick() {
		getInput();
		move();
		handler.getGameCamera().centerOnEntity(this);
	}

	private void getInput(){
		xMove = 0;
		yMove = 0;
		
		if(handler.getKeyManager().up){
			yMove = -speed;
		}
		
		if(handler.getKeyManager().down){
			yMove = speed;
		}
		
		if(handler.getKeyManager().right){
			xMove = speed;
		}
		
		if(handler.getKeyManager().left){
			xMove = -speed;
		}
	}
	
	@Override
	public void render(Graphics g) {
		g.drawImage(Assets.frontStill, (int)(x - handler.getGameCamera().getxOffset()), (int)(y - handler.getGameCamera().getyOffset()), width, height, null);
	}

}
