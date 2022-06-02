package app;

import org.w3c.dom.TypeInfo;
import test.Test;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.*;
import java.util.*;

public class Main {

    static List<String> classes = new ArrayList<>();

    public static void Search(File dir) {
        try {
            File[] files = dir.listFiles();
            for (File file : files) {
                String path = file.getCanonicalPath();
                if (path.contains(".class")) {
                    String[] split = path.split("\\.");
                    String[] split2 = split[0].split("\\\\");
                    String pathToClass = split2[split2.length - 2] + "." + split2[split2.length - 1];
                    classes.add(pathToClass);
                }
                if (file.isDirectory())
                    Search(file);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static int randomIntValue() {
        Random random = new Random();
        return random.nextInt(1000);
    }

    public static String randomStringValue() {
        Random random = new Random();
        StringBuilder stringBuilder = new StringBuilder();
        int l = 1 + random.nextInt(20);

        for (int i = 0; i < l; i++) {
            char c = (char) (random.nextInt((int) 'a', (int) 'z'));
            stringBuilder.append(c);
        }
        return stringBuilder.toString();
    }

    public static void invokeMethod(Class clazz) {
        int passed = 0, failed = 0;
        Object object = null;
        for (Method m : clazz.getMethods()) {
            try {
                Constructor constructor = clazz.getConstructor();

                object = constructor.newInstance();
                if (m.isAnnotationPresent(Test.class)) {
                    long startTime = System.currentTimeMillis();
                    m.invoke(object);
                    long finalTime = System.currentTimeMillis();
                    System.out.println("Timpul de executie a fost de " + (finalTime - startTime) / 1000F + " secunde");
                    passed++;
                }
            } catch (IllegalArgumentException e) {
                //System.out.println("numar de parametrii invalid");
                Object[] parametersValues = new Object[m.getParameterCount()];
                int i = 0;
                for (Class<?> p : m.getParameterTypes()) {
                    if (p.getName().equals("int"))
                        parametersValues[i++] = randomIntValue();
                    if (p.getName().equals("java.lang.String")) {
                        parametersValues[i++] = randomStringValue();
                    }
                }

                try {
                    long startTime = System.currentTimeMillis();
                    m.invoke(object, parametersValues);
                    long finalTime = System.currentTimeMillis();
                    System.out.println("Timpul de executie a fost de " + (finalTime - startTime) / 1000F + " secunde");
                    passed++;
                } catch (IllegalAccessException ex) {
                    ex.printStackTrace();
                } catch (InvocationTargetException ex) {
                    System.out.printf("Test %s failed: %s %n", m, e.getCause());
                    failed++;
                }

            } catch (InvocationTargetException e) {
                System.out.printf("Test %s failed: %s %n", m, e.getCause());
                failed++;
            } catch (NoSuchMethodException | InstantiationException | IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        System.out.printf("Passed: %d, Failed %d%n", passed, failed);
    }

    public static void loadClasses() {
        for (String s : classes) {
            try {
                Class clazzz = Class.forName(s);
                if (!clazzz.isInterface()) {
                    System.out.println(clazzz.getName());
                    invokeMethod(clazzz);
                    System.out.println("-----------------------------------");
                }
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }

    public static void prototype(Class clazz) {
        int modifier = clazz.getModifiers();
        if (Modifier.isPublic(modifier))
            System.out.print("public ");
        else
            System.out.print("private ");
        if (Modifier.isStatic(modifier))
            System.out.print("static ");
        System.out.println("class " + clazz.getName().split("\\.")[1]);

        System.out.println("Package: " + clazz.getPackageName());
        System.out.println("Superclass: " + clazz.getSuperclass());

        System.out.println("Constructors:");
        for (Constructor c : clazz.getConstructors()) {
            System.out.print(c.getName().split("\\.")[1] + " ( ");
            for (Class<?> p : c.getParameterTypes())
                System.out.print(p.getName() + " ");
            System.out.println(")");
        }
        System.out.println("Methods:");
        for (Method m : clazz.getDeclaredMethods()) {
            modifier = m.getModifiers();
            if (Modifier.isPublic(modifier))
                System.out.print("public ");
            else
                System.out.print("private ");
            System.out.print(m.getReturnType() + " " + m.getName() + " ( ");
            for (Class<?> p : m.getParameterTypes()) {
                System.out.print(p.getName() + " ");
            }
            System.out.println(")");
        }
        System.out.println("Fields:");
        for (Field f : clazz.getDeclaredFields()) {
            System.out.println(f);
        }
    }

    public static void main(String args[]) {

        File currentDir = new File("C:\\Users\\Oana\\Documents\\Programare Avansata\\Laborator12");
        Search(currentDir);

        loadClasses();

        try {
            prototype(Class.forName("test.MyTests"));
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
