package main;

import java.util.ArrayList;
import java.util.List;

public abstract class Tile {
	private long capacity;
	private List<Tile> adjacentTiles = new ArrayList<Tile>();
	private List<Virologist> virologits = new ArrayList<Virologist>();

	public void Remove(Virologist v) {
		System.out.println("Remove(v: Virologist)");
		for(int i = 0; i < virologits.size(); i++){
			if(virologits.get(i) == v) {
				virologits.remove(i);
			}
		}
	}
	
	public void Accept(Virologist v) {
		System.out.println("Accept(v: Virologist)");
		if(virologits.size() < 2){
			virologits.add(v);
		}
	}
	
	public Tile GetNeighbor(long n) {
		System.out.println("GetNeighbor(n: long): Tile");
		return adjacentTiles.get((int)n);
	}

	public void SetNeighbor(Tile tile){
		adjacentTiles.add(tile);
	}
	
	public Virologist GetOtherVirologist() {
		return null;
	}
	
	public abstract Object GetCollectable();
}
