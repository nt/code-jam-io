package nt.y2011.qualifications;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import nt.Problem;
import nt.utils.VI;

public class CandySplitting extends Problem {

	public CandySplitting() throws NumberFormatException,
			FileNotFoundException, IOException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public Object solve() throws Exception {
		int N = nextInt();
		VI vi = nextVI();
		
		int best = 0;
		
		for(int i=1;i<Math.pow(2, N);i++){
			
			int a = 0;
			int b = 0;
			int A = 0;
			int B = 0;
			
			for(int j=0;j<N;j++) {
//				p((i & (1 << j)));
				if((i & (1 << j)) != 0) {
					a = a ^ vi.get(j);
					A += vi.get(j);
				}
				else {
					b = b ^ vi.get(j);
					B += vi.get(j);
				}
			}
			
			if((a == b) && A*B>0 && Math.max(A, B)>best) {
				best = Math.max(A, B);
				p("new best for "+best);
				p(Integer.toBinaryString(i));
				
			}
			
			
		}
		if(best != 0)
			return best;
		return "NO";
	}

	public static void main(String[] args) throws Exception{
		Problem p = new CandySplitting();
//		System.out.println(1&0);
//		System.out.println(1<<1);
		p.solve_all();
		
	}
	

}
