package pl.damianradowiecki;

public class VolatileBaseExample {

    //private static boolean BOOL = true; //this not
    private volatile static boolean IS_RUNNING = true; //this works

    public static void main(String[] args) throws InterruptedException {
        new Thread(() -> { while (IS_RUNNING) { } }).start();
        Thread.sleep(100);
        IS_RUNNING = false;
    }
}
