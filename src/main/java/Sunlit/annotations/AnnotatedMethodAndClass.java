package sunlit.annotations;

import lombok.NonNull;

@InheritanceAnnotation(dayOfWeek = 0)
public class AnnotatedMethodAndClass extends AnnotatedClass {
    @TimeAndPriority(hour = 11, priority = 1, description = "The most important task")
    @TimeAndPriority(hour = 13, priority = 2, description = "Important task")
    @TimeAndPriority(hour = 16, priority = 3, description = "Just a task")
    public void dataContainerProcess(@NonNull DataContainer dataContainer) {
        new DataContainer(dataContainer.getKey(), dataContainer.getValue());
    }


public static class AnnotatedMethodAndSubclass extends AnnotatedClass{
    @TimeAndPriority(hour = 23, priority = 9, description = "Unimportant task")

    public static boolean isEmptyDataContainer(@NonNull DataContainer dataContainer) {
        return dataContainer.getValue() == 0 && dataContainer.getKey().isEmpty();
    }
}

}



