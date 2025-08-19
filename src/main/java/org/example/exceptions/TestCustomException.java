package org.example.exceptions;

public class TestCustomException  {
    public static void main(String[] args) {
        try {
            checkAge(15);
        } catch (MyCustomException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
    }

    static void checkAge(int age) throws MyCustomException {
        if (age < 18) {
            throw new MyCustomException("Возраст меньше 18!");
        }
    }
}
