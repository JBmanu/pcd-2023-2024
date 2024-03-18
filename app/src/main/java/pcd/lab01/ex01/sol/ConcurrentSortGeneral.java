package pcd.lab01.ex01.sol;

import java.util.*;

public class ConcurrentSortGeneral {

	static final int VECTOR_SIZE = 400_000_000;
	static final boolean isDebugging = false;
	
	public static void main(final String[] args) {
	
		log("Generating array...");
		final int[] v = genArray(VECTOR_SIZE);
		
		log("Array generated.");
		if (isDebugging) {
			dumpArray(v);
		}
		
		final long t0 = System.currentTimeMillis();
		log("Spawning workers to do sorting (" + VECTOR_SIZE + " elements)...");
	
		
		final int nAgents = Runtime.getRuntime().availableProcessors();
		final int jobSize = v.length/nAgents;
		int from = 0; 
		int to = jobSize - 1;
		
		final List<SortingWorker> workers = new ArrayList<SortingWorker>();
		for (int i = 0; i < nAgents - 1; i++) {
			final var w = new SortingWorker("worker-"+(i+1), v, from, to);
			w.start();
			workers.add(w);
			from = to + 1;
			to += jobSize;
		}
		final var w = new SortingWorker("worker-"+nAgents, v, from, v.length - 1);
		w.start();
		workers.add(w);

		final MergingWorkerGeneral m = new MergingWorkerGeneral("merger", v, workers);
		m.start();
		try {
			m.join();
			final long t1 = System.currentTimeMillis();
			log("Done. Time elapsed: " + (t1 - t0) + " ms");
			
			if (isDebugging) {
				dumpArray(v);
				assert (isSorted(v));
			}
			
		} catch (final Exception ex) {
			ex.printStackTrace();
		}
	}


	private static int[] genArray(final int n) {
		int numElem = n;
		if (isDebugging) {
			numElem = 100;
			final Random gen = new Random(System.currentTimeMillis());
			final int[] v = new int[numElem];
			for (int i = 0; i < v.length; i++) {
				v[i] = gen.nextInt() % 100;
			}
			return v;
		} else {
			final Random gen = new Random(System.currentTimeMillis());
			final int[] v = new int[numElem];
			for (int i = 0; i < v.length; i++) {
				v[i] = gen.nextInt();
			}
			return v;
		}
	}

	private static boolean isSorted(final int[] v) {
		if (v.length == 0) {
			return true;
		} else {
			int curr = v[0];
			for (int i = 1; i < v.length; i++) {
				if (curr > v[i]) {
					return false;
				} else {
					curr = v[i];
				}
			}
			return true;
		}
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
