package Sunlit.reflection;
import Sunlit.annotations.AnnotatedMethodAndClass;
import Sunlit.annotations.DataContainer;
import Sunlit.annotations.TimeAndPriorities;
import Sunlit.annotations.TimeAndPriority;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.*;


public class Reflection {
    public static void annotatedClassCreated (int dayOfWeek, int value, String key) {
        DataContainer dataContainer;
        try {
            dataContainer = new DataContainer(key, value);
        } catch (Exception e) {
            throw new Error(e.getMessage());
        }

        try {
            dataContainer = DataContainer.class.getConstructor(int.class, String.class).newInstance(value, key);
        } catch (Exception e) {
            throw new Error(e.getMessage());
        }

        Queue<Method> methodQueue = new PriorityQueue<>((x, y) -> {
            int priorityX = 0;
            if (x.isAnnotationPresent(TimeAndPriority.class)) {
                priorityX = x.getAnnotation(TimeAndPriority.class).priority();
            } else if (x.isAnnotationPresent(TimeAndPriorities.class)) {
                TimeAndPriority[] timePriorities = x.getAnnotation(TimeAndPriorities.class).value();
                int min = timePriorities[0].priority();
                for (int timePriorityNumber = 1; timePriorityNumber < timePriorities.length; timePriorityNumber++) {
                    min = Math.min(min, timePriorities[timePriorityNumber].priority());
                }
                priorityX = min;
            }
            int priorityY = 0;
            if (y.isAnnotationPresent(TimeAndPriority.class)) {
                priorityY = y.getAnnotation(TimeAndPriority.class).priority();
            } else if (y.isAnnotationPresent(TimeAndPriorities.class)) {
                TimeAndPriority[] timePriorities = y.getAnnotation(TimeAndPriorities.class).value();
                int min = timePriorities[0].priority();
                for (int timePriorityNumber = 1; timePriorityNumber < timePriorities.length; timePriorityNumber++) {
                    min = Math.min(min, timePriorities[timePriorityNumber].priority());
                }
                priorityY = min;
            }
            return Integer.compare(priorityX, priorityY);
        });

        try {
            Method[] classMethod = AnnotatedMethodAndClass.class.getMethods();
            for (Method method: classMethod) {
                if (method.isAnnotationPresent(TimeAndPriority.class) || method.isAnnotationPresent(TimeAndPriorities.class)) {
                    methodQueue.add(method);
                }
            }

            for (Method method: methodQueue) {
                if (method.getParameters().length == 2) {
                    method.invoke(dataContainer, dataContainer, dataContainer);
                } else if (method.getParameters().length == 1) {
                    method.invoke(dataContainer, dataContainer);
                }
            }

        } catch (Exception e) {
            throw new Error(e.getMessage());
        }

        try {
            Field keyField = dataContainer.getClass().getDeclaredField("key");
            Field valueField = dataContainer.getClass().getDeclaredField("value");

            keyField.setAccessible(true);
            valueField.setAccessible(true);

            String classKey = (String) keyField.get(dataContainer);
            int classValue = valueField.getInt(dataContainer);

            System.out.println("DataContainer state: key = " + classKey + ", value = " + classValue);
        } catch (Exception e) {
            throw new Error(e.getMessage());
        }
    }
}
