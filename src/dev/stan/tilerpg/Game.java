package dev.stan.tilerpg;

import java.awt.Graphics;
import java.awt.image.BufferStrategy;

import dev.stan.tilerpg.display.Display;
import dev.stan.tilerpg.gfx.Assets;
import dev.stan.tilerpg.gfx.GameCamera;
import dev.stan.tilerpg.input.Keymanager;
import dev.stan.tilerpg.states.GameState;
import dev.stan.tilerpg.states.MenuState;
import dev.stan.tilerpg.states.State;

public class Game implements Runnable{

	private Display display;	
	private int width, height;
	public String title;
	
	private boolean running = false;
	private Thread thread;
	
	private BufferStrategy bs;
	private Graphics g;
	
	//States
	private State gameState;
	private State menuState;
	
	//Input
	private Keymanager keyManager;
	
	//Camera
	private GameCamera gameCamera;
	
	//Handler
	private Handler handler;
	
	public Game(String title, int width, int height){
		this.width = width;
		this.height = height;
		this.title = title;
		keyManager = new Keymanager();
	}

	private void init(){
		display = new Display(title, width, height);
		display.getFrame().addKeyListener(keyManager);
		Assets.init();
		
		gameCamera = new GameCamera(this,0,0);
		handler = new Handler(this); 
		
		gameState = new GameState(handler);
		menuState = new MenuState(handler);
		
		State.setState(gameState);
	}
	

	
	private void tick(){
		keyManager.tick();
		
		if(State.getState() != null){
			State.getState().tick();
		}
	}
	
	private void render(){
		bs = display.getCanvas().getBufferStrategy();
		
		//if the first time render is called
		if(bs == null){
			display.getCanvas().createBufferStrategy(3);
			return;
		}
		
		g = bs.getDrawGraphics();
		//Clear Screen
		g.clearRect(0, 0, width, height);
		//Draw here

		if(State.getState() != null){
			State.getState().render(g);
		}

		
		//Done drawing
		bs.show();
		g.dispose();
	}

	@Override
	public void run() {
		
		init();
		
		int fps = 60; //frames per second
		final long  NANOSECONDS_IN_A_SECOND = 1000000000;
		double timePerTick = NANOSECONDS_IN_A_SECOND/fps; 
		double delta = 0;
		long now;
		long lastTime = System.nanoTime();
		
		long timer = 0;
		int ticks = 0;
		
		while(running){
			now = System.nanoTime();
			delta+= (now - lastTime) / timePerTick;
			timer+= now - lastTime;
			lastTime = now;
			
			if(delta >= 1){
				tick();
				render();
				ticks++;
				delta--;
			}
			
			if(timer >= NANOSECONDS_IN_A_SECOND){
				//System.out.println("Ticks and Frames: " + ticks);
				ticks = 0;
				timer = 0;
			}
		}
		
		stop();
	}
	
	public Keymanager getKeyManager(){
		return keyManager;
	}
	
	public GameCamera getGameCamera(){
		return gameCamera;
	}
	
	
	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

	public synchronized void start(){
		if(running){
			return;
		}
		
		running = true;
		thread = new Thread(this);
		thread.start();
	}
	
	public synchronized void stop(){
		if(!running){
			return;
		}
		
		running = false;
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
