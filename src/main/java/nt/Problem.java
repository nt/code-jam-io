package nt;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import nt.utils.VI;

public abstract class Problem<T extends Case> {

	/*
	 * Nomber of test cases
	 */
	int N;
	
	BufferedReader reader;
	
	BufferedWriter writer;
	
	static String DEFAULT_IN = "/Users/nicolas/Desktop/in.txt";
	static String DEFAULT_OUT = "/Users/nicolas/Desktop/out.txt";
	
	public Problem() throws NumberFormatException, FileNotFoundException, IOException {
		this(DEFAULT_IN, DEFAULT_OUT);
	}
	
	public Problem(String in, String out) throws NumberFormatException, FileNotFoundException, IOException {
		this(new FileInputStream(in), new BufferedWriter(new FileWriter(out)));
	}
	
	public Problem(InputStream is, BufferedWriter writer) throws NumberFormatException, IOException {
		reader = new BufferedReader(new InputStreamReader(is));
		this.writer = writer;
		N = Integer.valueOf(reader.readLine());
	}
	
	public void solve() throws Exception {
		for(int i=0;i<N;i++) {
			T c = buildCase(reader);
			String s = "Case #"+Integer.toString(i+1)+": "+c.solve();
			System.out.println(s);
			writer.write(s);
			writer.write("\n");
		}
		writer.close();
		reader.close();
	}

	public abstract T buildCase(BufferedReader reader) throws Exception;

	protected int nextInt() throws NumberFormatException, IOException {
		return Integer.valueOf(reader.readLine());
	}
	
	protected VI nextVI() throws IOException {
		String[] in = reader.readLine().split(" ");
		VI vector = new VI(in.length);
		for(String i:in) {
			vector.add(Integer.valueOf(i));
		}
		return vector;
	}
	
	
}
