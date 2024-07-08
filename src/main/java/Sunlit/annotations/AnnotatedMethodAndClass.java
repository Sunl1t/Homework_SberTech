package Sunlit.annotations;

import lombok.NonNull;

@InheritanceAnnotation(dayOfWeek = 0)
public class AnnotatedMethodAndClass extends AnnotatedClass {
    @TimeAndPriority(hour = 11, priority = 1, description = "The most important task")

    public void dataContainerProcess(@NonNull DataContainer dataContainer) {
        new DataContainer(dataContainer.getKey(), dataContainer.getValue());
    }

@InheritanceAnnotation(dayOfWeek = 5)
public static class AnnotatedMethodAndSubclass extends AnnotatedClass{
    @TimeAndPriority(hour = 2, priority = 9, description = "Unimportant task")

    public static boolean isEmptyDataContainer(@NonNull DataContainer dataContainer) {
        return dataContainer.getValue() == 0 && dataContainer.getKey().isEmpty();
    }
}

}



