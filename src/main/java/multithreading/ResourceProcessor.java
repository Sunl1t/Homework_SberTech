package multithreading;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResourceProcessor {
    private final Resource resource;

    public ResourceProcessor(Resource resource) {
        this.resource = resource;
    }
    public synchronized void increase()
    {
        resource.setValue(resource.getValue() + 1);
        System.out.println("Increase resource value: " + resource.getValue());
    }

    public synchronized void decrease(){
        resource.setValue(resource.getValue() - 1);
        System.out.println("Decrease resource value: " + resource.getValue());
    }

    public synchronized void waitForIncrease() {
        while (resource.getValue() >= 5) {
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
    public synchronized void waitForDecrease() {
        while (resource.getValue() < 1) {
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
    public synchronized void notifyProcessor() {
        notifyAll();
    }
}
