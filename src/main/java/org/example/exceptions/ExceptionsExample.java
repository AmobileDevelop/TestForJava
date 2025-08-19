package org.example.exceptions;

import java.util.Scanner;

public class ExceptionsExample {
    public static void main(String[] args) {

        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Введите число: ");
            int number = scanner.nextInt(); // Может выбросить InputMismatchException
            System.out.println("Вы ввели: " + number);
        } catch (Exception e) {
            System.out.println("Ошибка: вы ввели не число!");
        } finally {
            System.out.println("Программа завершает работу.");
            // Закрываем ресурс
        }
    }
}
