package nt.example;

import java.io.FileNotFoundException;
import java.io.IOException;

import nt.Problem;
import nt.utils.ArrayUtils;
import nt.utils.VI;

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
	


	int[][] left;
	int[][] top;
	int[][] corner;
	boolean[][] table;
	
	int M;
	int N;
	
	@Override
	public Object solve() throws Exception {
		
		VI v = nextVI();
		M = v.get(0);
		N = v.get(1);
		
		left = ArrayUtils.newArray(M, N, 0);
		top = ArrayUtils.newArray(M, N, 0);
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
		
		for(int i=0;i<M;i++) {
			left[i][0] = 1;
			for(int j=1;j<N;j++) {
				if(table[i][j] ^ table[i][j-1] == true) left[i][j] = left[i][j-1] + 1;
				else left[i][j] = 1;
			}
		}
		
		//p(left);
		
		for(int j=0;j<N;j++) {
			top[0][j] = 1;
			for(int i=1;i<M;i++) {
				if(table[i][j] ^ table[i-1][j] == true) top[i][j] = top[i-1][j] + 1;
				else top[i][j] = 1;
			}
		}
		
//		p(top);
		
//		corner[0][0] = 1;
		for(int i=0;i<M; i++) {
			corner[i][0] = 1;
		}
		
		for(int j=0;j<N;j++) {
			corner[0][j] = 1;
		}
		
		calculateCorner();
		
//		p(corner);
		
		int[] boards = new int[Math.min(M, N)];
		for(int i=0;i<boards.length;i++) boards[i] = 0;
		

		int nb = 0;
		
		while(!isEmpty()) {
			p(corner);
			p("---");
			int i = nextBiggestI();
			int j = nextBiggestJ();
			int size = corner[i][j];
			remove(i, j, size);
			if(boards[size] == 0) nb++;
			boards[size]++;
		}
		
		
		for(int i=boards.length-1;i>=0;i--) {
			if(boards[i]!=0) p(i+" "+boards[i]);
		}
		
		return nb;
	}

	int nextBiggestI() {
		int tmp_i = 0, tmp_j =0;
		int biggest = 0;
		for(int i=0;i<M; i++) {
			for(int j=0;j<N;j++) {
				if(corner[i][j]>biggest){
					tmp_i = i;
					tmp_j = j;
					biggest = corner[i][j];
				}
			}
		}
		return tmp_i;
	}
	
	int nextBiggestJ() {
		int tmp_i = 0, tmp_j =0;
		int biggest = 0;
		for(int i=0;i<M; i++) {
			for(int j=0;j<N;j++) {
				if(corner[i][j]>biggest){
					tmp_i = i;
					tmp_j = j;
					biggest = corner[i][j];
				}
			}
		}
		return tmp_j;
	}
	
	boolean isEmpty() {
		for(int i=0;i<M; i++) {
			for(int j=0;j<N;j++) {
				if(corner[i][j]!=0) return false;
			}
		}
		
		return true;
	}
	
	void remove(int x, int y, int size) {
		for(int i=0;i<size;i++) for(int j=0;j<size;j++) {
			corner[x-i][y-j] = 0;
			top[x-i][y-j] = 0;
			left[x-i][y-j] = 0;
		}
		for(int i=0;i<size;i++) top[x-i][y] = 1;
		for(int j=0;j<size;j++) left[x][y-j] = 1;
		calculateCorner();
	}
	
	void calculateCorner() {
		for(int i=1;i<M; i++) {
			for(int j=1;j<N;j++) {
				if(table[i][j] ^ table[i-1][j-1]) {
					corner[i][j] = 1;
				}
				corner[i][j] = Math.min(corner[i-1][j-1]+1, Math.min(left[i][j], top[i][j]));
			}
		}
	}
}
