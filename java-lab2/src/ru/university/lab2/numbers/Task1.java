package ru.university.lab2.numbers;

public class Task1 {

    public void run() {
        subtask1();
        subtask2();
        subtask3();
        subtask4();
        subtask5();
        subtask6();
        subtask7();
    }

    // 1. Диапазоны целочисленных типов
    private void subtask1() {
        System.out.println("=== Подзадача 1: Диапазоны целочисленных типов ===");
        // byte: 8 бит, диапазон от -128 до 127
        System.out.println("byte:   min = " + Byte.MIN_VALUE + ", max = " + Byte.MAX_VALUE);
        // short: 16 бит, диапазон от -32768 до 32767
        System.out.println("short:  min = " + Short.MIN_VALUE + ", max = " + Short.MAX_VALUE);
        // int: 32 бита, диапазон от -2147483648 до 2147483647
        System.out.println("int:    min = " + Integer.MIN_VALUE + ", max = " + Integer.MAX_VALUE);
        // long: 64 бита, диапазон от -9223372036854775808 до 9223372036854775807
        System.out.println("long:   min = " + Long.MIN_VALUE + ", max = " + Long.MAX_VALUE);
        System.out.println();
    }

    // 2. Вывод Integer.MAX_VALUE
    private void subtask2() {
        System.out.println("=== Подзадача 2: Integer.MAX_VALUE ===");
        int maxVal = Integer.MAX_VALUE;
        System.out.println("Integer.MAX_VALUE = " + maxVal);
        // Результат: 2147483647 — максимальное значение 32-битного знакового целого
        System.out.println();
    }

    // 3. Integer.MAX_VALUE + 2 в int и long
    private void subtask3() {
        System.out.println("=== Подзадача 3: Переполнение int ===");
        int maxVal = Integer.MAX_VALUE;

        // В int: происходит переполнение (overflow), результат отрицательный
        int resultInt = maxVal + 2;
        System.out.println("int:   Integer.MAX_VALUE + 2 = " + resultInt);
        // Объяснение: 2147483647 + 2 = 2147483649, но int вмещает только до 2147483647.
        // Биты переполняются: 0x7FFFFFFF + 2 = 0x80000001 = -2147483647

        // В long: переполнения нет, результат корректный
        long resultLong = (long) maxVal + 2;
        System.out.println("long:  Integer.MAX_VALUE + 2 = " + resultLong);
        // Объяснение: long имеет 64 бита, значение 2147483649 свободно помещается
        System.out.println();
    }

    // 4. Деление: 2 / -2 / 2 и -2 / 2
    private void subtask4() {
        System.out.println("=== Подзадача 4: Целочисленное деление ===");
        // 2 / -2 = -1 (целочисленное деление), затем -1 / 2 = 0 (округление к нулю)
        int r1 = 2 / -2 / 2;
        System.out.println("2 / -2 / 2 = " + r1);
        // Объяснение: 2/-2 = -1, затем -1/2 = 0 (Java округляет к нулю)

        // -2 / 2 = -1
        int r2 = -2 / 2;
        System.out.println("-2 / 2 = " + r2);
        // Объяснение: -2/2 = -1, точный результат
        System.out.println();
    }

    // 5. Что происходит при присваивании int к Integer.MAX_VALUE + int
    private void subtask5() {
        System.out.println("=== Подзадача 5: Переполнение при сложении ===");
        int a = Integer.MAX_VALUE;
        int b = 1;
        int sum = a + b;
        System.out.println("Integer.MAX_VALUE + 1 = " + sum);
        // Происходит переполнение: результат становится Integer.MIN_VALUE (-2147483648)
        // Это называется "wrap-around" — значение циклически переходит к минимуму
        System.out.println();
    }

    // 6. Арифметика через char: получить символ, показать код, выполнить арифметику
    private void subtask6() {
        System.out.println("=== Подзадача 6: Арифметика через char ===");
        char ch = 'A';
        int code = ch;
        System.out.println("Символ: '" + ch + "', его код (ASCII/Unicode): " + code);

        // Прибавляем 1 к коду символа
        char next = (char) (ch + 1);
        System.out.println("'" + ch + "' + 1 = '" + next + "' (код " + (int) next + ")");

        // Вычитаем
        char prev = (char) (ch - 1);
        System.out.println("'" + ch + "' - 1 = '" + prev + "' (код " + (int) prev + ")");

        // Умножаем код на 2
        int doubled = ch * 2;
        System.out.println("Код '" + ch + "' * 2 = " + doubled);
        System.out.println();
    }

    // 7. Метод проверки переполнения при сложении двух int (без Math.addExact)
    private void subtask7() {
        System.out.println("=== Подзадача 7: Проверка переполнения ===");
        int a1 = Integer.MAX_VALUE;
        int b1 = 1;
        System.out.println("a=" + a1 + ", b=" + b1 + " → переполнение: " + checkOverflow(a1, b1));
        // Ожидаемо: true (переполнение есть)

        int a2 = 100;
        int b2 = 200;
        System.out.println("a=" + a2 + ", b=" + b2 + " → переполнение: " + checkOverflow(a2, b2));
        // Ожидаемо: false (переполнения нет)

        int a3 = Integer.MIN_VALUE;
        int b3 = -1;
        System.out.println("a=" + a3 + ", b=" + b3 + " → переполнение: " + checkOverflow(a3, b3));
        // Ожидаемо: true (переполнение в отрицательную сторону)

        // Демонстрация на паре, которая переполняется, и на паре, которая нет
        demonstrateOverflow();
        System.out.println();
    }

    // Проверка переполнения при сложении двух int
    // Переполнение происходит если:
    // - оба положительных, а сумма отрицательная
    // - оба отрицательных, а сумма положительная
    private boolean checkOverflow(int a, int b) {
        int sum = a + b;
        if (a > 0 && b > 0 && sum < 0) return true;
        if (a < 0 && b < 0 && sum > 0) return true;
        return false;
    }

    private void demonstrateOverflow() {
        System.out.println("--- Демонстрация ---");
        // Пара с переполнением
        int x = Integer.MAX_VALUE;
        int y = 10;
        System.out.println(x + " + " + y + " = " + (x + y) + " (переполнение: " + checkOverflow(x, y) + ")");

        // Пара без переполнения
        int p = 1000;
        int q = 2000;
        System.out.println(p + " + " + q + " = " + (p + q) + " (переполнение: " + checkOverflow(p, q) + ")");
    }
}