package nt.example;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import nt.Problem;
import nt.utils.VI;

/**
 * http://code.google.com/codejam/contest/dashboard?c=619102#s=p0
 */
public class RopeInranet extends Problem {

	public RopeInranet() throws NumberFormatException, FileNotFoundException,
			IOException {
		super();
	}
	
	public static void main(String[] args) throws Exception{
		
		Problem p = new RopeInranet();
		p.solve_all();
	}

	public int N;
	List<VI> ropes;
	
	@Override
	public Object solve() throws Exception {
		N = nextInt();
		ropes = new ArrayList<VI>(N);
		for(int i=0;i<N;i++) {
			ropes.add(nextVI());
		}
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
