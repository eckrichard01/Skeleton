package main;

import java.util.ArrayList;
import java.util.List;

public class Virologist {
	private long codeCount = 0;
	private double agentResistance;
	private boolean throwBackAvailable;
	private List<Effects> effects = new ArrayList<Effects>();
	private List<GeneticCode> geneticCodes = new ArrayList<GeneticCode>();
	private List<ProtectiveGear> wear = new ArrayList<ProtectiveGear>();
	private Bag bag;
	private Tile tile;

	/**
	 * A virológus egyik konstruktora
	 * @param tile a mező amin tartózkodik
	 * @param bag a táska, amitben tárolja a védőfelszerelését, anyagait és az ágenseket
	 */
	public Virologist(Tile tile, Bag bag){
		codeCount = 0;
		throwBackAvailable = false;
		agentResistance = 0;
		this.bag = bag;
		this.tile = tile;
	}

	/**
	 * A viroloógus default kontruktora
	 */
	public Virologist(){ }

	/**
	 * A virológus az egyik mezőről a másikra lép
	 * @param n A mező száma amire lép a virológus
	 */
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

	/**
	 * A genetikai kódot megtanulja (bekerül az ismert genetikai kódok listájába)
	 * @param g Az a genetikai kód, amit megismer
	 */
	public void LearnCode(GeneticCode g) {
		System.out.println("LearnCode(g: GeneticCode): void");
		this.geneticCodes.add(g);
		codeCount++;
	}

	/**
	 * A védőfelszerelést felvesz a óvóhelyen.
	 * @param b1 arra az állításra a válasz, hogy van-e már ilyen tárgya
	 * @param b2 arra az állításra a válasz, hogy van-e elegendő hely a táskályában
	 */
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

	/**
	 * Letapogat egy genetikai kódot
	 */
	public void PalpateWall() {
		System.out.println("PalpateWall(): void");
		GeneticCode geneticCode = (GeneticCode) tile.GetCollectable();
		this.LearnCode(geneticCode);
	}

	/**
	 * Védőfelszerelés felvételének elkezdése
	 * @param g az a védőfelszerelés, amit felvesz
	 */
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

	/**
	 * A virológus felveszi az anyagot
	 * @param b arra a kérdésre a válasz, hogy van-e elég helye a táskájában
	 */
	public void CollectMaterial(boolean b) {
		System.out.println("CollectMaterial(): void");
		Material material = (Material) tile.GetCollectable();
		if(b == true) {
			bag.Add(material);
		}
	}
	
	public void addGear(ProtectiveGear g) {
	}

	/**
	 * Használja az anyagokat amiknek a
	 * mennyiségét a paraméterben kapja
	 * @param n egyik anagy amit felhasznál
	 * @param m egyik anagy amit felhasznál
	 * @param b arra a kérdésre a válasz, hogy van-e elegendő anyaga
	 * @return A sikeres vagy sikeretelen felhasználás
	 */
	public boolean useMaterials(Material n, Material m, boolean b) {
		System.out.println("useMaterials(n: Material, m: Material): bool");
		return b;
	}

	/**
	 * Ágenst add a táskához
	 * @param a Az az ágens, amit hozzáadunk
	 */
	public void addAgent(Agent a) {
		System.out.println("AddAgent(a: Agent): void");
		bag.Add(a);
	}
}
