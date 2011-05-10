package nt.y2011.qualifications;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import nt.Problem;
import nt.utils.VI;

public class CandySplitting2 extends Problem {

	public CandySplitting2() throws NumberFormatException,
			FileNotFoundException, IOException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public Object solve() throws Exception {
		int N = nextInt();
		VI vi = nextVI();
		
		int a = 0, sum=0;
		int min = Integer.MAX_VALUE;
		
		for(int i=0; i<N; i++){
			int j = vi.get(i);
			a = a ^ j;
			if(j<min) min = j;
			sum += j;
		}
		
		
		if(a == 0)
			return sum-min;
		return "NO";
	}

	public static void main(String[] args) throws Exception{
		Problem p = new CandySplitting2();
		p.solve_all();
		
	}
	

}
