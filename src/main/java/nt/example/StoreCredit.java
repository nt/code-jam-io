package nt.example;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import nt.Case;
import nt.Problem;

/**
 * http://code.google.com/codejam/contest/dashboard?c=351101#s=p0
 */
public class StoreCredit extends Problem<StoreCase> {

	public StoreCredit(InputStream is, BufferedWriter writer)
			throws NumberFormatException, IOException {
		super(is, writer);
	}

	@Override
	public StoreCase buildCase(BufferedReader reader) throws NumberFormatException, IOException {
		StoreCase c = new StoreCase();
		c.C = Integer.valueOf(reader.readLine());
		c.I = Integer.valueOf(reader.readLine());
		c.prices = new ArrayList<Integer>(c.I);
		for(String s:reader.readLine().split(" ")) {
			c.prices.add(Integer.valueOf(s));
		}
		return c;
	}
	
	public static void main(String[] args) throws Exception{
		
		Problem p = new StoreCredit(new FileInputStream("/Users/nicolas/Desktop/in.txt"),
				new BufferedWriter(new FileWriter(new File("/Users/nicolas/Desktop/out.txt"))));
		p.solve();
	}

}

class StoreCase extends Case {

	public int I;
	public int C;
	public List<Integer> prices;
	
	@Override
	public String solve() {
		
		for(int i=0;i<I-1;i++) {
			for(int j=i+1;j<I;j++) {
				int sum = prices.get(i)+prices.get(j);
				if(sum == C) return (i+1) + " " + (j+1);
			}
		}
		
		return "no solution";
	}
	
}
