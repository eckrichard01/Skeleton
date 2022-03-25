package main;

public class Laboratory extends Tile {
	private GeneticCode geneticCode;

	public Laboratory(GeneticCode code) {
		geneticCode = code;
	}
	public GeneticCode Palpate() {
		System.out.println("Palpate(): GeneticCode");
		return geneticCode;
	}
	@Override
	public GeneticCode GetCollectable() {
		System.out.println("GetCollectable(): GeneticCode");
		return this.Palpate();
	}
}
