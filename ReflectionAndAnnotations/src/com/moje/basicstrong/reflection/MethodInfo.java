package com.moje.basicstrong.reflection;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

public class MethodInfo {

  public static void main(String[] args)
      throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {

    Entity e = new Entity(10, "id");

    Class<? extends Entity> clazz1 = e.getClass();

    Method[] methods = clazz1.getMethods();

    System.out.println("getMethods");
    Arrays.stream(methods)
        .forEach(
            m -> {
              System.out.println("methodName: " + m.getName());
            });

    System.out.println();
    System.out.println("getDeclaredMethods");
    Method[] declaredMethods = clazz1.getDeclaredMethods();

    Arrays.stream(declaredMethods)
        .forEach(
            m -> {
              System.out.println("methodName: " + m.getName());
            });

    System.out.println();

    Method setVal = clazz1.getMethod("setVal", int.class);
    setVal.invoke(e, 27);

    Method getVal = clazz1.getMethod("getVal");
    Object invoked = getVal.invoke(e);
    System.out.println(invoked);

    Method setTestPrivateField = clazz1.getDeclaredMethod("setTestPrivateField", int.class);
    setTestPrivateField.invoke(e, 33);

    Method getTestPrivateField = clazz1.getDeclaredMethod("getTestPrivateField");
    Object invokedP = getTestPrivateField.invoke(e);
    System.out.println(invokedP);
  }
}
