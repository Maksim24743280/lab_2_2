package ru.university.lab2.numbers;

public class Task2 {

    public void run() {
        subtask1();
        subtask2();
        subtask3();
        subtask4();
        subtask5();
        subtask6();
    }

    // 1. 0.1 + 0.2 != 0.3
    private void subtask1() {
        System.out.println("=== Подзадача 1: 0.1 + 0.2 ===");
        double result = 0.1 + 0.2;
        System.out.println("0.1 + 0.2 = " + result);
        System.out.println("0.1 + 0.2 == 0.3? " + (result == 0.3));
        // Объяснение: 0.1 и 0.2 не могут быть точно представлены в двоичной системе (IEEE 754).
        // 0.1 в двоичной = 0.0001100110011... (бесконечная периодическая дробь),
        // поэтому при сложении накапливается ошибка округления.
        // Результат: 0.30000000000000004 вместо 0.3
        System.out.println();
    }

    // 2. Цикл: 10 раз прибавляем 0.1
    private void subtask2() {
        System.out.println("=== Подзадача 2: Накопление ошибки ===");
        double sum = 0.0;
        for (int i = 1; i <= 10; i++) {
            sum += 0.1;
            System.out.println("Шаг " + i + ": sum = " + sum);
        }
        // Ожидаем 1.0, но получаем 0.9999999999999999 из-за накопления ошибки округления
        System.out.println("Ожидалось 1.0, получено: " + sum);
        System.out.println();
    }

    // 3. Сравнение double с заданной точностью (epsilon)
    private void subtask3() {
        System.out.println("=== Подзадача 3: Сравнение с epsilon ===");
        double a = 0.1 + 0.2;
        double b = 0.3;
        double epsilon = 1e-9;

        System.out.println("a = " + a);
        System.out.println("b = " + b);
        System.out.println("a == b (прямое сравнение): " + (a == b));
        System.out.println("|a - b| < epsilon: " + (Math.abs(a - b) < epsilon));
        // Короткое замыкание: если |a-b| < epsilon, считаем числа равными
        // Это стандартный способ сравнения чисел с плавающей точкой
        System.out.println();
    }

    // 4. Infinity, -Infinity, NaN
    private void subtask4() {
        System.out.println("=== Подзадача 4: Special values ===");
        double inf = 1.0 / 0.0;
        double negInf = -1.0 / 0.0;
        double nan = 0.0 / 0.0;

        System.out.println("1.0 / 0.0 = " + inf);          // Infinity
        System.out.println("-1.0 / 0.0 = " + negInf);      // -Infinity
        System.out.println("0.0 / 0.0 = " + nan);          // NaN

        // NaN != NaN — это особенность IEEE 754
        System.out.println("NaN == NaN? " + (nan == nan));  // false!
        // Для проверки NaN нужно использовать Double.isNaN()
        System.out.println("Double.isNaN(nan)? " + Double.isNaN(nan)); // true

        // Арифметика с Infinity
        System.out.println("Infinity + 1 = " + (inf + 1));       // Infinity
        System.out.println("Infinity - Infinity = " + (inf + negInf)); // NaN
        System.out.println();
    }

    // 5. Math.floor, Math.round, Math.ceil
    private void subtask5() {
        System.out.println("=== Подзадача 5: Округление ===");
        System.out.println("Math.floor(2.7)  = " + Math.floor(2.7));   // 2.0
        System.out.println("Math.round(2.7)  = " + Math.round(2.7));   // 3
        System.out.println("Math.floor(-2.7) = " + Math.floor(-2.7));  // -3.0 (округление вниз, к -∞)
        System.out.println("Math.ceil(2.7)   = " + Math.ceil(2.7));    // 3.0
        System.out.println("Math.ceil(-2.7)  = " + Math.ceil(-2.7));   // -2.0 (округление вверх, к +∞)
        System.out.println("Math.round(-2.7) = " + Math.round(-2.7));  // -3
        // floor() округляет к меньшему (к -∞), ceil() — к большему (к +∞)
        // round() — к ближайшему целому ( halfway rounding up)
        System.out.println();
    }

    // 6. Сравнение float и double
    private void subtask6() {
        System.out.println("=== Подзадача 6: float vs double ===");
        float f = 0.1f;
        double d = 0.1;

        System.out.println("float 0.1f  = " + f);
        System.out.println("double 0.1  = " + d);
        System.out.println("0.1f == 0.1? " + (f == d)); // false — разная точность

        float fSum = 0.0f;
        double dSum = 0.0;
        for (int i = 0; i < 10; i++) {
            fSum += 0.1f;
            dSum += 0.1;
        }
        System.out.println("float  sum 10*0.1 = " + fSum);   // 1.0000001 (больше ошибка)
        System.out.println("double sum 10*0.1 = " + dSum);   // 0.9999999999999999
        // float имеет ~7 значащих цифр, double — ~15-16
        // double точнее, но занимает больше памяти (8 байт vs 4 байта)
        System.out.println();
    }
}