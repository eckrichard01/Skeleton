package main;

import java.util.ArrayList;
import java.util.List;

public class Virologist {
	private long codeCount;
	private double agentResistance;
	private boolean throwBackAvailable;
	private List<Effects> effects = new ArrayList<Effects>();
	private List<GeneticCode> geneticCodes = new ArrayList<GeneticCode>();
	private List<ProtectiveGear> wear = new ArrayList<ProtectiveGear>();
	private Bag bag;
	private Tile tile;

	public Virologist(Tile tile, Bag bag){
		codeCount = 0;
		throwBackAvailable = false;
		agentResistance = 0;
		this.bag = bag;
		this.tile = tile;
	}

	public Virologist(){

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
	
	public void CollectProtectiveGear(boolean b1, boolean b2) {
		System.out.println("CollectProtectiveGear(): void");
		ProtectiveGear pg = (ProtectiveGear) tile.GetCollectable();
		if(b2 == true){
			bag.Add(pg);
			if(b1 == false){
				this.Wear(pg);
			}
		}
	}
	
	public void PalpateWall() {
		System.out.println("PalpateWall(): void");
		GeneticCode geneticCode = (GeneticCode) tile.GetCollectable();
		this.LearnCode(geneticCode);
	}
	
	public void Wear(ProtectiveGear g) {
		System.out.println("Wear(ProtectiveGear g): void");
		wear.add(g);
		g.setVirologist(this);
		g.Wear();
	}
	
	public void HitByAgent(Agent which) {
	}
	
	public ProtectiveGear giveGear() {
		return null;
	}
	
	public void CollectMaterial(boolean b) {
		System.out.println("CollectMaterial(): void");
		Material material = (Material) tile.GetCollectable();
		if(b == true) {
			bag.Add(material);
		}
	}
	
	public void addGear(ProtectiveGear g) {
	}
	
	public boolean useMaterials(Material n, Material m, boolean b) {
		System.out.println("useMaterials(n: Material, m: Material): bool");
		return b;
	}
	
	public void addAgent(Agent a) {
		System.out.println("AddAgent(a: Agent): void");
		bag.Add(a);
	}
}
