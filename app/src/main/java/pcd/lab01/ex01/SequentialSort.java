package pcd.lab01.ex01;

import java.util.Arrays;
import java.util.Random;

public class SequentialSort {

        static final int VECTOR_SIZE = 200000000;
//    static final int VECTOR_SIZE = 1024;
    static final int STEP = 64;

    public static void main(String[] args) {

        log("Generating array...");

        MyThreadSequential[] threads = new MyThreadSequential[VECTOR_SIZE / STEP];
        long[] v = genArray(VECTOR_SIZE);

        log("Array generated.");
        log("Sorting (" + VECTOR_SIZE + " elements)...");

        for (int i = STEP; i < VECTOR_SIZE; i += STEP) {
            int endIndex = i - 1;
            if (VECTOR_SIZE - i < STEP) {
                endIndex = VECTOR_SIZE - 1;
            }
            threads[i / STEP] = new MyThreadSequential((i - STEP) + "", v, i - STEP, endIndex);
            threads[i / STEP].start();
        }

        long t0 = System.nanoTime();
        Arrays.sort(v, 0, v.length);
        long t1 = System.nanoTime();
        log("Done. Time elapsed: " + ((t1 - t0) / 1000000) + " ms");

        // dumpArray(v);
    }


    private static long[] genArray(int n) {
        Random gen = new Random(System.currentTimeMillis());
        long v[] = new long[n];
        for (int i = 0; i < v.length; i++) {
            v[i] = gen.nextLong();
        }
        return v;
    }

    private static void dumpArray(long[] v) {
        for (long l : v) {
            System.out.print(l + " ");
        }
    }

    private static void log(String msg) {
        System.out.println(msg);
    }
}
