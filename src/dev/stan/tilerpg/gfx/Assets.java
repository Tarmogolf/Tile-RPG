package dev.stan.tilerpg.gfx;

import java.awt.image.BufferedImage;

public class Assets {

	private static final int width = 31, height = 48;
	private static final int mapWidth = 64, mapHeight =64;
	
	public static BufferedImage frontStill, frontLeftAhead, frontRightAhead,
								leftSideStill, leftSideRightAhead, leftSideLeftAhead,
								rightSideStill, rightSideLeftAhead, rightSideRightAhead,
								backStill, backRightAhead, backLeftAhead, grass, dirt, rock;
								
	public static void init(){
		SpriteSheet sheet = new SpriteSheet(ImageLoader.loadImage("/textures/sheet.png"));
		SpriteSheet map = new SpriteSheet(ImageLoader.loadImage("/textures/map.png"));
		frontStill = sheet.crop(0,0,width,height);
		frontLeftAhead = sheet.crop(width,0,width,height);
		frontRightAhead = sheet.crop(width*3,0,width,height);
		
		leftSideStill = sheet.crop(0,height,width,height);
		leftSideRightAhead = sheet.crop(width,height,width,height);
		leftSideLeftAhead = sheet.crop(width*3,height,width,height);
		
		rightSideStill = sheet.crop(0,height*2,width,height);
		rightSideLeftAhead = sheet.crop(width,height*2,width,height);
		rightSideRightAhead = sheet.crop(width*3,height*2,width,height);
		
		backStill = sheet.crop(0,height*3,width,height);
		backRightAhead = sheet.crop(width,height*3,width,height);
		backLeftAhead = sheet.crop(width*3,height*3,width,height);
		
		grass = map.crop(0, 0, mapWidth, mapHeight);
		dirt = map.crop(mapWidth, 0, mapWidth, mapHeight);
		rock = map.crop(mapWidth*2, 0, mapWidth, mapHeight);
	}
}
