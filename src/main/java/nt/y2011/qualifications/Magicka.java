package nt.y2011.qualifications;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;

import nt.Problem;


/*
5
0 0 2 EA
1 QRI 0 4 RRQR
1 QFT 1 QF 7 FAQFDFQ
1 EEZ 1 QE 7 QEEEERA
0 1 QW 2 QW
 */
public class Magicka extends Problem {

	public Magicka() throws NumberFormatException, FileNotFoundException,
			IOException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public Object solve() throws Exception {
		String input = nextString();
		String[] t = input.split(" ");
		
		Map<String, Character> trans = new HashMap<String, Character>();
		
		int C = Integer.valueOf(t[0]);
//		p(C);
		for(int i=0;i<C;i++) {
			String u = t[1+i];
			trans.put(u.substring(0, 2), u.charAt(2));
			trans.put(u.charAt(1)+""+u.charAt(0), u.charAt(2));
		}
		
//		p(trans);
		
		int D = Integer.valueOf(t[1+C]);
//		p(D);
		List<String> oppos = new ArrayList<String>();
		
		for(int i=0;i<D;i++) {
			String u = t[1+C+1+i];
			oppos.add(u);
			oppos.add(u.charAt(1)+""+u.charAt(0));
			
		}
		
//		p(oppos);
		
		String formula = t[1+C+D+2];
		p(formula);
		if(formula.length()<2) return "["+formula+"]";
		
		StringBuilder sb = new StringBuilder(formula.substring(0, 2));
		
		
		ArrayList<Character> f = new ArrayList<Character>();
		f.add(formula.charAt(0));
		
		for(int i=1;i<formula.length();i++) {

			String p = f.get(f.size()-1) +""+ formula.charAt(i);
			if(trans.containsKey(p)){
				p("replacing");
				f.remove(f.size()-1);
				f.add(trans.get(p));
				continue;
			}
			for(int j=0;j<f.size();j++) {
				p = f.get(j) +""+ formula.charAt(i);
				if(oppos.contains(p)){
					f.clear();
//					if(i+1<formula.length())
//						f.add(formula.charAt(i+1));
//					if(i+2<formula.length())
//						f.add(formula.charAt(i+2));
//					i+=2;
					i++;
					p("delete");
					continue;
				}
			}
			if(i<formula.length())
				f.add(formula.charAt(i));
		}
		
		
		
		
		
		return f;
	}
	
	public static void main(String[] args) throws Exception{
		Problem p = new Magicka();
		p.solve_all();
	}

}
