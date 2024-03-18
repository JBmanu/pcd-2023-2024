package pcd.lab01.ex01.sol;

public class MergingWorkerTwoParts extends AbstractWorker {
	
	private final int[] array;
	private final SortingWorker w1;
    private final SortingWorker w2;
	
	public MergingWorkerTwoParts(final String name, final int[] array, final SortingWorker w1, final SortingWorker w2){
		super(name);
		this.array = array;
		this.w1 = w1;
		this.w2 = w2;		
	}
	
	public void run() {
        this.log("started merging.");
        this.log("waiting for subparts to be sorted...");
		try {
			final long t0 = System.currentTimeMillis();
            this.w1.join();
            this.w2.join();
            this.log("subparts sorted, going to merge...");
			final int[] merged = this.merge(this.array);
            System.arraycopy(merged, 0, this.array, 0, merged.length);
			final long t1 = System.currentTimeMillis();
            this.log("completed -- " + (t1 - t0) + " ms for merging.");
		} catch(final InterruptedException ex) {
            this.log("exception.");
		}
	}
	
	private int[] merge(final int[] v) {
		final int[] vnew = new int[v.length];
		int i1 = 0;
		final int max1 = v.length/2;
		int i2 = max1;
		final int max2 = v.length;
		int i3 = 0;
		while ((i1 < max1) && (i2 < max2)) {
			if (v[i1] < v[i2]) {
				vnew[i3] = v[i1];
				i1++;
			} else {
				vnew[i3] = v[i2];
				i2++;
			}
			i3++;
		}
		if (i1 < max1) {
			while (i1 < max1) {
				vnew[i3] = v[i1];
				i1++;
				i3++;
			}
		} else {
			while ((i2 < max2)) {
				vnew[i3] = v[i2];
				i2++;
				i3++;
			}
		}
		return vnew;
	}

}
