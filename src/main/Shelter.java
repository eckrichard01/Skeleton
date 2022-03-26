package main;

public class Shelter extends Tile {
	private ProtectiveGear p_g;

	public Shelter(ProtectiveGear p_g){
		this.p_g = p_g;
	}

	public ProtectiveGear Collect() {
		System.out.println("Collect(): ProtectiveGear");
		return p_g;
	}
	public ProtectiveGear GetCollectable() {
		System.out.println("GetCollectable(): ProtectiveGear");
		return Collect();
	}
}