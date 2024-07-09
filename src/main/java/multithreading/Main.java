package multithreading;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Resource resource = new Resource(0);
        ResourceProcessor processor = new ResourceProcessor(resource);

        for (int i = 0; i < 3; i++) {
            Thread increaser = new Increaser(processor);
            increaser.start();
        }

        Thread decreaser = new Thread(new Decreaser(processor));
        decreaser.start();

        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                synchronized (processor) {
                    processor.waitForIncrease();
                    processor.increase();
                    processor.notifyProcessor();
                }
            }
        }).start();

        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                synchronized (processor) {
                    processor.waitForDecrease();
                    processor.decrease();
                    processor.notifyProcessor();
                }
            }
        }).start();
    }
    }

