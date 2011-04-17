package nt.utils;

import java.util.ArrayList;

public class VVI extends ArrayList<VI> {

	int x, y;
	
	public VVI(int x, int y) {
		super(x);
		this.x = x;
		this.y = y;
		for(int i=0;i<x;i++) add(new VI(y));
	}
	
	public void setAllTo(int a) {
		
	}
	
}
