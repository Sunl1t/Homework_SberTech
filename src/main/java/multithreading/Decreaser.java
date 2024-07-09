package multithreading;

public class Decreaser implements Runnable {
    private final ResourceProcessor processor;

    public Decreaser(ResourceProcessor processor) {
        this.processor = processor;
    }

    @Override
    public void run() {
        for (int number = 0; number < 10; number++) {
            synchronized (processor) {
                processor.waitForDecrease();
                processor.decrease();
                processor.notifyProcessor();
            }
        }
        }
}
