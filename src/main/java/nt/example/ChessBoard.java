package nt.example;

import static java.lang.Math.max;
import static java.lang.Math.min;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import nt.Problem;
import nt.utils.ArrayUtils;
import nt.utils.VI;
/*
 * http://code.google.com/codejam/contest/dashboard?c=619102#s=p2
 * 
 */
public class ChessBoard extends Problem {

	public ChessBoard() throws NumberFormatException, FileNotFoundException,
			IOException {
		super();
	}

	public static void main(String[] args) throws NumberFormatException, FileNotFoundException, IOException, Exception {
		new ChessBoard().solve_all();
	}
	
	int[][] corner;
	boolean[][] table;
	
	int M;
	int N;
	
	ArrayList<Board> boards;
	
	@Override
	public Object solve() throws Exception {
		
		VI v = nextVI();
		M = v.get(0);
		N = v.get(1);
		
		corner = ArrayUtils.newArray(M, N, 0);
		
		table = new boolean[M][N];
		
		for(int i=0;i<M;i++) {
			String s = nextString();
			for(int j=0;j<N/4;j++) {
				Integer c = Integer.valueOf(s.charAt(j)+"", 16);
				table[i][4*j+3] = (c & (1 << 0)) != 0;
				table[i][4*j+2] = (c & (1 << 1)) != 0;
				table[i][4*j+1] = (c & (1 << 2)) != 0;
				table[i][4*j] = (c & (1 << 3)) != 0;
			}
		}
		
		for(int i=0;i<M; i++){
			corner[i][0] = 1;
		}
		
		for(int j=0;j<N;j++){
			corner[0][j] = 1;
		}
		
		for(int i=1;i<M; i++) {
			for(int j=1;j<N;j++) {
				if((table[i][j]==table[i-1][j-1])
						&& (table[i][j-1]==table[i-1][j])
						&& (table[i][j] ^ table[i-1][j])){
					corner[i][j] = min(corner[i-1][j-1], min(corner[i-1][j], corner[i][j-1])) + 1;
				}
				else
					corner[i][j] = 1;
			}
		}

		boards = new ArrayList<Board>();
		for(int i=0;i<M; i++){
			for(int j=0;j<N;j++){
				boards.add(new Board(i, j));
			}
		}
		
		int[] out = new int[Math.min(M, N)+1];
		for(int i=0;i<out.length;i++) out[i] = 0;

		int nb = 0;
		
		while(boards.size()>0) {
			Collections.sort(boards);
			Board b = boards.remove(0);
			if(b.size()==0) continue;
			
			if(out[b.size()]==0) nb++;
			out[b.size()]++;
			
			int size = b.size();
			int X = b.tx(), X_end=min(b.x+size+1, M);
			int Y=b.ty(), Y_end=min(b.y+size+1, N);
			
			for(int i=X;i<X_end;i++) {
				for(int j=Y;j<Y_end;j++) {
						corner[i][j] = max(0, min(max(j-b.y, i-b.x) ,corner[i][j]));
				}
			}
		}

		out("Case #"+Integer.toString(current_pb_nb+1)+": "+nb);
		
		for(int i=out.length-1;i>=0;i--) {
			if(out[i]!=0) out(i+" "+out[i]);
		}
		
		return null;
	}
	
	class Board implements Comparable<Board> {
		public Board(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}

		public int x;
		public int y;
		
		int size() { return corner[x][y]; }
		
		@Override
		public int compareTo(Board o) {
			if(size()!=o.size()) return o.size()-size();
			if(x!=o.x) return x-o.x;
			return y-o.y;
		}
		
		int tx(){ return x-size()+1;}
		int ty(){ return y-size()+1;}

		@Override
		public String toString() {
			return "x["+tx()+".."+x+"] y["+ty()+".."+y+"] size["+size()+"]";
		}
	}

}


