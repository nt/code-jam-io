package nt.example;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import nt.Case;
import nt.Problem;
import nt.utils.VI;

/**
 * http://code.google.com/codejam/contest/dashboard?c=619102#s=p0
 */
public class RopeInranet extends Problem<RopeCase> {

	public RopeInranet() throws NumberFormatException, FileNotFoundException,
			IOException {
		super();
	}

	@Override
	public RopeCase buildCase(BufferedReader reader) throws Exception {
		RopeCase c = new RopeCase();
		c.N = nextInt();
		c.ropes = new ArrayList<VI>(c.N);
		for(int i=0;i<c.N;i++) {
			c.ropes.add(nextVI());
		}
		return c;
	}
	
	public static void main(String[] args) throws Exception{
		
		Problem p = new RopeInranet();
		p.solve();
	}

}

class RopeCase extends Case {

	public int N;
	List<VI> ropes;
	
	@Override
	public Object solve() throws Exception {
		BigInteger sum = BigInteger.ZERO;
		for(int i=0;i<N-1;i++) {
			for(int j=i;j<N;j++) {
				if(intersect(ropes.get(i), ropes.get(j))) sum = sum.add(BigInteger.valueOf(1));
			}
		}
		return sum.toString();
	}
	
	boolean intersect(VI x, VI y) {
		return (x.get(0) - y.get(0))*(x.get(1)-y.get(1)) < 0;
	}
	
}
