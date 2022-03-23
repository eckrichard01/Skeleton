package main;

import java.util.ArrayList;
import java.util.List;

public abstract class Tile {
	private long capacity;
	private List<Tile> adjacentTiles = new ArrayList<Tile>();
	private List<Virologist> virologits = new ArrayList<Virologist>();
	public void Remove(Virologist v) {
	}
	
	public void Accept(Virologist v) {
	}
	
	public Tile GetNeighbor(long n) {
		return null;
	}
	
	public Virologist GetOtherVirologist() {
		return null;
	}
	
	public abstract Item GetCollectable();
}
