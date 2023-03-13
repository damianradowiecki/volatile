package pl.damianradowiecki;

import java.util.Random;

public class DocumentationExample {

    static int storedI = -1;
    static int storedJ = -1;

    static int i = 0, j = 0;

    static synchronized void one() {
        i++;
        j++;
    }

    static synchronized void two() {
        storedI = i;
        storedJ = j;
        if (storedI != storedJ) {
            System.out.println("i:" + i + " j:" + j);
            System.out.println("storedI:" + storedI + " storedJ:" + storedJ);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        new Thread(() -> {
            while (true) {
                one();
            }
        }).start();
        while (true) {
            Thread.sleep(new Random().nextInt(1000) + 100);
            new Thread(() -> two()).start();
        }
    }

}
