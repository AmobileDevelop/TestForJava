package org.example.exceptions;

public class ExceptionDemo {
    public static void run() {
        try {
            int a = 5 / 0;
        } catch (ArithmeticException e) {
            System.out.println("Деление на ноль: " + e.getMessage());
        }
    }
}
