package main;

import list.constructor.StringList;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        String[] strings = new String[]{"Первый", "Второй"};
        String[] strings2 = new String[]{"Первый", "Второй", "Третий", "Четвёртый"};
        StringList stringList = new StringList(strings);
        StringList stringList2 = new StringList(strings2);
        System.out.println(stringList.equals(stringList2));
        System.out.println(stringList);
        System.out.println(stringList.size());
        stringList.add("третий");
        System.out.println(stringList);
        System.out.println(stringList.size());
        stringList.add("Четвёртый");
        System.out.println(stringList);
        System.out.println(stringList.size());
        stringList.add("Пятый");
        System.out.println(stringList);
        System.out.println(stringList.size());
        System.out.println("stringList2 = " + stringList2);
        System.out.println(stringList2.size());
        System.out.println("-------------------------------------");
        System.out.println();


        stringList.add(3, "Машина");
        System.out.println(stringList);
        System.out.println(stringList.size());
        stringList.add(5, "кузня");
        System.out.println(stringList);
        System.out.println("stringList.getSize() = " + stringList.size());
        stringList.add("яма");
        System.out.println(stringList);
        System.out.println(stringList.size());
        stringList.set(3, "самолёт");
        System.out.println(stringList);
        stringList.remove("самолёт");
        System.out.println(stringList);
        System.out.println(stringList.size());
        stringList.remove(4);
        System.out.println(stringList);
        System.out.println(stringList.size());
        System.out.println(stringList.contains("яма"));
        System.out.println(stringList.indexOf("яма"));
        System.out.println(stringList.lastIndexOf("яма"));
        System.out.println(stringList.get(2));
        System.out.println(Arrays.toString(stringList.toArray()));
        stringList.clear();
        System.out.println(stringList);
        System.out.println(stringList.size());
        System.out.println(stringList.isEmpty());
    }
}