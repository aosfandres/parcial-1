package edu.eci.arsw.primefinder;

import edu.eci.arsw.math.MathUtilities;
import java.math.BigInteger;
import java.util.LinkedList;
import java.util.List;

public class PrimeFinder extends Thread { // clase que realiza la busqueda se entiende debe ser hilo

	private BigInteger a;
	private BigInteger b;
	private PrimesResultSet prs;

	public PrimeFinder(BigInteger a, BigInteger b, PrimesResultSet prs) {
		this.a = a;
		this.b = b;
		this.prs = prs;
	}

	@Override
	public void run() {
		
		findPrimes(a, b, prs);

	}

	public static void findPrimes(BigInteger _a, BigInteger _b, PrimesResultSet prs) {

		BigInteger a = _a;
		BigInteger b = _b;

		MathUtilities mt = new MathUtilities();

		int itCount = 0;

		BigInteger i = a;
		while (i.compareTo(b) <= 0) {
			itCount++;
			if (mt.isPrime(i)) {
				prs.addPrime(i);
			}

			i = i.add(BigInteger.ONE);
		}

	}
	
	
}
