package com.quid.java.string;

public class StringExample {
    public static void main(String[] args) {
        StringExample stringExample = new StringExample();
        stringExample.run();
    }

    private void run() {
        System.out.println("StringExample.run");
        String str1 = "Hello";
        String str2 = "Hello";
        String str3 = new String("Hello");
        String str4 = new String("Hello");
        String str5 = String.valueOf("Hello");

        System.out.println("str1 == str2: " + (str1 == str2)); // true
        System.out.println("str1 == str3: " + (str1 == str3)); // false
        System.out.println("str1 == str5: " + (str1 == str5)); // true
        System.out.println("str3 == str4: " + (str3 == str4)); // false
        System.out.println("str3 == str5: " + (str3 == str5)); // false
        System.out.println("str1.equals(str2): " + str1.equals(str2)); // true
        System.out.println("str1.equals(str3): " + str1.equals(str3)); // true

        String intern = str3.intern();

        System.out.println("str1 == intern: " + (str1 == intern)); // true
        System.out.println("str3 == intern: " + (str3 == intern)); // false
    }
}
