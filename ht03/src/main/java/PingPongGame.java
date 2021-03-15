public class PingPongGame {

    private static final int COUNT_MAX = 10;

    public static void play() {
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < COUNT_MAX; i++) {
                write("Ping");
            }
        });
        Thread t2 = new Thread(() -> {
            for (int i = 0; i < COUNT_MAX; i++) {
                write("Pong");
            }
        });

        t1.start();
        t2.start();
    }

    private static synchronized void write(String s) {
        System.out.println(s);
        PingPongGame.class.notify();
        try {
            PingPongGame.class.wait(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
