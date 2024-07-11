package Sunlit.reflection;
import Sunlit.annotations.*;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.*;


public class Reflection {
    public static void annotatedClassCreated(int dayOfWeek, int value, String key) {
        DataContainer dataContainer = new DataContainer(key, value);

        List<Object> instances = createInstancesForDayOfWeek(dayOfWeek);

        invokeMethodsByPriority(instances, dataContainer);
    }

    private static List<Object> createInstancesForDayOfWeek(int dayOfWeek) {
        List<Object> instances = new ArrayList<>();

        Class<?>[] classes = {AnnotatedClass.class,AnnotatedMethodAndClass.class,AnnotatedMethodAndClass.AnnotatedMethodAndSubclass.class};

        for (Class<?> clazz : classes) {
            InheritanceAnnotation annotation = clazz.getAnnotation(InheritanceAnnotation.class);
            if (annotation != null && annotation.dayOfWeek() == dayOfWeek) {
                try {
                    Object instance = clazz.getDeclaredConstructor().newInstance();
                    instances.add(instance);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return instances;
    }

    private static void invokeMethodsByPriority(List<Object> instances, DataContainer dataContainer) {
        List<Method> methodList = new ArrayList<>();

        for (Object instance : instances) {
            Method[] allMethods = instance.getClass().getDeclaredMethods();
            for (Method method : allMethods) {
                if (method.isAnnotationPresent(TimeAndPriority.class) || method.isAnnotationPresent(TimeAndPriorities.class)) {
                    methodList.add(method);
                }
            }
        }

        methodList.sort((x, y) -> {
            int priorityX = getMethodPriority(x);
            int priorityY = getMethodPriority(y);
            return Integer.compare(priorityX, priorityY);
        });

        for (Method method : methodList) {
            try {
                if (method.getParameterCount() == 1) {
                    method.invoke(method.getDeclaringClass().newInstance(), dataContainer);
                }
                checkDataContainerState(dataContainer);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private static int getMethodPriority(Method method) {
        int priority = Integer.MAX_VALUE;

        if (method.isAnnotationPresent(TimeAndPriority.class)) {
            priority = method.getAnnotation(TimeAndPriority.class).priority();
        } else if (method.isAnnotationPresent(TimeAndPriorities.class)) {
            TimeAndPriority[] timePriorities = method.getAnnotation(TimeAndPriorities.class).value();
            for (TimeAndPriority tp : timePriorities) {
                if (tp.priority() < priority) {
                    priority = tp.priority();
                }
            }
        }
        return priority;
    }
    
    private static void checkDataContainerState(DataContainer dataContainer) {
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
