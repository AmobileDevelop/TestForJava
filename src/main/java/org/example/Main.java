package org.example;

import org.example.exceptions.ExceptionDemo;
import org.example.io.FileReaderUtil;
import org.example.io.FileWriterUtil;
import org.example.shapes.Circle;
import org.example.shapes.Rectangle;
import org.example.shapes.Shape;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static long factorialIterative(int n) {
        long result = 1;
        for (int i = 2; i <= n; i++) {
            result *= i;
        }
        return result;
    }

    // Факториал через рекурсию
    public static long factorialRecursive(int n) {
        if (n <= 1) return 1;
        return n * factorialRecursive(n - 1);
    }

    public static void main(String[] args) {
        System.out.println("Программа запущена");


        List<Shape> shapeList = List.of(
                new Rectangle(20.0, 15.0),
                new Circle(15.0),
                new Rectangle(17.0, 12.0)
        );

        shapeList.forEach(shape -> {
            System.out.println(shape.getClass().getSimpleName() +
                    " — площадь: " + shape.getArea() +
                    ", периметр: " + shape.getPerimeter());
        });



        /*Scanner scanner = new Scanner(System.in);

        System.out.print("Введите путь к  исходному файлу: ");
        String inputFile = scanner.nextLine();

        System.out.print("Введите путь к  конечному файлу: ");
        String outputFile = scanner.nextLine();

        //byteStreamResolver(inputFile, outputFile);
        nioReverseResolver(inputFile, outputFile);*/




        /*Scanner scanner = new Scanner(System.in);



        System.out.print("Выберите действие: 1 — читать файл, 2 — записать в файл: ");
        String choice = scanner.nextLine();

        if (choice.equals("1")) {
            String path = resolveFilePath(args);
            FileReaderUtil.readFile(path);
        } else if (choice.equals("2")) {
            System.out.print("Введите путь к файлу: ");
            String filePath = scanner.nextLine();
            System.out.println("Введите текст для записи:");
            String content = scanner.nextLine();
            FileWriterUtil.writeFile(filePath, content);
        } else {
            System.out.println("Неверный выбор.");
        }*/


        /*String filePath = resolveFilePath(args);
        FileReaderUtil.readFile(filePath);*/





        /*int number = 5;

        System.out.println("Факториал (цикл) числа " + number + " = " + factorialIterative(number));
        System.out.println("Факториал (рекурсия) числа " + number + " = " + factorialRecursive(number));

        try {
            // код, который может вызвать ошибку
            int result = 10 / 0;
        } catch (ArithmeticException e) {
            System.out.println("Ошибка: деление на ноль!");
        }*/
    }
    private static String resolveFilePath(String[] args) {
        if (args.length > 0) {
            System.out.println("Путь к файлу получен из аргументов: " + args[0]);
            return args[0];
        }

        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите путь к файлу: ");
        if (scanner.hasNextLine()) {
            return scanner.nextLine();
        }

        throw new IllegalStateException("Ввод не получен");
    }

    private static void byteStreamResolver(String input, String output) {
        try (FileInputStream fis = new FileInputStream(input);
             FileOutputStream fos = new FileOutputStream(output)) {

            byte[] buffer = new byte[1024]; // буфер на 1 Кб
            int bytesRead;
            while ((bytesRead = fis.read(buffer)) != -1) {
                fos.write(buffer, 0, bytesRead);
            }

            System.out.println("Файл успешно скопирован.");

        } catch (IOException e) {
            System.out.println("Ошибка при работе с файлами: " + e.getMessage());
        }
    }

    private static void nioReverseResolver(String input, String output) {
        Path inputPath = Paths.get(input);
        Path outputPath = Paths.get(output);

        try {
            List<String> lines = Files.readAllLines(inputPath);

            // Вывод с номерами строк
            for (int i = 0; i < lines.size(); i++) {
                System.out.println((i + 1) + ": " + lines.get(i));
            }

            // Обратный порядок
            Collections.reverse(lines);

            // Запись в output.txt
            Files.write(outputPath, lines);

            System.out.println("Данные записаны в output.txt в обратном порядке.");

        } catch (IOException e) {
            System.out.println("Ошибка работы с файлами: " + e.getMessage());
        }
    }




}

