public class App {

    public static void main(String[] args) {
        PingPongGame.play();
        count();
    }

    public static void count() {
        Counter counter = new Counter();
        for (int i = 0; i < 10; i++) {
            new Thread(
                    counter::inc,
                    String.valueOf(i)
            ).start();
        }
    }

}
