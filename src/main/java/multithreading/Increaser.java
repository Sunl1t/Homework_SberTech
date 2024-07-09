package multithreading;


public class Increaser extends Thread {
    private final ResourceProcessor processor;

    public Increaser(ResourceProcessor processor) {
        super();
        this.processor = processor;
    }
    public void runInc() {
        for (int number = 0; number < 6; number++) {
            synchronized (processor) {
                processor.waitForIncrease();
                processor.increase();
                processor.notifyProcessor();
            }
        }
    }
}
