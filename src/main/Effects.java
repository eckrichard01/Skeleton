package main;

public abstract class Effects implements Steppable {
	public void Step() {
		System.out.println("Step(): void");
		setTimeEffected(0);
	}
	
	public abstract void setTimeEffected(long n);
}
