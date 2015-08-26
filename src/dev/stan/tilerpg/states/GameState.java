package dev.stan.tilerpg.states;

import java.awt.Graphics;

import dev.stan.tilerpg.Handler;
import dev.stan.tilerpg.entities.creatures.Player;
import dev.stan.tilerpg.worlds.World;

public class GameState extends State {

	private Player player;
	private World world;
	
	public GameState(Handler handler){
		super(handler);
		world = new World(handler,"res/worlds/world1.txt");
		handler.setWorld(world);
		player = new Player(100,100, handler);
		

	}
	
	@Override
	public void tick() {
		world.tick();
		player.tick();
		
	}

	@Override
	public void render(Graphics g) {
		world.render(g);
		player.render(g);
	}

}
