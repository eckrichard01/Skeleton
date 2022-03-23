package main;

public abstract class Effects implements Steppable {
	public void Step() {
	}
	
	public abstract void setTimeEffected(long n);
}
