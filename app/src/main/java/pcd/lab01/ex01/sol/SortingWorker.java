package pcd.lab01.ex01.sol;

import java.util.Arrays;

public class SortingWorker extends AbstractWorker {
	
	private final int[] array;
	private final int from;
    private final int to;
	
	public SortingWorker(final String name, final int[] array, final int from, final int to){
		super(name);
		this.array = array;
		this.from = from;
		this.to = to;
		
	}
	
	public void run() {
        this.log("started - sorting from " + this.from + " " + this.to);
		Arrays.sort(this.array, this.from, this.to + 1);
        this.log("completed.");
	}
}
