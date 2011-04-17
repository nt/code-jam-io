package nt.example;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import nt.Problem;

/**
 * http://code.google.com/codejam/contest/dashboard?c=351101#s=p0
 */
public class StoreCredit extends Problem {

	public StoreCredit(InputStream is, BufferedWriter writer)
			throws NumberFormatException, IOException {
		super(is, writer);
	}
	
	public static void main(String[] args) throws Exception{
		
		Problem p = new StoreCredit(new FileInputStream("/Users/nicolas/Desktop/in.txt"),
				new BufferedWriter(new FileWriter(new File("/Users/nicolas/Desktop/out.txt"))));
		p.solve_all();
	}

	
	public int I;
	public int C;
	public List<Integer> prices;
	
	@Override
	public Object solve() throws Exception {
		C = nextInt();
		I = nextInt();
		prices = nextVI();
		
		for(int i=0;i<I-1;i++) {
			for(int j=i+1;j<I;j++) {
				int sum = prices.get(i)+prices.get(j);
				if(sum == C) return (i+1) + " " + (j+1);
			}
		}
		
		return "no solution";
	}

}

