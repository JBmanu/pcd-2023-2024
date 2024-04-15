package pcd.lab01.ex01;

import java.util.Arrays;

public class MyThreadSequential extends Thread {
    private final String name;
    private final long[] list;
    private final int startIndex;
    private final int endIndex;

    public MyThreadSequential(String name, long[] list, int startIndex, int endIndex) {
        this.name = "Thread[" + name + "]";
        this.list = list;
        this.startIndex = startIndex;
        this.endIndex = endIndex;
    }

    @Override
    public void run() {
        long t0 = System.nanoTime();
        Arrays.sort(this.list, this.startIndex, this.endIndex);
        long t1 = System.nanoTime();
        System.out.println("Done. " + this.name + "Time elapsed: " + ((t1 - t0) / 1000000) + " ms");
    }
}
