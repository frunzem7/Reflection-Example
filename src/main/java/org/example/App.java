package org.example;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) throws Exception {
        Cat myCat = new Cat("Stela", 6);
        Field[] catFields = myCat.getClass().getDeclaredFields();

        for (Field field : catFields) {
            if (field.getName().equals("name")) {
                field.setAccessible(true);
                field.set(myCat, "Jimmy McGill");
            }
        }
        Method[] catMethods = myCat.getClass().getDeclaredMethods();

        for (Method method : catMethods) {
            if (method.getName().equals("thisIsAPrivateStaticMethod")) {
                method.setAccessible(true);
                method.invoke(null);
            }
        }
    }
}
