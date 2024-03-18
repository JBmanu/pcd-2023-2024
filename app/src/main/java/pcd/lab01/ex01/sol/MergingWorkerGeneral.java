package pcd.lab01.ex01.sol;

import java.util.List;

public class MergingWorkerGeneral extends AbstractWorker {
	
	private final int[] array;
	private final List<SortingWorker> workers;
	
	public MergingWorkerGeneral(final String name, final int[] array, final List<SortingWorker> workers){
		super(name);
		this.array = array;
		this.workers = workers;
	}
	
	public void run() {
		final int nParts = this.workers.size();
        this.log("started - merging " + nParts +" parts");
        this.log("waiting for subparts to be sorted...");
		try {
			for (final var w1: this.workers) {
				w1.join();
			}
            this.log("subparts sorted, going to merge...");
			
			final long t0 = System.currentTimeMillis();
			final int[] merged = this.merge(this.array, nParts);
            System.arraycopy(merged, 0, this.array, 0, merged.length);
			final long t1 = System.currentTimeMillis();
            this.log("completed -- " + (t1 - t0) + " ms for merging.");
		} catch(final InterruptedException ex) {
            this.log("exception.");
		}
	}
	
	private int[] merge(final int[] v, final int nParts) {
		final int[] vnew = new int[v.length];

		final int partSize = v.length/nParts;
		int from = 0; 

		final int[] indexes = new int[nParts];
		final int[] max = new int[nParts];
		for (int i = 0; i < indexes.length - 1; i++) {
			indexes[i] = from;
			max[i] = from + partSize;
			from = max[i];
		}
		indexes[indexes.length - 1] = from;
		max[indexes.length - 1] = v.length;

		int i3 = 0;
		boolean allFinished = false;
		while (!allFinished) {
			
			int min = Integer.MAX_VALUE;
			int index = -1;
			for (int i = 0; i < indexes.length; i++) {
				if (indexes[i] < max[i]) {
					if (v[indexes[i]] < min) {
						index = i;
						min = v[indexes[i]];
					}
				}
			}
			
			if (index != -1) {
				vnew[i3] = v[indexes[index]];
				indexes[index]++;
				i3++;
			} else {
				allFinished = true;
			}
		}
		return vnew;
	}

}
