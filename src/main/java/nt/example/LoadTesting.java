package nt.example;

import java.io.FileNotFoundException;
import java.io.IOException;

import nt.Problem;
import nt.utils.VI;

public class LoadTesting extends Problem {

	public LoadTesting() throws NumberFormatException, FileNotFoundException,
			IOException {
		super();
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) throws NumberFormatException, FileNotFoundException, IOException, Exception {
		new LoadTesting().solve_all();
	}
	
	@Override
	public Object solve() throws Exception {
		VI in = nextVI();
		int c = in.get(2);
		int left = in.get(0), right = in.get(1);
		int i = 0;
		while(left*c < right) {
			left = (right+left)/2;
			i++;
		}
		return i;
	}

}
