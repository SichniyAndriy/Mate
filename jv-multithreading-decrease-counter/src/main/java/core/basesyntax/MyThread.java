package core.basesyntax;

public class MyThread extends Thread {
    private final Counter counter;

    public MyThread(Counter counter, String name) {
        super(name);
        this.counter = counter;
    }

    @Override
    public void run() {
        counter.decreaseValue();
    }
}
