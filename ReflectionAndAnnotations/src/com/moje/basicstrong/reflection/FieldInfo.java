package com.moje.basicstrong.reflection;

import java.lang.reflect.Field;
import java.util.Arrays;

public class FieldInfo {

  public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {

    Entity e = new Entity(10, "id");

    Class<? extends Entity> clazz1 = e.getClass();

    Field[] fields = clazz1.getFields();
    Arrays.stream(fields)
        .forEach(
            field -> {
              System.out.println(
                  "A. fieldName:" + field.getName() + " , fieldType: " + field.getType().getName());
            });

    Field[] fieldsD = clazz1.getDeclaredFields();
    Arrays.stream(fieldsD)
        .forEach(
            field -> {
              System.out.println(
                  "B. fieldName:" + field.getName() + " , fieldType: " + field.getType().getName());
            });

    System.out.println("before: type= " + e.getType());
    Field typeField = clazz1.getField("type");
    typeField.set(e, "rollNo.");
    System.out.println("after: type= " + e.getType());

    System.out.println("before: val= " + e.getVal());
    //    Field valField = clazz1.getField("val");
    Field valField = clazz1.getDeclaredField("val");
    valField.setAccessible(true);
    valField.set(e, 23);
    System.out.println("before: val= " + e.getVal());
  }
}
