package main;

import java.util.ArrayList;

public abstract class Agent extends Item implements Steppable {
	private long useable;
	public abstract void setStatus(long n, Virologist v);

	/**
	 *
	 */
	public void Step() {
	}

	/**
	 *
	 * @return
	 */
	public ArrayList<Material> getNeededMaterials() {
		return null;
	}
}
