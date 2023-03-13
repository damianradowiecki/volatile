package pl.damianradowiecki;

public class DelayWrite {

    //private static String str = null; //this not
    private volatile static String str = null; //this works

    public static void main(String[] args) throws InterruptedException {
        new Thread(() -> { while (str == null);}).start();
        Thread.sleep(100);
        str = "value";
    }
}
