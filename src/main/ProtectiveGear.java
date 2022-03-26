package main;

public abstract class ProtectiveGear extends Item {
	private Shelter shelter;
	private Virologist virologist;
	public abstract void takeAway(Virologist v);
	public abstract void setAttribute(Virologist v);
	public void Wear() {
		System.out.println("Wear(): void");
		setAttribute(virologist);
	}
	public void setVirologist(Virologist v) {
		this.virologist = v;
	}
}
