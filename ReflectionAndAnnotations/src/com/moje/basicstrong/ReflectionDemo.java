package com.moje.basicstrong;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

class MyClass {
  private MyClass() {
    System.out.println("MyClass created");
  }
  private MyClass(String parameter) {
    System.out.println("MyClass created with parameter: " + parameter);
  }
}

public class ReflectionDemo {
  public static void main(String[] args)
      throws ClassNotFoundException,
          NoSuchMethodException,
          InvocationTargetException,
          InstantiationException,
          IllegalAccessException {

    //        MyClass myClass = new MyClass();

    Class<?> clazz = Class.forName("com.moje.basicstrong.MyClass");
//    Class<?> clazz = MyClass.class;
    Constructor<?> declaredConstructor = clazz.getDeclaredConstructor();
    declaredConstructor.setAccessible(true);
//    Object myClass = declaredConstructor.newInstance();
    MyClass myClass = (MyClass) declaredConstructor.newInstance();

    Constructor<?> declaredConstructorWihtParameter = clazz.getDeclaredConstructor(String.class);
    declaredConstructorWihtParameter.setAccessible(true);
    MyClass myClassWihtParameter = (MyClass) declaredConstructorWihtParameter.newInstance("this is text");
  }
}
