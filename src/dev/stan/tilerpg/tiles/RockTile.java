package dev.stan.tilerpg.tiles;

import dev.stan.tilerpg.gfx.Assets;

public class RockTile extends Tile{

	public RockTile(int id) {
		super(Assets.rock, id);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean isSolid(){
		return true;
	}
}
