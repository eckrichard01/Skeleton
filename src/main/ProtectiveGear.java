package main;

public abstract class ProtectiveGear extends Item {
	private Shelter shelter;
	public abstract void takeAway(Virologist v);
	public abstract void setAttribute(Virologist v);
	public void Wear() {
	}
}
