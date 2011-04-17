package nt;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public abstract class Problem<T extends Case> {

	/*
	 * Nomber of test cases
	 */
	int N;
	
	BufferedReader reader;
	
	BufferedWriter writer;
	
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
	
}
