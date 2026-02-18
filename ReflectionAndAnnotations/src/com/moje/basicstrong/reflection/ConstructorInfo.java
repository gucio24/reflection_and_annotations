package com.moje.basicstrong.reflection;

import java.lang.reflect.Constructor;
import java.util.Arrays;

public class ConstructorInfo {

  public static void main(String[] args) throws Exception {

    Entity e = new Entity(10, "id");

    //    Class<? extends Entity> clazz = e.getClass();
    Class<?> clazz = Class.forName("com.moje.basicstrong.reflection.Entity");

    System.out.println();

    Constructor<?>[] constructors = clazz.getConstructors();
    Arrays.stream(constructors)
        .forEach(
            c ->
                System.out.println(
                    "constructor: "
                        + c.toString()
                        + ", name: "
                        + c.getName()
                        + " , modifiers: "
                        + c.getModifiers()));

    System.out.println();

    Constructor<?>[] declaredConstructors = clazz.getDeclaredConstructors();
    Arrays.stream(declaredConstructors)
        .forEach(
            c ->
                System.out.println(
                    "declaredConstructor: "
                        + c.toString()
                        + " name: "
                        + c.getName()
                        + " , modifiers: "
                        + c.getModifiers()));

    System.out.println();

    Constructor<?> publicConstructor = clazz.getConstructor(int.class, String.class);
    System.out.println("constructor: " + publicConstructor.toString());
    Entity hello = (Entity) publicConstructor.newInstance(1, "hello");
    System.out.println(hello.getVal() + " :: " + hello.getType());

    System.out.println();

    //    Constructor<?> constructor1 = clazz.getConstructor();
    //    System.out.println("constructor1: " + constructor1.toString());

    System.out.println();

    Constructor<?> privateConstructor = clazz.getDeclaredConstructor();
    System.out.println("privateConstructor: " + privateConstructor.toString());
    privateConstructor.setAccessible(true);
    Entity defaultE = (Entity) privateConstructor.newInstance();
    System.out.println(defaultE.getVal() + " :: " + defaultE.getType());

    System.out.println();
  }
}
