package nt.utils;

public class ArrayUtils {
	
	public static int[][] newArray(int x, int y, int def) {
		int[][] a = new int[x][y];
		for(int i=0;i<x;i++) for(int j=0;j<y;j++) a[i][j] = def;
		return a;
	}
	
}
