package main;

import java.util.ArrayList;
import java.util.List;

public class Storage extends Tile {
	private List<Material> materials = new ArrayList<Material>();
	public Material Collect() {
		return null;
	}

	@Override
	public Material GetCollectable() {
		return null;
	}
}
