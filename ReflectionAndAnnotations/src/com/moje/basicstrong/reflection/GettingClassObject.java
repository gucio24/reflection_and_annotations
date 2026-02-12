package com.moje.basicstrong.reflection;

import java.util.Arrays;

class MyNewClass {
  MyNewClass() {
    System.out.println("MyNewClass created");
  }
}

public class GettingClassObject {
  public static void main(String[] args) throws ClassNotFoundException {

    // forName

    Class<?> clazz1 = Class.forName("java.lang.String");
    Class<?> clazz2 = Class.forName("java.lang.String");

    System.out.println(clazz1 == clazz2);

    // ClassName.class

    Class<?> clazz3 = int.class;
    Class<?> clazz4 = Integer.class;
    Class<?> clazz5 = String.class;

    // object.getClass()

    MyNewClass myNewClass = new MyNewClass();
    Class<? extends MyNewClass> clazz6 = myNewClass.getClass();

    // super class
    Class<?> superclass = clazz6.getSuperclass();
    System.out.println("superclass: " + superclass);

    // interfaces
    Class<?>[] interfaces = clazz6.getInterfaces();
    System.out.println("interfaces: " + Arrays.toString(interfaces));

    // getName
    String clazz6Name = clazz6.getName();
    System.out.println("getName(): " + clazz6Name);
  }
}
