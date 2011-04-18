package nt.example;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.PriorityQueue;

import nt.Problem;
import nt.utils.ArrayUtils;
import nt.utils.VI;

import static java.lang.Math.*;
/*
 * http://code.google.com/codejam/contest/dashboard?c=619102#s=p2
 */
public class ChessBoard extends Problem {

	public ChessBoard() throws NumberFormatException, FileNotFoundException,
			IOException {
		super();
	}

	public static void main(String[] args) throws NumberFormatException, FileNotFoundException, IOException, Exception {
		new ChessBoard().solve();
	}
	
	int[][] corner;
	boolean[][] table;
	
	int M;
	int N;
	
	PriorityQueue<Board> boards;
	
	@Override
	public Object solve() throws Exception {
		
		VI v = nextVI();
		M = v.get(0);
		N = v.get(1);
		
		corner = ArrayUtils.newArray(M, N, 0);
		
		table = new boolean[M][N];
		
		for(int i=0;i<M;i++) {
			String s = nextString();
			Integer c = Integer.decode("0x"+s);
			for(int j=0;j<N/4;j++) {
				
				table[i][N-1-4*j] = (c & (1 << 4*j+0)) != 0;
				table[i][N-1-4*j-1] = (c & (1 << 4*j+1)) != 0;
				table[i][N-1-4*j-2] = (c & (1 << 4*j+2)) != 0;
				table[i][N-1-4*j-3] = (c & (1 << 4*j+3)) != 0;
			}
		}
		
		p(table);
		p("----");
		
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

		boards = new PriorityQueue<Board>(N*M);
		for(int i=0;i<M; i++){
			for(int j=0;j<N;j++){
				boards.add(new Board(j, i));
			}
		}
		
		int[] out = new int[Math.min(M, N)];
		for(int i=0;i<out.length;i++) out[i] = 0;

		int nb = 0;
		
		
		while(boards.peek()!=null) {

			Board b = boards.poll();
			if(b.size()==0) continue;
			p(corner);
			p("Removing "+b);
			
			if(out[b.size()]==0) nb++;
			out[b.size()]++;
			
			for(int i=b.tx();i<=min(b.x+b.size(), N);i++) {
				for(int j=b.ty();j<=min(b.y+b.size(),M);j++) {
					corner[i][j] = max(0, min(min(j-b.x,corner[i][j]), min(i-b.y,corner[i][j])));
				}
			}
			
		}
		
		
		for(int i=out.length-1;i>=0;i--) {
			if(out[i]!=0) p(i+" "+out[i]);
		}
		
		return nb;
	}
	
	class Board implements Comparable<Board> {
		public Board(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}

		public int x;
		public int y;
		
		int size() { return corner[y][x]; }
		
		@Override
		public int compareTo(Board o) {
			if(size()!=o.size()) return o.size()-size();
			if(y!=o.y) return o.y-y;
			return o.x-x;
		}
		
		int tx(){ return x-size()+1;}
		int ty(){ return y-size()+1;}

		@Override
		public String toString() {
			return "x["+tx()+".."+x+"] y["+ty()+".."+y+"] size["+size()+"]";
		}
	}

}


