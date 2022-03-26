package main;

import java.util.ArrayList;

public abstract class Agent extends Item implements Steppable {
	private long useable;
	private Bag bag;
	public abstract void setStatus(long n, Virologist v);

	/**
	 *
	 */
	public void Step() {
		System.out.println("Step(): void");
		bag.Discard(this);
		bag = null;
	}

	public void setBag(Bag bag) {
		this.bag = bag;
	}

	/**
	 *
	 * @return
	 */
	public ArrayList<Material> getNeededMaterials() {
		return null;
	}
}
