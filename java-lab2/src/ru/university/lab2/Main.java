package ru.university.lab2;

import ru.university.lab2.numbers.Task1;
import ru.university.lab2.numbers.Task2;
import ru.university.lab2.numbers.Task3;
import ru.university.lab2.numbers.Task7;
import ru.university.lab2.strings.Task4;
import ru.university.lab2.strings.Task8;
import ru.university.lab2.arrays.Task5;
import ru.university.lab2.arrays.Task6;

public class Main {

    public static void main(String[] args) {
        Task8 menu = new Task8();
        menu.run();
    }

    // Метод run() только вызывает методы по порядку — без вычислительной логики
    public static void runAll() {
        new Task1().run();
        new Task2().run();
        new Task3().run();
        new Task4().run();
        new Task5().run();
        new Task6().run();
        new Task7().run();
    }
}