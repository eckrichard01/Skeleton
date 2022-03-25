package main;

import java.util.ArrayList;
import java.util.List;

public class Virologist {
	private long codeCount;
	private double agentResistance;
	private boolean throwBackAvailable;
	private List<Effects> effects = new ArrayList<Effects>();
	private List<GeneticCode> geneticCodes = new ArrayList<GeneticCode>();
	private Bag bag;
	private Tile tile;

	public Virologist(Tile tile, Bag bag){
		codeCount = 0;
		throwBackAvailable = false;
		agentResistance = 0;
		this.bag = bag;
		this.tile = tile;
	}

	public void Move(long n) {
		System.out.println("move(n: long):");
		Tile t2 = tile.GetNeighbor(n);
		tile.Remove(this);
		tile.Accept(this);
		tile = t2;
	}
	
	public void UseAgent(Virologist v, Agent a) {
	}
	
	public void TakeGear(Virologist from, ProtectiveGear g) {
	}
	
	public void LearnCode(GeneticCode g) {
		System.out.println("LearnCode(g: GeneticCode): void");
		this.geneticCodes.add(g);
	}
	
	public void CollectProtectiveGear() {
	}
	
	public void PalpateWall() {
		System.out.println("PalpateWall(): void");
		GeneticCode geneticCode = (GeneticCode) tile.GetCollectable();
		this.LearnCode(geneticCode);
	}
	
	public void Wear(ProtectiveGear g) {
	}
	
	public void HitByAgent(Agent which) {
	}
	
	public ProtectiveGear giveGear() {
		return null;
	}
	
	public void CollectMaterial() {
	}
	
	public void addGear(ProtectiveGear g) {
	}
	
	public boolean useMaterials(Material n, Material m) {
		return true;
	}
	
	public void addAgent(Agent a) {
	}
}
