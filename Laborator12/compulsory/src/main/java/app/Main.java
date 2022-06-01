package app;

import test.Test;

import java.lang.reflect.*;

public class Main {
    public static void main(String args[]) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Class clazz = Class.forName(args[0]);
        System.out.println("Metode:");
        for (Method m : clazz.getMethods()) {
            System.out.println(m.getName());
        }
        System.out.println("Se afla in pachetul: " + clazz.getPackageName());
        System.out.println("Superclasa: " + clazz.getSuperclass());

        int passed = 0, failed = 0;
        for (Method m : clazz.getMethods()) {
            Constructor constructor = clazz.getConstructor();
            Object object = constructor.newInstance();
            if (m.isAnnotationPresent(Test.class)) {
                try {
                    m.invoke(object);
                    passed++;
                } catch (Throwable ex) {
                    System.out.printf("Test %s failed: %s %n", m, ex.getCause());
                    failed++;
                }
            }
        }
        System.out.printf("Passed: %d, Failed %d%n", passed, failed);
    }
}
