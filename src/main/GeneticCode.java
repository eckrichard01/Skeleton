package main;

public class GeneticCode {
	private Agent agent;
	public void addCode(Virologist v) {
	}

	public GeneticCode(Agent a){
		agent = a;
	}

	public boolean CreateAgent(Virologist v, boolean b) {
		System.out.println("CreateAgent(v: Virologist): bool");
		v.useMaterials(null, null, b);
		if(b == true){
			v.addAgent(agent);
		}
		return b;
	}
}
