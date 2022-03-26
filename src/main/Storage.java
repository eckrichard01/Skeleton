package main;

import java.util.ArrayList;
import java.util.List;

public class Storage extends Tile {
	private List<Material> materials = new ArrayList<Material>();

	public Storage(List<Material> materials){
		this.materials = materials;
	}

	public Material Collect() {
		System.out.println("Collect(): Material");
		return materials.get(materials.size() - 1);
	}

	@Override
	public Material GetCollectable() {
		System.out.println("GetCollectable(): Material");
		return Collect();
	}
}
