package nt.example;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Collections;

import nt.Problem;
import nt.utils.VI;

/*
 * http://code.google.com/codejam/contest/dashboard?c=32016#s=p0
 */
public class MinimumScalarProduct extends Problem {

	public MinimumScalarProduct() throws NumberFormatException, FileNotFoundException, IOException {
		super();
	}

	public static void main(String[] args) throws Exception{
		Problem p = new MinimumScalarProduct();
		p.solve_all();
	}

	VI x;
	VI y;
	int N;
	
	@Override
	public Object solve() throws Exception {
		N = nextInt();
		x = nextVI();
		y = nextVI();
		Collections.sort(x);
		Collections.sort(y);
		Collections.reverse(y);
		return x.scalar(y).toString();
	}
	
}
