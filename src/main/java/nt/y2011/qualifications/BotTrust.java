package nt.y2011.qualifications;

import java.io.FileNotFoundException;
import java.io.IOException;

import nt.Problem;

/*
 * http://code.google.com/codejam/contest/dashboard?c=975485#
 * 
 * 
3
4 O 2 B 1 B 2 O 4
3 O 5 O 8 B 100
2 B 2 B 1
 * 
 */
public class BotTrust extends Problem {

	public BotTrust() throws NumberFormatException, FileNotFoundException,
			IOException {
		super();
		// TODO Auto-generated constructor stub
	}

	
	enum Color {
		O, B
	}
	
	@Override
	public Object solve() throws Exception {
		int blp = 1;
		int olp = 1;
		int bla = 0;
		int ola = 0;
		int time = 0;
		String line = nextString();
		String[] ins = line.split(" ");
		for(int i=0;i<ins.length/2;i++) {
			int p = Integer.valueOf(ins[i*2+2]);
			Color c = Color.valueOf(ins[2*i+1]);
//			p(c + " " +p);
			if(c==Color.B) {
//				p("dist: "+Math.abs(p-blp));
//				p("time saved: "+(time - bla));
				time += Math.max(Math.abs(p-blp) - (time - bla), 0) + 1;
				bla = time;
				blp = p;
			} else {
//				p("dist: "+Math.abs(p-olp));
//				p("time saved: "+(time - ola));
				time += Math.max(Math.abs(p-olp) - (time - ola), 0) + 1;
				ola = time;
				olp = p;
			}
//			p("time: "+time);
			
		}
		
		return time;
	}

	public static void main(String[] args) throws Exception{
		Problem p = new BotTrust();
		p.solve_all();
	}
}
