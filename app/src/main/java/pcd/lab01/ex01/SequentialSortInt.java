package pcd.lab01.ex01;

import java.util.*;

public class SequentialSortInt {

	static final int VECTOR_SIZE = 400_000_000;
	
	public static void main(final String[] args) {
	
		log("Generating array...");
		final int[] v = genArray(VECTOR_SIZE);
		
		log("Array generated.");
		log("Sorting (" + VECTOR_SIZE + " elements)...");
	
		final long t0 = System.nanoTime();
		Arrays.sort(v, 0, v.length);
		final long t1 = System.nanoTime();
		log("Done. Time elapsed: " + ((t1 - t0) / 1000000) + " ms");
		
		// dumpArray(v);
	}


	private static int[] genArray(final int n) {
		final Random gen = new Random(System.currentTimeMillis());
		final int[] v = new int[n];
		for (int i = 0; i < v.length; i++) {
			v[i] = gen.nextInt();
		}
		return v;
	}

	private static void dumpArray(final int[] v) {
		for (final int l:  v) {
			System.out.print(l + " ");
		}
		System.out.println();
	}

	private static void log(final String msg) {
		System.out.println(msg);
	}
}
