package nt.example;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Collections;

import nt.Case;
import nt.Problem;
import nt.utils.VI;

public class MinimumScalarProduct extends Problem<MSPCase> {

	public MinimumScalarProduct() throws NumberFormatException, FileNotFoundException, IOException {
		super();
	}

	@Override
	public MSPCase buildCase(BufferedReader reader) throws Exception {
		MSPCase c = new MSPCase();
		c.N = nextInt();
		c.x = nextVI();
		c.y = nextVI();
		return c;
	}

	public static void main(String[] args) throws Exception{
		
		Problem p = new MinimumScalarProduct();
		p.solve();
	}
	
}

class MSPCase extends Case {

	VI x;
	VI y;
	int N;
	
	@Override
	public Object solve() throws Exception {
		// TODO Auto-generated method stub
		Collections.sort(x);
		Collections.sort(y);
		Collections.reverse(y);
		return x.scalar(y).toString();
		
	}
	
}
