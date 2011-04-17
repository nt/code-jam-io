package nt.utils;

import java.math.BigInteger;
import java.util.ArrayList;

public class VI extends ArrayList<Integer> {
	
	public VI(int size) {
		super(size);
	}

	public BigInteger scalar(VI other) {
		BigInteger sum = BigInteger.ZERO;
		for(int i=0;i<this.size();i++) {
			sum=sum.add(BigInteger.valueOf(get(i)*other.get(i)));
		}
		return sum;
	}
	
	
}
