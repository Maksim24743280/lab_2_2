package ru.university.lab2.strings;

import ru.university.lab2.numbers.Task1;
import ru.university.lab2.numbers.Task2;
import ru.university.lab2.numbers.Task3;
import ru.university.lab2.numbers.Task7;
import ru.university.lab2.arrays.Task5;
import ru.university.lab2.arrays.Task6;

import java.util.Scanner;

public class Task8 {

    // Текстовый блок с меню (Java 15+)
    private static final String MENU_TEXT = """
            ╔══════════════════════════════════════╗
                   ЛАБОРАТОРНАЯ РАБОТА №2         ║
            ╠══════════════════════════════════════╣
            ║  1. Целочисленные ловушки            ║
            ║  2. Вещественная арифметика          ║
            ║  3. Побитовые операции               ║
            ║  4. Обработка текста                 ║
            ║  5. Одномерные массивы               ║
            ║  6. Многомерные массивы              ║
            ║  7. Методы и передача аргументов     ║
            ║  0. Выход                            ║
            ╚══════════════════════════════════════╝
            """;

    public void run() {
        Scanner scanner = new Scanner(System.in);
        String choice;

        System.out.println(MENU_TEXT);

        while (true) {
            System.out.print("Выберите задание (0-7): ");
            choice = scanner.nextLine().trim();

            switch (choice) {
                case "1" -> {
                    System.out.println("\n--- Задание 1: Целочисленные ловушки ---");
                    new Task1().run();
                }
                case "2" -> {
                    System.out.println("\n--- Задание 2: Вещественная арифметика ---");
                    new Task2().run();
                }
                case "3" -> {
                    System.out.println("\n--- Задание 3: Побитовые операции ---");
                    new Task3().run();
                }
                case "4" -> {
                    System.out.println("\n--- Задание 4: Обработка текста ---");
                    new Task4().run();
                }
                case "5" -> {
                    System.out.println("\n--- Задание 5: Одномерные массивы ---");
                    new Task5().run();
                }
                case "6" -> {
                    System.out.println("\n--- Задание 6: Многомерные массивы ---");
                    new Task6().run();
                }
                case "7" -> {
                    System.out.println("\n--- Задание 7: Методы и аргументы ---");
                    new Task7().run();
                }
                case "0" -> {
                    System.out.println("Выход из программы. До свидания!");
                    scanner.close();
                    return;
                }
                default -> {
                    System.out.println("Неверный ввод. Пожалуйста, выберите число от 0 до 7.");
                    // Программа не падает, цикл продолжается
                }
            }
            System.out.println();
        }
    }
}