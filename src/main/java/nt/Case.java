package nt;


public abstract class Case {
	
	public abstract Object solve() throws Exception;
	
	protected void p(Object o) {
		System.out.println(o);
	}
	
}
