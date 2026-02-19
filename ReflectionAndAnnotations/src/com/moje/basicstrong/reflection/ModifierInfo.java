package com.moje.basicstrong.reflection;

import java.lang.reflect.Modifier;

public class ModifierInfo {

  public static void main(String[] args) throws Exception {

    Entity e = new Entity(10, "id");
    Class<? extends Entity> clazz = e.getClass();

    int modifiers = clazz.getModifiers();

    System.out.println("modifiers: " + modifiers);
    System.out.println("Modifier.toString: " + Modifier.toString(modifiers));

    System.out.println();

    int i = Modifier.PUBLIC & modifiers;
    System.out.println("i = " + i);

    System.out.println();

    int modifiers1 = clazz.getMethod("getVal").getModifiers();
    int j = Modifier.PUBLIC & modifiers1;
    System.out.println("Modifier.PUBLIC = " + Modifier.PUBLIC);
    System.out.println("j = " + j);
    System.out.println("Modifier.isPublic = " + Modifier.isPublic(modifiers1));
    System.out.println("Modifier.toString: " + Modifier.toString(modifiers1));

    System.out.println();

    int modifiers3 = clazz.getDeclaredMethod("testPrivateMethod").getModifiers();
    int k = Modifier.PRIVATE & modifiers3;
    System.out.println("Modifier.PRIVATE = " + Modifier.PRIVATE);
    System.out.println("k = " + k);
    System.out.println("Modifier.isPrivate = " + Modifier.isPrivate(modifiers3));
    System.out.println("Modifier.toString: " + Modifier.toString(modifiers3));

    //    Modifier.

  }
}
