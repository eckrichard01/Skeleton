package main;

import java.util.ArrayList;
import java.util.List;

public class Bag {
	private long size;
	private Virologist virologist;
	private List<Agent> agents = new ArrayList<Agent>();
	private List<ProtectiveGear> protectiveGears = new ArrayList<ProtectiveGear>();
	private List<Material> materials = new ArrayList<Material>();

	public Bag(){
		size = 30;
	}

	public Bag(Agent agent){
		size = 30;
		agents.add(agent);
	}

	public void Discard(Agent a) {
		System.out.println("Discard(a: Agent): void");
		agents.remove(a);
	}
	public void Discard(ProtectiveGear g) {

	}
	public void Discard(Material m) {

	}
	
	public void Add(Agent a) {
		System.out.println("Add(a: Agent)");
		agents.add(a);
	}
	public void Add(ProtectiveGear g) {
		System.out.println("Add(g: ProtectiveGear): void");
		protectiveGears.add(g);
	}
	public void Add(Material m) {
		System.out.println("Add(m: Material): void");
		materials.add(m);
	}
}
